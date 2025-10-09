package cn.iocoder.yudao.module.prospective.service.history;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.prospective.controller.admin.history.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.history.HistoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.history.HistoryMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 预警历史记录 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class HistoryServiceImpl implements HistoryService {

    @Resource
    private HistoryMapper historyMapper;

    @Override
    public Integer createHistory(HistorySaveReqVO createReqVO) {
        // 插入
        HistoryDO history = BeanUtils.toBean(createReqVO, HistoryDO.class);
        historyMapper.insert(history);
        // 返回
        return history.getId();
    }

    @Override
    public void updateHistory(HistorySaveReqVO updateReqVO) {
        // 校验存在
        validateHistoryExists(updateReqVO.getId());
        // 更新
        HistoryDO updateObj = BeanUtils.toBean(updateReqVO, HistoryDO.class);
        historyMapper.updateById(updateObj);
    }

    @Override
    public void deleteHistory(Integer id) {
        // 校验存在
        validateHistoryExists(id);
        // 删除
        historyMapper.deleteById(id);
    }

    private void validateHistoryExists(Integer id) {
        if (historyMapper.selectById(id) == null) {
            throw exception(HISTORY_NOT_EXISTS);
        }
    }

    @Override
    public HistoryDO getHistory(Integer id) {
        return historyMapper.selectById(id);
    }

    @Override
    public PageResult<HistoryDO> getHistoryPage(HistoryPageReqVO pageReqVO) {
        return historyMapper.selectPage(pageReqVO);
    }

}