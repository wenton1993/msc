package com.wt.myspringcloud.listener.listener;

import com.alibaba.fastjson.JSON;
import com.wt.myspringcloud.common.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "USER")
public class UserListener {

    private final Logger logger = LoggerFactory.getLogger(UserListener.class);

    @RabbitHandler
    public void userListener(String message) {
        logger.info(message);
        User user = JSON.parseObject(message, User.class);
        logger.info(user.toString());
    }

}
