<template>
  <div class="module-management">
    <!-- 搜索和操作栏 -->
    <div class="header-operation">
      <!-- <el-form :inline="true" :model="queryParams">
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
        <el-form-item label="主表类型">
          <el-select v-model="queryParams.moduleCode" placeholder="请选择主表类型" clearable>
            <el-option label="前瞻性队列" value="prospective" />
            <el-option label="回顾性队列" value="retrospective" />
            <el-option label="高原作业能力" value="plateau_ability" />
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
      </el-form> -->

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
        <el-table-column prop="moduleCode" label="模块代码" width="300" />
        <el-table-column prop="moduleName" label="模块名称" width="200" />
        <el-table-column prop="moduleCode" label="主表类型" width="150">
          <template #default="{ row }">
            <el-tag :type="getMainTableTypeTagType(row.moduleCode)">
              {{ getMainTableTypeText(row.moduleCode) }}
            </el-tag>
          </template>
        </el-table-column>
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
        <!-- <el-table-column prop="tableName" label="对应表名" width="200" /> -->
        <el-table-column prop="joinField" label="关联字段" width="100">
          <template #default="{ row }">
            {{ row.joinField || 'tjh' }}
          </template>
        </el-table-column>
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

        <!-- 主表配置卡片 -->
        <el-card class="main-table-config" shadow="never" style="margin-bottom: 20px;">
          <template #header>
            <div class="card-header">
              <span>主表配置</span>
              <!-- <el-tag type="info">可自定义主表类型</el-tag> -->
            </div>
          </template>

          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item 
                label="类型" 
                prop="presetType"
              >
                <el-select 
                  v-model="importForm.presetType" 
                  placeholder="请选择预设类型"
                  @change="handlePresetTypeChange"
                  style="width: 100%"
                >
                  <el-option label="前瞻性队列" value="prospective" />
                  <el-option label="回顾性队列" value="retrospective" />
                  <el-option label="高原作业能力" value="plateau_ability" />
                </el-select>
                <div class="form-tip">选择预设类型将自动填充下方字段</div>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item label="主表类型标识" prop="moduleCode">
                <el-input 
                  v-model="importForm.moduleCode" 
                  placeholder="请输入主表类型标识，如：prospective"
                  clearable
                >
                  <template #append>
                    <el-tooltip content="将用于生成表名 dyn_xxx" placement="top">
                      <el-icon><InfoFilled /></el-icon>
                    </el-tooltip>
                  </template>
                </el-input>
                <div class="form-tip">表名将自动生成为：dyn_{{ importForm.moduleCode || '类型标识' }}</div>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="主表显示名称" prop="moduleName">
                <el-input 
                  v-model="importForm.moduleName" 
                  placeholder="请输入主表显示名称，如：前瞻性队列数据库"
                  clearable
                />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item label="关联字段" prop="joinField">
                <el-input 
                  v-model="importForm.joinField" 
                  placeholder="请输入关联字段，如：tjh"
                  clearable
                />
                <div class="form-tip">用于关联各子表的主键字段名</div>
              </el-form-item>
            </el-col>
          </el-row>
        </el-card>

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
            <el-descriptions-item label="主表类型">
              {{ getMainTableTypeText(importResult.moduleCode) }}
            </el-descriptions-item>
            <el-descriptions-item label="表名">
              {{ importResult.tableName }}
            </el-descriptions-item>
            <el-descriptions-item label="关联字段">
              {{ importResult.joinField || 'tjh' }}
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
import { InfoFilled } from '@element-plus/icons-vue'
import ModuleEditDialog from './components/ModuleEditDialog.vue'
import { ModuleConfigApi } from '@/api/queueDB/moduleconfig'
import { useRouter } from 'vue-router'
import { importApi, type ExcelImportResultVO } from '@/api/dynamic/import'
import download from '@/utils/download'

// 响应式数据
const loading = ref(false)
const moduleTree = ref<any[]>([])
const queryParams = reactive({
  moduleName: '',
  moduleLevel: undefined,
  moduleCode: undefined
})

const editDialog = reactive({
  visible: false,
  data: null,
  parentModule: null
})

// 导入表单
const importFormRef = ref()
const uploadRef = ref()
const fileList = ref<any[]>([])
const importResult = ref<ExcelImportResultVO | null>(null)

const importForm = reactive({
  file: null as File | null,
  // 主表类型相关字段
  presetType: 'prospective', // 添加presetType字段，默认选择前瞻性队列
  moduleCode: 'prospective',
  moduleName: '前瞻性队列数据库',
  joinField: 'tjh',
  autoCreateMainTable: true
})

const rules = {
  file: [
    { required: true, message: '请选择Excel文件', trigger: 'change' }
  ],
  presetType: [ // 常用类型必填验证
    { required: true, message: '请选择常用类型', trigger: 'change' }
  ],
  moduleCode: [
    { required: true, message: '请输入主表类型标识', trigger: 'blur' }
  ],
  moduleName: [
    { required: true, message: '请输入主表显示名称', trigger: 'blur' }
  ],
  joinField: [ // 关联字段必填验证
    { required: true, message: '请输入关联字段', trigger: 'blur' }
  ]
}

