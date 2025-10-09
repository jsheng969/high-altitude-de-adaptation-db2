package cn.iocoder.yudao.module.prospective.dal.mysql.basicotherinfo;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.basicotherinfo.ProspectiveBasicOtherInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.basicotherinfo.vo.*;

/**
 * 基础其他信息 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ProspectiveBasicOtherInfoMapper extends BaseMapperX<ProspectiveBasicOtherInfoDO> {

    default PageResult<ProspectiveBasicOtherInfoDO> selectPage(BasicOtherInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProspectiveBasicOtherInfoDO>()
                .eqIfPresent(ProspectiveBasicOtherInfoDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ProspectiveBasicOtherInfoDO::getMaritalStatus, reqVO.getMaritalStatus())
                .eqIfPresent(ProspectiveBasicOtherInfoDO::getFertilityStatus, reqVO.getFertilityStatus())
                .eqIfPresent(ProspectiveBasicOtherInfoDO::getEthnicity, reqVO.getEthnicity())
                .eqIfPresent(ProspectiveBasicOtherInfoDO::getEducationLevel, reqVO.getEducationLevel())
                .betweenIfPresent(ProspectiveBasicOtherInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProspectiveBasicOtherInfoDO::getId));
    }

}