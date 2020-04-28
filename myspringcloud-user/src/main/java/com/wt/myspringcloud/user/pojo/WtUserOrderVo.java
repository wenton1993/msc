package com.wt.myspringcloud.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

/**
 * 用户和订单信息
 * 测试Mybatis嵌套查询
 *
 * @author 文通
 * @since 2020/4/18
 */
@ApiModel("用户订单信息")
public class WtUserOrderVo implements Serializable {

    @ApiModelProperty("用户ID")
    private Long userId;
    @ApiModelProperty("用户姓名")
    private String name;
    @ApiModelProperty("用户订单")
    private List<WtOrder> orders;

    @Override
    public String toString() {
        return new StringJoiner(", ", WtUserOrderVo.class.getSimpleName() + "[", "]")
                .add("id=" + userId)
                .add("name='" + name + "'")
                .add("orders=" + orders)
                .toString();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WtOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<WtOrder> orders) {
        this.orders = orders;
    }
}
