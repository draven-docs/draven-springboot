/*
 Navicat Premium Data Transfer

 Source Server         : jdmysql8
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : 116.196.77.250:3306
 Source Schema         : slave2

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 13/01/2020 11:03:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '密码',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别',
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, 19, 'uuu', 2, 'user');
INSERT INTO `user` VALUES (4, 18, 'bbbb', 1, 'zzzz');
INSERT INTO `user` VALUES (2, 19, 'uuu', 2, 'user');

SET FOREIGN_KEY_CHECKS = 1;
