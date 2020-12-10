package com.wt.myspringcloud.common.pojo.req;

import com.wt.myspringcloud.common.core.BaseReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.StringJoiner;

@ApiModel(description = "查询用户参数")
public class UserReq extends BaseReq {

    @ApiModelProperty(value = "用户ID", example = "1")
    private long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    @Override
    public String toString() {
        return new StringJoiner(", ", UserReq.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("dateTime=" + dateTime)
                .toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
