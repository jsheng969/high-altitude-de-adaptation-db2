package cn.iocoder.yudao.module.queueDB.dal.mysql.registry;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.registry.RegistryDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.queueDB.controller.admin.registry.vo.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 动态表注册 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface RegistryMapper extends BaseMapperX<RegistryDO> {

    default PageResult<RegistryDO> selectPage(RegistryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<RegistryDO>()
                .likeIfPresent(RegistryDO::getTableName, reqVO.getTableName())
                .eqIfPresent(RegistryDO::getModuleCode, reqVO.getModuleCode())
                .eqIfPresent(RegistryDO::getNodeType, reqVO.getNodeType())
                .eqIfPresent(RegistryDO::getStatus, reqVO.getStatus())
                .eqIfPresent(RegistryDO::getFieldCount, reqVO.getFieldCount())
                .eqIfPresent(RegistryDO::getDescription, reqVO.getDescription())
                .betweenIfPresent(RegistryDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RegistryDO::getId));
    }

    @Select("SELECT * FROM table_registry WHERE table_name = #{tableName} LIMIT 1")
    RegistryDO selectByTableName(@Param("tableName") String tableName);


}