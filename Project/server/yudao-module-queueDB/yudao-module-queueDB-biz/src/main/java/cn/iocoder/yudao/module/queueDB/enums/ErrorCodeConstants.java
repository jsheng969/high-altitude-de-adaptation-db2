package cn.iocoder.yudao.module.queueDB.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {
    ErrorCode FIELD_CONFIG_NOT_EXISTS = new ErrorCode(1_001_203_000, "动态字段配置不存在");
    ErrorCode MODULE_CONFIG_NOT_EXISTS = new ErrorCode(1_001_203_001, "动态模块配置表（支持三级结构）不存在");
    ErrorCode REGISTRY_NOT_EXISTS = new ErrorCode(1_001_203_002, "动态表注册不存在");

    // ========== 模块配置 2-003-001-000 ==========
    ErrorCode MODULE_CONFIG_CODE_EXISTS = new ErrorCode(2_003_001_001, "模块代码已存在: {}");
    ErrorCode MODULE_CONFIG_CODE_NOT_BLANK = new ErrorCode(2_003_001_002, "模块代码不能为空");
    ErrorCode MODULE_CONFIG_HAS_CHILDREN = new ErrorCode(2_003_001_003, "存在子模块，无法删除");
    ErrorCode MODULE_CONFIG_HAS_FIELDS = new ErrorCode(2_003_001_004, "模块下存在字段，无法删除");
    ErrorCode MODULE_CONFIG_PARENT_SELF = new ErrorCode(2_003_001_005, "父模块不能是自己");
    ErrorCode MODULE_CONFIG_LEVEL_MAX = new ErrorCode(2_003_001_006, "模块层级不能超过 3 级");

    // ========== 字段配置 2-003-002-000 ==========
    ErrorCode FIELD_CONFIG_CODE_EXISTS = new ErrorCode(2_003_002_001, "字段代码已存在: {}");
    ErrorCode FIELD_CONFIG_CODE_NOT_BLANK = new ErrorCode(2_003_002_002, "字段代码不能为空");
    ErrorCode FIELD_CONFIG_MODULE_NOT_EXISTS = new ErrorCode(2_003_002_003, "所属模块不存在");

    // ========== 动态表 2-003-003-000 ==========
    ErrorCode DYNAMIC_TABLE_NOT_EXISTS = new ErrorCode(2_003_003_000, "动态表不存在");
    ErrorCode DYNAMIC_TABLE_CREATE_FAILED = new ErrorCode(2_003_003_001, "动态表创建失败: {}");
    ErrorCode DYNAMIC_TABLE_SYNC_FAILED = new ErrorCode(2_003_003_002, "动态表同步失败: {}");
}