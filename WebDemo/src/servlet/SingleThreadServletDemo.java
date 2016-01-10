package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author 20514 2016年1月10日 @description通过实现SingleThreadModel，
 *         解决一个servlet默认情况下使用多线程调用同一个service
 */
public class SingleThreadServletDemo extends HttpServlet implements SingleThreadModel {
	/**
	 * @author 20514 2016年1月10日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
	}
}
