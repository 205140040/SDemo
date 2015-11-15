package com.demo.c13.classdemo;

import com.demo.c12.exception.Person;

public class ClassDemo {
public static void main(String[] args) {
	Person person=new Person();
	//泛型通配符,限定子类
	Class<? extends Object> c=Person.class;
	if(c.isInstance(person)){
		System.out.println("is person");
	}
	System.out.println(c);
	c=Integer.class;
	Integer i=0;
	if(c.isInstance(i)){
		System.out.println("is int");
	}
	System.out.println(c);

}
}
