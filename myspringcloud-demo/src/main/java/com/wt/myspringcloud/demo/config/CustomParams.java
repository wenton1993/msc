package com.wt.myspringcloud.demo.config;

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
@Component
@ConfigurationProperties(prefix = "custom.wt")
public class CustomParams {

    private String id;

    private String name;

    private List<String> aList;

    private Map<String, String> aMap;

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomParams.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("name='" + name + "'")
                .add("aList=" + aList)
                .add("aMap=" + aMap)
                .toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getaList() {
        return aList;
    }

    public void setaList(List<String> aList) {
        this.aList = aList;
    }

    public Map<String, String> getaMap() {
        return aMap;
    }

    public void setaMap(Map<String, String> aMap) {
        this.aMap = aMap;
    }
}
