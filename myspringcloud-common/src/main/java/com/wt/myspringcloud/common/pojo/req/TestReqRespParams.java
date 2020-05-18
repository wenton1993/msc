package com.wt.myspringcloud.common.pojo.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.StringJoiner;

/**
 * 测试[接收请求参数]的对象
 */
@ApiModel(description = "测试请求和返回参数的对象")
public class TestReqRespParams implements Serializable {

    @ApiModelProperty(value = "ID", notes = "ID")
    @NotBlank(message = "ID不能为空")
    private String id;

    @ApiModelProperty(value = "Date类型的参数字段")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    @ApiModelProperty(value = "Date类型的参数字段")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
    private Date date2;

    @ApiModelProperty(value = "LocalDateTime类型的参数字段")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime localDateTime;

    @ApiModelProperty(value = "LocalDateTime类型的参数字段")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
    private LocalDateTime localDateTime2;

    @Override
    public String toString() {
        return new StringJoiner(", ", TestReqRespParams.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("date=" + date)
                .add("date2=" + date2)
                .add("localDateTime=" + localDateTime)
                .add("localDateTime2=" + localDateTime2)
                .toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
