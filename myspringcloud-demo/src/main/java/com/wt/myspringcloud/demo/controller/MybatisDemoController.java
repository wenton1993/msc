package com.wt.myspringcloud.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.myspringcloud.demo.pojo.entity.MybatisDemoEntity;
import com.wt.myspringcloud.demo.service.MybatisDemoEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 文通
 * @since 2020/7/7
 */
@RestController
@RequestMapping("/mybatisDemo")
public class MybatisDemoController {

    @Autowired
    private MybatisDemoEntityService ds;

    @GetMapping("/page")
    public R<IPage<MybatisDemoEntity>> page(Page<MybatisDemoEntity> page,
                                            MybatisDemoEntity entityParams) {
        return R.ok(ds.page(page, new QueryWrapper<>(entityParams)));
    }

    @GetMapping("/page2")
    public R<List<MybatisDemoEntity>> page2(Page<MybatisDemoEntity> page,
                                            MybatisDemoEntity entityParams) {
        return R.ok(ds.page(page, new QueryWrapper<>(entityParams)).getRecords());
    }

}
