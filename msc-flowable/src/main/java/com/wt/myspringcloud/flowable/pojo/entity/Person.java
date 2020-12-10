package com.wt.myspringcloud.flowable.pojo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author 文通
 * @since 2020/6/9
 */
@Getter
@Setter
@ToString
public class Person {

    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private Date birthDate;

}
