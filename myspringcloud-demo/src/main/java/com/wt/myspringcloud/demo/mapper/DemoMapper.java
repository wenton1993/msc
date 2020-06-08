package com.wt.myspringcloud.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wt.myspringcloud.common.pojo.entity.WtUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemoMapper extends BaseMapper<WtUser> {

    List<WtUser> testForeach(@Param("nameList") List<String> nameList);

}
