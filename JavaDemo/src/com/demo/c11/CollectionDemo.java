package com.demo.c11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionDemo {
	public static void main(String[] args) {
		//打赢容器
		List<String> l1=new ArrayList<>();
		l1.add("one");
		l1.add("two");
		l1.add("three");
		System.out.println(l1);
		Set<String> set1=new HashSet<>();
		set1.add("one");
		set1.add("two");
		set1.add("one");
		System.out.println(set1);
		Map<Integer, String> map1=new HashMap<>();
		map1.put(1, "one");
		map1.put(2, "tow");
		map1.put(3, "three");
		System.out.println(map1);

	}
}
