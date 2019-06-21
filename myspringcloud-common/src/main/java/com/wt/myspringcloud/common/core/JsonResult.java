package com.wt.myspringcloud.common.core;

public class JsonResult<T> {

    // 调用接口是否成功
    private boolean success;
    // 返回码
    private int code;
    // 返回信息
    private String message = "";
    // 返回时间
    private String responseDateTime;
    // 返回数据
    private T data;

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