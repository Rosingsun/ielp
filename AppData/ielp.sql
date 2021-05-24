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

 Date: 23/05/2021 13:51:03
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
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dynamic
-- ----------------------------
DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic`  (
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `id` int NOT NULL AUTO_INCREMENT COMMENT '动态id',
  `history` int NULL DEFAULT NULL COMMENT '使用翻译记录编号',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '动态信息',
  `like` int NULL DEFAULT NULL COMMENT '点赞数量',
  `comment` int NULL DEFAULT NULL COMMENT '评论',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `d_uid`(`user_id`) USING BTREE,
  CONSTRAINT `d_uid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dynamic_interaction
-- ----------------------------
DROP TABLE IF EXISTS `dynamic_interaction`;
CREATE TABLE `dynamic_interaction`  (
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `id` int NOT NULL AUTO_INCREMENT,
  `is_like` tinyint NULL DEFAULT NULL COMMENT '是否点赞',
  `is_comment` tinyint NULL DEFAULT NULL COMMENT '是否评论',
  `comment_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `dynamic_id` int NULL DEFAULT NULL COMMENT '动态id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `dy_did`(`dynamic_id`) USING BTREE,
  INDEX `dy_uid`(`user_id`) USING BTREE,
  CONSTRAINT `dy_did` FOREIGN KEY (`dynamic_id`) REFERENCES `dynamic` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `dy_uid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for enwords
-- ----------------------------
DROP TABLE IF EXISTS `enwords`;
CREATE TABLE `enwords`  (
  `word` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `translation` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`word`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for translate_history
-- ----------------------------
DROP TABLE IF EXISTS `translate_history`;
CREATE TABLE `translate_history`  (
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '翻译词条的id（该条翻译的id）',
  `language_from` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '翻译语种（我输入的语种）',
  `language_to` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '目标语种（我想翻译成什么语言）',
  `translated_word` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '翻译内容（我想翻译的内容）',
  `picture_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应图片的路径（翻译查询到的图片）',
  `is_collection` tinyint(1) NULL DEFAULT NULL COMMENT '是否收藏',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id（谁翻译的）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `th_uid`(`user_id`) USING BTREE,
  CONSTRAINT `th_uid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for translate_word
-- ----------------------------
DROP TABLE IF EXISTS `translate_word`;
CREATE TABLE `translate_word`  (
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT,
  `word` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单词',
  `translation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '翻译结果',
  `picture_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图像',
  `lyric` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '歌词',
  `uid` int NULL DEFAULT NULL COMMENT '提供者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `id` int NOT NULL AUTO_INCREMENT COMMENT '账户id',
  `email` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone_number` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `pass_word` char(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `id` int NOT NULL AUTO_INCREMENT COMMENT '信息id',
  `nick_name` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `profile` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '男' COMMENT '性别',
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `clock_in_continuity` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '持续打卡时间',
  `clock_in_total` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '总共打卡时间',
  `study_time` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '学习时间',
  `identify_img` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '识图总数',
  `user_id` int NOT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ui_uid`(`user_id`) USING BTREE,
  CONSTRAINT `ui_uid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_relation`;
CREATE TABLE `user_relation`  (
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `target_user_id` int NULL DEFAULT NULL COMMENT '目标用户id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ur_uid`(`user_id`) USING BTREE,
  INDEX `ur_tuid`(`target_user_id`) USING BTREE,
  CONSTRAINT `ur_tuid` FOREIGN KEY (`target_user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ur_uid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
