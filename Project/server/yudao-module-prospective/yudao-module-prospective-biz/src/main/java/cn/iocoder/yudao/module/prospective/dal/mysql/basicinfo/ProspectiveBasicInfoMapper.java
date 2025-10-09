package cn.iocoder.yudao.module.prospective.dal.mysql.basicinfo;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.prospective.dal.dataobject.basicinfo.ProspectiveBasicInfoDO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.prospective.controller.admin.basicinfo.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 基础信息 Mapper
 *
 * @author 管理员
 */
@Mapper
public interface ProspectiveBasicInfoMapper extends BaseMapperX<ProspectiveBasicInfoDO> {

    default PageResult<ProspectiveBasicInfoDO> selectPage(BasicInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ProspectiveBasicInfoDO>()
                .eqIfPresent(ProspectiveBasicInfoDO::getGender, reqVO.getGender())
                .eqIfPresent(ProspectiveBasicInfoDO::getBirthDate, reqVO.getBirthDate())
                .eqIfPresent(ProspectiveBasicInfoDO::getPosition, reqVO.getPosition())
                .eqIfPresent(ProspectiveBasicInfoDO::getIdNumber, reqVO.getIdNumber())
                .eqIfPresent(ProspectiveBasicInfoDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ProspectiveBasicInfoDO::getId));
    }

    default List<ProspectiveBasicInfoDO> selectBasicInfoList(BasicInfoPageReqVO reqVO){
        return selectList(new LambdaQueryWrapperX<ProspectiveBasicInfoDO>()
                .eqIfPresent(ProspectiveBasicInfoDO::getName, reqVO.getName())
                .eqIfPresent(ProspectiveBasicInfoDO::getGender, reqVO.getGender())
                .eqIfPresent(ProspectiveBasicInfoDO::getCode, reqVO.getCode())
                .orderByDesc(ProspectiveBasicInfoDO::getId));
    }
    Page<BasicInfoRespVO> selectDataByParamPage(Page<?> page, @Param("req") BasicInfoPageReqVO req);

    BasicInfoAverageVO getAverageByParam(@Param("req") BasicInfoPageReqVO req);

    Integer getVipNumber1();

    Integer getVipNumber2();

    Integer getVipNumber3();

    BasicInfoAverageVO getQueue1();

    BasicInfoAverageVO getQueue2();

    BasicInfoAverageVO getQueue3();

    BasicInfoAverageVO getTimePoint(@Param("req") BasicInfoPageReqVO req);

    List<Map<String, Object>> getQueue1EthnicityCount();

    List<Map<String, Object>> getQueue2EthnicityCount();

    BasicInfoAverageVO getMissionPointAltitudeCount();

    BasicInfoAverageVO getClinicalSymptomsData(@Param("req") BasicInfoPageReqVO req);

    BasicInfoAverageVO getExamData(@Param("req") BasicInfoPageReqVO req);
}