package com.wt.myspringcloud.user.controller;

import com.wt.myspringcloud.common.api.user.UserServiceApi;
import com.wt.myspringcloud.common.core.BaseController;
import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.exception.BusinessException;
import com.wt.myspringcloud.common.feign.listener.ListenerFeign;
import com.wt.myspringcloud.common.pojo.dto.QueueMessage;
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
    @Autowired
    private ListenerFeign listenerFeign;

    @Override
    public JsonResult<User> queryUserById(@RequestBody UserReq userReq) {
        if (4 == userReq.getId()) {
            throw new BusinessException("用户模块异常");
        } else if (8 == userReq.getId()) {
            throw new BusinessException("queryUserById 发生异常！");
        } else if (9 == userReq.getId()) {
            throw new RuntimeException("queryUserById 发生异常！");
        }
        User user = null;
        try {
            user = userService.getById(userReq.getId());
        } catch (Exception e) {
            logger.error("获取用户信息时发生异常", e);
            return renderError("获取用户信息时发生异常");
        }
        return renderSuccessWithData(user);
    }

    @Override
    public JsonResult<User> getUserById(UserReq userReq) {
        User user;
        try {
            user = userService.getById(userReq.getId());
        } catch (Exception e) {
            logger.error("获取用户信息时发生异常", e);
            return renderError("获取用户信息时发生异常");
        }
        return renderSuccessWithData(user);
    }

    @Override
    public JsonResult<User> queryOne() {
        return renderSuccessWithData(userService.queryOne());
    }

    @Override
    public JsonResult<User> queryOneById(@RequestBody UserReq req) {
        return renderSuccessWithData(userService.queryOneById(req.getId()));
    }

    @Override
    public JsonResult<User> queryUserByModel() {
        return renderSuccessWithData(new User().selectById(5));
    }

    @Override
    public JsonResult sendMessage(@RequestBody UserReq userReq) {
        User user = userService.getById(userReq.getId());
        QueueMessage<User> userQueueMessage = new QueueMessage<>("USER", user);
        listenerFeign.sendMessage(userQueueMessage);
        return renderSuccess("发送队列成功");
    }
}
