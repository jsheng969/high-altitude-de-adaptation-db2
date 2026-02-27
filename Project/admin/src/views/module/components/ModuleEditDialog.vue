<template>
  <el-dialog
    v-model="visible"
    :title="dialogTitle"
    width="600px"
    :before-close="handleClose"
  >
    <el-form
      ref="formRef"
      :model="formData"
      :rules="formRules"
      label-width="100px"
    >
      <el-form-item label="父模块" v-if="parentModule">
        <el-input :model-value="parentModule.moduleName" disabled />
        <div class="form-tip">当前为 {{ getLevelText(parentModule.moduleLevel) }} 模块</div>
      </el-form-item>

      <!-- 主表类型 - 只有一级模块可以设置 -->
      <el-form-item label="主表类型" prop="mainTableType" v-if="!parentModule">
        <el-select v-model="formData.mainTableType" placeholder="请选择主表类型">
          <el-option label="前瞻性队列" value="prospective" />
          <el-option label="回顾性队列" value="retrospective" />
          <el-option label="高原作业能力" value="plateau_ability" />
        </el-select>
        <div class="form-tip">子模块将继承主表类型</div>
      </el-form-item>

      <el-form-item label="模块代码" prop="moduleCode">
        <el-input
          v-model="formData.moduleCode"
          placeholder="请输入模块代码"
          :disabled="!!formData.id"
          @blur="validateModuleCode"
        />
        <div class="form-tip">
          唯一标识，只能包含字母、数字、下划线，创建后不可修改
          <span v-if="moduleCodeValidating" style="color: #409EFF;">验证中...</span>
          <span v-if="moduleCodeError" style="color: #F56C6C;">{{ moduleCodeError }}</span>
          <span v-if="moduleCodeValid && !formData.id" style="color: #67C23A;">模块代码格式可用</span>
        </div>
      </el-form-item>

      <el-form-item label="模块名称" prop="moduleName">
        <el-input
          v-model="formData.moduleName"
          placeholder="请输入模块名称"
        />
      </el-form-item>

      <el-form-item label="模块层级" prop="moduleLevel" v-if="!parentModule">
        <el-select
          v-model="formData.moduleLevel"
          placeholder="请选择模块层级"
        >
          <el-option label="一级模块" :value="1" />
          <el-option label="二级模块" :value="2" />
          <el-option label="三级模块" :value="3" />
        </el-select>
      </el-form-item>

      <el-form-item label="关联字段" prop="joinField">
        <el-input
          v-model="formData.joinField"
          placeholder="请输入关联字段，默认为tjh"
        />
        <div class="form-tip">用于关联各子表的主键字段名</div>
      </el-form-item>

      <el-form-item label="是否叶子节点" prop="isLeaf">
        <el-radio-group v-model="formData.isLeaf">
          <el-radio :label="1">是</el-radio>
          <el-radio :label="0">否</el-radio>
        </el-radio-group>
        <div class="form-tip">叶子节点可以关联字段和表</div>
      </el-form-item>

      <el-form-item label="表名" prop="tableName" v-if="formData.isLeaf === 1">
        <el-input
          v-model="formData.tableName"
          placeholder="请输入表名"
        />
        <div class="form-tip">动态生成的表名，如: dyn_pro_basic</div>
      </el-form-item>

      <el-form-item label="排序号" prop="orderNo">
        <el-input-number
          v-model="formData.orderNo"
          :min="0"
          :max="999"
        />
      </el-form-item>

      <el-form-item label="状态" prop="status">
        <el-radio-group v-model="formData.status">
          <el-radio :label="1">启用</el-radio>
          <el-radio :label="0">停用</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="备注" prop="remark">
        <el-input
          v-model="formData.remark"
          type="textarea"
          :rows="3"
          placeholder="请输入备注信息"
        />
      </el-form-item>
    </el-form>

    <template #footer>
      <el-button @click="handleClose">取消</el-button>
      <el-button type="primary" @click="handleSubmit" :loading="loading">
        确认
      </el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { ref, reactive, computed, watch } from 'vue'
import { ElMessage } from 'element-plus'
import { debounce } from 'lodash-es'
import { ModuleConfigApi } from '@/api/queueDB/moduleconfig'

interface Props {
  modelValue: boolean
  data?: any
  parentModule?: any
}

const props = defineProps<Props>()
const emit = defineEmits(['update:modelValue', 'success'])

const visible = ref(props.modelValue)
const loading = ref(false)
const formRef = ref()
const moduleCodeValidating = ref(false)
const moduleCodeValid = ref(false)
const moduleCodeError = ref('')

