package http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLException;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

public class HttpClientTwo {
	/**
	 * 简单demo
	 * 
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static void simpleExample() throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://localhost:8080/WebDemo/HttpClientServlet");
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		try {
			// 输出响应
			System.out.println(EntityUtils.toString(httpResponse.getEntity()));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭response
			httpResponse.close();
		}
	}

	/**
	 * doGet
	 * 
	 * @author 20514 2016年2月22日
	 * @description
	 * @param args
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static void doGet() throws URISyntaxException, Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		URI uri = new URIBuilder().setScheme("http").setHost("localhost:8080").setPath("/WebDemo/HttpClientServlet")
				.setParameter("sname", "萌萌哒酱紫").build();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		try {
			System.out.println("响应类容：" + EntityUtils.toString(httpResponse.getEntity()));
		} finally {
			httpResponse.close();
		}

	}

	/**
	 * 提交form表单
	 * 
	 * @author 20514 2016年2月22日
	 * @description
	 * @throws Exception
	 */
	public static void postForm() throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		URI uri = new URIBuilder().setScheme("http").setHost("localhost:8080").setPath("/WebDemo/HttpClientServlet")
				.build();
		HttpPost httpPost = new HttpPost(uri);
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("sname", "张三三"));
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, Consts.UTF_8);
		httpPost.setEntity(formEntity);

		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		try {
			System.out.println("响应类容：" + EntityUtils.toString(httpResponse.getEntity()));
		} finally {
			// 关闭response
			httpResponse.close();
			// 关闭httpclient
			httpClient.close();
		}
	}

	/**
	 * 获取uri
	 * 
	 * @author 20514 2016年2月22日
	 * @description
	 * @return
	 * @throws Exception
	 */
	public static URI getUri() throws Exception {
		return new URIBuilder().setScheme("http").setHost("localhost:8080").setPath("/WebDemo/HttpClientServlet")
				.build();
	}

	/**
	 * httpHandler自动释放连接
	 * 
	 * @author 20514 2016年2月22日
	 * @description
	 * @param args
	 * @throws URISyntaxException
	 * @throws Exception
	 */
	public static void httpHandler() throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(getUri());
		ResponseHandler<byte[]> handler = new ResponseHandler<byte[]>() {
			@Override
			public byte[] handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
				// 状态
				StatusLine statusLine = httpResponse.getStatusLine();
				HttpEntity entity = httpResponse.getEntity();
				if (statusLine.getStatusCode() >= 300) {
					throw new HttpResponseException(statusLine.getStatusCode(), statusLine.getReasonPhrase());
				}
				if (null == entity) {
					throw new ClientProtocolException("无响应类容");
				} else {
					return EntityUtils.toByteArray(entity);
				}
			}
		};
		byte[] res = httpClient.execute(httpGet, handler);
		try {
			OutputStream outputStream = new ByteArrayOutputStream();
			outputStream.write(res, 0, 1024);
			PrintWriter pWriter = new PrintWriter(outputStream);
			pWriter.print(res);
			System.out.println("响应类容：");
		} finally {
		}
	}

	/**
	 * 1.5.4。请求重试处理 为了使自定义异常回收机构 ​​应该提供的一个实现HttpRequestRetryHandler 接口。
	 * 
	 * @author 20514 2016年2月23日
	 * @throws Exception
	 * @description
	 */
	public static void doPostWithRetry() throws Exception {
		HttpRequestRetryHandler myRequestRetryHandler = new HttpRequestRetryHandler() {
			@Override
			public boolean retryRequest(IOException exception, int reqCount, HttpContext context) {
				if (5 <= reqCount) {
					// 不要重试，如​​果超过最大重试次数
					return false;
				}
				if (exception instanceof InterruptedIOException) {
					// timeout
					return false;
				}
				if (exception instanceof UnknownHostException) {
					// 未知主机
					return false;
				}
				if (exception instanceof ConnectTimeoutException) {
					//// 拒绝连接
					return false;
				}
				if (exception instanceof SSLException) {
					// SSL handshake exception
					return false;
				}
				HttpClientContext clientContext = HttpClientContext.adapt(context);
				HttpRequest request = clientContext.getRequest();
				boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
				if (idempotent) {
					// //重试，如果请求被认为是幂等
					return true;
				}
				return false;
			}
		};
		CloseableHttpClient httpClient = HttpClients.custom().setRetryHandler(myRequestRetryHandler).build();
		URI uri = getUri();
		List<BasicNameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("sname", "萌萌哒"));
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "UTF-8");
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setEntity(formEntity);
		CloseableHttpResponse response = httpClient.execute(httpPost);
		try {
			System.out.println("响应类容：" + EntityUtils.toString(response.getEntity()));
		} finally {
			response.close();
			httpClient.close();
		}
	}

	/**
	 * 池连接管理
	 * 
	 * @author 20514 2016年2月24日
	 * @throws Exception
	 * @description
	 */
	public static void poolingConnectionManager() throws Exception {
		HttpRequestRetryHandler myRequestRetryHandler = new HttpRequestRetryHandler() {
			@Override
			public boolean retryRequest(IOException exception, int reqCount, HttpContext context) {
				if (5 <= reqCount) {
					// 不要重试，如​​果超过最大重试次数
					return false;
				}
				if (exception instanceof InterruptedIOException) {
					// timeout
					return false;
				}
				if (exception instanceof UnknownHostException) {
					// 未知主机
					return false;
				}
				if (exception instanceof ConnectTimeoutException) {
					//// 拒绝连接
					return false;
				}
				if (exception instanceof SSLException) {
					// SSL handshake exception
					return false;
				}
				HttpClientContext clientContext = HttpClientContext.adapt(context);
				HttpRequest request = clientContext.getRequest();
				boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
				if (idempotent) {
					// //重试，如果请求被认为是幂等
					return true;
				}
				return false;
			}
		};

		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		// 最大连接数
		cm.setMaxTotal(200);
		// 每条路线//增加默认最大连接20
		cm.setDefaultMaxPerRoute(20);
		HttpHost localhost = new HttpHost("localhost", 80);
		cm.setMaxPerRoute(new HttpRoute(localhost), 50);
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm)
				.setRetryHandler(myRequestRetryHandler).build();

		URI uri = getUri();
		List<BasicNameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("sname", "萌萌哒"));
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "UTF-8");
		HttpPost httpPost = new HttpPost(uri);
		// 设定超时时间
		// 设置连接时间
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();// 设置请求和传输超时时间
		httpPost.setConfig(requestConfig);
		httpPost.setEntity(formEntity);
		CloseableHttpResponse response = httpClient.execute(httpPost);
		try {
			System.out.println("响应类容：" + EntityUtils.toString(response.getEntity()));
		} finally {
			response.close();
		}
	}

	public static void main(String[] args) throws URISyntaxException, Exception {
		// simpleExample();
		// System.out.println("----------httpGet");
		// doGet();
		// System.out.println("----------PostForm");
		// postForm();
		// System.out.println("----------httpHandler");
		// // httpHandler();
		// System.out.println("----------httpHandler");
		// doPostWithRetry();
		System.out.println("----------池连接管理");
		poolingConnectionManager();
	}

	public static MultipartEntityBuilder createMultipartEntityBuilderByMultipartFile(MultipartFile file)
			throws IOException {
		MultipartEntityBuilder multipartEntity = null;
		try {

			Assert.notNull(file);
			multipartEntity = MultipartEntityBuilder.create();
			// input = file.getInputStream();
			// file.getBytes();

			String filename = file.getOriginalFilename();
			// multipartEntity.addPart("files", new InputStreamBody(input,
			// filename));
			// new FileBody(file,ContentType.APPLICATION_JSON,filename);
			multipartEntity.addPart("files", new ByteArrayBody(file.getBytes(), filename));
		} catch (IOException e) {
			throw e;
		}
		return multipartEntity;

	}

}
