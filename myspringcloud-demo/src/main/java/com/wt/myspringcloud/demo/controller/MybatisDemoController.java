package com.wt.myspringcloud.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.myspringcloud.demo.pojo.entity.MybatisDemoEntity;
import com.wt.myspringcloud.demo.pojo.req.MybatisDemoReqResp;
import com.wt.myspringcloud.demo.service.MybatisDemoEntityService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author 文通
 * @since 2020/7/7
 */
@Slf4j
@RestController
@RequestMapping("/mybatisDemo")
public class MybatisDemoController {

    @Autowired
    private MybatisDemoEntityService ds;

    @GetMapping("/page")
    public R<IPage<MybatisDemoEntity>> page(Page<MybatisDemoEntity> page,
                                            MybatisDemoEntity params) {
        Wrapper<MybatisDemoEntity> wrapper = new QueryWrapper<MybatisDemoEntity>().lambda()
                .eq(StringUtils.isNotBlank(params.getId()), MybatisDemoEntity::getId, params.getId())
                .like(StringUtils.isNotBlank(params.getName()), MybatisDemoEntity::getName, params.getName())
                .eq(Objects.nonNull(params.getAge()), MybatisDemoEntity::getAge, params.getAge())
                .ge(Objects.nonNull(params.getMinCreateDatetime()), MybatisDemoEntity::getCreateDatetime, params.getMinCreateDatetime())
                .le(Objects.nonNull(params.getMaxCreateDatetime()), MybatisDemoEntity::getCreateDatetime, params.getMaxCreateDatetime())
                .orderByAsc(MybatisDemoEntity::getDemoNo);
        return R.ok(ds.page(page, wrapper));
    }

    @GetMapping("/pageByJson")
    public R<IPage<MybatisDemoEntity>> pageByJson(Page<MybatisDemoEntity> page,
                                                  MybatisDemoEntity entityParams) {
        return R.ok(ds.page(page, new QueryWrapper<>(entityParams)));
    }

    @PostMapping("/save")
    public R<Boolean> save(MybatisDemoEntity entity) {
        if (StringUtils.isBlank(entity.getDemoNo())) {
            return R.failed("编号不能为空");
        }
        if (Objects.isNull(entity.getDeleted())) {
            entity.setDeleted(0);
        }
        return R.ok(ds.save(entity));
    }

    @GetMapping("/queryById")
    public R<MybatisDemoEntity> queryById(String id) {
        if (StringUtils.isBlank(id)) {
            return R.failed("必填字段ID为空");
        }
        return R.ok(ds.getById(id));
    }

    @PostMapping("/updateById")
    public R<Boolean> updateById(MybatisDemoEntity entity) {
        if (StringUtils.isBlank(entity.getId())) {
            return R.failed("必填字段ID为空");
        }
        return R.ok(ds.updateById(entity));
    }

    @PostMapping("/removeById")
    public R<Boolean> removeById(String id) {
        if (StringUtils.isBlank(id)) {
            return R.failed("必填字段ID为空");
        }
        return R.ok(ds.removeById(id));
    }

    @PostMapping("/testReq")
    public R<MybatisDemoReqResp> testReq(MybatisDemoReqResp req) {
        log.info(req.toString());
        return R.ok(req);
    }
}
