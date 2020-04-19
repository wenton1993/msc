package com.wt.myspringcloud.user.pojo;

import java.util.List;
import java.util.StringJoiner;

/**
 * 用户和订单信息
 * 测试Mybatis嵌套查询
 *
 * @author 文通
 * @since 2020/4/18
 */
public class UserOrder {

    private Long id;
    private String name;
    private Integer amount;
    private List<WtOrder> orders;

    @Override
    public String toString() {
        return new StringJoiner(", ", UserOrder.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("amount=" + amount)
                .add("orders=" + orders)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<WtOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<WtOrder> orders) {
        this.orders = orders;
    }
}
