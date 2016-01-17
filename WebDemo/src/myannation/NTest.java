package myannation;

import java.lang.reflect.Method;

public class NTest {
	@NeedLogin(loginName = "zss")
	public void sayHello() {
		System.out.println("hello");
	}

	public static void main(String[] args) {
		NTest nTest = new NTest();
		Method[] methods = nTest.getClass().getMethods();
		for (Method method : methods) {
			NeedLogin needLogin = method.getAnnotation(NeedLogin.class);
			if (null != needLogin) {
				System.out.println(needLogin.value());
				System.out.println(needLogin.loginName());
			}
		}
	}
}
