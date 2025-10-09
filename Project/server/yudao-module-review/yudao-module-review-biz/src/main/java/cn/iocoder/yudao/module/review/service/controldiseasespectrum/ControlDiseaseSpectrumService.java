package cn.iocoder.yudao.module.review.service.controldiseasespectrum;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.review.controller.admin.controldiseasespectrum.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controldiseasespectrum.ControlDiseaseSpectrumDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 实验组-疾病谱 Service 接口
 *
 * @author 管理员
 */
public interface ControlDiseaseSpectrumService {

    /**
     * 创建实验组-疾病谱
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlDiseaseSpectrum(@Valid ControlDiseaseSpectrumSaveReqVO createReqVO);

    /**
     * 更新实验组-疾病谱
     *
     * @param updateReqVO 更新信息
     */
    void updateControlDiseaseSpectrum(@Valid ControlDiseaseSpectrumSaveReqVO updateReqVO);

    /**
     * 删除实验组-疾病谱
     *
     * @param id 编号
     */
    void deleteControlDiseaseSpectrum(Long id);

    /**
     * 获得实验组-疾病谱
     *
     * @param id 编号
     * @return 实验组-疾病谱
     */
    ControlDiseaseSpectrumDO getControlDiseaseSpectrum(Long id);

    /**
     * 获得实验组-疾病谱分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组-疾病谱分页
     */
    PageResult<ControlDiseaseSpectrumDO> getControlDiseaseSpectrumPage(ControlDiseaseSpectrumPageReqVO pageReqVO);

}