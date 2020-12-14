package com.wt.myspringcloud.common.exception;

import com.wt.myspringcloud.common.enumeration.result.CommonResultCode;

public class BusinessException extends RuntimeException {

    private int code;

    public BusinessException() {}

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(CommonResultCode commonResultCode) {
        super(commonResultCode.getMsg());
        this.code = commonResultCode.getCode();
    }

    public BusinessException(CommonResultCode commonResultCode, String message) {
        super(message);
        this.code = commonResultCode.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
