package cn.iocoder.yudao.module.prospective.dal.mysql.samplehistory;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.samplehistory.SampleHistoryDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.samplehistory.vo.*;

/**
 * 生物样本库历史记录 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface SampleHistoryMapper extends BaseMapperX<SampleHistoryDO> {

    default PageResult<SampleHistoryDO> selectPage(SampleHistoryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SampleHistoryDO>()
                .eqIfPresent(SampleHistoryDO::getBioSampleId, reqVO.getBioSampleId())
                .eqIfPresent(SampleHistoryDO::getCreateBy, reqVO.getCreateBy())
                .eqIfPresent(SampleHistoryDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(SampleHistoryDO::getAction, reqVO.getAction())
                .orderByDesc(SampleHistoryDO::getId));
    }

}