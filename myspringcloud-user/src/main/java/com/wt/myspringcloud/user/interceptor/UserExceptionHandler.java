package com.wt.myspringcloud.user.interceptor;

import com.wt.myspringcloud.common.core.BaseController;
import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.exception.UserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class UserExceptionHandler extends BaseController {

    @ExceptionHandler(value = UserException.class)
    public JsonResult handleUserException(@RequestBody UserException e) {
        logger.error(e.getMessage(), e);
        return renderError("用户模块发生异常");
    }
}
