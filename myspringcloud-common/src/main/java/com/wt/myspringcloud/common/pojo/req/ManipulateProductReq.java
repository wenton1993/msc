package com.wt.myspringcloud.common.pojo.req;

import com.wt.myspringcloud.common.enumeration.ienum.PublishStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author 文通
 * @since 2020/5/21
 */
@Getter
@Setter
@ToString
@ApiModel(description = "操作产品的请求对象")
public class ManipulateProductReq implements Serializable {

    @ApiModelProperty(value = "商品ID")
    private String id;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "上架状态：0-未上架 1-上架")
    private PublishStatus publishStatus;

    @ApiModelProperty(value = "商品价格(分)")
    private Integer price;

    @ApiModelProperty(value = "库存")
    private Integer stock;

    @ApiModelProperty(value = "销量")
    private Integer sale;

}
