package c001;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mytags.Student;

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
		ServletContext context=getServletContext();
		context.setAttribute("username", username);
		List<Student> sList=new ArrayList<>();
		sList.add(new Student("张三",18,"男"));
		sList.add(new Student("李四",18,"女"));
		sList.add(new Student("酱紫",19,"女"));
		context.setAttribute("sList", sList);
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
