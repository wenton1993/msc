package com.wt.myspringcloud.demo.pojo.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wt.myspringcloud.common.enumeration.field.PublishStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author 文通
 * @since 2020/6/11
 */
@Getter
@Setter
@ToString
@ApiModel(description = "响应结果对象")
public class DemoResp {

    @ApiModelProperty(value = "请求ID")
    private String id;

    private PublishStatus publishStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date formDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
    private Date JsonDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime formLocalDateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
    private LocalDateTime JsonLocalDateTime;

    @ApiModelProperty(value = "当前日期时间(Date)")
    private Date currentDate = new Date();

    @ApiModelProperty(value = "当前日期时间(LocalDateTime)")
    private LocalDateTime localDateTime = LocalDateTime.now();
}
