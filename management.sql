/*
 Navicat Premium Data Transfer

 Source Server         : Oscar
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : management

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 08/05/2021 21:32:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 93 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (6, 'admin', '12345', NULL);
INSERT INTO `admin` VALUES (7, 'aaa', '123', NULL);
INSERT INTO `admin` VALUES (8, '李华', '666', NULL);
INSERT INTO `admin` VALUES (90, '王武', 'qwe', NULL);
INSERT INTO `admin` VALUES (92, '张三', '1593576842QQ', NULL);

-- ----------------------------
-- Table structure for assess
-- ----------------------------
DROP TABLE IF EXISTS `assess`;
CREATE TABLE `assess`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `coachid` int(11) NULL DEFAULT NULL COMMENT '教练ID',
  `userid` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教练评论内容',
  `updatetime` datetime(6) NULL DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of assess
-- ----------------------------
INSERT INTO `assess` VALUES (1, 7, 66, ' 今天训练的成绩不错，望保持！', '2021-03-16 08:14:07.000000');
INSERT INTO `assess` VALUES (2, 7, 66, '回去多练习一下，实心球，后下腰发力动作', '2021-03-16 03:07:20.000000');
INSERT INTO `assess` VALUES (3, 7, 73, 'lalal', '2021-03-16 03:18:30.000000');

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `classid` int(10) NOT NULL AUTO_INCREMENT COMMENT '班级ID',
  `coachid` int(10) NULL DEFAULT NULL COMMENT '教练ID',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级名',
  `class_num` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级人数',
  `project` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级项目',
  `statu` int(4) NULL DEFAULT NULL COMMENT '0/表示待开班，1/表示已开班',
  `addtime` datetime(6) NULL DEFAULT NULL COMMENT '添加时间',
  `dataline` datetime(6) NULL DEFAULT NULL COMMENT '截止时间',
  `traintime` datetime(6) NULL DEFAULT NULL COMMENT '训练截止时间',
  `classgoal` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '班级目标',
  `trainnum` int(10) NULL DEFAULT NULL COMMENT '训练次数、一周几次',
  `amount` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '总金额',
  PRIMARY KEY (`classid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 121 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (107, 1, '游泳2班', '4', '游泳', 0, '2021-03-17 09:14:23.000000', '2021-03-24 09:14:23.000000', '2021-03-31 09:14:23.000000', '达到全员评价优良', 1, '299');
INSERT INTO `class` VALUES (108, 1, '跳远训练', '6', '立定跳远', 0, '2021-03-17 09:15:40.000000', '2021-03-20 09:15:40.000000', '2021-03-27 09:15:40.000000', '全员优秀', 1, '199');
INSERT INTO `class` VALUES (109, 1, '引体训练', '6', '引体向上', 0, '2021-03-17 09:15:40.000000', '2021-03-23 09:15:40.000000', '2021-03-30 09:15:40.000000', '全员优秀', 1, '199');
INSERT INTO `class` VALUES (110, 1, '实心球训练', '6', '实心球', 0, '2021-03-17 09:15:40.000000', '2021-03-26 09:15:40.000000', '2021-04-02 09:15:40.000000', '全员优秀', 1, '199');
INSERT INTO `class` VALUES (115, 7, '游泳1班', '4', '游泳', 0, '2021-05-08 06:44:47.000000', '2021-05-14 00:00:00.000000', '2021-05-21 00:00:00.000000', '全员优秀', 1, '277');
INSERT INTO `class` VALUES (117, 7, '篮球2班', '5', '篮球', 0, '2021-05-08 06:50:10.000000', '2021-05-14 00:00:00.000000', '2021-05-21 00:00:00.000000', '全员优秀', 1, '299');
INSERT INTO `class` VALUES (118, 7, '铅球1班', '3', '实心球', 0, '2021-05-08 06:52:48.000000', '2021-05-15 00:00:00.000000', '2021-05-22 00:00:00.000000', '全员优秀', 1, '199');
INSERT INTO `class` VALUES (119, 7, '女子800米', '5', '女子800m', 0, '2021-05-08 07:00:07.000000', '2021-05-14 00:00:00.000000', '2021-06-04 00:00:00.000000', '全员优秀', 2, '199');
INSERT INTO `class` VALUES (120, 7, '长跑训练', '5', '男子1000m', 0, '2021-05-08 07:15:45.000000', '2021-05-11 00:00:00.000000', '2021-05-25 00:00:00.000000', '达到全员评价优良', 2, '199');

-- ----------------------------
-- Table structure for coach
-- ----------------------------
DROP TABLE IF EXISTS `coach`;
CREATE TABLE `coach`  (
  `coachid` int(10) NOT NULL AUTO_INCREMENT COMMENT '教练ID',
  `classid` int(10) NULL DEFAULT NULL COMMENT '班级ID',
  `userid` int(10) NULL DEFAULT NULL COMMENT '用户ID',
  `fieldid` int(19) NULL DEFAULT NULL COMMENT '场地ID',
  `coach_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `coach_pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `coach_sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `touch_project` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `gen_time` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `price` int(10) NULL DEFAULT NULL COMMENT '价格、单位/元',
  PRIMARY KEY (`coachid`) USING BTREE,
  INDEX `coach_user`(`userid`) USING BTREE,
  INDEX `coach_class`(`classid`) USING BTREE,
  INDEX `coach_filed`(`fieldid`) USING BTREE,
  CONSTRAINT `coach_class` FOREIGN KEY (`classid`) REFERENCES `class` (`classid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `coach_filed` FOREIGN KEY (`fieldid`) REFERENCES `field` (`fieldid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `coach_user` FOREIGN KEY (`userid`) REFERENCES `userinfo` (`userid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach
-- ----------------------------
INSERT INTO `coach` VALUES (1, NULL, NULL, NULL, '陈教练', '15935746813', '男', '羽毛球', '13145632651', '315664345@qq.com', NULL, NULL, NULL);
INSERT INTO `coach` VALUES (2, NULL, NULL, NULL, '张三', 'qwe12345678', '男', '游泳', '15834657879', '2456754@163.com', NULL, NULL, NULL);
INSERT INTO `coach` VALUES (3, NULL, NULL, NULL, '钱华', '1598753536482rty', '女', '女子100m', '14623653854', '56768452@qq.com', NULL, NULL, NULL);
INSERT INTO `coach` VALUES (5, NULL, NULL, NULL, '林杨', '159753cvb', '男', '男子100m', '18723653854', '563537893@qq.com', NULL, NULL, NULL);
INSERT INTO `coach` VALUES (6, NULL, NULL, NULL, '黎明', '1597536842123', '男', '实心球', '18734626786', '2456754@163.com', NULL, NULL, NULL);
INSERT INTO `coach` VALUES (7, NULL, NULL, NULL, '钱五', '123', '男', '篮球', '18050771060', '123@qq.com', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for content
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userid` int(10) NULL DEFAULT NULL COMMENT '用户ID',
  `classid` int(10) NULL DEFAULT NULL COMMENT '班级ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of content
-- ----------------------------
INSERT INTO `content` VALUES (2, 66, 102);
INSERT INTO `content` VALUES (6, 73, 103);
INSERT INTO `content` VALUES (7, NULL, 103);
INSERT INTO `content` VALUES (8, 66, 105);
INSERT INTO `content` VALUES (9, 55, 107);
INSERT INTO `content` VALUES (10, 55, 105);
INSERT INTO `content` VALUES (11, 55, 106);
INSERT INTO `content` VALUES (12, 66, 101);
INSERT INTO `content` VALUES (13, 72, 101);
INSERT INTO `content` VALUES (14, 66, 117);

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate`  (
  `evaluate_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '评价ID',
  `userid` int(19) NOT NULL COMMENT '用户ID',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `coachid` int(10) NOT NULL COMMENT '教练ID',
  PRIMARY KEY (`evaluate_id`) USING BTREE,
  INDEX `evaluate_user`(`userid`) USING BTREE,
  INDEX `evaluate_coach`(`coachid`) USING BTREE,
  CONSTRAINT `evaluate_coach` FOREIGN KEY (`coachid`) REFERENCES `coach` (`coachid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `evaluate_user` FOREIGN KEY (`userid`) REFERENCES `userinfo` (`userid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES (3, 72, '教练比较细心，耐心。', 7);
INSERT INTO `evaluate` VALUES (4, 66, '有什么问题，问教练，教练都会第一时间耐心回复我', 7);
INSERT INTO `evaluate` VALUES (5, 66, '教练比较细心，耐心。', 7);

-- ----------------------------
-- Table structure for field
-- ----------------------------
DROP TABLE IF EXISTS `field`;
CREATE TABLE `field`  (
  `fieldid` int(10) NOT NULL AUTO_INCREMENT COMMENT '场地ID',
  `coachid` int(10) NULL DEFAULT NULL COMMENT '教练ID',
  `project` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `price` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '价格',
  PRIMARY KEY (`fieldid`) USING BTREE,
  INDEX `filed_coach`(`coachid`) USING BTREE,
  CONSTRAINT `filed_coach` FOREIGN KEY (`coachid`) REFERENCES `coach` (`coachid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of field
-- ----------------------------
INSERT INTO `field` VALUES (1, 1, '篮球', '福州市-至诚学院-篮球场', '20/h');
INSERT INTO `field` VALUES (2, NULL, '羽毛球', '夕阳红健身广场', '30/h');
INSERT INTO `field` VALUES (3, NULL, '篮球', '夕阳红健身广场', '30/h');
INSERT INTO `field` VALUES (4, NULL, '足球', '夕阳红健身广场', '60/h');
INSERT INTO `field` VALUES (5, NULL, '铅球', '夕阳红健身广场', '25/h');
INSERT INTO `field` VALUES (6, NULL, '女子100m', '福州大学至诚学院-操场', '0/h');
INSERT INTO `field` VALUES (7, NULL, '男子100m', '福州大学至诚学院-操场', '0/h');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `science_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '科普ID',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  PRIMARY KEY (`science_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `order_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `coachid` int(10) NULL DEFAULT NULL COMMENT '教练ID',
  `userid` int(10) NULL DEFAULT NULL COMMENT '用户ID',
  `project` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '项目',
  `price` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '价格',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, NULL, NULL, '篮球', '80/h');
INSERT INTO `orders` VALUES (2, NULL, NULL, '足球', '50/h');
INSERT INTO `orders` VALUES (3, NULL, NULL, '游泳', '30/h');
INSERT INTO `orders` VALUES (4, NULL, NULL, '铅球', '25/h');
INSERT INTO `orders` VALUES (5, NULL, NULL, '男子100m', '20/h');
INSERT INTO `orders` VALUES (6, NULL, NULL, '女子100m', '20/h');

-- ----------------------------
-- Table structure for questionbank
-- ----------------------------
DROP TABLE IF EXISTS `questionbank`;
CREATE TABLE `questionbank`  (
  `num_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '题目ID',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `correct` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '正确答案',
  `OptionA` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OptionB` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OptionC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OptionD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`num_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of questionbank
-- ----------------------------
INSERT INTO `questionbank` VALUES (1, '标准田径场内突围长为', 'C', '600m', '440m', '400m', '398m');
INSERT INTO `questionbank` VALUES (2, '足球场球门高度应是', 'C', '2.9m', '2.5m', '2.44m', '2.8m');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `scoreid` int(10) NOT NULL AUTO_INCREMENT COMMENT '成绩ID',
  `userid` int(10) NULL DEFAULT NULL COMMENT '用户ID',
  `project` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目',
  `score` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成绩',
  `gen_time` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`scoreid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `userid` int(10) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `coachid` int(10) NULL DEFAULT NULL COMMENT '教练ID',
  `classid` int(10) NULL DEFAULT NULL COMMENT '班级ID',
  `recordid` int(10) NULL DEFAULT NULL COMMENT '成绩ID',
  `account` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `user_pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `gen_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '添加时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `order_id` int(10) NULL DEFAULT NULL COMMENT '订单ID',
  `age` int(10) NULL DEFAULT NULL,
  PRIMARY KEY (`userid`) USING BTREE,
  INDEX `user_coach`(`coachid`) USING BTREE,
  INDEX `user_record`(`classid`) USING BTREE,
  INDEX `user_order`(`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 82 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (52, NULL, NULL, NULL, '林涛', 'alina1234', '男', '18734626786', 'alron@163.com', NULL, NULL, NULL, 21);
INSERT INTO `userinfo` VALUES (53, NULL, NULL, NULL, '周凔', 'qwerty12345', '男', '14727343791', '36435445@qq.com', '2021-01-02 17:56:18', NULL, NULL, 27);
INSERT INTO `userinfo` VALUES (54, NULL, NULL, NULL, '胡京唐', '159753mnbv', '男', '13745342794', '2554326335@qq.com', NULL, NULL, NULL, 16);
INSERT INTO `userinfo` VALUES (55, NULL, NULL, NULL, '林东', 'qwwe753mnbv', '男', '13747842794', '457363233@qq.com', NULL, NULL, NULL, 17);
INSERT INTO `userinfo` VALUES (56, NULL, NULL, NULL, '林淼淼', '1593574682ss', '女', '13745842794', '2145687267@qq.com', NULL, NULL, NULL, 17);
INSERT INTO `userinfo` VALUES (57, NULL, NULL, NULL, '朱婷婷', 'lovehhw', '女', '15834657879', '852147963@qq.com', NULL, NULL, NULL, 15);
INSERT INTO `userinfo` VALUES (60, NULL, NULL, NULL, '龚志', '1593476842', '男', '15834657879', '2240588361@163.com', NULL, NULL, NULL, 16);
INSERT INTO `userinfo` VALUES (66, NULL, 103, NULL, '李明', '123', '男', '14727343159', '36435445@qq.com', '2021-05-08 01:08:24', NULL, NULL, 20);
INSERT INTO `userinfo` VALUES (72, NULL, 103, NULL, '王翔', '123', '男', '18734626786', '2456754@163.com', '2021-03-28 11:06:14', NULL, NULL, 19);
INSERT INTO `userinfo` VALUES (81, NULL, NULL, NULL, '小红', 'qwe123', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
