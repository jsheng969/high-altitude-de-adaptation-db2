package cn.iocoder.yudao.module.review.dal.mysql.controlsurveyresidenceinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveyresidenceinfo.ControlSurveyResidenceInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveyresidenceinfo.vo.*;

/**
 * 对照组流调-旅居信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ControlSurveyResidenceInfoMapper extends BaseMapperX<ControlSurveyResidenceInfoDO> {

    default PageResult<ControlSurveyResidenceInfoDO> selectPage(ControlSurveyResidenceInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlSurveyResidenceInfoDO>()
                .eqIfPresent(ControlSurveyResidenceInfoDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlSurveyResidenceInfoDO::getHighlandExperience, reqVO.getHighlandExperience())
                .eqIfPresent(ControlSurveyResidenceInfoDO::getLongTermPlainExperience, reqVO.getLongTermPlainExperience())
                .eqIfPresent(ControlSurveyResidenceInfoDO::getResidence1, reqVO.getResidence1())
                .eqIfPresent(ControlSurveyResidenceInfoDO::getResidence2, reqVO.getResidence2())
                .eqIfPresent(ControlSurveyResidenceInfoDO::getResidence3, reqVO.getResidence3())
                .orderByDesc(ControlSurveyResidenceInfoDO::getId));
    }

}