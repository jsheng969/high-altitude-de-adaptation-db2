package cn.iocoder.yudao.module.review.dal.mysql.experimentexampastmedicalhistory;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexampastmedicalhistory.ExperimentExamPastMedicalHistoryDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentexampastmedicalhistory.vo.*;

/**
 * 实验组体检-既往病史 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentExamPastMedicalHistoryMapper extends BaseMapperX<ExperimentExamPastMedicalHistoryDO> {

    default PageResult<ExperimentExamPastMedicalHistoryDO> selectPage(ExperimentExamPastMedicalHistoryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentExamPastMedicalHistoryDO>()
                .eqIfPresent(ExperimentExamPastMedicalHistoryDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentExamPastMedicalHistoryDO::getInternalDiseaseHistory, reqVO.getInternalDiseaseHistory())
                .eqIfPresent(ExperimentExamPastMedicalHistoryDO::getExternalDiseaseHistory, reqVO.getExternalDiseaseHistory())
                .orderByDesc(ExperimentExamPastMedicalHistoryDO::getId));
    }

}