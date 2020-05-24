package com.wt.myspringcloud.common.core;

import com.wt.myspringcloud.common.enumeration.result.CommonResultCode;
import lombok.extern.slf4j.Slf4j;

import java.time.format.DateTimeFormatter;

@Slf4j
public class BaseController {

	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    protected <T> JsonResult<T> renderSuccess() {
        return renderSuccess(CommonResultCode.SUCCESS.getCode(), CommonResultCode.SUCCESS.getMessage());
    }

    protected <T> JsonResult<T> renderSuccess(String msg) {
		return renderSuccess(CommonResultCode.SUCCESS.getCode(), msg);
	}

	protected <T> JsonResult<T> renderSuccess(IResultCode resultCode) {
		return renderSuccess(resultCode.getCode(), resultCode.getMessage());
	}

    protected <T> JsonResult<T> renderSuccessWithData(T t) {
        JsonResult<T> result = renderSuccess();
        result.setData(t);
        return result;
    }

	protected <T> JsonResult<T> renderSuccess(int code, String msg) {
		JsonResult<T> result = getJsonResult(true);
		result.setCode(code);
		result.setMessage(msg);
		return result;
	}

	protected <T> JsonResult<T> renderError() {
		return renderError(CommonResultCode.ERROR.getCode(), CommonResultCode.ERROR.getMessage());
	}

	protected <T> JsonResult<T> renderError(String msg) {
		return renderError(CommonResultCode.ERROR.getCode(), msg);
	}

	protected <T> JsonResult<T> renderError(IResultCode resultCode) {
		return renderError(resultCode.getCode(), resultCode.getMessage());
	}

	protected <T> JsonResult<T> renderError(int status, String msg) {
		JsonResult<T> result = getJsonResult(false);
		result.setCode(status);
		result.setMessage(msg);
		return result;
	}

	/**
	 * 获取已赋值结果和时间的 JsonResult 对象
	 *
	 * @param success 返回结果是否成功
	 * @param <T> 返回数据类型
	 * @return JsonResult 对象
	 */
	private <T> JsonResult<T> getJsonResult(boolean success) {
		JsonResult<T> result = new JsonResult<>();
		result.setSuccess(success);
		return result;
	}

}
