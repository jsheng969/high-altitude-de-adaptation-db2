package cn.iocoder.yudao.module.queueDB.dal.mysql.fieldconfig;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.fieldconfig.FieldConfigDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.queueDB.controller.admin.fieldconfig.vo.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 动态字段配置 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface FieldConfigMapper extends BaseMapperX<FieldConfigDO> {

    default PageResult<FieldConfigDO> selectPage(FieldConfigPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<FieldConfigDO>()
                .eqIfPresent(FieldConfigDO::getModuleCode, reqVO.getModuleCode())
                .eqIfPresent(FieldConfigDO::getFieldCode, reqVO.getFieldCode())
                .eqIfPresent(FieldConfigDO::getFieldLabel, reqVO.getFieldLabel())
                .eqIfPresent(FieldConfigDO::getFieldType, reqVO.getFieldType())
                .eqIfPresent(FieldConfigDO::getDataType, reqVO.getDataType())
                .eqIfPresent(FieldConfigDO::getOptionsJson, reqVO.getOptionsJson())
                .eqIfPresent(FieldConfigDO::getIsRequired, reqVO.getIsRequired())
                .eqIfPresent(FieldConfigDO::getOrderNo, reqVO.getOrderNo())
                .eqIfPresent(FieldConfigDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(FieldConfigDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(FieldConfigDO::getId));
    }

    /**
     * 按 moduleCode 查询字段（按 sortOrder 排序）
     */
    List<FieldConfigDO> selectByModuleCode(@Param("moduleCode") String moduleCode);

    @Select("SELECT * FROM field_config WHERE module_code = #{moduleCode} ORDER BY sort_order ASC")
    List<FieldConfigDO> selectListByModuleCode(@Param("moduleCode") String moduleCode);

    @Select("SELECT DISTINCT module_code FROM field_config")
    List<String> selectDistinctModuleCodes();

}