package com.wt.myspringcloud.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * 订单实体
 * 测试Mybatis嵌套查询
 *
 * @author 文通
 * @since 2020/4/18
 */
@TableName(value = "wt_order")
public class WtOrder implements Serializable{

    @TableId("id")
    private Long id;

    @TableField("user_id")
    private Long userId;

    @TableField("amount")
    private Long amount;

    @Override
    public String toString() {
        return new StringJoiner(", ", WtOrder.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userId=" + userId)
                .add("amount=" + amount)
                .toString();
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
