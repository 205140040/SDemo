package com.demo.refactor;
/**
 * refatcor 重命名
 * 提取父类，提取接口
 * @author Administrator
 * 2016年4月17日
 * @description 
 * @ClassName RefactorDemo
 */
public class RefactorDemo extends RefactorDemoParent {
	private RefactorDemoData data = new RefactorDemoData(new User());

	/**
	 * 重构，把方法声明到接口中-->refactor-->pull up
	 * @author Administrator
	 * @date 2016年4月17日
	 * @description 
	 * void
	 */
	@Override
	public void test2() {
		System.out.println("test2");
	}

	/**
	 * 重构方法下移,到子类》push down
	 * 重构，把方法参数提取为类
	 * @author Administrator
	 * @date 2016年4月17日
	 * @description 
	 * void
	 * @param parameterObject TODO
	 */
	public void test3(Test3Parameter parameterObject) {
		RefactorDepend rdp=RefactorDepend.createRefactorDepend();
	}
	
	public static void main(String[] args) {
		/**
		 * 使用重构，通过父类声明变量
		 * use supertype where possible
		 * 使用重构，引入工厂
		 */
		RefactorDemoInterface rd=createRefactorDemo();
		rd.test2();
	}

	public static RefactorDemo createRefactorDemo() {
		return new RefactorDemo();
	}
}
