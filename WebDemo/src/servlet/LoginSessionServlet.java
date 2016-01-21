package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginSessionServlet extends HttpServlet {
	/**
	 * @author 20514 2016年1月21日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 解决中文参数乱码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		// 不存在则创建一个session,存在直接获取该session
		HttpSession session = request.getSession();
		String uname = request.getParameter("uanme");
		String upwd = request.getParameter("upwd");
		if (null == session.getAttribute("uname")) {
			session.setAttribute("uname", uname);
			session.setAttribute("upwd", upwd);
		}

		PrintWriter out = response.getWriter();
		out.println("sessionID" + session.getId() + "<br>");

		out.println("sessionInfo创建时间" + new Date(session.getCreationTime()).toLocaleString() + "<br>");
		out.println("session更改时间" + new Date(session.getLastAccessedTime()).toLocaleString() + "<br>");

		out.println("isNew是否是新建的" + session.isNew() + "<br>");

		if ("jz123".equals(session.getAttribute("upwd"))) {
			// 登录成功
			out.println("登录成功:<br><a href=\"/WebDemo/LogoutServlet\">退出</a>");
		} else {
			out.println("密码错误");
		}
		out.close();
	}

}
