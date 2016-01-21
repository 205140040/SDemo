package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {
	/**
	 * @author 20514 2016年1月18日
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

		/**
		 * cookie
		 */
		// 创建cookie
		Cookie cookie = new Cookie("uname", URLEncoder.encode("酱紫啊", "UTF-8"));
		// 注释
		cookie.setComment(URLEncoder.encode("注释：userInfo", "UTF-8"));
		// 使用域
		cookie.setDomain(request.getLocalName());
		// 有效时常1小时，3600秒
		cookie.setMaxAge(3600);
		// 可以使用的ulr路径
		cookie.setPath("/");
		// 设置版本
		cookie.setVersion(1);
		// 将cookie添加到响应信息中
		response.addCookie(cookie);
		// 输出cookie信息

		PrintWriter out = response.getWriter();
		out.println("cookieHeader:" + request.getHeader("Cookie") + "<br>");
		out.println("cookieName:" + cookie.getName() + "<br>");
		out.println("cookieValue:" + URLDecoder.decode(cookie.getValue(), "UTF-8") + "<br>");
		out.println("作用域名:" + cookie.getDomain() + "<br>");
		out.println("注释:" + URLDecoder.decode(cookie.getComment(), "UTF-8") + "<br>");
		out.println("有效路径:" + cookie.getPath() + "<br>");
		out.println("版本:" + cookie.getVersion() + "<br>");
		out.println("有效时间:" + cookie.getMaxAge() + "秒<br>");
		out.close();
		// 重定向到cokieservlet2
		// RequestDispatcher dispatcher =
		// request.getRequestDispatcher("/WebDemo/CookieServlet2");
		// dispatcher.forward(request, response);
	}

}
