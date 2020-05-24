package com.wt.myspringcloud.common.util;

import com.wt.myspringcloud.common.enumeration.result.CommonResultCode;
import com.wt.myspringcloud.common.core.IResultCode;
import com.wt.myspringcloud.common.core.JsonResult;

/**
 * @author 文通
 * @since 2020/5/24
 */
public class JsonResultUtils {

    /**
     * 获取已赋值结果和时间的 JsonResult 对象
     *
     * @param result 处理请求是否成功
     * @param <T>    返回数据类型
     * @return JsonResult 对象
     */
    private static <T> JsonResult<T> getBaseJsonResult(boolean result) {
        JsonResult<T> jsonResult = new JsonResult<>();
        jsonResult.setSuccess(result);
        return jsonResult;
    }

    /**
     * 处理请求成功，根据 code 和 msg 返回处理结果
     *
     * @param code 响应码
     * @param msg  描述
     * @param <T>  响应数据的类型
     * @return 响应结果的 JsonResult 对象
     */
    public static <T> JsonResult<T> success(int code, String msg) {
        JsonResult<T> result = getBaseJsonResult(true);
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    public static <T> JsonResult<T> success() {
        return success(CommonResultCode.SUCCESS.getCode(), CommonResultCode.SUCCESS.getMessage());
    }

    public static <T> JsonResult<T> success(String msg) {
        return success(CommonResultCode.SUCCESS.getCode(), msg);
    }

    public static <T> JsonResult<T> success(IResultCode resultCode) {
        return success(resultCode.getCode(), resultCode.getMessage());
    }

    public static <T> JsonResult<T> successWithData(T t) {
        JsonResult<T> result = success();
        result.setData(t);
        return result;
    }

    /**
     * 处理请求失败，根据 code 和 msg 返回处理结果
     *
     * @param status 响应码
     * @param msg    描述
     * @param <T>    响应数据的类型
     * @return 响应结果的 JsonResult 对象
     */
    public static <T> JsonResult<T> fail(int status, String msg) {
        JsonResult<T> result = getBaseJsonResult(false);
        result.setCode(status);
        result.setMessage(msg);
        return result;
    }

    public static <T> JsonResult<T> fail() {
        return fail(CommonResultCode.ERROR.getCode(), CommonResultCode.ERROR.getMessage());
    }

    public static <T> JsonResult<T> fail(String msg) {
        return fail(CommonResultCode.ERROR.getCode(), msg);
    }

    public static <T> JsonResult<T> fail(IResultCode resultCode) {
        return fail(resultCode.getCode(), resultCode.getMessage());
    }

}
