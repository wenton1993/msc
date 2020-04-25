package com.wt.myspringcloud.common.pojo.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.StringJoiner;

/**
 * 测试[接收请求参数]的对象
 */
public class TestReqRespParam implements Serializable {

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
    private Date date2;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
    private LocalDateTime localDateTime2;

    @Override
    public String toString() {
        return new StringJoiner(", ", TestReqRespParam.class.getSimpleName() + "[", "]")
                .add("date=" + date)
                .add("date2=" + date2)
                .add("localDateTime=" + localDateTime)
                .add("localDateTime2=" + localDateTime2)
                .toString();
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public LocalDateTime getLocalDateTime2() {
        return localDateTime2;
    }

    public void setLocalDateTime2(LocalDateTime localDateTime2) {
        this.localDateTime2 = localDateTime2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
