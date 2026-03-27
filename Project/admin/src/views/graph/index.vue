<template>
  <div class="mind-map-wrapper" ref="wrapperRef">
    <!-- SVG连线层 -->
    <svg class="connections-svg" ref="svgRef" :width="svgWidth" :height="svgHeight">
      <defs>
        <marker id="arrowBlue" markerWidth="6" markerHeight="6" refX="3" refY="3" orient="auto">
          <circle cx="3" cy="3" r="2" fill="#3B6FE8" opacity="0.6"/>
        </marker>
        <marker id="arrowRed" markerWidth="6" markerHeight="6" refX="3" refY="3" orient="auto">
          <circle cx="3" cy="3" r="2" fill="#E84B4B" opacity="0.6"/>
        </marker>
        <marker id="arrowCyan" markerWidth="6" markerHeight="6" refX="3" refY="3" orient="auto">
          <circle cx="3" cy="3" r="2" fill="#00B8D9" opacity="0.6"/>
        </marker>
        <filter id="glow">
          <feGaussianBlur stdDeviation="2" result="coloredBlur"/>
          <feMerge>
            <feMergeNode in="coloredBlur"/>
            <feMergeNode in="SourceGraphic"/>
          </feMerge>
        </filter>
      </defs>
      <!-- 主干连线 -->
      <path
        v-for="(line, idx) in mainLines"
        :key="'main-' + idx"
        :d="line.d"
        :stroke="line.color"
        stroke-width="2"
        fill="none"
        opacity="0.8"
        :class="['main-line', { active: line.active }]"
      />
      <!-- 子节点连线 -->
      <path
        v-for="(line, idx) in subLines"
        :key="'sub-' + idx"
        :d="line.d"
        :stroke="line.color"
        stroke-width="1.5"
        fill="none"
        opacity="0.6"
        class="sub-line"
      />
      <!-- 明细展开连线 -->
      <path
        v-for="(line, idx) in detailLines"
        :key="'detail-' + idx"
        :d="line.d"
        :stroke="line.color"
        stroke-width="1"
        fill="none"
        opacity="0.5"
        stroke-dasharray="4,3"
        class="detail-line"
      />
    </svg>

    <!-- 中心节点 -->
    <div
      class="center-node"
      ref="centerRef"
      :style="centerStyle"
    >
      <div class="center-inner">
        <div class="center-title">{{ mapData.title }}</div>
        <div class="center-subtitle">{{ mapData.subtitle }}</div>
      </div>
      <div class="center-pulse"></div>
    </div>

    <!-- 左侧分组节点 -->
    <template v-for="(group, gIdx) in leftGroups" :key="'lg-' + gIdx">
      <div
        :ref="el => setGroupRef(el, 'left', gIdx)"
        class="group-node group-node--left"
        :class="{ active: activeGroup === group.id }"
        :style="getGroupStyle('left', gIdx)"
        @click="toggleGroup(group)"
      >
        <span class="group-label">{{ group.name }}</span>
        <span class="group-count">{{ group.count }}</span>
      </div>

      <!-- 左侧子节点（前瞻/回顾） -->
      <template v-if="group.children">
        <div
          v-for="(child, cIdx) in group.children"
          :key="'lc-' + gIdx + '-' + cIdx"
          :ref="el => setChildRef(el, 'left', gIdx, cIdx)"
          class="child-node child-node--left"
          :style="getChildStyle('left', gIdx, cIdx, group.children.length)"
        >
          {{ child.label }}
        </div>
      </template>

      <!-- 左侧展开明细 -->
      <transition name="expand">
        <div
          v-if="activeGroup === group.id && group.details"
          class="detail-panel detail-panel--left"
          :style="getDetailPanelStyle('left', gIdx)"
        >
          <div class="detail-panel__title">{{ group.name }} 明细</div>
          <div class="detail-panel__content">
            <div
              v-for="(detail, dIdx) in group.details"
              :key="dIdx"
              class="detail-item"
            >
              <div class="detail-item__tag" :class="detail.type">{{ detail.type === 'prospect' ? '前瞻' : '回顾' }}</div>
              <div class="detail-item__info">
                <span class="detail-item__name">{{ detail.name }}</span>
                <span class="detail-item__value">{{ detail.value }}</span>
              </div>
            </div>
          </div>
        </div>
      </transition>
    </template>

    <!-- 右侧分组节点 -->
    <template v-for="(group, gIdx) in rightGroups" :key="'rg-' + gIdx">
      <div
        :ref="el => setGroupRef(el, 'right', gIdx)"
        class="group-node group-node--right"
        :class="[`group-node--${group.color}`, { active: activeGroup === group.id }]"
        :style="getGroupStyle('right', gIdx)"
        @click="toggleGroup(group)"
      >
        <span class="group-label">{{ group.name }}</span>
        <span class="group-count">{{ group.count }}</span>
      </div>

      <!-- 右侧子节点 -->
      <template v-if="group.children">
        <div
          v-for="(child, cIdx) in group.children"
          :key="'rc-' + gIdx + '-' + cIdx"
          :ref="el => setChildRef(el, 'right', gIdx, cIdx)"
          class="child-node child-node--right"
          :style="getChildStyle('right', gIdx, cIdx, group.children.length)"
        >
          {{ child.label }}
        </div>
      </template>

      <!-- 右侧展开明细 -->
      <transition name="expand">
        <div
          v-if="activeGroup === group.id && group.details"
          class="detail-panel detail-panel--right"
          :style="getDetailPanelStyle('right', gIdx)"
        >
          <div class="detail-panel__title">{{ group.name }} 明细</div>
          <div class="detail-panel__content">
            <div
              v-for="(detail, dIdx) in group.details"
              :key="dIdx"
              class="detail-item"
            >
              <div
                class="detail-item__tag"
                :class="detail.type"
              >{{ getDetailTag(detail.type) }}</div>
              <div class="detail-item__info">
                <span class="detail-item__name">{{ detail.name }}</span>
                <span class="detail-item__value">{{ detail.value }}</span>
              </div>
            </div>
          </div>
        </div>
      </transition>
    </template>
  </div>
