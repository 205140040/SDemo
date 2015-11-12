package com.demo.testjson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class FastJsonDemo {
	public static void main(String[] args) {
//		public static final Object parse(String text); 
		// ��JSON�ı�parseΪJSONObject����JSONArray 
		
//		public static final JSONObject parseObject(String text)��
		// ��JSON�ı�parse��JSONObject
		
//		public static final <T> T parseObject(String text, Class<T> clazz);
		// ��JSON�ı�parseΪJavaBean 
		
//		public static final JSONArray parseArray(String text);
		// ��JSON�ı�parse��JSONArray 
		
//		public static final <T> List<T> parseArray(String text, Class<T> clazz); 
		//��JSON�ı�parse��JavaBean���� 
		
//		public static final String toJSONString(Object object); 
		// ��JavaBean���л�ΪJSON�ı� 
		
//		public static final String toJSONString(Object object, boolean prettyFormat); 
		// ��JavaBean���л�Ϊ����ʽ��JSON�ı� 
		
//		public static final Object toJSON(Object javaObject);
		//��JavaBeanת��ΪJSONObject����JSONArray��
		Student student=new Student("ĬĬ","Ů",18,new Date());
		Student s3=new Student("ĬĬ","Ů",18,new Date());
		List<Student> myList=new ArrayList<>();
		myList.add(student);
		myList.add(s3);

		//��Objectװ����jsonString
		String jString=JSON.toJSONString(student);
		//��jsonstringת����JSONObject
		JSONObject jsonObject=JSON.parseObject(jString);
		jsonObject.put("haha", "����");
		Set<Entry<String, Object>> entrys=jsonObject.entrySet();
		for (Entry<String, Object> entry : entrys) {
			System.out.println(entry.getKey()+"\t "+entry.getValue());
		}
//		System.out.println(jsonObject);
		//��jsonstringת����javabean
		Student s2=JSON.parseObject(jString, Student.class);
		System.out.println(s2);
		//��jsonstring ����ת����java ����
		List<Student> jsonArray=JSON.parseArray(JSON.toJSONString(myList),Student.class);
		
//		3���й�����һЩ˵��

//		SerializeWriter���൱��StringBuffer

//		JSONArray���൱��List<Object>

//		JSONObject���൱��Map<String, Object>

//		JSON�����л�û���������飬�������Ͷ���List<Object>
		
		Object json=JSON.toJSON(student);
		
	}
}
