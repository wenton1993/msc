package com.wt.myspringcloud.trade.controller;

import com.wt.myspringcloud.common.core.BaseController;
import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.pojo.entity.WtUser;
import com.wt.myspringcloud.common.pojo.req.UserReq;
import com.wt.myspringcloud.trade.feign.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 文通
 * @since 2019/8/22
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private UserServiceFeign userServiceFeign;


    @PostMapping("/testQueryUserById")
    public JsonResult<WtUser> testQueryUserById(@RequestBody UserReq req) {
        return userServiceFeign.queryUserById(req);
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/testGetUserById")
    public JsonResult<WtUser> testGetUserById(@RequestBody UserReq req) {
        ResponseEntity<JsonResult> resultResponseEntity = restTemplate.getForEntity("http://user/user/getUserById?id=1", JsonResult.class);
        JsonResult<WtUser> jsonResult = resultResponseEntity.getBody();
        // getBody() 可能会返回 null，所以要进行判断
        if (Objects.nonNull(jsonResult)) {
            return jsonResult;
        }
        return renderError();
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/testGetUserById2")
    public JsonResult<WtUser> testGetUserById2(@RequestBody UserReq req) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("id", 2L);
        // 这个 paramsMap 应该是在请求体里的，不能被直接接收。所以应该直接用 restTemplate.getForEntity
        JsonResult<WtUser> jsonResult = restTemplate.getForObject("http://user/user/getUserById?id=1", JsonResult.class, paramsMap);
        // getBody() 可能会返回 null，所以要进行判断
        if (Objects.nonNull(jsonResult)) {
            return jsonResult;
        }
        return renderError();
    }
}
