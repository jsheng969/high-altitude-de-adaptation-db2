<template>
  <div class="mind-map-wrapper" :class="{ 'mind-map-wrapper--preview': props.preview }" ref="wrapperRef">
    <div v-if="!props.preview" class="toolbar">
      <div>
        <div class="toolbar__title">数据图谱</div>
        <div class="toolbar__desc">共 {{ idList.length }} 个体检 ID，可按 ID 查询对应连线数据</div>
      </div>
      <div class="toolbar__search">
        <input
          v-model.trim="searchKeyword"
          class="toolbar__input"
          type="text"
          placeholder="请输入体检 ID，例如 TJ000001"
          @keyup.enter="handleSearch"
        />
        <button type="button" class="toolbar__btn toolbar__btn--primary" @click="handleSearch">
          查询
        </button>
        <button type="button" class="toolbar__btn" @click="resetSearch">重置</button>
      </div>
    </div>

    <div v-if="!props.preview" class="toolbar__status">
      {{ currentParticipantId ? `当前 ID：${currentParticipantId}` : '当前视图：总体图谱' }}
    </div>

    <svg class="connections-svg" :width="svgWidth" :height="svgHeight">
      <path
        v-for="(line, index) in mainLines"
        :key="'main-' + index"
        :d="line.d"
        :stroke="line.color"
        fill="none"
        stroke-width="2"
        opacity="0.82"
      />
      <path
        v-for="(line, index) in childLines"
        :key="'child-' + index"
        :d="line.d"
        :stroke="line.color"
        fill="none"
        stroke-width="1.5"
        opacity="0.62"
      />
    </svg>

    <div class="center-node" ref="centerRef" :style="centerStyle">
      <div class="center-node__title">{{ mapData.title }}</div>
      <div class="center-node__subtitle">{{ mapData.subtitle }}</div>
    </div>

    <template v-for="(group, index) in leftGroups" :key="'left-' + group.id">
      <div
        :ref="(el) => setGroupRef(el, 'left', index)"
        class="group-node group-node--left"
        :style="getGroupStyle('left', index)"
      >
        <span>{{ group.name }}</span>
        <small>{{ group.count }}</small>
      </div>
      <div
        v-for="(child, childIndex) in group.children || []"
        :key="'left-child-' + group.id + '-' + childIndex"
        :ref="(el) => setChildRef(el, 'left', index, childIndex)"
        class="child-node"
        :style="getChildStyle('left', index, childIndex, group.children.length)"
      >
        {{ child.label }}
      </div>
    </template>

    <template v-for="(group, index) in rightGroups" :key="'right-' + group.id">
      <div
        :ref="(el) => setGroupRef(el, 'right', index)"
        class="group-node"
        :class="`group-node--${group.color || 'dark'}`"
        :style="getGroupStyle('right', index)"
      >
        <span>{{ group.name }}</span>
        <small>{{ group.count }}</small>
      </div>
      <div
        v-for="(child, childIndex) in group.children || []"
        :key="'right-child-' + group.id + '-' + childIndex"
        :ref="(el) => setChildRef(el, 'right', index, childIndex)"
        class="child-node"
        :style="getChildStyle('right', index, childIndex, group.children.length)"
      >
        {{ child.label }}
      </div>
    </template>
  </div>
</template>

<script setup>
import { computed, nextTick, onBeforeUnmount, onMounted, reactive, ref, watch } from 'vue'
import { ElMessage } from 'element-plus'

const props = defineProps({
  data: { type: Object, default: () => null },
  preview: { type: Boolean, default: false }
})

const mockIdList = Array.from({ length: 6368 }, (_, index) => `TJ${String(index + 1).padStart(6, '0')}`)

