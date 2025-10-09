package cn.iocoder.yudao.module.review.dal.mysql.experimentframingham;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentframingham.ExperimentFraminghamDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.experimentframingham.vo.*;

/**
 * 实验组-framingham评分 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ExperimentFraminghamMapper extends BaseMapperX<ExperimentFraminghamDO> {

    default PageResult<ExperimentFraminghamDO> selectPage(ExperimentFraminghamPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ExperimentFraminghamDO>()
                .eqIfPresent(ExperimentFraminghamDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(ExperimentFraminghamDO::getFraminghamScore, reqVO.getFraminghamScore())
                .eqIfPresent(ExperimentFraminghamDO::getFraminghamRisk, reqVO.getFraminghamRisk())
                .eqIfPresent(ExperimentFraminghamDO::getFraminghamRiskType, reqVO.getFraminghamRiskType())
                .betweenIfPresent(ExperimentFraminghamDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ExperimentFraminghamDO::getId));
    }

}