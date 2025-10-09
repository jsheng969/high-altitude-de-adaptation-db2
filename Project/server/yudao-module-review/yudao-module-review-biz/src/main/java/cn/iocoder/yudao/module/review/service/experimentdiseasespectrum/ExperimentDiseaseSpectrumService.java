package cn.iocoder.yudao.module.review.service.experimentdiseasespectrum;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.review.controller.admin.experimentdiseasespectrum.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.experimentdiseasespectrum.ExperimentDiseaseSpectrumDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 实验组-疾病谱 Service 接口
 *
 * @author 管理员
 */
public interface ExperimentDiseaseSpectrumService {

    /**
     * 创建实验组-疾病谱
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createExperimentDiseaseSpectrum(@Valid ExperimentDiseaseSpectrumSaveReqVO createReqVO);

    /**
     * 更新实验组-疾病谱
     *
     * @param updateReqVO 更新信息
     */
    void updateExperimentDiseaseSpectrum(@Valid ExperimentDiseaseSpectrumSaveReqVO updateReqVO);

    void updateExperimentDiseaseSpectrumByPersonId(@Valid ExperimentDiseaseSpectrumSaveReqVO updateReqVO);

    /**
     * 删除实验组-疾病谱
     *
     * @param id 编号
     */
    void deleteExperimentDiseaseSpectrum(Long id);

    /**
     * 获得实验组-疾病谱
     *
     * @param id 编号
     * @return 实验组-疾病谱
     */
    ExperimentDiseaseSpectrumDO getExperimentDiseaseSpectrum(Long id);

    /**
     * 获得实验组-疾病谱分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组-疾病谱分页
     */
    PageResult<ExperimentDiseaseSpectrumDO> getExperimentDiseaseSpectrumPage(ExperimentDiseaseSpectrumPageReqVO pageReqVO);

}