function createSummaryGraph(total) {
  return {
    title: '体检人数',
    subtitle: `${total}人`,
    leftGroups: [
      { id: 'liudiao', name: '流调', count: 'XXXX人', children: [{ label: '前瞻XXXX人' }, { label: '回顾XXX人' }] },
      { id: 'xinli', name: '心理睡眠', count: 'XXXX人', children: [{ label: 'PSQI' }, { label: '焦虑量表' }] },
      { id: 'renzhi', name: '认知', count: 'XXX人', children: [{ label: 'MoCA' }] },
      { id: 'renti', name: '人体成分', count: 'XXX人', children: [{ label: 'BMI' }, { label: '体脂率' }] }
    ],
    rightGroups: [
      { id: 'qianzhan', name: '前瞻样本', count: 'XXX份', color: 'red', children: [{ label: '血液XX份' }, { label: '唾液XX份' }] },
      { id: 'zuxue', name: '组学送样', count: 'XXX份', color: 'cyan', children: [{ label: '全基因组XX份' }, { label: '转录组XX份' }, { label: '蛋白组XX份' }] },
      { id: 'xueye', name: '血液', count: 'XXX人', color: 'dark', children: [{ label: '血常规' }, { label: '生化全套' }] },
      { id: 'xindian', name: '心电', count: 'XXX人', color: 'dark', children: [{ label: '静态心电图' }, { label: '动态血压' }] }
    ]
  }
}

function buildParticipantGraph(id) {
  const seed = Number(id.replace(/\D/g, '').slice(-3) || 0)
  const hasTranscriptome = seed % 2 === 0
  const hasProteomics = seed % 3 === 0

  return {
    title: '体检 ID',
    subtitle: id,
    leftGroups: [
      { id: 'liudiao', name: '流调', count: '已关联', children: [{ label: seed % 2 === 0 ? '前瞻问卷' : '回顾问卷' }] },
      { id: 'xinli', name: '心理睡眠', count: '已关联', children: [{ label: 'PSQI' }, { label: '焦虑量表' }] },
      { id: 'renzhi', name: '认知', count: seed % 5 === 0 ? '未关联' : '已关联', children: seed % 5 === 0 ? [] : [{ label: 'MoCA' }] },
      { id: 'renti', name: '人体成分', count: '已关联', children: [{ label: 'BMI' }, { label: '体脂率' }] }
    ],
    rightGroups: [
      { id: 'qianzhan', name: '前瞻样本', count: `${(seed % 2) + 1}份`, color: 'red', children: [{ label: '血液1份' }, ...(seed % 2 === 0 ? [{ label: '唾液1份' }] : [])] },
      { id: 'zuxue', name: '组学送样', count: `${1 + Number(hasTranscriptome) + Number(hasProteomics)}项`, color: 'cyan', children: [{ label: '全基因组' }, ...(hasTranscriptome ? [{ label: '转录组' }] : []), ...(hasProteomics ? [{ label: '蛋白组' }] : [])] },
      { id: 'xueye', name: '血液', count: '已关联', color: 'dark', children: [{ label: '血常规' }, { label: '生化全套' }] },
      { id: 'xindian', name: '心电', count: seed % 4 === 0 ? '未关联' : '已关联', color: 'dark', children: seed % 4 === 0 ? [] : [{ label: '静态心电图' }, { label: '动态血压' }] }
    ]
  }
}

const wrapperRef = ref(null)
const centerRef = ref(null)
const groupRefs = reactive({ left: [], right: [] })
const childRefs = reactive({ left: [], right: [] })
const searchKeyword = ref('')
const currentParticipantId = ref('')
const svgWidth = ref(1400)
const svgHeight = ref(props.preview ? 260 : 980)
const mainLines = ref([])
const childLines = ref([])

const idList = computed(() => (Array.isArray(props.data?.idList) && props.data.idList.length ? props.data.idList : mockIdList))
const currentGraph = computed(() => {
  if (!currentParticipantId.value) {
    return props.data?.summaryGraph || createSummaryGraph(idList.value.length)
  }
  return props.data?.graphById?.[currentParticipantId.value] || buildParticipantGraph(currentParticipantId.value)
})
const mapData = computed(() => ({ title: currentGraph.value.title, subtitle: currentGraph.value.subtitle }))
const leftGroups = computed(() => currentGraph.value.leftGroups || [])
const rightGroups = computed(() => currentGraph.value.rightGroups || [])