</template>

<script setup>
import { ref, reactive, computed, onMounted, nextTick, watch } from 'vue'

// ========== Props ==========
const props = defineProps({
  // 后台接口返回数据结构
  data: {
    type: Object,
    default: () => null
  }
})

// ========== 默认演示数据（对接后台时替换） ==========
const defaultData = {
  title: '体检人数',
  subtitle: '6368人',
  leftGroups: [
    {
      id: 'liudiao', name: '流调', count: 'XXXX人', color: 'dark',
      children: [{ label: '前瞻XXXX人' }, { label: '回顾XXX人' }],
      details: [
        { type: 'prospect', name: '前瞻问卷', value: '3200人' },
        { type: 'prospect', name: '前瞻随访', value: '1762人' },
        { type: 'retrospect', name: '回顾数据', value: '890人' },
        { type: 'retrospect', name: '回顾问卷', value: '478人' },
      ]
    },
    {
      id: 'xinlishuimian', name: '心理睡眠', count: 'XXXX人', color: 'dark',
      children: [{ label: '前瞻XXXX人' }, { label: '回顾XXX人' }],
      details: [
        { type: 'prospect', name: 'PSQI量表', value: '2100人' },
        { type: 'prospect', name: '焦虑量表', value: '1900人' },
        { type: 'retrospect', name: '历史记录', value: '700人' },
      ]
    },
    {
      id: 'renzhi', name: '认知', count: 'XXX人', color: 'dark',
      children: [{ label: '前瞻XXXX人' }, { label: '回顾XXX人' }],
      details: [
        { type: 'prospect', name: 'MoCA量表', value: '1500人' },
        { type: 'retrospect', name: '历史数据', value: '600人' },
      ]
    },
    {
      id: 'rentichenfen', name: '人体成分', count: 'XXX人', color: 'dark',
      children: [{ label: '前瞻XXXX人' }, { label: '回顾XXX人' }],
      details: [
        { type: 'prospect', name: 'BMI', value: '1800人' },
        { type: 'prospect', name: '体脂率', value: '1650人' },
        { type: 'retrospect', name: '历史数据', value: '550人' },
      ]
    },
    {
      id: 'shenjingwaike', name: '神经外科', count: 'XXX人', color: 'dark',
      children: [{ label: '前瞻XXXX人' }, { label: '回顾XXX人' }],
      details: [
        { type: 'prospect', name: '前瞻检查', value: '1200人' },
        { type: 'retrospect', name: '回顾病历', value: '480人' },
      ]
    },
    {
      id: 'feigongneng', name: '肺功能', count: 'XXXX人', color: 'dark',
      children: [
        { label: '弥散XXX人' }, { label: '通气XXX人' }
      ],
      childrenSub: [
        [{ label: '前瞻XXXX人' }, { label: '回顾XXX人' }],
        [{ label: '前瞻XXXX人' }, { label: '回顾XXX人' }],
      ],
      details: [
        { type: 'prospect', name: '弥散前瞻', value: '1200人' },
        { type: 'prospect', name: '通气前瞻', value: '1100人' },
        { type: 'retrospect', name: '弥散回顾', value: '500人' },
        { type: 'retrospect', name: '通气回顾', value: '480人' },
      ]
    },
    {
      id: 'yanke', name: '眼科', count: 'XXX人', color: 'dark',
      children: [],
      details: [
        { type: 'prospect', name: '眼底检查', value: '1400人' },
        { type: 'prospect', name: '视力测试', value: '1300人' },
      ]
    },
  ],
  rightGroups: [
    {
      id: 'qianzhan_sample', name: '前瞻样本', count: 'XXX份', color: 'red',
      children: [{ label: '血液XX份' }, { label: '唾液XX份' }],
      details: [
        { type: 'blood', name: '全血样本', value: '320份' },
        { type: 'blood', name: '血清样本', value: '280份' },
        { type: 'saliva', name: '唾液样本', value: '180份' },
      ]
    },
    {
      id: 'huigu_sample', name: '回顾样本', count: 'XXX份', color: 'red',
      children: [{ label: '血液XX份' }, { label: '尿液XX份' }],
      details: [
        { type: 'blood', name: '回顾血液', value: '240份' },
        { type: 'urine', name: '回顾尿液', value: '160份' },
      ]
    },
    {
      id: 'zuxue', name: '组学送样', count: 'XXX份', color: 'cyan',
      children: [
        { label: '全基因 XX份' }, { label: '宏基因组 XX份' },
        { label: '代谢组 XX份' }, { label: '表观组 XX份' },
        { label: '转录组 XX份' }, { label: '蛋白组 XX份' },
        { label: '免疫组 XX份' },
      ],
      details: [
        { type: 'genome', name: '全基因组', value: '120份' },
        { type: 'genome', name: '宏基因组', value: '95份' },
        { type: 'genome', name: '代谢组', value: '88份' },
        { type: 'genome', name: '表观组', value: '76份' },
        { type: 'genome', name: '转录组', value: '82份' },
        { type: 'genome', name: '蛋白组', value: '70份' },
        { type: 'genome', name: '免疫组', value: '65份' },
      ]
    },
    {
      id: 'xueye', name: '血液', count: 'XXX人', color: 'dark',
      children: [{ label: '前瞻XXXX人' }, { label: '回顾XXX人' }],
      details: [
        { type: 'prospect', name: '血常规', value: '2800人' },
        { type: 'prospect', name: '生化全套', value: '2600人' },
        { type: 'retrospect', name: '历史血检', value: '900人' },
      ]
    },
    {
      id: 'chaosheng', name: '超声', count: 'XXX人', color: 'dark',
      children: [],
      details: [
        { type: 'prospect', name: '腹部超声', value: '1600人' },
        { type: 'prospect', name: '心脏超声', value: '1200人' },
        { type: 'prospect', name: '颈动脉超声', value: '1100人' },
      ]
    },
    {
      id: 'xindian', name: '心电', count: 'XXX人', color: 'dark',
      children: [
        { label: '1静态血压血氧' }, { label: '2静态心电图' },
        { label: '3动态心电图' }, { label: '4动态血压' },
      ],
      details: [
        { type: 'prospect', name: '静态血压', value: '2500人' },
        { type: 'prospect', name: '静态心电图', value: '2400人' },
        { type: 'prospect', name: '动态心电图', value: '1800人' },
        { type: 'prospect', name: '动态血压', value: '1700人' },
        { type: 'retrospect', name: '回顾数据', value: '700人' },
      ]
    },
  ]
}

