package com.wt.myspringcloud.user.controller;

import com.wt.myspringcloud.common.api.user.UserServiceApi;
import com.wt.myspringcloud.common.core.BaseController;
import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.exception.BusinessException;
import com.wt.myspringcloud.common.pojo.entity.WtUser;
import com.wt.myspringcloud.common.pojo.req.UserReq;
import com.wt.myspringcloud.user.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户管理")
@RestController
public class UserController extends BaseController implements UserServiceApi {

    @Autowired
    private UserMapper userMapper;

    @Override
    public JsonResult<WtUser> getUserById(UserReq userReq) {
        WtUser user;
        try {
            user = userMapper.queryUser();
        } catch (Exception e) {
            logger.error("获取用户信息时发生异常", e);
            return renderError("获取用户信息时发生异常");
        }
        return renderSuccessWithData(user);
    }


    @Override
    @Transactional
    public JsonResult<WtUser> queryUserById(@RequestBody UserReq userReq) {
        if (8 == userReq.getId()) {
            throw new BusinessException("queryUserById 发生异常！");
        } else if (9 == userReq.getId()) {
            throw new RuntimeException("queryUserById 发生异常！");
        }
        WtUser user;
        try {
            System.out.println("queryUserById: " + userMapper.queryUserById(userReq.getId()));
            System.out.println("queryUserById: " + userMapper.queryUserById(5L));
            System.out.println("queryUserById: " + userMapper.queryUserById(userReq.getId()));
            user = userMapper.queryUserById(userReq.getId());
        } catch (Exception e) {
            logger.error("获取用户信息时发生异常", e);
            return renderError("获取用户信息时发生异常");
        }
        return renderSuccessWithData(user);
    }
}
