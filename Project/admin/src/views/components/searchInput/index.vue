<template>
  <el-autocomplete
    v-model="inputValue"
    :fetch-suggestions="querySearch"
    placeholder="请输入关键词"
    @select="handleSelect"
    :suffix-icon="'el-icon-search'"
  >
    <template #default="{ item }">
      {{ item.label }}
    </template>
  </el-autocomplete>
</template>

<script>
export default {
  data() {
    return {
      inputValue: '',
      suggestions: [] // 保存查询结果的数组
    }
  },
  computed: {
    mockData() {
      // 模拟的后端数据
      return [
        { value: '1', label: 'Option 1' },
        { value: '2', label: 'Option 2' },
        { value: '3', label: 'Option 3' },
        { value: '4', label: 'Option 4' },
        { value: '5', label: 'Option 5' }
      ]
    }
  },
  methods: {
    querySearch(queryString, cb) {
      // 模拟发送请求到后端查询数据
      // 这里需要根据实际情况替换成您的后端接口
      // 示例中使用setTimeout模拟异步请求
      setTimeout(() => {
        // 模拟从后端返回的数据
        const results = this.mockData.filter((item) =>
          item.label.toLowerCase().includes(queryString.toLowerCase())
        )
        // 更新建议列表
        this.suggestions = results
        // 将结果传递给回调函数
        cb(results)
      }, 300)
    },
    handleSelect(item) {
      // 处理选择项的逻辑，这里可以根据需要进行相应的操作
      console.log('Selected item:', item)
    }
  }
}
</script>
