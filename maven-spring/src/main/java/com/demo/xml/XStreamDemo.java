package com.demo.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.XStream;

public class XStreamDemo {

	public static void main(String[] args) {
		XmlUser user = new XmlUser("啦啦啦", 18, "哈哈", new Date());
		XmlUser lu2 = new XmlUser("啦啦啦2", 18, "哈哈2", new Date());
		List<XmlUser> list = new ArrayList<XmlUser>();
		list.add(user);
		list.add(lu2);
		objectToXml(list);
		List<XmlUser> list2 = (List<XmlUser>) xmlToObject();
		System.out.println(JSON.toJSONString(list2));
	}

	/**
	 * 对象转换成xml
	 * 
	 * @author admin
	 * @date 2016年5月21日
	 * @description
	 * @param t
	 *            void
	 */
	public static <T> void objectToXml(T t) {
		XStream xStream = new XStream();
		// 设置应用注解
		xStream.processAnnotations(XmlUser.class);

		try {
			OutputStream out = new FileOutputStream(new File("C://Users//admin//Desktop//xmluser.xml"));
			xStream.toXML(t, out);
			System.out.println("对象转换xml成功");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Object xmlToObject() {
		File file = new File("C://Users//admin//Desktop//xmluser.xml");

		// InputStream in=new FileInputStream(file);
		XStream xStream = new XStream();
		// 设置应用注解
		xStream.processAnnotations(XmlUser.class);
		Object object = xStream.fromXML(file);
		return object;
	}
}
