<template>
  <el-dialog v-model="visible" title="高级筛选" width="900px" :before-close="handleClose">
    <div style="display: flex; height: 400px">
      <!-- 左侧：动态导航（支持二/三级） -->
      <div style="width: 220px; border-right: 1px solid #eee; padding-right: 8px; overflow-y: auto">
        <el-menu :default-openeds="openedGroups" class="el-menu-vertical-demo" unique-opened>
          <el-sub-menu v-for="(subGroups, group) in groupedFields" :key="group" :index="group">
            <template #title>{{ group }}</template>

            <template v-for="(subGroupData, subGroup) in subGroups" :key="subGroup">
              <!-- 三级结构（当子组的值是对象且不是数组时） -->
              <el-sub-menu v-if="isThirdLevelGroup(subGroupData)" :index="`${group}::${subGroup}`">
                <template #title>{{ subGroup }}</template>
                <el-menu-item
                  v-for="(fields, thirdGroup) in subGroupData"
                  :key="thirdGroup"
                  :index="`${group}::${subGroup}::${thirdGroup}`"
                  @click="selectGroup(group, subGroup, thirdGroup)"
                >
                  {{ thirdGroup }}
                </el-menu-item>
              </el-sub-menu>

              <!-- 二级结构（当子组的值是数组时） -->
              <el-menu-item
                v-else
                :index="`${group}::${subGroup}`"
                @click="selectGroup(group, subGroup)"
              >
                {{ subGroup }}
              </el-menu-item>
            </template>
          </el-sub-menu>
        </el-menu>
      </div>

      <!-- 右侧：字段列表 -->
      <div style="flex: 1; padding-left: 16px; overflow-y: auto">
        <el-table
          :data="currentGroupFields"
          height="100%"
          @row-click="handleFieldClick"
          highlight-current-row
          size="small"
        >
          <el-table-column prop="label" label="字段名" />
        </el-table>
      </div>
    </div>
    <div
      style="
        margin-top: 40px;
        padding-top: 16px;
        border-top: 2px solid #dcdfe6;
        background-color: #f9fafc;
        border-radius: 4px;
      "
    >
      <div
        style="
          font-weight: 600;
          font-size: 14px;
          color: #606266;
          margin-left: 20px;
          margin-bottom: 12px;
        "
      >
        已选条件
      </div>
      <!-- 条件编辑区域（保持不变） -->
      <div
        v-for="(item, index) in selectedFields"
        :key="item.prop"
        style="display: flex; align-items: center; margin-left: 20px; margin-top: 8px"
      >
        <div style="width: 80px; margin-right: 8px" v-if="index === 0"></div>
        <el-select
          v-else
          v-model="item.logic"
          placeholder="逻辑"
          style="width: 80px; margin-right: 8px"
        >
          <el-option label="AND" value="AND" />
          <el-option label="OR" value="OR" />
          <el-option label="NOT" value="NOT" />
        </el-select>
        <el-tag style="width: 160px" type="info">{{ item.label }}</el-tag>
        <!-- 根据字段做不同显示 -->
        <template v-if="item.prop == 'gender'">
          <el-select
            v-model="item.value"
            placeholder="请选择"
            style="width: 160px; margin-left: 8px"
          >
            <el-option label="男" value="男" />
            <el-option label="女" value="女" />
          </el-select>
        </template>
        <template v-else-if="item.prop == 'actualAge'">
          <el-input
            v-model="item.min"
            placeholder="最小值"
            style="width: 100px; margin-right: 8px"
            type="number"
            @change="(val) => handleSelectChange(val, item, 'actualAge')"
          />
          <span>到</span>
          <el-input
            v-model="item.max"
            placeholder="最大值"
            style="width: 100px; margin-left: 8px"
            type="number"
            @change="(val) => handleSelectChange(val, item, 'actualAge')"
          />
        </template>
        <template
          v-else-if="
            item.prop.startsWith('experimentSurveyStationTrainingInfoRespVO.missionPointAltitude')
          "
        >
          <el-input
            v-model="item.min"
            placeholder="最小值"
            style="width: 100px; margin-right: 8px"
            type="number"
            @change="(val) => handleSelectChange(val, item, 'missionPointAltitude')"
          />
          <span>到</span>
          <el-input
            v-model="item.max"
            placeholder="最大值"
            style="width: 100px; margin-left: 8px"
            type="number"
            @change="(val) => handleSelectChange(val, item, 'missionPointAltitude')"
          />
        </template>
        <template
          v-else-if="
            item.prop == 'experimentSurveyStationTrainingInfoRespVO.plateauTrainingDuration'
          "
        >
          <el-input
            v-model="item.min"
            placeholder="最小值"
            style="width: 100px; margin-right: 8px"
            type="number"
            @change="(val) => handleSelectChange(val, item, 'plateauTrainingDuration')"
          />
          <span>到</span>
          <el-input
            v-model="item.max"
            placeholder="最大值"
            style="width: 100px; margin-left: 8px"
            type="number"
            @change="(val) => handleSelectChange(val, item, 'plateauTrainingDuration')"
          />
        </template>
        <template
          v-else-if="
            item.prop == 'experimentSurveyMissionProgressSurveyRespVO.plateauMissionDuration'
          "
        >
          <el-input
            v-model="item.min"
            placeholder="最小值"
            style="width: 100px; margin-right: 8px"
            type="number"
            @change="(val) => handleSelectChange(val, item, 'plateauMissionDuration')"
          />
          <span>到</span>
          <el-input
            v-model="item.max"
            placeholder="最大值"
            style="width: 100px; margin-left: 8px"
            type="number"
            @change="(val) => handleSelectChange(val, item, 'plateauMissionDuration')"
          />
        </template>
        <template v-else-if="item.prop == 'basicOtherInfoRespVO.ethnicity'">
          <el-select
            v-model="item.value"
            placeholder="请选择"
            style="width: 160px; margin-left: 8px"
          >
            <el-option label="汉族" value="汉族" />
            <el-option label="其他" value="其他" />
          </el-select>
        </template>
        <template v-else-if="item.prop == 'totalScoreType'">
          <el-select v-model="item.value" placeholder="请选评分类型" clearable class="!w-240px">
            <el-option label="阴" value="1" />
            <el-option label="轻" value="2" />
            <el-option label="中" value="3" />
            <el-option label="重" value="4" />
          </el-select>
        </template>
        <template v-else-if="item.prop == 'conversionType'">
          <el-select v-model="item.value" placeholder="请选择转归类型" clearable class="!w-240px">
            <el-option label="持续重度" value="1" />
            <el-option label="持续阴性" value="2" />
            <el-option label="持续阳性" value="3" />
            <el-option label="阴性转阳性" value="4" />
            <el-option label="阳性转阴性" value="5" />
            <el-option label="转为重度" value="6" />
          </el-select>
        </template>
        <template v-else-if="item.prop.startsWith('experimentSurveyPostReturnSymptomsRespVO') && !item.prop.endsWith('Duration') && item.prop != 'experimentSurveyPostReturnSymptomsRespVO.otherSymptoms'">
          <el-select v-model="item.value" placeholder="请选评分类型" clearable class="!w-240px" multiple>
            <el-option label="0" value="0" />
            <el-option label="1" value="1" />
            <el-option label="2" value="2" />
            <el-option label="3" value="3" />
          </el-select>
        </template>
        <template v-else>
          <el-select
            v-model="item.operator"
            placeholder="条件符"
            style="width: 100px; margin-left: 8px"
          >
            <el-option label="等于" value="=" />
            <el-option label="大于" value=">" />
            <el-option label="小于" value="<" />
          </el-select>
          <el-input v-model="item.value" placeholder="值" style="width: 160px; margin-left: 8px" />
        </template>
        <el-button type="danger" @click="removeField(index)" style="margin-left: 8px">
          <Icon icon="ep:delete" />
        </el-button>
      </div>
    </div>

    <template #footer>
      <el-button @click="handleClose">取消</el-button>
      <el-button type="primary" @click="confirmSelection">确认</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { ref, computed, watch } from 'vue'

