/*
 Navicat MySQL Data Transfer

 Source Server         : 本地连接
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : ielp

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 16/11/2021 14:19:05
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
  `type` enum('图文消息','翻译分享') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图文消息，翻译分享',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '动态信息',
  `
related_articles` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '相关文章',
  `music_path` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '音乐路径',
  `translate_history_id` int NOT NULL COMMENT '翻译记录id',
  `image_num` int NOT NULL COMMENT '图片数量',
  `like` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '点赞数量',
  `comment` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '评论',
  `collect` int NOT NULL DEFAULT 0 COMMENT '收藏',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `d_uid`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dynamic
-- ----------------------------

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
  `is_comment` tinyint NULL DEFAULT NULL COMMENT '是否评论',
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评论内容',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dynamic_comment
-- ----------------------------

-- ----------------------------
-- Table structure for dynamic_image
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_image`;
CREATE TABLE `dynamic_image`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '动态与音乐文件的关系表',
  `dynamic_id` int NOT NULL COMMENT '动态id',
  `file_image_id` int NOT NULL COMMENT '音乐文件id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dynamic_image
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

-- ----------------------------
-- Table structure for dynamic_music
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_music`;
CREATE TABLE `dynamic_music`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '动态与音乐文件的关系表',
  `dynamic_id` int NOT NULL COMMENT '动态id',
  `file_music_id` int NOT NULL COMMENT '音乐文件id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '动态与音乐文件的关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dynamic_music
-- ----------------------------

-- ----------------------------
-- Table structure for file_image
-- ----------------------------
DROP TABLE IF EXISTS `file_image`;
CREATE TABLE `file_image`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '动态id',
  `file_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件路径',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file_image
-- ----------------------------

-- ----------------------------
-- Table structure for file_music
-- ----------------------------
DROP TABLE IF EXISTS `file_music`;
CREATE TABLE `file_music`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '动态id',
  `file_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件路径',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file_music
-- ----------------------------

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
