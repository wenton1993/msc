package com.wt.myspringcloud.common.exception;

import com.wt.myspringcloud.common.core.ResultCode;

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

    public UserException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
    }

    public UserException(ResultCode resultCode, String message) {
        super(message);
        this.code = resultCode.getCode();
    }

}
