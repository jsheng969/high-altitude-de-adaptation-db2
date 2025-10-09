<template>
  <el-dialog v-model="localShow" width="608px">
    <template #title>
      <div style="text-align: center">
        {{ title }}
      </div>
    </template>
    <div class="tube-container">
      <div class="col-header-group">
        <div v-for="col in columns" :key="col" class="col-header">
          {{ col }}
        </div>
      </div>
      <div v-for="(row, rowIndex) in rows" :key="rowIndex" style="display: flex">
        <div class="row-header">
          {{ row }}
        </div>
        <div v-for="col in columns" :key="col">
          <el-tooltip placement="top">
            <template #content>
              <div v-if="getTubeInfo(row, col) && getTubeInfo(row, col).timePoint !=5">
                <div>试管编号: {{ getTubeInfo(row, col)?.tubeNo }}</div>
                <div>操作员ID: {{ getTubeInfo(row, col)?.operatorId }}</div>
                <div>样本类型: {{ mappedTypeTitle }}</div>
              </div>
              <div v-else>无数据</div>
            </template>
            <div
              class="circle"
              :style="{ backgroundColor: getTubeColor(getTubeInfo(row, col)) }"
              @click="openTubeDetail(getTubeInfo(row, col))"
            ></div>
          </el-tooltip>
        </div>
        <div class="row-header">
          {{ row }}
        </div>
      </div>
      <div class="col-header-group">
        <div v-for="col in columns" :key="col" class="col-header">
          {{ col }}
        </div>
      </div>
    </div>
  </el-dialog>

  <!-- 使用提取的试管详情组件 -->
  <TubeDetailDialog 
    :show="tubeDetailDialog" 
    :tube="selectedTube"
    @update:show="tubeDetailDialog = $event"
    @refresh="refreshData"
  />
</template>

<script setup lang="ts">
import { ref, watch, onMounted } from 'vue'
import { SampleApi } from '@/api/sample'
import TubeDetailDialog from './TubeDetailDialog.vue'

interface Props {
  show: boolean
  title?: string
  boxNo: string
}

interface TubeInfo {
  id: number
  tubeNo: string
  operatorId: string
  sampleType: string
  positionCode: string
  // 其他字段根据需要添加
}

// 样本类型映射函数
const mapSampleType = (type: string | undefined): string => {
  if (!type) return 'other'
  
  const lowerType = type.toLowerCase()
  
  // 尿液类型
  if (['u', 'u1', 'u2', 'u3'].includes(lowerType)) return 'urine'
  
  // 唾液类型
  if (['t', 't1', 't2', 't3'].includes(lowerType)) return 'saliva'
  
  // 血液类型 - 详细拆分
  if (['s', 's1', 's2', 's3'].includes(lowerType)) return 'blood_serum'      // 血清
  if (['p', 'p1', 'p2', 'p3'].includes(lowerType)) return 'blood_plasma'     // 血浆
  if (['b', 'b1', 'b2', 'b3'].includes(lowerType)) return 'blood_whole'      // 全血
  if (['w', 'w1', 'w2', 'w3'].includes(lowerType)) return 'blood_granulocyte' // 粒细胞
  if (['r', 'r1', 'r2', 'r3'].includes(lowerType)) return 'blood_erythrocyte' // 红细胞
  
  // 其他血液类型（原列表中未明确分类的）
  if (lowerType.startsWith('s') || lowerType.startsWith('p') || 
      lowerType.startsWith('b') || lowerType.startsWith('w') || 
      lowerType.startsWith('r')) {
    return 'blood_other'
  }
  
  // 其他类型
  return 'other'
}

// 颜色映射 - 红色系细分
const colorMap: Record<string, string> = {
  'urine': '#409EFF',           // 蓝色 - 尿液
  'saliva': '#67C23A',          // 绿色 - 唾液
  
  // 红色系 - 血液相关类型
  'blood_serum': '#F56C6C',     // 标准红色 - 血清
  'blood_plasma': '#E64E4E',    // 稍暗红色 - 血浆
  'blood_whole': '#D63C3C',     // 更深红色 - 全血
  'blood_granulocyte': '#FF7875', // 亮红色 - 粒细胞
  'blood_erythrocyte': '#C92C2C', // 深红色 - 红细胞
  'blood_other': '#F89898',     // 浅红色 - 血液其他类型
  
  'other': '#ccc'            // 黄色 - 其他
}

