package com.wt.myspringcloud.mall.runner;

import com.wt.myspringcloud.common.enumeration.ienum.PublishStatus;
import com.wt.myspringcloud.common.pojo.entity.Product;
import com.wt.myspringcloud.common.pojo.entity.ProductCategory;
import com.wt.myspringcloud.mall.mapper.ProductCategoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * 在开发环境下，生成用于测试的商品分类数据
 * 
 * @author 文通
 * @since 2020/5/21
 */
@Profile(value = "dev")
@Component
@Slf4j
public class ProductCategoryRunner implements ApplicationRunner {

    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public void run(ApplicationArguments args) {
        log.info("==== ProductRunner start ====");
        ProductCategory productCategory = new ProductCategory();
        log.info("插入一级商品分类");
        for (int i = 1; i <= 5; i++) {
            productCategory.setId(i);
            productCategory.setParentId(0);
            productCategory.setName("商品分类" + i);
            productCategory.setLevel(1);
            productCategoryMapper.insert(productCategory);
        }
        log.info("插入二级商品分类");
        for (int i = 6; i <= 20; i++) {
            productCategory.setId(i);
            productCategory.setParentId(1 + i % 4);
            productCategory.setName("商品分类" + i);
            productCategory.setLevel(2);
            productCategoryMapper.insert(productCategory);
        }
        log.info("插入三级商品分类");
        for (int i = 21; i <= 50; i++) {
            productCategory.setId(i);
            productCategory.setParentId(6 + i % 14);
            productCategory.setName("商品分类" + i);
            productCategory.setLevel(3);
            productCategoryMapper.insert(productCategory);
        }
        log.info("==== ProductRunner end ====");
    }
}
