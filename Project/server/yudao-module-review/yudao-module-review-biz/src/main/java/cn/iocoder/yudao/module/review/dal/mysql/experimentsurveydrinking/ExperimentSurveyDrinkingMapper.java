package cn.iocoder.yudao.module.review.dal.mysql.experimentsurveydrinking;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveydrinking.ExperimentSurveyDrinkingDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveydrinking.vo.*;

/**
 * 实验组流调-饮酒情况 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentSurveyDrinkingMapper extends BaseMapperX<ExperimentSurveyDrinkingDO> {

    default PageResult<ExperimentSurveyDrinkingDO> selectPage(ExperimentSurveyDrinkingPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyDrinkingDO>()
                .eqIfPresent(ExperimentSurveyDrinkingDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyDrinkingDO::getDrinkingExperience, reqVO.getDrinkingExperience())
                .eqIfPresent(ExperimentSurveyDrinkingDO::getStillDrinking, reqVO.getStillDrinking())
                .eqIfPresent(ExperimentSurveyDrinkingDO::getDrinkingFrequency, reqVO.getDrinkingFrequency())
                .eqIfPresent(ExperimentSurveyDrinkingDO::getOverDrinking, reqVO.getOverDrinking())
                .eqIfPresent(ExperimentSurveyDrinkingDO::getBeer, reqVO.getBeer())
                .eqIfPresent(ExperimentSurveyDrinkingDO::getLiquor, reqVO.getLiquor())
                .eqIfPresent(ExperimentSurveyDrinkingDO::getRedWine, reqVO.getRedWine())
                .eqIfPresent(ExperimentSurveyDrinkingDO::getCocktails, reqVO.getCocktails())
                .eqIfPresent(ExperimentSurveyDrinkingDO::getSpirits, reqVO.getSpirits())
                .eqIfPresent(ExperimentSurveyDrinkingDO::getOtherAlcohol, reqVO.getOtherAlcohol())
                .orderByDesc(ExperimentSurveyDrinkingDO::getId));
    }

}