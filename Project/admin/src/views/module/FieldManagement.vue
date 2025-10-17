<template>
  <div class="field-management">
    <!-- 页面头部 -->
    <div class="page-header">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/queueDB/module-management' }">
          模块管理
        </el-breadcrumb-item>
        <el-breadcrumb-item>字段管理 - {{ currentModule?.moduleName }}</el-breadcrumb-item>
      </el-breadcrumb>
      
      <div class="header-actions">
        <el-button type="primary" @click="handleCreateField">
          <Icon icon="ep:plus" />新增字段
        </el-button>
        <el-button @click="handleBack">
          <Icon icon="ep:arrow-left" />返回
        </el-button>
      </div>
    </div>

    <!-- 字段列表 -->
    <el-card>
      <template #header>
        <span>字段列表 ({{ fieldList.length }})</span>
      </template>

      <el-table
        v-loading="loading"
        :data="fieldList"
        row-key="id"
      >
        <el-table-column prop="fieldCode" label="字段代码" width="200" />
        <el-table-column prop="fieldLabel" label="字段显示名" width="200" />
        <el-table-column prop="fieldType" label="字段类型" width="120">
          <template #default="{ row }">
            <el-tag>{{ getFieldTypeText(row.fieldType) }}</el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="dataType" label="数据库类型" width="150" />
        <el-table-column prop="isRequired" label="是否必填" width="100">
          <template #default="{ row }">
            <el-tag :type="row.isRequired ? 'danger' : 'info'">
              {{ row.isRequired ? '是' : '否' }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="orderNo" label="排序" width="80" />
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
        <el-table-column label="操作" width="180" fixed="right">
          <template #default="{ row }">
            <el-button link type="primary" @click="handleEdit(row)">
              <Icon icon="ep:edit" />编辑
            </el-button>
            <el-button link type="danger" @click="handleDelete(row)">
              <Icon icon="ep:delete" />删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-card>

    <!-- 字段编辑对话框 -->
    <FieldEditDialog
      v-model="editDialog.visible"
      :data="editDialog.data"
      :module-code="currentModule?.moduleCode"
      @success="handleEditSuccess"
    />
  </div>
</template>

<script setup lang="ts">
import { ref, reactive, onMounted, computed } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { ElMessage, ElMessageBox } from 'element-plus'
import FieldEditDialog from './components/FieldEditDialog.vue'
import { FieldConfigApi } from '@/api/queueDB/fieldconfig'
import { ModuleConfigApi } from '@/api/queueDB/moduleconfig'

const route = useRoute()
const router = useRouter()

// 响应式数据
const loading = ref(false)
const currentModule = ref<any>(null)
const fieldList = ref<any[]>([])

const editDialog = reactive({
  visible: false,
  data: null
})

// 计算属性
const moduleId = computed(() => route.query.moduleId as string)

// 方法
const loadModuleDetail = async () => {
  if (!moduleId.value) return
  
  try {
    console.log('Loading module details for ID:', moduleId.value);
    
    const response = await ModuleConfigApi.getModuleConfig(moduleId.value)
    currentModule.value = response
  } catch (error) {
    console.error('加载模块详情失败:', error)
    ElMessage.error('加载模块详情失败')
  }
}

const loadFieldList = async () => {
  if (!moduleId.value) return
  
  try {
    loading.value = true
    const response = await FieldConfigApi.listByModuleCode(currentModule.value?.moduleCode)
    fieldList.value = response
  } catch (error) {
    console.error('加载字段列表失败:', error)
    ElMessage.error('加载字段列表失败')
  } finally {
    loading.value = false
  }
}

const handleCreateField = () => {
  if (!currentModule.value) {
    ElMessage.warning('请先选择模块')
    return
  }
  editDialog.data = null
  editDialog.visible = true
}

const handleEdit = (field: any) => {
  editDialog.data = field
  editDialog.visible = true
}

const handleStatusChange = async (field: any) => {
  try {
    await FieldConfigApi.updateFieldConfig({
      id: field.id,
      status: field.status
    })
    ElMessage.success(field.status === 1 ? '启用成功' : '停用成功')
  } catch (error) {
    // 回滚状态
    field.status = field.status === 1 ? 0 : 1
    ElMessage.error('状态更新失败')
  }
}

const handleDelete = async (field: any) => {
  try {
    await ElMessageBox.confirm(
      `确定删除字段 "${field.fieldLabel}" 吗？`,
      '提示',
      {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }
    )
    
    await FieldConfigApi.deleteFieldConfig(field.id)
    ElMessage.success('删除成功')
    loadFieldList()
  } catch (error) {
    // 用户取消删除
  }
}

const handleBack = () => {
  router.push('/queueDB/module-management')
}

const handleEditSuccess = () => {
  editDialog.visible = false
  loadFieldList()
}

const getFieldTypeText = (fieldType: string) => {
  const texts: any = {
    input: '单行文本',
    textarea: '多行文本',
    number: '数字',
    decimal: '小数',
    select: '下拉选择',
    checkbox: '多选框',
    date: '日期',
    datetime: '日期时间',
    boolean: '布尔值'
  }
  return texts[fieldType] || fieldType
}

// 生命周期
onMounted(async () => {
  await loadModuleDetail()
  await loadFieldList()
})
</script>

<style scoped>
.field-management {
  padding: 20px;
}

.page-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 16px;
}

.header-actions {
  display: flex;
  gap: 8px;
}
</style>