package com.wt.myspringcloud.demo.pojo.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wt.myspringcloud.common.enumeration.field.PublishStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.StringJoiner;

/**
 * 测试[接收请求参数]的对象
 */
@Getter
@Setter
@ToString
@ApiModel(description = "测试请求和返回参数的对象")
public class TestReqRespParams implements Serializable {

    @ApiModelProperty(value = "ID", notes = "ID")
    @NotBlank(message = "ID不能为空")
    private String id;

    @ApiModelProperty(value = "产品上架状态")
    private PublishStatus publishStatus;

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

}
