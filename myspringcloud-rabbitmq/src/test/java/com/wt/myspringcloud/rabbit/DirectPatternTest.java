package com.wt.myspringcloud.rabbit;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 文通
 * @since 2019/9/23
 */
public class DirectPatternTest extends BaseTest {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Test
    public void publishMany() {
        for (int i = 1; i <= 10; i++) {
            rabbitTemplate.convertAndSend("helloQueue", String.valueOf(i));
        }
    }
}
