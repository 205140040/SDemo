package com.demo.test;

public class ClassLoaderTest {
	public static void main(String[] args) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		System.out.println("AppClassLoader:" + classLoader);
		System.out.println("ExtClassLoader:" + classLoader.getParent());
		System.out.println("RootLoader:" + classLoader.getParent().getParent());
	}
}
