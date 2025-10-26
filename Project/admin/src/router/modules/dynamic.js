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
    }
  ]
}