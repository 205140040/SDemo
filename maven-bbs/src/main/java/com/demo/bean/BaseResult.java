package com.demo.bean;

public class BaseResult extends BaseBean {

	/**
	 * @author admin 2016年5月31日
	 * @description
	 */
	private static final long serialVersionUID = 1L;

	private Boolean flag;

	private String msg;

	private Object object;

	public BaseResult() {
		super();
	}

	public static BaseResult resultTrueAndMsg(String msg) {
		BaseResult br = new BaseResult();
		br.flag = true;
		br.msg = msg;
		return br;
	}

	public static BaseResult resultFalseAndMsg(String msg) {
		BaseResult br = new BaseResult();
		br.flag = false;
		br.msg = msg;
		return br;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
