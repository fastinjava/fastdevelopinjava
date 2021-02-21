/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.21 : Database - fastdevelopinjava_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fastdevelopinjava_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `fastdevelopinjava_system`;

/*Table structure for table `api_info` */

DROP TABLE IF EXISTS `api_info`;

CREATE TABLE `api_info` (
  `api_id` int NOT NULL AUTO_INCREMENT COMMENT 'api id',
  `api_code` varchar(100) DEFAULT NULL COMMENT '接口编码',
  `api_name` varchar(100) DEFAULT NULL COMMENT '接口名称',
  `api_desc` varchar(100) DEFAULT NULL COMMENT '接口描述',
  `app_id` int DEFAULT NULL COMMENT '应用id',
  `need_auth` varchar(1) DEFAULT NULL COMMENT '是否需要授权才能访问',
  `delete_flag` varchar(1) DEFAULT NULL COMMENT '是否删除',
  `creat_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `api_url` varchar(100) DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`api_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `api_info` */

insert  into `api_info`(`api_id`,`api_code`,`api_name`,`api_desc`,`app_id`,`need_auth`,`delete_flag`,`creat_time`,`update_time`,`api_url`) values (6,'apiCode','apiName','apiDesc',1,'0','0','2021-02-21 22:42:13','2021-02-21 22:42:13','apiUrl'),(7,'2','2','2',1,'0',NULL,'2021-02-21 22:53:55','2021-02-21 22:53:55','33');

/*Table structure for table `application` */

DROP TABLE IF EXISTS `application`;

CREATE TABLE `application` (
  `app_id` int NOT NULL AUTO_INCREMENT COMMENT 'app id',
  `app_name` varchar(100) DEFAULT NULL COMMENT 'app名称',
  `app_code` varchar(100) DEFAULT NULL COMMENT 'app编码',
  `app_desc` varchar(100) DEFAULT NULL COMMENT 'app描述',
  `app_type` varchar(100) DEFAULT NULL COMMENT 'app类型,1=application 2=service',
  `delete_flag` varchar(100) DEFAULT '0' COMMENT '是否删除',
  `app_https` int DEFAULT '0' COMMENT '是否支持https，0不支持1支持，默认为0不支持',
  `app_host` varchar(20) DEFAULT 'localhost' COMMENT 'ip或者主机名',
  `app_context` varchar(100) DEFAULT NULL COMMENT '资源前缀',
  `app_port` int DEFAULT NULL COMMENT '端口号',
  `creat_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`app_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `application` */

insert  into `application`(`app_id`,`app_name`,`app_code`,`app_desc`,`app_type`,`delete_flag`,`app_https`,`app_host`,`app_context`,`app_port`,`creat_time`,`update_time`) values (1,'用户中心','service_ucenter','用户中心管理','1','0',0,'localhost','fastdevelopinjava-service-ucenter',50005,'2021-01-29 14:10:23','2021-02-18 20:25:09'),(2,'demoData','demoData','demoData','demoData','0',1,'demoData',NULL,1,'2021-02-18 21:36:42','2021-02-18 21:36:42'),(3,'demoData','demoData','demoData','demoData','0',1,'demoData',NULL,1,'2021-02-18 21:37:06','2021-02-18 21:37:06'),(4,'系统管理','system_manage','系统管理','1','0',0,'localhost',NULL,50007,'2021-02-18 21:43:59','2021-02-18 21:43:59'),(5,'系统管理','system_manage','系统管理','1','0',0,'localhost','fastdevelopinjava-service-system',50007,'2021-02-18 22:33:54','2021-02-18 22:33:54');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
