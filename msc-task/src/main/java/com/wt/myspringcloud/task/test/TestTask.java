package com.wt.myspringcloud.task.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author 文通
 * @since 2020/9/7
 */
@Slf4j
@Component
public class TestTask {

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("现在时间:", LocalDateTime.now());
    }

}
