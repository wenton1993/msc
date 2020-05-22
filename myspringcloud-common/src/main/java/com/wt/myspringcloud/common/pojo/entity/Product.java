package com.wt.myspringcloud.common.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wt.myspringcloud.common.enumeration.ienum.PublishStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 产品对象
 *
 * @author 文通
 * @since 2020/5/20
 */
@Getter
@Setter
@ToString
@TableName(value = "product")
public class Product implements Serializable {

    @ApiModelProperty(value = "商品ID")
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty(value = "商品名称")
    @TableId(value = "name")
    private String name;

    @ApiModelProperty(value = "上架状态：0-未上架 1-上架")
    @TableField(value = "publish_status")
    private PublishStatus publishStatus;

    @ApiModelProperty(value = "商品价格(分)", example = "100")
    @TableField(value = "price")
    private Integer price;

    @ApiModelProperty(value = "库存", example = "100")
    @TableField(value = "stock")
    private Integer stock;

    @ApiModelProperty(value = "销量", example = "100")
    @TableField(value = "sale")
    private Integer sale;

    @ApiModelProperty(value = "更新操作时间戳")
    @TableField(value = "update_timestamp")
    private Timestamp updateTimestamp;
}
