package com.wt.myspringcloud.stream.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author 文通
 * @since 2019/8/25
 */
public interface OrderSink {

    String INPUT = "inputOrder";

    @Input(OrderSink.INPUT)
    SubscribableChannel input();
}
