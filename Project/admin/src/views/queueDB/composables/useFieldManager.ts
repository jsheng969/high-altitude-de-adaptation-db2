import { ref, computed } from 'vue'
import { getModuleTree } from '@/api/queueDB/moduleTree'

interface TableField {
  label: string
  prop: string
  moduleCode?: string
  tableName?: string
}

export function useFieldManager(queryParams: any) {
  const displayedFields = ref<Record<string, TableField[]>>({})
  const moduleTree = ref<ModuleTreeVO[]>([])
  const loading = ref(false)

// 加载模块树
const loadModuleTree = async () => {
  loading.value = true
  try {
    const response = await getModuleTree()
    moduleTree.value = response || []
    
    console.log('=== 完整的模块树结构 ===')
    moduleTree.value.forEach(module => {
      console.log(`模块 ${module.moduleName}:`, {
        id: module.id,
        moduleCode: module.moduleCode,
        tableName: module.tableName,
        isLeaf: module.isLeaf,
        children: module.children,
        fields: module.fields,
        childrenCount: module.children?.length,
        fieldsCount: module.fields?.length
      })
    })
    
  } catch (error) {
    console.error('加载模块树失败:', error)
    moduleTree.value = []
  } finally {
    loading.value = false
  }
}

  // 获取基础信息模块（一级模块）
  const baseModules = computed(() => {
    return moduleTree.value.filter(module => 
      module.parentId === null && module.status === 1
    )
  })

  // 根据模块名称获取模块
  const getModuleByName = (moduleName: string) => {
    return baseModules.value.find(module => module.moduleName === moduleName)
  }

  // 构建多级表头结构
const buildTableFields = (module: ModuleTreeVO): Record<string, any> => {
  const result: Record<string, any> = {}

  console.log(`构建模块 ${module.moduleName} 的表头:`, {
    id: module.id,
    moduleCode: module.moduleCode,
    tableName: module.tableName,
    isLeaf: module.isLeaf,
    children: module.children,
    fields: module.fields,
    childrenCount: module.children?.length,
    fieldsCount: module.fields?.length
  })

  // 检查是否有有效的子模块（children 存在且是数组）
  const hasValidChildren = Array.isArray(module.children) && module.children.length > 0
  
  // 如果模块有有效的子模块，构建多级表头（如吸烟情况）
  if (hasValidChildren) {
    console.log(`模块 ${module.moduleName} 有子模块，构建多级表头`)
    
    result[module.moduleName] = {}
    let hasValidChildFields = false
    
    module.children.forEach((child: ModuleTreeVO) => {
      console.log(`处理子模块 ${child.moduleName}:`, {
        isLeaf: child.isLeaf,
        tableName: child.tableName,
        hasFields: child.fields?.length
      })
      
      // 子模块是叶子节点且有字段
      if (child.isLeaf === 1 && child.fields && child.fields.length > 0) {
        const childFields = child.fields
          .filter(field => field.status === 1)
          .map(field => {
            const prop = child.tableName ? `${child.tableName}.${field.fieldCode}` : field.fieldCode
            console.log(`字段 ${field.fieldLabel} -> ${prop}`)
            return {
              label: field.fieldLabel,
              prop: prop,
              moduleCode: child.moduleCode,
              tableName: child.tableName
            }
          })
        
        if (childFields.length > 0) {
          result[module.moduleName][child.moduleName] = childFields
          hasValidChildFields = true
        }
      } else {
        console.log(`子模块 ${child.moduleName} 没有字段或不是叶子节点，跳过`)
      }
    })
  } 
  // 如果是叶子节点且有字段，直接使用字段作为一级表头下的二级表头（如超声）
  else if (module.isLeaf === 1 && module.fields && module.fields.length > 0) {
    console.log(`模块 ${module.moduleName} 是叶子节点，构建一级表头 + 二级表头`)
    
    const fields = module.fields
      .filter(field => field.status === 1)
      .map(field => {
        const prop = module.tableName ? `${module.tableName}.${field.fieldCode}` : field.fieldCode
        console.log(`字段 ${field.fieldLabel} -> ${prop}`)
        return {
          label: field.fieldLabel,
          prop: prop,
          moduleCode: module.moduleCode,
          tableName: module.tableName
        }
      })
    
    if (fields.length > 0) {
      // 一级表头：模块名称
      // 二级表头：直接显示字段
      result[module.moduleName] = fields
    }
  }
  // 既不是叶子节点也没有子模块，但是有字段（特殊情况）
  else if (module.fields && module.fields.length > 0) {
    console.log(`模块 ${module.moduleName} 既不是叶子节点也没有子模块，但直接有字段`)
    
    const fields = module.fields
      .filter(field => field.status === 1)
      .map(field => ({
        label: field.fieldLabel,
        prop: module.tableName ? `${module.tableName}.${field.fieldCode}` : field.fieldCode,
        moduleCode: module.moduleCode,
        tableName: module.tableName
      }))
    
    if (fields.length > 0) {
      result[module.moduleName] = fields
    }
  } else {
    console.log(`模块 ${module.moduleName} 没有任何字段，跳过`)
  }

  console.log(`模块 ${module.moduleName} 最终结果:`, result)
  return result
}

const updateDisplayedFields = () => {
  const groupedFields: Record<string, any> = {}
  
  console.log('=== 开始更新显示字段 ===')
  console.log('查询参数 baseInfo:', queryParams.baseInfo)
  console.log('当前模块树:', moduleTree.value)
  console.log('基础模块:', baseModules.value.map(m => ({name: m.moduleName, isLeaf: m.isLeaf, hasChildren: m.children?.length})))
  
  // 基础信息 - 动态从模块树获取
  if (queryParams.baseInfo && queryParams.baseInfo.length > 0) {
    queryParams.baseInfo.forEach((moduleName: string) => {
      console.log(`=== 处理模块: ${moduleName} ===`)
      const module = getModuleByName(moduleName)
      console.log(`找到模块:`, module ? {
        name: module.moduleName,
        isLeaf: module.isLeaf,
        hasChildren: module.children?.length,
        hasFields: module.fields?.length
      } : '未找到')
      
      if (module) {
        const moduleFields = buildTableFields(module)
        console.log(`模块 ${moduleName} 生成的表头结构:`, moduleFields)
        // 合并到 groupedFields
        Object.assign(groupedFields, moduleFields)
      }
    })
    
    console.log('最终基础信息字段结构:', groupedFields)
  }

  displayedFields.value = groupedFields
  console.log('=== 最终显示的字段结构 ===', displayedFields.value)
}

  const fieldGroups = computed(() => {
    return convertToGroupedTree(displayedFields.value)
  })

  const convertToGroupedTree = (flatGroups: Record<string, TableField[]>) => {
    const tree: Record<string, Record<string, TableField[]>> = {}

    for (const [groupName, fields] of Object.entries(flatGroups)) {
      if (groupName === '基础信息') {
        tree['基础信息'] = { '基础信息字段': fields }
      } else {
        if (!tree['动态模块']) tree['动态模块'] = {}
        tree['动态模块'][groupName] = fields
      }
    }

    return tree
  }

  return {
    displayedFields,
    updateDisplayedFields,
    fieldGroups,
    baseModules,
    loadModuleTree,
    loading
  }
}