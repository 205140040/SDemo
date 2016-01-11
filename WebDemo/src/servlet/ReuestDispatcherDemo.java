package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReuestDispatcherDemo extends HttpServlet {
	/**
	 * @author 20514 2016年1月11日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		out.println("include");
		// RequestDispatcher include方法包含其它servlet
		// RequestDispatcher dispatcher =
		// req.getRequestDispatcher("/index.jsp");
		// dispatcher.include(req, res);
		// RequestDispatcher dispatcher=req.getRequestDispatcher("/servlet1");
		// //跳转到servlet1
		// dispatcher.forward(req, res);
		// 重定向
//		res.sendRedirect("http://www.baidu.com");
		out.close();
	}
}
