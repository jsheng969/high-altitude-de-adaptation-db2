package cn.iocoder.yudao.module.queueDB.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {
    ErrorCode FIELD_CONFIG_NOT_EXISTS = new ErrorCode(1_001_203_000, "动态字段配置不存在");
    ErrorCode MODULE_CONFIG_NOT_EXISTS = new ErrorCode(1_001_203_001, "动态模块配置表（支持三级结构）不存在");
}