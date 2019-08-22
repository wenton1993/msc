package com.wt.myspringcloud.common.core;

public enum CommonResultCode implements IResultCode {
	SUCCESS(200, "成功"),
	ERROR(509, "未知系统异常"),
	SERVICE_DISABLED(500, "您请求的服务不可用！"),

	;

	private int code;
	private String message;

	CommonResultCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}