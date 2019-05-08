package com.wt.myspringcloud.common.dto;

public class QueueMessage<T> {

    private String name;
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
