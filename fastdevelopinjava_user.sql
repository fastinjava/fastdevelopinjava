/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : fastdevelopinjava_user

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 20/01/2021 00:11:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `user_nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `user_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `delete_flag` int(11) NULL DEFAULT NULL COMMENT '删除标识',
  `updated_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `created_user_id` int(11) NULL DEFAULT NULL COMMENT '创建用户主键id',
  `updated_user_id` int(11) NULL DEFAULT NULL COMMENT '更新用户主键id',
  `created_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '1', '1', '1', 1, '2021-01-16 15:04:01', 1, 1, '2021-01-16 15:03:59');

SET FOREIGN_KEY_CHECKS = 1;


create table if not exists role
(
	id int auto_increment comment '角色id'
		primary key,
	role_name varchar(100) null comment '角色名称',
	role_code varchar(100) null comment '角色编码',
	role_desc varchar(100) null comment '角色描述',
	delete_flag varchar(100) default '0' null comment '是否删除',
	creat_time timestamp default CURRENT_TIMESTAMP null,
	update_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);



create table if not exists organization
(
	org_id int auto_increment comment '组织id'
		primary key,
	org_pid int null comment '组织父id',
	org_name varchar(100) null comment '组织名称',
	org_code varchar(100) null comment '组织编码',
	org_desc varchar(100) null comment '组织描述',
	delete_flag varchar(100) default '0' null comment '是否删除',
	creat_time timestamp default CURRENT_TIMESTAMP null,
	update_time timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP
);

