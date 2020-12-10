package com.wt.myspringcloud.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 文通
 * @since 2019/9/22
 */
@Component
@RabbitListener(queues = "helloQueue")
public class HelloConsumer2 {

    @RabbitHandler
    public void process(String message) {
        System.out.println("HelloConsumer2: " + message);
    }
}
