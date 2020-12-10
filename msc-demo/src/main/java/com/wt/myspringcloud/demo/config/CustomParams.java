package com.wt.myspringcloud.demo.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * 接收YAML中自定义的属性
 *
 * @author 文通
 * @since 2020/5/19
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "custom.wt")
public class CustomParams {

    private String id;

    private String name;

    private List<String> aList;

    private Map<String, String> aMap;

}