// ========== 响应式状态 ==========
const wrapperRef = ref(null)
const svgRef = ref(null)
const centerRef = ref(null)
const groupRefs = reactive({ left: [], right: [] })
const childRefs = reactive({ left: [], right: [] })

const activeGroup = ref(null)
const svgWidth = ref(1400)
const svgHeight = ref(900)

const mainLines = ref([])
const subLines = ref([])
const detailLines = ref([])

// ========== 计算属性 ==========
const mapData = computed(() => {
  const d = props.data || defaultData
  return { title: d.title, subtitle: d.subtitle }
})
const leftGroups = computed(() => (props.data || defaultData).leftGroups)
const rightGroups = computed(() => (props.data || defaultData).rightGroups)

// ========== 布局参数 ==========
const CENTER_X = 560
const CENTER_Y = 450
const GROUP_W = 120
const GROUP_H = 56
const LEFT_X = 270
const RIGHT_X = 850
const CHILD_W = 110
const CHILD_H = 30
const CHILD_SPACING = 42
const LEFT_CHILD_OFFSET_X = 150
const RIGHT_CHILD_OFFSET_X = 165
const GROUP_VERTICAL_GAP = 34

function getCenterPos() {
  return { x: CENTER_X, y: CENTER_Y }
}

function getGroupPos(side, idx) {
  const x = side === 'left' ? LEFT_X : RIGHT_X
  const groups = side === 'left' ? leftGroups.value : rightGroups.value
  const blockHeights = groups.map((group) => {
    const childCount = group.children?.length || 0
    const childHeight = childCount > 0 ? (childCount - 1) * CHILD_SPACING + CHILD_H : 0
    return Math.max(GROUP_H, childHeight)
  })
  const totalHeight =
    blockHeights.reduce((sum, height) => sum + height, 0) +
    Math.max(groups.length - 1, 0) * GROUP_VERTICAL_GAP

  let currentTop = CENTER_Y - totalHeight / 2
  for (let i = 0; i < blockHeights.length; i++) {
    const blockHeight = blockHeights[i]
    const centerY = currentTop + blockHeight / 2
    if (i === idx) {
      return { x, y: centerY }
    }
    currentTop += blockHeight + GROUP_VERTICAL_GAP
  }

  return { x, y: CENTER_Y }
}

