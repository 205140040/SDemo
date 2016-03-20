package com.demo.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * tokenAop方法拦截器,通知类
 * 
 * @author 20514 2016年3月20日
 * @description
 */
public class TokenInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object res = null;
		Method method = invocation.getMethod();
		CheckToken checkToken = method.getAnnotation(CheckToken.class);
		if (null == checkToken) {
			// 继续运行
			return invocation.proceed();
		}
		if (checkToken.value() == false) {
			// 继续运行
			return invocation.proceed();
		}
		Object[] args = invocation.getArguments();
		if (null != args && args.length > 0) {
			String userName = (String) args[0];
			if ("admin".equals(userName)) {
				// 继续运行
				res = (Object) invocation.proceed();
			} else {
				res = (Object) "信息校验失败";
			}
		} else {
			res = "check not pass hahhha";
		}
		return res;
	}

}
