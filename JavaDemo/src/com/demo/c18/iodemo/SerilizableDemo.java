package com.demo.c18.iodemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import com.alibaba.fastjson.JSON;

public class SerilizableDemo {
	/**
	 * 序列化
	 * @param args
	 * @throws Exception 
	 */
public static void main(String[] args) throws Exception {
	OutputStream os=new FileOutputStream("C://Users//20514//Desktop//testIo.txt");
	ObjectOutputStream oos=new ObjectOutputStream(os);
	Person person=new Person("zhangsan", "女", 18);
	oos.writeObject(person);
	os.close();
	oos.close();
	FileInputStream is=new FileInputStream("C://Users//20514//Desktop//testIo.txt");
	ObjectInputStream ois=new ObjectInputStream(is);
	Person read=(Person)ois.readObject();
	System.out.println(JSON.toJSONString(read));
	is.close();
	ois.close();
}
}
