import request from '@/config/axios'

// 字段显示配置 VO
export interface FieldDisplayConfigVO {
  id?: number
  moduleType: string
  altitude?: number
  codeRange?: string
  fieldGroups: FieldGroupConfigVO[]
  createTime?: Date
  updateTime?: Date
}

// 字段组配置 VO
export interface FieldGroupConfigVO {
  groupCode: string
  groupName: string
  selected: boolean
  fields: FieldConfigVO[]
}

// 字段配置 VO
export interface FieldConfigVO {
  fieldCode: string
  fieldLabel: string
  selected: boolean
  tableName?: string
  fieldType?: string
  dataType?: string
  fieldLength?: number
}

// 字段数据查询请求 VO
export interface FieldDataQueryReqVO {
  group?: number
  altitude?: number
  codeRange?: number
  selectedFields: SelectedFieldVO[]
  pageNo?: number
  pageSize?: number
  sortField?: string
  sortOrder?: string
}

// 选中的字段 VO
export interface SelectedFieldVO {
  fieldCode: string
  fieldLabel: string
  tableName?: string
  moduleCode?: string
}

// 字段组响应 VO
export interface FieldGroupRespVO {
  groupCode: string
  groupName: string
  selected: boolean
  fields: FieldItemRespVO[]
}

// 字段项响应 VO
export interface FieldItemRespVO {
  fieldCode: string
  fieldLabel: string
  selected: boolean
  tableName?: string
  moduleCode?: string
  fieldType?: string
  dataType?: string
  fieldLength?: number
  isRequired?: number
  orderNo?: number
}

// 模块类型响应 VO
export interface ModuleTypeRespVO {
  value: string
  label: string
}

// 字段数据响应 VO
export interface FieldDataRespVO {
  list: any[]
  total: number
}

// 海拔选项 VO
export interface AltitudeOptionVO {
  value: number
  label: string
}

// 编号范围选项 VO
export interface CodeRangeOptionVO {
  value: number
  label: string
}

// API 响应类型
export interface ApiResponse<T = any> {
  code: number
  data: T
  message: string
  success: boolean
}

// 分页响应类型
export interface PageResponse<T = any> {
  list: T[]
  total: number
  pageNo: number
  pageSize: number
}

// 字段显示配置 API
export const FieldDisplayApi = {
  // 获取字段显示配置
  getFieldDisplayConfig: async (params?: { 
    moduleType?: string; 
    altitude?: number;
    codeRange?: string;
  }): Promise<ApiResponse<FieldGroupRespVO[]>> => {
    return await request.get({ url: '/queueDB/field-display/config', params })
  },

  // 保存字段显示配置
  saveFieldDisplayConfig: async (data: FieldDisplayConfigVO): Promise<ApiResponse<boolean>> => {
    return await request.post({ url: '/queueDB/field-display/config', data })
  },

  // 获取动态字段数据
  getDynamicFieldData: async (data: FieldDataQueryReqVO): Promise<ApiResponse<PageResponse>> => {
    return await request.post({ url: '/queueDB/field-display/data', data })
  },

  // 获取模块类型列表
  getModuleTypes: async (): Promise<ApiResponse<ModuleTypeRespVO[]>> => {
    return await request.get({ url: '/queueDB/field-display/module-types' })
  },

  // 获取字段分组列表
  getFieldGroups: async (params: { moduleType: string }): Promise<ApiResponse<FieldGroupRespVO[]>> => {
    return await request.get({ url: '/queueDB/field-display/field-groups', params })
  },

  // 获取海拔选项
  getAltitudeOptions: async (): Promise<ApiResponse<AltitudeOptionVO[]>> => {
    return await request.get({ url: '/queueDB/field-display/altitude-options' })
  },

  // 获取编号范围选项
  getCodeRangeOptions: async (): Promise<ApiResponse<CodeRangeOptionVO[]>> => {
    return await request.get({ url: '/queueDB/field-display/code-range-options' })
  },

  // 导出字段数据
  exportFieldData: async (data: FieldDataQueryReqVO): Promise<void> => {
    return await request.download({ url: '/queueDB/field-display/export-data', data })
  }
}

// 默认配置
export const DEFAULT_GROUP_OPTIONS = [
  { value: 1, label: '基线数据' }
] as const

