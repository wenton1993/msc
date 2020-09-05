package com.wt.myspringcloud.reactor.runner;

import com.wt.myspringcloud.reactor.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.concurrent.CountDownLatch;

/**
 * 发布、订阅
 *
 * @author 文通
 * @since 2020/9/5
 */
@Slf4j
@Component
public class ReactiveRepositoryDemoRunner implements ApplicationRunner {

    @Autowired
    private CoffeeRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ReactiveRepositoryDemoRunner::run");
        CountDownLatch cdl = new CountDownLatch(2);
        repository
                .findAllById(Flux.just(1L, 2L))
                // .findAll()
                .map(c -> c.getName() + "-" + c.getPrice().toString())
                .doFinally(s -> cdl.countDown())
                .subscribe(c -> log.info("Find {}", c));

        repository.findByName("mocha")
                .doFinally(s -> cdl.countDown())
                .subscribe(c -> log.info("Find {}", c));

        cdl.await();
    }

}
