package com.wt.myspringcloud.demo.pojo.resp;

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
public class SwaggerTestResp {

    @ApiModelProperty(value = "Swagger ID", required = true, example = "1024")
    private String id;

    @ApiModelProperty(value = "返回字段对象", required = false)
    private RespTestResp respTestResp;

}
