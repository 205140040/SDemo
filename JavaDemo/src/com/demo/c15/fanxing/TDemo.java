package com.demo.c15.fanxing;

import java.util.List;

/**
 * 类型参数:一个类的泛型参数
 * @author hyc
 *
 * @param <Type>
 */
public class TDemo <Type>{
	private Type type;
	List<Type> list;


	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Type> getList() {
		return list;
	}

	public void setList(List<Type> list) {
		this.list = list;
	}
	
	/**
	 * 泛型方法
	 * 
	 */
	public <T> void typeMethod(T t){
		System.out.println(t);
	}
}
