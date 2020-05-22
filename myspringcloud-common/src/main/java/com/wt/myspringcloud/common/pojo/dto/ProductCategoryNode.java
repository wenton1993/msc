package com.wt.myspringcloud.common.pojo.dto;

import com.wt.myspringcloud.common.pojo.entity.ProductCategory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author 文通
 * @since 2020/5/22
 */
@Getter
@Setter
@ToString
public class ProductCategoryNode extends ProductCategory {

    private List<ProductCategoryNode> children;

}
