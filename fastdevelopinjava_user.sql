/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.21 : Database - fastdevelopinjava_user
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fastdevelopinjava_user` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `fastdevelopinjava_user`;

/*Table structure for table `organization` */

DROP TABLE IF EXISTS `organization`;

CREATE TABLE `organization` (
  `org_id` int NOT NULL AUTO_INCREMENT COMMENT '组织id',
  `org_pid` int DEFAULT NULL COMMENT '组织父id',
  `org_name` varchar(100) DEFAULT NULL COMMENT '组织名称',
  `org_code` varchar(100) DEFAULT NULL COMMENT '组织编码',
  `org_desc` varchar(100) DEFAULT NULL COMMENT '组织描述',
  `delete_flag` varchar(100) DEFAULT '0' COMMENT '是否删除',
  `creat_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`org_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `organization` */

insert  into `organization`(`org_id`,`org_pid`,`org_name`,`org_code`,`org_desc`,`delete_flag`,`creat_time`,`update_time`) values (1,0,'42e442e9707311ebadd50a0027000012','42e44368707311ebadd50a0027000012','1','1','2021-01-28 22:11:04','2021-02-17 00:40:00'),(2,0,'42e475db707311ebadd50a0027000012','42e475f2707311ebadd50a0027000012','42e475fb707311ebadd50a0027000012','0','2021-01-28 22:11:09','2021-02-17 00:23:11'),(3,0,'42e47734707311ebadd50a0027000012','42e4773f707311ebadd50a0027000012','42e47746707311ebadd50a0027000012','0','2021-01-28 22:11:10','2021-02-17 00:23:11'),(4,0,'42e477e2707311ebadd50a0027000012','42e477eb707311ebadd50a0027000012','42e477f2707311ebadd50a0027000012','0','2021-01-28 22:11:10','2021-02-17 00:23:11'),(5,0,'42e4789d707311ebadd50a0027000012','42e478a7707311ebadd50a0027000012','42e478ad707311ebadd50a0027000012','0','2021-01-28 22:11:10','2021-02-17 00:23:11'),(6,1,'42e47939707311ebadd50a0027000012','42e47942707311ebadd50a0027000012','42e47949707311ebadd50a0027000012','0','2021-01-28 22:11:10','2021-02-17 00:23:11'),(7,0,'42e479ed707311ebadd50a0027000012','42e479f6707311ebadd50a0027000012','42e479fd707311ebadd50a0027000012','0','2021-01-28 22:11:11','2021-02-17 00:23:11'),(8,0,'42e47a95707311ebadd50a0027000012','42e47a9e707311ebadd50a0027000012','42e47aa5707311ebadd50a0027000012','0','2021-01-28 22:11:11','2021-02-17 00:23:11'),(9,0,'42e47b49707311ebadd50a0027000012','42e47b52707311ebadd50a0027000012','42e47b59707311ebadd50a0027000012','0','2021-01-28 22:11:11','2021-02-17 00:23:11'),(10,0,'42e47be3707311ebadd50a0027000012','42e47bec707311ebadd50a0027000012','42e47bf3707311ebadd50a0027000012','0','2021-01-28 22:11:11','2021-02-17 00:23:11'),(11,0,'42e47cf0707311ebadd50a0027000012','42e47cfb707311ebadd50a0027000012','42e47d02707311ebadd50a0027000012','0','2021-01-28 22:11:50','2021-02-17 00:23:11'),(12,0,'fff','ff','fff','0','2021-02-17 00:37:00','2021-02-17 00:37:00'),(13,12,'vv','x','1','1','2021-02-17 00:37:36','2021-02-17 20:21:44'),(14,12,'jfldjkf','ggg','1','1','2021-02-17 00:39:49','2021-02-17 19:49:35');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `org_id` int DEFAULT NULL COMMENT '所属组织id',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(100) DEFAULT NULL COMMENT '角色编码',
  `role_desc` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `delete_flag` varchar(100) DEFAULT '0' COMMENT '是否删除',
  `creat_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `role` */

insert  into `role`(`id`,`org_id`,`role_name`,`role_code`,`role_desc`,`delete_flag`,`creat_time`,`update_time`) values (1,2,'测试角色update','test_role','测试角色1','1','2021-01-20 21:42:00','2021-02-17 23:56:58'),(2,2,'测试角色','test_role','测试角色','0','2021-01-21 11:21:38','2021-02-17 23:56:58'),(3,2,'测试角色','test_role','测试角色','0','2021-01-30 16:31:38','2021-02-17 23:56:58'),(4,2,'test_role3 名称','test_role3','test_role3 描述','0','2021-02-17 22:42:27','2021-02-17 23:56:58'),(5,2,'打断点','jfdl','jfdljfl','0','2021-02-17 22:57:51','2021-02-17 23:56:58'),(6,2,'dd','ddd','dd','0','2021-02-17 23:07:09','2021-02-17 23:56:58'),(7,2,'dd','ddd','dd','0','2021-02-17 23:20:38','2021-02-17 23:56:58'),(8,2,'vv','vv','vv','0','2021-02-17 23:21:04','2021-02-17 23:56:58'),(9,2,'vv','vv','vv','0','2021-02-17 23:21:47','2021-02-17 23:56:58'),(10,2,'vv','vv','vv','0','2021-02-17 23:22:35','2021-02-17 23:56:58'),(11,2,'vv','vv','vv','0','2021-02-17 23:23:03','2021-02-17 23:56:58'),(12,2,'vv','vv','vv','0','2021-02-17 23:25:46','2021-02-17 23:25:46'),(13,2,'vv','vv','vv','0','2021-02-17 23:25:58','2021-02-17 23:25:58');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(200) DEFAULT NULL COMMENT '/*用户密码*/',
  `user_nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户昵称',
  `user_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '用户邮箱',
  `delete_flag` int DEFAULT NULL COMMENT '删除标识',
  `updated_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `created_user_id` int DEFAULT NULL COMMENT '创建用户主键id',
  `updated_user_id` int DEFAULT NULL COMMENT '更新用户主键id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_name`,`password`,`user_nick_name`,`user_email`,`delete_flag`,`updated_time`,`created_user_id`,`updated_user_id`,`created_time`) values (1,'1',NULL,'1','1',1,'2021-01-16 15:04:01',1,1,'2021-01-16 15:03:59'),(2,'string',NULL,'string',NULL,0,NULL,NULL,NULL,NULL),(3,'lifuyong',NULL,'李付勇',NULL,0,NULL,NULL,NULL,NULL),(4,'lifuyong',NULL,'李付勇','13761809951@163.com',0,NULL,NULL,NULL,NULL),(5,'lifuyong',NULL,'李付勇','13761809951@163.com',0,NULL,NULL,NULL,'2021-01-20 14:44:12'),(6,'lifuyong',NULL,'李付勇','13761809951@163.com',0,NULL,NULL,NULL,'2021-01-20 14:44:13'),(7,'lifuyong',NULL,'李付勇','13761809951@163.com',0,NULL,NULL,NULL,'2021-01-20 14:44:13'),(8,'lifuyong',NULL,'李付勇','13761809951@163.com',0,NULL,NULL,NULL,'2021-01-20 14:44:14'),(9,'lifuyong',NULL,'李付勇','13761809951@163.com',0,'2021-01-20 14:45:24',NULL,NULL,'2021-01-20 14:45:24'),(10,'lifuyong','123456','李付勇','13761809951@163.com',0,'2021-01-20 14:48:00',NULL,NULL,'2021-01-20 14:48:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
