package com.demo.refactor;
/**
 * refatcor 重命名
 * @author Administrator
 * 2016年4月17日
 * @description 
 * @ClassName RefactorDemo
 */
public class RefactorDepend {
	public static void sayName(){
		System.out.println("name");
	}
	public static void main(String[] args) {
		RefactorDemo.sysoI2Update();
	}
	public static RefactorDepend createRefactorDepend() {
		return new RefactorDepend();
	}
}
