package cn.iocoder.yudao.module.prospective.dal.mysql.history;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.history.HistoryDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.history.vo.*;

/**
 * 预警历史记录 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface HistoryMapper extends BaseMapperX<HistoryDO> {

    default PageResult<HistoryDO> selectPage(HistoryPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<HistoryDO>()
                .eqIfPresent(HistoryDO::getParm, reqVO.getParm())
                .eqIfPresent(HistoryDO::getSocre, reqVO.getSocre())
                .orderByDesc(HistoryDO::getId));
    }

}