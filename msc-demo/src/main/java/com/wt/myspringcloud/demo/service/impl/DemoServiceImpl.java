package com.wt.myspringcloud.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.myspringcloud.demo.mapper.DemoMapper;
import com.wt.myspringcloud.demo.pojo.entity.Demo;
import com.wt.myspringcloud.demo.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements DemoService {
}
