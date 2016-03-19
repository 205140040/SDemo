package com.demo.login.interecptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.demo.login.annation.NeedLogin;

/**
 * 登录拦截器
 * 
 * @author 20514 2016年3月19日
 * @description
 */
public class LoginInterecptor extends HandlerInterceptorAdapter {
	/**
	 * 方法前拦截器
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// handler
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		// 得到是否需要登录的注解
		NeedLogin needLogin = handlerMethod.getMethodAnnotation(NeedLogin.class);
		if (null != needLogin && needLogin.value() == false) {
			// 执行拦截器后面的方法
			return true;
		}
		// 拦截所有的请求，没登录提示登录(除了标注注解needlogin的为false的方法)
		HttpSession session = request.getSession();
		String sessionUserName = (String) session.getAttribute("userName");
		if (null == sessionUserName) {
			response.sendRedirect("/SpringDeep/login/toLoginPage");
			return false;
		} else {
			return true;
		}
	}
}
