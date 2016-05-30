package com.demo.bean;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
/**
 * 所有bean的类的基类
 * @author admin
 * 2016年5月30日
 * @description 
 * @ClassName BaseBean
 */
public class BaseBean implements Serializable{

	/**
	 * @author admin
	 * 2016年5月30日
	 * @description 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 统一的tostring方法
	 */
	@Override
	public String toString() {
		//使用apache的工具类，实现统一的tostring
		return ToStringBuilder.reflectionToString(this);
	}

}
