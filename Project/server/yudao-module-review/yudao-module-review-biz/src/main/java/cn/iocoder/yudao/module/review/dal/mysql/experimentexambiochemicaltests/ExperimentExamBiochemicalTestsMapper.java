package cn.iocoder.yudao.module.review.dal.mysql.experimentexambiochemicaltests;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexambiochemicaltests.ExperimentExamBiochemicalTestsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentexambiochemicaltests.vo.*;

/**
 * 实验组体检-生化 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentExamBiochemicalTestsMapper extends BaseMapperX<ExperimentExamBiochemicalTestsDO> {

    default PageResult<ExperimentExamBiochemicalTestsDO> selectPage(ExperimentExamBiochemicalTestsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentExamBiochemicalTestsDO>()
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getUrea, reqVO.getUrea())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getCreatinine, reqVO.getCreatinine())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getAlt, reqVO.getAlt())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getAst, reqVO.getAst())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getTotalCholesterol, reqVO.getTotalCholesterol())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getTriglycerides, reqVO.getTriglycerides())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getHdlC, reqVO.getHdlC())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getLdlC, reqVO.getLdlC())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getUricAcid, reqVO.getUricAcid())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getTotalProtein, reqVO.getTotalProtein())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getAlbumin, reqVO.getAlbumin())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getGlobulin, reqVO.getGlobulin())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getAlbGlobRatio, reqVO.getAlbGlobRatio())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getTotalBilirubin, reqVO.getTotalBilirubin())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getDirectBilirubin, reqVO.getDirectBilirubin())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getIndirectBilirubin, reqVO.getIndirectBilirubin())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getGlycatedHemoglobin, reqVO.getGlycatedHemoglobin())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getPotassium, reqVO.getPotassium())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getSodium, reqVO.getSodium())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getChloride, reqVO.getChloride())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getCalcium, reqVO.getCalcium())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getPhosphorus, reqVO.getPhosphorus())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getMagnesium, reqVO.getMagnesium())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getFastingGlucose, reqVO.getFastingGlucose())
                .betweenIfPresent(ExperimentExamBiochemicalTestsDO::getProthrombinTime, reqVO.getProthrombinTime())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getProthrombinActivity, reqVO.getProthrombinActivity())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getInr, reqVO.getInr())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getFibrinogen, reqVO.getFibrinogen())
                .eqIfPresent(ExperimentExamBiochemicalTestsDO::getAptt, reqVO.getAptt())
                .betweenIfPresent(ExperimentExamBiochemicalTestsDO::getThrombinTime, reqVO.getThrombinTime())
                .orderByDesc(ExperimentExamBiochemicalTestsDO::getId));
    }

}