const CENTER_X = props.preview ? 595 : 660
const CENTER_Y = props.preview ? 138 : 420
const CENTER_W = props.preview ? 132 : 180
const CENTER_H = props.preview ? 86 : 120
const GROUP_W = props.preview ? 96 : 120
const GROUP_H = props.preview ? 34 : 56
const LEFT_X = props.preview ? 372 : 270
const RIGHT_X = props.preview ? 845 : 950
const CHILD_W = props.preview ? 92 : 110
const CHILD_H = props.preview ? 20 : 30
const CHILD_SPACING = props.preview ? 22 : 42
const GROUP_VERTICAL_GAP = props.preview ? 16 : 34

const centerStyle = computed(() => ({
  left: `${CENTER_X - CENTER_W / 2}px`,
  top: `${CENTER_Y - CENTER_H / 2}px`,
  width: `${CENTER_W}px`,
  height: `${CENTER_H}px`
}))

function clearRefs() {
  groupRefs.left = []
  groupRefs.right = []
  childRefs.left = []
  childRefs.right = []
}

function getGroupPos(side, index) {
  const x = side === 'left' ? LEFT_X : RIGHT_X
  const groups = side === 'left' ? leftGroups.value : rightGroups.value
  const heights = groups.map((group) => Math.max(GROUP_H, ((group.children?.length || 1) - 1) * CHILD_SPACING + CHILD_H))
  const totalHeight = heights.reduce((sum, item) => sum + item, 0) + Math.max(heights.length - 1, 0) * GROUP_VERTICAL_GAP
  let top = CENTER_Y - totalHeight / 2
  for (let i = 0; i < heights.length; i += 1) {
    const centerY = top + heights[i] / 2
    if (i === index) return { x, y: centerY }
    top += heights[i] + GROUP_VERTICAL_GAP
  }
  return { x, y: CENTER_Y }
}

function getGroupStyle(side, index) {
  const pos = getGroupPos(side, index)
  return { left: `${pos.x}px`, top: `${pos.y - GROUP_H / 2}px`, width: `${GROUP_W}px`, height: `${GROUP_H}px` }
}

function getChildStyle(side, groupIndex, childIndex, total) {
  const groupPos = getGroupPos(side, groupIndex)
  const startY = groupPos.y - ((total - 1) * CHILD_SPACING) / 2
  const offsetX = props.preview
    ? side === 'left'
      ? -112
      : 116
    : side === 'left'
      ? -150
      : 165
  return {
    left: `${groupPos.x + GROUP_W / 2 + offsetX - CHILD_W / 2}px`,
    top: `${startY + childIndex * CHILD_SPACING - CHILD_H / 2}px`,
    width: `${CHILD_W}px`,
    height: `${CHILD_H}px`
  }
}

function getRelativeRect(el) {
  const wrapper = wrapperRef.value
  if (!wrapper || !el) return null
  const wrapperRect = wrapper.getBoundingClientRect()
  const rect = el.getBoundingClientRect()
  return {
    left: rect.left - wrapperRect.left,
    right: rect.right - wrapperRect.left,
    top: rect.top - wrapperRect.top,
    height: rect.height,
    centerY: rect.top - wrapperRect.top + rect.height / 2
  }
}

function distributeEdgeY(rect, index, total, padding = 12) {
  if (!rect || total <= 1) return rect?.centerY ?? CENTER_Y
  const usableHeight = Math.max(rect.height - padding * 2, 0)
  return rect.top + padding + (usableHeight * index) / (total - 1)
}

function createCurve(startX, startY, endX, endY, side) {
  const direction = side === 'left' ? -1 : 1
  const dx = Math.abs(endX - startX)
  const offset = Math.max(36, Math.min(110, dx * 0.45))
  return `M ${startX},${startY} C ${startX + direction * offset},${startY} ${endX - direction * offset},${endY} ${endX},${endY}`
}

