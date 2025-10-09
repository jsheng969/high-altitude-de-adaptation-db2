package cn.iocoder.yudao.module.review.service.experimentdiseasespectrum;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentdiseasespectrum.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentdiseasespectrum.ExperimentDiseaseSpectrumDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.experimentdiseasespectrum.ExperimentDiseaseSpectrumMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组-疾病谱 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ExperimentDiseaseSpectrumServiceImpl implements ExperimentDiseaseSpectrumService {

    @Resource
    private ExperimentDiseaseSpectrumMapper experimentDiseaseSpectrumMapper;

    @Override
    public Long createExperimentDiseaseSpectrum(ExperimentDiseaseSpectrumSaveReqVO createReqVO) {
        // 插入
        ExperimentDiseaseSpectrumDO experimentDiseaseSpectrum = BeanUtils.toBean(createReqVO, ExperimentDiseaseSpectrumDO.class);
        experimentDiseaseSpectrumMapper.insert(experimentDiseaseSpectrum);
        // 返回
        return experimentDiseaseSpectrum.getId();
    }

    @Override
    public void updateExperimentDiseaseSpectrum(ExperimentDiseaseSpectrumSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentDiseaseSpectrumExists(updateReqVO.getId());
        // 更新
        ExperimentDiseaseSpectrumDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentDiseaseSpectrumDO.class);
        experimentDiseaseSpectrumMapper.updateById(updateObj);
    }

    @Override
    public void updateExperimentDiseaseSpectrumByPersonId(ExperimentDiseaseSpectrumSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<ExperimentDiseaseSpectrumDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(ExperimentDiseaseSpectrumDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        ExperimentDiseaseSpectrumDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentDiseaseSpectrumDO.class);
        experimentDiseaseSpectrumMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteExperimentDiseaseSpectrum(Long id) {
        // 校验存在
        validateExperimentDiseaseSpectrumExists(id);
        // 删除
        experimentDiseaseSpectrumMapper.deleteById(id);
    }

    private void validateExperimentDiseaseSpectrumExists(Long id) {
        if (experimentDiseaseSpectrumMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_DISEASE_SPECTRUM_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentDiseaseSpectrumDO getExperimentDiseaseSpectrum(Long id) {
        return experimentDiseaseSpectrumMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentDiseaseSpectrumDO> getExperimentDiseaseSpectrumPage(ExperimentDiseaseSpectrumPageReqVO pageReqVO) {
        return experimentDiseaseSpectrumMapper.selectPage(pageReqVO);
    }

}