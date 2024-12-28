/*
 Navicat Premium Data Transfer

 Source Server         : 本机MySQL
 Source Server Type    : MySQL
 Source Server Version : 50719 (5.7.19)
 Source Host           : localhost:3306
 Source Schema         : lelenongchanpinxiaoshou

 Target Server Type    : MySQL
 Target Server Version : 50719 (5.7.19)
 File Encoding         : 65001

 Date: 28/12/2024 16:13:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `yonghu_id` int(20) NOT NULL COMMENT '创建用户',
  `address_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人 ',
  `address_phone` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话 ',
  `address_dizhi` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址 ',
  `isdefault_types` int(11) NOT NULL COMMENT '是否默认地址 ',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间 show3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收货地址' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES (1, 3, '收货人1', '17703786901', '地址1', 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `address` VALUES (2, 3, '收货人2', '17703786902', '地址2', 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `address` VALUES (4, 3, '收货人4', '17703786904', '地址4', 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `address` VALUES (5, 2, '收货人5', '17703786905', '地址5', 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `address` VALUES (6, 3, '收货人6', '17703786906', '地址6', 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `address` VALUES (7, 1, 'kkk', '17703786907', '江西农业大学', 2, '2023-04-28 16:06:15', '2024-03-21 18:14:37', '2023-04-28 16:06:15');
INSERT INTO `address` VALUES (8, 2, '收货人8', '17703786908', '地址8', 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `address` VALUES (9, 3, '收货人9', '17703786909', '地址9', 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `address` VALUES (12, 1, 'kkk', '13970095229', '江西省南昌市经开区', 1, '2023-04-28 16:06:15', '2024-03-21 18:14:16', '2023-04-28 16:06:15');
INSERT INTO `address` VALUES (13, 3, '收货人13', '17703786913', '地址13', 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `address` VALUES (14, 2, '收货人14', '17703786914', '地址14', 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `yonghu_id` int(11) NULL DEFAULT NULL COMMENT '所属用户',
  `nongchanpin_id` int(11) NULL DEFAULT NULL COMMENT '农产品',
  `buy_number` int(11) NULL DEFAULT NULL COMMENT '购买数量',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '添加时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '购物车' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for config
-- ----------------------------
DROP TABLE IF EXISTS `config`;
CREATE TABLE `config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置参数名称',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置参数值',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '配置文件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of config
-- ----------------------------
INSERT INTO `config` VALUES (1, '轮播图1', 'upload/config1.jpg');
INSERT INTO `config` VALUES (2, '轮播图2', 'upload/config2.jpg');
INSERT INTO `config` VALUES (3, '轮播图3', 'upload/config3.jpg');

-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS `dictionary`;
CREATE TABLE `dictionary`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dic_code` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字段',
  `dic_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字段名',
  `code_index` int(11) NULL DEFAULT NULL COMMENT '编码',
  `index_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码名字  Search111 ',
  `super_id` int(11) NULL DEFAULT NULL COMMENT '父字段id',
  `beizhu` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dictionary
-- ----------------------------
INSERT INTO `dictionary` VALUES (1, 'sex_types', '性别类型', 1, '男', NULL, NULL, '2023-04-28 16:06:01');
INSERT INTO `dictionary` VALUES (2, 'sex_types', '性别类型', 2, '女', NULL, NULL, '2023-04-28 16:06:01');
INSERT INTO `dictionary` VALUES (3, 'gonggao_types', '公告类型', 1, '公告类型1', NULL, NULL, '2023-04-28 16:06:01');
INSERT INTO `dictionary` VALUES (4, 'gonggao_types', '公告类型', 2, '公告类型2', NULL, NULL, '2023-04-28 16:06:01');
INSERT INTO `dictionary` VALUES (5, 'forum_state_types', '帖子状态', 1, '发帖', NULL, NULL, '2023-04-28 16:06:01');
INSERT INTO `dictionary` VALUES (6, 'forum_state_types', '帖子状态', 2, '回帖', NULL, NULL, '2023-04-28 16:06:01');
INSERT INTO `dictionary` VALUES (7, 'isdefault_types', '是否默认地址', 1, '否', NULL, NULL, '2023-04-28 16:06:02');
INSERT INTO `dictionary` VALUES (8, 'isdefault_types', '是否默认地址', 2, '是', NULL, NULL, '2023-04-28 16:06:02');
INSERT INTO `dictionary` VALUES (9, 'shangxia_types', '上下架', 1, '上架', NULL, NULL, '2023-04-28 16:06:02');
INSERT INTO `dictionary` VALUES (10, 'shangxia_types', '上下架', 2, '下架', NULL, NULL, '2023-04-28 16:06:02');
INSERT INTO `dictionary` VALUES (11, 'nongchanpin_types', '农产品类型', 1, '农产品类型1', NULL, NULL, '2023-04-28 16:06:02');
INSERT INTO `dictionary` VALUES (12, 'nongchanpin_types', '农产品类型', 2, '农产品类型2', NULL, NULL, '2023-04-28 16:06:02');
INSERT INTO `dictionary` VALUES (13, 'nongchanpin_types', '农产品类型', 3, '农产品类型3', NULL, NULL, '2023-04-28 16:06:02');
INSERT INTO `dictionary` VALUES (14, 'nongchanpin_types', '农产品类型', 4, '农产品类型4', NULL, NULL, '2023-04-28 16:06:02');
INSERT INTO `dictionary` VALUES (15, 'nongchanpin_collection_types', '收藏表类型', 1, '收藏', NULL, NULL, '2023-04-28 16:06:02');
INSERT INTO `dictionary` VALUES (16, 'nongchanpin_order_types', '订单类型', 101, '已支付', NULL, NULL, '2023-04-28 16:06:02');
INSERT INTO `dictionary` VALUES (17, 'nongchanpin_order_types', '订单类型', 102, '已退款', NULL, NULL, '2023-04-28 16:06:02');
INSERT INTO `dictionary` VALUES (18, 'nongchanpin_order_types', '订单类型', 103, '已发货', NULL, NULL, '2023-04-28 16:06:02');
INSERT INTO `dictionary` VALUES (19, 'nongchanpin_order_types', '订单类型', 104, '已收货', NULL, NULL, '2023-04-28 16:06:02');
INSERT INTO `dictionary` VALUES (20, 'nongchanpin_order_types', '订单类型', 105, '已评价', NULL, NULL, '2023-04-28 16:06:02');
INSERT INTO `dictionary` VALUES (21, 'shangjia_xingji_types', '商家信用类型', 1, '一级', NULL, NULL, '2023-04-28 16:06:02');
INSERT INTO `dictionary` VALUES (22, 'shangjia_xingji_types', '商家信用类型', 2, '二级', NULL, NULL, '2023-04-28 16:06:02');
INSERT INTO `dictionary` VALUES (23, 'shangjia_xingji_types', '商家信用类型', 3, '三级', NULL, NULL, '2023-04-28 16:06:02');

-- ----------------------------
-- Table structure for forum
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `forum_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '帖子标题  Search111 ',
  `yonghu_id` int(11) NULL DEFAULT NULL COMMENT '用户',
  `shangjia_id` int(11) NULL DEFAULT NULL COMMENT '商家',
  `users_id` int(11) NULL DEFAULT NULL COMMENT '管理员',
  `forum_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '发布内容',
  `super_ids` int(11) NULL DEFAULT NULL COMMENT '父id',
  `forum_state_types` int(11) NULL DEFAULT NULL COMMENT '帖子状态',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '发帖时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show2',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '交流论坛' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of forum
-- ----------------------------
INSERT INTO `forum` VALUES (1, '帖子标题1', 3, NULL, NULL, '发布内容1', 66, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `forum` VALUES (2, '帖子标题2', 3, NULL, NULL, '发布内容2', 256, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `forum` VALUES (3, '帖子标题3', 3, NULL, NULL, '发布内容3', 500, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `forum` VALUES (4, '帖子标题4', 3, NULL, NULL, '发布内容4', 244, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `forum` VALUES (5, '帖子标题5', 1, NULL, NULL, '发布内容5', 463, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `forum` VALUES (6, '帖子标题6', 3, NULL, NULL, '发布内容6', 88, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `forum` VALUES (7, '帖子标题7', 3, NULL, NULL, '发布内容7', 18, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `forum` VALUES (8, '帖子标题8', 3, NULL, NULL, '发布内容8', 350, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `forum` VALUES (9, '帖子标题9', 2, NULL, NULL, '发布内容9', 164, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `forum` VALUES (10, '帖子标题10', 1, NULL, NULL, '发布内容10', 14, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `forum` VALUES (11, '帖子标题11', 3, NULL, NULL, '发布内容11', 22, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `forum` VALUES (12, '帖子标题12', 1, NULL, NULL, '发布内容12', 4, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `forum` VALUES (13, '帖子标题13', 2, NULL, NULL, '发布内容13', 207, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `forum` VALUES (14, '帖子标题14', 3, NULL, NULL, '发布内容14', 14, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `forum` VALUES (16, '测试', 1, NULL, NULL, '<p>测试</p>', NULL, 1, '2023-04-28 16:25:08', NULL, '2023-04-28 16:25:08');
INSERT INTO `forum` VALUES (17, NULL, NULL, 1, NULL, '测试', 16, 2, '2023-04-28 16:27:18', NULL, '2023-04-28 16:27:18');
INSERT INTO `forum` VALUES (18, NULL, NULL, NULL, 1, '车阿萨德', 16, 2, '2023-04-28 16:28:16', NULL, '2023-04-28 16:28:16');
INSERT INTO `forum` VALUES (19, NULL, 1, NULL, NULL, 'hhh', 3, 2, '2024-04-18 19:15:23', NULL, '2024-04-18 19:15:23');

-- ----------------------------
-- Table structure for gonggao
-- ----------------------------
DROP TABLE IF EXISTS `gonggao`;
CREATE TABLE `gonggao`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `gonggao_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告名称 Search111  ',
  `gonggao_photo` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告图片 ',
  `gonggao_types` int(11) NOT NULL COMMENT '公告类型 Search111 ',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '发布时间',
  `gonggao_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '公告详情 ',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show1 show2 nameShow',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公告信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gonggao
-- ----------------------------
INSERT INTO `gonggao` VALUES (1, '公告名称1', 'upload/gonggao1.jpg', 1, '2023-04-28 16:06:15', '公告详情1', '2023-04-28 16:06:15');
INSERT INTO `gonggao` VALUES (2, '公告名称2', 'upload/gonggao2.jpg', 2, '2023-04-28 16:06:15', '公告详情2', '2023-04-28 16:06:15');
INSERT INTO `gonggao` VALUES (3, '公告名称3', 'upload/gonggao3.jpg', 1, '2023-04-28 16:06:15', '公告详情3', '2023-04-28 16:06:15');
INSERT INTO `gonggao` VALUES (4, '公告名称4', 'upload/gonggao4.jpg', 1, '2023-04-28 16:06:15', '公告详情4', '2023-04-28 16:06:15');
INSERT INTO `gonggao` VALUES (5, '公告名称5', 'upload/gonggao5.jpg', 1, '2023-04-28 16:06:15', '公告详情5', '2023-04-28 16:06:15');
INSERT INTO `gonggao` VALUES (6, '公告名称6', 'upload/gonggao6.jpg', 1, '2023-04-28 16:06:15', '公告详情6', '2023-04-28 16:06:15');
INSERT INTO `gonggao` VALUES (7, '公告名称7', 'upload/gonggao7.jpg', 2, '2023-04-28 16:06:15', '公告详情7', '2023-04-28 16:06:15');
INSERT INTO `gonggao` VALUES (8, '公告名称8', 'upload/gonggao8.jpg', 1, '2023-04-28 16:06:15', '公告详情8', '2023-04-28 16:06:15');
INSERT INTO `gonggao` VALUES (9, '公告名称9', 'upload/gonggao9.jpg', 1, '2023-04-28 16:06:15', '公告详情9', '2023-04-28 16:06:15');
INSERT INTO `gonggao` VALUES (10, '公告名称10', 'upload/gonggao10.jpg', 1, '2023-04-28 16:06:15', '公告详情10', '2023-04-28 16:06:15');
INSERT INTO `gonggao` VALUES (11, '公告名称11', 'upload/gonggao11.jpg', 1, '2023-04-28 16:06:15', '公告详情11', '2023-04-28 16:06:15');
INSERT INTO `gonggao` VALUES (12, '公告名称12', 'upload/gonggao12.jpg', 2, '2023-04-28 16:06:15', '公告详情12', '2023-04-28 16:06:15');
INSERT INTO `gonggao` VALUES (13, '公告名称13', 'upload/gonggao13.jpg', 1, '2023-04-28 16:06:15', '公告详情13', '2023-04-28 16:06:15');
INSERT INTO `gonggao` VALUES (14, '公告名称14', 'upload/gonggao14.jpg', 2, '2023-04-28 16:06:15', '公告详情14', '2023-04-28 16:06:15');

-- ----------------------------
-- Table structure for nongchanpin
-- ----------------------------
DROP TABLE IF EXISTS `nongchanpin`;
CREATE TABLE `nongchanpin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `shangjia_id` int(11) NULL DEFAULT NULL COMMENT '商家',
  `nongchanpin_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '农产品名称  Search111 ',
  `nongchanpin_photo` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '农产品照片',
  `nongchanpin_types` int(11) NULL DEFAULT NULL COMMENT '农产品类型 Search111',
  `nongchanpin_kucun_number` int(11) NULL DEFAULT NULL COMMENT '农产品库存',
  `nongchanpin_old_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '农产品原价 ',
  `nongchanpin_new_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '现价',
  `nongchanpin_clicknum` int(11) NULL DEFAULT NULL COMMENT '点击次数 ',
  `nongchanpin_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '农产品介绍 ',
  `shangxia_types` int(11) NULL DEFAULT NULL COMMENT '是否上架 ',
  `nongchanpin_delete` int(11) NULL DEFAULT NULL COMMENT '逻辑删除',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间  show1 show2 photoShow',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '农产品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nongchanpin
-- ----------------------------
INSERT INTO `nongchanpin` VALUES (1, 3, '农产品名称1', 'upload/nongchanpin1.jpg', 1, 101, 691.58, 366.22, 4, '农产品介绍1', 1, 1, '2023-04-28 16:06:15');
INSERT INTO `nongchanpin` VALUES (2, 2, '农产品名称2', 'upload/nongchanpin2.jpg', 3, 102, 567.73, 119.39, 415, '农产品介绍2', 1, 1, '2023-04-28 16:06:15');
INSERT INTO `nongchanpin` VALUES (3, 1, '农产品名称3', 'upload/nongchanpin3.jpg', 1, 97, 685.36, 86.44, 386, '农产品介绍3', 1, 1, '2023-04-28 16:06:15');
INSERT INTO `nongchanpin` VALUES (4, 1, '农产品名称4', 'upload/nongchanpin4.jpg', 4, 104, 514.64, 154.26, 225, '农产品介绍4', 1, 1, '2023-04-28 16:06:15');
INSERT INTO `nongchanpin` VALUES (5, 2, '农产品名称5', 'upload/nongchanpin5.jpg', 3, 105, 534.46, 219.68, 40, '农产品介绍5', 1, 1, '2023-04-28 16:06:15');
INSERT INTO `nongchanpin` VALUES (6, 3, '农产品名称6', 'upload/nongchanpin6.jpg', 4, 106, 942.49, 468.07, 383, '农产品介绍6', 1, 1, '2023-04-28 16:06:15');
INSERT INTO `nongchanpin` VALUES (7, 3, '农产品名称7', 'upload/nongchanpin7.jpg', 2, 107, 663.59, 441.83, 107, '农产品介绍7', 1, 1, '2023-04-28 16:06:15');
INSERT INTO `nongchanpin` VALUES (8, 2, '农产品名称8', 'upload/nongchanpin8.jpg', 4, 108, 552.67, 216.15, 264, '农产品介绍8', 1, 1, '2023-04-28 16:06:15');
INSERT INTO `nongchanpin` VALUES (9, 2, '农产品名称9', 'upload/nongchanpin9.jpg', 1, 107, 558.69, 71.73, 357, '农产品介绍9', 1, 1, '2023-04-28 16:06:15');
INSERT INTO `nongchanpin` VALUES (10, 1, '农产品名称10', 'upload/nongchanpin10.jpg', 4, 1010, 514.54, 375.05, 240, '农产品介绍10', 1, 1, '2023-04-28 16:06:15');
INSERT INTO `nongchanpin` VALUES (11, 3, '农产品名称11', 'upload/nongchanpin11.jpg', 1, 1011, 532.79, 315.15, 191, '农产品介绍11', 1, 1, '2023-04-28 16:06:15');
INSERT INTO `nongchanpin` VALUES (12, 2, '农产品名称12', 'upload/nongchanpin12.jpg', 1, 1012, 605.65, 304.88, 274, '农产品介绍12', 1, 1, '2023-04-28 16:06:15');
INSERT INTO `nongchanpin` VALUES (13, 3, '农产品名称13', 'upload/nongchanpin13.jpg', 1, 1013, 909.70, 216.35, 473, '农产品介绍13', 1, 1, '2023-04-28 16:06:15');
INSERT INTO `nongchanpin` VALUES (14, 3, '农产品名称14', 'upload/nongchanpin14.jpg', 4, 1013, 524.58, 441.53, 416, '农产品介绍14', 1, 1, '2023-04-28 16:06:15');

-- ----------------------------
-- Table structure for nongchanpin_collection
-- ----------------------------
DROP TABLE IF EXISTS `nongchanpin_collection`;
CREATE TABLE `nongchanpin_collection`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nongchanpin_id` int(11) NULL DEFAULT NULL COMMENT '农产品',
  `yonghu_id` int(11) NULL DEFAULT NULL COMMENT '用户',
  `nongchanpin_collection_types` int(11) NULL DEFAULT NULL COMMENT '类型',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '收藏时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3 photoShow',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '农产品收藏' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nongchanpin_collection
-- ----------------------------
INSERT INTO `nongchanpin_collection` VALUES (1, 1, 1, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_collection` VALUES (2, 2, 1, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_collection` VALUES (3, 3, 3, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_collection` VALUES (4, 4, 2, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_collection` VALUES (5, 5, 3, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_collection` VALUES (6, 6, 1, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_collection` VALUES (7, 7, 3, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_collection` VALUES (8, 8, 3, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_collection` VALUES (9, 9, 2, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_collection` VALUES (10, 10, 2, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_collection` VALUES (11, 11, 3, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_collection` VALUES (12, 12, 3, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_collection` VALUES (13, 13, 3, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_collection` VALUES (14, 14, 1, 1, '2023-04-28 16:06:15', '2023-04-28 16:06:15');

-- ----------------------------
-- Table structure for nongchanpin_commentback
-- ----------------------------
DROP TABLE IF EXISTS `nongchanpin_commentback`;
CREATE TABLE `nongchanpin_commentback`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nongchanpin_id` int(11) NULL DEFAULT NULL COMMENT '农产品',
  `yonghu_id` int(11) NULL DEFAULT NULL COMMENT '用户',
  `nongchanpin_commentback_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评价内容',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '评价时间',
  `reply_text` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '回复内容',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '回复时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '农产品评价' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nongchanpin_commentback
-- ----------------------------
INSERT INTO `nongchanpin_commentback` VALUES (1, 1, 3, '评价内容1', '2023-04-28 16:06:15', '回复信息1', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_commentback` VALUES (2, 2, 1, '评价内容2', '2023-04-28 16:06:15', '回复信息2', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_commentback` VALUES (3, 3, 2, '评价内容3', '2023-04-28 16:06:15', '回复信息3', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_commentback` VALUES (4, 4, 3, '评价内容4', '2023-04-28 16:06:15', '回复信息4', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_commentback` VALUES (5, 5, 1, '评价内容5', '2023-04-28 16:06:15', '回复信息5', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_commentback` VALUES (6, 6, 3, '评价内容6', '2023-04-28 16:06:15', '回复信息6', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_commentback` VALUES (7, 7, 3, '评价内容7', '2023-04-28 16:06:15', '回复信息7', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_commentback` VALUES (8, 8, 3, '评价内容8', '2023-04-28 16:06:15', '回复信息8', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_commentback` VALUES (9, 9, 1, '评价内容9', '2023-04-28 16:06:15', '回复信息9', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_commentback` VALUES (10, 10, 1, '评价内容10', '2023-04-28 16:06:15', '回复信息10', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_commentback` VALUES (11, 11, 2, '评价内容11', '2023-04-28 16:06:15', '回复信息11', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_commentback` VALUES (12, 12, 1, '评价内容12', '2023-04-28 16:06:15', '回复信息12', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_commentback` VALUES (13, 13, 3, '评价内容13', '2023-04-28 16:06:15', '回复信息13', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_commentback` VALUES (14, 14, 1, '评价内容14', '2023-04-28 16:06:15', '回复信息14', '2023-04-28 16:06:15', '2023-04-28 16:06:15');
INSERT INTO `nongchanpin_commentback` VALUES (15, 3, 1, 'sad奥迪撒', '2023-04-28 16:26:09', '相册sad', '2023-04-28 16:26:44', '2023-04-28 16:26:09');

-- ----------------------------
-- Table structure for nongchanpin_order
-- ----------------------------
DROP TABLE IF EXISTS `nongchanpin_order`;
CREATE TABLE `nongchanpin_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nongchanpin_order_uuid_number` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `address_id` int(11) NULL DEFAULT NULL COMMENT '收获地址 ',
  `nongchanpin_id` int(11) NULL DEFAULT NULL COMMENT '农产品',
  `yonghu_id` int(11) NULL DEFAULT NULL COMMENT '用户',
  `buy_number` int(11) NULL DEFAULT NULL COMMENT '购买数量',
  `nongchanpin_order_true_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '实付价格',
  `nongchanpin_order_courier_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递公司',
  `nongchanpin_order_courier_number` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单快递单号',
  `nongchanpin_order_types` int(11) NULL DEFAULT NULL COMMENT '订单类型',
  `insert_time` timestamp NULL DEFAULT NULL COMMENT '订单创建时间',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show3',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '农产品订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nongchanpin_order
-- ----------------------------
INSERT INTO `nongchanpin_order` VALUES (5, '1682670109881', 3, 3, 1, 2, 172.88, '123', '3321', 105, '2023-04-28 16:21:50', '2023-04-28 16:21:50');
INSERT INTO `nongchanpin_order` VALUES (6, '1682670332670', 7, 3, 1, 1, 86.44, NULL, NULL, 101, '2023-04-28 16:25:33', '2023-04-28 16:25:33');
INSERT INTO `nongchanpin_order` VALUES (7, '1682670349554', 10, 3, 1, 3, 259.32, '阿萨德sad', 'sadsad是', 104, '2023-04-28 16:25:50', '2023-04-28 16:25:50');
INSERT INTO `nongchanpin_order` VALUES (8, '1710984539025', 12, 9, 1, 1, 71.73, NULL, NULL, 101, '2024-03-21 09:28:59', '2024-03-21 09:28:59');
INSERT INTO `nongchanpin_order` VALUES (9, '1713438897390', 7, 9, 1, 1, 71.73, NULL, NULL, 101, '2024-04-18 19:14:57', '2024-04-18 19:14:57');
INSERT INTO `nongchanpin_order` VALUES (10, '1713438897390', 7, 14, 1, 1, 441.53, NULL, NULL, 101, '2024-04-18 19:14:57', '2024-04-18 19:14:57');

-- ----------------------------
-- Table structure for shangjia
-- ----------------------------
DROP TABLE IF EXISTS `shangjia`;
CREATE TABLE `shangjia`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `username` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户 ',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码 ',
  `shangjia_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家名称 Search111 ',
  `shangjia_phone` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `shangjia_email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `shangjia_photo` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业执照展示 ',
  `shangjia_xingji_types` int(11) NULL DEFAULT NULL COMMENT '商家信用类型',
  `new_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '现有余额',
  `shangjia_content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商家介绍 ',
  `shangjia_delete` int(11) NULL DEFAULT NULL COMMENT '逻辑删除',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间 show1 show2 photoShow ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商家' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shangjia
-- ----------------------------
INSERT INTO `shangjia` VALUES (1, 'a1', '123456', '商家名称1', '17703786901', '1@qq.com', 'upload/shangjia1.jpg', 1, 749.99, '商家介绍1', 1, '2023-04-28 16:06:15');
INSERT INTO `shangjia` VALUES (2, 'a2', '123456', '商家名称2', '17703786902', '2@qq.com', 'upload/shangjia2.jpg', 1, 1002.49, '商家介绍2', 1, '2023-04-28 16:06:15');
INSERT INTO `shangjia` VALUES (3, 'a3', '123456', '商家名称3', '17703786903', '3@qq.com', 'upload/shangjia3.jpg', 3, 1010.09, '<p>商家介绍3</p>', 1, '2023-04-28 16:06:15');

-- ----------------------------
-- Table structure for token
-- ----------------------------
DROP TABLE IF EXISTS `token`;
CREATE TABLE `token`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` bigint(20) NOT NULL COMMENT '儿童id',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '儿童名',
  `tablename` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表名',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `token` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  `expiratedtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'token表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of token
-- ----------------------------
INSERT INTO `token` VALUES (1, 1, 'a1', 'yonghu', '用户', 'i77e7sitaq5345mrclw8pp1k5rhjaoia', '2023-04-28 16:10:37', '2024-05-20 20:08:28');
INSERT INTO `token` VALUES (2, 1, 'admin', 'users', '管理员', 'xbcazi2zk6w4r0jhvupip3zqdi9k0fpj', '2023-04-28 16:15:44', '2024-04-05 13:28:47');
INSERT INTO `token` VALUES (3, 1, 'a1', 'shangjia', '商家', 'ma8ak2al3v232d86zcvzbs6or286j1yo', '2023-04-28 16:21:24', '2024-03-21 18:21:58');
INSERT INTO `token` VALUES (4, 2, 'a2', 'shangjia', '商家', 'u3d3tzlxvmf05guvr9xvfcxdkbe0qme2', '2024-04-05 12:55:07', '2024-04-05 13:55:07');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '儿童名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '管理员' COMMENT '角色',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '新增时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', 'admin', '管理员', '2023-04-28 16:06:01');

-- ----------------------------
-- Table structure for yonghu
-- ----------------------------
DROP TABLE IF EXISTS `yonghu`;
CREATE TABLE `yonghu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `yonghu_uuid_number` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户编号 Search111 ',
  `yonghu_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名 Search111 ',
  `yonghu_phone` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `yonghu_id_number` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户身份证号',
  `yonghu_photo` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `sex_types` int(11) NULL DEFAULT NULL COMMENT '性别',
  `yonghu_email` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `new_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '余额 ',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yonghu
-- ----------------------------
INSERT INTO `yonghu` VALUES (1, 'a1', '123456', '1682669175619', '用户姓名1', '17703786901', '410224199010102001', 'upload/1711015873356.jpg', 2, '1@qq.com', 283.60, '2023-04-28 16:06:15');
INSERT INTO `yonghu` VALUES (2, 'a2', '123456', '1682669175553', '用户姓名2', '17703786902', '410224199010102002', 'upload/yonghu2.jpg', 1, '2@qq.com', 85.44, '2023-04-28 16:06:15');
INSERT INTO `yonghu` VALUES (3, 'a3', '123456', '1682669175558', '用户姓名3', '17703786903', '410224199010102003', 'upload/yonghu3.jpg', 1, '3@qq.com', 351.63, '2023-04-28 16:06:15');

SET FOREIGN_KEY_CHECKS = 1;
