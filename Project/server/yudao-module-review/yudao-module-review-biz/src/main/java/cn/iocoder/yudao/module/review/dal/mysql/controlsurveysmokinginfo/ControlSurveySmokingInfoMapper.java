package cn.iocoder.yudao.module.review.dal.mysql.controlsurveysmokinginfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.controlsurveysmokinginfo.ControlSurveySmokingInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.controlsurveysmokinginfo.vo.*;

/**
 * 对照组流调-吸烟情况 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ControlSurveySmokingInfoMapper extends BaseMapperX<ControlSurveySmokingInfoDO> {

    default PageResult<ControlSurveySmokingInfoDO> selectPage(ControlSurveySmokingInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlSurveySmokingInfoDO>()
                .eqIfPresent(ControlSurveySmokingInfoDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlSurveySmokingInfoDO::getSmokingStatus, reqVO.getSmokingStatus())
                .eqIfPresent(ControlSurveySmokingInfoDO::getSmokingYears, reqVO.getSmokingYears())
                .eqIfPresent(ControlSurveySmokingInfoDO::getTriedQuit, reqVO.getTriedQuit())
                .eqIfPresent(ControlSurveySmokingInfoDO::getQuitTime, reqVO.getQuitTime())
                .orderByDesc(ControlSurveySmokingInfoDO::getId));
    }

}