export const DEFAULT_ALTITUDE_OPTIONS = [
  { value: 181, label: '3000-4000米' },
  { value: 363, label: '4000米以上' },
  { value: 0, label: '全部' }
] as const

export const DEFAULT_CODE_RANGE_OPTIONS = [
  { value: 23, label: '1-100' },
  { value: 24, label: '101-200' },
  { value: 0, label: '全部' }
] as const

// 基线数据选项类型
export const BASE_INFO_ITEMS = [
  '超声',
  '肺功能',
  '人体成分',
  '认知',
  '神经外科',
  '心电',
  '血液',
  '眼科',
  '血栓弹力图'
] as const

export type BaseInfoItem = typeof BASE_INFO_ITEMS[number]

// 字段类型类型
export type FieldType = 'input' | 'textarea' | 'number' | 'decimal' | 'select' | 'checkbox' | 'date' | 'datetime' | 'boolean'

// 数据类型类型
export type DataType = 'varchar' | 'text' | 'int' | 'bigint' | 'decimal' | 'datetime' | 'date' | 'tinyint'

// 工具函数
export const buildFieldProp = (field: FieldItemRespVO | SelectedFieldVO): string => {
  if (field.tableName) {
    return `${field.tableName}.${field.fieldCode}`
  }
  return field.fieldCode
}

export const getSelectedFields = (fieldGroups: FieldGroupConfigVO[]): SelectedFieldVO[] => {
  const selectedFields: SelectedFieldVO[] = []
  fieldGroups.forEach(group => {
    if (group.selected) {
      group.fields.forEach(field => {
        if (field.selected) {
          selectedFields.push({
            fieldCode: field.fieldCode,
            fieldLabel: field.fieldLabel,
            tableName: field.tableName,
            moduleCode: (field as any).moduleCode
          })
        }
      })
    }
  })
  return selectedFields
}

export const toggleGroupSelection = (group: FieldGroupConfigVO, selected: boolean): void => {
  group.selected = selected
  group.fields.forEach(field => {
    field.selected = selected
  })
}

export const isGroupPartiallySelected = (group: FieldGroupConfigVO): boolean => {
  const selectedCount = group.fields.filter(field => field.selected).length
  return selectedCount > 0 && selectedCount < group.fields.length
}

export const isGroupFullySelected = (group: FieldGroupConfigVO): boolean => {
  return group.fields.every(field => field.selected)
}

export const getSelectedFieldCount = (group: FieldGroupConfigVO): number => {
  return group.fields.filter(field => field.selected).length
}

export const selectAllGroups = (fieldGroups: FieldGroupConfigVO[]): void => {
  fieldGroups.forEach(group => {
    toggleGroupSelection(group, true)
  })
}

export const clearAllGroups = (fieldGroups: FieldGroupConfigVO[]): void => {
  fieldGroups.forEach(group => {
    toggleGroupSelection(group, false)
  })
}

// 字段格式化工具
export const formatFieldValue = (value: any, fieldType?: FieldType): string => {
  if (value === null || value === undefined || value === '') {
    return '-'
  }

  switch (fieldType) {
    case 'date':
    case 'datetime':
      return formatDate(value)
    case 'boolean':
      return value ? '是' : '否'
    case 'number':
    case 'decimal':
      return formatNumber(value)
    default:
      return String(value)
  }
}

export const formatDate = (value: any): string => {
  if (!value) return '-'
  try {
    const date = new Date(value)
    return date.toLocaleDateString('zh-CN')
  } catch {
    return String(value)
  }
}

export const formatNumber = (value: any): string => {
  if (value === null || value === undefined) return '-'
  const num = Number(value)
  return isNaN(num) ? String(value) : num.toLocaleString('zh-CN')
}

// 计算列宽度
export const getAutoMinWidth = (label: string, minWidth: number = 120): number => {
  return Math.max(minWidth, label.length * 12 + 20)
}

// 加载模块类型
export const loadModuleTypes = async (): Promise<ModuleTypeRespVO[]> => {
  try {
    const response = await FieldDisplayApi.getModuleTypes()
    return response.data
  } catch (error) {
    console.error('加载模块类型失败:', error)
    return []
  }
}

