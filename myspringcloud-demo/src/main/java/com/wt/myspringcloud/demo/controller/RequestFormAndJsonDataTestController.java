package com.wt.myspringcloud.demo.controller;

import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.demo.pojo.req.DemoReq;
import com.wt.myspringcloud.demo.pojo.resp.DemoResp;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试[接收请求参数]
 * 总结：
 * 1.@DateTimeFormat 只能用于序列化和反序列化 url 和 表单数据中的时间信息
 * 2.@JsonFormat 只能用于序列化和反序列化请求体中 JSON 格式的时间信息
 */
@RestController
@RequestMapping("/requestFormAndJsonDataTest")
public class RequestFormAndJsonDataTestController {

    /**
     * 测试使用 @RequestParam 接收请求体中的参数
     * 测试结果：
     * 1. @DateTimeFormat 可以反序列化时间信息到 Date 或 LocalDateTime
     * 2. @DateTimeFormat 可以对 Date 或 LocalDateTime 进行序列化
     * 3. @JsonFormat 无法反序列化时间信息到 Date 或 LocalDateTime
     */
    @PostMapping("/testRequestFormData")
    public JsonResult<DemoResp> testRequestFormData(DemoReq req) {
        System.out.println(req.getFormDate());
        System.out.println(req.getJsonDate());
        System.out.println(req.getFormLocalDateTime());
        System.out.println(req.getJsonLocalDateTime());
        DemoResp resp = new DemoResp();
        BeanUtils.copyProperties(req, resp);
        return JsonResult.success(resp);
    }

    /**
     * 测试使用 @RequestBody 接收请求体中的参数
     * 测试结果：
     * 1. @DateTimeFormat 无法反序列化时间信息到 Date 或 LocalDateTime
     * 2. @JsonFormat 可以按格式序列化请求体中的 String 类型的时间
     * 3. @JsonFormat 可以将 Date 和 LocalDateTime 按格式反序列化成 String
     */
    @PostMapping("/testRequestJsonData")
    public JsonResult<DemoResp> testRequestJsonData(@RequestBody DemoReq req) {
        System.out.println(req.getFormDate());
        System.out.println(req.getJsonDate());
        System.out.println(req.getFormLocalDateTime());
        System.out.println(req.getJsonLocalDateTime());
        DemoResp resp = new DemoResp();
        BeanUtils.copyProperties(req, resp);
        return JsonResult.success(resp);
    }

}
