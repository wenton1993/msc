package com.wt.myspringcloud.demo.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wt.myspringcloud.demo.validation.type.Insert;
import com.wt.myspringcloud.demo.validation.type.Update;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author 文通
 * @since 2020/6/14
 */
@Getter
@Setter
@ToString
@TableName(schema = "local", value = "demo")
public class Demo {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
    private LocalDateTime createDatetime;

    /**
     * 是否已删除
     */
    @TableLogic
    @TableField("delete_status")
    private Integer delete_status;

    /**
     * 版本号
     */
    @Version
    @TableField("version")
    private Long version;

}
