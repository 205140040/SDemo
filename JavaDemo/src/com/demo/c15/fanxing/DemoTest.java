package com.demo.c15.fanxing;

import java.util.List;

import com.demo.c12.exception.Person;

public class DemoTest {
	public static void main(String[] args) {
		TDemo<Person> tDemo=new TDemo<>();
		TDemo<Integer> tDemo2=new TDemo<>();
		tDemo.setType(new Person());
		System.out.println(tDemo.getType());
		tDemo2.setType(666);
		System.out.println(tDemo2.getType());
		List<Person> tList=tDemo.getList();
		tDemo.typeMethod("1");
		tDemo.typeMethod(666.66);
		tDemo.typeMethod(Person.class);
		
	}
}
