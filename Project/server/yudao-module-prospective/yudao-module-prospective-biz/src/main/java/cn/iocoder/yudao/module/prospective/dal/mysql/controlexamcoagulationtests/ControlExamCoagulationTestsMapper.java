package cn.iocoder.yudao.module.prospective.dal.mysql.controlexamcoagulationtests;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlexamcoagulationtests.ControlExamCoagulationTestsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexamcoagulationtests.vo.*;

/**
 * 实验组体检-凝血功能 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ControlExamCoagulationTestsMapper extends BaseMapperX<ControlExamCoagulationTestsDO> {

    default PageResult<ControlExamCoagulationTestsDO> selectPage(ControlExamCoagulationTestsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlExamCoagulationTestsDO>()
                .eqIfPresent(ControlExamCoagulationTestsDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlExamCoagulationTestsDO::getAptt, reqVO.getAptt())
                .eqIfPresent(ControlExamCoagulationTestsDO::getAntithrombinIiiActivityPercent, reqVO.getAntithrombinIiiActivityPercent())
                .eqIfPresent(ControlExamCoagulationTestsDO::getAntithrombinIiiActivityRate, reqVO.getAntithrombinIiiActivityRate())
                .eqIfPresent(ControlExamCoagulationTestsDO::getDDimerOptDensity, reqVO.getDDimerOptDensity())
                .eqIfPresent(ControlExamCoagulationTestsDO::getDDimerConcentration, reqVO.getDDimerConcentration())
                .eqIfPresent(ControlExamCoagulationTestsDO::getFibrinDegradationProductsDensity, reqVO.getFibrinDegradationProductsDensity())
                .eqIfPresent(ControlExamCoagulationTestsDO::getFibrinDegradationProductsConcentration, reqVO.getFibrinDegradationProductsConcentration())
                .eqIfPresent(ControlExamCoagulationTestsDO::getFibrinogenConcentration, reqVO.getFibrinogenConcentration())
                .betweenIfPresent(ControlExamCoagulationTestsDO::getFibrinogenClottingTime, reqVO.getFibrinogenClottingTime())
                .eqIfPresent(ControlExamCoagulationTestsDO::getProthrombinTimePercent, reqVO.getProthrombinTimePercent())
                .eqIfPresent(ControlExamCoagulationTestsDO::getPtInr, reqVO.getPtInr())
                .eqIfPresent(ControlExamCoagulationTestsDO::getProthrombinTimeRatio, reqVO.getProthrombinTimeRatio())
                .betweenIfPresent(ControlExamCoagulationTestsDO::getProthrombinTime, reqVO.getProthrombinTime())
                .betweenIfPresent(ControlExamCoagulationTestsDO::getThrombinTime, reqVO.getThrombinTime())
                .eqIfPresent(ControlExamCoagulationTestsDO::getThrombinTime1, reqVO.getThrombinTime1())
                .eqIfPresent(ControlExamCoagulationTestsDO::getAptt1, reqVO.getAptt1())
                .eqIfPresent(ControlExamCoagulationTestsDO::getAptt2, reqVO.getAptt2())
                .eqIfPresent(ControlExamCoagulationTestsDO::getProthrombinActivity, reqVO.getProthrombinActivity())
                .eqIfPresent(ControlExamCoagulationTestsDO::getInr, reqVO.getInr())
                .betweenIfPresent(ControlExamCoagulationTestsDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ControlExamCoagulationTestsDO::getTimePoint, reqVO.getTimePoint())
                .eqIfPresent(ControlExamCoagulationTestsDO::getPtdFbg, reqVO.getPtdFbg())
                .orderByDesc(ControlExamCoagulationTestsDO::getId));
    }

}