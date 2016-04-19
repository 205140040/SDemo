package com.demo.property;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertyDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * java操作属性文件
		 */
		String pPath="D://JAVASoft//GitProject//GitRep//SpringDeep//src//com//demo//property//testPro.properties";
		Properties properties=new Properties();
		readProperties(pPath, properties);
		//写入属性文件
		properties.setProperty("tname", "lulua");
		properties.setProperty("tage", "18");
		OutputStream os=new FileOutputStream(pPath);
		properties.store(os, "写入属性文件");
		os.close();
		System.out.println("------------写入后再次读取----");
		readProperties(pPath, properties);
		
	}

	public static void readProperties(String pPath, Properties properties) throws FileNotFoundException, IOException {
		InputStream in=new FileInputStream(pPath);
		/*读取属性文件*/
		properties.load(in);
		System.out.println("tname:"+properties.getProperty("tname"));
		System.out.println("遍历属性文件:");
		for (Entry<Object, Object> entry:properties.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		in.close();
	}

}
