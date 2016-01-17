package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * httpservletrequest使用
 * 
 * @author 20514 2016年1月13日
 * @description
 */
public class RequestDemo extends HttpServlet {
	/**
	 * @author 20514 2016年1月13日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置响应字符
		response.setCharacterEncoding("UTF-8");
		// 设置响应格式
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// 获取请求方式
		String reqMethod = request.getMethod();
		out.println("请求方式：" + reqMethod + "<br>");
		// 获取请求路径的uri
		out.println("reqUri:" + request.getRequestURI() + "<br>");
		out.println("reqUrl:" + request.getRequestURL() + "<br>");
		// 获取问号后面的参数
		out.println("queryString:" + request.getQueryString() + "<br>");
		// 获取http协议版本
		out.println("httpVersion:" + request.getProtocol() + "<br>");
		// 获取请求url在webcontent中的目录
		out.println("getContextPath:" + request.getContextPath() + "<br>");
		out.println("getServletPath:" + request.getServletPath() + "<br>");
		// 获取网络连接信息
		// 请求的客户机ip地址
		out.println("请求的客户机ip地址:" + request.getRemoteAddr() + "<br>");
		// 获取请求的客户机主机名称，无法解析则返回ip
		out.println("请求的客户机主机名称:" + request.getRemoteHost() + "<br>");
		// 获取请求客户机的网络端口
		out.println("请求的客户机网络端口:" + request.getRemotePort() + "<br>");
		// 返回web服务器ip
		out.println("web服务器ip地址:" + request.getLocalAddr() + "<br>");
		out.println("web服务器主机名:" + request.getLocalName() + "<br>");
		out.println("web服务器接受端口:" + request.getLocalPort() + "<br>");
		// 获取当前请求的主机名
		out.println("当前请求的主机名:" + request.getServerName() + "<br>");
		out.println("当前请求的主机端口号:" + request.getServerPort() + "<br>");
		// 请求的协议名，http，https,ftp
		out.println("请求的协议名，http，https,ftp----:" + request.getScheme() + "<br>");
		// 获取请求头信息
		out.println("header请求头方法:Accept-Language:" + request.getHeader("Accept-Language") + "<br>");

		Enumeration<String> allHeaders = request.getHeaderNames();
		while (allHeaders.hasMoreElements()) {
			out.println(allHeaders.nextElement() + request.getHeader(allHeaders.nextElement()) + "<br>");
		}
		out.println("contentType" + request.getContentType() + "<br>");
		out.println("请求页面referer:" + request.getHeader("referer") + "<br>");
		// 关闭输出流
		out.close();
	}
}
