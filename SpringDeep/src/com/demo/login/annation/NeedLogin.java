package com.demo.login.annation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 需要登录的注解
 * 
 * @author 20514 2016年3月19日
 * @description
 */
// 使用范围，方法
@Target(ElementType.METHOD)
// 在运行时有效
@Retention(RetentionPolicy.RUNTIME)
public @interface NeedLogin {
	/**
	 * 默认需要登录为true，传入false代表不需要登录
	 */
	public boolean value() default true;
}
