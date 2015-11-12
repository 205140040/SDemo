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
		// 把JSON文本parse为JSONObject或者JSONArray 
		
//		public static final JSONObject parseObject(String text)；
		// 把JSON文本parse成JSONObject
		
//		public static final <T> T parseObject(String text, Class<T> clazz);
		// 把JSON文本parse为JavaBean 
		
//		public static final JSONArray parseArray(String text);
		// 把JSON文本parse成JSONArray 
		
//		public static final <T> List<T> parseArray(String text, Class<T> clazz); 
		//把JSON文本parse成JavaBean集合 
		
//		public static final String toJSONString(Object object); 
		// 将JavaBean序列化为JSON文本 
		
//		public static final String toJSONString(Object object, boolean prettyFormat); 
		// 将JavaBean序列化为带格式的JSON文本 
		
//		public static final Object toJSON(Object javaObject);
		//将JavaBean转换为JSONObject或者JSONArray。
		Student student=new Student("默默","女",18,new Date());
		Student s3=new Student("默默","女",18,new Date());
		List<Student> myList=new ArrayList<>();
		myList.add(student);
		myList.add(s3);

		//将Object装换成jsonString
		String jString=JSON.toJSONString(student);
		//将jsonstring转换成JSONObject
		JSONObject jsonObject=JSON.parseObject(jString);
		jsonObject.put("haha", "哈哈");
		Set<Entry<String, Object>> entrys=jsonObject.entrySet();
		for (Entry<String, Object> entry : entrys) {
			System.out.println(entry.getKey()+"\t "+entry.getValue());
		}
//		System.out.println(jsonObject);
		//将jsonstring转换成javabean
		Student s2=JSON.parseObject(jString, Student.class);
		System.out.println(s2);
		//将jsonstring 集合转换成java 集合
		List<Student> jsonArray=JSON.parseArray(JSON.toJSONString(myList),Student.class);
		
//		3、有关类库的一些说明

//		SerializeWriter：相当于StringBuffer

//		JSONArray：相当于List<Object>

//		JSONObject：相当于Map<String, Object>

//		JSON反序列化没有真正数组，本质类型都是List<Object>
		
		Object json=JSON.toJSON(student);
		
	}
}
