package com.wt.myspringcloud.common.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseController {

	protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);

	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

	// 调用接口成功
    protected <T> JsonResult<T> renderSuccess() {
        JsonResult<T> result = getJsonResult(true);
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMsg());
        return result;
    }

    protected <T> JsonResult<T> renderSuccess(String msg) {
        JsonResult<T> result = getJsonResult(true);
		result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(msg);
        return result;
    }

	protected <T> JsonResult<T> renderSuccess(String code, String msg) {
		JsonResult<T> result = getJsonResult(true);
		result.setCode(code);
		result.setMessage(msg);
		return result;
	}

	protected <T> JsonResult<T> renderSuccess(ResultCode resultCode) {
		return renderSuccess(resultCode.getCode(), resultCode.getMsg());
	}

    protected <T> JsonResult<T> renderSuccessWithData(T t) {
        JsonResult<T> result = renderSuccess();
        result.setData(t);
        return result;
    }

    // 调用接口失败
	protected <T> JsonResult<T> renderError() {
		JsonResult<T> result = getJsonResult(false);
		result.setCode(ResultCode.ERROR.getCode());
		result.setMessage(ResultCode.ERROR.getMsg());
		return result;
	}

	protected <T> JsonResult<T> renderError(String msg) {
		JsonResult<T> result = getJsonResult(false);
		result.setCode(ResultCode.ERROR.getCode());
		result.setMessage(msg);
		return result;
	}

	protected <T> JsonResult<T> renderError(String status, String msg) {
		JsonResult<T> result = getJsonResult(false);
		result.setCode(status);
		result.setMessage(msg);
		return result;
	}

	protected <T> JsonResult<T> renderError(ResultCode result) {
		return renderError(result.getCode(), result.getMsg());
	}

	private <T> JsonResult<T> getJsonResult(boolean success) {
		JsonResult<T> result = new JsonResult<>();
		result.setSuccess(success);
		result.setResponseTime(dtf.format(LocalDateTime.now()));
		return result;
	}
}
