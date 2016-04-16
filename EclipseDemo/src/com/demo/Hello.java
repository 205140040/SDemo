package com.demo;

public class Hello {
	public static void main(String[] args) {
		System.out.println("------------命令行参数------");
		for (String string : args) {
			System.out.println("s:"+string);
		}
		System.out.println("--------------------------");
		System.out.println("hello");
	}
}
