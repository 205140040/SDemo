package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class ClassLoaderDemo extends HttpServlet {

	/**
	 * @author 20514
	 * 2016年1月10日
	 * @description 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("类装载器名称："+this.getClass().getClassLoader().getClass().getName());
		super.service(arg0, arg1);
	}
}
