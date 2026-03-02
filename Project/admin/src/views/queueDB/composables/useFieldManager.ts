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
  // 主表字段（基础字段）
  const mainTableFields = ref<TableField[]>([])

  // 加载模块树
  const loadModuleTree = async () => {
    loading.value = true
    try {
      const response = await getModuleTree("prospective")
      moduleTree.value = response || []
      
      console.log('=== 完整的模块树结构 ===')
      moduleTree.value.forEach(module => {
        console.log(`模块 ${module.moduleName} (ID: ${module.id}):`, {
          id: module.id,
          moduleCode: module.moduleCode,
          tableName: module.tableName,
          isLeaf: module.isLeaf,
          children: module.children?.map(c => c.moduleName),
          fields: module.fields?.map(f => ({ 
            label: f.fieldLabel, 
            code: f.fieldCode,
            status: f.status 
          })),
          childrenCount: module.children?.length,
          fieldsCount: module.fields?.length
        })
      })
      
      // 获取主表字段（ID为176的模块，即前瞻性队列数据库）
      const mainModule = moduleTree.value.find(m => m.id === 176)
      if (mainModule && mainModule.fields) {
        console.log('找到主模块，所有字段:', mainModule.fields.map(f => ({ 
          label: f.fieldLabel, 
          code: f.fieldCode,
          status: f.status 
        })))
        
        mainTableFields.value = mainModule.fields
          .filter(field => {
            // 过滤条件：状态为1
            if (field.status !== 1) {
              console.log(`字段 ${field.fieldLabel} 状态不为1，跳过`)
              return false
            }
            
            // 记录所有通过的字段
            console.log(`字段 ${field.fieldLabel} 通过过滤`)
            return true
          })
          .map(field => ({
            label: field.fieldLabel,
            prop: field.fieldCode, // 主表字段直接使用fieldCode
            moduleCode: mainModule.moduleCode,
            tableName: mainModule.tableName
          }))
        
        console.log('主表字段最终结果:', mainTableFields.value)
      } else {
        console.log('未找到主模块或主模块没有字段')
      }
      
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

  // 递归查找模块
  const findModuleByName = (moduleName: string, modules: ModuleTreeVO[]): ModuleTreeVO | null => {
    for (const module of modules) {
      if (module.moduleName === moduleName) {
        return module
      }
      if (module.children) {
        const found = findModuleByName(moduleName, module.children)
        if (found) return found
      }
    }
    return null
  }

  // 获取模块的字段
  const getModuleFields = (module: ModuleTreeVO): TableField[] => {
    const fields: TableField[] = []
    
    console.log(`获取模块 ${module.moduleName} 的字段:`, {
      id: module.id,
      isLeaf: module.isLeaf,
      hasFields: module.fields?.length,
      hasChildren: module.children?.length,
      tableName: module.tableName
    })
    
    // 如果是叶子节点且有字段，直接使用字段
    if (module.isLeaf === 1 && module.fields && module.fields.length > 0) {
      console.log(`模块 ${module.moduleName} 的原始字段:`, module.fields.map(f => ({ 
        label: f.fieldLabel, 
        code: f.fieldCode,
        status: f.status 
      })))
      
      module.fields
        .filter(field => {
          // 过滤条件：状态为1
          if (field.status !== 1) {
            console.log(`字段 ${field.fieldLabel} 状态不为1，跳过`)
            return false
          }
          
          console.log(`字段 ${field.fieldLabel} 通过过滤`)
          return true
        })
        .forEach(field => {
          const prop = module.tableName ? `${module.tableName}.${field.fieldCode}` : field.fieldCode
          fields.push({
            label: field.fieldLabel,
            prop: prop,
            moduleCode: module.moduleCode,
            tableName: module.tableName
          })
        })
    } else {
      console.log(`模块 ${module.moduleName} 不是叶子节点或没有字段`)
    }
    
    console.log(`模块 ${module.moduleName} 最终字段:`, fields)
    return fields
  }

  const updateDisplayedFields = () => {
    const groupedFields: Record<string, any> = {}
    
    console.log('=== 开始更新显示字段 ===')
    console.log('查询参数 baseInfo:', queryParams.baseInfo)
    console.log('当前模块树:', moduleTree.value)
    console.log('主表字段:', mainTableFields.value)
    
    // 先添加主表字段（作为第一列）
    if (mainTableFields.value.length > 0) {
      groupedFields['基础信息'] = mainTableFields.value
      console.log('添加主表字段到基础信息:', mainTableFields.value)
    }
    
    // 基础信息 - 动态从模块树获取
    if (queryParams.baseInfo && queryParams.baseInfo.length > 0) {
      queryParams.baseInfo.forEach((moduleName: string) => {
        console.log(`=== 处理模块: ${moduleName} ===`)
        
        // 查找模块（可能是一级模块或二级模块）
        let targetModule = null
        
        // 先在一级模块中查找
        const baseModule = baseModules.value.find(m => m.moduleName === moduleName)
        
        if (baseModule) {
          // 如果是一级模块（如"前瞻性队列数据库"），获取其直接子模块（二级模块）
          console.log(`找到一级模块: ${baseModule.moduleName}，获取其子模块`)
          
          if (baseModule.children && baseModule.children.length > 0) {
            // 遍历所有子模块（二级模块）
            baseModule.children.forEach((childModule: ModuleTreeVO) => {
              if (childModule.status === 1) {
                console.log(`处理子模块: ${childModule.moduleName}`)
                
                // 直接使用子模块名称作为表头
                const fields = getModuleFields(childModule)
                if (fields.length > 0) {
                  groupedFields[childModule.moduleName] = fields
                  console.log(`为模块 ${childModule.moduleName} 添加字段:`, fields)
                } else {
                  console.log(`模块 ${childModule.moduleName} 没有字段，跳过`)
                }
              }
            })
          } else {
            console.log(`一级模块 ${baseModule.moduleName} 没有子模块`)
          }
        } else {
          // 如果直接是二级模块名称（如"检查结果"）
          targetModule = findModuleByName(moduleName, moduleTree.value)
          if (targetModule) {
            console.log(`找到二级模块: ${targetModule.moduleName}`)
            const fields = getModuleFields(targetModule)
            if (fields.length > 0) {
              groupedFields[targetModule.moduleName] = fields
              console.log(`为模块 ${targetModule.moduleName} 添加字段:`, fields)
            }
          } else {
            console.log(`未找到模块: ${moduleName}`)
          }
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
    mainTableFields,
    loadModuleTree,
    loading
  }
}