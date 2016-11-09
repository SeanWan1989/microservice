/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : mybatis

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2016-10-31 15:24:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` varchar(32) CHARACTER SET utf8 NOT NULL,
  `title` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `userid` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid_foreign1` (`userid`),
  CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `blog_user` (`userid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES ('1', 'java并发编程', 'http://blog.csdn.net/isea533\r\n', '1\r\n');
INSERT INTO `blog` VALUES ('2', 'java8', 'http://www.google.com\r\n', '533\r\n');

-- ----------------------------
-- Table structure for blog_comments
-- ----------------------------
DROP TABLE IF EXISTS `blog_comments`;
CREATE TABLE `blog_comments` (
  `commentid` varchar(32) CHARACTER SET utf8 NOT NULL,
  `postid` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `msg` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`commentid`),
  KEY `postid_foreign` (`postid`),
  CONSTRAINT `blog_comments_ibfk_1` FOREIGN KEY (`postid`) REFERENCES `blog_post` (`postid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of blog_comments
-- ----------------------------
INSERT INTO `blog_comments` VALUES ('1', '1', '专家费\r\n', '楼主好！\r\n');
INSERT INTO `blog_comments` VALUES ('2', '1', '噶额外\r\n', '不错，顶！！！\r\n');
INSERT INTO `blog_comments` VALUES ('3', '2', '光和热\r\n', '支持楼主！！\r\n');
INSERT INTO `blog_comments` VALUES ('4', '3', '静态化\r\n', '谢谢楼主！！\r\n');
INSERT INTO `blog_comments` VALUES ('5', '3', '俄国和\r\n', '同谢！！\r\n');

-- ----------------------------
-- Table structure for blog_post
-- ----------------------------
DROP TABLE IF EXISTS `blog_post`;
CREATE TABLE `blog_post` (
  `postid` varchar(32) CHARACTER SET utf8 NOT NULL,
  `userid` varchar(32) CHARACTER SET utf8 DEFAULT NULL,
  `postdate` date DEFAULT NULL,
  `postinfo` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`postid`),
  KEY `userid_foreign2` (`userid`),
  CONSTRAINT `blog_post_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `blog_user` (`userid`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of blog_post
-- ----------------------------
INSERT INTO `blog_post` VALUES ('1', '533\r\n', '2016-10-31', 'EasyUI特殊情况下的BUG整理 http://blog.csdn.net/isea533/article/details/17953787 该问题在IE下显示如下： 放大后： 可以看到本该是箭头的位置，出现了一个缺口，很影响美观。。 解决方法有两种，一种最简单的方式就是在IE下不显示箭头。\r\n');
INSERT INTO `blog_post` VALUES ('2', '1\r\n', '2016-10-11', '今天打开别人分享的一个有道云笔记的时候网页一直显示载入中... 刷新多次都无效，然后F12打开开发者工具，发现有两个js请求失败，单独在链接中打开js很正常。 显示如下图： 在Request Header这里显示CAUTION Provisional headers are shown\r\n');
INSERT INTO `blog_post` VALUES ('3', '1\r\n', '2016-10-04', '前面有两篇： Easyui - combo[tree,box]下拉图标有间隙bug解决方法 http://blog.csdn.net/isea533/article/details/12996561 Easyui - dialog,window影响父页面布局的BUG解决方法 http://blog.csdn.net/isea533/article/details/13000\r\n');
INSERT INTO `blog_post` VALUES ('4', '533\r\n', '2016-10-10', '2012年统计用区划代码和城乡划分代码 数据来源:http://www.stats.gov.cn/zjtj/tjbz/tjyqhdmhcxhfdm/2012/ 格式:XML 预览图: 下载地址： 全国数据（所有数据都在一个XML内）：http://pan.baidu.com/s/1hqxD6vU 分省数据：http://pan.\r\n');

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `userid` varchar(32) CHARACTER SET utf8 NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `userinfo` varchar(200) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of blog_user
-- ----------------------------
INSERT INTO `blog_user` VALUES ('1\r\n', 'test\r\n', '123456\r\n', 'Test\r\n');
INSERT INTO `blog_user` VALUES ('533\r\n', 'abel533\r\n', '123456\r\n', 'java - 没事看看\r\n');

-- ----------------------------
-- Table structure for t_city
-- ----------------------------
DROP TABLE IF EXISTS `t_city`;
CREATE TABLE `t_city` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_city
-- ----------------------------
INSERT INTO `t_city` VALUES ('1', 'ShangHai', 'SH', 'nimeiadddddddddddddddd');
