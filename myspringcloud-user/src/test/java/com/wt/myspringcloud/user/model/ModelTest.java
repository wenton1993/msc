package com.wt.myspringcloud.user.model;

import com.wt.myspringcloud.common.pojo.entity.User;
import com.wt.myspringcloud.user.BaseTester;
import org.junit.Test;

/**
 * @author 文通
 * @since 2019/9/5
 */
public class ModelTest extends BaseTester {

    @Test
    public void testSelect() {
        System.out.println(new User().selectById(3));
    }
}
