package com.wt.myspringcloud.mall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.myspringcloud.common.core.BaseController;
import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.pojo.dto.ProductCategoryNode;
import com.wt.myspringcloud.common.pojo.entity.ProductCategory;
import com.wt.myspringcloud.common.pojo.req.ProductCategoryReq;
import com.wt.myspringcloud.mall.mapper.ProductCategoryMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 文通
 * @since 2020/5/21
 */
@RestController
@RequestMapping(path = "/productCategory")
@Api(tags = "产品类别管理控制器")
public class ProductCategoryController extends BaseController {

    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @ApiOperation(value = "查询产品分类列表")
    @PostMapping(path = "/queryProductCategory")
    public JsonResult<IPage<ProductCategory>> queryProductCategory(@RequestBody ProductCategoryReq req) {
        ProductCategory params = new ProductCategory();
        BeanUtils.copyProperties(req, params);
        Page<ProductCategory> page = req.getPage();
        page = productCategoryMapper.selectPage(page, new QueryWrapper<>(params));
        return renderSuccessWithData(page);
    }

    @ApiOperation(value = "查询商品分类树")
    @PostMapping(path = "/queryProductCategoryTree")
    public JsonResult<List<ProductCategoryNode>> queryProductCategoryTree() {
        List<ProductCategory> categoryList = productCategoryMapper.selectList(null);
        List<ProductCategoryNode> nodeList = categoryList.stream()
                .filter(c -> c.getLevel() == 1)
                .map(c -> covert(c, categoryList))
                .collect(Collectors.toList());
        return renderSuccessWithData(nodeList);
    }

    private ProductCategoryNode covert(ProductCategory category, List<ProductCategory> categoryList) {
        ProductCategoryNode node = new ProductCategoryNode();
        BeanUtils.copyProperties(category, node);
        List<ProductCategoryNode> nodeList = categoryList.stream()
                .filter(c -> c.getParentId().equals(category.getId()))
                .map(c -> covert(c, categoryList))
                .collect(Collectors.toList());
        node.setChildren(nodeList);
        return node;
    }

}
