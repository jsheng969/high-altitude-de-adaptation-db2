package cn.iocoder.yudao.module.review.dal.mysql.controlsurveydrinkinginfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveydrinkinginfo.ControlSurveyDrinkingInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveydrinkinginfo.vo.*;

/**
 * 对照组流调-饮酒情况 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ControlSurveyDrinkingInfoMapper extends BaseMapperX<ControlSurveyDrinkingInfoDO> {

    default PageResult<ControlSurveyDrinkingInfoDO> selectPage(ControlSurveyDrinkingInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlSurveyDrinkingInfoDO>()
                .eqIfPresent(ControlSurveyDrinkingInfoDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlSurveyDrinkingInfoDO::getDrinkingExperience, reqVO.getDrinkingExperience())
                .eqIfPresent(ControlSurveyDrinkingInfoDO::getDrinkingFrequency, reqVO.getDrinkingFrequency())
                .orderByDesc(ControlSurveyDrinkingInfoDO::getId));
    }

}