const props = defineProps({
  modelValue: Boolean,
  groupedFields: Object as PropType<Record<string, any>>
})
const emit = defineEmits(['update:modelValue', 'confirm'])

const visible = ref(props.modelValue)
watch(
  () => props.modelValue,
  (val) => (visible.value = val)
)
watch(visible, (val) => emit('update:modelValue', val))

const openedGroups = ref(Object.keys(props.groupedFields || {}))
const activeGroup = ref('')
const activeSubGroup = ref('')
const activeThirdGroup = ref('')
const selectedFields = ref<TableFieldWithCondition[]>([])

interface TableField {
  label: string
  prop: string
}
interface TableFieldWithCondition extends TableField {
  operator?: string
  value?: string
  logic?: string
}

// 判断是否是三级结构（子组的值是对象且不是数组）
const isThirdLevelGroup = (subGroupData: any) => {
  return typeof subGroupData === 'object' && !Array.isArray(subGroupData)
}

const selectGroup = (group: string, subGroup: string, thirdGroup?: string) => {
  activeGroup.value = group
  activeSubGroup.value = subGroup
  activeThirdGroup.value = thirdGroup || ''
}

const currentGroupFields = computed(() => {
  if (!activeGroup.value || !activeSubGroup.value) return []

  const groupData = props.groupedFields[activeGroup.value]
  if (!groupData) return []

  const subGroupData = groupData[activeSubGroup.value]
  if (!subGroupData) return []

  // 如果是三级结构
  if (activeThirdGroup.value && isThirdLevelGroup(subGroupData)) {
    return subGroupData[activeThirdGroup.value] || []
  }

  // 如果是二级结构
  return Array.isArray(subGroupData) ? subGroupData : []
})