const mappedTypeTitle = ref()

function getTubeColor(tube: TubeInfo | undefined) {
  // 没有数据 → 灰色
  if (!tube) return '#ccc'

  // 没有试管编号 → 灰色
  if (!tube.tubeNo) return '#ccc'

  // 没有数据 → 灰色
  if (tube.status==0) return '#ccc'

  // 没有数据 → 灰色
  if (tube.timePoint==5) return '#ccc'

  // 按 sampleType 映射颜色
  const mappedType = mapSampleType(tube.sampleType)
  if(tube.sampleType=='u' || tube.sampleType=='u1' || tube.sampleType=='u2' || tube.sampleType=='u3'){
    mappedTypeTitle.value='尿液'
  }else if(tube.sampleType=='s' || tube.sampleType=='s1' || tube.sampleType=='s2' || tube.sampleType=='s3'){
    mappedTypeTitle.value='血清'
  }else if(tube.sampleType=='p' || tube.sampleType=='p1' || tube.sampleType=='p2' || tube.sampleType=='p3'){
    mappedTypeTitle.value='血浆'
  }else if(tube.sampleType=='b' || tube.sampleType=='b1' || tube.sampleType=='b2' || tube.sampleType=='b3'){
    mappedTypeTitle.value='全血'
  }else if(tube.sampleType=='w' || tube.sampleType=='w1' || tube.sampleType=='w2' || tube.sampleType=='w3'){
    mappedTypeTitle.value='粒细胞'
  }else if(tube.sampleType=='r' || tube.sampleType=='r1' || tube.sampleType=='r2' || tube.sampleType=='r3'){
    mappedTypeTitle.value='红细胞'
  }else if(tube.sampleType=='t' || tube.sampleType=='t1' || tube.sampleType=='t2' || tube.sampleType=='t3'){
    mappedTypeTitle.value='唾液'
  }else{
    mappedTypeTitle.value='其他'
  }
  if (mappedType && colorMap[mappedType]) {
    return colorMap[mappedType]
  }

  // 没有匹配到 → 默认绿色
  return '#FF0000'
}

const props = defineProps<Props>()
const emit = defineEmits(['update:show'])

const localShow = ref(false)
const columns = ref<string[]>(['1', '2', '3', '4', '5', '6', '7', '8', '9'])
const rows = ref<string[]>(['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'])
const tubeData = ref<TubeInfo[]>([])

const handleBoxClick = async (boxNo: any) => {
  try {
    const res = await SampleApi.getDataByBoxNo({ boxNo: boxNo })
    tubeData.value = res
    
  } catch (error) {
    console.error('获取盒子详情失败:', error)
  }
}

const getTubeInfo = (row: string, col: string): TubeInfo | undefined => {
  const position = `${row}${col}`
  // console.log('查找位置:', position);
  // console.log('tubeData:', tubeData.value);

  return tubeData.value.find((item) => item.positionCode === position)
}

// 在组件挂载时自动执行
onMounted(() => {
  localShow.value = props.show
  handleBoxClick(props.boxNo)
})

watch(
  () => props.show,
  (val) => {
    localShow.value = val
    handleBoxClick(props.boxNo)
  }
)

watch(
  () => props.boxNo,
  (val) => {
    if (val) {
      handleBoxClick(val)
    }
  },
  { immediate: true }
)

watch(localShow, (val) => {
  emit('update:show', val)
})

// 详情页控制
const tubeDetailDialog = ref(false)
const selectedTube = ref<TubeInfo | null>(null)
// const useRecords = ref<any[]>([])

// 打开详情页
const openTubeDetail = async (tube: TubeInfo | undefined) => {
  if (!tube) return
  selectedTube.value = tube
  tubeDetailDialog.value = true
  // if (tube) {
  //   // 拉取使用记录
  //   const res = await SampleApi.getUseRecords(tube.id)
  //   useRecords.value = res || []
  // }
}

