package com.wt.myspringcloud.user.controller;

import com.wt.myspringcloud.common.api.UserServiceApi;
import com.wt.myspringcloud.common.core.BaseController;
import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.pojo.dto.QueueMessage;
import com.wt.myspringcloud.common.pojo.entity.User;
import com.wt.myspringcloud.common.exception.UserException;
import com.wt.myspringcloud.common.feign.ListenerFeign;
import com.wt.myspringcloud.common.pojo.vo.UserVo;
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
    public JsonResult<User> getUserById(@RequestBody UserVo userVo) {
        if (4 == userVo.getId()) {
            throw new UserException("用户模块异常");
        }
        User user = null;
        try {
            user = userService.getById(userVo.getId());
        } catch (Exception e) {
            logger.error("获取用户信息时发生异常", e);
            return renderError("获取用户信息时发生异常");
        }
        return renderSuccessWithData(user);
    }

    @Override
    public JsonResult sendMessage(@RequestBody UserVo userVo) {
        User user = userService.getById(userVo.getId());
        QueueMessage<User> userQueueMessage = new QueueMessage<>("USER", user);
        listenerFeign.sendMessage(userQueueMessage);
        return renderSuccess("发送队列成功");
    }

}
