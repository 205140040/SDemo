package com.demo.annotation;

/**
 * 不需要登录
 * 
 * @author admin 2016年5月30日
 * @description
 * @ClassName NotNeedLogin
 */
public @interface NotNeedLogin {
	public boolean value() default true;
}
