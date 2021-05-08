/*
 Navicat Premium Data Transfer

 Source Server         : demo
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : ielp

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 08/05/2021 14:41:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `admin_name` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pass_word` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for translate
-- ----------------------------
DROP TABLE IF EXISTS `translate`;
CREATE TABLE `translate`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '翻译词条的id（该条翻译的id）',
  `from` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '翻译语种（我输入的语种）',
  `to` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '目标语种（我想翻译成什么语言）',
  `translatedWords` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '翻译内容（我想翻译的内容）',
  `translatedTime` date NULL DEFAULT NULL COMMENT '翻译的时间（我翻译的时间）',
  `picUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应图片的路径（翻译查询到的图片）',
  `userId` int(11) NULL DEFAULT NULL COMMENT '用户id（谁翻译的）',
  `userHead` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像（谁翻译的人的头像）',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '谁翻译的人的姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of translate
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '账户id',
  `user_Head` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像路径',
  `nick_name` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `email` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1@zjsru.edu' COMMENT '邮箱',
  `phone_number` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '电话号码',
  `pass_word` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123456' COMMENT '密码',
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '男' COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `clock_in_continuity` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '持续打卡时间',
  `clock_in_total` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '总共打卡时间',
  `study_time` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '学习时间',
  `identify_img` int(10) UNSIGNED NOT NULL DEFAULT 0 COMMENT '识图总数',
  `translate_times` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT '翻译次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (0, NULL, '幕冬', '66@qq.com', '19858161283', '666', '男', '2021-04-28', 0, 1, 1, 201, 0000000000);
INSERT INTO `user` VALUES (2, NULL, '管理员', '1@zjsru.edu', '19858666666', 'Admin666!?', '男', '2021-04-28', 0, 0, 0, 200, 0000000000);

SET FOREIGN_KEY_CHECKS = 1;
