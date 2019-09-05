package com.wt.myspringcloud.user.controller;

import com.wt.myspringcloud.common.api.user.UserServiceApi;
import com.wt.myspringcloud.common.core.BaseController;
import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.exception.BusinessException;
import com.wt.myspringcloud.common.pojo.entity.User;
import com.wt.myspringcloud.common.pojo.req.UserReq;
import com.wt.myspringcloud.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BaseController implements UserServiceApi {

    @Autowired
    private UserService userService;

    @Override
    public JsonResult<User> getUserById(UserReq userReq) {
        User user;
        try {
            user = userService.queryUser();
        } catch (Exception e) {
            logger.error("获取用户信息时发生异常", e);
            return renderError("获取用户信息时发生异常");
        }
        return renderSuccessWithData(user);
    }

    @Override
    public JsonResult<User> queryUserById(@RequestBody UserReq userReq) {
        if (8 == userReq.getId()) {
            throw new BusinessException("queryUserById 发生异常！");
        } else if (9 == userReq.getId()) {
            throw new RuntimeException("queryUserById 发生异常！");
        }
        User user;
        try {
            user = userService.queryUserById(userReq.getId());
        } catch (Exception e) {
            logger.error("获取用户信息时发生异常", e);
            return renderError("获取用户信息时发生异常");
        }
        return renderSuccessWithData(user);
    }
}
