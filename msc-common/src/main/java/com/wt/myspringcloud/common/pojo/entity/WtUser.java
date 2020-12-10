package com.wt.myspringcloud.common.pojo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class WtUser implements Serializable {

    private Long id;
    private String name;
    private Integer age;
    private String email;

}