function getGroupStyle(side, idx) {
  const pos = getGroupPos(side, idx)
  return {
    left: pos.x + 'px',
    top: pos.y - GROUP_H / 2 + 'px',
    width: GROUP_W + 'px',
    height: GROUP_H + 'px',
  }
}

function getChildStyle(side, gIdx, cIdx, total) {
  const gPos = getGroupPos(side, gIdx)
  const startY = gPos.y - ((total - 1) * CHILD_SPACING) / 2
  const offsetX = side === 'left' ? -LEFT_CHILD_OFFSET_X : RIGHT_CHILD_OFFSET_X
  return {
    left: (gPos.x + GROUP_W / 2 + offsetX - CHILD_W / 2) + 'px',
    top: (startY + cIdx * CHILD_SPACING - CHILD_H / 2) + 'px',
    width: CHILD_W + 'px',
    height: CHILD_H + 'px',
  }
}

function getDetailPanelStyle(side, gIdx) {
  const gPos = getGroupPos(side, gIdx)
  const offsetX = side === 'left' ? -330 : 150
  return {
    left: (gPos.x + GROUP_W / 2 + offsetX) + 'px',
    top: (gPos.y - 80) + 'px',
    width: '200px',
  }
}

const centerStyle = computed(() => ({
  left: (CENTER_X - 90) + 'px',
  top: (CENTER_Y - 60) + 'px',
  width: '180px',
  height: '120px',
}))

// ========== 连线计算 ==========
function bezierPath(x1, y1, x2, y2, side) {
  const cp = side === 'left'
    ? `C ${x1 - 80},${y1} ${x2 + 80},${y2} ${x2},${y2}`
    : `C ${x1 + 80},${y1} ${x2 - 80},${y2} ${x2},${y2}`
  return `M ${x1},${y1} ${cp}`
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
    bottom: rect.bottom - wrapperRect.top,
    width: rect.width,
    height: rect.height,
    centerX: rect.left - wrapperRect.left + rect.width / 2,
    centerY: rect.top - wrapperRect.top + rect.height / 2
  }
}

function getCenterAnchor(side) {
  const rect = getRelativeRect(centerRef.value)
  if (!rect) {
    return {
      x: side === 'left' ? CENTER_X - 90 : CENTER_X + 90,
      y: CENTER_Y
    }
  }

  return {
    x: side === 'left' ? rect.left : rect.right,
    y: rect.centerY
  }
}

