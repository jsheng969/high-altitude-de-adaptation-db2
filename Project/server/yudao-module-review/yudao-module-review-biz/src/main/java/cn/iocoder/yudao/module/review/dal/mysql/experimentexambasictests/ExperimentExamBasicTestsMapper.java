package cn.iocoder.yudao.module.review.dal.mysql.experimentexambasictests;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexambasictests.ExperimentExamBasicTestsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentexambasictests.vo.*;

/**
 * 实验组体检-基本检测信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentExamBasicTestsMapper extends BaseMapperX<ExperimentExamBasicTestsDO> {

    default PageResult<ExperimentExamBasicTestsDO> selectPage(ExperimentExamBasicTestsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentExamBasicTestsDO>()
                .eqIfPresent(ExperimentExamBasicTestsDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentExamBasicTestsDO::getSystolicPressure, reqVO.getSystolicPressure())
                .eqIfPresent(ExperimentExamBasicTestsDO::getDiastolicPressure, reqVO.getDiastolicPressure())
                .eqIfPresent(ExperimentExamBasicTestsDO::getPulse, reqVO.getPulse())
                .eqIfPresent(ExperimentExamBasicTestsDO::getHeight, reqVO.getHeight())
                .eqIfPresent(ExperimentExamBasicTestsDO::getWeight, reqVO.getWeight())
                .eqIfPresent(ExperimentExamBasicTestsDO::getBmi, reqVO.getBmi())
                .orderByDesc(ExperimentExamBasicTestsDO::getId));
    }

}