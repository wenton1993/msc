package com.wt.myspringcloud.common.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JsonResult<T> {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    // 调用接口是否成功
    private boolean success;
    // 返回码
    private int code;
    // 返回信息
    private String message = "";
    // 返回时间
    private String responseDateTime = dtf.format(LocalDateTime.now());
    // 返回数据
    private T data;

    public JsonResult() {}

    public JsonResult(boolean success, IResultCode resultCode) {
        this.success = success;
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponseDateTime() {
        return responseDateTime;
    }

    public void setResponseDateTime(String responseDateTime) {
        this.responseDateTime = responseDateTime;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}