<template>
  <el-dialog
    v-model="visible"
    :title="dialogTitle"
    width="700px"
    :before-close="handleClose"
  >
    <el-form
      ref="formRef"
      :model="formData"
      :rules="formRules"
      label-width="120px"
    >
      <el-form-item label="所属模块">
        <el-input :model-value="currentModule?.moduleName" disabled />
      </el-form-item>

      <el-form-item label="字段代码" prop="fieldCode">
        <el-input
          v-model="formData.fieldCode"
          placeholder="请输入字段代码"
          :disabled="!!formData.id"
          @blur="validateFieldCode"
        />
        <div class="form-tip">
          唯一标识，只能包含字母、数字、下划线，创建后不可修改
          <span v-if="fieldCodeValidating" style="color: #409EFF;">验证中...</span>
          <span v-if="fieldCodeError" style="color: #F56C6C;">{{ fieldCodeError }}</span>
          <span v-if="fieldCodeValid && !formData.id" style="color: #67C23A;">字段代码格式可用</span>
        </div>
      </el-form-item>

      <el-form-item label="字段显示名" prop="fieldLabel">
        <el-input
          v-model="formData.fieldLabel"
          placeholder="请输入字段显示名"
        />
      </el-form-item>

      <el-row>
        <el-col :span="12">
          <el-form-item label="字段类型" prop="fieldType">
            <el-select
              v-model="formData.fieldType"
              placeholder="请选择字段类型"
              @change="handleFieldTypeChange"
            >
              <el-option label="单行文本" value="input" />
              <el-option label="多行文本" value="textarea" />
              <el-option label="数字" value="number" />
              <el-option label="小数" value="decimal" />
              <el-option label="下拉选择" value="select" />
              <el-option label="多选框" value="checkbox" />
              <el-option label="日期" value="date" />
              <el-option label="日期时间" value="datetime" />
              <el-option label="布尔值" value="boolean" />
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="数据库类型" prop="dataType">
            <el-select
              v-model="formData.dataType"
              placeholder="请选择数据库类型"
            >
              <el-option 
                v-for="type in dataTypeOptions" 
                :key="type.value" 
                :label="type.label" 
                :value="type.value" 
              />
            </el-select>
          </el-form-item>
        </el-col>
      </el-row>

      <el-form-item label="字段长度" prop="fieldLength">
        <el-input-number
          v-model="formData.fieldLength"
          :min="1"
          :max="4000"
          placeholder="请输入字段长度"
        />
        <div class="form-tip">文本类型字段的长度限制</div>
      </el-form-item>

      <el-form-item label="小数位数" prop="decimalScale" v-if="formData.fieldType === 'decimal'">
        <el-input-number
          v-model="formData.decimalScale"
          :min="0"
          :max="10"
          placeholder="请输入小数位数"
        />
      </el-form-item>

      <el-form-item label="默认值" prop="defaultValue">
        <el-input
          v-model="formData.defaultValue"
          placeholder="请输入默认值"
        />
        <div class="form-tip">根据字段类型输入合适的默认值</div>
      </el-form-item>

      <el-form-item label="选项值" prop="optionValues" v-if="['select', 'checkbox'].includes(formData.fieldType)">
        <el-input
          v-model="formData.optionValues"
          type="textarea"
          :rows="3"
          placeholder="请输入选项值，格式：值1:标签1,值2:标签2"
        />
        <div class="form-tip">多个选项用逗号分隔，格式：值:标签，例如：1:是,0:否</div>
      </el-form-item>

      <el-row>
        <el-col :span="12">
          <el-form-item label="是否必填" prop="isRequired">
            <el-radio-group v-model="formData.isRequired">
              <el-radio :label="1">是</el-radio>
              <el-radio :label="0">否</el-radio>
            </el-radio-group>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="排序号" prop="orderNo">
            <el-input-number
              v-model="formData.orderNo"
              :min="0"
              :max="999"
            />
          </el-form-item>
        </el-col>
      </el-row>

      <el-form-item label="状态" prop="status">
        <el-radio-group v-model="formData.status">
          <el-radio :label="1">启用</el-radio>
          <el-radio :label="0">停用</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="字段描述" prop="fieldDesc">
        <el-input
          v-model="formData.fieldDesc"
          type="textarea"
          :rows="2"
          placeholder="请输入字段描述"
        />
      </el-form-item>

      <el-form-item label="验证规则" prop="validationRule">
        <el-input
          v-model="formData.validationRule"
          placeholder="请输入验证规则"
        />
        <div class="form-tip">如：email、phone、custom regex</div>
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
import { ref, reactive, computed, watch, nextTick } from 'vue'
import { ElMessage } from 'element-plus'
import { debounce } from 'lodash-es'
import { FieldConfigApi } from '@/api/queueDB/fieldconfig'

interface Props {
  modelValue: boolean
  data?: any
  moduleCode?: string
}

const props = defineProps<Props>()
const emit = defineEmits(['update:modelValue', 'success'])

const visible = ref(props.modelValue)
const loading = ref(false)
const formRef = ref()
const fieldCodeValidating = ref(false)
const fieldCodeValid = ref(false)
const fieldCodeError = ref('')

// 当前模块信息（可以从store或props获取）
const currentModule = ref({
  moduleCode: props.moduleCode,
  moduleName: '当前模块'
})

// 表单数据
const formData = reactive({
  id: undefined,
  moduleCode: props.moduleCode,
  fieldCode: '',
  fieldLabel: '',
  fieldType: 'input',
  dataType: 'varchar',
  fieldLength: 255,
  decimalScale: 2,
  defaultValue: '',
  optionValues: '',
  isRequired: 0,
  orderNo: 0,
  status: 1,
  fieldDesc: '',
  validationRule: ''
})

