package com.demo.c20.myannotation;

import java.lang.reflect.Method;

/**
 * 注解处理器
 * 
 * @date 2015年11月3日
 * @author hyc
 * @description
 */
public class UseCaseController {
	public static void useCaseTrack(Class<?> c){
		for (Method m : c.getMethods()) {//遍历对象方法
			//获取方法的注解信息
			UseCase u=m.getAnnotation(UseCase.class);
			if(null!=u){
				System.out.println("**********************登录开始*************************");
				System.out.println("id:"+u.id()+"\t用户名:"+u.name());
				if("323456".equals(u.token())){
					System.out.println("密码正确,登录成功");
				}else{
					System.out.println("密码错误,登录失败");
				}
				System.out.println("**********************登录结束*************************");
				System.out.println("");
			}
			
		}
	}
	
	public static void main(String[] args) {
 		useCaseTrack( TestAnnotation.class);
	}
}
