package com.demo.c15.fanxing;

import java.util.ArrayList;
import java.util.List;

import com.demo.c12.exception.Person;

/**
 * 泛型方法和可变参数结合使用
 * @author hyc
 *
 */
public class ArgsType {
	/**
	 * 泛型方法和可变参数结合使用
	 * @param args
	 * @return
	 */
	public static <T> List<T> argsType(T ... args){
		List<T> result=new ArrayList<>();
		for(T item:args){
			result.add(item);
		}
		return result;
	}
	
	/**
	 * 泛型边界 方法和可变参数结合使用
	 * @param args
	 * @return
	 */
	public static <T extends Person> List<T> argsType2(T ... args){
		List<T> result=new ArrayList<>();
		for(T item:args){
			result.add(item);
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(argsType(1,2,3,4));
		Person person=new Person();
		person.setName("zss");
		System.out.println(argsType2(person,person));
		System.out.println(argsType("one","two","three","four"));
		//泛型通配符 用于反射
		Class<?> class1=Person.class;
		System.out.println(class1);
	}
}
