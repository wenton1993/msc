package com.wt.myspringcloud.common.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.wt.myspringcloud.common.enumeration.field.PublishStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @ApiModelProperty(value = "商品价格(分)", example = "100")
    @TableField(value = "price")
    private Integer price;

    @ApiModelProperty(value = "商品分类ID", example = "1")
    @TableField(value = "product_category_id")
    private Integer productCategoryId;

    @ApiModelProperty(value = "上架状态：0-未上架 1-上架")
    @TableField(value = "publish_status")
    private PublishStatus publishStatus;

    @ApiModelProperty(value = "库存", example = "100")
    @TableField(value = "stock")
    private Integer stock;

    @ApiModelProperty(value = "销量", example = "100")
    @TableField(value = "sale")
    private Integer sale;

    @ApiModelProperty(value = "创建日期和时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8:00")
    @TableField(value = "create_datetime")
    private LocalDateTime createDateTime;

    @Getter
    @Setter
    @ToString
    public static class ProductCategoryNode extends ProductCategory {

        private List<ProductCategoryNode> children;

        /**
         * 递归查找一个分类下所有的子分类,并返回一个Node对象
         *
         * 步骤：
         * 1. 将传入的实体类转化为一个 Node
         * 2. 筛选出该 Node 的所有下级
         * 3. 递归地将下级实体类转化为 Node
         * 4. 在递归出口将筛选出的下级组合成 List 放入到 Node 的 children 属性中
         *
         * @param category 目录
         * @param categoryList 所有目录
         * @return category 对应的节点
         */
        public static ProductCategoryNode covert(ProductCategory category, List<ProductCategory> categoryList) {
            ProductCategoryNode node = new ProductCategoryNode();
            BeanUtils.copyProperties(category, node);
            List<ProductCategoryNode> nodeList = categoryList.stream()
                    .filter(c -> c.getParentId().equals(category.getId()))
                    .map(c -> covert(c, categoryList))
                    .collect(Collectors.toList());
            node.setChildren(nodeList.size() > 0 ? nodeList : null);
            return node;
        }

    }

}
