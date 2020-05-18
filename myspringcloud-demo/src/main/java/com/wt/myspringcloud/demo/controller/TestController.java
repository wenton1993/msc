package com.wt.myspringcloud.demo.controller;

import com.wt.myspringcloud.common.core.BaseController;
import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.pojo.entity.WtUser;
import org.springframework.web.bind.annotation.*;

/**
 * 测试 @RequestParam 与 @RequestBody
 *
 * @author 文通
 * @since 2020/4/21
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    /**
     * 测试使用 @RequestParam 接收 POST 请求中的表单数据
     * 测试结果：
     *   1.可以接收查询参数和表单数据
     * 备注：
     *   1.POST 请求会将表单数据，以 application/x-www-form-urlencoded 的格式发送给服务器
     */
    @PostMapping("/testPostRequestParam")
    public JsonResult<Void> testPostRequestParam(Long userId,
                                                 @RequestParam(value = "name", required = false) String userName,
                                                 @RequestParam(value = "demo", required = false) WtUser user) {
        System.out.println("End");
        return renderSuccess();
    }

    /**
     * 测试利用 @RequestParam 接收 GET 请求中的查询参数
     * 测试结果：
     *   1.可以接收查询参数和表单数据
     * 备注：
     *   1. GET 请求会将表单数据，以键值对的形式附在 url 的 ? 后面发送给服务器
     */
    @GetMapping(path = "/testGetRequestParam", produces = "application/json")
    public JsonResult<Void> testGetRequestParam(Long userId,
                                                @RequestParam(value = "name", required = false) String userName,
                                                @RequestParam(value = "demo", required = false) WtUser user) {
        System.out.println("End");
        return renderSuccess();
    }

    /**
     * 测试利用 @RequestBody 接收 POST 请求中的 JSON 数据
     */
    @PostMapping(value = "/testRequestBody", consumes = "application/json")
    public JsonResult<Void> testRequestBody(@RequestBody WtUser user) {
        System.out.println("End");
        return renderSuccess();
    }
}
