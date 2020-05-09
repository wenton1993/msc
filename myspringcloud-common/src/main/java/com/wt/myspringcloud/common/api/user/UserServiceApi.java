package com.wt.myspringcloud.common.api.user;

import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.pojo.entity.WtUser;
import com.wt.myspringcloud.common.pojo.req.UserReq;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
public interface UserServiceApi {

    /**
     * 测试结果：
     *   1.@ApiParam在这里不会生效，除非请求参数不是实体对象
     */
    @ApiOperation(value = "根据ID获取用户信息", httpMethod = "GET")
    @GetMapping("/getUserById")
    JsonResult<WtUser> getUserById(@ApiParam("查询用户参数对象") UserReq userReq);

    /**
     *
     */
    @ApiOperation(value = "根据ID获取用户信息", notes = "ID不能为空", httpMethod = "POST")
    @PostMapping("/queryUserById")
    JsonResult<WtUser> queryUserById(@ApiParam("查询用户参数对象") @RequestBody UserReq userReq);
}
