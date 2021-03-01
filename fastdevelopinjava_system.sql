/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : fastdevelopinjava_system

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 01/03/2021 22:33:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for api_info
-- ----------------------------
DROP TABLE IF EXISTS `api_info`;
CREATE TABLE `api_info`  (
  `api_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'api id',
  `api_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '接口编码',
  `api_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '接口名称',
  `api_desc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '接口描述',
  `app_id` int(11) NULL DEFAULT NULL COMMENT '应用id',
  `need_auth` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否需要授权才能访问',
  `delete_flag` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否删除',
  `creat_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `api_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`api_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of api_info
-- ----------------------------
INSERT INTO `api_info` VALUES (6, '1', '1', '1', 1, '0', NULL, '2021-02-21 23:52:20', '2021-02-21 23:52:20', '1');
INSERT INTO `api_info` VALUES (7, '3', '3', '3', 1, '0', NULL, '2021-02-21 23:53:04', '2021-02-21 23:53:04', '3');
INSERT INTO `api_info` VALUES (8, '', '', '', 1, '0', NULL, '2021-02-22 00:28:15', '2021-02-22 00:28:15', '');
INSERT INTO `api_info` VALUES (9, '', '', '', 1, '0', NULL, '2021-02-22 00:28:24', '2021-02-22 00:28:24', '');
INSERT INTO `api_info` VALUES (10, '', '', '', 1, '0', NULL, '2021-02-22 22:08:16', '2021-02-22 22:08:16', '');
INSERT INTO `api_info` VALUES (11, 'tescode', 'ddd', 'ddd', 5, '0', NULL, '2021-02-23 20:36:29', '2021-02-23 20:36:29', 'ddd');
INSERT INTO `api_info` VALUES (12, 'ddd', 'ddd', 'ddd', 4, '1', NULL, '2021-02-23 20:40:24', '2021-02-23 20:40:24', 'dd');
INSERT INTO `api_info` VALUES (13, 'ddd', 'ddd', 'ddd', 5, '1', NULL, '2021-02-23 20:40:34', '2021-02-23 20:40:34', 'dd');
INSERT INTO `api_info` VALUES (14, '55', '55', '5', 5, '1', NULL, '2021-02-24 20:27:59', '2021-02-24 20:27:59', '55');
INSERT INTO `api_info` VALUES (15, 'apiCode', '', '', 5, '1', NULL, '2021-02-25 22:33:53', '2021-02-25 22:33:53', '/apiinfo/delete');

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application`  (
  `app_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'app id',
  `app_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'app名称',
  `app_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'app编码',
  `app_desc` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'app描述',
  `app_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'app类型,1=application 2=service',
  `delete_flag` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '是否删除',
  `app_https` int(11) NULL DEFAULT 0 COMMENT '是否支持https，0不支持1支持，默认为0不支持',
  `app_host` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT 'localhost' COMMENT 'ip或者主机名',
  `app_context` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '资源前缀',
  `app_port` int(11) NULL DEFAULT NULL COMMENT '端口号',
  `creat_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`app_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES (5, '系统管理', 'system_manage', '系统管理', '1', '0', 0, 'localhost', 'fastdevelopinjava-service-system', 50006, '2021-02-18 22:33:54', '2021-02-24 20:36:56');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'menu id',
  `menu_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `menu_code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单编码',
  `menu_url` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单路径',
  `menu_icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `menu_pid` int(11) NULL DEFAULT NULL COMMENT '父菜单id，如果menu_type=-1，代表当前父菜单id为客户端id',
  `menu_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单类型,\n\n-1->客户端\n\n0->目录 1->页面路由 2->按钮',
  `menu_visible` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '如果是按钮类型,按钮是否可见',
  `menu_api_ids` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '如果是按钮类型,按钮关联的接口',
  `delete_flag` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '是否删除',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '父菜单测试', 'string', 'string', 'string', 1, 'string', 'string', 'string', '0', '2021-02-28 20:04:40', '2021-03-01 20:57:12');
INSERT INTO `menu` VALUES (2, 'string', 'string', 'string', 'string', 1, 'string', 'string', 'string', '0', '2021-03-01 20:11:04', '2021-03-01 20:56:53');
INSERT INTO `menu` VALUES (3, 'string', 'string', 'string', 'string', 1, 'string', 'string', 'string', '0', '2021-03-01 20:11:57', '2021-03-01 20:56:53');

-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details`  (
  `client_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `resource_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `client_secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `scope` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `authorized_grant_types` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `web_server_redirect_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `authorities` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `access_token_validity` int(11) NULL DEFAULT NULL,
  `refresh_token_validity` int(11) NULL DEFAULT NULL,
  `additional_information` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `autoapprove` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态 0 ---  刚刚创建\n     1 ---  申请中\n    2 --- 申请通过\n    3 --- 申请拒绝\n',
  `delete_flag` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '是否删除\n',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `client_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '客户端名称'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('string', 'string', 'string', 'string', 'string', 'string', 'string', 0, 0, 'string', 'string', 'string', '1', '2021-02-27 20:05:10', '2021-02-27 20:27:05', NULL);
INSERT INTO `oauth_client_details` VALUES ('string', 'string', 'string', 'string', 'string', 'string', 'string', 0, 0, 'string', 'string', 'string', '0', '2021-02-27 20:17:52', '2021-02-27 20:24:42', NULL);
INSERT INTO `oauth_client_details` VALUES ('string', 'string', 'string', 'string', 'string', 'string', 'string', 0, 0, 'string', 'string', 'string', '0', '2021-02-28 14:44:10', '2021-02-28 14:46:17', NULL);
INSERT INTO `oauth_client_details` VALUES ('string', 'string', 'string', 'string', 'string', 'string', 'string', 0, 0, 'string', 'string', 'string', '0', '2021-02-28 14:46:08', '2021-02-28 14:46:08', NULL);
INSERT INTO `oauth_client_details` VALUES ('fastinjava_web', '5', '123456', 'string', 'string', 'string', 'string', 16000, 16000, 'string', 'string', 'string', '0', '2021-02-28 14:47:26', '2021-02-28 14:47:26', NULL);
INSERT INTO `oauth_client_details` VALUES ('string', 'string', 'string', 'string', 'string', 'string', 'string', 0, 0, 'string', 'string', 'string', '0', '2021-02-28 14:48:40', '2021-02-28 14:48:40', NULL);
INSERT INTO `oauth_client_details` VALUES ('string', 'string', 'string', 'string', 'string', 'string', 'string', 0, 0, 'string', 'string', 'string', '0', '2021-02-28 14:49:04', '2021-02-28 14:49:04', NULL);

SET FOREIGN_KEY_CHECKS = 1;
