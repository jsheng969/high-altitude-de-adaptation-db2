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
        <template v-else-if="item.prop.startsWith('experimentSurveyServiceInfoRespVO.altitude')">
          <el-input
            v-model="item.min"
            placeholder="最小值"
            style="width: 100px; margin-right: 8px"
            type="number"
          />
          <span>到</span>
          <el-input
            v-model="item.max"
            placeholder="最大值"
            style="width: 100px; margin-left: 8px"
            type="number"
          />
        </template>
        <template v-else-if="item.prop.startsWith('serviceTime')">
          <el-select
            v-model="item.value"
            placeholder="请选择服役年限"
            clearable
            class="!w-240px"
            @change="(val) => handleSelectChange(val, item, 'serviceTime')"
          >
            <el-option label="小于10年" value="1" />
            <el-option label="10~15年" value="2" />
            <el-option label="大于15年" value="3" />
          </el-select>
        </template>
        <template v-else-if="item.prop === 'residenceArea'">
          <el-select
            v-model="item.value"
            multiple
            placeholder="请选择疾病"
            style="width: 240px; margin-left: 8px"
            @change="(val) => handleSelectChange(val, item, 'residenceArea')"
          >
            <el-option label="成都" value="chengdu" />
            <el-option label="昆明" value="kunming" />
            <el-option label="西宁" value="xining" />
            <el-option label="其他" value="otherArea" />
          </el-select>
        </template>
        <template
          v-else-if="
            item.prop === 'highlandDiseasesDuringService' || item.prop === 'newDiseasesPostReturn'
          "
        >
          <el-select
            v-model="item.value"
            multiple
            placeholder="请选择疾病"
            style="width: 240px; margin-left: 8px"
          >
            <el-option label="高血压" value="hypertension" />
            <el-option label="心肌梗死" value="myocardialInfarction" />
            <el-option label="冠心病" value="coronaryHeartDisease" />
            <el-option label="肺心病" value="pulmonaryHeartDisease" />
            <el-option label="四肢静脉血栓" value="lowerExtremityVenousThrombosis" />
            <el-option label="窦性心动过缓" value="bradycardia" />
            <el-option label="窦性心动过速" value="tachycardia" />
            <el-option label="窦性心律不齐" value="arrhythmia" />
            <el-option label="房颤" value="atrialFibrillation" />
            <el-option label="阵发性室上速" value="paroxysmalAuricularTachycardia" />
            <el-option label="频发房性早搏" value="frequentPrematureAtrialContractions" />
            <el-option label="频发室性早搏" value="frequentPrematureVentricularContractions" />
            <el-option label="房室传导阻滞" value="avBlock" />
            <el-option label="室性心动过速" value="ventricularTachycardia" />
            <el-option label="其他" value="otherDiseases1" />
            <el-option label="眩晕" value="dizziness" />
            <el-option label="短暂性脑缺血" value="transientIschemicAttack" />
            <el-option label="脑梗死/脑血栓" value="cerebralInfarction" />
            <el-option label="脑出血" value="cerebralHemorrhage" />
            <el-option label="其他" value="otherDiseases2" />
            <el-option label="高血脂" value="hyperlipidemia" />
            <el-option label="糖尿病" value="diabetes" />
            <el-option label="高尿酸血症（痛风）" value="gout" />
            <el-option label="甲状腺疾病" value="thyroidDisease" />
            <el-option label="其他" value="otherDiseases3" />
            <el-option label="失眠" value="insomnia" />
            <el-option label="肿瘤" value="tumor" />
            <el-option label="其他" value="otherDiseases4" />
          </el-select>
        </template>
        <template
          v-else-if="
            item.prop == 'controlSurveyPastDiseasesRespVO.disease1Diagnosed' ||
            item.prop == 'controlSurveyPastDiseasesRespVO.disease2Diagnosed' ||
            item.prop == 'controlSurveyPastDiseasesRespVO.disease3Diagnosed' ||
            item.prop == 'controlSurveyPastDiseasesRespVO.disease4Diagnosed' ||
            item.prop == 'controlSurveyPastDiseasesRespVO.disease5Diagnosed' ||
            item.prop == 'controlSurveyPastDiseasesRespVO.disease6Diagnosed'
          "
        >
          <el-select
            v-model="item.value"
            placeholder="请选择"
            style="width: 160px; margin-left: 8px"
          >
            <el-option label="是" value="1" />
            <el-option label="否" value="0" />
          </el-select>
        </template>
        <template v-else-if="item.prop.startsWith('diseaseSpectrumDigestiveSystem')">
          <el-select
            v-model="item.value"
            multiple
            placeholder="请选择疾病"
            style="width: 240px; margin-left: 8px"
          >
            <el-option label="脂肪肝" value="fattyLiver" />
            <el-option label="肝囊肿" value="hepaticCyst" />
            <el-option label="胆囊息肉" value="gallbladderPolyp" />
            <el-option label="胆囊结石" value="gallbladderStone" />
            <el-option label="肝血管瘤" value="hepaticHemangioma" />
            <el-option label="脾大" value="splenomegaly" />
            <el-option label="慢性胃炎" value="chronicGastritis" />
            <el-option label="肠息肉" value="intestinalPolyp" />
            <el-option label="阑尾炎" value="appendicitis" />
            <el-option label="急性胰腺炎" value="acutePancreatitis" />
            <el-option label="消化道溃疡" value="digestiveUlcer" />
            <el-option label="消化道出血" value="digestiveBleeding" />
          </el-select>
        </template>
        <template v-else-if="item.prop.startsWith('diseaseSpectrumCardiovascularSystem')">
          <el-select
            v-model="item.value"
            multiple
            placeholder="请选择疾病"
            style="width: 240px; margin-left: 8px"
          >
            <el-option label="高血压" value="hypertension" />
            <el-option label="窦性心动过缓" value="bradycardia" />
            <el-option label="短暂性脑缺血" value="transientIschemicAttack" />
            <el-option label="窦性心动过速" value="tachycardia" />
            <el-option label="脑梗死/脑血栓" value="cerebralInfarction" />
            <el-option label="频发房性早搏" value="frequentPrematureAtrialContractions" />
            <el-option label="频发室性早搏" value="frequentPrematureVentricularContractions" />
            <el-option label="冠心病" value="coronaryHeartDisease" />
            <el-option label="房颤" value="atrialFibrillation" />
            <el-option label="心肌梗死" value="myocardialInfarction" />
          </el-select>
        </template>
        <template v-else-if="item.prop.startsWith('diseaseSpectrumEndocrineSystem')">
          <el-select
            v-model="item.value"
            multiple
            placeholder="请选择疾病"
            style="width: 240px; margin-left: 8px"
          >
            <el-option label="高甘油三酯血症" value="hypertriglyceridemia" />
            <el-option label="低密度脂蛋白胆固醇增多症" value="highLdl" />
            <el-option label="高密度脂蛋白胆固醇增多症" value="highHdl" />
            <el-option label="高尿酸血症" value="hyperuricemia" />
            <el-option label="高胆固醇血症" value="hypercholesterolemia" />
            <el-option label="糖尿病" value="diabetes" />
            <el-option label="甲状腺疾病" value="thyroidDisease" />
          </el-select>
        </template>
        <template v-else-if="item.prop.startsWith('diseaseSpectrumRespiratorySystem')">
          <el-select
            v-model="item.value"
            multiple
            placeholder="请选择疾病"
            style="width: 240px; margin-left: 8px"
          >
            <el-option label="肺结节" value="lungNodule" />
            <el-option label="肺气肿" value="pulmonaryEmphysema" />
            <el-option label="慢阻肺" value="copd" />
            <el-option label="哮喘" value="asthma" />
          </el-select>
        </template>
        <template v-else-if="item.prop.startsWith('diseaseSpectrumUrinarySystem')">
          <el-select
            v-model="item.value"
            multiple
            placeholder="请选择疾病"
            style="width: 240px; margin-left: 8px"
          >
            <el-option label="肾结石" value="kidneyStone" />
            <el-option label="肾囊肿" value="renalCyst" />
            <el-option label="前列腺炎" value="prostatitis" />
          </el-select>
        </template>
        <template v-else-if="item.prop.startsWith('diseaseSpectrumSkeletalSystem')">
          <el-select
            v-model="item.value"
            multiple
            placeholder="请选择疾病"
            style="width: 240px; margin-left: 8px"
          >
            <el-option label="腰椎病" value="lumbarSpondylosis" />
            <el-option label="颈椎病" value="cervicalSpondylosis" />
          </el-select>
        </template>
        <template v-else-if="item.prop.startsWith('diseaseSpectrumNervousSystem')">
          <el-select
            v-model="item.value"
            multiple
            placeholder="请选择疾病"
            style="width: 240px; margin-left: 8px"
          >
            <el-option label="失眠" value="insomnia" />
          </el-select>
        </template>
        <template
          v-else-if="
            item.prop == 'experimentFraminghamRespVO.framinghamRiskType' ||
            item.prop == 'controlFraminghamRespVO.framinghamRiskType'
          "
        >
          <el-select
            v-model="item.value"
            placeholder="请选择"
            style="width: 160px; margin-left: 8px"
            @change="(val) => handleSelectChange(val, item, 'framinghamRiskType')"
          >
            <el-option label="低风险" value="low" />
            <el-option label="中风险" value="medium" />
            <el-option label="高风险" value="high" />
          </el-select>
        </template>
        <template v-else-if="item.prop.startsWith('experimentExamEcgRespVO.ecgDescription')">
          <el-select
            v-model="item.value"
            multiple
            placeholder="请选类型"
            style="width: 240px; margin-left: 8px"
          >
            <el-option label="正常心电图" value="正常心电图/正常" />
            <el-option label="异常心电图" value="异常心电图/异常" />
            <el-option label="边缘心电图" value="边缘心电图" />
            <el-option label="非典型心电图" value="非典型心电图" />
            <el-option label="窦性心律" value="窦性心律" />
            <el-option label="窦性心动过缓" value="窦性心动过缓" />
            <el-option label="窦性心律不齐" value="窦性心律不齐" />
            <el-option label="不能确定的心律不齐" value="不能确定的心律不齐" />
            <el-option label="室性早搏" value="室性早搏/室早/早搏" />
            <el-option label="心房纤颤" value="房颤/心房纤颤" />
            <el-option label="房室传导阻滞" value="房室传导阻滞" />
            <el-option label="室内传导阻滞" value="室内传导阻滞" />
            <el-option label="室内差异传导" value="室内差异传导" />
            <el-option label="WPW综合症" value="WPW综合症/预激综合征/预激" />
            <el-option label="电轴左偏" value="电轴左偏" />
            <el-option label="电轴右偏" value="电轴右偏" />
            <el-option label="短QT间期" value="短QT/短Q-T" />
            <el-option label="长QT间期" value="长QT/长Q-T" />
            <el-option label="短PR间期" value="短PR间期/PR间期缩短" />
            <el-option label="长PR间期" value="长PR间期" />
            <el-option label="P波异常" value="P波异常" />
            <el-option label="T波异常" value="T波异常" />
            <el-option label="ST段压低" value="ST段压低/压低" />
            <el-option label="ST段抬高" value="ST段抬高/抬高" />
            <el-option label="心肌梗塞" value="心肌梗塞/心梗" />
            <el-option label="心肌缺血" value="心肌缺血" />
            <el-option label="心房肥大" value="房肥大/房增大" />
            <el-option label="心室肥大" value="室肥大/室增大" />
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
  if (type === 'serviceTime') {
    const found = serviceTimeOptions.find((opt) => opt.value === val)
    if (found) item.labelText = found.label
  }
  if (type === 'framinghamRiskType') {
    const found = framinghamRiskTypeOptions.find((opt) => opt.value === val)
    if (found) item.labelText = found.label
  }
  if (type === 'residenceArea') {
    const labels = residenceAreaOptions // 从选项表中过滤出匹配项
      .filter((opt) => Array.isArray(val) && val.includes(opt.value))
      .map((opt) => opt.label)

    if (labels.length) {
      item.labelText = labels.join('、') // 多选时用顿号连接
    } else {
      item.labelText = '' // 没匹配到时设为空，可按需调整
    }
  }
}
const buildAdvancedQueryConditions = () => {
  return selectedFields.value.map((item, index) => ({
    logic: index === 0 ? 'AND' : item.logic || 'AND',
    label: item.label,
    field: item.prop,
    operator: item.operator,
    value: item.prop.startsWith('experimentSurveyServiceInfoRespVO.altitude')
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
