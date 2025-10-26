import request from '@/config/axios'

export interface ModuleTreeVO {
  id: number
  parentId: number | null
  moduleCode: string
  moduleName: string
  tableName: string | null
  moduleLevel: number
  groupType: string | null
  moduleType: string | null
  isLeaf: number
  orderNo: number
  status: number
  children?: ModuleTreeVO[]
  fields?: FieldConfigVO[]
}

export interface FieldConfigVO {
  id: number
  moduleCode: string
  fieldCode: string
  fieldLabel: string
  fieldType: string
  dataType: string
  optionsJson: any
  isRequired: number
  orderNo: number
  status: number
  fieldLength: number | null
  isDefault: number
  displayOrder: number
  fieldName: string | null
  fieldGroup: string | null
  fieldGroupName: string | null
}

// 获取完整的模块树（包含字段）
export const getModuleTree = () => {
  return request.get<ModuleTreeVO[]>({
    url: '/queueDB/module-config/tree-with-fields'
  })
}

// 获取基础信息模块（parent_id为null的模块）
export const getBaseModules = () => {
  return request.get<ModuleTreeVO[]>({
    url: '/queueDB/module-config/base-modules'
  })
}