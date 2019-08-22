package com.wt.myspringcloud.common.api;

import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.pojo.entity.User;
import com.wt.myspringcloud.common.pojo.vo.UserVo;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserServiceApi {

    @GetMapping("/queryUserById")
    JsonResult<User> queryUserById(UserVo userVo);

    @PostMapping("/getUserById")
    JsonResult<User> getUserById(@RequestBody UserVo userVo);

    @PostMapping("/sendMessage")
    JsonResult sendMessage(@RequestBody UserVo userVo);
}
