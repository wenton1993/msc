package com.wt.myspringcloud.common.api.user;

import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.pojo.entity.User;
import com.wt.myspringcloud.common.pojo.req.UserReq;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserServiceApi {

    @GetMapping("/getUserById")
    JsonResult<User> getUserById(UserReq userReq);

    @PostMapping("/queryUserById")
    JsonResult<User> queryUserById(@RequestBody UserReq userReq);

    @PostMapping("/sendMessage")
    JsonResult sendMessage(@RequestBody UserReq userReq);
}
