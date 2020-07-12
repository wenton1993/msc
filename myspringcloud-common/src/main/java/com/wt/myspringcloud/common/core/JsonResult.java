package com.wt.myspringcloud.common.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
public class JsonResult<T> {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    /**
     * 调用接口是否成功
     */
    private boolean success;

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg = "";

    /**
     * 返回时间
     */
    private String responseDateTime = dtf.format(LocalDateTime.now());

    /**
     * 返回数据
     */
    private T data;

    public JsonResult() {
    }

    public JsonResult(boolean success, IResultCode resultCode) {
        this.success = success;
        this.code = resultCode.getCode();
        this.msg = resultCode.getMessage();
    }

}