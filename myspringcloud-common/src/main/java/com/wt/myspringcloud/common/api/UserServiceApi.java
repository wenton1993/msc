package com.wt.myspringcloud.common.api;

import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.entity.User;
import com.wt.myspringcloud.common.vo.UserVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface UserServiceApi {

    @PostMapping("/getUserById")
    JsonResult<User> getUserById(UserVo userVo);

    @PostMapping("/sendMessage")
    JsonResult sendMessage(@RequestBody UserVo userVo);
}
