package com.wt.myspringcloud.user.model;

import com.wt.myspringcloud.common.pojo.entity.User;
import com.wt.myspringcloud.user.BaseTest;
import org.junit.Test;

/**
 * @author 文通
 * @since 2019/9/5
 */
public class ModelTest extends BaseTest {

    @Test
    public void testSelect() {
        System.out.println(new User().selectById(3));
    }
}