function distributeEdgeY(rect, idx, total, padding = 10) {
  if (!rect || total <= 1) return rect?.centerY ?? CENTER_Y
  const usableHeight = Math.max(rect.height - padding * 2, 0)
  return rect.top + padding + (usableHeight * idx) / (total - 1)
}

function getMainCenterAnchor(side, idx, total) {
  const rect = getRelativeRect(centerRef.value)
  if (!rect) {
    return {
      x: side === 'left' ? CENTER_X - 90 : CENTER_X + 90,
      y: CENTER_Y
    }
  }

  return {
    x: side === 'left' ? rect.left : rect.right,
    y: distributeEdgeY(rect, idx, total, 18)
  }
}

function getGroupMainAnchor(side, idx) {
  const rect = getRelativeRect(groupRefs[side]?.[idx])
  const fallback = getGroupPos(side, idx)
  if (!rect) {
    return {
      x: side === 'left' ? fallback.x + GROUP_W : fallback.x,
      y: fallback.y
    }
  }

  return {
    x: side === 'left' ? rect.right : rect.left,
    y: rect.centerY
  }
}

function getGroupChildAnchor(side, gIdx, cIdx, total) {
  const rect = getRelativeRect(groupRefs[side]?.[gIdx])
  const fallback = getGroupPos(side, gIdx)
  if (!rect) {
    return {
      x: side === 'left' ? fallback.x : fallback.x + GROUP_W,
      y: fallback.y
    }
  }

  return {
    x: side === 'left' ? rect.left : rect.right,
    y: distributeEdgeY(rect, cIdx, total, 10)
  }
}

function getChildAnchor(side, gIdx, cIdx) {
  const groups = side === 'left' ? leftGroups.value : rightGroups.value
  const childCount = groups[gIdx]?.children?.length || 0
  const rect = getRelativeRect(childRefs[side]?.[gIdx]?.[cIdx])
  const fallbackStyle = getChildStyle(side, gIdx, cIdx, childCount)
  if (!rect) {
    return {
      x: side === 'left' ? parseFloat(fallbackStyle.left) + CHILD_W : parseFloat(fallbackStyle.left),
      y: parseFloat(fallbackStyle.top) + CHILD_H / 2
    }
  }

  return {
    x: side === 'left' ? rect.right : rect.left,
    y: rect.centerY
  }
}

function createTreeCurvePath(startX, startY, endX, endY, side) {
  const direction = side === 'left' ? -1 : 1
  const dx = Math.abs(endX - startX)
  const offset = Math.max(36, Math.min(110, dx * 0.45))
  const cp1X = startX + direction * offset
  const cp2X = endX - direction * offset

  return `M ${startX},${startY} C ${cp1X},${startY} ${cp2X},${endY} ${endX},${endY}`
}

function updateLines() {
  const newMain = []
  const newSub = []
  const newDetail = []

  // 左侧主干连线
  leftGroups.value.forEach((group, gIdx) => {
    const total = leftGroups.value.length
    const centerAnchor = getMainCenterAnchor('left', gIdx, total)
    const groupAnchor = getGroupMainAnchor('left', gIdx)
    newMain.push({
      d: createTreeCurvePath(centerAnchor.x, centerAnchor.y, groupAnchor.x, groupAnchor.y, 'left'),
      color: '#3B6FE8',
      active: activeGroup.value === group.id
    })

    // 子节点连线
    if (group.children && group.children.length) {
      group.children.forEach((child, cIdx) => {
        const groupChildAnchor = getGroupChildAnchor('left', gIdx, cIdx, group.children.length)
        const childAnchor = getChildAnchor('left', gIdx, cIdx)
        newSub.push({
          d: createTreeCurvePath(groupChildAnchor.x, groupChildAnchor.y, childAnchor.x, childAnchor.y, 'left'),
          color: '#3B6FE8'
        })
      })
    }
  })

  // 右侧主干连线
  rightGroups.value.forEach((group, gIdx) => {
    const total = rightGroups.value.length
    const centerAnchor = getMainCenterAnchor('right', gIdx, total)
    const groupAnchor = getGroupMainAnchor('right', gIdx)
    const color = group.color === 'red' ? '#E84B4B' : group.color === 'cyan' ? '#00B8D9' : '#3B6FE8'
    newMain.push({
      d: createTreeCurvePath(centerAnchor.x, centerAnchor.y, groupAnchor.x, groupAnchor.y, 'right'),
      color,
      active: activeGroup.value === group.id
    })

    // 子节点连线
    if (group.children && group.children.length) {
      group.children.forEach((child, cIdx) => {
        const groupChildAnchor = getGroupChildAnchor('right', gIdx, cIdx, group.children.length)
        const childAnchor = getChildAnchor('right', gIdx, cIdx)
        newSub.push({
          d: createTreeCurvePath(groupChildAnchor.x, groupChildAnchor.y, childAnchor.x, childAnchor.y, 'right'),
          color
        })
      })
    }
  })

  mainLines.value = newMain
  subLines.value = newSub
  detailLines.value = newDetail
}

