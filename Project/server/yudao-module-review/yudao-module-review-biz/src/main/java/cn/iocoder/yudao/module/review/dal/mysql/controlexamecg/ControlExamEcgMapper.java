package cn.iocoder.yudao.module.review.dal.mysql.controlexamecg;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.controlexamecg.ControlExamEcgDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.controlexamecg.vo.*;

/**
 * 对照组体检-心电图 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface ControlExamEcgMapper extends BaseMapperX<ControlExamEcgDO> {

    default PageResult<ControlExamEcgDO> selectPage(ControlExamEcgPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlExamEcgDO>()
                .eqIfPresent(ControlExamEcgDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlExamEcgDO::getEcgDescription, reqVO.getEcgDescription())
                .orderByDesc(ControlExamEcgDO::getId));
    }

}