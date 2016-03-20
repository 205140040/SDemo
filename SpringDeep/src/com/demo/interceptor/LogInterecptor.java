package com.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 日志拦截器
 * 
 * @author 20514 2016年3月16日
 * @description
 */
public class LogInterecptor extends HandlerInterceptorAdapter {

	/**
	 * 处理完毕后方法
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("---------处理完毕-----------");
	}

	/**
	 * 返回modelandview后回调方法
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("---------后处理回调方法-----------");
	}

	/**
	 * 预处理回调方法，实现处理器的预处理（如登录检查） ，第三个参数为响应的处理器（如我们上一章的Controller实现）；
	 * 返回值：true表示继续流程（如调用下一个拦截器或处理器）； false表示流程中断（如登录检查失败）， 不会继续调用其他的拦截器或处理器，
	 * 此时我们需要通过response来产生响应；
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		System.out.println("-----预处理：拦截器开始:");
		res.setCharacterEncoding("UTF-8");
		return true;
	}

}
