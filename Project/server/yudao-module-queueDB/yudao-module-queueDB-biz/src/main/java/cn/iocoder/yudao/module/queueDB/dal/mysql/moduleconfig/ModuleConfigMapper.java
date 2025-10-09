package cn.iocoder.yudao.module.queueDB.dal.mysql.moduleconfig;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.moduleconfig.ModuleConfigDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.queueDB.controller.admin.moduleconfig.vo.*;
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

    @Select("SELECT * FROM module_config ORDER BY order_no ASC")
    List<ModuleConfigDO> selectAll();

    @Select("SELECT * FROM module_config WHERE parent_code IS NULL ORDER BY order_no ASC")
    List<ModuleConfigDO> selectRootModules();

    @Select("SELECT * FROM module_config WHERE parent_code = #{parentCode} ORDER BY order_no ASC")
    List<ModuleConfigDO> selectByParentCode(String parentCode);

    @Select("SELECT * FROM module_config WHERE module_code = #{moduleCode} LIMIT 1")
    ModuleConfigDO selectByCode(String moduleCode);

}