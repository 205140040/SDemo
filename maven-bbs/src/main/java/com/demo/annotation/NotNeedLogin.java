package com.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 不需要登录
 * 
 * @author admin 2016年5月30日
 * @description
 * @ClassName NotNeedLogin
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NotNeedLogin {
	public boolean value() default true;
}
