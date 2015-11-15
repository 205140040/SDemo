package com.demo.c15.fanxing;

import java.util.List;

import com.demo.c12.exception.Person;

public class DemoTest {
	public static void main(String[] args) {
		TDemo<Person> tDemo=new TDemo<>();
		TDemo<Integer> tDemo2=new TDemo<>();
		tDemo.setT(new Person());
		System.out.println(tDemo.getT());
		tDemo2.setT(666);
		System.out.println(tDemo2.getT());
		List<Person> tList=tDemo.getList();
		
		
	}
}
