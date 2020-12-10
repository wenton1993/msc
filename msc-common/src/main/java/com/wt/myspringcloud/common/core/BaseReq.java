package com.wt.myspringcloud.common.core;

import io.swagger.annotations.ApiModelProperty;

import java.util.StringJoiner;

public class BaseReq {

    @ApiModelProperty(value = "客户号", example = "1")
    private String custNo;

    @Override
    public String toString() {
        return new StringJoiner(", ", BaseReq.class.getSimpleName() + "[", "]")
                .add("custNo='" + custNo + "'")
                .toString();
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }
}