// ========== 交互 ==========
function toggleGroup(group) {
  if (activeGroup.value === group.id) {
    activeGroup.value = null
  } else {
    activeGroup.value = group.id
  }
  nextTick(updateLines)
}

function getDetailTag(type) {
  const map = {
    prospect: '前瞻', retrospect: '回顾',
    blood: '血液', saliva: '唾液', urine: '尿液',
    genome: '组学'
  }
  return map[type] || type
}

function setGroupRef(el, side, idx) {
  if (!groupRefs[side]) groupRefs[side] = []
  groupRefs[side][idx] = el
}

function setChildRef(el, side, gIdx, cIdx) {
  if (!childRefs[side]) childRefs[side] = []
  if (!childRefs[side][gIdx]) childRefs[side][gIdx] = []
  childRefs[side][gIdx][cIdx] = el
}

// ========== 生命周期 ==========
onMounted(async () => {
  await nextTick()
  const wrapper = wrapperRef.value
  if (wrapper) {
    svgWidth.value = wrapper.offsetWidth || 1400
    svgHeight.value = wrapper.offsetHeight || 900
  }
  updateLines()
  window.addEventListener('resize', handleResize)
})

function handleResize() {
  const wrapper = wrapperRef.value
  if (wrapper) {
    svgWidth.value = wrapper.offsetWidth
    svgHeight.value = wrapper.offsetHeight
  }
  nextTick(updateLines)
}

watch([leftGroups, rightGroups], () => {
  nextTick(updateLines)
}, { deep: true })
</script>

<style scoped lang="scss">
.mind-map-wrapper {
  position: relative;
  width: 100%;
  min-height: 900px;
  background: #f0f4ff;
  overflow: hidden;
  font-family: 'PingFang SC', 'Microsoft YaHei', sans-serif;
  background-image:
    radial-gradient(circle at 20% 30%, rgba(59,111,232,0.06) 0%, transparent 60%),
    radial-gradient(circle at 80% 70%, rgba(0,184,217,0.06) 0%, transparent 60%);
}

// ========== SVG连线 ==========
.connections-svg {
  position: absolute;
  top: 0;
  left: 0;
  pointer-events: none;
  z-index: 1;

  .main-line {
    transition: stroke-width 0.3s, opacity 0.3s;
    &.active {
      stroke-width: 3 !important;
      opacity: 1 !important;
    }
  }

  .detail-line {
    animation: dash-flow 2s linear infinite;
  }
}

@keyframes dash-flow {
  to { stroke-dashoffset: -20; }
}

