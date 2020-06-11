package com.wt.myspringcloud.demo.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单对象
 * 测试Mybatis嵌套查询
 *
 * @author 文通
 * @since 2020/4/18
 */
@Getter
@Setter
@ToString
public class Menu implements Serializable {

    private Long menuId;

    private List<Menu> childMenuList;

}
