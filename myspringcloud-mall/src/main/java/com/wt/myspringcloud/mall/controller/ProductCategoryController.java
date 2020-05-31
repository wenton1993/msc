package com.wt.myspringcloud.mall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.pojo.entity.Product;
import com.wt.myspringcloud.common.pojo.entity.ProductCategory;
import com.wt.myspringcloud.common.pojo.req.ProductCategoryReq;
import com.wt.myspringcloud.common.util.JsonResultUtils;
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
@RequestMapping(value = "/productCategory")
@Api(tags = "产品类别管理控制器")
public class ProductCategoryController {

    @Resource
    private ProductCategoryMapper productCategoryMapper;

    @ApiOperation(value = "查询产品分类列表")
    @PostMapping(value = "/queryProductCategory")
    public JsonResult<IPage<ProductCategory>> queryProductCategory(@RequestBody ProductCategoryReq req) {
        ProductCategory params = new ProductCategory();
        BeanUtils.copyProperties(req, params);
        Page<ProductCategory> page = req.getPage();
        page = productCategoryMapper.selectPage(page, new QueryWrapper<>(params));
        return JsonResultUtils.successWithData(page);
    }

    @ApiOperation(value = "查询商品分类树")
    @PostMapping(value = "/queryProductCategoryTree")
    public JsonResult<List<Product.ProductCategoryNode>> queryProductCategoryTree() {
        List<ProductCategory> categoryList = productCategoryMapper.selectList(null);
        List<Product.ProductCategoryNode> nodeList = categoryList.stream()
                .filter(c -> c.getLevel() == 1)
                .map(c -> Product.ProductCategoryNode.covert(c, categoryList))
                .collect(Collectors.toList());
        return JsonResultUtils.successWithData(nodeList);
    }

}
