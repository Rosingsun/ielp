/*
 Navicat MySQL Data Transfer

 Source Server         : 本地连接
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : ielp

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 10/05/2021 15:46:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `admin_name` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pass_word` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin');
INSERT INTO `admin` VALUES (2, 'zzddadmin', '123456');
INSERT INTO `admin` VALUES (7, '1', '1');

-- ----------------------------
-- Table structure for translate
-- ----------------------------
DROP TABLE IF EXISTS `translate`;
CREATE TABLE `translate`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '翻译词条的id（该条翻译的id）',
  `language_from` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '翻译语种（我输入的语种）',
  `language_to` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '目标语种（我想翻译成什么语言）',
  `translated_words` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '翻译内容（我想翻译的内容）',
  `translated_time` datetime NULL DEFAULT NULL COMMENT '翻译的时间（我翻译的时间）',
  `pic_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应图片的路径（翻译查询到的图片）',
  `user_id` int UNSIGNED NULL DEFAULT NULL COMMENT '用户id（谁翻译的）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of translate
-- ----------------------------
INSERT INTO `translate` VALUES (1, 'english', '中文', 'a', '2021-05-09 17:12:15', NULL, 1);
INSERT INTO `translate` VALUES (2, '6', '7', 'hello', '2021-05-09 18:52:12', '', 1);
INSERT INTO `translate` VALUES (3, '6', '7', 'hello', '2021-05-09 18:54:10', '', 1);

-- ----------------------------
-- Table structure for translate_word_picture
-- ----------------------------
DROP TABLE IF EXISTS `translate_word_picture`;
CREATE TABLE `translate_word_picture`  (
  `id` int NOT NULL,
  `word` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of translate_word_picture
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '账户id',
  `nick_name` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `profile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `email` char(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1@zjsru.edu' COMMENT '邮箱',
  `phone_number` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '电话号码',
  `pass_word` char(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123456' COMMENT '密码',
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '男' COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `clock_in_continuity` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '持续打卡时间',
  `clock_in_total` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '总共打卡时间',
  `study_time` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '学习时间',
  `identify_img` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '识图总数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '幕冬', NULL, '66@qq.com', '19858161283', '666', '男', '2021-04-28', 0, 1, 1, 201);
INSERT INTO `user` VALUES (2, '管理员', NULL, '1@zjsru.edu', '19858666666', 'Admin666!?', '男', '2021-04-28', 0, 0, 0, 200);

SET FOREIGN_KEY_CHECKS = 1;
