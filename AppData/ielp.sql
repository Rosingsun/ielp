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

 Date: 28/10/2021 18:19:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dynamic
-- ----------------------------
DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '动态id',
  `user_id` int NOT NULL COMMENT '用户id',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '动态信息',
  `like` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '点赞数量',
  `comment` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '评论',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `d_uid`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dynamic
-- ----------------------------
INSERT INTO `dynamic` VALUES (1, 1, '{\r\n    \"dynamicInfo\": \"诶嘿，诶嘿嘿IEhi额hi和\"\r\n}', 0, 0, '2021-10-28 16:59:50', '2021-10-28 16:59:50');
INSERT INTO `dynamic` VALUES (2, 1, '\"诶嘿，诶嘿嘿IEhi额hi和\"\r\n', 0, 0, '2021-10-28 17:00:45', '2021-10-28 17:00:45');
INSERT INTO `dynamic` VALUES (3, 1, '诶嘿，诶嘿嘿IEhi额hi和', 0, 0, '2021-10-28 17:01:36', '2021-10-28 17:01:36');

-- ----------------------------
-- Table structure for dynamic_collect
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_collect`;
CREATE TABLE `dynamic_collect`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '动态id',
  `user_id` int NOT NULL COMMENT '用户id',
  `dynamic_id` int NOT NULL COMMENT '动态id',
  `is_collect` tinyint NOT NULL COMMENT '是否点赞',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dynamic_collect
-- ----------------------------

-- ----------------------------
-- Table structure for dynamic_comment
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_comment`;
CREATE TABLE `dynamic_comment`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '动态id',
  `user_id` int NOT NULL COMMENT '用户id',
  `dynamic_id` int NOT NULL COMMENT '动态id',
  `is_comment` tinyint NULL DEFAULT NULL COMMENT '是否点赞',
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否点赞',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dynamic_comment
-- ----------------------------

-- ----------------------------
-- Table structure for dynamic_like
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_like`;
CREATE TABLE `dynamic_like`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '动态id',
  `user_id` int NOT NULL COMMENT '用户id',
  `dynamic_id` int NOT NULL COMMENT '动态id',
  `is_like` tinyint NOT NULL COMMENT '是否点赞',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dynamic_like
-- ----------------------------
INSERT INTO `dynamic_like` VALUES (1, 1, 1, 0, '2021-10-28 17:18:12', '2021-10-28 17:21:15');

-- ----------------------------
-- Table structure for test_listen
-- ----------------------------
DROP TABLE IF EXISTS `test_listen`;
CREATE TABLE `test_listen`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of test_listen
-- ----------------------------

-- ----------------------------
-- Table structure for test_read
-- ----------------------------
DROP TABLE IF EXISTS `test_read`;
CREATE TABLE `test_read`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of test_read
-- ----------------------------

-- ----------------------------
-- Table structure for test_word
-- ----------------------------
DROP TABLE IF EXISTS `test_word`;
CREATE TABLE `test_word`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of test_word
-- ----------------------------

-- ----------------------------
-- Table structure for translate_history
-- ----------------------------
DROP TABLE IF EXISTS `translate_history`;
CREATE TABLE `translate_history`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '翻译词条的id（该条翻译的id）',
  `user_id` int NOT NULL COMMENT '用户id（谁翻译的）',
  `translated_word` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '翻译内容（我想翻译的内容）',
  `is_collection` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否收藏',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of translate_history
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '账户id',
  `username` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '昵称',
  `email` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '邮箱',
  `phone_number` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '电话号码',
  `profile` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '用户头像',
  `sex` enum('男','女','保密') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '保密' COMMENT '性别',
  `birthday` date NOT NULL COMMENT '生日',
  `clock_in_continuity` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '持续打卡时间',
  `clock_in_total` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '总共打卡时间',
  `study_time` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '学习时间',
  `identify_img` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '识图总数',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `index_user_username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'root', '$2a$10$f1nl5TkUrbdCdF97szaPauxhZfC/cr5EO7y/mhmrlwpQ.VtHJBiqq', '', '', '', '', '保密', '2021-10-28', 0, 0, 0, 0, '2021-10-28 16:18:34', '2021-10-28 16:18:34');

-- ----------------------------
-- Table structure for user_follow
-- ----------------------------
DROP TABLE IF EXISTS `user_follow`;
CREATE TABLE `user_follow`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL COMMENT '用户id',
  `follow_user_id` int NOT NULL COMMENT '关注用户id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ur_uid`(`user_id`) USING BTREE,
  INDEX `ur_tuid`(`follow_user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_follow
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
