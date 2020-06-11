package com.wt.myspringcloud.demo.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 文通
 * @since 2020/6/11
 */
@Getter
@Setter
@ToString
@ApiModel(description = "Swagger请求参数对象")
public class SwaggerTestReq {

    @ApiModelProperty(value = "Swagger ID", required = true, example = "1024")
    private String id;

    @ApiModelProperty(value = "请求参数对象", required = false)
    private ReqTestReq reqTestReq;

}
