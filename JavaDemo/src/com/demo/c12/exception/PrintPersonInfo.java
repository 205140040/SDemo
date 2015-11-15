package com.demo.c12.exception;

public class PrintPersonInfo {
	public static void printInfo(Person person) throws MyException{
		System.out.println(person.getName());
		throw new MyException("出现了自定义异常");
	}
}
