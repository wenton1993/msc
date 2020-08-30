package com.wt.myspringcloud.common.util;

import com.baomidou.mybatisplus.core.toolkit.Sequence;

/**
 * @author 文通
 * @since 2020/8/30
 */
public class SequenceUtils {

    private static final Sequence sequence = new Sequence();

    public static long nextId() {
        return sequence.nextId();
    }

}
