package cn.iocoder.yudao.module.queueDB.dal.mysql.fieldconfig;

import java.util.*;
import java.util.stream.Collectors;

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
                .orderByDesc(FieldConfigDO::getId));
    }

    /**
     * 按 moduleCode 查询字段（按 sortOrder 排序）
     */
    default List<FieldConfigDO> selectByModuleCode(String moduleCode) {
        return selectList(new LambdaQueryWrapperX<FieldConfigDO>()
                .eq(FieldConfigDO::getModuleCode, moduleCode)
                .eq(FieldConfigDO::getDeleted, false)
                .orderByAsc(FieldConfigDO::getOrderNo));
    }

    @Select("SELECT * FROM field_config WHERE module_code = #{moduleCode} AND deleted = 0 ORDER BY order_no ASC")
    List<FieldConfigDO> selectListByModuleCode(@Param("moduleCode") String moduleCode);

    @Select("SELECT DISTINCT module_code FROM field_config WHERE deleted = 0")
    List<String> selectDistinctModuleCodes();

    default FieldConfigDO selectByModuleAndFieldCode(String moduleCode, String fieldCode) {
        return selectOne(new LambdaQueryWrapperX<FieldConfigDO>()
                .eq(FieldConfigDO::getModuleCode, moduleCode)
                .eq(FieldConfigDO::getFieldCode, fieldCode)
                .eq(FieldConfigDO::getDeleted, false));
    }

    default boolean existsByModuleAndFieldCode(String moduleCode, String fieldCode) {
        return selectCount(new LambdaQueryWrapperX<FieldConfigDO>()
                .eq(FieldConfigDO::getModuleCode, moduleCode)
                .eq(FieldConfigDO::getFieldCode, fieldCode)
                .eq(FieldConfigDO::getDeleted, false)) > 0;
    }

    default Long countByModuleCode(String moduleCode) {
        return selectCount(new LambdaQueryWrapperX<FieldConfigDO>()
                .eq(FieldConfigDO::getModuleCode, moduleCode)
                .eq(FieldConfigDO::getDeleted, false));
    }

    @Select("SELECT module_code, COUNT(*) as field_count FROM field_config WHERE deleted = 0 GROUP BY module_code")
    List<Map<String, Object>> selectFieldCountByModule();

//    /**
//     * 根据模块代码查询字段列表
//     */
//    @Select("SELECT * FROM field_config WHERE module_code = #{moduleCode} AND status = 1 ORDER BY order_no ASC")
//    List<FieldConfigDO> selectListByModuleCode(@Param("moduleCode") String moduleCode);
//
//    /**
//     * 查询所有不重复的模块代码
//     */
//    @Select("SELECT DISTINCT module_code FROM field_config WHERE status = 1")
//    List<String> selectDistinctModuleCodes();

    /**
     * 根据模块类型和时间点查询字段配置
     */
    @Select("<script>" +
            "SELECT fc.*, mc.module_name, mc.table_name " +
            "FROM field_config fc " +
            "LEFT JOIN module_config mc ON fc.module_code = mc.module_code " +
            "WHERE fc.status = 1 AND mc.status = 1 " +
            "<if test='moduleType != null and moduleType != \"\"'>" +
            "   AND mc.module_type = #{moduleType} " +
            "</if>" +
            "<if test='timePoint != null'>" +
            "   AND mc.time_point = #{timePoint} " +
            "</if>" +
            "ORDER BY mc.order_no ASC, fc.order_no ASC" +
            "</script>")
    List<FieldConfigDO> selectByModuleTypeAndTimePoint(@Param("moduleType") String moduleType,
                                                       @Param("timePoint") Integer timePoint);

    /**
     * 根据模块类型查询字段配置
     */
    @Select("SELECT fc.*, mc.module_name, mc.table_name " +
            "FROM field_config fc " +
            "LEFT JOIN module_config mc ON fc.module_code = mc.module_code " +
            "WHERE fc.status = 1 AND mc.status = 1 AND mc.module_type = #{moduleType} " +
            "ORDER BY mc.order_no ASC, fc.order_no ASC")
    List<FieldConfigDO> selectByModuleType(@Param("moduleType") String moduleType);

    /**
     * 根据字段组查询字段配置
     */
    @Select("SELECT * FROM field_config WHERE field_group = #{fieldGroup} AND status = 1 ORDER BY order_no ASC")
    List<FieldConfigDO> selectByFieldGroup(@Param("fieldGroup") String fieldGroup);

    /**
     * 查询所有不重复的字段组
     */
    @Select("SELECT DISTINCT field_group FROM field_config WHERE status = 1 AND field_group IS NOT NULL")
    List<String> selectDistinctFieldGroups();

    /**
     * 检查字段代码是否存在
     */
    @Select("SELECT COUNT(*) FROM field_config WHERE field_code = #{fieldCode} AND module_code = #{moduleCode}")
    int checkFieldCodeExists(@Param("fieldCode") String fieldCode, @Param("moduleCode") String moduleCode);
}