package c001;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		Integer a = null;
		Integer b = 2;
		// System.out.println(a / b);
		out.println("this is servlet1");

		out.println("this is modife");
		/**
		 * servletconfig方法使用
		 */
		Enumeration<String> e = getServletConfig().getInitParameterNames();
		// System.out.println(e.nextElement());
		System.out.println("servletName:" + getServletName());
		ServletContext context = getServletContext();
		System.out.println("contextPath:" + context.getRealPath("/"));
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	/**
	 * 修改是否修改的缓存标识
	 */
	@Override
	protected long getLastModified(HttpServletRequest req) {
		return 31507200;
		// return super.getLastModified(req);
	}
}
