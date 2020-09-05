package com.wt.myspringcloud.reactor.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * 响应式访问数据库
 *
 * @author 文通
 * @since 2020/9/4
 */
@Slf4j
@Component
public class ReactorDemoRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ReactorDemoRunner::run");
        Flux.range(1, 6)
                .doOnRequest(n -> log.info("Request {} number", n)) // 注意顺序造成的区别
                .publishOn(Schedulers.elastic())
                .doOnComplete(() -> log.info("Publisher COMPLETE 1"))
                .map(i -> {
                    log.info("Publish {}, {}", Thread.currentThread(), i);
                    // return 10 / (i - 3);
                    return i;
                })
                .doOnComplete(() -> log.info("Publisher COMPLETE 2"))
                .subscribeOn(Schedulers.single())
                // .onErrorResume(e -> {
                // 	log.error("Exception {}", e.toString());
                // 	return Mono.just(-1);
                // })
                // 发生异常时执行, 并且不会抛出异常到订阅者
                .onErrorReturn(-1)
                .subscribe(i -> log.info("Subscribe {}: {}", Thread.currentThread(), i),
                        e -> log.error("error {}", e.toString()),
                        () -> log.info("Subscriber COMPLETE"),
                        s -> s.request(4)
                );
        Thread.sleep(2000);

    }

}
