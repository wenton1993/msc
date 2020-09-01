package com.wt.myspringcloud.demo.pojo.req;

import com.wt.myspringcloud.demo.pojo.entity.Demo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 同时作为请求和返回对象
 *
 * @author 文通
 * @since 2020/7/19
 */
@Getter
@Setter
@ToString
public class DemoReqResp extends Demo {

    private List<String> interests;

}
