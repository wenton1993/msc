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
@TableName("mybatis_demo_entity")
public class MybatisDemoEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 编号
     */
    @TableField("demo_no")
    private String demoNo;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 创建日期时间
     */
    @TableField("create_datetime")
    private LocalDateTime createDatetime;

    /**
     * 是否已删除
     */
    @TableLogic
    @TableField("deleted")
    private Integer deleted;

    /**
     * 版本号
     */
    @Version
    @TableField("version")
    private Timestamp version;
}
