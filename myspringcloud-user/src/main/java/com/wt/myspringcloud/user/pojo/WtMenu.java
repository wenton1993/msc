package com.wt.myspringcloud.user.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.StringJoiner;

/**
 * 菜单对象
 * 测试Mybatis嵌套查询
 *
 * @author 文通
 * @since 2020/4/18
 */
public class WtMenu implements Serializable{

    private Long menuId;

    private List<WtMenu> childrenMenu;

    @Override
    public String toString() {
        return new StringJoiner(", ", WtMenu.class.getSimpleName() + "[", "]")
                .add("menuId=" + menuId)
                .add("childrenMenu=" + childrenMenu)
                .toString();
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public List<WtMenu> getChildrenMenu() {
        return childrenMenu;
    }

    public void setChildrenMenu(List<WtMenu> childrenMenu) {
        this.childrenMenu = childrenMenu;
    }
}
