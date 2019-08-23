package com.wt.myspringcloud.common.pojo.req;

import com.wt.myspringcloud.common.core.BaseReq;

import java.util.StringJoiner;

public class UserReq extends BaseReq {

    private Integer id;

    @Override
    public String toString() {
        return new StringJoiner(", ", UserReq.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
