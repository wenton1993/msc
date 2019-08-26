package com.wt.myspringcloud.stream.receiver;

import com.wt.myspringcloud.stream.channel.OrderProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author 文通
 * @since 2019/8/25
 */
@EnableBinding(value = {OrderProcessor.class})
public class OrderSender {

    private static Logger logger = LoggerFactory.getLogger(OrderSender.class);

    /*@Bean
    @InboundChannelAdapter(value = OrderSource.OUTPUT, poller = @Poller(fixedDelay = "10000"))
    public MessageSource<User> sendOrder() {
        return () -> new GenericMessage<>(new User(1L, "榴莲", 18));
    }

    @Bean
    @InboundChannelAdapter(value = OrderSource.OUTPUT, poller = @Poller(fixedDelay = "10000"))
    public MessageSource<User> sendOrder2() {
        return () -> new GenericMessage<>(new User(2L, "痔疮", 18));
    }*/

    /*@StreamListener(OrderSink.INPUT)
    public void receiveOrder(User user) {
        logger.info("receiveOrder: " + user.toString());
    }*/

    /*@StreamListener(OrderSink.INPUT)
    public void receiveOrder2(User user) {
        logger.info("receiveOrder2: " + user.toString());
    }*/
}
