package cn.iocoder.yudao.module.review.service.basicotherinfo;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.stereotype.Service;

import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.basicotherinfo.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.basicotherinfo.BasicOtherInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.basicotherinfo.BasicOtherInfoMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 基础其他信息 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class BasicOtherInfoServiceImpl implements BasicOtherInfoService {

    @Resource
    private BasicOtherInfoMapper basicOtherInfoMapper;

    @Override
    public Long createBasicOtherInfo(BasicOtherInfoSaveReqVO createReqVO) {
        // 插入
        BasicOtherInfoDO basicOtherInfo = BeanUtils.toBean(createReqVO, BasicOtherInfoDO.class);
        basicOtherInfoMapper.insert(basicOtherInfo);
        // 返回
        return basicOtherInfo.getId();
    }

    @Override
    public void updateBasicOtherInfo(BasicOtherInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateBasicOtherInfoExists(updateReqVO.getId());
        // 更新
        BasicOtherInfoDO updateObj = BeanUtils.toBean(updateReqVO, BasicOtherInfoDO.class);
        basicOtherInfoMapper.updateById(updateObj);
    }

    @Override
    public void updateBasicOtherInfoByPersonId(BasicOtherInfoSaveReqVO updateReqVO) {
        LambdaUpdateWrapper<BasicOtherInfoDO> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(BasicOtherInfoDO::getPersonId, updateReqVO.getPersonId());
        // 更新
        BasicOtherInfoDO updateObj = BeanUtils.toBean(updateReqVO, BasicOtherInfoDO.class);
        basicOtherInfoMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void updateBasicOtherInfoByWrapper(BasicOtherInfoSaveReqVO updateReqVO, UpdateWrapper<BasicOtherInfoDO> updateWrapper) {
        // 更新
        BasicOtherInfoDO updateObj = BeanUtils.toBean(updateReqVO, BasicOtherInfoDO.class);
        basicOtherInfoMapper.update(updateObj,updateWrapper);
    }

    @Override
    public void deleteBasicOtherInfo(Long id) {
        // 校验存在
        validateBasicOtherInfoExists(id);
        // 删除
        basicOtherInfoMapper.deleteById(id);
    }

    private void validateBasicOtherInfoExists(Long id) {
        if (basicOtherInfoMapper.selectById(id) == null) {
            throw exception(BASIC_OTHER_INFO_NOT_EXISTS);
        }
    }

    @Override
    public BasicOtherInfoDO getBasicOtherInfo(Long id) {
        return basicOtherInfoMapper.selectById(id);
    }

    @Override
    public PageResult<BasicOtherInfoDO> getBasicOtherInfoPage(BasicOtherInfoPageReqVO pageReqVO) {
        return basicOtherInfoMapper.selectPage(pageReqVO);
    }

}