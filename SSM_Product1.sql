/*
 Navicat Premium Data Transfer

 Source Server         : mysql80
 Source Server Type    : MySQL
 Source Server Version : 80028 (8.0.28)
 Source Host           : localhost:3306
 Source Schema         : SSM_Product1

 Target Server Type    : MySQL
 Target Server Version : 80028 (8.0.28)
 File Encoding         : 65001

 Date: 10/12/2022 14:31:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Dept
-- ----------------------------
DROP TABLE IF EXISTS `Dept`;
CREATE TABLE `Dept` (
  `d_id` int NOT NULL AUTO_INCREMENT,
  `d_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Dept
-- ----------------------------
BEGIN;
INSERT INTO `Dept` (`d_id`, `d_name`) VALUES (1, '管理部');
INSERT INTO `Dept` (`d_id`, `d_name`) VALUES (2, '市场部');
INSERT INTO `Dept` (`d_id`, `d_name`) VALUES (3, '技术部');
COMMIT;

-- ----------------------------
-- Table structure for Job
-- ----------------------------
DROP TABLE IF EXISTS `Job`;
CREATE TABLE `Job` (
  `j_id` int NOT NULL AUTO_INCREMENT,
  `j_name` varchar(20) DEFAULT NULL,
  `j_salary` double DEFAULT NULL,
  `j_level` int DEFAULT NULL,
  PRIMARY KEY (`j_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Job
-- ----------------------------
BEGIN;
INSERT INTO `Job` (`j_id`, `j_name`, `j_salary`, `j_level`) VALUES (1, '超级管理员', 0, 1);
INSERT INTO `Job` (`j_id`, `j_name`, `j_salary`, `j_level`) VALUES (2, '公司高管', 8000, 1);
INSERT INTO `Job` (`j_id`, `j_name`, `j_salary`, `j_level`) VALUES (3, '运营', 4000, 3);
INSERT INTO `Job` (`j_id`, `j_name`, `j_salary`, `j_level`) VALUES (4, '广告', 3000, 3);
INSERT INTO `Job` (`j_id`, `j_name`, `j_salary`, `j_level`) VALUES (5, '软件开发', 6000, 2);
INSERT INTO `Job` (`j_id`, `j_name`, `j_salary`, `j_level`) VALUES (6, '测试', 5000, 2);
COMMIT;

-- ----------------------------
-- Table structure for Job_level
-- ----------------------------
DROP TABLE IF EXISTS `Job_level`;
CREATE TABLE `Job_level` (
  `jl_id` int DEFAULT NULL,
  `jl_name` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Job_level
-- ----------------------------
BEGIN;
INSERT INTO `Job_level` (`jl_id`, `jl_name`) VALUES (1, '高级');
INSERT INTO `Job_level` (`jl_id`, `jl_name`) VALUES (2, '中级');
INSERT INTO `Job_level` (`jl_id`, `jl_name`) VALUES (3, '低级');
COMMIT;

-- ----------------------------
-- Table structure for RewardAndPunishment
-- ----------------------------
DROP TABLE IF EXISTS `RewardAndPunishment`;
CREATE TABLE `RewardAndPunishment` (
  `rp_id` int NOT NULL AUTO_INCREMENT,
  `rp_type` int DEFAULT NULL,
  `rp_detail` varchar(50) DEFAULT NULL,
  `rp_time` date DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`rp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of RewardAndPunishment
-- ----------------------------
BEGIN;
INSERT INTO `RewardAndPunishment` (`rp_id`, `rp_type`, `rp_detail`, `rp_time`, `user_id`) VALUES (1, 2, '迟到', '2018-07-09', 5);
INSERT INTO `RewardAndPunishment` (`rp_id`, `rp_type`, `rp_detail`, `rp_time`, `user_id`) VALUES (2, 1, '技能大赛一等奖', '2022-04-05', 4);
INSERT INTO `RewardAndPunishment` (`rp_id`, `rp_type`, `rp_detail`, `rp_time`, `user_id`) VALUES (3, 2, '顶撞领导', '2022-06-07', 4);
INSERT INTO `RewardAndPunishment` (`rp_id`, `rp_type`, `rp_detail`, `rp_time`, `user_id`) VALUES (4, 1, '服务器大赛三等奖', '2022-08-09', 1);
INSERT INTO `RewardAndPunishment` (`rp_id`, `rp_type`, `rp_detail`, `rp_time`, `user_id`) VALUES (5, 1, ' Java大赛二等奖', '2022-09-10', 2);
COMMIT;

-- ----------------------------
-- Table structure for Role
-- ----------------------------
DROP TABLE IF EXISTS `Role`;
CREATE TABLE `Role` (
  `r_id` int DEFAULT NULL,
  `r_name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of Role
-- ----------------------------
BEGIN;
INSERT INTO `Role` (`r_id`, `r_name`) VALUES (1, '管理员');
INSERT INTO `Role` (`r_id`, `r_name`) VALUES (2, '普通员工');
COMMIT;

-- ----------------------------
-- Table structure for RPType
-- ----------------------------
DROP TABLE IF EXISTS `RPType`;
CREATE TABLE `RPType` (
  `rpt_id` int DEFAULT NULL,
  `rpt_name` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of RPType
-- ----------------------------
BEGIN;
INSERT INTO `RPType` (`rpt_id`, `rpt_name`) VALUES (1, '奖');
INSERT INTO `RPType` (`rpt_id`, `rpt_name`) VALUES (2, '惩');
COMMIT;

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `u_id` int NOT NULL AUTO_INCREMENT,
  `u_username` varchar(20) DEFAULT NULL,
  `u_password` varchar(20) DEFAULT NULL,
  `u_age` int DEFAULT NULL,
  `u_time` date DEFAULT NULL,
  `dept_id` int DEFAULT NULL,
  `job_id` int DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of User
-- ----------------------------
BEGIN;
INSERT INTO `User` (`u_id`, `u_username`, `u_password`, `u_age`, `u_time`, `dept_id`, `job_id`, `role_id`) VALUES (1, 'admin', '123', 100, '2022-01-01', 1, 1, 1);
INSERT INTO `User` (`u_id`, `u_username`, `u_password`, `u_age`, `u_time`, `dept_id`, `job_id`, `role_id`) VALUES (2, '王明', '123', 90, '2021-09-09', 3, 5, 2);
INSERT INTO `User` (`u_id`, `u_username`, `u_password`, `u_age`, `u_time`, `dept_id`, `job_id`, `role_id`) VALUES (3, '李鹏', '123', 88, '2019-05-03', 1, 2, 1);
INSERT INTO `User` (`u_id`, `u_username`, `u_password`, `u_age`, `u_time`, `dept_id`, `job_id`, `role_id`) VALUES (4, '周腾', '123', 77, '2022-03-02', 2, 3, 2);
INSERT INTO `User` (`u_id`, `u_username`, `u_password`, `u_age`, `u_time`, `dept_id`, `job_id`, `role_id`) VALUES (5, '杨玉', '123', 65, '2017-09-10', 2, 4, 2);
INSERT INTO `User` (`u_id`, `u_username`, `u_password`, `u_age`, `u_time`, `dept_id`, `job_id`, `role_id`) VALUES (6, '刘晨', '123', 38, '2022-08-08', 3, 6, 2);
COMMIT;

-- ----------------------------
-- Table structure for UserInfo
-- ----------------------------
DROP TABLE IF EXISTS `UserInfo`;
CREATE TABLE `UserInfo` (
  `ui_id` int DEFAULT NULL,
  `ui_telephone` varchar(20) DEFAULT NULL,
  `ui_address` varchar(50) DEFAULT NULL,
  `ui_education` varchar(20) DEFAULT NULL,
  `ui_work` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of UserInfo
-- ----------------------------
BEGIN;
INSERT INTO `UserInfo` (`ui_id`, `ui_telephone`, `ui_address`, `ui_education`, `ui_work`) VALUES (1, '18600000000', '公司服务器', '无', '无');
INSERT INTO `UserInfo` (`ui_id`, `ui_telephone`, `ui_address`, `ui_education`, `ui_work`) VALUES (2, '18700000000', '广东省深圳市', '博士', 'Java工程师');
INSERT INTO `UserInfo` (`ui_id`, `ui_telephone`, `ui_address`, `ui_education`, `ui_work`) VALUES (3, '17900000000', '湖北省黄冈市', '研究生', '小米高管');
INSERT INTO `UserInfo` (`ui_id`, `ui_telephone`, `ui_address`, `ui_education`, `ui_work`) VALUES (4, '16800000000', '上海市', '大专', '大数据');
INSERT INTO `UserInfo` (`ui_id`, `ui_telephone`, `ui_address`, `ui_education`, `ui_work`) VALUES (5, '15000000000', '北京市', '本科', '插画设计');
INSERT INTO `UserInfo` (`ui_id`, `ui_telephone`, `ui_address`, `ui_education`, `ui_work`) VALUES (6, '19990000000', '湖北省仙桃市', '本科', '网络运维');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