// 表单数据 - 删除了moduleType和groupType
const formData = reactive({
  id: undefined,
  parentId: undefined,
  moduleCode: '',
  moduleName: '',
  moduleLevel: 1,
  mainTableType: 'prospective',  // 主表类型
  joinField: 'tjh',               // 关联字段
  isLeaf: 0,
  tableName: '',
  orderNo: 0,
  status: 1,
  remark: ''
})

// 表单规则
const formRules = {
  moduleCode: [
    { required: true, message: '请输入模块代码', trigger: 'blur' },
    { pattern: /^[a-zA-Z_][a-zA-Z0-9_]*$/, message: '模块代码只能包含字母、数字、下划线，且不能以数字开头', trigger: 'blur' }
  ],
  moduleName: [
    { required: true, message: '请输入模块名称', trigger: 'blur' }
  ],
  moduleLevel: [
    { required: true, message: '请选择模块层级', trigger: 'change' }
  ],
  mainTableType: [
    { required: true, message: '请选择主表类型', trigger: 'change' }
  ]
}

// 计算属性
const dialogTitle = computed(() => {
  if (props.data) return '编辑模块'
  if (props.parentModule) return `添加子模块 - ${props.parentModule.moduleName}`
  return '新增模块'
})

// 方法
const validateModuleCode = debounce(async () => {
  if (!formData.moduleCode) {
    moduleCodeError.value = '请输入模块代码'
    moduleCodeValid.value = false
    return
  }

  const codeRegex = /^[a-zA-Z_][a-zA-Z0-9_]*$/
  if (!codeRegex.test(formData.moduleCode)) {
    moduleCodeError.value = '模块代码只能包含字母、数字、下划线，且不能以数字开头'
    moduleCodeValid.value = false
    return
  }

  if (formData.id) {
    moduleCodeError.value = ''
    moduleCodeValid.value = true
    return
  }

  try {
    moduleCodeValidating.value = true
    const response = await ModuleConfigApi.checkModuleCode(formData.moduleCode)
    if (response === true) {
      moduleCodeError.value = '模块代码已存在'
      moduleCodeValid.value = false
    } else {
      moduleCodeError.value = ''
      moduleCodeValid.value = true
    }
  } catch (error: any) {
    moduleCodeError.value = error.message || '验证失败'
    moduleCodeValid.value = false
  } finally {
    moduleCodeValidating.value = false
  }
}, 500)

const handleSubmit = async () => {
  if (!formRef.value) return
  
  try {
    await formRef.value.validate()
    
    if (!formData.id && !moduleCodeValid.value) {
      ElMessage.warning('请先验证模块代码')
      return
    }
    
    loading.value = true
    
    if (props.parentModule) {
      formData.parentId = props.parentModule.id
      formData.moduleLevel = props.parentModule.moduleLevel + 1
      // 子模块继承父模块的主表类型
      if (props.parentModule.mainTableType) {
        formData.mainTableType = props.parentModule.mainTableType
      }
    }
    
    const api = formData.id 
      ? ModuleConfigApi.updateModuleConfig(formData)
      : ModuleConfigApi.createModuleConfig(formData)
    
    await api
    ElMessage.success(formData.id ? '更新成功' : '创建成功')
    emit('success')
    handleClose()
  } catch (error: any) {
    console.error('提交失败:', error)
    ElMessage.error(error.message || '操作失败')
  } finally {
    loading.value = false
  }
}

const handleClose = () => {
  visible.value = false
}

const getLevelText = (level: number) => {
  const texts: any = { 1: '一级', 2: '二级', 3: '三级' }
  return texts[level] || '未知'
}

// 监听显示状态
watch(visible, (val) => {
  emit('update:modelValue', val)
})

watch(() => props.modelValue, (val) => {
  visible.value = val
})

// 初始化表单数据
watch(() => props.data, (val) => {
  if (val) {
    Object.assign(formData, val)
    moduleCodeValid.value = true
  } else {
    Object.keys(formData).forEach(key => {
      if (key === 'moduleLevel') {
        formData[key] = props.parentModule ? props.parentModule.moduleLevel + 1 : 1
      } else if (key === 'orderNo') {
        formData[key] = 0
      } else if (key === 'status') {
        formData[key] = 1
      } else if (key === 'isLeaf') {
        formData[key] = 0
      } else if (key === 'mainTableType') {
        if (props.parentModule?.mainTableType) {
          formData[key] = props.parentModule.mainTableType
        } else {
          formData[key] = 'prospective'
        }
      } else if (key === 'joinField') {
        formData[key] = 'tjh'
      } else {
        (formData as any)[key] = ''
      }
    })
    formData.id = undefined
    formData.parentId = props.parentModule?.id
    
    moduleCodeValid.value = false
    moduleCodeError.value = ''
  }
}, { immediate: true })
</script>

<style scoped>
.form-tip {
  font-size: 12px;
  color: #909399;
  margin-top: 4px;
}
</style>