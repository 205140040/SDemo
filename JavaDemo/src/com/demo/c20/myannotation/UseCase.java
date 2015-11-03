package com.demo.c20.myannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 统计用列注解
 * 
 * @date 2015年11月3日
 * @author hyc
 * @description
 */
@Target(value=ElementType.METHOD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface UseCase {
	public int id();
	public String name() default "no description";
	public String token();
}
