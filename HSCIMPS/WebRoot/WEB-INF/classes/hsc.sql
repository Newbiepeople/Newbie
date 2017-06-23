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

insert  into `tb_crypto`(`cryptoId`,`cryptoName`,`englishName`,`cryptoDesc`,`createDate`) values (1,'����PKI��Կ��������','Traditional Public Key Cryptosystem','����PKI��Կ��������','2016-10-23 18:25:47'),(2,'������ݹ�Կ��������','Identity-based Public Key Cryptosystem','������ݹ�Կ��������','2016-10-24 20:33:58'),(3,'��֤�鹫Կ��������','Certificateless Public Key Cryptosystem','��֤�鹫Կ��������','2016-10-29 19:22:39');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `userId` int(20) NOT NULL AUTO_INCREMENT COMMENT '�û�id',
  `username` varchar(32) DEFAULT NULL COMMENT '�û���',
  `password` varchar(32) DEFAULT NULL COMMENT '����',
  `sex` varchar(2) DEFAULT NULL COMMENT '�Ա�',
  `age` int(4) DEFAULT NULL COMMENT '����',
  `birthDate` varchar(10) DEFAULT NULL COMMENT '��������',
  `telphone` varchar(11) DEFAULT NULL COMMENT '��ϵ�绰',
  `occupation` varchar(50) DEFAULT NULL COMMENT 'ְҵ',
  `homeAddress` varchar(50) DEFAULT NULL COMMENT '��ͥסַ',
  `createDate` varchar(19) DEFAULT NULL COMMENT '��������',
  `cryptoId` int(20) DEFAULT NULL COMMENT '��������',
  `state` varchar(2) DEFAULT NULL COMMENT 'Ȩ��:0����Ա 1��ͨ�û�',
  `status` varchar(2) DEFAULT NULL COMMENT '״̬:0���� 1ͣ��',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`userId`,`username`,`password`,`sex`,`age`,`birthDate`,`telphone`,`occupation`,`homeAddress`,`createDate`,`cryptoId`,`state`,`status`) values (1,'admin','96e79218965eb72c92a549dd5a330112','��',26,'1990-03-28','13919975822','ѧ��','����ʡ�����а���������ʦ����ѧ','2016-10-21 18:13:12',1,'0','0'),(2,'111111','96e79218965eb72c92a549dd5a330112','��',20,'1996-03-28','12345678901','ѧ��','����','2016-10-22 18:13:12',1,'1','0'),(3,'1','96e79218965eb72c92a549dd5a330112','��',1,'1','1','1','1','2016-10-23 18:13:12',2,'1','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

