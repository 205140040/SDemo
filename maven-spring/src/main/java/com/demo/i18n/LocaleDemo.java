package com.demo.i18n;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 国际化
 * 
 * @author admin 2016年5月12日
 * @description
 * @ClassName LocaleDemo
 */
public class LocaleDemo {

	public static void main(String[] args) throws Exception {
		/**
		 * 国际化：语言-地区代码,如：zh-CN,en-US
		 */
		Locale cnlocale = new Locale("zh", "CN");
		Locale usLocale = new Locale("en", "US");
		DateFormat cnnf = DateFormat.getDateInstance(DateFormat.MEDIUM, cnlocale);
		DateFormat usnf = DateFormat.getDateInstance(DateFormat.MEDIUM, usLocale);
		System.out.println("cn:" + cnnf.format(new Date()));
		System.out.println("us:" + usnf.format(new Date()));
		// 读取资源文件
		ResourceBundle zhBundle = ResourceBundle.getBundle("com/demo/i18n/res", cnlocale);
		System.out.println(new String(zhBundle.getString("hello").getBytes(), "UTF-8"));
		ResourceBundle usBundle = ResourceBundle.getBundle("com/demo/i18n/res", usLocale);
		System.out.println(usBundle.getString("hello"));
		/**
		 * 在资源文件中使用格式化串,{0}获取动态参数
		 */
	}

}
