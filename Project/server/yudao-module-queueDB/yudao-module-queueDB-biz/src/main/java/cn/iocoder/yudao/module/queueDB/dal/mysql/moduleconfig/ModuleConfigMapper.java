package cn.iocoder.yudao.module.queueDB.dal.mysql.moduleconfig;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.moduleconfig.ModuleConfigDO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.queueDB.controller.admin.moduleconfig.vo.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 动态模块配置表（支持三级结构） Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ModuleConfigMapper extends BaseMapperX<ModuleConfigDO> {

    default PageResult<ModuleConfigDO> selectPage(ModuleConfigPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ModuleConfigDO>()
                .eqIfPresent(ModuleConfigDO::getParentId, reqVO.getParentId())
                .eqIfPresent(ModuleConfigDO::getModuleCode, reqVO.getModuleCode())
                .likeIfPresent(ModuleConfigDO::getModuleName, reqVO.getModuleName())
                .likeIfPresent(ModuleConfigDO::getTableName, reqVO.getTableName())
                .eqIfPresent(ModuleConfigDO::getModuleLevel, reqVO.getModuleLevel())
                .eqIfPresent(ModuleConfigDO::getGroupType, reqVO.getGroupType())
                .eqIfPresent(ModuleConfigDO::getModuleType, reqVO.getModuleType())
                .eqIfPresent(ModuleConfigDO::getIsLeaf, reqVO.getIsLeaf())
                .eqIfPresent(ModuleConfigDO::getOrderNo, reqVO.getOrderNo())
                .eqIfPresent(ModuleConfigDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ModuleConfigDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ModuleConfigDO::getId));
    }

    @Select("SELECT * FROM module_config WHERE parent_code = #{parentCode} ORDER BY order_no ASC")
    List<ModuleConfigDO> selectByParentCode(String parentCode);

    @Select("SELECT * FROM module_config WHERE deleted = 0 ORDER BY order_no ASC")
    List<ModuleConfigDO> selectAll();

    @Select("SELECT * FROM module_config WHERE parent_id IS NULL AND deleted = 0 ORDER BY order_no ASC")
    List<ModuleConfigDO> selectRootModules();

    default List<ModuleConfigDO> selectByParentId(Long parentId) {
        return selectList(new LambdaQueryWrapperX<ModuleConfigDO>()
                .eq(ModuleConfigDO::getParentId, parentId)
                .eq(ModuleConfigDO::getDeleted, false)
                .orderByAsc(ModuleConfigDO::getOrderNo));
    }

    default ModuleConfigDO selectByCode(String moduleCode) {
        return selectOne(new LambdaQueryWrapperX<ModuleConfigDO>()
                .eq(ModuleConfigDO::getModuleCode, moduleCode)
                .eq(ModuleConfigDO::getDeleted, false));
    }

    default boolean existsByCode(String moduleCode) {
        return selectCount(new LambdaQueryWrapperX<ModuleConfigDO>()
                .eq(ModuleConfigDO::getModuleCode, moduleCode)
                .eq(ModuleConfigDO::getDeleted, false)) > 0;
    }

    default boolean hasChildren(Long parentId) {
        return selectCount(new LambdaQueryWrapperX<ModuleConfigDO>()
                .eq(ModuleConfigDO::getParentId, parentId)
                .eq(ModuleConfigDO::getDeleted, false)) > 0;
    }

    /**
     * 查询模块树形结构
     */
    @Select("<script>" +
            "SELECT id, parent_id, module_code, module_name, module_level, module_type, " +
            "       group_type, is_leaf, table_name, order_no, status " +
            "FROM module_config " +
            "WHERE status = 1 " +
            "<if test='moduleName != null and moduleName != \"\"'>" +
            "   AND module_name LIKE CONCAT('%', #{moduleName}, '%') " +
            "</if>" +
            "<if test='moduleLevel != null'>" +
            "   AND module_level = #{moduleLevel} " +
            "</if>" +
            "ORDER BY order_no ASC" +
            "</script>")
    List<ModuleConfigDO> selectModuleTree(@Param("moduleName") String moduleName,
                                          @Param("moduleLevel") Integer moduleLevel);

    /**
     * 根据模块类型查询模块
     */
    @Select("SELECT * FROM module_config WHERE module_type = #{moduleType} AND status = 1 ORDER BY order_no ASC")
    List<ModuleConfigDO> selectByModuleType(@Param("moduleType") String moduleType);

    /**
     * 查询所有不重复的模块类型
     */
    @Select("SELECT DISTINCT module_type FROM module_config WHERE status = 1 AND module_type IS NOT NULL")
    List<String> selectDistinctModuleTypes();

