package cn.iocoder.yudao.module.prospective.dal.mysql.experimentexamotherdata;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexamotherdata.ExperimentExamOtherDataDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexamotherdata.vo.*;

/**
 * 实验组体检-其他数据 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ExperimentExamOtherDataMapper extends BaseMapperX<ExperimentExamOtherDataDO> {

    default PageResult<ExperimentExamOtherDataDO> selectPage(ExperimentExamOtherDataPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentExamOtherDataDO>()
                .eqIfPresent(ExperimentExamOtherDataDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentExamOtherDataDO::getCardiacTroponinI, reqVO.getCardiacTroponinI())
                .eqIfPresent(ExperimentExamOtherDataDO::getVascularUltrasoundResult, reqVO.getVascularUltrasoundResult())
                .eqIfPresent(ExperimentExamOtherDataDO::getEcgAnalysisResult, reqVO.getEcgAnalysisResult())
                .betweenIfPresent(ExperimentExamOtherDataDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ExperimentExamOtherDataDO::getTimePoint, reqVO.getTimePoint())
                .orderByDesc(ExperimentExamOtherDataDO::getId));
    }

}