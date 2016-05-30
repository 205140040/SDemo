package com.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.demo.annotation.NotNeedLogin;
import com.demo.bean.User;
import com.demo.bean.staticbean.UserStatic;
import com.demo.utils.EmptyUtil;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 登录权限校验
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HandlerMethod method = (HandlerMethod) handler;
		NotNeedLogin notNeedLogin = method.getMethodAnnotation(NotNeedLogin.class);
		if (EmptyUtil.isNotEmpty(notNeedLogin) && notNeedLogin.value()) {
			// 不需要权限
			return super.preHandle(request, response, handler);
		} else {
			User user = (User) request.getSession().getAttribute(UserStatic.USER_CONTEXT);
			if (EmptyUtil.isEmpty(user)) {
				//重定向到登录
				response.sendRedirect("/login/toLogin");
				return false;
			}
			return super.preHandle(request, response, handler);
		}

	}
}
