package cn.iocoder.yudao.module.prospective.service.experimentexamotherdata;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.prospective.controller.admin.experimentexamotherdata.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexamotherdata.ExperimentExamOtherDataDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.experimentexamotherdata.ExperimentExamOtherDataMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;


/**
 * 实验组体检-其他数据 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ExperimentExamOtherDataServiceImpl implements ExperimentExamOtherDataService {

    @Resource
    private ExperimentExamOtherDataMapper experimentExamOtherDataMapper;

    @Override
    public Long createExperimentExamOtherData(ExperimentExamOtherDataSaveReqVO createReqVO) {
        // 插入
        ExperimentExamOtherDataDO experimentExamOtherData = BeanUtils.toBean(createReqVO, ExperimentExamOtherDataDO.class);
        experimentExamOtherDataMapper.insert(experimentExamOtherData);
        // 返回
        return experimentExamOtherData.getId();
    }

    @Override
    public void updateExperimentExamOtherData(ExperimentExamOtherDataSaveReqVO updateReqVO) {
        // 校验存在
        validateExperimentExamOtherDataExists(updateReqVO.getId());
        // 更新
        ExperimentExamOtherDataDO updateObj = BeanUtils.toBean(updateReqVO, ExperimentExamOtherDataDO.class);
        experimentExamOtherDataMapper.updateById(updateObj);
    }

    @Override
    public void deleteExperimentExamOtherData(Long id) {
        // 校验存在
        validateExperimentExamOtherDataExists(id);
        // 删除
        experimentExamOtherDataMapper.deleteById(id);
    }

    private void validateExperimentExamOtherDataExists(Long id) {
        if (experimentExamOtherDataMapper.selectById(id) == null) {
            throw exception(EXPERIMENT_EXAM_OTHER_DATA_NOT_EXISTS);
        }
    }

    @Override
    public ExperimentExamOtherDataDO getExperimentExamOtherData(Long id) {
        return experimentExamOtherDataMapper.selectById(id);
    }

    @Override
    public PageResult<ExperimentExamOtherDataDO> getExperimentExamOtherDataPage(ExperimentExamOtherDataPageReqVO pageReqVO) {
        return experimentExamOtherDataMapper.selectPage(pageReqVO);
    }

}