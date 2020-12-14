package com.wt.myspringcloud.common.api.user;

import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.pojo.entity.WtUser;
import com.wt.myspringcloud.common.pojo.req.UserReq;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public interface UserApi {

    /**
     * 测试结果：
     * 1.@ApiParam在这里不会生效，除非请求参数不是实体对象
     */
    @GetMapping("/getUserById")
    JsonResult<WtUser> getUserById(UserReq userReq);

    /**
     *
     */
    @PostMapping("/queryUserById")
    JsonResult<WtUser> queryUserById(@RequestBody UserReq userReq);
}
