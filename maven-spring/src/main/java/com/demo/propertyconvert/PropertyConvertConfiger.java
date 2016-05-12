package com.demo.propertyconvert;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 属性文件加密转换实现类
 * 
 * @author admin 2016年5月12日
 * @description
 * @ClassName PropertyConvertConfiger
 */
public class PropertyConvertConfiger extends PropertyPlaceholderConfigurer {

	public String[] propertList = { "jdbc.url", "jdbc.username" };

	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if (needConvert(propertyName)) {
			return propertyValue.substring(4, propertyValue.length());
		}
		return propertyValue;
	}

	private boolean needConvert(String propName) {
		for (String s : propertList) {
			if (s.equals(propName)) {
				return true;
			}
		}
		return false;
	}

}
