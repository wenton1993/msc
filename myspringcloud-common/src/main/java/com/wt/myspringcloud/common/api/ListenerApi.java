package com.wt.myspringcloud.common.api;

import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.pojo.dto.QueueMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/listener")
public interface ListenerApi {

    @PostMapping("/sendMessage")
    JsonResult sendMessage(@RequestBody QueueMessage queueMessage);

}
