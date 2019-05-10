package com.wt.myspringcloud.common.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

	private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

	private JsonResult<Void> getJsonResult(boolean success) {
		JsonResult<Void> result = new JsonResult<>();
		result.setSuccess(success);
		result.setResponseTime(dtf.format(LocalDateTime.now()));
		return result;
	}

    /**
     * 渲染成功数据
     *
     * @return result
     */
    protected JsonResult<Void> renderSuccess() {
        JsonResult<Void> result = getJsonResult(true);
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMsg());
        return result;
    }

    /**
     * 渲染成功数据（带信息）
     *
     * @param msg 需要返回的信息
     * @return result
     */
    protected JsonResult<Void> renderSuccess(String msg) {
        JsonResult<Void> result = getJsonResult(true);
		result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(msg);
        return result;
    }

	protected JsonResult<Void> renderSuccess(String code, String msg) {
		JsonResult<Void> result = getJsonResult(true);
		result.setCode(code);
		result.setMessage(msg);
		return result;
	}

	protected JsonResult<Void> renderSuccess(ResultCode resultCode) {
		return renderSuccess(resultCode.getCode(), resultCode.getMsg());
	}

    /**
     * 渲染成功数据（带数据）
     *
     * @param <T> t 需要返回的对象
     * @return result
     */
    protected <T> JsonResult<T> renderSuccessWithData(T t) {
        JsonResult<T> result = new JsonResult<>();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMsg());
        result.setData(t);
        result.setResponseTime(dtf.format(LocalDateTime.now()));
        return result;
    }

	/**
	 * 渲染失败数据
	 *
	 * @return result
	 */
	protected JsonResult<Void> renderError() {
		JsonResult<Void> result = getJsonResult(false);
		result.setCode(ResultCode.ERROR.getCode());
		result.setMessage(ResultCode.ERROR.getMsg());
		return result;
	}

	/**
	 * 渲染失败数据（带消息）
	 *
	 * @param msg
	 *            需要返回的消息
	 * @return result
	 */
	protected JsonResult<Void> renderError(String msg) {
		JsonResult<Void> result = getJsonResult(false);
		result.setCode(ResultCode.ERROR.getCode());
		result.setMessage(msg);
		return result;
	}

	/**
	 * 渲染失败数据（带状态码和消息）
	 *
	 * @param status 状态
	 * @param msg 消息
	 * @return result
	 */
	protected JsonResult<Void> renderError(String status, String msg) {
		JsonResult<Void> result = getJsonResult(false);
		result.setCode(status);
		result.setMessage(msg);
		return result;
	}
	
	/**
	 * 直接指定返回对象{@link ResultCode}}
	 * 
	 * @param result 错误信息对象
	 * @return result
	 */
	protected JsonResult<Void> renderError(ResultCode result) {
		return renderError(result.getCode(), result.getMsg());
	}

}
