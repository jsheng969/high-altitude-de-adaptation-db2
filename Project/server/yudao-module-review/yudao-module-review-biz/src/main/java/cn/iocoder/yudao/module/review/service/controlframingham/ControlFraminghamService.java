package cn.iocoder.yudao.module.review.service.controlframingham;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.review.controller.admin.controlframingham.vo.*;
import cn.iocoder.yudao.module.review.dal.dataobject.controlframingham.ControlFraminghamDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 实验组-framingham评分 Service 接口
 *
 * @author 管理员
 */
public interface ControlFraminghamService {

    /**
     * 创建实验组-framingham评分
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createControlFramingham(@Valid ControlFraminghamSaveReqVO createReqVO);

    /**
     * 更新实验组-framingham评分
     *
     * @param updateReqVO 更新信息
     */
    void updateControlFramingham(@Valid ControlFraminghamSaveReqVO updateReqVO);

    /**
     * 删除实验组-framingham评分
     *
     * @param id 编号
     */
    void deleteControlFramingham(Long id);

    /**
     * 获得实验组-framingham评分
     *
     * @param id 编号
     * @return 实验组-framingham评分
     */
    ControlFraminghamDO getControlFramingham(Long id);

    /**
     * 获得实验组-framingham评分分页
     *
     * @param pageReqVO 分页查询
     * @return 实验组-framingham评分分页
     */
    PageResult<ControlFraminghamDO> getControlFraminghamPage(ControlFraminghamPageReqVO pageReqVO);

}