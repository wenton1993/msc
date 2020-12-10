package com.wt.myspringcloud.common.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author 文通
 * @since 2020/5/22
 */
@Getter
@Setter
@ToString
@TableName(value = "product_category")
public class ProductCategory implements Serializable {

    @ApiModelProperty(value = "分类ID", example = "1")
    @TableId(value = "id")
    private Integer id;

    @ApiModelProperty(value = "父级分类ID", example = "1")
    @TableField(value = "parent_id")
    private Integer parentId;

    @ApiModelProperty(value = "分类名称")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty(value = "分类级别", example = "1")
    @TableField(value = "level")
    private Integer level;

    @ApiModelProperty(value = "分类描述")
    @TableField(value = "desc")
    private String desc;

}
