/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : sicaursm

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-04-18 15:27:10
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
  KEY `apply_item` (`tid`),
  KEY `apply_state_dic` (`state`),
  CONSTRAINT `apply_state_dic` FOREIGN KEY (`state`) REFERENCES `applystatedic` (`state`) ON UPDATE CASCADE,
  CONSTRAINT `apply_user` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of apply
-- ----------------------------

-- ----------------------------
-- Table structure for applystatedic
-- ----------------------------
DROP TABLE IF EXISTS `applystatedic`;
CREATE TABLE `applystatedic` (
  `state` int(11) NOT NULL AUTO_INCREMENT,
  `instruction` varchar(255) NOT NULL,
  PRIMARY KEY (`state`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of applystatedic
-- ----------------------------
INSERT INTO `applystatedic` VALUES ('-1', '已被拒绝');
INSERT INTO `applystatedic` VALUES ('0', '未通过审核');
INSERT INTO `applystatedic` VALUES ('1', '审核通过，已借出');
INSERT INTO `applystatedic` VALUES ('2', '申请归还中');
INSERT INTO `applystatedic` VALUES ('3', '已归还');

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
  PRIMARY KEY (`id`),
  KEY `field_user` (`borrower_id`),
  KEY `field_dic` (`state`),
  CONSTRAINT `field_dic` FOREIGN KEY (`state`) REFERENCES `fielditemstatedic` (`state`),
  CONSTRAINT `field_user` FOREIGN KEY (`borrower_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=1004387701 DEFAULT CHARSET=utf8mb4 COMMENT='场地信息表,记录可以借出的场地';

-- ----------------------------
-- Records of field
-- ----------------------------
INSERT INTO `field` VALUES ('1', '杏园中门前', '场地标号10号', '0', '杏园中门前', null);
INSERT INTO `field` VALUES ('2', '杏园后门前', '场地标号2号', '0', '杏园后门前', null);
INSERT INTO `field` VALUES ('3', '杏园前门前', '场地标号4号', '0', '杏园前门前', null);
INSERT INTO `field` VALUES ('4', '三区保亭', '场地标号8号', '0', '三区保亭', null);
INSERT INTO `field` VALUES ('5', '三区门口', '场地标号12号', '0', '三区门口', null);
INSERT INTO `field` VALUES ('6', '二区门口', '场地标号5号', '0', '二区门口', null);
INSERT INTO `field` VALUES ('1004387699', '从', '大', '0', '我的裆下', null);
INSERT INTO `field` VALUES ('1004387700', '金', '细长', '0', '黄铠的', null);

-- ----------------------------
-- Table structure for fielditemstatedic
-- ----------------------------
DROP TABLE IF EXISTS `fielditemstatedic`;
CREATE TABLE `fielditemstatedic` (
  `state` int(1) unsigned zerofill NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`state`),
  KEY `state` (`state`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of fielditemstatedic
-- ----------------------------
INSERT INTO `fielditemstatedic` VALUES ('0', '未借出');
INSERT INTO `fielditemstatedic` VALUES ('1', '已借出');

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
  PRIMARY KEY (`id`),
  KEY `item_user` (`borrower_id`),
  KEY `item_dic` (`state`),
  CONSTRAINT `item_dic` FOREIGN KEY (`state`) REFERENCES `fielditemstatedic` (`state`),
  CONSTRAINT `item_user` FOREIGN KEY (`borrower_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COMMENT='物品表,记录可以借出的物品';

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '乒乓球拍', '编号0000132', '0', '老区游泳池旁边', null);
INSERT INTO `item` VALUES ('2', '羽毛球拍', '0000133', '0', '老区游泳池旁边', null);
INSERT INTO `item` VALUES ('3', '篮球', '0000134', '0', '老区游泳池旁边', null);
INSERT INTO `item` VALUES ('4', '篮球', '0000135', '0', '老区游泳池旁边', null);
INSERT INTO `item` VALUES ('5', '排球', '0000136', '0', '老区游泳池旁边', null);
INSERT INTO `item` VALUES ('6', '足球', '0000137', '0', '老区游泳池旁边', null);
INSERT INTO `item` VALUES ('9', '足球', '0000138', '0', '老区游泳池旁边', null);
INSERT INTO `item` VALUES ('17', '鸡', '公鸡', '0', '那里', null);
INSERT INTO `item` VALUES ('18', '鸡2', '母鸡', '0', '这里', null);
INSERT INTO `item` VALUES ('19', '鸡3', '金', '0', '他', null);
INSERT INTO `item` VALUES ('20', '金针菇', '黄铠', '0', '黄铠', null);
INSERT INTO `item` VALUES ('23', '避', '牌', '1', '在', null);

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
  PRIMARY KEY (`id`),
  KEY `usertype` (`type`),
  CONSTRAINT `usertype` FOREIGN KEY (`type`) REFERENCES `usertypedic` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='用户表,存放用户的登录信息等';

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for usertypedic
-- ----------------------------
DROP TABLE IF EXISTS `usertypedic`;
CREATE TABLE `usertypedic` (
  `type` int(1) unsigned zerofill NOT NULL,
  `role` varchar(255) NOT NULL,
  KEY `type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of usertypedic
-- ----------------------------
INSERT INTO `usertypedic` VALUES ('0', '普通用户');
INSERT INTO `usertypedic` VALUES ('1', '管理员');
INSERT INTO `usertypedic` VALUES ('2', '负责老师');
INSERT INTO `usertypedic` VALUES ('3', '物品管理员');
