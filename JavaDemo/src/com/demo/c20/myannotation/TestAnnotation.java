package com.demo.c20.myannotation;

public class TestAnnotation {
	@MyTest
	public void sayHello(){
		System.out.println("hello");
	}
	
	@UseCase(id=1,name="张三",token="123456")
	public void sayHello1(){
		System.out.println("hello1");
	}
	
	@UseCase(id=2,name="李四",token="223456")
	public void sayHello2(){
		System.out.println("HELLO");
	}
	
	@UseCase(id=3,name="酱紫",token="323456")
	public void sayHello3(){
		System.out.println("hello");
	}
}
