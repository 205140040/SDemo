package com.demo;

/**
 * 生成javadoc ：export 导出javadoc 1.在configure javadoc arguments处 设置：-encoding
 * UTF-8 -charset UTF-8
 * 
 * @author Administrator 2016年4月21日
 * @description
 * @ClassName JavaDocDemo
 */
public class JavaDocDemo {

	public static void main(String[] args) {
		getStr();
	}

	/**
	 * 
	 * @author Administrator
	 * @date 2016年4月21日
	 * @description
	 * @return String
	 */
	public static String getStr() {
		return "hello";
	}
}
