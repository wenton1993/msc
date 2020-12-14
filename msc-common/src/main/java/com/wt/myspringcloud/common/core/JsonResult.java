package com.wt.myspringcloud.common.core;

import com.wt.myspringcloud.common.enumeration.result.CommonResultCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
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

    private JsonResult(boolean success, int code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> JsonResult<T> success() {
        return new JsonResult<>(true, CommonResultCode.SUCCESS.getCode(), CommonResultCode.SUCCESS.getMsg(), null);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<>(true, CommonResultCode.SUCCESS.getCode(), CommonResultCode.SUCCESS.getMsg(), data);
    }

    /**
     * 处理请求失败，根据 code 和 msg 返回处理结果
     *
     * @param code 响应码
     * @param msg  描述
     * @param <T>  响应数据的类型
     * @return 响应结果的 JsonResult 对象
     */
    public static <T> JsonResult<T> fail(int code, String msg) {
        return new JsonResult<>(false, code, msg, null);
    }

    public static <T> JsonResult<T> fail() {
        return new JsonResult<>(false, CommonResultCode.ERROR.getCode(), CommonResultCode.ERROR.getMsg(), null);
    }

    public static <T> JsonResult<T> fail(String msg) {
        return new JsonResult<>(false, CommonResultCode.ERROR.getCode(), msg, null);
    }

    public static <T> JsonResult<T> fail(IResultCode resultCode) {
        return new JsonResult<>(false, resultCode.getCode(), resultCode.getMsg(), null);
    }

}