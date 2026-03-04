package cn.iocoder.yudao.module.prospective.service.sample;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.sample.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.sample.SampleDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 生物样本 Service 接口
 *
 * @author 管理员
 */
public interface SampleService {

    /**
     * 创建生物样本
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSample(@Valid SampleSaveReqVO createReqVO);

    // 新增：根据条件查询样本
    SampleDO getSampleByUniqueCondition(String freezerNo, String layer, String columnNum,
                                        String drawerNo, String boxSeq, Integer tubeSeq);

    // 新增：创建或更新样本
    void createOrUpdateSample(SampleSaveReqVO reqVO);

    /**
     * 更新生物样本
     *
     * @param updateReqVO 更新信息
     */
    void updateSample(@Valid SampleSaveReqVO updateReqVO);

    /**
     * 删除生物样本
     *
     * @param id 编号
     */
    void deleteSample(Long id);

    /**
     * 获得生物样本
     *
     * @param id 编号
     * @return 生物样本
     */
    SampleDO getSample(Long id);

    /**
     * 获得生物样本分页
     *
     * @param pageReqVO 分页查询
     * @return 生物样本分页
     */
    PageResult<SampleDO> getSamplePage(SamplePageReqVO pageReqVO);

    void batchInsert(List<SamplePageReqVO> dataList);

    List<BoxDisplayVO> getBoxesWithSampleTypes(SampleRespVO sampleRespVO);

    List<SampleRespVO> getDataByBoxNo(SampleRespVO sampleRespVO);

    List<SampleTypeCountVO> getSampleTypeCount();

    List<SampleTypeCountVO> getSampleTypeCount2();

    void takeOut(Long id);

    void putBack(SamplePageReqVO pageReqVO);

    public void takeOutByTubeNo(String tubeNo);

    public void encryptAllAnnotatedFields() throws IllegalAccessException;
}