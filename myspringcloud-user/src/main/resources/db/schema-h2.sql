DROP TABLE IF EXISTS wt_user;
DROP TABLE IF EXISTS wt_order;
DROP TABLE IF EXISTS wt_menu;
-- 用户表，测试基础查询功能
CREATE TABLE wt_user
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名',
	age INT(11) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
	PRIMARY KEY (id)
);
-- 订单表，结合用户表测试作分组查询和嵌套查询
CREATE TABLE wt_order
(
	id BIGINT(20) NOT NULL COMMENT '主键ID',
	user_id BIGINT(20) NOT NULL COMMENT '用户ID',
	PRIMARY KEY (id)
);
-- 菜单表，测试查询树形结构的数据
create table wt_menu
(
    menu_id BIGINT(20) NOT NULL COMMENT '菜单ID',
	parent_menu_id BIGINT(20) COMMENT '父菜单ID',
	PRIMARY KEY (menu_id)
);