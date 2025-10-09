package cn.iocoder.yudao.module.prospective.service.history;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.prospective.controller.admin.history.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.history.HistoryDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 预警历史记录 Service 接口
 *
 * @author 管理员
 */
public interface HistoryService {

    /**
     * 创建预警历史记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createHistory(@Valid HistorySaveReqVO createReqVO);

    /**
     * 更新预警历史记录
     *
     * @param updateReqVO 更新信息
     */
    void updateHistory(@Valid HistorySaveReqVO updateReqVO);

    /**
     * 删除预警历史记录
     *
     * @param id 编号
     */
    void deleteHistory(Integer id);

    /**
     * 获得预警历史记录
     *
     * @param id 编号
     * @return 预警历史记录
     */
    HistoryDO getHistory(Integer id);

    /**
     * 获得预警历史记录分页
     *
     * @param pageReqVO 分页查询
     * @return 预警历史记录分页
     */
    PageResult<HistoryDO> getHistoryPage(HistoryPageReqVO pageReqVO);

}