package com.wt.myspringcloud.mall.mapper;

import com.wt.myspringcloud.mall.MallApplicationTests;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author 文通
 * @since 2020/5/21
 */
public class ProductMapperTests extends MallApplicationTests {

    @Resource
    private ProductMapper productMapper;

    @Test
    public void testQueryAllProduct() {
        System.out.println(productMapper.selectList(null));
    }

}
