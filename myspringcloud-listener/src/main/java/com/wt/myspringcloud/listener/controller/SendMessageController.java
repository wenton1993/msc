package com.wt.myspringcloud.listener.controller;

import com.alibaba.fastjson.JSON;
import com.wt.myspringcloud.common.api.ListenerApi;
import com.wt.myspringcloud.common.core.BaseController;
import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.pojo.dto.QueueMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController extends BaseController implements ListenerApi {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public JsonResult sendMessage(@RequestBody QueueMessage queueMessage) {
        String name = queueMessage.getName();
        Object message = queueMessage.getMessage();
        this.amqpTemplate.convertAndSend(name, JSON.toJSONString(message));
        return renderSuccess("发送队列成功");
    }

}