// 加载选项
export const loadOptions = async (): Promise<{
  altitudeOptions: AltitudeOptionVO[]
  codeRangeOptions: CodeRangeOptionVO[]
}> => {
  try {
    const [altitudeResponse, codeRangeResponse] = await Promise.all([
      FieldDisplayApi.getAltitudeOptions(),
      FieldDisplayApi.getCodeRangeOptions()
    ])
    return {
      altitudeOptions: altitudeResponse.data,
      codeRangeOptions: codeRangeResponse.data
    }
  } catch (error) {
    console.error('加载选项失败:', error)
    return {
      altitudeOptions: DEFAULT_ALTITUDE_OPTIONS,
      codeRangeOptions: DEFAULT_CODE_RANGE_OPTIONS
    }
  }
}

// 验证查询参数
export const validateQueryParams = (params: FieldDataQueryReqVO): string | null => {
  if (!params.selectedFields || params.selectedFields.length === 0) {
    return '请至少选择一个字段'
  }
  
  if (params.group === undefined) {
    return '请选择数据节点'
  }
  
  return null
}

// 构建导出参数
export const buildExportParams = (params: FieldDataQueryReqVO): FieldDataQueryReqVO => {
  return {
    ...params,
    pageNo: 1,
    pageSize: 10000 // 导出所有数据
  }
}

// 表格列配置类型
export interface TableColumnConfig {
  prop: string
  label: string
  width?: number
  minWidth?: number
  align?: 'left' | 'center' | 'right'
  fixed?: boolean | 'left' | 'right'
  sortable?: boolean
  formatter?: (row: any, column: any, cellValue: any) => string
}

// 生成表格列配置
export const generateTableColumns = (fieldGroups: FieldGroupRespVO[]): TableColumnConfig[] => {
  const columns: TableColumnConfig[] = [
    {
      prop: 'code',
      label: '编号',
      width: 100,
      align: 'center',
      fixed: 'left'
    },
    {
      prop: 'name',
      label: '姓名',
      width: 120,
      align: 'center',
      fixed: 'left'
    }
  ]

  fieldGroups.forEach(group => {
    group.fields.forEach(field => {
      if (field.selected) {
        columns.push({
          prop: buildFieldProp(field),
          label: field.fieldLabel,
          minWidth: getAutoMinWidth(field.fieldLabel),
          align: 'center',
          formatter: (row, column, cellValue) => formatFieldValue(cellValue, field.fieldType as FieldType)
        })
      }
    })
  })

  return columns
}

// 字段组工具
export const findFieldGroupByName = (fieldGroups: FieldGroupRespVO[], groupName: string): FieldGroupRespVO | undefined => {
  return fieldGroups.find(group => group.groupName === groupName)
}

export const findFieldByCode = (fieldGroups: FieldGroupRespVO[], fieldCode: string): FieldItemRespVO | undefined => {
  for (const group of fieldGroups) {
    const field = group.fields.find(f => f.fieldCode === fieldCode)
    if (field) return field
  }
  return undefined
}

// 缓存工具
export class FieldConfigCache {
  private static cache = new Map<string, FieldGroupRespVO[]>()
  private static cacheTime = new Map<string, number>()
  private static readonly CACHE_DURATION = 5 * 60 * 1000 // 5分钟

  static set(key: string, data: FieldGroupRespVO[]): void {
    this.cache.set(key, data)
    this.cacheTime.set(key, Date.now())
  }

  static get(key: string): FieldGroupRespVO[] | null {
    const data = this.cache.get(key)
    const cacheTime = this.cacheTime.get(key)
    
    if (data && cacheTime && Date.now() - cacheTime < this.CACHE_DURATION) {
      return data
    }
    
    // 清除过期缓存
    this.clearExpired()
    return null
  }

  static clear(key?: string): void {
    if (key) {
      this.cache.delete(key)
      this.cacheTime.delete(key)
    } else {
      this.cache.clear()
      this.cacheTime.clear()
    }
  }

  private static clearExpired(): void {
    const now = Date.now()
    for (const [key, time] of this.cacheTime.entries()) {
      if (now - time >= this.CACHE_DURATION) {
        this.cache.delete(key)
        this.cacheTime.delete(key)
      }
    }
  }

  static generateCacheKey(moduleType: string, altitude?: number, codeRange?: string): string {
    return `${moduleType}_${altitude}_${codeRange}`
  }
}