package cn.iocoder.yudao.module.review.dal.mysql.controlexampastmedicalhistory;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexampastmedicalhistory.ControlExamPastMedicalHistoryDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.controlexampastmedicalhistory.vo.*;

/**
 * 对照组体检-既往病史 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ControlExamPastMedicalHistoryMapper extends BaseMapperX<ControlExamPastMedicalHistoryDO> {

    default PageResult<ControlExamPastMedicalHistoryDO> selectPage(ControlExamPastMedicalHistoryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlExamPastMedicalHistoryDO>()
                .eqIfPresent(ControlExamPastMedicalHistoryDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlExamPastMedicalHistoryDO::getInternalDiseaseHistory, reqVO.getInternalDiseaseHistory())
                .eqIfPresent(ControlExamPastMedicalHistoryDO::getExternalDiseaseHistory, reqVO.getExternalDiseaseHistory())
                .orderByDesc(ControlExamPastMedicalHistoryDO::getId));
    }

}