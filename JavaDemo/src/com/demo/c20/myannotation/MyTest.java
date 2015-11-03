package com.demo.c20.myannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 定义一个空注解
 * 
 * @date 2015年11月3日
 * @author hyc
 * @description
 */
@Target(value=ElementType.METHOD)//注解用在什么地方,一个方法，或者域上
@Retention(value=RetentionPolicy.RUNTIME)//注解在哪个级别可用，在运行时可用，或者源码中
public @interface MyTest {

}
