package http;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLException;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

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
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return res;
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
	 *            List<NameValuePair> 参数list
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

	public static void main(String[] args) throws URISyntaxException, UnsupportedEncodingException {
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("sname", "mengmeng"));
		URI uri = getUri("http", "localhost:8080", "/WebDemo/HttpClientServlet", params);
		System.out.println(uri);
		String res = HttpClientUtils.get(uri);
		System.out.println(res);
	}

}
