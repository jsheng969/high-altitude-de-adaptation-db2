package cn.iocoder.yudao.module.review.dal.mysql.basicotherinfo;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.review.dal.dataobject.basicotherinfo.BasicOtherInfoDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.review.controller.admin.basicotherinfo.vo.*;

/**
 * 基础其他信息 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface BasicOtherInfoMapper extends BaseMapperX<BasicOtherInfoDO> {

    default PageResult<BasicOtherInfoDO> selectPage(BasicOtherInfoPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<BasicOtherInfoDO>()
                .eqIfPresent(BasicOtherInfoDO::getPersonId, reqVO.getPersonId())
                .eqIfPresent(BasicOtherInfoDO::getFertilityStatus, reqVO.getFertilityStatus())
                .eqIfPresent(BasicOtherInfoDO::getAge, reqVO.getAge())
                .eqIfPresent(BasicOtherInfoDO::getRetiredWeight, reqVO.getRetiredWeight())
                .orderByDesc(BasicOtherInfoDO::getId));
    }

}