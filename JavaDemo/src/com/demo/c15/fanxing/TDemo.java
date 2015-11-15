package com.demo.c15.fanxing;

import java.util.List;

/**
 * 类型参数:一个类的泛型参数
 * @author hyc
 *
 * @param <Type>
 */
public class TDemo <Type>{
	private Type t;
	List<Type> list;

	public Type getT() {
		return t;
	}

	public void setT(Type t) {
		this.t = t;
	}

	public List<Type> getList() {
		return list;
	}

	public void setList(List<Type> list) {
		this.list = list;
	}
	
	
}