//    /**
//     * 根据父模块ID查询子模块
//     */
//    @Select("SELECT * FROM module_config WHERE parent_id = #{parentId} AND status = 1 ORDER BY order_no ASC")
//    List<ModuleConfigDO> selectByParentId(@Param("parentId") Long parentId);

    /**
     * 检查模块代码是否存在
     */
    @Select("SELECT COUNT(*) FROM module_config WHERE module_code = #{moduleCode}")
    int checkModuleCodeExists(@Param("moduleCode") String moduleCode);

    /**
     * 根据分组类型查询模块
     */
    @Select("SELECT * FROM module_config WHERE group_type = #{groupType} AND status = 1 AND is_leaf = 1 ORDER BY order_no ASC")
    List<ModuleConfigDO> selectByGroupType(@Param("groupType") String groupType);

    /**
     * 根据模块编码查询模块配置
     */
    default ModuleConfigDO selectByModuleCode(String moduleCode) {
        return selectOne(new LambdaQueryWrapperX<ModuleConfigDO>()
                .eq(ModuleConfigDO::getModuleCode, moduleCode)
                .eq(ModuleConfigDO::getDeleted, false));
    }

    /**
     * 根据模块编码查询（包含已删除的）
     */
    default ModuleConfigDO selectByModuleCodeIncludeDeleted(String moduleCode) {
        return selectOne(new LambdaQueryWrapperX<ModuleConfigDO>()
                .eq(ModuleConfigDO::getModuleCode, moduleCode));
    }

    /**
     * 查询所有需要建表的叶子模块
     */
    default List<ModuleConfigDO> selectLeafModules() {
        return selectList(new LambdaQueryWrapperX<ModuleConfigDO>()
                .eq(ModuleConfigDO::getIsLeaf, 1)
                .eq(ModuleConfigDO::getDeleted, false)
                .orderByAsc(ModuleConfigDO::getOrderNo));
    }

    /**
     * 查询启用的叶子模块
     */
    default List<ModuleConfigDO> selectActiveLeafModules() {
        return selectList(new LambdaQueryWrapperX<ModuleConfigDO>()
                .eq(ModuleConfigDO::getIsLeaf, 1)
                .eq(ModuleConfigDO::getStatus, 1)
                .eq(ModuleConfigDO::getDeleted, false)
                .orderByAsc(ModuleConfigDO::getOrderNo));
    }

//    /**
//     * 检查模块编码是否存在
//     */
//    default boolean existsByModuleCode(String moduleCode) {
//        Long count = selectCount(new LambdaQueryWrapper<ModuleConfigDO>()
//                .eq(ModuleConfigDO::getModuleCode, moduleCode));
//        return count != null && count > 0;
//    }

    /**
     * 检查模块编码是否存在
     */
    @Select("SELECT COUNT(*) FROM module_config WHERE module_code = #{moduleCode}")
    int existsByModuleCode(@Param("moduleCode") String moduleCode);

    /**
     * 根据模块编码更新模块状态
     */
    default int updateStatusByModuleCode(String moduleCode, Integer status) {
        ModuleConfigDO updateDO = new ModuleConfigDO();
        updateDO.setStatus(status);
        updateDO.setUpdateTime(LocalDateTime.now());

        return update(updateDO, new LambdaQueryWrapperX<ModuleConfigDO>()
                .eq(ModuleConfigDO::getModuleCode, moduleCode)
                .eq(ModuleConfigDO::getDeleted, false));
    }

    /**
     * 根据模块编码逻辑删除
     */
    default int deleteByModuleCode(String moduleCode) {
        return delete(new LambdaQueryWrapperX<ModuleConfigDO>()
                .eq(ModuleConfigDO::getModuleCode, moduleCode));
    }

    /**
     * 查询模块统计信息
     */
    default Map<String, Long> countByModuleType() {
        LambdaQueryWrapper<ModuleConfigDO> wrapper = new LambdaQueryWrapper<ModuleConfigDO>()
                .select(ModuleConfigDO::getModuleType)
                .eq(ModuleConfigDO::getDeleted, false)
                .groupBy(ModuleConfigDO::getModuleType);

        List<ModuleConfigDO> list = selectList(wrapper);
        return list.stream()
                .collect(Collectors.groupingBy(ModuleConfigDO::getModuleType, Collectors.counting()));
    }

    /**
     * 根据父级ID查询子模块列表（包含逻辑删除的记录）
     */
    @Select("SELECT * FROM module_config WHERE parent_id = #{parentId}")
    List<ModuleConfigDO> selectByParentIdIncludeDeleted(@Param("parentId") Long parentId);

    /**
     * 根据模块编码物理删除模块
     */
    @Delete("DELETE FROM module_config WHERE module_code = #{moduleCode}")
    int physicallyDeleteByModuleCode(@Param("moduleCode") String moduleCode);

    /**
     * 根据ID物理删除模块
     */
    @Delete("DELETE FROM module_config WHERE id = #{id}")
    int physicallyDeleteById(@Param("id") Long id);

    /**
     * 根据父级ID物理删除子模块
     */
    @Delete("DELETE FROM module_config WHERE parent_id = #{parentId}")
    int physicallyDeleteByParentId(@Param("parentId") Long parentId);

    /**
     * 根据ID列表物理删除模块
     */
    @Delete("<script>" +
            "DELETE FROM module_config WHERE id IN " +
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int physicallyDeleteByIds(@Param("ids") List<Long> ids);

}