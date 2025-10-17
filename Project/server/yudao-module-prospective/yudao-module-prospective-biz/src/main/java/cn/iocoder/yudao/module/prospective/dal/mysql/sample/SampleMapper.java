package cn.iocoder.yudao.module.prospective.dal.mysql.sample;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.sample.SampleDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.sample.vo.*;
import org.apache.ibatis.annotations.Param;

/**
 * 生物样本 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface SampleMapper extends BaseMapperX<SampleDO> {

    default PageResult<SampleDO> selectPage(SamplePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SampleDO>()
                .eqIfPresent(SampleDO::getCreateTime, reqVO.getCreateTime())
                .eqIfPresent(SampleDO::getLayer, reqVO.getLayer())
                .eqIfPresent(SampleDO::getColumnNum, reqVO.getColumnNum())
                .eqIfPresent(SampleDO::getFreezerNo, reqVO.getFreezerNo())
                .eqIfPresent(SampleDO::getDrawerNo, reqVO.getDrawerNo())
                .eqIfPresent(SampleDO::getBoxNo, reqVO.getBoxNo())
                .eqIfPresent(SampleDO::getTubeSeq, reqVO.getTubeSeq())
                .eqIfPresent(SampleDO::getPositionCode, reqVO.getPositionCode())
                .eqIfPresent(SampleDO::getTubeNo, reqVO.getTubeNo())
                .eqIfPresent(SampleDO::getSampleType, reqVO.getSampleType())
                .eqIfPresent(SampleDO::getOperatorId, reqVO.getOperatorId())
                .eqIfPresent(SampleDO::getStatus, reqVO.getStatus())
                .eqIfPresent(SampleDO::getStorageTime, reqVO.getStorageTime())
                .eqIfPresent(SampleDO::getOutTime, reqVO.getOutTime())
                .likeIfPresent(SampleDO::getSampleName, reqVO.getSampleName())
                .eqIfPresent(SampleDO::getSampleSource, reqVO.getSampleSource())
                .eqIfPresent(SampleDO::getSampleVolume, reqVO.getSampleVolume())
                .eqIfPresent(SampleDO::getSampleConcentration, reqVO.getSampleConcentration())
                .eqIfPresent(SampleDO::getExpirationDate, reqVO.getExpirationDate())
                .eqIfPresent(SampleDO::getNotes, reqVO.getNotes())
                .orderByDesc(SampleDO::getId));
    }

    void batchInsert(List<SamplePageReqVO> dataList);

    public List<BoxDisplayVO> selectBoxesWithGroupedSampleTypes(SampleRespVO sampleRespVO);

    List<SampleRespVO> selectDataByBoxNo(SampleRespVO sampleRespVO);

    List<SampleTypeCountVO> selectSampleTypeCount();

    // 根据唯一条件查询样本
    SampleDO selectByUniqueCondition(@Param("freezerNo") String freezerNo,
                                     @Param("layer") String layer,
                                     @Param("columnNum") String columnNum,
                                     @Param("drawerNo") String drawerNo,
                                     @Param("boxSeq") String boxSeq,
                                     @Param("tubeSeq") Integer tubeSeq);
}