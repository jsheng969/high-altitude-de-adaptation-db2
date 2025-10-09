package cn.iocoder.yudao.module.prospective.dal.mysql.experimentexamcoagulationtests;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexamcoagulationtests.ExperimentExamCoagulationTestsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexamcoagulationtests.vo.*;

/**
 * 实验组体检-凝血功能 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ExperimentExamCoagulationTestsMapper extends BaseMapperX<ExperimentExamCoagulationTestsDO> {

    default PageResult<ExperimentExamCoagulationTestsDO> selectPage(ExperimentExamCoagulationTestsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentExamCoagulationTestsDO>()
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getAptt, reqVO.getAptt())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getAntithrombinIiiActivityPercent, reqVO.getAntithrombinIiiActivityPercent())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getAntithrombinIiiActivityRate, reqVO.getAntithrombinIiiActivityRate())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getDDimerOptDensity, reqVO.getDDimerOptDensity())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getDDimerConcentration, reqVO.getDDimerConcentration())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getFibrinDegradationProductsDensity, reqVO.getFibrinDegradationProductsDensity())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getFibrinDegradationProductsConcentration, reqVO.getFibrinDegradationProductsConcentration())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getFibrinogenConcentration, reqVO.getFibrinogenConcentration())
                .betweenIfPresent(ExperimentExamCoagulationTestsDO::getFibrinogenClottingTime, reqVO.getFibrinogenClottingTime())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getProthrombinTimePercent, reqVO.getProthrombinTimePercent())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getPtInr, reqVO.getPtInr())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getProthrombinTimeRatio, reqVO.getProthrombinTimeRatio())
                .betweenIfPresent(ExperimentExamCoagulationTestsDO::getProthrombinTime, reqVO.getProthrombinTime())
                .betweenIfPresent(ExperimentExamCoagulationTestsDO::getThrombinTime, reqVO.getThrombinTime())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getThrombinTime1, reqVO.getThrombinTime1())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getAptt1, reqVO.getAptt1())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getAptt2, reqVO.getAptt2())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getProthrombinActivity, reqVO.getProthrombinActivity())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getInr, reqVO.getInr())
                .betweenIfPresent(ExperimentExamCoagulationTestsDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ExperimentExamCoagulationTestsDO::getTimePoint, reqVO.getTimePoint())
                .orderByDesc(ExperimentExamCoagulationTestsDO::getId));
    }

}