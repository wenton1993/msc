package com.wt.myspringcloud.stream.receiver;

import com.wt.myspringcloud.common.pojo.entity.WtUser;
import com.wt.myspringcloud.stream.channel.OrderProcessor;
import com.wt.myspringcloud.stream.channel.OrderSink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author 文通
 * @since 2019/8/25
 */
@EnableBinding(value = {OrderProcessor.class})
public class OrderSender {
    private static Logger logger = LoggerFactory.getLogger(OrderSender.class);

    /*@Bean
    @InboundChannelAdapter(value = OrderSource.OUTPUT, poller = @Poller(fixedDelay = "5000"))
    public MessageSource<User> sendOrder() {
        return () -> new GenericMessage<>(new User(1L, "榴莲", 18));
    }*/

    /*@Bean
    @InboundChannelAdapter(value = OrderSource.OUTPUT, poller = @Poller(fixedDelay = "10000"))
    public MessageSource<User> sendOrder2() {
        return () -> new GenericMessage<>(new User(2L, "痔疮", 18));
    }*/

    @StreamListener(OrderSink.INPUT)
    public void receiveOrder(WtUser user) {
        logger.info("receiveOrder: " + user.toString());
        throw new RuntimeException("RuntimeException: receiveOrder");
    }

    /*@StreamListener(OrderSink.INPUT)
    public void receiveOrder2(User user) {
        logger.info("receiveOrder2: " + user.toString());
    }*/

    /**
     * Note:
     *   inputChannel = <destination>.<group>.error
     *   group未指定时，不能使用这种错误处理方式
     */
    /*@ServiceActivator(inputChannel = "order.order.errors")
    public void error(Message<?> message) {
        // 这里的message应该是一个请求对象，而不是User
        System.out.println("Handling ERROR: " + message.getPayload());
    }*/
}
