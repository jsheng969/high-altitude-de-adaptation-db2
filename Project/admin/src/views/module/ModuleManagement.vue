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

    <el-card class="import-card">
      <template #header>
        <div class="card-header">
          <span>Excel 导入</span>
          <el-button type="primary" link @click="downloadTemplate('simple')">
            下载模板
          </el-button>
          <!-- <el-button type="primary" link @click="downloadTemplate('full')">
            下载完整模板
          </el-button> -->
        </div>
      </template>

      <el-form :model="importForm" :rules="rules" ref="importFormRef" label-width="120px">
        <el-form-item label="Excel文件" prop="file">
          <el-upload
            ref="uploadRef"
            class="upload-demo"
            action=""
            :auto-upload="false"
            :on-change="handleFileChange"
            :on-remove="handleFileRemove"
            :file-list="fileList"
            accept=".xlsx,.xls"
            :limit="1"
          >
            <el-button type="primary">选择文件</el-button>
            <template #tip>
              <div class="el-upload__tip">
                请上传 .xlsx 或 .xls 格式的Excel文件，文件大小不超过10MB
              </div>
            </template>
          </el-upload>
        </el-form-item>

        <el-form-item label="模块类型" prop="moduleType">
          <el-select v-model="importForm.moduleType" placeholder="请选择模块类型">
            <el-option label="调查问卷" value="survey" />
            <el-option label="考试测评" value="exam" />
            <el-option label="数据采集" value="data_collection" />
            <el-option label="其他" value="other" />
          </el-select>
        </el-form-item>

        <el-form-item label="分组类型" prop="groupType">
          <el-select v-model="importForm.groupType" placeholder="请选择分组类型">
            <el-option label="通用" value="general" />
            <el-option label="医疗" value="medical" />
            <el-option label="教育" value="education" />
            <el-option label="企业" value="enterprise" />
          </el-select>
        </el-form-item>

        <el-form-item label="配置模式" prop="configMode">
          <el-radio-group v-model="importForm.configMode">
            <el-radio label="auto">自动检测</el-radio>
            <el-radio label="simple">简单模式</el-radio>
            <el-radio label="full">完整模式</el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="模块编码" prop="moduleCode">
          <el-input 
            v-model="importForm.moduleCode" 
            placeholder="留空则根据文件名自动生成"
            clearable
          />
        </el-form-item>

        <el-form-item label="模块名称" prop="moduleName">
          <el-input 
            v-model="importForm.moduleName" 
            placeholder="留空则根据文件名自动生成"
            clearable
          />
        </el-form-item>

        <el-form-item label="备注">
          <el-input
            v-model="importForm.remark"
            type="textarea"
            :rows="2"
            placeholder="请输入备注信息"
          />
        </el-form-item>

        <el-form-item>
          <el-button 
            type="primary" 
            :loading="loading" 
            @click="handleImport"
          >
            {{ loading ? '导入中...' : '开始导入' }}
          </el-button>
          <el-button @click="handleReset">重置</el-button>
        </el-form-item>
      </el-form>
    </el-card>

    <!-- 导入结果展示 -->
    <el-card v-if="importResult" class="result-card">
      <template #header>
        <div class="result-header">
          <span>导入结果</span>
          <el-tag :type="importResult.success ? 'success' : 'danger'">
            {{ importResult.success ? '成功' : '失败' }}
          </el-tag>
        </div>
      </template>

      <div class="result-content">
        <el-alert
          :title="importResult.message"
          :type="importResult.success ? 'success' : 'error'"
          :closable="false"
          show-icon
        />

        <div v-if="importResult.success" class="success-details">
          <el-descriptions :column="2" border>
            <el-descriptions-item label="模块编码">
              {{ importResult.moduleCode }}
            </el-descriptions-item>
            <el-descriptions-item label="表名">
              {{ importResult.tableName }}
            </el-descriptions-item>
            <el-descriptions-item label="字段数量">
              {{ importResult.successFields }}/{{ importResult.totalFields }}
            </el-descriptions-item>
            <el-descriptions-item label="数据记录">
              {{ importResult.successRecords }}/{{ importResult.totalRecords }}
            </el-descriptions-item>
            <el-descriptions-item label="导入时间">
              {{ formatTime(importResult.importTime) }}
            </el-descriptions-item>
            <el-descriptions-item label="耗时">
              {{ importResult.costTime }}ms
            </el-descriptions-item>
          </el-descriptions>
        </div>

        <div v-if="importResult.errorMessages && importResult.errorMessages.length > 0" class="error-details">
          <el-alert
            title="错误信息"
            type="warning"
            :closable="false"
            class="error-alert"
          />
          <el-collapse>
            <el-collapse-item title="查看详细错误">
              <ul class="error-list">
                <li v-for="(error, index) in importResult.errorMessages" :key="index">
                  {{ error }}
                </li>
              </ul>
            </el-collapse-item>
          </el-collapse>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive, onMounted } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import ModuleEditDialog from './components/ModuleEditDialog.vue'
