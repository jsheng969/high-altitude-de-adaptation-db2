export default {
  path: '/dynamic',
  component: Layout,
  redirect: '/dynamic',
  name: 'Dynamic',
  meta: { title: '动态模块', icon: 'el-icon-s-management' },
  children: [
    {
      path: 'import',
      component: () => import('@/views/dynamic/ExcelImport'),
      name: 'ExcelImport',
      meta: { title: 'Excel导入', icon: 'el-icon-upload' }
    },
{
  path: '/ability-model/brain-prediction',
  name: 'BrainPrediction',
  component: () => import('@/views/ability-model/brain-prediction.vue'),
  meta: {
    title: '脑力作业能力预测'
  }
}
  ]
}