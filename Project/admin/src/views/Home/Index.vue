<template>
  <div class="home">
    <div class="overview-graph">
      <div class="overview-graph__side-title">数据图谱</div>
      <button
        class="overview-graph__icon-btn overview-graph__icon-btn--floating"
        type="button"
        aria-label="展开图谱"
        @click="graphExpanded = true"
      >
        <span class="overview-graph__icon overview-graph__icon--expand">
          <span></span>
          <span></span>
        </span>
      </button>
      <div class="overview-graph__body">
        <div class="overview-graph__preview">
          <GraphView preview />
        </div>
      </div>
    </div>

    <div v-if="graphExpanded" class="overview-graph-modal" @click.self="graphExpanded = false">
      <div class="overview-graph-modal__panel">
        <div class="overview-graph-modal__header">
          <div class="overview-graph-modal__title"></div>
          <button
            class="overview-graph__icon-btn"
            type="button"
            aria-label="收起图谱"
            @click="graphExpanded = false"
          >
            <span class="overview-graph__icon overview-graph__icon--collapse">
              <span></span>
              <span></span>
            </span>
          </button>
        </div>
        <div class="overview-graph-modal__body">
          <GraphView />
        </div>
      </div>
    </div>

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

        <div class="card" @click="handleClick('/VipChart')">
          <div class="card-title">多组学数据库</div>
          <div class="card-sub">Integrated Multi-Omics Database</div>
          <div class="card-btn">点击查看</div>
        </div>
      </div>
    </div>

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

    <div class="section green">
      <div class="section-title">预测模型</div>
      <div class="card-grid two">
        <div class="card" @click="handleClick('/reportPage')">
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
import GraphView from '../graph/index.vue'

const router = useRouter()
const graphExpanded = ref(false)

const handleClick = (path: string) => {
  if (!path) return
  router.push(path)
}
</script>

<style scoped lang="scss">
.home {
  min-height: 100vh;
}

.overview-graph {
  position: relative;
  margin: 0px 80px 0 40px;
  background: #fff;
  border-radius: 12px;
  box-shadow: 0 6px 18px rgba(0, 0, 0, 0.08);
  overflow: hidden;
}

.overview-graph__side-title {
  position: absolute;
  left: 0;
  top: 0;
  bottom: 0;
  width: 80px;
  display: flex;
  align-items: center;
  justify-content: center;
  writing-mode: vertical-rl;
  text-orientation: mixed;
  letter-spacing: 4px;
  font-size: 20px;
  font-weight: 600;
  background: #e6f2ff;
  color: #0a76b6;
}

.overview-graph__icon-btn {
  width: 34px;
  height: 34px;
  border: 1px solid rgba(37, 99, 235, 0.12);
  background: #fff;
  border-radius: 10px;
  display: inline-flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  transition: all 0.2s ease;
}

.overview-graph__icon-btn:hover {
  background: #eff6ff;
  border-color: rgba(37, 99, 235, 0.28);
}

.overview-graph__icon-btn--floating {
  position: absolute;
  top: 12px;
  right: 12px;
  z-index: 5;
  box-shadow: 0 8px 20px rgba(15, 23, 42, 0.1);
}

.overview-graph__icon {
  position: relative;
  width: 16px;
  height: 16px;
  display: inline-block;
}

.overview-graph__icon span {
  position: absolute;
  width: 7px;
  height: 7px;
  border-color: #111827;
  border-style: solid;
}

.overview-graph__icon--expand span:first-child {
  top: 0;
  right: 0;
  border-width: 2px 2px 0 0;
}

.overview-graph__icon--expand span:last-child {
  bottom: 0;
  left: 0;
  border-width: 0 0 2px 2px;
}

.overview-graph__icon--collapse span:first-child {
  top: 0;
  left: 0;
  border-width: 2px 0 0 2px;
}

.overview-graph__icon--collapse span:last-child {
  right: 0;
  bottom: 0;
  border-width: 0 2px 2px 0;
}

.overview-graph__body {
  position: relative;
  height: 96px;
  margin-left: 80px;
  overflow: hidden;
  display: flex;
  align-items: flex-start;
  justify-content: center;
  background: linear-gradient(180deg, #f8fbff 0%, #eef4ff 100%);
}

.overview-graph__preview {
  position: relative;
  width: 1400px;
  flex: 0 0 auto;
  pointer-events: none;
  transform-origin: left top;
  transform: translateX(96px) translateY(-74px) scale(1);
}

.overview-graph__preview :deep(.mind-map-wrapper) {
  min-height: 260px;
  padding-top: 0;
  background: transparent;
}

.overview-graph-modal {
  position: fixed;
  inset: 0;
  z-index: 2000;
  display: flex;
  align-items: center;
  justify-content: center;
  background: rgba(15, 23, 42, 0.42);
  padding: 32px;
}

.overview-graph-modal__panel {
  width: min(1380px, calc(100vw - 64px));
  max-height: calc(100vh - 64px);
  background: #fff;
  border-radius: 16px;
  overflow: hidden;
  box-shadow: 0 24px 80px rgba(15, 23, 42, 0.28);
}

.overview-graph-modal__header {
  display: flex;
  align-items: center;
  justify-content: flex-end;
  padding: 16px 20px 12px;
}

.overview-graph-modal__title {
  display: none;
}

.overview-graph-modal__body {
  max-height: calc(100vh - 132px);
  overflow: auto;
  background: linear-gradient(180deg, #f8fbff 0%, #eef4ff 100%);
}

.overview-graph-modal__body :deep(.mind-map-wrapper) {
  min-height: 800px;
}

.section {
  display: flex;
  align-items: stretch;
  margin: 20px 80px 20px 40px;
  background: #fff;
  border-radius: 12px;
  box-shadow: 0 6px 18px rgba(0, 0, 0, 0.08);
  overflow: hidden;
}

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

.blue .section-title {
  background: #e6f2ff;
  color: #0a76b6;
}

.pink .section-title {
  background: #fff5f6;
  color: #9d520c;
}

.green .section-title {
  background: #e6fbcd;
  color: #0d8120;
}

.card-grid {
  flex: 1;
  padding: 10px 15px 10px 200px;
  display: grid;
  grid-template-columns: repeat(2, minmax(0, 1fr));
  gap: 15px;
}

.card-grid.two {
  grid-template-columns: repeat(2, 1fr);
}

.card {
  background: linear-gradient(180deg, #e6f2ff, #b6e3ff);
  border-radius: 12px;
  padding: 24px;
  cursor: pointer;
  transition: all 0.3s ease;
  position: relative;
  min-height: 130px;
  width: 100%;
  height: 150px;
  color: #2717a4;
}

.pink .card {
  background: linear-gradient(180deg, #fff5f6, #fbe4e7);
  color: #9d0c0c;
}

.green .card {
  background: linear-gradient(180deg, #e6fbcd, #e6fbcd);
  color: #044114;
}

.card:hover {
  transform: translateY(-4px);
  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
}

.highlight {
  border: 2px solid #3b82f6;
}

.card-title {
  font-size: 30px;
  font-weight: 700;
  margin-bottom: 10px;
}

.card-sub {
  font-size: 13px;
  color: #6057a8;
  margin-bottom: 20px;
}

.card-btn {
  font-size: 13px;
  color: #2717a4;
  position: absolute;
  bottom: 20px;
  right: 25px;
}

.pink .card-btn {
  color: #9d0c0c;
}

.green .card-btn {
  color: #044114;
}
</style>
