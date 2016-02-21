package http;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientDemo {
	public static void main(String[] args) {
		HttpClientDemo.get();
	}

	public static void get() {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet("http://localhost:8080/WebDemo/HttpClientServlet");
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			System.out.println("uri:" + httpGet.getURI());
			System.out.println("httpEntityContent:" + EntityUtils.toString(httpEntity));

			// httpreponse
			System.out.println("协议版本:" + httpResponse.getProtocolVersion());
			System.out.println("状态：" + httpResponse.getStatusLine().toString());
			// http实体
			StringEntity stringEntity = new StringEntity("这是httpString实体类容", "UTF-8");
			System.out.println("contentType:" + stringEntity.getContentType());
			System.out.println("length:" + stringEntity.getContentLength());
			System.out.println("charSet:" + EntityUtils.getContentCharSet(stringEntity));
			System.out.println("类容：" + EntityUtils.toString(stringEntity));

			System.out.println("----------httpPost提交form参数entity------------------------");

			HttpPost httpPost = new HttpPost("http://localhost:8080/WebDemo/HttpClientServlet");
			FileEntity fileEntity = new FileEntity(new File("C://Users//20514//Desktop//hc.png"));
			// httpPost.setEntity(fileEntity);
			// httpClient.execute(httpPost);
			// System.out.println(httpPost.getEntity());
			// 提交html表单
			List<BasicNameValuePair> formParams = new ArrayList<>();
			formParams.add(new BasicNameValuePair("sname", "小明"));
			formParams.add(new BasicNameValuePair("ssex", "nv"));
			UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(formParams, "UTF-8");
			httpPost.setEntity(formEntity);
			HttpResponse postRes = httpClient.execute(httpPost);
			System.out.println("响应：" + EntityUtils.toString(postRes.getEntity()));

			if (null != httpEntity) {
				InputStream in = httpEntity.getContent();
				int l;
				byte[] temp = new byte[1024];
				// while ((l = in.read(temp)) != 0) {
				// System.out.println((char) l);
				// }
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
