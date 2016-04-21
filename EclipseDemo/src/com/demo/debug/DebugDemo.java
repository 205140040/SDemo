package com.demo.debug;

import java.util.HashMap;

import com.demo.Student;

public class DebugDemo {
	
	public static void main(String[] args) {
		/**
		 * debug
		 * 1.F6一步一步运行
		 * 2.查看变量，在debug视图中查看，
		 * 或者选中变量悬停可以看到变量的值
		 * 3.F5进入方法中进行调试
		 * 4.F7跳出方法
		 * 5.F6步进
		 * 6.F8调到下一个端点
		 * 7.表达式或display查看结果,选中一个表达式点击watch查看结果
		 * show view -display:直接输入变量如syso(s.length());
		 * 8.显示集合里面具体的值 ,选择debug视图variables上面的show logical
		 * 9.设置条件断点：断点那一行，选择断点properties，启用condition并设置条件
		 * 10.设置异常断点,run:add javaexception break
		 */
		forTest();
		int num2=6;
		int num3=testNum()+num2;
		int num5=num2+num3;
		String s="hello";
		System.out.println(num5);
		HashMap<String, StudentDemo> sMap=new HashMap<>();
		sMap.put("s1", new StudentDemo("aa", "aa"));
		sMap.put("s2", new StudentDemo("bb", "bb"));
		System.out.println(sMap);
		StudentDemo sd=new StudentDemo();
		System.out.println(sd.getSname().length());
		System.out.println("上面出现异常了");
	}

	public static void forTest() {
		for (int i = 1; i <= 100; i++) {
			System.out.println("i:"+i);
		}
	}
	
	public static int testNum(){
		return 10;
	}

}
