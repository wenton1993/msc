package com.wt.myspringcloud.user.pojo;

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

    @TableId
    private Long id;
    @TableField("user_id")
    private Integer userId;

    @Override
    public String toString() {
        return new StringJoiner(", ", WtOrder.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userId=" + userId)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
