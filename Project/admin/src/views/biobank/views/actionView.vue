<template>
  <el-dialog v-model:visible="localShow" width="400px">
    <template #title>
      <div style="text-align: center">取出 / 放回样本</div>
    </template>
    <el-form :mode="form">
      <el-form-item label="选择您的操作" prop="action">
        <el-radio-group>
          <el-radio>取出样本</el-radio>
          <el-radio>放回样本</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="输入试管号" prop="tubeNumber">
        <el-input placeholder="请输入" />
      </el-form-item>

      <div class="form-foot">
        <el-button @click="localShow = false">取消</el-button>
        <el-button type="primary" @click="handleSubmit">确定</el-button>
      </div>
    </el-form>
  </el-dialog>
</template>

<script>
export default {
  props: {
    show: [Boolean]
  },
  data() {
    return {
      localShow: false,
      form: {}
    }
  },
  watch: {
    show: function (val) {
      this.localShow = val
    },
    localShow: function (val) {
      this.$emit('update:show', val)
    }
  },
  mounted() {
    this.localShow = this.show
  },
  methods: {
    handleSubmit() {}
  }
}
</script>

<style>
.form-foot {
  display: flex;
  justify-content: flex-end;
}

.descriptions-main {
  td {
    color: #000;
  }
}

.pagination-container .el-pagination {
  position: unset;
}
</style>
