package com.wt.myspringcloud.rabbit;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 文通
 * @since 2019/9/23
 */
public class TopicPatternTest extends BaseTest {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Test
    public void publishMany() {
        for (int i = 1; i <= 5; i++) {
            rabbitTemplate.convertAndSend("topicExchange", "message.vip", "vipMessage" + String.valueOf(i));
        }
        for (int i = 1; i <= 5; i++) {
            rabbitTemplate.convertAndSend("topicExchange", "message", "message" + String.valueOf(i));
        }
    }
}
