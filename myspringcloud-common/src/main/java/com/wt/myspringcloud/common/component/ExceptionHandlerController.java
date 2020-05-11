package com.wt.myspringcloud.common.component;

import com.wt.myspringcloud.common.core.BaseController;
import com.wt.myspringcloud.common.core.CommonResultCode;
import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

/**
 * 异常统一处理类 *
 * 
 * @author xiaoh
 * @create 2018-09-10 9:40
 */
@ControllerAdvice
public class ExceptionHandlerController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

    /**
     * [JSR-303 参数检查]
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public JsonResult<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error("参数错误:{}", e.getBindingResult().getFieldError().getDefaultMessage());
        return renderError(CommonResultCode.PARAM_ERROR.getCode(), e.getBindingResult().getFieldError().getDefaultMessage());

    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public JsonResult<?> handleApplicationException(BusinessException e) {
        logger.error(e.getMessage(), e);
        return renderError(e.getCode(), e.getMessage());
    }
    
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult<?> handleException(Exception e, HandlerMethod handlerMethod) {

        logger.error(e.getMessage(), e);
        return renderError("网络繁忙，请稍后再试");
    }


}
