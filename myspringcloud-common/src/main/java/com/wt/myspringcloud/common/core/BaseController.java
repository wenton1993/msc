package com.wt.myspringcloud.common.core;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;

public class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 渲染成功数据
     *
     * @return result
     */
    protected JsonResult renderSuccess() {
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setResponseTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        return result;
    }

    /**
     * 渲染成功数据（带信息）
     *
     * @param msg 需要返回的信息
     * @return result
     */
    protected JsonResult renderSuccess(String msg) {
        JsonResult result = renderSuccess();
        result.setMessage(msg);
        result.setResponseTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        return result;
    }

    /**
     * 渲染成功数据（带数据）
     *
     * @param <T> t 需要返回的对象
     * @return result
     */
    protected <T> JsonResult<T> renderSuccessWithData(T t) {
        JsonResult<T> result = this.renderSuccess();
        result.setData(t);
        result.setResponseTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        return result;
    }

	/**
	 * 渲染失败数据
	 *
	 * @return result
	 */
	protected JsonResult renderError() {
		JsonResult result = new JsonResult();
		result.setSuccess(false);
		result.setCode(ResultCode.ERROR.getCode());
		result.setResponseTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
		return result;
	}

	/**
	 * 渲染失败数据（带消息）
	 *
	 * @param msg
	 *            需要返回的消息
	 * @return result
	 */
	protected JsonResult renderError(String msg) {
		JsonResult result = renderError();
		result.setMessage(msg);
		result.setResponseTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
		return result;
	}

	/**
	 * 渲染失败数据（带状态码和消息）
	 *
	 * @param status
	 * @param msg
	 * @return result
	 */
	protected JsonResult renderError(String status, String msg) {
		JsonResult result = new JsonResult();
		result.setSuccess(false);
		result.setCode(status);
		result.setMessage(msg);
		result.setResponseTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
		return result;
	}
	
	/**
	 * 直接指定返回对象{@link ResultCode}}
	 * 
	 * @param result 错误信息对象
	 * @return result
	 */
	protected JsonResult renderError(ResultCode result) {
		return renderError(result.getCode(), result.getMsg());
	}

}
