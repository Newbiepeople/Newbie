CREATE DATABASE IF NOT EXISTS petstore CHARACTER SET UTF8;

USE petstore;

SET NAMES GBK;

insert into tb_user (login, password) values ('petstore_test', 'petstore_test');

insert into tb_category (id, name) values (1, '狗'); 
insert into tb_category (id, name) values (2, '猫'); 
insert into tb_category (id, name) values (3, '兔'); 
insert into tb_category (id, name) values (4, '龟'); 

insert into tb_category (id, name, parent_id) values (5, '长毛猫', 2); 
insert into tb_category (id, name, parent_id) values (6, '短毛猫', 2);
insert into tb_category (id, name, parent_id) values (7, '野 猫', 2);
    
insert into tb_category (id, name, parent_id) values (8, '土耳其梵猫', 5); 
insert into tb_category (id, name, parent_id) values (9, '韦尔斯猫', 5);
insert into tb_category (id, name, parent_id) values (10, '山东狮子猫', 5);
insert into tb_category (id, name, parent_id) values (11, '安哥拉猫', 5);
insert into tb_category (id, name, parent_id) values (12, '波斯猫', 5);
insert into tb_category (id, name, parent_id) values (13, '金吉拉', 5);
insert into tb_category (id, name, parent_id) values (14, '索马里猫', 5);
insert into tb_category (id, name, parent_id) values (15, '长毛反耳猫', 5);
insert into tb_category (id, name, parent_id) values (16, '长毛暹罗猫', 5);
insert into tb_category (id, name, parent_id) values (17, '喜玛拉雅猫', 5);
insert into tb_category (id, name, parent_id) values (18, '挪威森林猫', 5);

insert into tb_category (id, name, parent_id) values (19, '美国卷耳猫', 7);
insert into tb_category (id, name, parent_id) values (20, '孟买猫', 7);
insert into tb_category (id, name, parent_id) values (21, '外来种猫', 7);
insert into tb_category (id, name, parent_id) values (22, '东方短毛猫', 7);
insert into tb_category (id, name, parent_id) values (23, '阿比西尼亚猫', 7);
insert into tb_category (id, name, parent_id) values (24, '孟加拉猫', 7);


