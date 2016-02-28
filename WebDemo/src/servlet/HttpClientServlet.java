package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/HttpClientServlet")
public class HttpClientServlet extends HttpServlet {
	/**
	 * @author 20514 2016年2月21日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("这是httpclientResponse");
		String sname = request.getParameter("sname");
		if (null != sname) {
			System.out.println("sname:"+sname);
			out.println("sname:" + sname);
		}
		out.close();
	}
}
