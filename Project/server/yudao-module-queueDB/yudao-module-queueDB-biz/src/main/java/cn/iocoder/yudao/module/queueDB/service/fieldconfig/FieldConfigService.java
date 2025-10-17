package cn.iocoder.yudao.module.queueDB.service.fieldconfig;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.queueDB.controller.admin.fieldconfig.vo.*;
import cn.iocoder.yudao.module.queueDB.dal.dataobject.fieldconfig.FieldConfigDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 动态字段配置 Service 接口
 *
 * @author 芋道源码
 */
public interface FieldConfigService {

    /**
     * 创建动态字段配置
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createFieldConfig(@Valid FieldConfigSaveReqVO createReqVO);

    /**
     * 更新动态字段配置
     *
     * @param updateReqVO 更新信息
     */
    void updateFieldConfig(@Valid FieldConfigSaveReqVO updateReqVO);

    /**
     * 删除动态字段配置
     *
     * @param id 编号
     */
    void deleteFieldConfig(Long id);

    /**
     * 获得动态字段配置
     *
     * @param id 编号
     * @return 动态字段配置
     */
    FieldConfigDO getFieldConfig(Long id);

    /**
     * 获得动态字段配置分页
     *
     * @param pageReqVO 分页查询
     * @return 动态字段配置分页
     */
    PageResult<FieldConfigDO> getFieldConfigPage(FieldConfigPageReqVO pageReqVO);

    /**
     * 根据 moduleCode 获取字段（用于前端渲染）
     */
    List<FieldConfigDO> listByModuleCode(String moduleCode);

    /**
     * 批量创建字段配置
     */
    void batchCreateFieldConfig(List<FieldConfigSaveReqVO> createReqVOs);

    /**
     * 获取字段类型选项
     */
    List<FieldTypeOptionVO> getFieldTypeOptions();

    /**
     * 检查字段代码是否可用
     */
    boolean checkFieldCodeAvailable(String moduleCode, String fieldCode);

}