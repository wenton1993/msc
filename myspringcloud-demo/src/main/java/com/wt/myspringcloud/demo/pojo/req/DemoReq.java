package com.wt.myspringcloud.demo.pojo.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wt.myspringcloud.common.enumeration.field.PublishStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 总结：
 * 1. @DateTimeFormat 用于接收表单格式的请求参数
 * 2. @JsonFormat 用于接收JSON格式的请求参数
 */
@Getter
@Setter
@ToString
@ApiModel(description = "请求参数对象")
public class DemoReq {

    @ApiModelProperty(value = "请求ID", required = true, example = "1024")
    private String id;

    @ApiModelProperty(value = "上架状态", allowableValues = "0, 1")
    private PublishStatus publishStatus;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date formDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
    private Date JsonDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime formLocalDateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
    private LocalDateTime JsonLocalDateTime;

}