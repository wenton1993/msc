package com.wt.myspringcloud.demo.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wt.myspringcloud.demo.mybatis.MoneyTypeHandler;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.joda.money.Money;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author 文通
 * @since 2020/6/14
 */
@Getter
@Setter
@ToString
@TableName(schema = "local", value = "demo", autoResultMap = true)
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
     * 价格
     */
    /*@TableField("price")
    private Long price;*/
    @TableField(value = "price", typeHandler = MoneyTypeHandler.class)
    private Money price;

    /**
     * 创建日期时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
    @TableField("create_datetime")
    private LocalDateTime createDatetime;

    /**
     * 是否已删除
     */
    @TableLogic
    @TableField("delete_status")
    private Integer deleteStatus;

    /**
     * 版本号
     */
    @Version
    @TableField("version")
    private Long version;

}
