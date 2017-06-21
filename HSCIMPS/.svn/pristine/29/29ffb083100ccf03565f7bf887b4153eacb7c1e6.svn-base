/*
Navicat MySQL Data Transfer

Source Server         : 123.206.77.22_3306
Source Server Version : 50716
Source Host           : 123.206.77.22:3306
Source Database       : hsc

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-03-01 09:53:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_crypto
-- ----------------------------
DROP TABLE IF EXISTS `tb_crypto`;
CREATE TABLE `tb_crypto` (
  `cryptoId` int(20) NOT NULL AUTO_INCREMENT COMMENT '密码体制Id',
  `cryptoName` varchar(32) DEFAULT NULL COMMENT '名称',
  `englishName` varchar(50) DEFAULT NULL COMMENT '英文名称',
  `cryptoDesc` varchar(200) DEFAULT NULL COMMENT '描述',
  `createDate` varchar(19) DEFAULT NULL COMMENT '创建日期',
  PRIMARY KEY (`cryptoId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_crypto
-- ----------------------------
INSERT INTO `tb_crypto` VALUES ('1', '基于PKI公钥密码体制', 'Traditional Public Key Cryptosystem', '基于PKI公钥密码体制', '2016-10-23 18:25:47');
INSERT INTO `tb_crypto` VALUES ('2', '基于身份公钥密码体制', 'Identity-based Public Key CryptoSystem', '基于身份公钥密码体制', '2016-10-24 17:38:56');
INSERT INTO `tb_crypto` VALUES ('3', '无证书公钥密码体制', 'Certificateless Public Key Cryptos', '无证书公钥密码体制', '2016-10-24 17:42:06');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
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
  `createDate` varchar(19) DEFAULT NULL COMMENT '创建时间',
  `cryptoId` int(20) DEFAULT NULL COMMENT '密码体制',
  `state` varchar(2) DEFAULT NULL COMMENT '权限(0管理员 1普通用户)',
  `status` varchar(2) DEFAULT NULL COMMENT '状态(0启用 1停用)',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', '96e79218965eb72c92a549dd5a330112', '男', '26', '1990-03-28', '13919975822', '学生', '甘肃省', '2016-10-21 18:13:12', '1', '0', '0');
INSERT INTO `tb_user` VALUES ('10', 'Alice', 'f2b90534bd952942c6657c106195c8d7', '男', '24', '1993-12-02', '18678380120', '学生', '甘肃省兰州市安宁区西北师范大学', '2017-02-27 16:01:13', '1', '1', '0');
INSERT INTO `tb_user` VALUES ('11', 'honey', 'f2b90534bd952942c6657c106195c8d7', '女', '24', '1993-12-02', '18678380010', '学生', '山东省德州市夏津县夏津县', '2017-02-27 16:02:38', '2', '1', '0');
