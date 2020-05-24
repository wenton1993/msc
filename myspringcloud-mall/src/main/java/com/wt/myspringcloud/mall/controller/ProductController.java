package com.wt.myspringcloud.mall.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.pojo.entity.Product;
import com.wt.myspringcloud.common.pojo.req.ProductReq;
import com.wt.myspringcloud.common.util.JsonResultUtils;
import com.wt.myspringcloud.mall.mapper.ProductMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 文通
 * @since 2020/5/21
 */
@RestController
@RequestMapping(path = "/product")
@Api(tags = "产品管理控制器")
public class ProductController {

    @Resource
    private ProductMapper productMapper;

    @ApiOperation(value = "查询产品列表")
    @PostMapping(path = "/queryProduct")
    public JsonResult<IPage<Product>> queryProduct(@RequestBody ProductReq req) {
        Product params = new Product();
        BeanUtils.copyProperties(req, params);
        Page<Product> page = req.getPage();
        page = productMapper.selectPage(page, new QueryWrapper<>(params));
        return JsonResultUtils.successWithData(page);
    }

}