import { ModuleConfigApi } from '@/api/queueDB/moduleconfig'
import { useRoute, useRouter } from 'vue-router'
import { importApi, type ExcelImportResultVO } from '@/api/dynamic/import'
import download from '@/utils/download'

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

const importFormRef = ref()
const uploadRef = ref()
const fileList = ref<any[]>([])
const importResult = ref<ExcelImportResultVO | null>(null)

const importForm = reactive({
  file: null as File | null,
  moduleType: 'survey',
  groupType: 'general',
  configMode: 'auto',
  moduleCode: '',
  moduleName: '',
  remark: ''
})

const rules = {
  file: [
    { required: true, message: '请选择Excel文件', trigger: 'change' }
  ],
  moduleType: [
    { required: true, message: '请选择模块类型', trigger: 'change' }
  ]
}

// 文件选择处理
const handleFileChange = (file: any) => {
  importForm.file = file.raw
  // 自动生成模块编码和名称
  if (!importForm.moduleCode) {
    const fileName = file.name.replace(/\.[^/.]+$/, "") // 移除扩展名
    importForm.moduleCode = generateModuleCode(fileName)
  }
  if (!importForm.moduleName) {
    importForm.moduleName = file.name.replace(/\.[^/.]+$/, "")
  }
}

const handleFileRemove = () => {
  importForm.file = null
}

// 生成模块编码
const generateModuleCode = (fileName: string): string => {
  return fileName
    .replace(/[^a-zA-Z0-9\u4e00-\u9fa5]/g, '_')
    .replace(/_+/g, '_')
    .toLowerCase() + '_module'
}

// 下载模板 - 简化版本
const downloadTemplate = async (type: string) => {
  try {
    const data = await importApi.downloadTemplate(type)
    download.excel(data, '模板.xlsx')
    ElMessage.success('模板下载成功')
  } catch (error) {
    console.error('下载模板错误:', error)
    ElMessage.error('模板下载失败')
  }
}

// 执行导入
const handleImport = async () => {
  if (!importFormRef.value) return
  
  await importFormRef.value.validate(async (valid: boolean) => {
    if (!valid) {
      ElMessage.error('请完善表单信息')
      return
    }

    if (!importForm.file) {
      ElMessage.error('请选择Excel文件')
      return
    }

    loading.value = true
    importResult.value = null

    try {
      const formData = new FormData()
      formData.append('file', importForm.file)
      formData.append('moduleType', importForm.moduleType)
      formData.append('groupType', importForm.groupType)
      formData.append('configMode', importForm.configMode)
      formData.append('moduleCode', importForm.moduleCode)
      formData.append('moduleName', importForm.moduleName)
      formData.append('remark', importForm.remark)

      const result = await importApi.importExcel(formData)
      importResult.value = result.data
      
      if (result.data.success) {
        ElMessage.success('导入成功')
      } else {
        ElMessage.error('导入失败: ' + result.data.message)
      }
    } catch (error) {
      console.error('导入错误:', error)
    } finally {
      loading.value = false
    }
  })
}

// 重置表单
const handleReset = () => {
  importFormRef.value?.resetFields()
  uploadRef.value?.clearFiles()
  fileList.value = []
  importResult.value = null
  importForm.file = null
}

// 格式化时间
const formatTime = (time: string) => {
  if (!time) return ''
  return new Date(time).toLocaleString()
}
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