// 点击按钮行为
const handleTakeOut = async () => {
  if (!selectedTube.value) return
  await SampleApi.takeOut(selectedTube.value.id)
  selectedTube.value.status = '取出'
  // // 追加记录
  // useRecords.value.unshift({
  //   userName: '当前用户',
  //   action: '取出',
  //   time: new Date().toLocaleString()
  // })
  // 拉取使用记录
  const res = await SampleApi.getUseRecords(selectedTube.value.id)
    useRecords.value = res || []
  // 刷新所有数据 + 更新 selectedTube
  await refreshData()
  
}

// const handlePutBack = async () => {
//   if (!selectedTube.value) return
//   await SampleApi.putBack({ id: selectedTube.value.id, tubeNo: selectedTube.value.tubeNo })
//   selectedTube.value.status = '放回'
//   useRecords.value.unshift({
//     userName: '当前用户',
//     action: '放回',
//     time: new Date().toLocaleString()
//   })
// }

// 新增：放回相关变量
const putBackDialog = ref(false)
const putBackFormRef = ref<FormInstance>()
const putBackForm = ref({
  tubeNo: ''
})
const putBackRules: FormRules = {
  tubeNo: [{ required: true, message: '试管号不能为空', trigger: 'blur' }]
}

const currentTubeId = ref<number | null>(null) // 记录当前操作的试管ID

// 修改handlePutBack方法
const handlePutBack = async () => {
  if (!selectedTube.value) return

  // 记录当前试管ID，并打开放回弹窗
  currentTubeId.value = selectedTube.value.id
  putBackDialog.value = true
}

// 新增：确认放回方法
const confirmPutBack = async () => {
  if (!putBackFormRef.value) return

  // 验证表单
  const valid = await putBackFormRef.value.validate()
  if (!valid) return

  try {
    if (!currentTubeId.value) {
      ElMessage.error('未找到试管信息')
      return
    }

    // 调用放回接口
    await SampleApi.putBack({
      id: currentTubeId.value,
      tubeNo: putBackForm.value.tubeNo
    })

    // 更新界面状态
    if (selectedTube.value) {
      selectedTube.value.status = '放回'
      selectedTube.value.tubeNo = putBackForm.value.tubeNo // 更新试管号
    }

    // // 添加使用记录
    // useRecords.value.unshift({
    //   createTime: '当前用户',
    //   action: '放回',
    //   createTime: new Date().toLocaleString()
    // })
    if (currentTubeId.value) {
    // 拉取使用记录
    const res = await SampleApi.getUseRecords(currentTubeId.value)
    useRecords.value = res || []
  }

    // 关闭弹窗并重置表单
    putBackDialog.value = false
    putBackFormRef.value.resetFields()
    currentTubeId.value = null

    ElMessage.success('放回成功')
    // 刷新所有数据 + 更新 selectedTube
  await refreshData()
  } catch (error) {
    console.error('放回失败:', error)
    ElMessage.error('放回失败，请重试')
  }
}

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

// 提取公共方法
const refreshData = async () => {
  await handleBoxClick(props.boxNo)
  emit('refresh')
  // ✅ 同步更新 selectedTube
  if (selectedTube.value) {
    const latest = tubeData.value.find(t => t.id === selectedTube.value?.id)
    if (latest) {
      selectedTube.value = { ...latest }
    }
  }
}
</script>

<style>
/* 原有样式保持不变 */
.tube-container {
  width: 560px;
  height: 560px;
  border-radius: 4px;
  padding: 18px;
  background: #f2f3f5;
  border: 1px solid rgba(0, 0, 0, 0.1);

  .circle {
    width: 36px;
    height: 36px;
    border-radius: 50%;
    background-color: #ccc;
    margin: 8px;
    cursor: pointer;
  }

  .row-header {
    width: 36px;
    height: 36px;
    margin: 8px 0;
    user-select: none;
    font-weight: bold;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .col-header-group {
    display: flex;
    justify-content: center;
  }

  .col-header {
    width: 36px;
    height: 27px;
    margin: 0 8px;
    text-align: center;
    user-select: none;
    display: flex;
    align-items: center;
    justify-content: center;
    font-weight: bold;
  }
}
</style>
