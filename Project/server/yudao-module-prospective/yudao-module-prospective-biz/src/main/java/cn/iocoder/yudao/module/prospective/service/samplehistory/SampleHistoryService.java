package cn.iocoder.yudao.module.prospective.service.samplehistory;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.samplehistory.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.samplehistory.SampleHistoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 生物样本库历史记录 Service 接口
 *
 * @author 管理员
 */
public interface SampleHistoryService {

    /**
     * 创建生物样本库历史记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSampleHistory(@Valid SampleHistorySaveReqVO createReqVO);

    /**
     * 更新生物样本库历史记录
     *
     * @param updateReqVO 更新信息
     */
    void updateSampleHistory(@Valid SampleHistorySaveReqVO updateReqVO);

    /**
     * 删除生物样本库历史记录
     *
     * @param id 编号
     */
    void deleteSampleHistory(Long id);

    /**
     * 获得生物样本库历史记录
     *
     * @param id 编号
     * @return 生物样本库历史记录
     */
    SampleHistoryDO getSampleHistory(Integer id);

    /**
     * 获得生物样本库历史记录分页
     *
     * @param pageReqVO 分页查询
     * @return 生物样本库历史记录分页
     */
    PageResult<SampleHistoryDO> getSampleHistoryPage(SampleHistoryPageReqVO pageReqVO);

    List<SampleHistoryDO> getSampleHistoryBySampleId(Long id);
}