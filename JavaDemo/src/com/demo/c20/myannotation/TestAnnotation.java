package com.demo.c20.myannotation;

public class TestAnnotation {
	@MyTest
	public void sayHello(){
		System.out.println("hello");
	}
	
	@UseCase(id=1,name="����",token="123456")
	public void sayHello1(){
		System.out.println("hello1");
	}
	
	@UseCase(id=2,name="����",token="223456")
	public void sayHello2(){
		System.out.println("HELLO");
	}
	
	@UseCase(id=3,name="����",token="323456")
	public void sayHello3(){
		System.out.println("hello");
	}
}
