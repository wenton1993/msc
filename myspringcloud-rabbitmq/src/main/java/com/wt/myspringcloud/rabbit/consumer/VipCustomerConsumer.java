package com.wt.myspringcloud.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 文通
 * @since 2019/9/26
 */
@Component
@RabbitListener(queues = "vipCustomerQueue")
public class VipCustomerConsumer {

    @RabbitHandler
    public void process(String message) {
        System.out.println("vipCustomerQueue: " + message);
    }
}
