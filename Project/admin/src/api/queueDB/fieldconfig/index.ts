import request from '@/config/axios'

// 动态字段配置 VO
export interface FieldConfigVO {
  id: number // 字段ID
  moduleCode: string // 所属模块code（对应module_config.module_code）
  fieldCode: string // 字段标识（用于数据库列名）
  fieldLabel: string // 字段显示名
  fieldType: string // 字段类型（input/select/number/date/checkbox等）
  dataType: string // 数据库字段类型
  optionsJson: string // 选项配置（如下拉选项等）
  isRequired: number // 是否必填
  orderNo: number // 排序号
  status: number // 状态（1启用）
}

// 动态字段配置 API
export const FieldConfigApi = {
  // 查询动态字段配置分页
  getFieldConfigPage: async (params: any) => {
    return await request.get({ url: `/queueDB/field-config/page`, params })
  },

  // 查询动态字段配置详情
  getFieldConfig: async (id: number) => {
    return await request.get({ url: `/queueDB/field-config/get?id=` + id })
  },

  // 新增动态字段配置
  createFieldConfig: async (data: FieldConfigVO) => {
    return await request.post({ url: `/queueDB/field-config/create`, data })
  },

  // 修改动态字段配置
  updateFieldConfig: async (data: FieldConfigVO) => {
    return await request.put({ url: `/queueDB/field-config/update`, data })
  },

  // 删除动态字段配置
  deleteFieldConfig: async (id: number) => {
    return await request.delete({ url: `/queueDB/field-config/delete?id=` + id })
  },

  // 导出动态字段配置 Excel
  exportFieldConfig: async (params) => {
    return await request.download({ url: `/queueDB/field-config/export-excel`, params })
  },
  // 根据模块代码获取字段列表
  listByModuleCode: async (moduleCode: string) => {
    return await request.get({ url: '/queueDB/field-config/list', params: { moduleCode } })
  },
  
  // 获取字段类型选项
  getFieldTypeOptions: async () => {
    return await request.get({ url: '/queueDB/field-config/field-type-options' })
  },

  // 检查字段代码是否可用
  checkFieldCode: async (moduleCode: string, fieldCode: string) => {
    return await request.get({ 
      url: '/queueDB/field-config/check-code', 
      params: { moduleCode, fieldCode } 
    })
  }
}