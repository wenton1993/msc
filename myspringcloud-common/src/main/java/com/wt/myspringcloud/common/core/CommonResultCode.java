package com.wt.myspringcloud.common.core;

public enum CommonResultCode implements IResultCode {
	SUCCESS("200", "成功"),
	ERROR("500", "未知系统异常");

	private String code;
	private String message;

	CommonResultCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}