<template>
  <!-- 在最外层容器加上 v-loading -->
  <div class="drawer-main" v-loading="loading" element-loading-text="加载中...">
    <div class="drawer-title">{{ title }}</div>

    <div class="drawer-group-list">
      <div v-for="groupIndex in 24" :key="`group-${groupIndex}`" class="drawer-group">
        <div v-for="itemIndex in 5" :key="`item-${groupIndex}-${itemIndex}`" class="drawer-item">
          <template v-for="box in getBoxesByPosition(groupIndex, itemIndex)">
            <el-tooltip
              v-if="box.boxNo && box.displayColor != 'other'"
              placement="top"
              :key="`tooltip-${groupIndex}-${itemIndex}-${box.boxSeq}`"
              :hide-after="0"
            >
              <template #content>
                <div style="cursor: pointer">
                  {{ box.layer }}层{{ box.columnNum }}列{{ box.drawerNo }}屉
                  {{ box.boxNo }}
                </div>
              </template>
              <div
                class="drawer-subitem"
                :style="{ backgroundColor: getColor(box) }"
                @click.stop="handleBoxClick(box)"
              ></div>
            </el-tooltip>
            <div
              v-else
              :key="`no-tooltip-${groupIndex}-${itemIndex}-${box.boxSeq}`"
              class="drawer-subitem"
              :style="{ backgroundColor: getColor(box) }"
              @click.stop="handleBoxClick(box)"
            ></div>
          </template>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, watch, defineProps, onMounted } from 'vue'

interface BoxData {
  freezerNo: string
  layer: string
  columnNum: string
  drawerNo: string
  boxNo: string | null
  boxSeq: number
  positionCode: string | null
  sampleTypes: string | null
  displayColor: string | null
}

const props = defineProps<{
  value: BoxData[]
  title?: string
}>()

const localValue = ref<BoxData[]>([])
const loading = ref(true)


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
  
  'other': '#ccc',            // 黄色 - 其他
  'mixed': '#00000B' // 黑色 - 混合
}

// 用于记录未知颜色的固定随机色
const randomColorMap: Record<string, string> = {}
function getColor(box: BoxData) {
  // 没有 boxNo → 不显示颜色
  if (!box.boxNo) return '#ccc'

  const colorKey = box.displayColor || `unknown_${box.boxNo}`
// 按 sampleType 映射颜色
// const mappedType = mapSampleType(colorKey)
  // 有固定映射
  if (colorMap[colorKey]) {
    return colorMap[colorKey]
  }

  // 无映射 → 分配固定随机色
  if (!randomColorMap[colorKey]) {
    randomColorMap[colorKey] = '#FF0000'
    //  +Math.floor(Math.random() * 0xffffff)
    //   .toString(16)
    //   .padStart(6, '0')
  }
  return randomColorMap[colorKey]
}

// 监听 props.value 改变时同步到 localValue
watch(
  () => props.value,
  (newVal) => {
    localValue.value = newVal || []
    // 数据更新后，关闭 loading
    if (newVal && newVal.length > 0) {
      loading.value = false
    }
  },
  { immediate: true, deep: true }
)

// 计算 groupIndex
function getGroupIndex(layer: string, columnNum: string) {
  return (Number(layer) - 1) * 6 + Number(columnNum)
}

// 获取某组某抽屉的所有盒子
function getBoxesByPosition(groupIndex: number, itemIndex: number) {
  return localValue.value
    .filter((box) => {
      return (
        getGroupIndex(box.layer, box.columnNum) === groupIndex && Number(box.drawerNo) === itemIndex
      )
    })
    .sort((a, b) => a.boxSeq - b.boxSeq)
}

const emit = defineEmits<{
  (e: 'box-click', box: BoxData): void
}>()

function handleBoxClick(box: BoxData) {
  emit('box-click', box)
}
</script>

<style>
.drawer-main {
  width: 568px;
  height: 664px;
  border-radius: 4px;
  background: #f2f3f5;
  box-sizing: border-box;
  border: 1px solid rgba(0, 0, 0, 0.1);

  .drawer-title {
    width: 100%;
    font-size: 14px;
    text-align: center;
    margin: 16px;
    user-select: none;
  }

  .drawer-group-list {
    display: grid;
    grid-template-columns: repeat(6, auto); /* 每行 6 组 */
    gap: 8px;
    justify-content: center;

    .drawer-group {
      width: 80px;
      height: 144px;
      border-radius: 2px;
      border: 1px solid rgba(0, 0, 0, 0.1);

      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      padding: 2px 12px;
      gap: 4px;
    }

    .drawer-item {
      background-color: #ccc;
      width: 72px;
      border-radius: 2px;
      height: 24px;

      display: flex;
      gap: 2px;
      overflow: hidden;

      .drawer-subitem {
        width: 100%;
      }
    }

    .drawer-item:hover {
      box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
    }
  }
}
</style>
