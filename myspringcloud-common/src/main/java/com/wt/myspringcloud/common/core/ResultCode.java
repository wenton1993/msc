package com.wt.myspringcloud.common.core;

public enum ResultCode {
	SUCCESS("200", "成功"),
	ERROR("500", "未知系统异常");

	private String code;
	private String msg;

	ResultCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

}