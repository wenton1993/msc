package com.wt.myspringcloud.common.api.user;

import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.pojo.entity.User;
import com.wt.myspringcloud.common.pojo.req.UserReq;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RequestMapping("/user")
public interface UserServiceApi {

    @GetMapping("/getUserById")
    JsonResult<User> getUserById(UserReq userReq);

    @PostMapping("/queryUserById")
    JsonResult<User> queryUserById(@RequestBody UserReq userReq);

    @PostMapping("/queryOne")
    JsonResult<User> queryOne();

    @PostMapping("/queryOneById")
    JsonResult<User> queryOneById(@RequestBody UserReq req);

    @PostMapping("/queryUserByModel")
    JsonResult<User> queryUserByModel();

    @PostMapping("/sendMessage")
    JsonResult sendMessage(@RequestBody UserReq userReq);
}
