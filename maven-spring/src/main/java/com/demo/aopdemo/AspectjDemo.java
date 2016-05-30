package com.demo.aopdemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect // 生命一个切面
public class AspectjDemo {
	/**
	 * 1.execution关键字,表示执行方法
	 * 
	 * @author admin
	 * @date 2016年5月15日
	 * @description void 引用自定义的切点
	 */
	@Before("execution(* sayHello(..))&&MyPointer.inDemoService()") // 定义切点
	public void beforeAdvice() {// 前置增强
		// 增强业务
		System.out.println("尊敬的顾客:");
	}

	/**
	 * returning绑定返回值
	 * @author admin
	 * @date 2016年5月15日
	 * @description 
	 * @param returnValue
	 * void
	 */
	@AfterReturning(value="@annotation(com.demo.aopdemo.NeedTest)",returning="returnValue")
	public void afterAdvice(String returnValue) {
		System.out.println("标识@NeedTest，注解的方法运行后置增强....");
		System.out.println("返回值:"+returnValue);
	}

	/**
	 * @throws Throwable 7.4.1切点表达式函数: 1.execution ,表示满足某一匹配模式的所有目标类方法连接点
	 * 2.@annation,表示满足标识某一注解的目标类方法连接点 3.args,标识满足某个参数的方法
	 * 4.@args()，表示参数为某个注解指定的方法连接点
	 * 5.within(),表示特定域下的所有连接点，如：within(com.demo.service.*)表示com.demo.
	 * service包中所有类的方法连接点 within(com.demo.service.*Service)所有已service结尾的方法连接点
	 * 7.4.2切点表达式通配符:*匹配所有,..匹配所有，但在匹配类时必须和*结合使用 7.4.3逻辑运算符:&&
	 * 与运算符，交集运算符，在xml中使用and ||或 !非,如:!within(com.demo.test.*) 7.4.4增强类型
	 * 1.@before前置增强 2.@afterReturning后置增强 3.环绕增强 4.抛出增强 5.
	 * 7.5.2,exectuion(<返回类型>,<方法名>,<参数>) 如execuiton(*
	 * com.demo.service.*(..))匹配com.demo.service中任意返回类型的所有方法
	 * 在类名模式串中,.*表示包下的所有方法,..*表示包下的所有子孙包下的所有方法 execution(*
	 * *hello(String,int))匹配参数为string，int的方法 *表示任意类型的参数,..表示任意类型，任意个数的参数
	 * execution(* *hello(String,*)第一个为sring，第二个为任意类型的参数 7.5.3
	 * args(com.demo.Waiter)表示匹配参数为waiter的所有类中的所有方法
	 * within()指定的范围最小是类，如within(com.demo.service.*) 7.6切点符合运算
	 * within(com.demo.service.*&&execution(* *hello(..)))
	 * 或target(com.demo.service.S1||com.demo.service.S2) 7.6.4访问连接点信息
	 * 1.JoinPoint 2.ProceedingJoinPoint @throws
	 */
	
	
	
	/**
	 * 7.6.4访问连接点信息
	 * 1.JoinPoint 2.ProceedingJoinPoint
	 * 3.绑定连接点方法入参
	 * @author admin
	 * @date 2016年5月15日
	 * @description 
	 * @param pjp
	 * @throws Throwable
	 * void
	 */
	@Around(value="execution(* com.demo.aopdemo.WaiterServiceImpl.*Arround(..))&&args(name,sex,..)")
	public void arroundJoinPoint(ProceedingJoinPoint pjp,String name,String sex) throws Throwable {
		System.out.println("---------------------------------------------------------");
		System.out.println("环绕增强开始");
		System.out.println("参数[0]:" + pjp.getArgs()[0]);
		System.out.println("连接点入参：name:"+name+"\tsex:"+sex);
		System.out.println(pjp.getTarget().getClass());//访问连接点信息
		pjp.proceed();// 通过连接点执行目标对象方法
		System.out.println("环绕增强结束");
		System.out.println("---------------------------------------------------------");

	}
	
	/**
	 * 绑定异常
	 * @author admin
	 * @date 2016年5月15日
	 * @description 
	 * @param exception
	 * void
	 */
//	@AfterThrowing(throwing="exception")
//	public void throwing(Exception exception){
//		System.out.println(exception.getMessage());
//	}
}
