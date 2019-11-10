CREATE TABLE test_task(
	id int UNSIGNED PRIMARY KEY,#订单编号
	title VARCHAR(50) NOT NULL COMMENT '标题',
	gmt_create datetime not NULL DEFAULT NOW() COMMENT'创建时间',
	gmt_due datetime COMMENT '修改时间',
	ordertag VARCHAR(10) NOT NULL COMMENT '开发语言',
	requiretype VARCHAR(20) NOT NULL COMMENT '需求类型',
	devprice INT NOT NULL COMMENT '价格',
	orderstatus char(10) not NULL DEFAULT '未接单' COMMENT'开发状态',
	docfilepath VARCHAR(50) COMMENT '需求文档',
	allfilepath VARCHAR(50) COMMENT '附件',
	requirement VARCHAR(50) NOT NULL COMMENT '订单需求',
	devremark VARCHAR(50) NOT NULL COMMENT '开发备注',
	pickflag INT not NULL DEFAULT '0' COMMENT '是否有人接单'
)