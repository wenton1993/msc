package com.wt.myspringcloud.common.exception;

import com.wt.myspringcloud.common.core.CommonResultCode;

public class UserException extends RuntimeException {

    private String code;

    public UserException() {}

    public UserException(String message) {
        super(message);
    }

    public UserException(String code, String message) {
        super(message);
        this.code = code;
    }

    public UserException(CommonResultCode commonResultCode) {
        super(commonResultCode.getMessage());
        this.code = commonResultCode.getCode();
    }

    public UserException(CommonResultCode commonResultCode, String message) {
        super(message);
        this.code = commonResultCode.getCode();
    }

}
