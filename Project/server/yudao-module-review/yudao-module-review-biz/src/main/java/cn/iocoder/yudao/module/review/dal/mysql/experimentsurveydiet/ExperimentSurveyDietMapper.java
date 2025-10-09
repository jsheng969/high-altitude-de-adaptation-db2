package cn.iocoder.yudao.module.review.dal.mysql.experimentsurveydiet;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentsurveydiet.ExperimentSurveyDietDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentsurveydiet.vo.*;

/**
 * 实验组流调-饮食习惯 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentSurveyDietMapper extends BaseMapperX<ExperimentSurveyDietDO> {

    default PageResult<ExperimentSurveyDietDO> selectPage(ExperimentSurveyDietPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentSurveyDietDO>()
                .eqIfPresent(ExperimentSurveyDietDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentSurveyDietDO::getEatingHabits, reqVO.getEatingHabits())
                .eqIfPresent(ExperimentSurveyDietDO::getDrinkingWater, reqVO.getDrinkingWater())
                .eqIfPresent(ExperimentSurveyDietDO::getTea, reqVO.getTea())
                .eqIfPresent(ExperimentSurveyDietDO::getFruitJuice, reqVO.getFruitJuice())
                .eqIfPresent(ExperimentSurveyDietDO::getCarbonatedDrinks, reqVO.getCarbonatedDrinks())
                .eqIfPresent(ExperimentSurveyDietDO::getCoffee, reqVO.getCoffee())
                .eqIfPresent(ExperimentSurveyDietDO::getMilk, reqVO.getMilk())
                .orderByDesc(ExperimentSurveyDietDO::getId));
    }

}