// 数据库类型选项
const dataTypeOptions = ref([
  { label: 'VARCHAR', value: 'varchar' },
  { label: 'TEXT', value: 'text' },
  { label: 'INT', value: 'int' },
  { label: 'BIGINT', value: 'bigint' },
  { label: 'DECIMAL', value: 'decimal' },
  { label: 'DATETIME', value: 'datetime' },
  { label: 'DATE', value: 'date' },
  { label: 'TINYINT', value: 'tinyint' }
])

// 字段类型对应的默认数据库类型映射
const fieldTypeToDataType = {
  input: 'varchar',
  textarea: 'text',
  number: 'int',
  decimal: 'decimal',
  select: 'varchar',
  checkbox: 'varchar',
  date: 'date',
  datetime: 'datetime',
  boolean: 'tinyint'
}

// 表单规则
const formRules = {
  fieldCode: [
    { required: true, message: '请输入字段代码', trigger: 'blur' },
    { pattern: /^[a-zA-Z_][a-zA-Z0-9_]*$/, message: '字段代码只能包含字母、数字、下划线', trigger: 'blur' }
  ],
  fieldLabel: [
    { required: true, message: '请输入字段显示名', trigger: 'blur' }
  ],
  fieldType: [
    { required: true, message: '请选择字段类型', trigger: 'change' }
  ],
  dataType: [
    { required: true, message: '请选择数据库类型', trigger: 'change' }
  ]
}

// 计算属性
const dialogTitle = computed(() => {
  return props.data ? '编辑字段' : '新增字段'
})

// 方法
const validateFieldCode = debounce(async () => {
  if (!formData.fieldCode) {
    fieldCodeError.value = '请输入字段代码'
    fieldCodeValid.value = false
    return
  }

  // 验证格式
  const codeRegex = /^[a-zA-Z_][a-zA-Z0-9_]*$/
  if (!codeRegex.test(formData.fieldCode)) {
    fieldCodeError.value = '字段代码只能包含字母、数字、下划线，且不能以数字开头'
    fieldCodeValid.value = false
    return
  }

  // 如果是编辑模式，不验证唯一性
  if (formData.id) {
    fieldCodeError.value = ''
    fieldCodeValid.value = true
    return
  }

  // 验证唯一性（在同一个模块内）
  try {
    fieldCodeValidating.value = true
    console.log('Validating field code:', formData.fieldCode, 'in module:', props.moduleCode);
    
    const response = await FieldConfigApi.checkFieldCode({
        moduleCode: props.moduleCode,
      fieldCode: formData.fieldCode
      
    })
    fieldCodeError.value = ''
    fieldCodeValid.value = true
  } catch (error: any) {
    fieldCodeError.value = error.message || '字段代码已存在'
    fieldCodeValid.value = false
  } finally {
    fieldCodeValidating.value = false
  }
}, 500)

const handleFieldTypeChange = (fieldType: string) => {
  // 根据字段类型自动设置数据库类型
  const dataType = fieldTypeToDataType[fieldType as keyof typeof fieldTypeToDataType]
  if (dataType) {
    formData.dataType = dataType
  }

  // 设置默认长度
  if (fieldType === 'input') {
    formData.fieldLength = 255
  } else if (fieldType === 'textarea') {
    formData.fieldLength = 1000
  } else if (fieldType === 'number') {
    formData.fieldLength = 11
  }
}

const handleSubmit = async () => {
  if (!formRef.value) return
  
  try {
    await formRef.value.validate()
    
    // 验证字段代码
    if (!formData.id && !fieldCodeValid.value) {
      ElMessage.warning('请先验证字段代码')
      return
    }
    
    loading.value = true
    
    // 设置模块代码
    formData.moduleCode = props.moduleCode || ''
    
    const api = formData.id 
      ? FieldConfigApi.updateFieldConfig(formData)
      : FieldConfigApi.createFieldConfig(formData)
    
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

// 监听显示状态
watch(visible, (val) => {
  emit('update:modelValue', val)
})

watch(() => props.modelValue, (val) => {
  visible.value = val
})

// 监听moduleCode变化
watch(() => props.moduleCode, (val) => {
  if (val) {
    formData.moduleCode = val
    currentModule.value.moduleCode = val
  }
})

// 初始化表单数据
watch(() => props.data, (val) => {
  if (val) {
    Object.assign(formData, val)
    fieldCodeValid.value = true // 编辑模式下默认验证通过
  } else {
    // 重置表单
    Object.keys(formData).forEach(key => {
      if (key === 'fieldType') {
        formData[key] = 'input'
      } else if (key === 'dataType') {
        formData[key] = 'varchar'
      } else if (key === 'fieldLength') {
        formData[key] = 255
      } else if (key === 'decimalScale') {
        formData[key] = 2
      } else if (key === 'isRequired') {
        formData[key] = 0
      } else if (key === 'orderNo') {
        formData[key] = 0
      } else if (key === 'status') {
        formData[key] = 1
      } else if (key === 'moduleCode') {
        formData[key] = props.moduleCode || ''
      } else {
        (formData as any)[key] = ''
      }
    })
    formData.id = undefined
    
    // 重置验证状态
    fieldCodeValid.value = false
    fieldCodeError.value = ''
  }
}, { immediate: true })
</script>

<style scoped>
.form-tip {
  font-size: 12px;
  color: #909399;
  margin-top: 4px;
}

:deep(.el-input-number) {
  width: 100%;
}
</style>