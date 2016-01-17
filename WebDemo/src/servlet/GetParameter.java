package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.CharacterEncodingFilter;

public class GetParameter extends HttpServlet {
	/**
	 * @author 20514 2016年1月17日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求参数
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		// get请求编码
		System.out.println("reqEncoding" + request.getCharacterEncoding());
		// 设置请求编码，解决中午url解码
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		System.out.println("name:" + URLDecoder.decode(name, "UTF-8"));
		PrintWriter out = response.getWriter();
		out.println("name" + URLDecoder.decode(name, "UTF-8") + "<br>");
		// 获取所有请求的参数名
		Enumeration<String> pnames = request.getParameterNames();
		out.println("获取所有请求的参数名" + "<br>");

		while (pnames.hasMoreElements()) {
			out.println(pnames.nextElement() + "<br>");
		}
		// 获取请求参数map，参数名称和值
		out.println("获取请求参数map，参数名称和值" + "<br>");
		Map<String, String[]> maps = request.getParameterMap();
		for (Entry<String, String[]> entry : maps.entrySet()) {
			out.println("name:" + entry.getKey() + "\t\tvalue:" + entry.getValue()[0] + "<br>");
			System.out.println("name:" + entry.getKey() + "\t\tvalue:" + entry.getValue()[0] + "<br>");
		}
		out.println("通过输入流读取参数:" + "<br>");
		BufferedReader reader = request.getReader();
		out.println("通过输入流读取参数:" + reader.readLine() + "<br>");

		out.close();
	}
}
