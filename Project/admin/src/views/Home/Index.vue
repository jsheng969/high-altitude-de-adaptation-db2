<template>
  <div class="home">
    <!-- ===== 表型组数据库 ===== -->
    <div class="section blue">
      <div class="section-title">表型组数据库</div>
      <div class="card-grid">
        <div class="card" @click="handleClick('/ProspectiveDataView')">
          <div class="card-title">急进（前瞻）数据库</div>
          <div class="card-sub">Rapid Deployment Cohort Database</div>
          <div class="card-btn">点击查看</div>
        </div>

        <div class="card" @click="handleClick('/RetrospectiveDataView')">
          <div class="card-title">长驻（回顾）数据库</div>
          <div class="card-sub">Stationary Cohort Database</div>
          <div class="card-btn">点击查看</div>
        </div>

        <div class="card highlight" @click="handleClick('/PlateauAbilityDataView')">
          <div class="card-title">高原作业能力分析库</div>
          <div class="card-sub">High-Altitude Work Capacity & Fitness Database</div>
          <div class="card-btn">点击查看</div>
        </div>

        <div class="card" @click="handleClick('VipChart')">
          <div class="card-title">多组学数据库</div>
          <div class="card-sub">Integrated Multi-Omics Database</div>
          <div class="card-btn">点击查看</div>
        </div>
      </div>
    </div>

    <!-- ===== 样本库 ===== -->
    <div class="section pink">
      <div class="section-title">样本库</div>
      <div class="card-grid two">
        <div class="card" @click="handleClick('/biobank')">
          <div class="card-title">急进（前瞻）样本库</div>
          <div class="card-btn">点击查看</div>
        </div>

        <div class="card" @click="handleClick('/indexReview')">
          <div class="card-title">常驻（回顾）样本库</div>
          <div class="card-btn">点击查看</div>
        </div>
      </div>
    </div>

    <!-- ===== 预测模型 ===== -->
    <div class="section green">
      <div class="section-title">预测模型</div>
      <div class="card-grid two">
        <div class="card"  @click="handleClick('/reportPage')">
          <div class="card-title">急慢性高原病预测模型</div>
          <div class="card-btn">点击查看</div>
        </div>

        <div class="card" @click="handleClick('/AltitudeModel')">
          <div class="card-title">高原作业能力评估模型</div>
          <div class="card-btn">点击查看</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
const router = useRouter()

const handleClick = (path: string) => {
  if (!path) return
  router.push(path)
}
</script>

<style scoped lang="scss">
.home {
  min-height: 100vh;  // 改成最小高度
}

/* ===== 每个区块 ===== */
.section {
  display: flex;
  align-items: stretch;  // 保证左右高度一致
  margin: 20px 80px 20px 40px;
  background: #fff;
  border-radius: 12px;
  box-shadow: 0 6px 18px rgba(0, 0, 0, 0.08);
  overflow: hidden;
}

/* 左侧竖标题 */
.section-title {
  width: 80px;
  writing-mode: vertical-rl;
  text-orientation: mixed;
  font-size: 20px;
  font-weight: 600;
  letter-spacing: 4px;
  display: flex;
  align-items: center;
  justify-content: center;
}

/* 不同颜色主题 */
.blue .section-title {
  background: #E6F2FF;
  color: #0A76B6;
}

.pink .section-title {
  background: #FFF5F6;
  color: #9D520C;
}

.green .section-title {
  background: #E6FBCD;
  color: #0D8120;
}

/* 卡片网格 */
.card-grid {
  flex: 1;
  padding: 10px 15px 10px 200px;  // 左边为 0
  display: grid;
  grid-template-columns: repeat(2, minmax(0, 1fr));
  gap: 15px;
}

.card-grid.two {
  grid-template-columns: repeat(2, 1fr);
}

/* 卡片样式 */
.card {
  background: linear-gradient(180deg, #E6F2FF, #B6E3FF);
  border-radius: 12px;
  padding: 24px;
  cursor: pointer;
  transition: all 0.3s ease;
  position: relative;
  min-height: 130px;
  width: 100%;   // 改成占满 grid
  height: 150px;
  color: #2717A4;
}

.pink .card {
  background: linear-gradient(180deg, #FFF5F6, #FBE4E7);
  color: #9D0C0C;
}

.green .card {
  background: linear-gradient(180deg, #E6FBCD, #E6FBCD);
  color: #044114;
}

.card:hover {
  transform: translateY(-4px);
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
}

/* 高亮卡片 */
.highlight {
  border: 2px solid #3b82f6;
}

/* 标题 */
.card-title {
  font-size: 30px;
  font-weight: 700;
  margin-bottom: 10px;
}

/* 英文副标题 */
.card-sub {
  font-size: 13px;
  color: #6057A8;
  margin-bottom: 20px;
}

/* 按钮 */
.card-btn {
  font-size: 13px;
  color: #1e3a8a;
  position: absolute;
  bottom: 20px;
  right: 25px;
}

.card-btn {
  font-size: 13px;
  color: #2717A4;
  position: absolute;
  bottom: 20px;
  right: 25px;
}

.pink .card-btn {
  font-size: 13px;
  color: #9D0C0C;
  position: absolute;
  bottom: 20px;
  right: 25px;
}

.green .card-btn {
  font-size: 13px;
  color: #044114;
  position: absolute;
  bottom: 20px;
  right: 25px;
}

</style>