package myannation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//使用范围，方法
@Target(ElementType.METHOD)
// 在运行时有效
@Retention(RetentionPolicy.RUNTIME)
/**
 * 需要登录
 * 
 * @author 20514 2016年1月18日
 * @description
 */
public @interface NeedLogin {
	public boolean value() default true;

	public String loginName() default "";
}
