package cn.iocoder.yudao.module.review.dal.mysql.controlexamabdominalultrasound;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexamabdominalultrasound.ControlExamAbdominalUltrasoundDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.controlexamabdominalultrasound.vo.*;

/**
 * 对照组体检-腹部超声 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ControlExamAbdominalUltrasoundMapper extends BaseMapperX<ControlExamAbdominalUltrasoundDO> {

    default PageResult<ControlExamAbdominalUltrasoundDO> selectPage(ControlExamAbdominalUltrasoundPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlExamAbdominalUltrasoundDO>()
                .eqIfPresent(ControlExamAbdominalUltrasoundDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlExamAbdominalUltrasoundDO::getUltrasoundDescription, reqVO.getUltrasoundDescription())
                .eqIfPresent(ControlExamAbdominalUltrasoundDO::getUltrasoundSummary, reqVO.getUltrasoundSummary())
                .orderByDesc(ControlExamAbdominalUltrasoundDO::getId));
    }

}