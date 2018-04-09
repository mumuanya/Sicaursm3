/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : sicaursm

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-04-04 18:58:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for apply
-- ----------------------------
DROP TABLE IF EXISTS `apply`;
CREATE TABLE `apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL DEFAULT '0' COMMENT '借用什么,0表示物品,1表示场地',
  `borrowtype` int(1) NOT NULL COMMENT '借用类型,0表示物品,1表示场地',
  `tid` int(11) NOT NULL COMMENT '借用的物品或者场地的id',
  `state` int(1) NOT NULL COMMENT '0表示未审核,1表示已审核,未借出.2表示已借出,未归还,3表示归还申请中,4表示归还完成,借用完成.',
  `borrowreason` varchar(255) NOT NULL COMMENT '借用理由',
  `borrowtime` int(1) NOT NULL DEFAULT '3' COMMENT '借用天数,10日以内',
  PRIMARY KEY (`id`),
  KEY `apply_user` (`userid`),
  CONSTRAINT `apply_user` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of apply
-- ----------------------------

-- ----------------------------
-- Table structure for field
-- ----------------------------
DROP TABLE IF EXISTS `field`;
CREATE TABLE `field` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `state` int(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '0表示未借出,1表示已借出',
  `position` varchar(255) DEFAULT NULL,
  `borrower_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='场地信息表,记录可以借出的场地';

-- ----------------------------
-- Records of field
-- ----------------------------
INSERT INTO `field` VALUES ('1', '杏园中门前', '场地标号10号', '0', '杏园中门前', null);
INSERT INTO `field` VALUES ('2', '杏园后门前', '场地标号2号', '0', '杏园后门前', null);
INSERT INTO `field` VALUES ('3', '杏园前门前', '场地标号4号', '0', '杏园前门前', null);
INSERT INTO `field` VALUES ('4', '三区保亭', '场地标号8号', '0', '三区保亭', null);
INSERT INTO `field` VALUES ('5', '三区门口', '场地标号12号', '0', '三区门口', null);
INSERT INTO `field` VALUES ('6', '二区门口', '场地标号5号', '0', '二区门口', null);
INSERT INTO `field` VALUES ('7', '老区体育馆前', '场地标号7号', '0', '老区体育馆前', null);

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `state` int(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '状态,1表示已经借出,0表示未借出,可以借',
  `position` varchar(255) DEFAULT NULL,
  `borrower_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COMMENT='物品表,记录可以借出的物品';

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '乒乓球拍', '编号0000132', '0', '老区游泳池旁边', null);
INSERT INTO `item` VALUES ('2', '羽毛球拍', '0000133', '0', '老区游泳池旁边', null);
INSERT INTO `item` VALUES ('3', '篮球', '0000134', '0', '老区游泳池旁边', null);
INSERT INTO `item` VALUES ('4', '篮球', '0000135', '0', '老区游泳池旁边', null);
INSERT INTO `item` VALUES ('5', '排球', '0000136', '0', '老区游泳池旁边', null);
INSERT INTO `item` VALUES ('6', '足球', '0000137', '0', '老区游泳池旁边', null);
INSERT INTO `item` VALUES ('7', '足球', '0000138', '0', '老区游泳池旁边', null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `neckname` varchar(32) DEFAULT NULL COMMENT '别名',
  `account` varchar(32) NOT NULL COMMENT '账号,唯一',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `headpic` text COMMENT '头像',
  `stuid` int(11) NOT NULL COMMENT '学号',
  `mail` varchar(255) NOT NULL COMMENT '邮箱地址',
  `phone` varchar(255) NOT NULL COMMENT '电话号码',
  `type` int(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '用户类型,0表示学生,1管理员,2负责老师,3物品管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='用户表,存放用户的登录信息等';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小吴', 'test1', 'test1', null, '20140001', 'qkmc@outlook.com', '18783551223', '0');
INSERT INTO `user` VALUES ('2', '小娇', 'test2', 'test2', null, '20140002', 'qkmc@outlook.com', '18783551223', '0');
INSERT INTO `user` VALUES ('3', '小静', 'test3', 'test3', null, '20140003', 'qkmc@outlook.com', '18783551223', '0');
INSERT INTO `user` VALUES ('4', 'superAdmin', 'admin', 'admin', null, '10000', 'qkmc@outlook.com', '18783551223', '1');
INSERT INTO `user` VALUES ('5', '王曼涛', 'wang', 'wang', null, '1995100', 'qkmc@outlook.com', '18783551223', '2');
INSERT INTO `user` VALUES ('6', '刘阿姨', 'liu', 'liu', null, '32123', 'qkmc@outlook.com', '18783551223', '3');
