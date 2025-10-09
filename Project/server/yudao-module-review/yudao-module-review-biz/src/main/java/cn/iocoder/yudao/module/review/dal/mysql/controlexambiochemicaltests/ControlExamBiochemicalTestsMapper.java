package cn.iocoder.yudao.module.review.dal.mysql.controlexambiochemicaltests;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexambiochemicaltests.ControlExamBiochemicalTestsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.controlexambiochemicaltests.vo.*;

/**
 * 对照组体检-生化 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ControlExamBiochemicalTestsMapper extends BaseMapperX<ControlExamBiochemicalTestsDO> {

    default PageResult<ControlExamBiochemicalTestsDO> selectPage(ControlExamBiochemicalTestsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlExamBiochemicalTestsDO>()
                .eqIfPresent(ControlExamBiochemicalTestsDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getUrea, reqVO.getUrea())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getCreatinine, reqVO.getCreatinine())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getAlt, reqVO.getAlt())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getAst, reqVO.getAst())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getTotalCholesterol, reqVO.getTotalCholesterol())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getTriglycerides, reqVO.getTriglycerides())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getHdlC, reqVO.getHdlC())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getLdlC, reqVO.getLdlC())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getUricAcid, reqVO.getUricAcid())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getTotalProtein, reqVO.getTotalProtein())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getAlbumin, reqVO.getAlbumin())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getGlobulin, reqVO.getGlobulin())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getAlbGlobRatio, reqVO.getAlbGlobRatio())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getTotalBilirubin, reqVO.getTotalBilirubin())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getDirectBilirubin, reqVO.getDirectBilirubin())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getIndirectBilirubin, reqVO.getIndirectBilirubin())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getGlycatedHemoglobin, reqVO.getGlycatedHemoglobin())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getPotassium, reqVO.getPotassium())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getSodium, reqVO.getSodium())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getChloride, reqVO.getChloride())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getCalcium, reqVO.getCalcium())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getPhosphorus, reqVO.getPhosphorus())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getMagnesium, reqVO.getMagnesium())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getFastingGlucose, reqVO.getFastingGlucose())
                .betweenIfPresent(ControlExamBiochemicalTestsDO::getProthrombinTime, reqVO.getProthrombinTime())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getProthrombinActivity, reqVO.getProthrombinActivity())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getInr, reqVO.getInr())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getFibrinogen, reqVO.getFibrinogen())
                .eqIfPresent(ControlExamBiochemicalTestsDO::getAptt, reqVO.getAptt())
                .betweenIfPresent(ControlExamBiochemicalTestsDO::getThrombinTime, reqVO.getThrombinTime())
                .orderByDesc(ControlExamBiochemicalTestsDO::getId));
    }

}