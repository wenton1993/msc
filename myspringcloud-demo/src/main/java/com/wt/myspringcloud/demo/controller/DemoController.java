package com.wt.myspringcloud.demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.myspringcloud.demo.pojo.entity.Demo;
import com.wt.myspringcloud.demo.pojo.req.DemoReqResp;
import com.wt.myspringcloud.demo.service.DemoService;
import com.wt.myspringcloud.demo.validation.type.Insert;
import com.wt.myspringcloud.demo.validation.type.Update;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
public class DemoController {

    @Autowired
    private DemoService ds;

    @GetMapping("/page")
    public R<IPage<Demo>> page(Page<Demo> page,
                               Demo params) {
        Wrapper<Demo> wrapper = new QueryWrapper<Demo>().lambda()
                .eq(Demo::getId, params.getId())
                .like(StringUtils.isNotBlank(params.getName()), Demo::getName, params.getName())
                .eq(Objects.nonNull(params.getAge()), Demo::getAge, params.getAge())
                .ge(Objects.nonNull(params.getMinCreateDatetime()), Demo::getCreateDatetime, params.getMinCreateDatetime())
                .le(Objects.nonNull(params.getMaxCreateDatetime()), Demo::getCreateDatetime, params.getMaxCreateDatetime())
                .orderByAsc(Demo::getId);
        return R.ok(ds.page(page, wrapper));
    }

    @GetMapping("/pageByJson")
    public R<IPage<Demo>> pageByJson(Page<Demo> page,
                                     Demo entityParams) {
        return R.ok(ds.page(page, new QueryWrapper<>(entityParams)));
    }

    @PostMapping("/save")
    public R<Boolean> save(@Validated({Insert.class}) Demo entity) {
        if (Objects.isNull(entity.getDelete_status())) {
            entity.setDelete_status(0);
        }
        return R.ok(ds.save(entity));
    }

    @GetMapping("/queryById")
    public R<Demo> queryById(String id) {
        if (StringUtils.isBlank(id)) {
            return R.failed("必填字段ID为空");
        }
        return R.ok(ds.getById(id));
    }

    @PostMapping("/updateById")
    public R<Boolean> updateById(@Validated({Update.class}) Demo entity) {
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
    public R<DemoReqResp> testReq(DemoReqResp req) {
        log.info(req.toString());
        return R.ok(req);
    }
}
