package com.demo.c12.exception;

public class TestException {
	public static void main(String[] args) {
		try {
//			Person person=new Person();
//			PrintPersonInfo.printInfo(person);
			thorwMyException();
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println(e.getMessage());
			e.printStackTrace(System.err);
			System.out.println("遍历异常栈");
			for(StackTraceElement ste: e.getStackTrace()){
				System.err.println(ste.getLineNumber()+"\t"+ste.getClass()+"\t"+ste.getClassName());
			}
		}
		System.out.println("异常捕获后");
		System.out.println("执行next方法");
		sayHello();
	}

	public static void sayHello() {
		System.out.println("Hello");
	}

	public static void thorwMyException() throws MyException{
//		Person p = new Person();
//		System.out.println(p.getName());
		throw new MyException("出现了自定义异常");
	}
}
