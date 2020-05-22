package com.wt.myspringcloud.common.enumeration.ienum;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 产品上架状态
 *
 * @author 文通
 * @since 2020/5/20
 */
public enum PublishStatus implements IEnum<Integer> {

    OFF(0, "未上架"),
    ON(1, "上架"),
    ;

    @JsonValue
    private Integer value;

    private String desc;

    PublishStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    public String getDesc() {
        return desc;
    }
}
