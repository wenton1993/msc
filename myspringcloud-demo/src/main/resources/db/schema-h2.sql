-- CRUD Demo表
DROP TABLE IF EXISTS mybatis_demo;
CREATE TABLE mybatis_demo_entity
(
    id CHAR(32) NOT NULL COMMENT '主键ID',
    demo_no VARCHAR(32) NOT NULL UNIQUE comment '唯一号码',
    name VARCHAR(32) COMMENT '姓名',
    age INT(8) COMMENT '年龄',
    birthday DATE comment '出生日期',
    create_datetime DATETIME comment '创建日期时间',
    update_datetime DATETIME comment '更新日期时间',
    deleted TINYINT(1) comment '是否删除:0-未删除 1-已删除',
    version TIMESTAMP comment '记录的版本号',
    PRIMARY KEY (id)
);
-- 用户表，测试基础查询功能
DROP TABLE IF EXISTS wt_user;
CREATE TABLE wt_user
(
	id BIGINT(16) NOT NULL COMMENT '主键ID',
	name VARCHAR(32) NULL DEFAULT NULL COMMENT '姓名',
	age INT(8) NULL DEFAULT NULL COMMENT '年龄',
	email VARCHAR(64) NULL DEFAULT NULL COMMENT '邮箱',
	PRIMARY KEY (id)
);
-- 订单表，结合用户表测试作分组查询和嵌套查询
DROP TABLE IF EXISTS wt_order;
CREATE TABLE wt_order
(
	id BIGINT(16) NOT NULL COMMENT '主键ID',
	user_id BIGINT(16) NOT NULL COMMENT '用户ID',
	amount BIGINT(16) NOT NULL COMMENT '金额',
	PRIMARY KEY (id)
);
-- 菜单表，测试查询树形结构的数据
DROP TABLE IF EXISTS menu;
create table menu
(
    id BIGINT(8) NOT NULL COMMENT '菜单ID',
	parent_id BIGINT(8) COMMENT '父菜单ID',
	PRIMARY KEY (id)
);