package com.wt.myspringcloud.common.constant;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 * @author 文通
 * @since 2019/6/16
 */
public enum RandomName {

    Alex, Alice, Alison,
    Bache, Bella,
    Carol, Cassie, Cristina,
    Dan, Daniel
    ;

    private static final List<RandomName> NAME_LIST = Arrays.asList(values());
    // 获取一个随机的名字
    public static RandomName getRandomName()  {
        return NAME_LIST.get(RandomUtils.nextInt(0, NAME_LIST.size()));
    }

    public static void main(String[] args) {
        // 测试
        for (int i = 0; i < 100; i++) {
            System.out.println(getRandomName());
        }
    }
}
