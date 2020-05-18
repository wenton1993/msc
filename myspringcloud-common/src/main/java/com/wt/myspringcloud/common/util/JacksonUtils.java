package com.wt.myspringcloud.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 文通
 * @since 2020/5/18
 */
public class JacksonUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static ObjectMapper getMapper() {
        return mapper;
    }

}