function updateLines() {
  const mains = []
  const children = []
  const centerRect = getRelativeRect(centerRef.value)

  ;[
    ['left', leftGroups.value, '#3b6fe8'],
    ['right', rightGroups.value, null]
  ].forEach(([side, groups, fixedColor]) => {
    groups.forEach((group, index) => {
      const groupRect = getRelativeRect(groupRefs[side]?.[index])
      const color = fixedColor || (group.color === 'red' ? '#e84b4b' : group.color === 'cyan' ? '#00b8d9' : '#3b6fe8')
      const centerX =
        side === 'left'
          ? centerRect?.left ?? CENTER_X - CENTER_W / 2
          : centerRect?.right ?? CENTER_X + CENTER_W / 2
      const centerY = distributeEdgeY(centerRect, index, groups.length, 18)
      const groupX = side === 'left' ? groupRect?.right ?? getGroupPos(side, index).x + GROUP_W : groupRect?.left ?? getGroupPos(side, index).x
      const groupY = groupRect?.centerY ?? getGroupPos(side, index).y
      mains.push({ d: createCurve(centerX, centerY, groupX, groupY, side), color })

      ;(group.children || []).forEach((child, childIndex) => {
        const childRect = getRelativeRect(childRefs[side]?.[index]?.[childIndex])
        const startY = distributeEdgeY(groupRect, childIndex, group.children.length, 10)
        const startX = side === 'left' ? groupRect?.left ?? getGroupPos(side, index).x : groupRect?.right ?? getGroupPos(side, index).x + GROUP_W
        const endX = side === 'left' ? childRect?.right ?? parseFloat(getChildStyle(side, index, childIndex, group.children.length).left) + CHILD_W : childRect?.left ?? parseFloat(getChildStyle(side, index, childIndex, group.children.length).left)
        const endY = childRect?.centerY ?? parseFloat(getChildStyle(side, index, childIndex, group.children.length).top) + CHILD_H / 2
        children.push({ d: createCurve(startX, startY, endX, endY, side), color })
      })
    })
  })

  mainLines.value = mains
  childLines.value = children
}

function setGroupRef(el, side, index) {
  if (!groupRefs[side]) groupRefs[side] = []
  groupRefs[side][index] = el
}

function setChildRef(el, side, groupIndex, childIndex) {
  if (!childRefs[side]) childRefs[side] = []
  if (!childRefs[side][groupIndex]) childRefs[side][groupIndex] = []
  childRefs[side][groupIndex][childIndex] = el
}

function handleSearch() {
  if (!searchKeyword.value) {
    resetSearch()
    return
  }
  const keyword = searchKeyword.value.toLowerCase()
  const matchedId =
    idList.value.find((id) => id.toLowerCase() === keyword) ||
    idList.value.find((id) => id.toLowerCase().includes(keyword))

  if (!matchedId) {
    ElMessage.warning('未找到对应体检 ID，请检查后重试')
    return
  }

  currentParticipantId.value = matchedId
  searchKeyword.value = matchedId
}

function resetSearch() {
  searchKeyword.value = ''
  currentParticipantId.value = ''
}

function handleResize() {
  const wrapper = wrapperRef.value
  if (!wrapper) return
  svgWidth.value = wrapper.offsetWidth || 1400
  svgHeight.value = wrapper.offsetHeight || (props.preview ? 260 : 980)
  nextTick(updateLines)
}

onMounted(async () => {
  await nextTick()
  handleResize()
  window.addEventListener('resize', handleResize)
})

onBeforeUnmount(() => {
  window.removeEventListener('resize', handleResize)
})

watch([leftGroups, rightGroups, currentParticipantId], async () => {
  clearRefs()
  await nextTick()
  updateLines()
})
</script>

<style scoped lang="scss">
.mind-map-wrapper {
  position: relative;
  width: 100%;
  min-height: 980px;
  padding-top: 108px;
  overflow: hidden;
  background:
    radial-gradient(circle at 20% 30%, rgba(59, 111, 232, 0.06) 0%, transparent 60%),
    radial-gradient(circle at 80% 70%, rgba(0, 184, 217, 0.06) 0%, transparent 60%),
    #f0f4ff;
  font-family: 'PingFang SC', 'Microsoft YaHei', sans-serif;
}

.mind-map-wrapper--preview {
  min-height: 260px;
  padding-top: 0;
  background: transparent;
}

.mind-map-wrapper--preview .center-node {
  box-shadow: 0 10px 28px rgba(59, 111, 232, 0.28);
}

.mind-map-wrapper--preview .center-node__title {
  font-size: 12px;
}

