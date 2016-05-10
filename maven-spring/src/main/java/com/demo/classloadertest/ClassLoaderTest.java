package com.demo.classloadertest;

public class ClassLoaderTest {
	public static void main(String[] args) {
		/**
		 * 类装载器:
		 * root:-->ExtClassLoader-->AppClassLoader
		 */
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		System.out.println("current:" + classLoader);
		System.out.println("parent:" + classLoader.getParent());
		System.out.println("root:" + classLoader.getParent().getParent());
	}
}
