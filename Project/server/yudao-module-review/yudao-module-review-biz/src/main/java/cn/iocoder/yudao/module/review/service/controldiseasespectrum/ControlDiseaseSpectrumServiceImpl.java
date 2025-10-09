package cn.iocoder.yudao.module.review.service.controldiseasespectrum;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.controldiseasespectrum.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controldiseasespectrum.ControlDiseaseSpectrumDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.controldiseasespectrum.ControlDiseaseSpectrumMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组-疾病谱 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ControlDiseaseSpectrumServiceImpl implements ControlDiseaseSpectrumService {

    @Resource
    private ControlDiseaseSpectrumMapper controlDiseaseSpectrumMapper;

    @Override
    public Long createControlDiseaseSpectrum(ControlDiseaseSpectrumSaveReqVO createReqVO) {
        // 插入
        ControlDiseaseSpectrumDO controlDiseaseSpectrum = BeanUtils.toBean(createReqVO, ControlDiseaseSpectrumDO.class);
        controlDiseaseSpectrumMapper.insert(controlDiseaseSpectrum);
        // 返回
        return controlDiseaseSpectrum.getId();
    }

    @Override
    public void updateControlDiseaseSpectrum(ControlDiseaseSpectrumSaveReqVO updateReqVO) {
        // 校验存在
        validateControlDiseaseSpectrumExists(updateReqVO.getId());
        // 更新
        ControlDiseaseSpectrumDO updateObj = BeanUtils.toBean(updateReqVO, ControlDiseaseSpectrumDO.class);
        controlDiseaseSpectrumMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlDiseaseSpectrum(Long id) {
        // 校验存在
        validateControlDiseaseSpectrumExists(id);
        // 删除
        controlDiseaseSpectrumMapper.deleteById(id);
    }

    private void validateControlDiseaseSpectrumExists(Long id) {
        if (controlDiseaseSpectrumMapper.selectById(id) == null) {
            throw exception(CONTROL_DISEASE_SPECTRUM_NOT_EXISTS);
        }
    }

    @Override
    public ControlDiseaseSpectrumDO getControlDiseaseSpectrum(Long id) {
        return controlDiseaseSpectrumMapper.selectById(id);
    }

    @Override
    public PageResult<ControlDiseaseSpectrumDO> getControlDiseaseSpectrumPage(ControlDiseaseSpectrumPageReqVO pageReqVO) {
        return controlDiseaseSpectrumMapper.selectPage(pageReqVO);
    }

}