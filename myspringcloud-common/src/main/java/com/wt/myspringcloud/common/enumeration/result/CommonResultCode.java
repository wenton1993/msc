package com.wt.myspringcloud.common.enumeration.result;

import com.wt.myspringcloud.common.core.IResultCode;

/**
 * 公共错误码
 * 分类：2XX-成功，4XX-客户端错误，5XX-服务端错误
 */
public enum CommonResultCode implements IResultCode {
	SUCCESS(200, "操作成功"),

	PARAM_ERROR(401, "请求参数检查不通过"),

	ERROR(500, "操作失败"),
	SERVICE_DISABLED(501, "请求的服务不可用"),
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