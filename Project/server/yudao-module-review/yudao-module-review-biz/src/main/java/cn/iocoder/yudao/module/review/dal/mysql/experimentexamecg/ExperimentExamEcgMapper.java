package cn.iocoder.yudao.module.review.dal.mysql.experimentexamecg;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentexamecg.ExperimentExamEcgDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentexamecg.vo.*;

/**
 * 实验组体检-心电图 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ExperimentExamEcgMapper extends BaseMapperX<ExperimentExamEcgDO> {

    default PageResult<ExperimentExamEcgDO> selectPage(ExperimentExamEcgPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentExamEcgDO>()
                .eqIfPresent(ExperimentExamEcgDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentExamEcgDO::getEcgDescription, reqVO.getEcgDescription())
                .orderByDesc(ExperimentExamEcgDO::getId));
    }

}