<template>
  <el-table-column label="个人信息" align="center">
    <el-table-column
      v-for="column in columns"
      :key="column.name"
      :prop="column.name"
      :label="column.label"
      :width="column.width"
    />
  </el-table-column>
</template>



<script>
export default {
    data() {
        return {
            columns: [
                { label: "性别", prop: '' },
                { label: "出生年月", prop: '' },
                { label: "婚姻", prop: '' },
                { label: "民族", prop: '' },
                { label: "最高学历", prop: '' },
                { label: "生育情况", prop: '' },
                { label: "证件号", prop: '' },
                { label: "与同龄人相比，您认为目前自己的身体健康状况如何", prop: '', width:320},
                { label: "您认为自己身体健康状况能得__分", prop: '', width:220},
            ]
        }
    }
}

</script>
