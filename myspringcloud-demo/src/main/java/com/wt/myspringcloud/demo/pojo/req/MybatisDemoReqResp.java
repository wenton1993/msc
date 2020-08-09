package com.wt.myspringcloud.demo.pojo.req;

import com.wt.myspringcloud.demo.pojo.entity.MybatisDemoEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author 文通
 * @since 2020/7/19
 */
@Getter
@Setter
@ToString
public class MybatisDemoReqResp extends MybatisDemoEntity {

    private List<String> interests;

}
