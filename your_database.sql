/*
 Navicat Premium Data Transfer

 Source Server         : 114.132.123.49_3306
 Source Server Type    : MySQL
 Source Server Version : 50744
 Source Host           : 114.132.123.49:3306
 Source Schema         : your_database

 Target Server Type    : MySQL
 Target Server Version : 50744
 File Encoding         : 65001

 Date: 19/12/2024 19:12:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT ' 客户编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '客户名称',
  `linkman` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '联系人',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '移动电话\r\n',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '固定电话',
  `postal_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '邮政编号',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '地址',
  `source_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '客户来源',
  `industry_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '所属行业',
  `grade_id` int(11) NOT NULL COMMENT '客户级别',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_emp_dept`(`linkman`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 87 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES (33, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (34, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (35, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (36, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (37, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (38, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (39, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (41, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (42, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (43, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (44, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (45, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (46, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (47, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (48, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (50, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (51, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (53, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (54, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (55, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (56, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (57, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (58, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (59, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '3', '3', 3);
INSERT INTO `emp` VALUES (60, '客户ABC', '李四', '13800138003', '010-11111111', '300000', '天津市南开区', '1', '1', 1);
INSERT INTO `emp` VALUES (61, '客户DEF', '张三', '13800138004', '010-11111112', '300001', '北京市海淀区', '1', '1', 2);
INSERT INTO `emp` VALUES (62, '客户GHI', '王五', '13800138005', '010-11111113', '300002', '上海市浦东新区', '1', '1', 3);
INSERT INTO `emp` VALUES (63, '客户JKL', '赵六', '13800138006', '010-11111114', '300003', '广州市天河区', '1', '2', 1);
INSERT INTO `emp` VALUES (64, '客户MNO', '李四', '13800138007', '010-11111115', '300004', '深圳市南山区', '1', '2', 2);
INSERT INTO `emp` VALUES (65, '客户PQR', '张三', '13800138008', '010-11111116', '300005', '杭州市西湖区', '1', '2', 3);
INSERT INTO `emp` VALUES (66, '客户STU', '王五', '13800138009', '010-11111117', '300006', '武汉市江汉区', '1', '3', 1);
INSERT INTO `emp` VALUES (67, '客户VWX', '赵六', '13800138010', '010-11111118', '300007', '重庆市渝中区', '1', '3', 2);
INSERT INTO `emp` VALUES (68, '客户YZA', '李四', '13800138011', '010-11111119', '300008', '成都市武侯区', '1', '3', 3);
INSERT INTO `emp` VALUES (69, '客户ABC', '李四', '13800138012', '010-11111120', '300009', '天津市南开区', '2', '1', 1);
INSERT INTO `emp` VALUES (70, '客户DEF', '张三', '13800138013', '010-11111121', '300010', '北京市海淀区', '2', '1', 2);
INSERT INTO `emp` VALUES (71, '客户GHI', '王五', '13800138014', '010-11111122', '300011', '上海市浦东新区', '2', '1', 3);
INSERT INTO `emp` VALUES (72, '客户JKL', '赵六', '13800138015', '010-11111123', '300012', '广州市天河区', '2', '2', 1);
INSERT INTO `emp` VALUES (73, '客户MNO', '李四', '13800138016', '010-11111124', '300013', '深圳市南山区', '2', '2', 2);
INSERT INTO `emp` VALUES (74, '客户PQR', '张三', '13800138017', '010-11111125', '300014', '杭州市西湖区', '2', '2', 3);
INSERT INTO `emp` VALUES (75, '客户STU', '王五', '13800138018', '010-11111126', '300015', '武汉市江汉区', '2', '3', 1);
INSERT INTO `emp` VALUES (76, '客户VWX', '赵六', '13800138019', '010-11111127', '300016', '重庆市渝中区', '2', '3', 2);
INSERT INTO `emp` VALUES (77, '客户YZA', '李四', '13800138020', '010-11111128', '300017', '成都市武侯区', '2', '3', 3);
INSERT INTO `emp` VALUES (78, '客户ABC', '李四', '13800138021', '010-11111129', '300018', '天津市南开区', '3', '1', 1);
INSERT INTO `emp` VALUES (79, '客户DEF', '张三', '13800138022', '010-11111130', '300019', '北京市海淀区', '3', '1', 2);
INSERT INTO `emp` VALUES (80, '客户GHI', '王五', '13800138023', '010-11111131', '300020', '上海市浦东新区', '3', '1', 3);
INSERT INTO `emp` VALUES (81, '客户JKL', '赵六', '13800138024', '010-11111132', '300021', '广州市天河区', '3', '2', 1);
INSERT INTO `emp` VALUES (82, '客户MNO', '李四', '13800138025', '010-11111133', '300022', '深圳市南山区', '3', '2', 2);
INSERT INTO `emp` VALUES (83, '客户PQR', '张三', '13800138026', '010-11111134', '300023', '杭州市西湖区', '3', '2', 3);
INSERT INTO `emp` VALUES (84, '客户STU', '王五', '13800138027', '010-11111135', '300024', '武汉市江汉区', '3', '3', 1);
INSERT INTO `emp` VALUES (85, '客户VWX', '赵六', '13800138028', '010-11111136', '300025', '重庆市渝中区', '3', '3', 2);

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `grade_id` int(11) NOT NULL,
  `grade_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '等级名称',
  `emp_id` int(11) NOT NULL COMMENT '客户id',
  PRIMARY KEY (`grade_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (1, '普通客户', 1);
INSERT INTO `grade` VALUES (2, 'VIP客户', 2);
INSERT INTO `grade` VALUES (3, '高级VIP', 3);

-- ----------------------------
-- Table structure for industry
-- ----------------------------
DROP TABLE IF EXISTS `industry`;
CREATE TABLE `industry`  (
  `industry_id` int(11) NOT NULL,
  `industry_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '行业名称',
  `emp_id` int(11) NOT NULL COMMENT '客户id',
  PRIMARY KEY (`industry_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of industry
-- ----------------------------
INSERT INTO `industry` VALUES (1, 'IT', 1);
INSERT INTO `industry` VALUES (2, '金融', 2);
INSERT INTO `industry` VALUES (3, '零售', 3);

-- ----------------------------
-- Table structure for source
-- ----------------------------
DROP TABLE IF EXISTS `source`;
CREATE TABLE `source`  (
  `source_id` int(11) NOT NULL AUTO_INCREMENT,
  `source_Name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '客户来源名称',
  `emp_id` int(11) NOT NULL COMMENT '客户id',
  PRIMARY KEY (`source_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of source
-- ----------------------------
INSERT INTO `source` VALUES (1, '网络营销', 1);
INSERT INTO `source` VALUES (2, '广告推广', 2);
INSERT INTO `source` VALUES (3, '直销', 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `password` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `email` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'alice', 'password123', 'alice@example.com');
INSERT INTO `user` VALUES (2, 'bob', 'password456', 'bob@example.com');
INSERT INTO `user` VALUES (3, 'charlie', 'password789', 'charlie@example.com');

SET FOREIGN_KEY_CHECKS = 1;
