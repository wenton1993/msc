package com.wt.myspringcloud.stream.controller;

import com.wt.myspringcloud.common.core.BaseController;
import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.pojo.entity.WtUser;
import com.wt.myspringcloud.stream.channel.OrderSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 文通
 * @since 2019/8/26
 */
@RestController
@RequestMapping("/sender")
public class SenderController extends BaseController {

    @Autowired
    private OrderSource orderSource;

    @PostMapping("/sendMessage")
    public JsonResult<Void> sendMessage(@RequestBody WtUser user) {
        orderSource.output().send(MessageBuilder.withPayload(user).build());
        return renderSuccess();
    }
}
