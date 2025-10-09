<template>
  <el-dialog v-model:visible="localShow" width="608px">
    <template #title>
      <div style="text-align: center">试管详情</div>
    </template>

    <el-descriptions
      class="descriptions-main"
      title="N2203I241212"
      :column="3"
      direction="vertical"
    >
      <el-descriptions-item label="样本类型">123</el-descriptions-item>
      <el-descriptions-item label="样本所属人员编号">123</el-descriptions-item>
      <el-descriptions-item label="所属盒号">123</el-descriptions-item>
      <el-descriptions-item label="所属柜名">123</el-descriptions-item>
      <el-descriptions-item label="总可用次数">123</el-descriptions-item>
      <el-descriptions-item label="当前剩余可用次数">123</el-descriptions-item>
      <el-descriptions-item label="当前状态">
        <el-tag size="small">取出</el-tag></el-descriptions-item
      >
    </el-descriptions>

    <div>使用记录</div>
    <el-table :data="localData">
      <el-table-column label="序号" prop="id" />
      <el-table-column label="使用者" />
      <el-table-column label="行为">
        <template>
          <el-tag size="small">取出</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="时间" />
    </el-table>

    <div style="display: flex; justify-content: center">
      <pagination
        :total="total"
        v-model:page="queryParams.pageNum"
        v-model:limit="queryParams.pageSize"
        @pagination="getList"
        layout="prev, pager, next"
      />
    </div>
  </el-dialog>
</template>

<script>
export default {
  props: {
    show: [Boolean],
    title: [String]
  },
  data() {
    return {
      localShow: false,
      columns: ['1', '2', '3', '4', '5', '6', '7', '8', '9'], // 行标识数组
      rows: ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'], // 列标识数组

      localData: [{ id: 1 }],
      total: 0,
      queryParams: {}
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
  }
}
</script>

<style>
.descriptions-main {
  td {
    color: #000;
  }
}

.pagination-container .el-pagination {
  position: unset;
}
</style>
