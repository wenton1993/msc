package com.wt.myspringcloud.common.pojo.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.myspringcloud.common.enumeration.field.PublishStatus;
import com.wt.myspringcloud.common.pojo.entity.Product;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 文通
 * @since 2020/5/21
 */
@Getter
@Setter
@ToString
@ApiModel(description = "操作产品的请求对象")
public class ProductReq implements Serializable {

    @ApiModelProperty(value = "商品ID")
    private String id;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "上架状态：0-未上架 1-上架")
    private PublishStatus publishStatus;

    @ApiModelProperty(value = "商品价格(分)", example = "100")
    private Integer price;

    @ApiModelProperty(value = "库存", example = "100")
    private Integer stock;

    @ApiModelProperty(value = "销量", example = "100")
    private Integer sale;

    @ApiModelProperty(value = "分页参数对象")
    Page<Product> page;

}
