package com.wt.myspringcloud.common.dto;

import io.swagger.annotations.ApiModelProperty;

public class QueueMessage<T> {

    @ApiModelProperty("队列名称")
    private String name;
    @ApiModelProperty("队列消息内容对象")
    private T message;

    public QueueMessage() {}

    public QueueMessage(String name, T message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

}
