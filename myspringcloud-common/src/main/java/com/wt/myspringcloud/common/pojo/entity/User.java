package com.wt.myspringcloud.common.pojo.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class User implements Serializable {

    private Long id;
    private String name;
    private Integer age;
    private String email;

    public User() {}

    public User(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("age", age)
                .append("email", email)
                .toString();
    }



}
