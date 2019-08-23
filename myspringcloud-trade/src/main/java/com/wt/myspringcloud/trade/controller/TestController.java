package com.wt.myspringcloud.trade.controller;

import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.feign.user.UserServiceFeign;
import com.wt.myspringcloud.common.pojo.entity.User;
import com.wt.myspringcloud.common.pojo.req.UserReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 文通
 * @since 2019/8/22
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private UserServiceFeign userServiceFeign;

    @PostMapping("/testQueryUserById")
    public JsonResult<User> testQueryUserById(@RequestBody UserReq req) {
        return userServiceFeign.queryUserById(req);
    }
}
