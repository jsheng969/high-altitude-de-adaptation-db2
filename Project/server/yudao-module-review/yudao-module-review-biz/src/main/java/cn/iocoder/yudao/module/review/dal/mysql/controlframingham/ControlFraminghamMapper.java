package cn.iocoder.yudao.module.review.dal.mysql.controlframingham;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.controlframingham.ControlFraminghamDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.controlframingham.vo.*;

/**
 * 实验组-framingham评分 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ControlFraminghamMapper extends BaseMapperX<ControlFraminghamDO> {

    default PageResult<ControlFraminghamDO> selectPage(ControlFraminghamPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ControlFraminghamDO>()
                .eqIfPresent(ControlFraminghamDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ControlFraminghamDO::getFraminghamScore, reqVO.getFraminghamScore())
                .eqIfPresent(ControlFraminghamDO::getFraminghamRisk, reqVO.getFraminghamRisk())
                .eqIfPresent(ControlFraminghamDO::getFraminghamRiskType, reqVO.getFraminghamRiskType())
                .betweenIfPresent(ControlFraminghamDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ControlFraminghamDO::getId));
    }

}