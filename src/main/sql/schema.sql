create database seckill;
use seckill;

create table seckill(
`seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '��Ʒ���id',
`name` varchar(120) NOT NULL COMMENT '��Ʒ����',
`number` int NOT NULL COMMENT '�������',
`start_time` timestamp not null COMMENT '��ɱ��ʼʱ��',
`end_time` timestamp not null COMMENT '��ɱ����ʱ��',
`create_time` timestamp not null default CURRENT_TIMESTAMP COMMENT '����ʱ��',
PRIMARY KEY(seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='��ɱ����'; 

insert into seckill(name,number,start_time,end_time)
values
("1000Ԫ��ɱiPhonex",100,'2018-7-11 00:00:00','2018-7-13 00:00:00'),
("500Ԫ��ɱiPad2",200,'2018-7-11 00:00:00','2018-7-13 00:00:00'),
("300Ԫ��ɱС��6",300,'2018-7-11 00:00:00','2018-7-13 00:00:00'),
("200Ԫ��ɱ����note3",400,'2018-7-11 00:00:00','2018-7-13 00:00:00');

create table success_killed(
`seckill_id` bigint NOT NULL COMMENT '��ɱ��Ʒid',
`user_phone` bigint not null COMMENT '�û��ֻ���',
`state` tinyint not null DEFAULT -1 COMMENT '״̬��ʶ��-1����Ч  0���ɹ� 1���Ѹ��� 2���ѷ��� ',
`create_time` timestamp not null COMMENT '����ʱ��',
PRIMARY KEY(seckill_id,user_phone),
key idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��ɱ�ɹ���ϸ��';

mysql -uroot -p;