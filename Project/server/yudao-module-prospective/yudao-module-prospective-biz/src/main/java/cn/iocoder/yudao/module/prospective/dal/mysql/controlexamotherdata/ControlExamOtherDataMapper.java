package cn.iocoder.yudao.module.prospective.dal.mysql.controlexamotherdata;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.controlexamotherdata.ControlExamOtherDataDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.controlexamotherdata.vo.*;

/**
 * 实验组体检-其他数据 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ControlExamOtherDataMapper extends BaseMapperX<ControlExamOtherDataDO> {

    default PageResult<ControlExamOtherDataDO> selectPage(ControlExamOtherDataPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlExamOtherDataDO>()
                .eqIfPresent(ControlExamOtherDataDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlExamOtherDataDO::getCardiacTroponinI, reqVO.getCardiacTroponinI())
                .eqIfPresent(ControlExamOtherDataDO::getVascularUltrasoundResult, reqVO.getVascularUltrasoundResult())
                .eqIfPresent(ControlExamOtherDataDO::getEcgAnalysisResult, reqVO.getEcgAnalysisResult())
                .betweenIfPresent(ControlExamOtherDataDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(ControlExamOtherDataDO::getTimePoint, reqVO.getTimePoint())
                .eqIfPresent(ControlExamOtherDataDO::getAtniH, reqVO.getAtniH())
                .eqIfPresent(ControlExamOtherDataDO::getMyog, reqVO.getMyog())
                .eqIfPresent(ControlExamOtherDataDO::getCkMbg, reqVO.getCkMbg())
                .orderByDesc(ControlExamOtherDataDO::getId));
    }

}