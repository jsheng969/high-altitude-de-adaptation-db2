<template>
  <!-- 试管详情弹窗 -->
  <el-dialog v-model="dialogVisible" width="720px">
    <template #title>
      <div style="text-align: center">试管详情</div>
    </template>

    <div v-if="selectedTube">
      <el-descriptions :column="2" border>
        <el-descriptions-item label="管号">{{ selectedTube.tubeNo }}</el-descriptions-item>
        <el-descriptions-item label="当前状态">
          <el-tag :type="selectedTube.status === 0 ? 'danger' : 'success'">
            {{ selectedTube.status === 0 ? '取出' : '放回' }}
          </el-tag>
        </el-descriptions-item>
        <el-descriptions-item label="样本类型">{{ selectedTube.sampleType }}</el-descriptions-item>
        <el-descriptions-item label="所属人员编号">
          <span 
            style="cursor: pointer; color: #409EFF; text-decoration: underline;"
            @click="handleOperatorIdClick(selectedTube.operatorId, selectedTube.timePoint)"
          >
            {{ selectedTube.operatorId }}
          </span>  
        </el-descriptions-item>
        <el-descriptions-item label="所属盒号">{{ selectedTube.boxNo }}</el-descriptions-item>
        <el-descriptions-item label="所属柜名">{{ selectedTube.freezerNo }}</el-descriptions-item>
        <el-descriptions-item label="总可用次数">{{
          selectedTube.totalCount ? selectedTube.totalCount : 10
        }}</el-descriptions-item>
        <el-descriptions-item label="剩余可用次数">{{
          selectedTube.remainCount != null ? selectedTube.remainCount : 10
        }}</el-descriptions-item>
      </el-descriptions>

      <div style="margin-top: 20px">
        <el-table :data="useRecords" border style="width: 100%">
          <el-table-column type="index" label="序号" width="60" />
          <el-table-column prop="createBy" label="使用者" />
          <el-table-column prop="action" label="行为" />
          <el-table-column prop="createTime" label="时间">
            <template #default="{ row }">
              {{ formatTime(row.createTime) }}
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>
    <div style="text-align: center; margin-top: 20px">
      <el-button v-if="selectedTube?.remainCount!=0" type="primary" @click="handleTakeOut">取出</el-button>
      <el-button type="success" @click="handlePutBack">放回</el-button>
      <!-- 新增 修改按钮 -->
      <el-button type="warning" @click="handleEdit">修改</el-button>
    </div>
  </el-dialog>

  <!-- 放回试管弹窗 -->
  <el-dialog v-model="putBackDialog" title="放回试管" width="400px">
    <el-form :model="putBackForm" :rules="putBackRules" ref="putBackFormRef">
      <el-form-item label="试管号" prop="tubeNo">
        <el-input v-model="putBackForm.tubeNo" placeholder="请输入试管号" clearable />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="putBackDialog = false">取消</el-button>
        <el-button type="primary" @click="confirmPutBack">确定</el-button>
      </span>
    </template>
  </el-dialog>

  <!-- 修改试管信息弹窗 -->
  <el-dialog v-model="editDialog" title="修改试管信息" width="600px">
    <el-form :model="editForm" :rules="editRules" ref="editFormRef" label-width="120px">
      <el-form-item label="管号" prop="tubeNo">
        <el-input v-model="editForm.tubeNo" />
      </el-form-item>
      <el-form-item label="当前状态" prop="status">
        <el-select v-model="editForm.status" placeholder="请选择状态">
          <el-option :value="0" label="取出" />
          <el-option :value="1" label="放回" />
        </el-select>
      </el-form-item>
      <el-form-item label="样本类型" prop="sampleType">
        <el-input v-model="editForm.sampleType" />
      </el-form-item>
      <el-form-item label="所属人员编号" prop="operatorId">
        <el-input v-model="editForm.operatorId" />
      </el-form-item>
      <el-form-item label="所属盒号" prop="boxNo">
        <el-input v-model="editForm.boxNo" />
      </el-form-item>
      <el-form-item label="所属柜名" prop="freezerNo">
        <el-input v-model="editForm.freezerNo" />
      </el-form-item>
      <el-form-item label="总可用次数" prop="totalCount">
        <el-input-number v-model="editForm.totalCount" :min="0" />
      </el-form-item>
      <el-form-item label="剩余可用次数" prop="remainCount">
        <el-input-number v-model="editForm.remainCount" :min="0" />
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="editDialog = false">取消</el-button>
        <el-button type="primary" @click="confirmEdit">保存</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { ref, watch, computed } from 'vue'
import { SampleApi } from '@/api/sample'
import { ElMessage, ElMessageBox } from 'element-plus'
import { useRouter } from 'vue-router'
import { BasicInfoApi } from '@/api/prospective/basicinfo'

interface TubeInfo {
  id: number
  tubeNo: string
  operatorId: string
  sampleType: string
  positionCode: string
  status: number
  boxNo: string
  freezerNo: string
  totalCount?: number
  remainCount?: number
  timePoint?: number
}

interface Props {
  show: boolean
  tube: TubeInfo | null
}

const props = defineProps<Props>()
const emit = defineEmits(['update:show', 'refresh'])

