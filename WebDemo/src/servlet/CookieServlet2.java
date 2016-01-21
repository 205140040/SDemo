package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet2 extends HttpServlet {
	/**
	 * @author 20514 2016年1月21日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解决请求参数url编码格式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		// 输出上一个servlet中保存的cookie
		// 输出cookie信息

		PrintWriter out = response.getWriter();
		out.println("cookieHeader:" + request.getHeader("Cookie") + "<br>");
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			out.println("cookieName:" + cookie.getName() + "<br>");
			out.println("cookieValue:" + URLDecoder.decode(cookie.getValue(), "UTF-8") + "<br>");
			// out.println("作用域名:" + cookie.getDomain() + "<br>");
			// out.println("注释:" + URLDecoder.decode(cookie.getComment()) +
			// "<br>");
			// out.println("有效路径:" + cookie.getPath() + "<br>");
			// out.println("版本:" + cookie.getVersion() + "<br>");
			// out.println("有效时间:" + cookie.getMaxAge() + "秒<br>");
		}
		out.close();
	}

}
