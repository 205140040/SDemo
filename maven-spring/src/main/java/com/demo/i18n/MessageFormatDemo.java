package com.demo.i18n;

import java.text.MessageFormat;
import java.util.Date;

public class MessageFormatDemo {

	public static void main(String[] args) {
		/**
		 * JAVA中使用MessageFormat替换String中的占位符
		 * 1.MessageFormat.format方法的第二个参数是一个数组，所以可以传多个参数进去 2.
		 * 如果传入多个参数，但实际需要替换的占位符没有那么多，程序并不会报错
		 */
		String msg = "你好啊:{0},今天日期:{1}";
		System.out.println(MessageFormat.format(msg, "酱酱", new Date().toLocaleString()));
	}

}
