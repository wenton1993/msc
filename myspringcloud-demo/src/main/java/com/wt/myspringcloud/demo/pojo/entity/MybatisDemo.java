package com.wt.myspringcloud.demo.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author 文通
 * @since 2020/6/14
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MybatisDemo {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @TableField("demo_no")
    private String demoNo;

    @TableField("cust_name")
    private String custName;

    @TableField("cust_age")
    private Integer custAge;

    @TableField("create_datetime")
    private LocalDateTime createDatetime;

    @TableLogic
    @TableField("deleted")
    private Integer deleted;

    @Version
    @TableField("version")
    private Timestamp version;
}
