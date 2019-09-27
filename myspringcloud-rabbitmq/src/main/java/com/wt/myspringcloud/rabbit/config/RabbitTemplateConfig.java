package com.wt.myspringcloud.rabbit.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 文通
 * @since 2019/9/27
 */
@Slf4j
@Configuration
public class RabbitTemplateConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        // 当exchange没有将消息路由到队列时，调用basic.return，将消息返回给消费者
        rabbitTemplate.setMandatory(true);
        // 指定一个ConfirmCallback的实现类，处理exchange返回的路由消息到队列的结果
        rabbitTemplate.setConfirmCallback(this);
        // 指定一个ReturnCallback的实现类，处理exchange返回的路由失败的消息
        rabbitTemplate.setReturnCallback(this);
        return rabbitTemplate;
    }

    /**
     * 处理exchange返回的路由消息到队列的结果
     * @param correlationData
     * @param ack 路由消息成功或失败
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.info("消息发送到队列成功，message：{}", correlationData);
        } else {
            log.info("消息发送到队列失败，message：{}，cause：{}", correlationData, cause);
        }
    }

    /**
     * 处理exchange返回的路由失败的消息
     * @param message 路由失败的消息
     * @param replyCode RabbitMQ返回的错误代码
     * @param replyText RabbitMQ返回的错误信息
     * @param exchange 交换器
     * @param routingKey 路由键
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("未找到匹配的队列，message: {}，replyCode：{}，replyText：{}, routingKey: {}", message, replyCode, replyText, routingKey);
    }
}
