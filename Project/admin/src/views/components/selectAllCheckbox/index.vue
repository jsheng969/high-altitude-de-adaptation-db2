<template>
    <div style="display: flex; gap: 30px;">
      <el-checkbox
        label="全部"
        :indeterminate="isIndeterminate"
        :checked="isCheckAll"
        @change="handleCheckAllChange"
      />
      <el-checkbox-group v-model="innerValue" @change="handleGroupChange">
        <el-checkbox v-for="(item, index) in items" :key="index" :label="item" />
      </el-checkbox-group>
    </div>
  </template>
  
  <script>
  export default {
    name: 'SelectAllCheckbox',
    props: {
      modelValue: {
        type: Array,
        default: () => []
      },
      items: {
        type: Array,
        default: () => []
      }
    },
    emits: ['update:modelValue'],
    data() {
      return {
        innerValue: [] // 用于内部绑定的真实值
      }
    },
    computed: {
      isCheckAll() {
        return this.innerValue.length === this.items.length
      },
      isIndeterminate() {
        return this.innerValue.length > 0 && this.innerValue.length < this.items.length
      }
    },
    watch: {
      modelValue: {
        immediate: true,
        handler(val) {
          this.innerValue = [...val]
        }
      }
    },
    methods: {
      handleGroupChange(val) {
        this.$emit('update:modelValue', val)
      },
      handleCheckAllChange(checked) {
        const newValue = checked ? [...this.items] : []
        this.innerValue = newValue
        this.$emit('update:modelValue', newValue)
      }
    }
  }
  </script>