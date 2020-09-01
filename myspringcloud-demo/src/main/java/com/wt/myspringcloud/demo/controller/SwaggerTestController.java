package com.wt.myspringcloud.demo.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.wt.myspringcloud.demo.pojo.req.SwaggerDemoReq;
import com.wt.myspringcloud.demo.pojo.resp.SwaggerDemoResp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 文通
 * @since 2020/6/11
 */
@RestController
@Api(tags = "Swagger测试")
@RequestMapping("/swaggerTest")
public class SwaggerTestController {

    @ApiOperation(value = "测试", notes = "仅供测试")
    @PostMapping("/testForm")
    public R<SwaggerDemoResp> testForm(SwaggerDemoReq req) {
        SwaggerDemoResp resp = new SwaggerDemoResp();
        BeanUtils.copyProperties(req, resp);
        return R.ok(resp);
    }

    @ApiOperation(value = "测试", notes = "仅供测试")
    @PostMapping("/testJson")
    public R<SwaggerDemoResp> testJson(@RequestBody SwaggerDemoReq req) {
        SwaggerDemoResp resp = new SwaggerDemoResp();
        BeanUtils.copyProperties(req, resp);
        return R.ok(resp);
    }

}
