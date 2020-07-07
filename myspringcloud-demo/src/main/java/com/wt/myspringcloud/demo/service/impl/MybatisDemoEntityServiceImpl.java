package com.wt.myspringcloud.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.myspringcloud.demo.mapper.MybatisDemoEntityMapper;
import com.wt.myspringcloud.demo.pojo.entity.MybatisDemoEntity;
import com.wt.myspringcloud.demo.service.MybatisDemoEntityService;
import org.springframework.stereotype.Service;

@Service
public class MybatisDemoEntityServiceImpl extends ServiceImpl<MybatisDemoEntityMapper, MybatisDemoEntity> implements MybatisDemoEntityService {
}
