package com.demo.nav;

import java.util.ArrayList;
import java.util.List;

public class NavDemo {

	public static void main(String[] args) {
		/**
		 * 导航菜单的使用
		 * 1.go to line ==ctrl + l跳转到指定行
		 * 2.打开声明F3
		 * 3.打开类型层次 F4(查看父类，及其子类)
		 * 4,打开资源文件 open type 打开类
		 * 5.打开资源文件 open resource打开任意文件
		 * 6.面包屑：显示该类的路径:toggle bread
		 */
		List<String> l=new ArrayList<>();
		System.out.println("helloworld");
		
		myFor();
	}

	public static void myFor() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}

}