// 控制弹窗显示
const dialogVisible = computed({
  get: () => props.show,
  set: (value) => emit('update:show', value)
})

// 选中的试管信息
const selectedTube = ref<TubeInfo | null>(props.tube)

// 监听props变化
watch(() => props.tube, (newTube) => {
  selectedTube.value = newTube
  if (newTube) {
    fetchUseRecords(newTube.id)
  }
})

// 使用记录
const useRecords = ref<any[]>([])

// 获取使用记录
const fetchUseRecords = async (tubeId: number) => {
  try {
    const tubeDetail = await SampleApi.getSample(tubeId)
    selectedTube.value = tubeDetail
    const res = await SampleApi.getUseRecords(tubeId)
    useRecords.value = res || []
  } catch (error) {
    console.error('获取使用记录失败:', error)
    ElMessage.error('获取使用记录失败')
  }
}

// 取出操作
const handleTakeOut = async () => {
  if (!selectedTube.value) return
  ElMessageBox.confirm('确定要取出该试管吗？', '操作确认', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning',
  }).then(async () => {
    try {
      await SampleApi.takeOut(selectedTube.value!.id)
      ElMessage.success('取出成功')
      await fetchUseRecords(selectedTube.value!.id)
      emit('refresh')
    } catch (error) {
      console.error('取出失败:', error)
      ElMessage.error('取出失败')
    }
  }).catch(() => {
    ElMessage.info('已取消取出操作')
  })
}

// 放回相关变量和方法
const putBackDialog = ref(false)
const putBackFormRef = ref()
const putBackForm = ref({ tubeNo: '' })
const putBackRules = {
  tubeNo: [{ required: true, message: '试管号不能为空', trigger: 'blur' }]
}

const handlePutBack = () => {
  if (!selectedTube.value) return
  putBackForm.value.tubeNo = selectedTube.value.tubeNo || ''
  putBackDialog.value = true
}

const confirmPutBack = async () => {
  if (!putBackFormRef.value) return
  try {
    const valid = await putBackFormRef.value.validate()
    if (!valid) return
    if (!selectedTube.value) {
      ElMessage.error('未找到试管信息')
      return
    }
    await SampleApi.putBack({
      id: selectedTube.value.id,
      tubeNo: putBackForm.value.tubeNo
    })
    ElMessage.success('放回成功')
    putBackDialog.value = false
    await fetchUseRecords(selectedTube.value.id)
    emit('refresh')
  } catch (error) {
    console.error('放回失败:', error)
    ElMessage.error('放回失败，请重试')
  }
}

// 修改相关变量和方法
const editDialog = ref(false)
const editFormRef = ref()
const editForm = ref<TubeInfo>({
  id: 0,
  tubeNo: '',
  operatorId: '',
  sampleType: '',
  positionCode: '',
  status: 1,
  boxNo: '',
  freezerNo: '',
  totalCount: 10,
  remainCount: 10
})

const editRules = {
  tubeNo: [{ required: true, message: '管号不能为空', trigger: 'blur' }],
  status: [{ required: true, message: '状态不能为空', trigger: 'change' }],
  operatorId: [{ required: true, message: '人员编号不能为空', trigger: 'blur' }]
}

const handleEdit = () => {
  if (!selectedTube.value) return
  editForm.value = { ...selectedTube.value }
  editDialog.value = true
}

const confirmEdit = async () => {
  if (!editFormRef.value) return
  try {
    await editFormRef.value.validate()
    await SampleApi.updateSample(editForm.value)
    ElMessage.success('修改成功')
    editDialog.value = false
    await fetchUseRecords(editForm.value.id)
    emit('refresh')
  } catch (error) {
    console.error('修改失败:', error)
    ElMessage.error('修改失败，请重试')
  }
}

// 格式化时间
const formatTime = (time: string | number) => {
  if (!time) return ''
  const date = new Date(time)
  const y = date.getFullYear()
  const m = String(date.getMonth() + 1).padStart(2, '0')
  const d = String(date.getDate()).padStart(2, '0')
  const hh = String(date.getHours()).padStart(2, '0')
  const mm = String(date.getMinutes()).padStart(2, '0')
  const ss = String(date.getSeconds()).padStart(2, '0')
  return `${y}-${m}-${d} ${hh}:${mm}:${ss}`
}

const router = useRouter()

const handleOperatorIdClick = async (operatorId, timePoint) => {
  try {
    let queryParams = {}
    if (operatorId.startsWith('DZQ')) {
      queryParams = { group: 2, code: operatorId, surveyOrExam: 'exam' }
    } else {
      const type = operatorId.substring(0, 3)
      const year = operatorId.substring(3, 5)
      queryParams = {
        group: 1,
        code: operatorId,
        type: parseInt(type),
        year: parseInt(year),
        timePoint: timePoint,
        surveyOrExam: 'exam'
      }
    }
    const data = await BasicInfoApi.getDataByParamPage({
      ...queryParams,
      pageNo: 1,
      pageSize: 1
    })
    if (data.total > 0) {
      router.push({ name: 'prospective', query: queryParams })
    } else {
      ElMessage.warning('未找到对应的前瞻性数据')
    }
  } catch (error) {
    console.error('查询前瞻性数据失败:', error)
    ElMessage.error('查询失败，请稍后重试')
  }
}
</script>
