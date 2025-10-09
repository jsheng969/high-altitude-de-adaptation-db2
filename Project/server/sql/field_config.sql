/*
 Navicat Premium Dump SQL

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80027 (8.0.27)
 Source Host           : localhost:3306
 Source Schema         : high-altitude

 Target Server Type    : MySQL
 Target Server Version : 80027 (8.0.27)
 File Encoding         : 65001

 Date: 04/10/2025 17:36:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for field_config
-- ----------------------------
DROP TABLE IF EXISTS `field_config`;
CREATE TABLE `field_config` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '字段ID',
  `module_code` varchar(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT '所属模块code（对应module_config.module_code）',
  `field_code` varchar(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT '字段标识（用于数据库列名）',
  `field_label` varchar(200) COLLATE utf8mb4_general_ci NOT NULL COMMENT '字段显示名',
  `field_type` varchar(50) COLLATE utf8mb4_general_ci NOT NULL COMMENT '字段类型（input/select/number/date/checkbox等）',
  `data_type` varchar(100) COLLATE utf8mb4_general_ci DEFAULT 'VARCHAR(255)' COMMENT '数据库字段类型',
  `options_json` json DEFAULT NULL COMMENT '选项配置（如下拉选项等）',
  `is_required` tinyint DEFAULT '0' COMMENT '是否必填',
  `order_no` int DEFAULT '0' COMMENT '排序号',
  `status` tinyint DEFAULT '1' COMMENT '状态（1启用）',
  `creator` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建者',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updater` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新者',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
  `tenant_id` bigint NOT NULL DEFAULT '0' COMMENT '租户编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='动态字段配置表';

-- ----------------------------
-- Records of field_config
-- ----------------------------
BEGIN;
INSERT INTO `field_config` (`id`, `module_code`, `field_code`, `field_label`, `field_type`, `data_type`, `options_json`, `is_required`, `order_no`, `status`, `create_time`, `update_time`) VALUES (1, 'smoking_current', 'daily_smoke_count', '每天吸烟数（支）', 'number', 'INT', NULL, 0, 0, 1, '2025-10-04 16:02:00', '2025-10-04 16:02:00');
INSERT INTO `field_config` (`id`, `module_code`, `field_code`, `field_label`, `field_type`, `data_type`, `options_json`, `is_required`, `order_no`, `status`, `create_time`, `update_time`) VALUES (2, 'smoking_current', 'smoke_years', '吸烟年数', 'number', 'INT', NULL, 0, 0, 1, '2025-10-04 16:02:00', '2025-10-04 16:02:00');
INSERT INTO `field_config` (`id`, `module_code`, `field_code`, `field_label`, `field_type`, `data_type`, `options_json`, `is_required`, `order_no`, `status`, `create_time`, `update_time`) VALUES (3, 'smoking_current', 'smoke_type', '烟草类型', 'select', 'VARCHAR(100)', NULL, 0, 0, 1, '2025-10-04 16:02:00', '2025-10-04 16:02:00');
INSERT INTO `field_config` (`id`, `module_code`, `field_code`, `field_label`, `field_type`, `data_type`, `options_json`, `is_required`, `order_no`, `status`, `create_time`, `update_time`) VALUES (4, 'smoking_quit', 'quit_years', '戒烟年数', 'number', 'INT', NULL, 0, 0, 1, '2025-10-04 16:02:00', '2025-10-04 16:02:00');
INSERT INTO `field_config` (`id`, `module_code`, `field_code`, `field_label`, `field_type`, `data_type`, `options_json`, `is_required`, `order_no`, `status`, `create_time`, `update_time`) VALUES (5, 'smoking_quit', 'quit_reason', '戒烟原因', 'input', 'VARCHAR(255)', NULL, 0, 0, 1, '2025-10-04 16:02:00', '2025-10-04 16:02:00');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
