package cn.iocoder.yudao.module.review.service.basicinfo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.basicinfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.basicinfo.BasicInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.basicinfo.BasicInfoMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 基础信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class BasicInfoServiceImpl implements BasicInfoService {

    @Resource
    private BasicInfoMapper basicInfoMapper;

    @Override
    public Long createBasicInfo(BasicInfoSaveReqVO createReqVO) {
        // 插入
        BasicInfoDO basicInfo = BeanUtils.toBean(createReqVO, BasicInfoDO.class);
        basicInfoMapper.insert(basicInfo);
        // 返回
        return basicInfo.getId();
    }

    @Override
    public void updateBasicInfo(BasicInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateBasicInfoExists(updateReqVO.getId());
        // 更新
        BasicInfoDO updateObj = BeanUtils.toBean(updateReqVO, BasicInfoDO.class);
        basicInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteBasicInfo(Long id) {
        // 校验存在
        validateBasicInfoExists(id);
        // 删除
        basicInfoMapper.deleteById(id);
    }

    private void validateBasicInfoExists(Long id) {
        if (basicInfoMapper.selectById(id) == null) {
            throw exception(BASIC_INFO_NOT_EXISTS);
        }
    }

    @Override
    public BasicInfoDO getBasicInfo(Long id) {
        return basicInfoMapper.selectById(id);
    }

    @Override
    public PageResult<BasicInfoDO> getBasicInfoPage(BasicInfoPageReqVO pageReqVO) {
        return basicInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public PageResult<BasicInfoDO> getDataByParamPage(BasicInfoPageReqVO pageReqVO) {
        Page<BasicInfoDO> page = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        Page<BasicInfoRespVO> basicInfoRespVOList = basicInfoMapper.selectDataByParamPage(page,pageReqVO);
        return new PageResult(basicInfoRespVOList.getRecords(),basicInfoRespVOList.getTotal());
    }

    @Override
    public BasicInfoAverageVO getAverageByParam(BasicInfoPageReqVO pageReqVO) {
        BasicInfoAverageVO basicInfoRespVOList = basicInfoMapper.getAverageByParam(pageReqVO);
        return basicInfoRespVOList;
    }

    @Override
    public List<BasicInfoDO> selectBasicInfoList(BasicInfoPageReqVO reqVO){
        return basicInfoMapper.selectBasicInfoList(reqVO);
    }
}