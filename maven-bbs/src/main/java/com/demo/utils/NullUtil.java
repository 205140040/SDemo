package com.demo.utils;

public class NullUtil {
	public static <T> Boolean isNull(T t) {
		if (null == t) {
			return true;
		} else {
			return false;
		}
	}

	public static <T> Boolean isNotNull(T t) {
		if (null != t) {
			return true;
		} else {
			return false;
		}
	}
}
