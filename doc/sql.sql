CREATE TABLE test_task(
	id int UNSIGNED PRIMARY KEY,#�������
	title VARCHAR(50) NOT NULL COMMENT '����',
	gmt_create datetime not NULL DEFAULT NOW() COMMENT'����ʱ��',
	gmt_due datetime COMMENT '�޸�ʱ��',
	ordertag VARCHAR(10) NOT NULL COMMENT '��������',
	requiretype VARCHAR(20) NOT NULL COMMENT '��������',
	devprice INT NOT NULL COMMENT '�۸�',
	orderstatus char(10) not NULL DEFAULT 'δ�ӵ�' COMMENT'����״̬',
	docfilepath VARCHAR(50) COMMENT '�����ĵ�',
	allfilepath VARCHAR(50) COMMENT '����',
	requirement VARCHAR(50) NOT NULL COMMENT '��������',
	devremark VARCHAR(50) NOT NULL COMMENT '������ע',
	pickflag INT not NULL DEFAULT '0' COMMENT '�Ƿ����˽ӵ�'
)