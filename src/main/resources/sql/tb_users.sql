/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50022
Source Host           : localhost:3306
Source Database       : peace

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2020-04-21 18:08:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_users`
-- ----------------------------
DROP TABLE IF EXISTS `tb_users`;
CREATE TABLE `tb_users` (
  `id` int(11) NOT NULL auto_increment COMMENT 'id',
  `name` varchar(20) NOT NULL default '' COMMENT '名字',
  `age` int(11) NOT NULL default '0' COMMENT '年纪',
  `password` varchar(225) NOT NULL default '' COMMENT '密码',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_users
-- ----------------------------
INSERT INTO `tb_users` VALUES ('1', 'an', '23', '111111');
