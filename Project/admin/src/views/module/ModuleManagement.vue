<template>
  <div class="module-management">
    <!-- 搜索和操作栏 -->
    <div class="header-operation">
      <el-form :inline="true" :model="queryParams">
        <el-form-item label="模块名称">
          <el-input
            v-model="queryParams.moduleName"
            placeholder="请输入模块名称"
            clearable
            style="width: 200px"
          />
        </el-form-item>
        <el-form-item label="模块层级">
          <el-select v-model="queryParams.moduleLevel" placeholder="请选择层级" clearable>
            <el-option label="一级模块" :value="1" />
            <el-option label="二级模块" :value="2" />
            <el-option label="三级模块" :value="3" />
          </el-select>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleQuery">
            <Icon icon="ep:search" />搜索
          </el-button>
          <el-button @click="resetQuery">
            <Icon icon="ep:refresh" />重置
          </el-button>
        </el-form-item>
      </el-form>

      <div class="right-buttons">
        <el-button type="primary" @click="handleCreate">
          <Icon icon="ep:plus" />新增模块
        </el-button>
      </div>
    </div>

    <!-- 模块树表格 -->
    <el-card>
      <template #header>
        <span>模块列表</span>
      </template>

      <el-table
        v-loading="loading"
        :data="moduleTree"
        row-key="id"
        :tree-props="{ children: 'children', hasChildren: 'hasChildren' }"
      >
        <el-table-column prop="moduleCode" label="模块代码" width="200" />
        <el-table-column prop="moduleName" label="模块名称" width="200" />
        <el-table-column prop="moduleLevel" label="层级" width="100">
          <template #default="{ row }">
            <el-tag :type="getLevelTagType(row.moduleLevel)">
              {{ getLevelText(row.moduleLevel) }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="fieldCount" label="字段数量" width="100">
          <template #default="{ row }">
            <el-tag v-if="row.fieldCount > 0" type="success">
              {{ row.fieldCount }}
            </el-tag>
            <span v-else>-</span>
          </template>
        </el-table-column>
        <el-table-column prop="tableName" label="对应表名" width="180" />
        <el-table-column prop="isLeaf" label="叶子节点" width="100">
          <template #default="{ row }">
            <el-tag :type="row.isLeaf ? 'success' : 'info'">
              {{ row.isLeaf ? '是' : '否' }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="status" label="状态" width="80">
          <template #default="{ row }">
            <el-switch
              v-model="row.status"
              :active-value="1"
              :inactive-value="0"
              @change="handleStatusChange(row)"
            />
          </template>
        </el-table-column>
        <el-table-column prop="orderNo" label="排序" width="80" />
        <el-table-column label="操作" width="240" fixed="right">
          <template #default="{ row }">
            <el-button link type="primary" @click="handleViewFields(row)">
              <Icon icon="ep:view" />字段管理
            </el-button>
            <el-button link type="primary" @click="handleEdit(row)">
              <Icon icon="ep:edit" />编辑
            </el-button>
            <el-button 
              v-if="row.moduleLevel < 3"
              link 
              type="primary" 
              @click="handleCreateChild(row)"
            >
              <Icon icon="ep:plus" />添加子模块
            </el-button>
            <el-button 
              link 
              type="danger" 
              @click="handleDelete(row)"
              :disabled="row.fieldCount > 0"
            >
              <Icon icon="ep:delete" />删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <!-- 模块编辑对话框 -->
    <ModuleEditDialog
      v-model="editDialog.visible"
      :data="editDialog.data"
      :parent-module="editDialog.parentModule"
      @success="handleEditSuccess"
    />
  </div>
</template>

<script setup lang="ts">
import { ref, reactive, onMounted } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import ModuleEditDialog from './components/ModuleEditDialog.vue'
import { ModuleConfigApi } from '@/api/queueDB/moduleconfig'
import { useRoute, useRouter } from 'vue-router'

// 响应式数据
const loading = ref(false)
const moduleTree = ref<any[]>([])
const queryParams = reactive({
  moduleName: '',
  moduleLevel: undefined
})

const editDialog = reactive({
  visible: false,
  data: null,
  parentModule: null
})

// 方法
const loadModuleTree = async () => {
  try {
    loading.value = true
    const response = await ModuleConfigApi.getModuleTreeWithStats('/queueDB/module-config/tree-with-stats', {
      params: queryParams
    })    
    moduleTree.value = response
  } catch (error) {
    console.error('加载模块树失败:', error)
    ElMessage.error('加载模块树失败')
  } finally {
    loading.value = false
  }
}

const handleCreate = () => {
  editDialog.data = null
  editDialog.parentModule = null
  editDialog.visible = true
}

const handleCreateChild = (parentModule: any) => {
  editDialog.data = null
  editDialog.parentModule = parentModule
  editDialog.visible = true
}

const handleEdit = (module: any) => {
  editDialog.data = module
  editDialog.parentModule = null
  editDialog.visible = true
}
const router = useRouter() // 路由对象
const handleViewFields = (module: any) => {
  // 跳转到字段管理页面，带上模块ID
//   const route = useRouter()
  router.push(`/field?moduleId=${module.id}`)
}

const handleStatusChange = async (module: any) => {
  try {
    await ModuleConfigApi.updateModuleConfig({
      id: module.id,
      status: module.status
    })
    ElMessage.success(module.status === 1 ? '启用成功' : '停用成功')
  } catch (error) {
    // 回滚状态
    module.status = module.status === 1 ? 0 : 1
    ElMessage.error('状态更新失败')
  }
}

const handleDelete = async (module: any) => {
  try {
    await ElMessageBox.confirm(
      `确定删除模块 "${module.moduleName}" 吗？`,
      '提示',
      {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }
    )
    
    await ModuleConfigApi.deleteModuleConfig(module.id)
    ElMessage.success('删除成功')
    loadModuleTree()
  } catch (error) {
    // 用户取消删除
  }
}

const handleQuery = () => {
  loadModuleTree()
}

const resetQuery = () => {
  Object.assign(queryParams, {
    moduleName: '',
    moduleLevel: undefined
  })
  loadModuleTree()
}

const handleEditSuccess = () => {
  editDialog.visible = false
  loadModuleTree()
}

const getLevelTagType = (level: number) => {
  const types: any = { 1: 'danger', 2: 'warning', 3: 'success' }
  return types[level] || 'info'
}

const getLevelText = (level: number) => {
  const texts: any = { 1: '一级', 2: '二级', 3: '三级' }
  return texts[level] || '未知'
}

// 生命周期
onMounted(() => {
  loadModuleTree()
})
</script>

<style scoped>
.module-management {
  padding: 20px;
}

.header-operation {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  margin-bottom: 16px;
}

.right-buttons {
  display: flex;
  gap: 8px;
}
</style>