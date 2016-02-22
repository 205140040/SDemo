package http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

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
			httpResponse.close();
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
				}else{
					return EntityUtils.toByteArray(entity);
				}
			}
		};
		byte[] res = httpClient.execute(httpGet, handler);
		try {
			OutputStream outputStream=new ByteArrayOutputStream();
			outputStream.write(res, 0, 1024);
			PrintWriter pWriter=new PrintWriter(outputStream);
			pWriter.print(res);
			System.out.println("响应类容：" );
		} finally {
		}
	}

	public static void main(String[] args) throws URISyntaxException, Exception {
		simpleExample();
		System.out.println("----------httpGet");
		doGet();
		System.out.println("----------PostForm");
		postForm();
		System.out.println("----------httpHandler");
		httpHandler();
	}

}