const handleFieldClick = (row: TableField) => {
  if (!selectedFields.value.some((item) => item.prop === row.prop)) {
    selectedFields.value.push({
      ...row,
      operator: '=',
      value: '',
      logic: selectedFields.value.length === 0 ? undefined : 'AND'
    })
  }
}

const removeField = (index: number) => {
  selectedFields.value.splice(index, 1)
}

const serviceTimeOptions = [
  { label: '小于10年', value: '1' },
  { label: '10-15年', value: '2' },
  { label: '大于15年', value: '3' }
]

const framinghamRiskTypeOptions = [
  { label: '低风险', value: 'low' },
  { label: '中风险', value: 'medium' },
  { label: '高风险', value: 'high' }
]

const residenceAreaOptions = [
  { label: '成都', value: 'chengdu' },
  { label: '昆明', value: 'kunming' },
  { label: '西宁', value: 'xining' },
  { label: '其他', value: 'otherArea' }
]

const handleSelectChange = (val, item, type) => {
  if (type === 'actualAge' || type === 'missionPointAltitude' || type === 'plateauTrainingDuration' || type === 'plateauMissionDuration') {
    item.operator = '为'
    if (
      item.min != undefined &&
      item.min != '' &&
      item.min != null &&
      item.max != undefined &&
      item.max != '' &&
      item.max != null
    ) {
      item.labelText = `>=${item.min} 并且 <${item.max}`
    } else if (
      (item.min == undefined || item.min == '' || item.min == null) &&
      item.max != undefined &&
      item.max != '' &&
      item.max != null
    ) {
      item.labelText = `<${item.max}`
    } else if (
      item.min != undefined &&
      item.min != '' &&
      item.min != null &&
      (item.max == undefined || item.max == '' || item.max == null)
    ) {
      item.labelText = `>=${item.min}`
    } else {
      item.operator = ''
      item.labelText = null
    }
  }
  // if(item.prop.startsWith('experimentSurveyPostReturnSymptomsRespVO') 
  //            && !item.prop.endsWith('Duration')
  //            && item.prop != 'experimentSurveyPostReturnSymptomsRespVO.otherSymptoms'){
              
  //            }
  // if (type === 'serviceTime') {
  //   const found = serviceTimeOptions.find((opt) => opt.value === val)
  //   if (found) item.labelText = found.label
  // }
  // if (type === 'framinghamRiskType') {
  //   const found = framinghamRiskTypeOptions.find((opt) => opt.value === val)
  //   if (found) item.labelText = found.label
  // }
  // if (type === 'residenceArea') {
  //   const labels = residenceAreaOptions // 从选项表中过滤出匹配项
  //     .filter((opt) => Array.isArray(val) && val.includes(opt.value))
  //     .map((opt) => opt.label)

  //   if (labels.length) {
  //     item.labelText = labels.join('、') // 多选时用顿号连接
  //   } else {
  //     item.labelText = '' // 没匹配到时设为空，可按需调整
  //   }
  // }
}
const buildAdvancedQueryConditions = () => {
  return selectedFields.value.map((item, index) => ({
    logic: index === 0 ? 'AND' : item.logic || 'AND',
    label: item.label,
    field: item.prop,
    operator: item.operator,
    value:
      item.prop.startsWith('experimentSurveyStationTrainingInfoRespVO.missionPointAltitude') ||
      item.prop == 'actualAge'
      || item.prop == 'experimentSurveyStationTrainingInfoRespVO.plateauTrainingDuration'
      || item.prop == 'experimentSurveyMissionProgressSurveyRespVO.plateauMissionDuration'
        ? item.min + ',' + item.max
        : item.value,
    displayText: item.labelText || item.value
  }))
}

const confirmSelection = () => {
  const conditions = buildAdvancedQueryConditions()
  emit('confirm', conditions) // ✅ 通过 emit 返回条件数据
  visible.value = false
}

const handleClose = () => {
  visible.value = false
}
</script>