// 方法
const loadModuleTree = async () => {
  try {
    loading.value = true
    const response = await ModuleConfigApi.getModuleTreeWithStats({
      params: queryParams
    })
    
    console.log('原始数据:', response) // 查看数据结构
    
    // 检查返回的数据是否是扁平结构（包含parentId字段）
    if (response && Array.isArray(response) && response.length > 0) {
      // 构建树形结构
      const buildTree = (items, parentId = null) => {
        const tree = []
        items.forEach(item => {
          // 注意：数据库中使用的是 NULL 作为根节点，所以需要处理 null 的情况
          if ((item.parentId === parentId) || 
              (parentId === null && (item.parentId === null || item.parentId === undefined))) {
            const children = buildTree(items, item.id)
            if (children.length > 0) {
              item.children = children
            }
            tree.push({...item}) // 创建副本避免引用问题
          }
        })
        return tree
      }
      
      // 将扁平数据转换为树形结构
      moduleTree.value = buildTree(response, null)
      console.log('构建后的树:', moduleTree.value)
    } else {
      moduleTree.value = response
    }
    
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

const router = useRouter()
const handleViewFields = (module: any) => {
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
    moduleLevel: undefined,
    moduleCode: undefined
  })
  loadModuleTree()
}

const handleEditSuccess = () => {
  editDialog.visible = false
  loadModuleTree()
}

// 预设类型变化处理
const handlePresetTypeChange = (val: string) => {
  if (val === 'prospective') {
    importForm.moduleCode = 'prospective'
    importForm.moduleName = '前瞻性队列数据库'
    importForm.joinField = 'tjh'
  } else if (val === 'retrospective') {
    importForm.moduleCode = 'retrospective'
    importForm.moduleName = '回顾性队列数据库'
    importForm.joinField = 'tjh'
  } else if (val === 'plateau_ability') {
    importForm.moduleCode = 'plateau_ability'
    importForm.moduleName = '高原作业能力分析'
    importForm.joinField = 'tjh'
  }
}

// 文件选择处理
const handleFileChange = (file: any) => {
  importForm.file = file.raw
}

const handleFileRemove = () => {
  importForm.file = null
}

// 下载模板
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
      
      // 主表类型相关
      formData.append('moduleCode', importForm.moduleCode)
      formData.append('moduleName', importForm.moduleName)
      formData.append('joinField', importForm.joinField)
      formData.append('autoCreateMainTable', String(importForm.autoCreateMainTable))

      const response = await importApi.importExcel(formData)
      const result = response
      importResult.value = result
      
      // 根据成功记录数显示不同的提示
      if (result.success) {
        // 后端返回success=true的情况
        if (result.successRecords === result.totalRecords) {
          // 全部成功
          ElMessage.success(`导入成功：全部${result.totalRecords}条数据导入成功`)
        } else if (result.successRecords > 0) {
          // 部分成功
          ElMessage.warning(`导入完成：成功${result.successRecords}条，跳过${result.totalRecords - result.successRecords}条`)
        } else {
          // 0条成功（虽然success=true，但没有成功数据）
          ElMessage.info(`导入完成：没有数据被导入，请检查数据格式`)
        }
        // 无论部分成功还是全部成功，都刷新模块列表
        loadModuleTree()
      } else {
        // 后端返回success=false的情况（系统错误或全部失败）
        if (result.errorMessages && result.errorMessages.length > 0) {
          // 显示前3条错误信息
          const errors = result.errorMessages.slice(0, 3).join('；')
          ElMessage.error(`导入失败：${errors}${result.errorMessages.length > 3 ? '...' : ''}`)
        } else {
          ElMessage.error('导入失败：' + (result.message || '未知错误'))
        }
      }
    } catch (error) {
      console.error('导入错误:', error)
      ElMessage.error('导入失败：网络错误或服务器异常')
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
  importForm.presetType = 'prospective' // 重置为默认值
  importForm.moduleCode = 'prospective'
  importForm.moduleName = '前瞻性队列数据库'
  importForm.joinField = 'tjh'
  importForm.autoCreateMainTable = true
}

// 标签样式函数
const getLevelTagType = (level: number) => {
  const types: any = { 1: 'danger', 2: 'warning', 3: 'success' }
  return types[level] || 'info'
}

const getLevelText = (level: number) => {
  const texts: any = { 1: '一级', 2: '二级', 3: '三级' }
  return texts[level] || '未知'
}

const getMainTableTypeTagType = (type: string) => {
  const types: any = {
    'prospective': 'primary',
    'retrospective': 'success',
    'plateau_ability': 'warning'
  }
  return types[type] || 'info'
}

const getMainTableTypeText = (type: string) => {
  if (!type) return '未知'
  const texts: any = {
    'prospective': '前瞻性队列',
    'retrospective': '回顾性队列',
    'plateau_ability': '高原作业能力'
  }
  return texts[type] || type
}

// 格式化时间
const formatTime = (time: string) => {
  if (!time) return ''
  return new Date(time).toLocaleString()
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

.form-tip {
  font-size: 12px;
  color: #909399;
  margin-top: 4px;
}

.import-card,
.result-card {
  margin-top: 20px;
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.main-table-config {
  margin-bottom: 20px;
  border: 1px solid #ebeef5;
}

.main-table-config :deep(.el-card__header) {
  padding: 12px 20px;
  background-color: #f5f7fa;
}

.ml-2 {
  margin-left: 8px;
}

.result-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.success-details {
  margin-top: 16px;
}

.error-details {
  margin-top: 16px;
}

.error-alert {
  margin-bottom: 8px;
}

.error-list {
  margin: 0;
  padding-left: 20px;
  color: #f56c6c;
}

.error-list li {
  margin: 4px 0;
}
</style>