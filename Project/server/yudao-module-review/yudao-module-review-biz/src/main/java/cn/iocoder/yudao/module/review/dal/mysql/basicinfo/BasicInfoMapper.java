package cn.iocoder.yudao.module.review.dal.mysql.basicinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.basicinfo.BasicInfoDO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.basicinfo.vo.*;
import org.apache.ibatis.annotations.Param;

/**
 * 基础信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface BasicInfoMapper extends BaseMapperX<BasicInfoDO> {

    default PageResult<BasicInfoDO> selectPage(BasicInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BasicInfoDO>()
                .likeIfPresent(BasicInfoDO::getName, reqVO.getName())
                .eqIfPresent(BasicInfoDO::getGender, reqVO.getGender())
                .eqIfPresent(BasicInfoDO::getHighestEducation, reqVO.getHighestEducation())
                .eqIfPresent(BasicInfoDO::getEthnicity, reqVO.getEthnicity())
                .eqIfPresent(BasicInfoDO::getMaritalStatus, reqVO.getMaritalStatus())
                .eqIfPresent(BasicInfoDO::getHeight, reqVO.getHeight())
                .eqIfPresent(BasicInfoDO::getWeight, reqVO.getWeight())
                .orderByDesc(BasicInfoDO::getId));
    }

    Page<BasicInfoRespVO> selectDataByParamPage(Page<?> page, @Param("req") BasicInfoPageReqVO req);

    default List<BasicInfoDO> selectBasicInfoList(BasicInfoPageReqVO reqVO){
        return selectList(new LambdaQueryWrapperX<BasicInfoDO>()
                .eqIfPresent(BasicInfoDO::getName, reqVO.getName())
                .eqIfPresent(BasicInfoDO::getGender, reqVO.getGender())
                .eqIfPresent(BasicInfoDO::getHighestEducation, reqVO.getHighestEducation())
                .eqIfPresent(BasicInfoDO::getEthnicity, reqVO.getEthnicity())
                .eqIfPresent(BasicInfoDO::getMaritalStatus, reqVO.getMaritalStatus())
                .eqIfPresent(BasicInfoDO::getHeight, reqVO.getHeight())
                .eqIfPresent(BasicInfoDO::getWeight, reqVO.getWeight())
                .eqIfPresent(BasicInfoDO::getType, reqVO.getType()));
    }

    BasicInfoAverageVO getAverageByParam(@Param("req") BasicInfoPageReqVO req);
}