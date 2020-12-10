package com.wt.myspringcloud.stream.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author 文通
 * @since 2019/8/25
 */
public interface OrderSource {

    String OUTPUT = "outputOrder";

    @Output(OrderSource.OUTPUT)
    MessageChannel output();
}
