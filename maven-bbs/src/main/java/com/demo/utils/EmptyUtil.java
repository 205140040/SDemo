package com.demo.utils;

import org.springframework.util.StringUtils;

public class EmptyUtil {
	public static Boolean isEmpty(Object obj) {
		return NullUtil.isNull(obj);
	}

	public static Boolean isNotEmpty(Object obj) {
		return NullUtil.isNotNull(obj);
	}

	public static Boolean isEmpty(String obj) {
		return !StringUtils.hasText(obj);
	}

	public static Boolean isNotEmpty(String obj) {
		return StringUtils.hasText(obj);
	}

}