.mind-map-wrapper--preview .center-node__subtitle {
  font-size: 14px;
}

.mind-map-wrapper--preview .group-node span {
  font-size: 11px;
}

.mind-map-wrapper--preview .group-node small {
  font-size: 10px;
}

.mind-map-wrapper--preview .child-node {
  font-size: 9px;
  padding: 0 10px;
}

.toolbar {
  position: absolute;
  top: 18px;
  left: 24px;
  right: 24px;
  z-index: 30;
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 16px;
  padding: 14px 18px;
  border: 1px solid rgba(59, 111, 232, 0.1);
  border-radius: 18px;
  background: rgba(255, 255, 255, 0.92);
  box-shadow: 0 12px 28px rgba(48, 85, 154, 0.1);
}

.toolbar__title {
  font-size: 18px;
  font-weight: 700;
  color: #203152;
}

.toolbar__desc {
  margin-top: 4px;
  font-size: 13px;
  color: #60708f;
}

.toolbar__search {
  display: flex;
  align-items: center;
  gap: 10px;
}

.toolbar__input {
  width: 280px;
  height: 40px;
  padding: 0 14px;
  border: 1px solid rgba(59, 111, 232, 0.18);
  border-radius: 12px;
  font-size: 14px;
  color: #22304e;
  outline: none;
}

.toolbar__btn {
  height: 40px;
  padding: 0 16px;
  border: 1px solid rgba(59, 111, 232, 0.14);
  border-radius: 12px;
  background: #fff;
  color: #40516f;
  font-size: 14px;
  font-weight: 600;
  cursor: pointer;
}

.toolbar__btn--primary {
  border-color: transparent;
  background: linear-gradient(135deg, #2f5dd4 0%, #4b85ff 100%);
  color: #fff;
}

.toolbar__status {
  position: absolute;
  top: 100px;
  left: 24px;
  z-index: 25;
  display: inline-flex;
  align-items: center;
  height: 30px;
  padding: 0 12px;
  border-radius: 999px;
  background: rgba(255, 255, 255, 0.92);
  color: #486084;
  font-size: 12px;
  box-shadow: 0 6px 16px rgba(48, 85, 154, 0.08);
}

.connections-svg {
  position: absolute;
  top: 0;
  left: 0;
  z-index: 1;
  pointer-events: none;
}

.center-node {
  position: absolute;
  z-index: 10;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  border-radius: 50%;
  color: #fff;
  background: linear-gradient(135deg, #2352c8 0%, #3b6fe8 50%, #4f8aff 100%);
  box-shadow: 0 8px 32px rgba(59, 111, 232, 0.45);
}

.center-node__title {
  font-size: 15px;
  font-weight: 700;
}

.center-node__subtitle {
  margin-top: 4px;
  font-size: 17px;
  font-weight: 800;
}

.group-node {
  position: absolute;
  z-index: 10;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  border-radius: 28px;
  color: #fff;
  box-shadow: 0 4px 16px rgba(10, 26, 74, 0.4);
  background: linear-gradient(135deg, #0a1a4a 0%, #1a2f6e 100%);
}

.group-node--red {
  background: linear-gradient(135deg, #c8293a 0%, #e84b4b 100%);
}

.group-node--cyan {
  background: linear-gradient(135deg, #0088b3 0%, #00b8d9 100%);
}

.group-node span {
  font-size: 13px;
  font-weight: 700;
}

.group-node small {
  margin-top: 2px;
  font-size: 12px;
  opacity: 0.85;
}

.child-node {
  position: absolute;
  z-index: 8;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 0 12px;
  border: 1px solid rgba(255, 255, 255, 0.08);
  border-radius: 999px;
  background: linear-gradient(135deg, #0a1a4a 0%, #1a2f6e 100%);
  box-shadow: 0 4px 16px rgba(10, 26, 74, 0.28);
  color: #fff;
  font-size: 11px;
  font-weight: 600;
  white-space: nowrap;
}

@media (max-width: 1200px) {
  .toolbar {
    flex-direction: column;
    align-items: stretch;
  }

  .toolbar__search {
    width: 100%;
  }

  .toolbar__input {
    flex: 1;
    width: auto;
  }
}
</style>
