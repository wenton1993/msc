package com.wt.myspringcloud.common.pojo.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.myspringcloud.common.pojo.entity.ProductCategory;
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
@ApiModel(description = "操作产品分类的请求对象")
public class ProductCategoryReq implements Serializable {

    @ApiModelProperty(value = "分类ID", example = "1")
    private Integer id;

    @ApiModelProperty(value = "父级分类ID", example = "1")
    private Integer parentId;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "分类级别", example = "1")
    private Integer level;

    @ApiModelProperty(value = "分类描述")
    private String desc;

    @ApiModelProperty(value = "分页参数对象")
    Page<ProductCategory> page;

}
