<template>
  <div class="dynamic-page">
    <el-card>
      <div style="margin-bottom: 16px;">
        <el-select v-model="selectedModule" placeholder="选择模块" @change="loadFields">
          <el-option v-for="m in modules" :key="m.moduleCode" :label="m.moduleName" :value="m.moduleCode" />
        </el-select>
      </div>

      <el-form :model="formData" ref="formRef" label-width="140px">
        <el-row :gutter="16">
          <el-col :span="12" v-for="field in fields" :key="field.fieldName">
            <el-form-item :label="field.fieldLabel" :prop="field.fieldName" :rules="getRules(field)">
              <component
                :is="resolveComponent(field.fieldType)"
                v-model="formData[field.fieldName]"
                v-bind="getComponentProps(field)"
              >
                <template v-if="field.fieldType === 'select'">
                  <el-option
                    v-for="(label, key) in parseOptions(field.optionsJson)"
                    :key="key" :label="label" :value="key"
                  />
                </template>
              </component>
            </el-form-item>
          </el-col>
        </el-row>

        <div style="margin-top: 12px;">
          <el-button type="primary" @click="submit">保存</el-button>
          <el-button @click="reset">重置</el-button>
        </div>
      </el-form>

      <div style="margin-top: 24px;">
        <h3>示例表格（动态列）</h3>
        <el-table :data="tableData" stripe>
          <el-table-column prop="personId" label="personId" width="120" />
          <el-table-column v-for="field in fields" :key="field.fieldName" :prop="field.fieldName" :label="field.fieldLabel" />
        </el-table>
      </div>
    </el-card>
  </div>
</template>

<script lang="ts">
import { defineComponent, reactive, ref, onMounted } from 'vue';
import { FieldConfigApi } from '@/api/queueDB/fieldconfig';

export default defineComponent({
  name: 'DynamicModulePage',
  setup() {
    // 示例模块列表（实际应从 /api/module-config 获取模块树）
    const modules = reactive([
      { moduleCode: 'smoking_current', moduleName: '吸烟' },
      { moduleCode: 'smoking_quit', moduleName: '已戒烟' },
    ]);

    const selectedModule = ref(modules[0].moduleCode);
    const fields = ref<any[]>([]);
    const formData = reactive<Record<string, any>>({});
    const tableData = ref<any[]>([
      { personId: 1, daily_smoke_count: 10, smoke_years: 5 },
      { personId: 2, daily_smoke_count: 0, smoke_years: 0 }
    ]);

    async function loadFields(moduleCode?: string) {
      const code = moduleCode || selectedModule.value;
      const res: any = await FieldConfigApi.listByModuleCode(code);
      const list = res.data || res; // 取决于后端返回包装
      fields.value = list;
      // 初始化 formData
      fields.value.forEach((f: any) => {
        formData[f.fieldName] = null;
      });
    }

    function resolveComponent(type: string) {
      switch (type) {
        case 'number': return 'el-input-number';
        case 'select': return 'el-select';
        case 'date': return 'el-date-picker';
        case 'checkbox': return 'el-checkbox';
        default: return 'el-input';
      }
    }

    function parseOptions(optionsJson: string) {
      if (!optionsJson) return {};
      try { return JSON.parse(optionsJson); } catch (e) { return {}; }
    }

    function getComponentProps(field: any) {
      if (field.fieldType === 'date') {
        return { type: 'date', placeholder: '请选择日期' };
      }
      if (field.fieldType === 'select') {
        return { placeholder: '请选择' };
      }
      if (field.fieldType === 'number') {
        return { precision: 0, controlsPosition: 'right' };
      }
      return {};
    }

    function getRules(field: any) {
      const rules: any[] = [];
      if (field.isRequired) {
        rules.push({ required: true, message: `${field.fieldLabel} 为必填`, trigger: 'blur' });
      }
      return rules;
    }

    function reset() {
      fields.value.forEach((f: any) => formData[f.fieldName] = null);
    }

    function submit() {
      // 将 formData 提交到后端动态表插入接口（例如 /api/queue-db/dynamic/{moduleCode}/save）
      console.log('submit', formData);
    }

    onMounted(() => {
      loadFields();
    });

    return {
      modules,
      selectedModule,
      fields,
      formData,
      tableData,
      loadFields,
      resolveComponent,
      parseOptions,
      getComponentProps,
      getRules,
      submit,
      reset
    };
  }
});
</script>

<style scoped>
.dynamic-page { padding: 12px; }
</style>
