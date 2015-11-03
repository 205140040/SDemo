package com.demo.c20.myannotation;

import java.lang.reflect.Method;

/**
 * ע�⴦����
 * 
 * @date 2015��11��3��
 * @author hyc
 * @description
 */
public class UseCaseController {
	public static void useCaseTrack(Class<?> c){
		for (Method m : c.getMethods()) {//�������󷽷�
			//��ȡ������ע����Ϣ
			UseCase u=m.getAnnotation(UseCase.class);
			if(null!=u){
				System.out.println("**********************��¼��ʼ*************************");
				System.out.println("id:"+u.id()+"\t�û���:"+u.name());
				if("323456".equals(u.token())){
					System.out.println("������ȷ,��¼�ɹ�");
				}else{
					System.out.println("�������,��¼ʧ��");
				}
				System.out.println("**********************��¼����*************************");
				System.out.println("");
			}
			
		}
	}
	
	public static void main(String[] args) {
 		useCaseTrack( TestAnnotation.class);
	}
}
