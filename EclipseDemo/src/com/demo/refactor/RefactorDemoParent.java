package com.demo.refactor;
/**
 * 重构提取接口
 * @author Administrator
 * 2016年4月17日
 * @description 
 * @ClassName RefactorDemoParent
 */
public class RefactorDemoParent implements RefactorDemoInterface {

	private RefactorDepend rdp;
	private static int num1;

	/**
	 * 
	 * @author Administrator
	 * @date 2016年4月17日
	 * @description 
	 * void
	 */
	public static void sayHello() {
		System.out.println("hello");
		RefactorDepend.sayName();
	}

	public static void main(String[] args) {
		/**
		 * refactor提取方法
		 * 重构提取局部变量
		 * 重构内联，直接调用某个方法的内部代码，不是调用方法名
		 */
		num1 = TEN;
		for (int i = 0; i < num1; i++) {
			System.out.println(i);
		}
		/**
		 * 重构更改方法名
		 */
		sysoI2Update();
	}

	public static void sysoI2Update() {
		num1 = TEN;
		for (int i = 0; i < num1; i++) {
			System.out.println(i);
		}
	}

	public static void forSysoutI() {
		num1 = TEN;
		for (int i = 0; i < num1; i++) {
			System.out.println(i);
		}
	}

	public RefactorDemoParent() {
		super();
	}

	public void test2() {
	}

}