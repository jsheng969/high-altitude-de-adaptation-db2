<template>
  <div class="ability-home">
    <div class="container">
      <div class="header">
        <h1>能力模型评估系统</h1>
        <p>选择对应的功能模块，进行模型训练或结果预测</p>
      </div>

      <div class="card-grid">
        <div class="card" @click="goPage('/ability-model/brain-train')">
          <h2>脑力作业模型训练</h2>
          <p>训练针对脑力表现的评估模型</p>
          <div class="action-btn">进入训练</div>
        </div>

        <div class="card" @click="goPage('/ability-model/physical-train')">
          <h2>体力作业模型训练</h2>
          <p>训练针对体力表现的评估模型</p>
          <div class="action-btn">进入训练</div>
        </div>

        <div class="card" @click="goPage('/ability-model/operation-train')">
          <h2>精确操作模型训练</h2>
          <p>训练针对精确操作的评估模型</p>
          <div class="action-btn">进入训练</div>
        </div>

        <div class="card" @click="goPage('/ability-model/brain-prediction')">
          <h2>脑力作业预测</h2>
          <p>使用训练好的模型预测脑力表现</p>
          <div class="action-btn">开始预测</div>
        </div>

        <div class="card" @click="goPage('/ability-model/physical-prediction')">
          <h2>体力作业预测</h2>
          <p>使用训练好的模型预测体力表现</p>
          <div class="action-btn">开始预测</div>
        </div>
        
        <div class="card" @click="goPage('/ability-model/operation-prediction')">
          <h2>精确操作预测</h2>
          <p>使用训练好的模型预测精确操作表现</p>
          <div class="action-btn">开始预测</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router'

const router = useRouter()

const goPage = (path: string) => {
  if (!path) return
  router.push(path)
}
</script>

<style scoped lang="scss">
.ability-home {
  min-height: calc(100vh - 50px);
  background: #f5f7fa;
  padding: 24px;
}

.container {
  max-width: 1200px;
  margin: 0 auto;
}

.header {
  text-align: center;
  margin-bottom: 32px;

  h1 {
    color: #303133;
    font-size: 32px;
    font-weight: 700;
    margin: 0 0 10px;
  }

  p {
    color: #909399;
    font-size: 14px;
    margin: 0;
  }
}

.card-grid {
  display: grid;
  grid-template-columns: repeat(3, minmax(0, 1fr));
  gap: 24px;
}

.card {
  background: #fff;
  border-radius: 12px;
  padding: 28px 24px;
  text-align: center;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.06);
  transition:
    transform 0.25s ease,
    box-shadow 0.25s ease;
  cursor: pointer;
  border-top: 4px solid transparent;

  &:hover {
    transform: translateY(-4px);
    box-shadow: 0 8px 24px rgba(0, 0, 0, 0.1);
  }

  h2 {
    color: #303133;
    margin: 0 0 12px;
    font-size: 22px;
    font-weight: 600;
    line-height: 1.4;
  }

  p {
    color: #909399;
    margin: 0 0 22px;
    min-height: 44px;
    line-height: 1.6;
    font-size: 14px;
  }
}

.action-btn {
  display: inline-block;
  padding: 10px 22px;
  color: #fff;
  border-radius: 4px;
  font-size: 14px;
  line-height: 1;
  transition: opacity 0.2s ease;
}

.card .action-btn {
  background: #009688;
}

.card:hover .action-btn {
  opacity: 0.92;
}

@media screen and (max-width: 992px) {
  .card-grid {
    grid-template-columns: repeat(2, minmax(0, 1fr));
  }
}

@media screen and (max-width: 768px) {
  .ability-home {
    padding: 16px;
  }

  .header {
    margin-bottom: 24px;

    h1 {
      font-size: 26px;
    }
  }

  .card-grid {
    grid-template-columns: 1fr;
    gap: 16px;
  }

  .card {
    padding: 22px 18px;
  }
}
</style>