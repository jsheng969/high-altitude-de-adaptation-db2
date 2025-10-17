<template>
  <div class="condition-display">
    <div v-if="conditions.length > 0" class="conditions">
      筛选条件：
      <span v-for="(condition, index) in conditions" :key="index">
        {{ condition.label }} {{ condition.operator }} {{ condition.displayText }}
        <span v-if="index < conditions.length - 1">，</span>
      </span>
    </div>
    
    <div class="statistics">
      <span>共{{ total }}人</span>
      
      <!-- 性别统计 -->
      <span v-if="hasGenderCondition">
        ，男性有{{ average.maleCount }}人，女性有{{ average.femaleCount }}人
      </span>
      
      <!-- 年龄统计 -->
      <span v-if="hasAgeCondition">
        ，平均年龄为{{ average.averageAge?.toFixed(2) }}岁（最小{{
          average.minAge?.toFixed(2)
        }}岁，最大{{ average.maxAge?.toFixed(2) }}岁）
      </span>
      
      <!-- 海拔统计 -->
      <span v-if="hasAltitudeCondition">
        ，高原服役平均海拔{{ average.averageHighlandAltitude?.toFixed(2) }}米（最高{{
          average.maxHighlandAltitude?.toFixed(2)
        }}米，最矮{{ average.minHighlandAltitude?.toFixed(2) }}米)
      </span>
      
      <!-- 更多统计信息... -->
    </div>
  </div>
</template>

<script lang="ts" setup>
import { computed } from 'vue'

interface Props {
  conditions: any[]
  total: number
  average: any
  queryParams: any
}

const props = defineProps<Props>()

const hasGenderCondition = computed(() => 
  props.conditions.some(condition => condition.field === 'gender')
)

const hasAgeCondition = computed(() => 
  props.conditions.some(condition => condition.field === 'actualAge')
)

const hasAltitudeCondition = computed(() => 
  props.conditions.some(condition => 
    condition.field.includes('altitude')
  )
)
</script>

<style scoped>
.condition-display {
  font-size: 14px;
  color: #666;
  margin-top: 10px;
}

.conditions {
  margin-bottom: 8px;
  font-weight: 500;
}

.statistics {
  color: #888;
}
</style>