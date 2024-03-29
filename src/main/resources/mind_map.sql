/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : mind_map

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 03/03/2023 13:45:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for node
-- ----------------------------
DROP TABLE IF EXISTS `node`;
CREATE TABLE `node`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `rid` int(11) NOT NULL DEFAULT 0,
  `pid` int(11) NOT NULL DEFAULT 0,
  `direction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `level` int(11) NOT NULL DEFAULT 1,
  `color` int(11) NOT NULL DEFAULT 0,
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expanded` tinyint(1) NULL DEFAULT 1,
  `deleted` int(11) NOT NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2131722484 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of node
-- ----------------------------
INSERT INTO `node` VALUES (1, 'mindmap', 1, 0, 'right', 1, 0, NULL, 1, 0, '2023-01-05 18:07:51', '2023-02-26 15:04:00');
INSERT INTO `node` VALUES (2, 'testnode0', 1, 1, 'right', 1, 0, NULL, 1, 0, '2023-01-11 20:09:03', '2023-02-26 15:04:00');
INSERT INTO `node` VALUES (3, 'testnode123', 1, 2, 'right', 2, 0, NULL, 1, 1, '2023-01-11 20:09:03', '2023-02-25 14:57:47');
INSERT INTO `node` VALUES (4, 'testnode222', 1, 3, 'right', 3, 0, NULL, 1, 1, '2023-01-11 20:09:03', '2023-02-25 14:57:47');
INSERT INTO `node` VALUES (5, 'testnode3', 1, 4, 'right', 4, 0, NULL, 1, 1, '2023-01-11 20:09:03', '2023-02-25 12:59:34');
INSERT INTO `node` VALUES (6, 'testnode4', 1, 5, 'right', 5, 0, NULL, 1, 1, '2023-01-11 20:09:03', '2023-02-25 12:59:34');
INSERT INTO `node` VALUES (7, 'testnode1', 1, 1, 'right', 2, 0, NULL, 1, 0, '2023-01-11 20:11:19', '2023-02-26 15:04:00');
INSERT INTO `node` VALUES (8, 'testnode2134', 1, 2, 'right', 3, 0, NULL, 1, 0, '2023-01-11 20:11:19', '2023-02-26 15:04:00');
INSERT INTO `node` VALUES (9, 'testnode3', 1, 3, 'right', 4, 0, NULL, 1, 1, '2023-01-11 20:11:19', '2023-02-25 14:57:47');
INSERT INTO `node` VALUES (10, 'testnode1', 1, 1, 'right', 2, 0, NULL, 1, 1, '2023-01-11 20:12:51', '2023-02-25 14:13:54');
INSERT INTO `node` VALUES (11, 'testnode3', 1, 3, 'right', 4, 0, NULL, 1, 1, '2023-01-11 20:12:51', '2023-02-25 14:57:47');
INSERT INTO `node` VALUES (12, 'testnode5', 1, 5, 'right', 6, 0, NULL, 1, 1, '2023-01-11 20:12:51', '2023-02-25 12:59:34');
INSERT INTO `node` VALUES (13, 'testnode7', 1, 7, 'right', 8, 0, NULL, 1, 0, '2023-01-11 20:12:51', '2023-02-26 15:04:00');
INSERT INTO `node` VALUES (14, 'mindmap2', 5, 0, 'right', 1, 0, NULL, 1, 0, NULL, NULL);
INSERT INTO `node` VALUES (27, 'new Node1', 1, 1, 'left', 1, 0, NULL, 1, 1, '2023-02-25 14:47:32', '2023-02-25 14:52:26');
INSERT INTO `node` VALUES (28, 'new Node3', 1, 1, NULL, 1, 0, NULL, 1, 1, '2023-02-25 14:47:32', '2023-02-25 14:47:32');
INSERT INTO `node` VALUES (29, 'new Node2', 1, 28, 'left', 1, 0, NULL, 1, 1, '2023-02-25 14:47:32', '2023-02-25 14:47:32');
INSERT INTO `node` VALUES (30, 'new Node111', 1, 1, 'left', 1, 0, NULL, 1, 1, '2023-02-25 14:52:26', '2023-02-25 14:52:26');
INSERT INTO `node` VALUES (36280275, 'new Node', 36, 1186082884, NULL, 1, 0, NULL, 1, 0, '2023-02-26 09:30:49', '2023-02-26 09:32:08');
INSERT INTO `node` VALUES (54254439, 'new Node123', 45, 1979855031, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:58:39', '2023-02-26 10:02:01');
INSERT INTO `node` VALUES (82538729, 'new Node', 35, 1375596415, NULL, 1, 0, NULL, 1, 1, '2023-02-26 15:07:20', '2023-02-26 15:07:20');
INSERT INTO `node` VALUES (93384359, 'new Node', 35, 1979855021, 'left', 1, 0, NULL, 1, 1, '2023-02-26 15:07:19', '2023-02-26 15:07:19');
INSERT INTO `node` VALUES (114048032, 'new Node456', 29, 1979855015, 'right', 1, 0, NULL, 1, 0, '2023-02-25 22:02:34', '2023-02-25 22:03:26');
INSERT INTO `node` VALUES (137858428, 'new Node123', 48, 2131722483, NULL, 1, 0, NULL, 1, 0, '2023-02-26 15:09:57', '2023-02-26 15:09:57');
INSERT INTO `node` VALUES (150350906, 'new Node33', 1, 1979855012, NULL, 1, 0, NULL, 1, 0, '2023-02-25 14:57:47', '2023-02-26 15:04:00');
INSERT INTO `node` VALUES (170862503, 'new Node', 35, 1758492971, NULL, 1, 0, NULL, 1, 1, '2023-02-26 15:07:20', '2023-02-26 15:07:20');
INSERT INTO `node` VALUES (194614884, 'new Node123666', 29, 1979855015, 'right', 1, 0, NULL, 1, 0, '2023-02-25 22:02:34', '2023-02-25 22:03:26');
INSERT INTO `node` VALUES (239253427, 'new Node', 48, 948301217, NULL, 1, 0, NULL, 1, 0, '2023-02-26 15:09:57', '2023-02-26 15:09:57');
INSERT INTO `node` VALUES (242252856, 'new Node43', 1, 1979855012, NULL, 1, 0, NULL, 1, 0, '2023-02-25 14:57:47', '2023-02-26 15:04:00');
INSERT INTO `node` VALUES (309026814, 'new Node', 48, 463179501, NULL, 1, 0, NULL, 1, 0, '2023-02-26 15:09:57', '2023-02-26 15:09:57');
INSERT INTO `node` VALUES (349020432, 'new Node', 35, 1979855021, 'right', 1, 0, NULL, 1, 1, '2023-02-26 15:04:26', '2023-02-26 15:04:26');
INSERT INTO `node` VALUES (378842230, 'new Node123123', 29, 194614884, NULL, 1, 0, NULL, 1, 0, '2023-02-25 22:02:34', '2023-02-25 22:03:26');
INSERT INTO `node` VALUES (391183688, 'new Node2', 37, 1979855023, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:48:29', '2023-02-26 09:48:29');
INSERT INTO `node` VALUES (440325708, 'new Node', 36, 1046524297, NULL, 1, 0, NULL, 1, 1, '2023-02-26 09:30:48', '2023-02-26 09:30:48');
INSERT INTO `node` VALUES (463179501, 'new Node', 48, 2121193164, 'left', 1, 0, NULL, 1, 0, '2023-02-26 15:09:57', '2023-02-26 15:09:57');
INSERT INTO `node` VALUES (471843097, 'new Nodefafd', 35, 1301532110, NULL, 1, 0, NULL, 1, 1, '2023-02-26 15:04:26', '2023-02-26 15:04:26');
INSERT INTO `node` VALUES (612633047, 'new Node789', 29, 1979855015, 'left', 1, 0, NULL, 1, 0, '2023-02-25 22:02:34', '2023-02-25 22:03:26');
INSERT INTO `node` VALUES (612772552, 'new Node3', 37, 1979855023, 'left', 1, 0, NULL, 1, 0, '2023-02-26 09:48:29', '2023-02-26 09:48:29');
INSERT INTO `node` VALUES (649854164, 'new Node44', 1, 1, 'left', 1, 0, NULL, 1, 0, '2023-02-25 14:57:47', '2023-02-26 15:04:00');
INSERT INTO `node` VALUES (682946560, 'new Node', 45, 1979855031, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:58:39', '2023-02-26 10:02:01');
INSERT INTO `node` VALUES (879468429, 'New Node', 45, 1895756203, NULL, 1, 0, NULL, 1, 0, '2023-02-26 10:02:01', '2023-02-26 10:02:01');
INSERT INTO `node` VALUES (948301217, 'new Node', 48, 2121193164, 'right', 1, 0, NULL, 1, 0, '2023-02-26 15:09:57', '2023-02-26 15:09:57');
INSERT INTO `node` VALUES (949668418, 'new Node5', 37, 1957509390, NULL, 1, 0, NULL, 1, 0, '2023-02-26 09:48:29', '2023-02-26 09:48:29');
INSERT INTO `node` VALUES (957423181, 'new Node', 45, 1895756203, NULL, 1, 0, NULL, 1, 0, '2023-02-26 09:58:39', '2023-02-26 10:02:01');
INSERT INTO `node` VALUES (1042364385, 'new Node123456', 29, 194614884, NULL, 1, 0, NULL, 1, 0, '2023-02-25 22:02:34', '2023-02-25 22:03:26');
INSERT INTO `node` VALUES (1044936500, 'new Node', 48, 239253427, NULL, 1, 0, NULL, 1, 0, '2023-02-26 15:09:57', '2023-02-26 15:09:57');
INSERT INTO `node` VALUES (1046524297, 'new Node123', 36, 1437696518, NULL, 1, 0, NULL, 1, 0, '2023-02-26 09:30:48', '2023-02-26 09:32:08');
INSERT INTO `node` VALUES (1059830786, 'new Node', 45, 1979855031, 'left', 1, 0, NULL, 1, 0, '2023-02-26 09:58:39', '2023-02-26 10:02:01');
INSERT INTO `node` VALUES (1123399540, 'new Node6', 29, 378842230, NULL, 1, 0, NULL, 1, 1, '2023-02-25 22:02:34', '2023-02-25 22:02:34');
INSERT INTO `node` VALUES (1141980662, 'new Node4', 37, 1979855023, 'left', 1, 0, NULL, 1, 0, '2023-02-26 09:48:29', '2023-02-26 09:48:29');
INSERT INTO `node` VALUES (1157262101, 'new Node', 35, 82538729, NULL, 1, 0, NULL, 1, 1, '2023-02-26 15:07:20', '2023-02-26 15:07:20');
INSERT INTO `node` VALUES (1168422389, 'new Node', 45, 1447789930, NULL, 1, 0, NULL, 1, 1, '2023-02-26 09:58:39', '2023-02-26 09:58:39');
INSERT INTO `node` VALUES (1186082884, 'new Node', 36, 1979855022, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:30:48', '2023-02-26 09:32:08');
INSERT INTO `node` VALUES (1187727889, 'new Node', 48, 2131722483, NULL, 1, 0, NULL, 1, 0, '2023-02-26 15:09:57', '2023-02-26 15:09:57');
INSERT INTO `node` VALUES (1301532110, '3234dsa', 35, 349020432, NULL, 1, 0, NULL, 1, 1, '2023-02-26 15:04:26', '2023-02-26 15:04:26');
INSERT INTO `node` VALUES (1328930191, 'new Node8', 37, 1923941650, NULL, 1, 0, NULL, 1, 0, '2023-02-26 09:48:29', '2023-02-26 09:48:29');
INSERT INTO `node` VALUES (1350567662, 'new Node', 48, 463179501, NULL, 1, 0, NULL, 1, 0, '2023-02-26 15:09:57', '2023-02-26 15:09:57');
INSERT INTO `node` VALUES (1375596415, 'new Node', 35, 1758492971, NULL, 1, 0, NULL, 1, 1, '2023-02-26 15:07:20', '2023-02-26 15:07:20');
INSERT INTO `node` VALUES (1418131249, 'new Node', 36, 1979855022, 'left', 1, 0, NULL, 1, 0, '2023-02-26 09:30:49', '2023-02-26 09:32:08');
INSERT INTO `node` VALUES (1437696518, 'new Node', 36, 1979855022, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:30:48', '2023-02-26 09:32:08');
INSERT INTO `node` VALUES (1447789930, 'new Node', 45, 1880880465, NULL, 1, 0, NULL, 1, 1, '2023-02-26 09:58:39', '2023-02-26 09:58:39');
INSERT INTO `node` VALUES (1487734600, 'new Node', 35, 1979855021, 'right', 1, 0, NULL, 1, 1, '2023-02-26 15:04:26', '2023-02-26 15:04:26');
INSERT INTO `node` VALUES (1489950505, 'new Node', 35, 170862503, NULL, 1, 0, NULL, 1, 1, '2023-02-26 15:07:20', '2023-02-26 15:07:20');
INSERT INTO `node` VALUES (1511862817, 'new Node', 35, 349020432, NULL, 1, 0, NULL, 1, 1, '2023-02-26 15:04:26', '2023-02-26 15:04:26');
INSERT INTO `node` VALUES (1532621589, 'new Node', 35, 349020432, NULL, 1, 0, NULL, 1, 1, '2023-02-26 15:04:26', '2023-02-26 15:04:26');
INSERT INTO `node` VALUES (1676754278, 'new Node7', 37, 1923941650, NULL, 1, 0, NULL, 1, 0, '2023-02-26 09:48:29', '2023-02-26 09:48:29');
INSERT INTO `node` VALUES (1709214053, 'new Node', 36, 1437696518, NULL, 1, 0, NULL, 1, 0, '2023-02-26 09:30:48', '2023-02-26 09:32:08');
INSERT INTO `node` VALUES (1758492971, 'new Node132', 35, 1979855021, 'right', 1, 0, NULL, 1, 0, '2023-02-26 15:04:26', '2023-02-26 15:07:19');
INSERT INTO `node` VALUES (1880880465, 'new Node', 45, 957423181, NULL, 1, 0, NULL, 1, 1, '2023-02-26 09:58:39', '2023-02-26 09:58:39');
INSERT INTO `node` VALUES (1895756203, 'new Node', 45, 682946560, NULL, 1, 0, NULL, 1, 0, '2023-02-26 09:58:39', '2023-02-26 10:02:01');
INSERT INTO `node` VALUES (1923068378, 'New Node', 45, 682946560, NULL, 1, 0, NULL, 1, 0, '2023-02-26 10:02:01', '2023-02-26 10:02:01');
INSERT INTO `node` VALUES (1923941650, 'new Node6', 37, 1957509390, NULL, 1, 0, NULL, 1, 0, '2023-02-26 09:48:29', '2023-02-26 09:48:29');
INSERT INTO `node` VALUES (1957509390, 'new Node1', 37, 1979855023, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:48:29', '2023-02-26 09:48:29');
INSERT INTO `node` VALUES (1962058170, 'new Node', 45, 682946560, NULL, 1, 0, NULL, 1, 0, '2023-02-26 09:58:39', '2023-02-26 10:02:01');
INSERT INTO `node` VALUES (1979855012, 'new Node333', 1, 1, 'left', 1, 0, NULL, 1, 0, '2023-02-25 14:57:47', '2023-02-26 15:04:00');
INSERT INTO `node` VALUES (1979855015, 'New MindMap', 29, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-25 18:35:43', '2023-02-25 22:03:26');
INSERT INTO `node` VALUES (1979855016, 'New MindMap', 30, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-25 18:37:30', '2023-02-25 18:37:30');
INSERT INTO `node` VALUES (1979855017, 'New MindMap', 31, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-25 18:42:09', '2023-02-25 18:42:09');
INSERT INTO `node` VALUES (1979855018, 'New MindMap', 32, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-25 18:43:18', '2023-02-25 18:43:18');
INSERT INTO `node` VALUES (1979855019, 'New MindMap', 33, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-25 18:43:52', '2023-02-25 18:43:52');
INSERT INTO `node` VALUES (1979855020, 'New MindMap', 34, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-25 18:45:25', '2023-02-25 18:45:25');
INSERT INTO `node` VALUES (1979855021, 'New MindMap', 35, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-25 21:41:37', '2023-02-26 15:08:07');
INSERT INTO `node` VALUES (1979855022, 'New MindMap', 36, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:29:50', '2023-02-26 09:32:08');
INSERT INTO `node` VALUES (1979855023, 'New MindMap', 37, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:39:48', '2023-02-26 09:48:29');
INSERT INTO `node` VALUES (1979855024, 'New MindMap', 38, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:40:21', '2023-02-26 09:40:21');
INSERT INTO `node` VALUES (1979855025, 'New MindMap', 39, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:45:07', '2023-02-26 09:45:07');
INSERT INTO `node` VALUES (1979855026, 'New MindMap', 40, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:47:00', '2023-02-26 09:47:00');
INSERT INTO `node` VALUES (1979855027, 'New MindMap', 41, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:47:07', '2023-02-26 09:47:07');
INSERT INTO `node` VALUES (1979855028, 'New MindMap', 42, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:47:18', '2023-02-26 09:47:18');
INSERT INTO `node` VALUES (1979855029, 'New MindMap', 43, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:50:19', '2023-02-26 09:50:19');
INSERT INTO `node` VALUES (1979855030, 'New MindMap', 44, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:51:17', '2023-02-26 09:51:17');
INSERT INTO `node` VALUES (1979855031, 'New MindMap', 45, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:52:29', '2023-02-26 10:02:01');
INSERT INTO `node` VALUES (1979855032, 'New MindMap', 46, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-26 09:58:06', '2023-02-26 09:58:06');
INSERT INTO `node` VALUES (1979855033, 'New MindMap', 47, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-26 15:03:01', '2023-02-26 15:03:01');
INSERT INTO `node` VALUES (2004382752, 'new Node', 35, 1979855021, 'right', 1, 0, NULL, 1, 1, '2023-02-26 15:07:20', '2023-02-26 15:07:20');
INSERT INTO `node` VALUES (2121193163, 'new Node', 35, 1758492971, NULL, 1, 0, NULL, 1, 1, '2023-02-26 15:07:20', '2023-02-26 15:07:20');
INSERT INTO `node` VALUES (2121193164, 'New MindMap', 48, 0, 'right', 1, 0, NULL, 1, 0, '2023-02-26 15:09:38', '2023-02-26 15:09:57');
INSERT INTO `node` VALUES (2131722483, 'new Node', 48, 2121193164, 'right', 1, 0, NULL, 1, 0, '2023-02-26 15:09:57', '2023-02-26 15:09:57');

-- ----------------------------
-- Table structure for theme
-- ----------------------------
DROP TABLE IF EXISTS `theme`;
CREATE TABLE `theme`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uid` int(11) NOT NULL,
  `deleted` int(11) NOT NULL DEFAULT 0,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of theme
-- ----------------------------
INSERT INTO `theme` VALUES (1, 'mindmap', 1, 0, '2023-01-05 17:58:04', '2023-02-26 15:04:03');
INSERT INTO `theme` VALUES (3, 'testUpdate', 2, 1, '2023-01-05 17:58:04', '2023-02-26 09:46:40');
INSERT INTO `theme` VALUES (4, 'test11', 1, 1, '2023-01-05 17:59:50', '2023-02-25 18:45:55');
INSERT INTO `theme` VALUES (5, 'test0', 1, 0, '2023-01-10 22:22:40', '2023-02-25 21:42:19');
INSERT INTO `theme` VALUES (6, 'test1', 1, 1, '2023-01-10 22:22:40', '2023-02-25 22:01:28');
INSERT INTO `theme` VALUES (7, 'test2', 1, 1, '2023-01-10 22:22:40', '2023-02-25 18:46:14');
INSERT INTO `theme` VALUES (8, 'test3', 1, 1, '2023-01-10 22:22:40', '2023-01-10 22:22:40');
INSERT INTO `theme` VALUES (9, 'test41', 1, 1, '2023-01-10 22:22:40', '2023-02-25 21:42:25');
INSERT INTO `theme` VALUES (10, 'test5', 1, 1, '2023-01-10 22:22:40', '2023-02-25 18:46:10');
INSERT INTO `theme` VALUES (11, 'test6', 1, 1, '2023-01-10 22:22:40', '2023-02-25 18:46:05');
INSERT INTO `theme` VALUES (12, 'test77', 1, 1, '2023-01-10 22:22:40', '2023-02-25 21:42:21');
INSERT INTO `theme` VALUES (13, 'test8', 1, 1, '2023-01-10 22:22:40', '2023-02-25 18:46:00');
INSERT INTO `theme` VALUES (14, 'test9', 1, 1, '2023-01-10 22:22:40', '2023-02-25 10:19:16');
INSERT INTO `theme` VALUES (15, 'test10', 2, 1, '2023-01-10 22:23:16', '2023-01-10 22:23:16');
INSERT INTO `theme` VALUES (16, 'test11', 2, 1, '2023-01-10 22:23:16', '2023-01-10 22:23:16');
INSERT INTO `theme` VALUES (17, 'test12', 2, 1, '2023-01-10 22:23:16', '2023-01-10 22:23:16');
INSERT INTO `theme` VALUES (18, 'test13', 2, 1, '2023-01-10 22:23:16', '2023-01-10 22:23:16');
INSERT INTO `theme` VALUES (19, 'test14', 2, 1, '2023-01-10 22:23:16', '2023-01-10 22:23:16');
INSERT INTO `theme` VALUES (20, 'test15', 2, 1, '2023-01-10 22:23:16', '2023-01-10 22:23:16');
INSERT INTO `theme` VALUES (21, 'test16', 2, 1, '2023-01-10 22:23:16', '2023-01-10 22:23:16');
INSERT INTO `theme` VALUES (22, 'test17', 2, 1, '2023-01-10 22:23:16', '2023-01-10 22:23:16');
INSERT INTO `theme` VALUES (23, 'test18', 2, 1, '2023-01-10 22:23:16', '2023-01-10 22:23:16');
INSERT INTO `theme` VALUES (24, 'test19', 2, 1, '2023-01-10 22:23:16', '2023-01-10 22:23:16');
INSERT INTO `theme` VALUES (25, 'test31', 1, 1, '2023-02-25 10:31:09', '2023-02-25 10:31:11');
INSERT INTO `theme` VALUES (26, 'test32', 1, 1, '2023-02-25 10:31:20', '2023-02-25 10:31:22');
INSERT INTO `theme` VALUES (27, 'adasdasd', 1, 1, '2023-02-25 14:02:29', '2023-02-25 21:42:29');
INSERT INTO `theme` VALUES (28, 'test111', 1, 1, '2023-02-25 18:28:25', '2023-02-25 18:28:25');
INSERT INTO `theme` VALUES (29, 'test', 1, 0, '2023-02-25 18:35:43', '2023-02-26 09:37:33');
INSERT INTO `theme` VALUES (30, 'test213', 1, 0, '2023-02-25 18:37:30', '2023-02-25 21:42:33');
INSERT INTO `theme` VALUES (31, 'test010', 1, 1, '2023-02-25 18:42:09', '2023-02-25 21:42:35');
INSERT INTO `theme` VALUES (32, 'test111', 1, 0, '2023-02-25 18:43:18', '2023-02-25 21:42:37');
INSERT INTO `theme` VALUES (33, 'test0111', 1, 0, '2023-02-25 18:43:52', '2023-02-25 21:42:38');
INSERT INTO `theme` VALUES (34, 'egnrngosirhngodzf', 1, 1, '2023-02-25 18:45:25', '2023-02-26 15:02:45');
INSERT INTO `theme` VALUES (35, 'aaa123', 1, 0, '2023-02-25 21:41:37', '2023-02-26 15:04:28');
INSERT INTO `theme` VALUES (36, 'alnfrognry123', 1, 0, '2023-02-26 09:29:50', '2023-02-26 09:36:56');
INSERT INTO `theme` VALUES (37, 'mindmap2', 2, 0, '2023-02-26 09:39:48', '2023-02-26 09:48:32');
INSERT INTO `theme` VALUES (38, 'test11', 2, 0, '2023-02-26 09:40:21', '2023-02-26 09:46:48');
INSERT INTO `theme` VALUES (39, 'testuser', 2, 0, '2023-02-26 09:45:06', '2023-02-26 09:45:47');
INSERT INTO `theme` VALUES (40, 'test1', 2, 0, '2023-02-26 09:47:00', '2023-02-26 09:47:00');
INSERT INTO `theme` VALUES (41, 'test0', 2, 0, '2023-02-26 09:47:07', '2023-02-26 09:47:07');
INSERT INTO `theme` VALUES (42, 'test123', 2, 0, '2023-02-26 09:47:18', '2023-02-26 15:14:15');
INSERT INTO `theme` VALUES (43, 'test2435', 2, 1, '2023-02-26 09:50:19', '2023-02-26 09:50:19');
INSERT INTO `theme` VALUES (44, 'new', 3, 0, '2023-02-26 09:51:17', '2023-02-26 09:51:19');
INSERT INTO `theme` VALUES (45, 'new theme', 4, 0, '2023-02-26 09:52:29', '2023-02-26 10:02:04');
INSERT INTO `theme` VALUES (46, 'test', 4, 0, '2023-02-26 09:58:06', '2023-02-26 09:58:06');
INSERT INTO `theme` VALUES (47, 'test0000', 1, 0, '2023-02-26 15:03:01', '2023-02-26 15:03:03');
INSERT INTO `theme` VALUES (48, 'twefd3', 2, 0, '2023-02-26 15:09:38', '2023-02-26 15:10:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `level` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', '2023-01-05 18:01:06', 3);
INSERT INTO `user` VALUES (2, 'ahahha', '123456', '2023-01-05 18:01:09', 1);
INSERT INTO `user` VALUES (3, 'testuser', '123456', '2023-02-26 09:51:00', 1);

SET FOREIGN_KEY_CHECKS = 1;
