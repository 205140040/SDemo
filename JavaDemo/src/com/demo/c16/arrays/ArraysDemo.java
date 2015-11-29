package com.demo.c16.arrays;

import java.util.Arrays;
import java.util.Collections;

public class ArraysDemo {
	/**
	 * arrays的用法
	 */
	public static void main(String[] args) {
		// 复制数组
		int[] i = new int[7];
		int[] j = new int[9];
		int[] b = new int[7];
		Arrays.fill(i, 6);
		Arrays.fill(j, 8);
		Arrays.fill(b, 6);
		for (int i2 : i) {
			System.out.print(i2 + ",");
		}
		System.out.println("\n-----------------------");
		for (int j2 : j) {
			System.out.print(j2 + ",");
		}
		//
		System.arraycopy(i, 0, j, 0, i.length);
		System.out.println("\n-----------------------");
		for (int j2 : j) {
			System.out.print(j2 + ",");
		}
		System.out.println("\n-----------------------");
		// 比较数组是否相等，个数和类容是否一样
		if (Arrays.equals(i, j)) {
			System.out.println("i,j相等");
		} else {
			System.out.println("i,j不相等");
		}
		if (Arrays.equals(i, b)) {
			System.out.println("i,b相等");
		} else {
			System.out.println("i,b不相等");
		}
		// 排序
		Integer[] sorts = { 5, 3, 88, 0, -1, 518, 99, 666 };
		Arrays.sort(sorts);
		for (Integer s : sorts) {
			System.out.print(s + "\t");
		}
		System.out.println("\n----------------------");
		// 查找
		System.out.println(Arrays.binarySearch(sorts, 3));
		System.out.println("\n----------------------");
		/**
		 * collections,反转排序
		 */
		Collections.reverse(Arrays.asList(sorts));
		for (Integer s : sorts) {
			System.out.print(s + "\t");
		}
		System.out.println(555);
	}
}
