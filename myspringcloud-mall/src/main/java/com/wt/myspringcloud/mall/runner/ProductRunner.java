package com.wt.myspringcloud.mall.runner;

import com.wt.myspringcloud.common.enumeration.ienum.PublishStatus;
import com.wt.myspringcloud.common.pojo.entity.Product;
import com.wt.myspringcloud.mall.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 在开发环境下，生成用于测试的商品数据
 *
 * @author 文通
 * @since 2020/5/21
 */
@Profile(value = "dev")
@Component
@Slf4j
public class ProductRunner implements ApplicationRunner {

    @Resource
    private ProductMapper productMapper;

    @Override
    public void run(ApplicationArguments args) {
        log.info("==== ProductRunner start ====");
        Product product = new Product();
        product.setPrice(100 * 100);
        product.setPublishStatus(PublishStatus.ON);
        product.setStock(1000);
        product.setSale(0);
        product.setCreateDateTime(LocalDateTime.now());
        for (int i = 1; i <= 100; i++) {
            product.setId(null);
            product.setName("榴莲" + i);
            product.setProductCategoryId(1 + i % 5);
            productMapper.insert(product);
        }
        log.info("==== ProductRunner end ====");
    }
}
