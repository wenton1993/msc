package com.wt.myspringcloud.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 文通
 * @since 2020/5/18
 */
public class JacksonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static ObjectMapper getMapper() {
        return mapper;
    }

    public static String writeValueAsString(Object o) throws JsonProcessingException {
        return JacksonUtils.mapper.writeValueAsString(o);
    }

    public static <T> T readValue(String json, Class<T> c) throws JsonProcessingException {
        return JacksonUtils.mapper.readValue(json, c);
    }

}
