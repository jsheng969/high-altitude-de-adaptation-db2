<template>
    <el-card>
        <template #header>
<div  class="card-title">
            <span>选择要查看的样本库</span>
        </div>
</template>

        <el-form class="query-form">
            <el-form-item prop="queryParams">
                <el-checkbox-group v-model="queryParams">
                    <el-checkbox label="前瞻性队列数据样本-一次"/>
                    <el-checkbox label="前瞻性队列数据样本-二次"/>
                    <el-checkbox label="前瞻性队列数据样本-三次"/>
                    <el-checkbox label="回顾性队列数据样本"/>
                </el-checkbox-group>
            </el-form-item>

            <div>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">展示所选样本库</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置条件</el-button>
            </div>
        </el-form>
    </el-card>
</template>

<script>
import '../styles.css'

export default {
    data() {
        return {
            queryParams: []
        }
    },
    methods: {
        reset(){
            this.queryParams.splice(0);
        },
        handleQuery() {

        },
        resetQuery() {
            this.reset();
        }
    }
}
</script>


<style>

.query-form {
    .el-form-item {
        margin-bottom: 8px;
    }
}
</style>