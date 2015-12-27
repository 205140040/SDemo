package c001;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String pwd;

	@Override
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		username = config.getInitParameter("username");
		pwd = config.getInitParameter("pwd");
		System.out.println("name:" + username + "\tpwd:" + pwd);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		ServletContext context=req.getServletContext();
		PrintWriter out = resp.getWriter();
		out.println("this is init servlet<br>");
		out.println("name:" + username + "\tpwd:" + pwd);
		out.println("<br>上下文参数:name:" + context.getInitParameter("username"));
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
