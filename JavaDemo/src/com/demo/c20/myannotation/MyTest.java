package com.demo.c20.myannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * ����һ����ע��
 * 
 * @date 2015��11��3��
 * @author hyc
 * @description
 */
@Target(value=ElementType.METHOD)//ע������ʲô�ط�,һ����������������
@Retention(value=RetentionPolicy.RUNTIME)//ע�����ĸ�������ã�������ʱ���ã�����Դ����
public @interface MyTest {

}
