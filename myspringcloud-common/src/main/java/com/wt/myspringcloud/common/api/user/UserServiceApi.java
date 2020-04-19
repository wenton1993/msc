package com.wt.myspringcloud.common.api.user;

import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.pojo.entity.WtUser;
import com.wt.myspringcloud.common.pojo.req.UserReq;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserServiceApi {

    @GetMapping("/getUserById")
    JsonResult<WtUser> getUserById(UserReq userReq);

    @PostMapping("/queryUserById")
    JsonResult<WtUser> queryUserById(@RequestBody UserReq userReq);
}
