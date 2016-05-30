package com.demo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 1.通过@value注入属性到bean 2.通过@value注入字面值
 * 引入属性文件中的值用$开头，引入bean中的值用#开头如：#{student.name}
 * @author admin 2016年5月12日
 * @description
 * @ClassName MyDataSource
 */
@Component
public class MyDataSource {
	@Value("${jdbc.url}")
	private String url;
	@Value("哈哈哈哈")
	private String myName;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

}
