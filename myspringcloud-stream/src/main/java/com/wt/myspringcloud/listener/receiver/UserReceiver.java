package com.wt.myspringcloud.listener.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class UserReceiver {

    private final Logger logger = LoggerFactory.getLogger(UserReceiver.class);

    @StreamListener(Sink.INPUT)
    public void userListener(Object user) {
        logger.info(user.toString());
    }

}
