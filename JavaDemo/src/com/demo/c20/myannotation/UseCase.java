package com.demo.c20.myannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * ͳ������ע��
 * 
 * @date 2015��11��3��
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
