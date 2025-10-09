package cn.iocoder.yudao.module.review.service.experimentframingham;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentframingham.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentframingham.ExperimentFraminghamDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentframingham.ExperimentFraminghamMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组-framingham评分 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ExperimentFraminghamServiceImpl implements ExperimentFraminghamService {

    @Resource
    private ExperimentFraminghamMapper experimentFraminghamMapper;

    @Override
    public Long createExperimentFramingham(ExperimentFraminghamSaveReqVO createReqVO) {
        // 插入
        ExperimentFraminghamDO experimentFramingham = BeanUtils.toBean(createReqVO, ExperimentFraminghamDO.class);
        experimentFraminghamMapper.insert(experimentFramingham);
        // 返回
        return experimentFramingham.getId();
    }

    @Override
    public void updateExperimentFramingham(ExperimentFraminghamSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentFraminghamExists(updateReqVO.getId());
        // 更新
        ExperimentFraminghamDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentFraminghamDO.class);
        experimentFraminghamMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentFraminghamByPersonId(ExperimentFraminghamSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ExperimentFraminghamDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ExperimentFraminghamDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ExperimentFraminghamDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentFraminghamDO.class);
        experimentFraminghamMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentFramingham(Long id) {
        // 校验存在
        validateExperimentFraminghamExists(id);
        // 删除
        experimentFraminghamMapper.deleteById(id);
    }

    private void validateExperimentFraminghamExists(Long id) {
        if (experimentFraminghamMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_FRAMINGHAM_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentFraminghamDO getExperimentFramingham(Long id) {
        return experimentFraminghamMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentFraminghamDO> getExperimentFraminghamPage(ExperimentFraminghamPageReqVO pageReqVO) {
        return experimentFraminghamMapper.selectPage(pageReqVO);
    }

}