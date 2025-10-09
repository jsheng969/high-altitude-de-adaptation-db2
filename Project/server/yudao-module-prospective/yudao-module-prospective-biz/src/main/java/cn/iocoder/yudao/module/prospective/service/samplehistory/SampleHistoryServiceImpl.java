package cn.iocoder.yudao.module.prospective.service.samplehistory;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.prospective.controller.admin.samplehistory.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.samplehistory.SampleHistoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.samplehistory.SampleHistoryMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 生物样本库历史记录 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class SampleHistoryServiceImpl implements SampleHistoryService {

    @Resource
    private SampleHistoryMapper sampleHistoryMapper;

    @Override
    public Long createSampleHistory(SampleHistorySaveReqVO createReqVO) {
        // 插入
        SampleHistoryDO sampleHistory = BeanUtils.toBean(createReqVO, SampleHistoryDO.class);
        sampleHistoryMapper.insert(sampleHistory);
        // 返回
        return sampleHistory.getId();
    }

    @Override
    public void updateSampleHistory(SampleHistorySaveReqVO updateReqVO) {
        // 校验存在
        validateSampleHistoryExists(updateReqVO.getId());
        // 更新
        SampleHistoryDO updateObj = BeanUtils.toBean(updateReqVO, SampleHistoryDO.class);
        sampleHistoryMapper.updateById(updateObj);
    }

    @Override
    public void deleteSampleHistory(Long id) {
        // 校验存在
        validateSampleHistoryExists(id);
        // 删除
        sampleHistoryMapper.deleteById(id);
    }

    private void validateSampleHistoryExists(Long id) {
        if (sampleHistoryMapper.selectById(id) == null) {
            throw exception(SAMPLE_HISTORY_NOT_EXISTS);
        }
    }

    @Override
    public SampleHistoryDO getSampleHistory(Integer id) {
        return sampleHistoryMapper.selectById(id);
    }

    @Override
    public PageResult<SampleHistoryDO> getSampleHistoryPage(SampleHistoryPageReqVO pageReqVO) {
        return sampleHistoryMapper.selectPage(pageReqVO);
    }

    @Override
    public List<SampleHistoryDO> getSampleHistoryBySampleId(Long id) {
        QueryWrapper<SampleHistoryDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("bio_sample_id", id);
        return sampleHistoryMapper.selectList(queryWrapper);
    }

}