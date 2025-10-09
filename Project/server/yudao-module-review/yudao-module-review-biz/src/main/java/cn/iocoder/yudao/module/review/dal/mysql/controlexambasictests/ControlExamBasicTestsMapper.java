package cn.iocoder.yudao.module.review.dal.mysql.controlexambasictests;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexambasictests.ControlExamBasicTestsDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.controlexambasictests.vo.*;

/**
 * 对照组体检-基本检测信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ControlExamBasicTestsMapper extends BaseMapperX<ControlExamBasicTestsDO> {

    default PageResult<ControlExamBasicTestsDO> selectPage(ControlExamBasicTestsPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlExamBasicTestsDO>()
                .eqIfPresent(ControlExamBasicTestsDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlExamBasicTestsDO::getSystolicPressure, reqVO.getSystolicPressure())
                .eqIfPresent(ControlExamBasicTestsDO::getDiastolicPressure, reqVO.getDiastolicPressure())
                .eqIfPresent(ControlExamBasicTestsDO::getPulse, reqVO.getPulse())
                .eqIfPresent(ControlExamBasicTestsDO::getHeight, reqVO.getHeight())
                .eqIfPresent(ControlExamBasicTestsDO::getWeight, reqVO.getWeight())
                .eqIfPresent(ControlExamBasicTestsDO::getBmi, reqVO.getBmi())
                .orderByDesc(ControlExamBasicTestsDO::getId));
    }

}