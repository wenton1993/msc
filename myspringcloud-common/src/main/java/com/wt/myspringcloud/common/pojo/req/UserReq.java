package com.wt.myspringcloud.common.pojo.req;

import com.wt.myspringcloud.common.core.BaseReq;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.StringJoiner;

public class UserReq extends BaseReq {

    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    @Override
    public String toString() {
        return new StringJoiner(", ", UserReq.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
