package com.demo.controller;

import org.junit.Test;

public class TestJUnit {

	public String methodOne(){
		return "this is one";
	}
	
	public String methodTwo(){
		return "this is two";
	}
	
	public String methodThree(){
		return "this is three";
	}
	
	@Test
	public void testOne(){
		System.out.println(methodOne());
	}
	
	@Test
	public void testTwo(){
		System.out.println(methodTwo());
	}
}
