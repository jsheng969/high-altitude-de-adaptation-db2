package cn.iocoder.yudao.module.review.dal.mysql.experimentexamabdominalultrasound;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexamabdominalultrasound.ExperimentExamAbdominalUltrasoundDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentexamabdominalultrasound.vo.*;

/**
 * 实验组体检-腹部超声 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentExamAbdominalUltrasoundMapper extends BaseMapperX<ExperimentExamAbdominalUltrasoundDO> {

    default PageResult<ExperimentExamAbdominalUltrasoundDO> selectPage(ExperimentExamAbdominalUltrasoundPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentExamAbdominalUltrasoundDO>()
                .eqIfPresent(ExperimentExamAbdominalUltrasoundDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentExamAbdominalUltrasoundDO::getUltrasoundDescription, reqVO.getUltrasoundDescription())
                .eqIfPresent(ExperimentExamAbdominalUltrasoundDO::getUltrasoundSummary, reqVO.getUltrasoundSummary())
                .orderByDesc(ExperimentExamAbdominalUltrasoundDO::getId));
    }

}