// ========== 中心节点 ==========
.center-node {
  position: absolute;
  z-index: 10;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 50%;
  background: linear-gradient(135deg, #2352C8 0%, #3B6FE8 50%, #4F8AFF 100%);
  box-shadow:
    0 8px 32px rgba(59,111,232,0.45),
    0 2px 8px rgba(59,111,232,0.3),
    inset 0 1px 0 rgba(255,255,255,0.15);
  cursor: default;
  user-select: none;

  .center-inner {
    text-align: center;
    color: #fff;
    z-index: 2;
    position: relative;
  }

  .center-title {
    font-size: 15px;
    font-weight: 700;
    letter-spacing: 1px;
    line-height: 1.4;
    text-shadow: 0 1px 4px rgba(0,0,0,0.2);
  }

  .center-subtitle {
    font-size: 17px;
    font-weight: 800;
    margin-top: 4px;
    color: #fff;
  }

  .center-pulse {
    position: absolute;
    inset: -8px;
    border-radius: 50%;
    border: 2px solid rgba(59,111,232,0.3);
    animation: pulse-ring 2.5s ease-out infinite;
  }
}

@keyframes pulse-ring {
  0% { transform: scale(1); opacity: 0.6; }
  100% { transform: scale(1.15); opacity: 0; }
}

// ========== 分组节点 ==========
.group-node {
  position: absolute;
  z-index: 10;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  border-radius: 28px;
  cursor: pointer;
  transition: all 0.25s cubic-bezier(0.34, 1.56, 0.64, 1);
  user-select: none;

  &:hover {
    transform: scale(1.06);
  }

  &.active {
    transform: scale(1.08);
    box-shadow: 0 0 0 3px rgba(255,255,255,0.8), 0 8px 24px rgba(0,0,0,0.2) !important;
  }

  .group-label {
    font-size: 13px;
    font-weight: 700;
    line-height: 1.3;
  }

  .group-count {
    font-size: 12px;
    font-weight: 600;
    opacity: 0.85;
  }

  // 深色（默认）
  &--dark, &.group-node--left {
    background: linear-gradient(135deg, #0A1A4A 0%, #1A2F6E 100%);
    color: #fff;
    box-shadow: 0 4px 16px rgba(10,26,74,0.4);
  }

  // 红色
  &--red {
    background: linear-gradient(135deg, #C8293A 0%, #E84B4B 100%);
    color: #fff;
    box-shadow: 0 4px 16px rgba(232,75,75,0.4);
  }

  // 青色
  &--cyan {
    background: linear-gradient(135deg, #0088B3 0%, #00B8D9 100%);
    color: #fff;
    box-shadow: 0 4px 16px rgba(0,184,217,0.4);
  }
}

// ========== 子节点 ==========
.child-node {
  position: absolute;
  z-index: 8;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 11px;
  color: #fff;
  font-weight: 600;
  white-space: nowrap;
  padding: 0 12px;
  border-radius: 999px;
  background: linear-gradient(135deg, #0A1A4A 0%, #1A2F6E 100%);
  box-shadow: 0 4px 16px rgba(10,26,74,0.28);
  border: 1px solid rgba(255,255,255,0.08);
  pointer-events: none;

  &--left {
    justify-content: center;
  }

  &--right {
    justify-content: center;
  }
}

// ========== 明细面板 ==========
.detail-panel {
  position: absolute;
  z-index: 20;
  background: #fff;
  border-radius: 12px;
  box-shadow:
    0 8px 32px rgba(59,111,232,0.18),
    0 2px 8px rgba(0,0,0,0.08);
  padding: 14px 14px 10px;
  border: 1px solid rgba(59,111,232,0.12);
  min-width: 190px;

  &__title {
    font-size: 12px;
    font-weight: 700;
    color: #1A2F6E;
    margin-bottom: 10px;
    padding-bottom: 6px;
    border-bottom: 1px solid #eef2ff;
    letter-spacing: 0.5px;
  }

  &__content {
    display: flex;
    flex-direction: column;
    gap: 6px;
  }
}

.detail-item {
  display: flex;
  align-items: center;
  gap: 8px;

  &__tag {
    flex-shrink: 0;
    font-size: 10px;
    font-weight: 700;
    padding: 2px 6px;
    border-radius: 4px;
    letter-spacing: 0.3px;

    &.prospect {
      background: rgba(59,111,232,0.12);
      color: #3B6FE8;
    }

    &.retrospect {
      background: rgba(100,116,139,0.12);
      color: #475569;
    }

    &.blood {
      background: rgba(232,75,75,0.12);
      color: #E84B4B;
    }

    &.saliva, &.urine {
      background: rgba(245,158,11,0.12);
      color: #D97706;
    }

    &.genome {
      background: rgba(0,184,217,0.12);
      color: #0095A8;
    }
  }

  &__info {
    display: flex;
    justify-content: space-between;
    align-items: center;
    flex: 1;
    gap: 8px;
  }

  &__name {
    font-size: 11px;
    color: #334155;
    font-weight: 500;
  }

  &__value {
    font-size: 11px;
    color: #3B6FE8;
    font-weight: 700;
    white-space: nowrap;
  }
}

// ========== 展开动画 ==========
.expand-enter-active {
  animation: expand-in 0.28s cubic-bezier(0.34, 1.56, 0.64, 1);
}

.expand-leave-active {
  animation: expand-in 0.2s cubic-bezier(0.55, 0, 1, 0.45) reverse;
}

@keyframes expand-in {
  from {
    opacity: 0;
    transform: scale(0.88) translateY(-8px);
  }
  to {
    opacity: 1;
    transform: scale(1) translateY(0);
  }
}
</style>
