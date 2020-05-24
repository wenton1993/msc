package com.wt.myspringcloud.common.component;

import com.wt.myspringcloud.common.enumeration.result.CommonResultCode;
import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.exception.BusinessException;
import com.wt.myspringcloud.common.util.JsonResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常统一处理类 *
 *
 * @author xiaoh
 * @create 2018-09-10 9:40
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    /**
     * [JSR-303 参数检查]
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public JsonResult<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("参数错误:{}", e.getBindingResult().getFieldError().getDefaultMessage());
        return JsonResultUtils.fail(CommonResultCode.PARAM_ERROR.getCode(), e.getBindingResult().getFieldError().getDefaultMessage());

    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public JsonResult<?> handleApplicationException(BusinessException e) {
        log.error(e.getMessage(), e);
        return JsonResultUtils.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult<?> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return JsonResultUtils.fail(CommonResultCode.ERROR);
    }

}
