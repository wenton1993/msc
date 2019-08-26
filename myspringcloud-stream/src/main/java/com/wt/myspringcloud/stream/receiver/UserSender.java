package com.wt.myspringcloud.stream.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;

/**
 * @author 文通
 * @since 2019/8/25
 */
@EnableBinding(value = {Processor.class})
public class UserSender {
    private static Logger logger = LoggerFactory.getLogger(UserSender.class);

    /*@Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "10000"))
    public MessageSource<User> sendUser() {
        return () -> new GenericMessage<>(new User(1L, "保罗", 18));
    }*/

    /*@Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "10000"))
    public MessageSource<User> sendUser2() {
        return () -> new GenericMessage<>(new User(1L, "戴安娜", 18));
    }*/

    /*@StreamListener(Sink.INPUT)
    public void receiveUser(User user) {
        logger.info("receiveUser: " + user.toString());
    }*/

    /*@StreamListener(Sink.INPUT)
    public void receiveUser2(User user) {
        logger.info("receiveUser2: " + user.toString());
    }*/
}
