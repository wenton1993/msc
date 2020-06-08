package com.wt.myspringcloud.demo.mybatis;

import com.wt.myspringcloud.demo.BaseTest;
import com.wt.myspringcloud.demo.mapper.DemoMapper;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 文通
 * @since 2020/6/8
 */
public class DemoTest extends BaseTest {

    @Resource
    private DemoMapper demoMapper;

    /**
     * 测试[foreach]
     */
    @Test
    public void testForeach() {
        List<String> nameList = new ArrayList<>();
        nameList.add("Tom");
        nameList.add("Billie");
        nameList.add("Jone");
        demoMapper.testForeach(nameList);
        System.out.println("end");
    }

}
