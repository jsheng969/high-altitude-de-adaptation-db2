package cn.iocoder.yudao.module.review.service.controlframingham;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.review.controller.admin.controlframingham.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlframingham.ControlFraminghamDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.review.dal.mysql.controlframingham.ControlFraminghamMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.review.enums.ErrorCodeConstants.*;

/**
 * 实验组-framingham评分 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ControlFraminghamServiceImpl implements ControlFraminghamService {

    @Resource
    private ControlFraminghamMapper controlFraminghamMapper;

    @Override
    public Long createControlFramingham(ControlFraminghamSaveReqVO createReqVO) {
        // 插入
        ControlFraminghamDO controlFramingham = BeanUtils.toBean(createReqVO, ControlFraminghamDO.class);
        controlFraminghamMapper.insert(controlFramingham);
        // 返回
        return controlFramingham.getId();
    }

    @Override
    public void updateControlFramingham(ControlFraminghamSaveReqVO updateReqVO) {
        // 校验存在
        validateControlFraminghamExists(updateReqVO.getId());
        // 更新
        ControlFraminghamDO updateObj = BeanUtils.toBean(updateReqVO, ControlFraminghamDO.class);
        controlFraminghamMapper.updateById(updateObj);
    }

    @Override
    public void deleteControlFramingham(Long id) {
        // 校验存在
        validateControlFraminghamExists(id);
        // 删除
        controlFraminghamMapper.deleteById(id);
    }

    private void validateControlFraminghamExists(Long id) {
        if (controlFraminghamMapper.selectById(id) == null) {
            throw exception(CONTROL_FRAMINGHAM_NOT_EXISTS);
        }
    }

    @Override
    public ControlFraminghamDO getControlFramingham(Long id) {
        return controlFraminghamMapper.selectById(id);
    }

    @Override
    public PageResult<ControlFraminghamDO> getControlFraminghamPage(ControlFraminghamPageReqVO pageReqVO) {
        return controlFraminghamMapper.selectPage(pageReqVO);
    }

}