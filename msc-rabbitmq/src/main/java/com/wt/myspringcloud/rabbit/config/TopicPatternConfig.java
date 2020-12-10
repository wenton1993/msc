package com.wt.myspringcloud.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 文通
 * @since 2019/9/26
 */
@Configuration
public class TopicPatternConfig {

    private final String COMMON_CUSTOMER_QUEUE = "commonCustomerQueue";
    private final String VIP_CUSTOMER_QUEUE = "vipCustomerQueue";

    @Bean
    public Queue commonCustomerQueue() {
        return new Queue(COMMON_CUSTOMER_QUEUE);
    }

    @Bean
    public Queue vipCustomerQueue() {
        return new Queue(VIP_CUSTOMER_QUEUE);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bindingCommonCustomerQueue() {
        return BindingBuilder.bind(commonCustomerQueue()).to(topicExchange()).with("message.common");
    }

    @Bean
    public Binding bindingVipCustomerQueue() {
        return BindingBuilder.bind(vipCustomerQueue()).to(topicExchange()).with("message.*");
    }
}
