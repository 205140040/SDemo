package http;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.net.ssl.SSLException;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
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
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * HttpClientUtils
 * 
 * @author 20514 2016年2月27日
 * @description
 */
public class HttpClientUtils {
	private static final String CHAR_SET = "UTF-8";
	// SOCKET_TIMEOUT
	private static final Integer SOCKET_TIMEOUT = 5000;
	// 连接超时时间
	private static final Integer CONNECT_TIMEOUT = 5000;
	// httpClient
	private static CloseableHttpClient httpClient;
	// 请求配置
	private static RequestConfig requestConfig;
	// logger
	private static Logger logger = Logger.getLogger(HttpClientUtils.class);

	/**
	 * 初始化httpClient连接池和requestConfig
	 */
	static {
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
		httpClient = HttpClients.custom().setConnectionManager(cm).setRetryHandler(myRequestRetryHandler).build();
		// 设置请求和传输超时时间
		requestConfig = RequestConfig.custom().setSocketTimeout(SOCKET_TIMEOUT).setConnectTimeout(CONNECT_TIMEOUT)
				.build();
	}

	/**
	 * 获取uri
	 * 
	 * @author 20514 2016年2月27日
	 * @description
	 * @param scheme
	 *            如:http或https
	 * @param host
	 *            主机名:如：localhost:8080
	 * @param path
	 *            请求路径:如：/WebDemo/HttpClientServlet
	 * @param params
	 *            List<NameValuePair> url?参数list
	 * @return
	 */
	public static URI getUri(String scheme, String host, String path, List<NameValuePair> params) {
		URI uri = null;
		try {
			if (params.isEmpty()) {
				uri = new URIBuilder().setScheme(scheme).setHost(host).setPath(path).build();
			} else {
				uri = new URIBuilder().setScheme(scheme).setHost(host).setPath(path).setParameters(params).build();
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return uri;
	}

	/**
	 * get请求
	 * 
	 * @author 20514 2016年2月27日
	 * @description
	 * @param uri
	 *            请求uri
	 * @return
	 */
	public static String get(URI uri) {
		String res = null;
		HttpGet httpGet = new HttpGet(uri);
		httpGet.setConfig(requestConfig);
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				res = EntityUtils.toString(response.getEntity(), CHAR_SET);
			} else {
				res = "响应状态码 = " + response.getStatusLine().getStatusCode();
				logger.info(res);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != response) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	/**
	 * post请求
	 * 
	 * @author 20514 2016年2月27日
	 * @description
	 * @param uri
	 * @param params
	 *            List<NameValuePair>请求参数
	 * @return
	 */
	public static String post(URI uri, List<NameValuePair> params) {
		String res = null;
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setConfig(requestConfig);
		if (!params.isEmpty()) {
			UrlEncodedFormEntity formEntity;
			try {
				formEntity = new UrlEncodedFormEntity(params, CHAR_SET);
				httpPost.setEntity(formEntity);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				res = EntityUtils.toString(response.getEntity(), CHAR_SET);
			} else {
				res = "响应状态码 = " + response.getStatusLine().getStatusCode();
				logger.info(res);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != response) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	/**
	 * post一个form实体对象请求
	 * 
	 * @author 20514 2016年2月27日
	 * @description
	 * @param uri
	 * @param t
	 *            form表单实体对象
	 * @return
	 */
	public static <T> String postBean(URI uri, T t) {
		String res = null;
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setConfig(requestConfig);
		List<NameValuePair> params = new ArrayList<>();
		if (null != t) {
			JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(t));
			if (null != jsonObject.entrySet() && !jsonObject.entrySet().isEmpty()) {
				for (Entry<String, Object> entry : jsonObject.entrySet()) {
					params.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
				}
			}
		}
		if (!params.isEmpty()) {
			UrlEncodedFormEntity formEntity;
			try {
				formEntity = new UrlEncodedFormEntity(params, CHAR_SET);
				httpPost.setEntity(formEntity);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				res = EntityUtils.toString(response.getEntity(), CHAR_SET);
			} else {
				res = "响应状态码 = " + response.getStatusLine().getStatusCode();
				logger.info(res);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != response) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return res;
	}

	/**
	 * postMultipartFile请求 ,上传文件
	 * 
	 * @author 20514 2016年2月27日
	 * @description
	 * @param uri
	 * @param params
	 *            List<NameValuePair>请求参数
	 * @return
	 * @throws IOException
	 */
	public static String postMultipartFile(URI uri, MultipartFile multipartFile) {
		String res = null;
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setConfig(requestConfig);
		if (!multipartFile.isEmpty()) {
			HttpEntity httpEntity;
			try {
				ContentBody contentBody = new ByteArrayBody(multipartFile.getBytes(),
						multipartFile.getOriginalFilename());
				httpEntity = MultipartEntityBuilder.create().addPart("file", contentBody).build();
				httpPost.setEntity(httpEntity);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				res = EntityUtils.toString(response.getEntity(), CHAR_SET);
			} else {
				res = "响应状态码 = " + response.getStatusLine().getStatusCode();
				logger.info(res);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != response) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return res;
	}

	public static void main(String[] args) throws URISyntaxException, UnsupportedEncodingException {
		List<NameValuePair> params = new ArrayList<>();
		// params.add(new BasicNameValuePair("sname", "mengmeng"));
		URI uri = getUri("http", "localhost:8080", "/WebDemo/HttpClientServlet", params);
		// System.out.println(uri);
		// String res = HttpClientUtils.get(uri);
		// System.out.println(res);

		List<NameValuePair> postParams = new ArrayList<>();
		// postParams.add(new BasicNameValuePair("sname", "小馒头"));
		// String postres = post(uri, postParams);
		// System.out.println("postRes:" + postres);

		Student student = new Student("提百万2", "提莫", 19);
		System.out.println(JSON.toJSONString(postParams));
		String postres = postBean(uri, student);
		System.out.println("postRes:" + postres);
	}

}
