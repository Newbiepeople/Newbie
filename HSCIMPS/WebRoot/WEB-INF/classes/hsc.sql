/*
SQLyog Ultimate v8.32 
MySQL - 5.5.12 : Database - hsc
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hsc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hsc`;

/*Table structure for table `tb_crypto` */

DROP TABLE IF EXISTS `tb_crypto`;

CREATE TABLE `tb_crypto` (
  `cryptoId` int(32) NOT NULL AUTO_INCREMENT,
  `cryptoName` varchar(32) DEFAULT NULL,
  `englishName` varchar(50) DEFAULT NULL,
  `cryptoDesc` varchar(200) DEFAULT NULL,
  `createDate` varchar(19) DEFAULT NULL,
  PRIMARY KEY (`cryptoId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tb_crypto` */

insert  into `tb_crypto`(`cryptoId`,`cryptoName`,`englishName`,`cryptoDesc`,`createDate`) values (1,'基于PKI公钥密码体制','Traditional Public Key Cryptosystem','基于PKI公钥密码体制','2016-10-23 18:25:47'),(2,'基于身份公钥密码体制','Identity-based Public Key Cryptosystem','基于身份公钥密码体制','2016-10-24 20:33:58'),(3,'无证书公钥密码体制','Certificateless Public Key Cryptosystem','无证书公钥密码体制','2016-10-29 19:22:39');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `userId` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `age` int(4) DEFAULT NULL COMMENT '年龄',
  `birthDate` varchar(10) DEFAULT NULL COMMENT '出生日期',
  `telphone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `occupation` varchar(50) DEFAULT NULL COMMENT '职业',
  `homeAddress` varchar(50) DEFAULT NULL COMMENT '家庭住址',
  `createDate` varchar(19) DEFAULT NULL COMMENT '创建日期',
  `cryptoId` int(20) DEFAULT NULL COMMENT '密码体制',
  `state` varchar(2) DEFAULT NULL COMMENT '权限:0管理员 1普通用户',
  `status` varchar(2) DEFAULT NULL COMMENT '状态:0启用 1停用',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`userId`,`username`,`password`,`sex`,`age`,`birthDate`,`telphone`,`occupation`,`homeAddress`,`createDate`,`cryptoId`,`state`,`status`) values (1,'admin','96e79218965eb72c92a549dd5a330112','男',26,'1990-03-28','13919975822','学生','甘肃省兰州市安宁区西北师范大学','2016-10-21 18:13:12',1,'0','0'),(2,'111111','96e79218965eb72c92a549dd5a330112','男',20,'1996-03-28','12345678901','学生','甘肃','2016-10-22 18:13:12',1,'1','0'),(3,'1','96e79218965eb72c92a549dd5a330112','男',1,'1','1','1','1','2016-10-23 18:13:12',2,'1','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

