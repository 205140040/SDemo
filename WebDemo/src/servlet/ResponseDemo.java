package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo extends HttpServlet {
	/**
	 * @author 20514 2016年1月10日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * response对象设置响应
	 */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// super.service(req, res);
		HttpServletResponse response = (HttpServletResponse) res;
		// 设置响应类容为图片
		// response.setContentType("img/*");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		System.out.println("servletName:" + getServletName());
		// 状态码常量,404 设置http响应消息的状态码
		// response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		// response.sendError(HttpServletResponse.SC_NOT_FOUND, "找不到页面");
		// setHeader
		// response.setHeader("Content-Language", "zh-cn");
		// response.setDateHeader("Date", (new Date(1995, 9, 15).getTime()));
		// response.setLocale(new Locale("zh", "CN"));
		// 设置浏览器定时刷新网页，或者跳转
		// response.setHeader("Refresh", "5");
		// response.setHeader("Refresh", "5;url=http://www.baidu.com");
		PrintWriter out = response.getWriter();
		// out.println("5秒后刷新" + new Date().toLocaleString());
		// out.println("5秒后刷新,并跳转" + new Date().toLocaleString());
		// 禁用缓存
		// response.setDateHeader("Expires", 0);
		// response.setHeader("Cache-Control", "no-cache");
		// response.setHeader("Pragma", "no-cache");
		// 2.在服务器的动态网页中禁止缓存，要加入类似如下脚本
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -1);
		out.println("生成随机数：" + Math.random());
		out.println("<form action=\"NotServlet\" method=\"post\">"
				+ "参数1:<input type=\"text\" name=\"p1\" value=\"666\" /><br>"
				+ "<input type=\"submit\" value=\"提交\"/></form>");
		out.close();
	}
}
