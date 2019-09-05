package com.wt.myspringcloud.user.controller;

import com.wt.myspringcloud.common.core.BaseController;
import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.exception.BusinessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 文通
 * @since 2019/9/2
 */
@ControllerAdvice
@RestController
public class ExceptionHandlerController extends BaseController {

    @ExceptionHandler(value = BusinessException.class)
    public JsonResult<Void> handleBusinessException() {
        return renderError("业务异常");
    }
}
