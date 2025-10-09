<template>
    <div>
        <div class="total-text">对应数据共计 18,872 条</div>
        <div class="data-table">
            <el-table :data="tableData" style="width: 100%;">
                {{ tableColumns }}
                <el-table-column
v-for="(group, groupIndex) in tableColumns" :key="`group-${groupIndex}`" :prop="group.prop" :label="group.label"
                    :width="group.width" align="center">
                    <el-table-column
v-for="(column, columnIndex) in group.columns" :key="`column-${groupIndex}-${columnIndex}`" :prop="column.prop" :label="column.label"
                        :width="column.width" align="center"/>
                </el-table-column>
            </el-table>
        </div>
    </div>
</template>


<script>
import { dataTableColumns } from './tableColumns'

export default {
    props: {
        columns: {
            type: Array,
            default: function () {
                return []
            }
        },
        data: {
            type: Array,
            default: function () {
                return []
            }
        },
    },
    data() {
        return {
            tableColumns: [],
            tableData: [{
                date: '201-003',
                name: '王小虎',
                province: '上海',
                city: '普陀区',
                address: '上海市普陀区金沙江路 1518 弄',
                zip: 200333
            }, {
                date: '201-008',
                name: '王小虎',
                province: '上海',
                city: '普陀区',
                address: '上海市普陀区金沙江路 1518 弄',
                zip: 200333
            }, {
                date: '201-006',
                name: '王小虎',
                province: '上海',
                city: '普陀区',
                address: '上海市普陀区金沙江路 1518 弄',
                zip: 200333
            }, {
                date: '201-007',
                name: '王小虎',
                province: '上海',
                city: '普陀区',
                address: '上海市普陀区金沙江路 1518 弄',
                zip: 200333
            }]
        }
    },
    watch: {
        columns: function () {
            this.updateColumns();
        }
    },
    mounted() {
        this.updateColumns();
    },
    methods: {
        updateColumns: function () {
            let columns = this.columns;
            this.tableColumns = dataTableColumns.filter(x => !x.label || columns.findIndex(y => (y.prop == x.prop && y.label == x.label)) >= 0);
        }
    }
}
</script>


<style>
.total-text {
    font-size: 14px;
    line-height: 16.38px;
    letter-spacing: 0px;
    color: rgba(0, 0, 0, 0.4);
    margin-bottom: 19px;
}

.data-table {
    overflow-x: auto;
}
</style>./tableColumns.js