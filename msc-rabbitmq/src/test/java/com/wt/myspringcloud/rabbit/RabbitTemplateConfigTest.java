package com.wt.myspringcloud.rabbit;

import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 文通
 * @since 2019/9/27
 */
public class RabbitTemplateConfigTest extends BaseTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 测试消息未被路由时的处理
     */
    @Test
    public void testReturnedMessage() {
        // 发送可以被路由的消息
        for (int i = 1; i <= 5; i++) {
            rabbitTemplate.convertAndSend("topicExchange", "message.vip", "vipMessage" + String.valueOf(i));
        }
        // 发送不能被路由的消息
        for (int i = 1; i <= 5; i++) {
            rabbitTemplate.convertAndSend("topicExchange", "message", "vipMessage" + String.valueOf(i));
        }
        // 发送到不存在的exchange上，导致channel关闭
        for (int i = 1; i <= 5; i++) {
            rabbitTemplate.convertAndSend("wrongExchange", "message", "vipMessage" + String.valueOf(i));
        }
    }
}
