-- 商品表
DROP TABLE IF EXISTS product;
CREATE TABLE product
(
	id CHAR(32) NOT NULL COMMENT '产品ID',
	name VARCHAR(32) NOT NULL COMMENT '产品名称',
	publish_status TINYINT(1) DEFAULT 0 COMMENT '发布状态',
	price BIGINT(16) NOT NULL COMMENT '产品价格',
	stock BIGINT(16) DEFAULT 0 COMMENT '产品库存',
	sale BIGINT(16) DEFAULT 0 COMMENT '产品销量',
	create_datetime DATETIME NOT NULL COMMENT '创建日期和时间',
	PRIMARY KEY (id)
);

-- 商品分类表
DROP TABLE IF EXISTS product_category;
CREATE TABLE product_category
(
	id int NOT NULL COMMENT '类别ID',
	parent_id int NOT NULL COMMENT '父级类别',
	name VARCHAR(32) NOT NULL COMMENT '类别名称',
	level int NOT NULL COMMENT '级别',
	desc VARCHAR(64) COMMENT '类别描述',
	PRIMARY KEY (id)
);
