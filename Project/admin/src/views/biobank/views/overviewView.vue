<template>
  <el-card>
    <template #header>
      <div class="card-header">
        <div class="card-title">
          <span>总览</span>
        </div>
        <!-- <el-button type="primary" link @click="refreshData">
          <el-icon><Refresh /></el-icon>
          刷新
        </el-button> -->
      </div>
    </template>

    <div class="card-list">
      <!-- 总样本数卡片 -->
      <div class="card-item">
        <div class="progress-bar">
          <div class="progress-value" :style="{ height: totalPercentage + '%' }"></div>
        </div>
        <div class="content">
          <div class="title">总样本数</div>
          <div class="value">{{ formatNumber(totalSamples) }}</div>
        </div>
      </div>

      <!-- 动态生成的样本类型卡片 -->
      <div 
        v-for="(item, index) in sampleTypeData" 
        :key="item.sampleType" 
        class="card-item"
      >
        <div class="progress-bar" :style="{ backgroundColor: getProgressBarColor(index) }">
          <div 
            class="progress-value" 
            :style="{ 
              backgroundColor: getProgressValueColor(index),
              height: calculatePercentage(item.count) + '%'
            }"
          ></div>
        </div>
        <div class="content">
          <div class="title">{{ getDisplayName(item.sampleType) }}样本数</div>
          <div class="value" :style="{ color: getProgressValueColor(index) }">
            {{ formatNumber(item.count) }}
          </div>
        </div>
      </div>
    </div>
  </el-card>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { ElMessage } from 'element-plus'
import { Refresh } from '@element-plus/icons-vue'
import { SampleApi } from '@/api/sample'

// 样本类型数据
const sampleTypeData = ref([])
const totalSamples = ref(0)
const totalPercentage = ref(80) // 默认进度条高度

// 颜色配置
const colorConfig = [
  { bar: 'rgba(255, 255, 0, 0.2)', value: '#F56C6C' },
  { bar: 'rgba(22, 93, 255, 0.2)', value: '#409EFF' },
  { bar: 'rgba(255, 167, 167, 0.2)', value: '#67C23A' },
  { bar: 'rgba(255, 167, 167, 0.2)', value: '#eb5959' },
  { bar: 'rgba(71, 170, 105, 0.2)', value: '#47aa69' },
  { bar: 'rgba(128, 90, 213, 0.2)', value: '#805ad5' },
  { bar: 'rgba(231, 76, 60, 0.2)', value: '#e74c3c' }
]

// 样本类型显示名称映射
const sampleTypeDisplayNames = {
  'urine': '尿液',
  'saliva': '唾液',
  'blood': '血液',
  'blood_serum': '血液-血清',
  'blood_plasma': '血液-血浆',
  'stool': '大便',
  'tissue': '组织',
  'cell': '细胞',
  'unknown': '未知',
  'other': '其他',
  '其他后端返回的类型': '显示名称'
}

// 获取数据
const fetchSampleTypeData = async () => {
  try {
    const response = await SampleApi.getSampleTypeCount()
    sampleTypeData.value = response || []
    console.log('样本类型数据:', sampleTypeData.value)
    // 计算总样本数
    totalSamples.value = sampleTypeData.value.reduce((sum, item) => sum + (item.count || 0), 0)
    
    // 计算总样本数的进度条高度（基于最大样本类型的百分比）
    if (sampleTypeData.value.length > 0) {
      const maxCount = Math.max(...sampleTypeData.value.map(item => item.count || 0))
      totalPercentage.value = Math.min(100, Math.max(20, (totalSamples.value / maxCount) * 80))
    }
    
    // ElMessage.success('数据加载成功')
  } catch (error) {
    console.error('获取样本类型数据失败:', error)
    // ElMessage.error('数据加载失败')
  }
}

// 刷新数据
const refreshData = () => {
  fetchSampleTypeData()
}

// 计算进度条百分比
const calculatePercentage = (count) => {
  if (totalSamples.value === 0) return 0
  return Math.min(100, Math.max(20, (count / totalSamples.value) * 100))
}

// 获取进度条背景色
const getProgressBarColor = (index) => {
  return colorConfig[index % colorConfig.length]?.bar || 'rgba(22, 93, 255, 0.2)'
}

// 获取进度条值颜色
const getProgressValueColor = (index) => {
  return colorConfig[index % colorConfig.length]?.value || '#1d87e9'
}

// 获取显示名称
const getDisplayName = (sampleType) => {
  return sampleTypeDisplayNames[sampleType] || sampleType || '未知'
}

// 格式化数字（添加千位分隔符）
const formatNumber = (num) => {
  if (num === null || num === undefined) return '0'
  return num.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',')
}

// 组件挂载时获取数据
onMounted(() => {
  fetchSampleTypeData()
})
</script>

<style scoped>
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.card-list {
  display: flex;
  flex-wrap: wrap;
  gap: 16px;

  .card-item {
    display: flex;
    flex: 1;
    min-width: 180px;
    max-width: 220px;

    .progress-bar {
      float: left;
      width: 4px;
      height: 62px;
      margin-right: 8px;
      border-radius: 2px;
      position: relative;
      background-color: rgba(22, 93, 255, 0.2);

      .progress-value {
        width: 4px;
        position: absolute;
        bottom: 0;
        left: 0;
        border-radius: 2px;
        background-color: #1d87e9;
        transition: height 0.3s ease;
      }
    }

    .content {
      display: flex;
      flex-direction: column;
      justify-content: center;

      .title {
        font-size: 14px;
        line-height: 22px;
        letter-spacing: 0px;
        color: #4e5969;
        margin-bottom: 4px;
      }

      .value {
        font-size: 24px;
        line-height: 32px;
        letter-spacing: 0px;
        color: #1d2129;
        font-weight: bold;
      }
    }
  }
}

/* 响应式设计 */
@media (max-width: 1200px) {
  .card-list {
    .card-item {
      min-width: 160px;
    }
  }
}

@media (max-width: 768px) {
  .card-list {
    .card-item {
      min-width: 140px;
      
      .content {
        .title {
          font-size: 12px;
        }
        
        .value {
          font-size: 20px;
        }
      }
    }
  }
}
</style>