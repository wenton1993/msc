-- 用户表，测试基础查询功能
DROP TABLE IF EXISTS product;
CREATE TABLE product
(
	id CHAR(32) NOT NULL COMMENT '产品ID',
	name VARCHAR(32) NOT NULL COMMENT '产品名称',
	publish_status TINYINT(1) DEFAULT 0 COMMENT '发布状态',
	price BIGINT(16) NOT NULL COMMENT '产品价格',
	stock BIGINT(16) DEFAULT 0 COMMENT '产品库存',
	sale BIGINT(16) DEFAULT 0 COMMENT '产品销量',
	update_timestamp TIMESTAMP NOT NULL COMMENT '产品销量',
	PRIMARY KEY (id)
);
