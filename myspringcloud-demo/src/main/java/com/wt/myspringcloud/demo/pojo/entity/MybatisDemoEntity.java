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
@NoArgsConstructor
@AllArgsConstructor
@TableName("mybatis_demo_entity")
public class MybatisDemoEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_UUID)
    @NotEmpty(message = "主键不能为空", groups = {Update.class})
    private String id;

    /**
     * 编号
     */
    @TableField("demo_no")
    @NotEmpty(message = "编号不能为空", groups = {Insert.class})
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
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

    // 非数据库字段
    /**
     * 最小创建日期时间
     */
    @TableField(exist = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
    private LocalDateTime minCreateDatetime;

    @TableField(exist = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
    private LocalDateTime maxCreateDatetime;

}
