package com.demo.controller;

public class TitleObject {
	/**
	 * 字段名称
	 */
	private String columnName;
	/**
	 * 中文名称
	 */
	private String chinaName;

	public TitleObject() {
		super();
	}

	public TitleObject(String columnName, String chinaName) {
		super();
		this.columnName = columnName;
		this.chinaName = chinaName;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getChinaName() {
		return chinaName;
	}

	public void setChinaName(String chinaName) {
		this.chinaName = chinaName;
	}

}
