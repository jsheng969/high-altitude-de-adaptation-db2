<template>
  <div class="home">
    <div class="container">
      <el-row>
        <el-col :span="12" class="card">
          <!-- <div class="image-container" @click="handleClick('/prospective')"> -->
            <div class="image-container" @click="handleClick('/queueDB')">
            <img src="@/assets/images/new-home-block.png" />
            <div class="image-text">
              <div>前瞻性队列数据库</div>
            </div>
            <div class="image-text-english">
              <div>Prospective cohort database</div>
            </div>
            <div class="image-button">
              <div>点击查看</div>
            </div>
            <!-- 右下角图片 -->
            <img class="corner-image" src="@/assets/images/coding@1x.png" />
          </div>
        </el-col>
        <el-col :span="12" class="card">
          <div class="image-container" @click="handleClick('/prospective2')">
            <img src="@/assets/images/new-home-block.png" />
            <div class="image-text">
              <div>回顾性队列数据库</div>
              </div>
            <div class="image-text-english">
              <div>Retrospective cohort database</div>
            </div>
            <div class="image-button">
              <div>点击查看</div>
            </div>
            <!-- 右下角图片 -->
            <img class="corner-image" src="@/assets/images/data-visualization@1x.png" />
          </div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12" class="card">
          <div class="image-container" @click="handleClick('/biobank')">
            <img src="@/assets/images/new-home-block.png" />
            <div class="image-text">
              <div>生物样本库</div>
              </div>
            <div class="image-text-english">
              <div>Biological sample bank</div>
            </div>
            <div class="image-button">
              <div>点击查看</div>
            </div>
            <!-- 右下角图片 -->
            <img class="corner-image" src="@/assets/images/health@1x.png" />
          </div>
        </el-col>
        <el-col :span="12" class="card">
          <div class="image-container">
            <img src="@/assets/images/new-home-block.png" />
            <div class="image-text">
              <div>高原作业能力分析</div>
              </div>
            <div class="image-text-english">
              <div>High-altitude operation capability</div>
            </div>
            <div class="image-button">
              <div>点击查看</div>
            </div>
            <!-- 右下角图片 -->
            <img class="corner-image" src="@/assets/images/search@1x.png" />
          </div>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="12" class="card">
          <div class="image-container" @click="handleClick('VipChart')">
            <img src="@/assets/images/new-home-block.png" />
            <div class="image-text">
              <div>多组学数据库</div>
              </div>
            <div class="image-text-english">
              <div>Multigene database</div>
            </div>
            <div class="image-button">
              <div>点击查看</div>
            </div>
            <!-- 右下角图片 -->
            <img class="corner-image" src="@/assets/images/vaccine@1x.png" />
          </div>
        </el-col>
        <el-col :span="12" class="card">
          <div class="image-container" @click="handleClick('/biobank')">
            <img src="@/assets/images/new-home-block.png" />
            <div class="image-text">
              <div>平台管理</div>
              </div>
            <div class="image-text-english">
              <div>Platform management</div>
            </div>
            <div class="image-button">
              <div>点击查看</div>
            </div>
            <!-- 右下角图片 -->
            <img class="corner-image" src="@/assets/images/system@1x.png" />
          </div>
        </el-col>
      </el-row>
    </div>

    <div v-if="!showOperatorLog" @click="showOperatorLog = true" class="right-button">操作日志</div>

    <el-card v-if="!!showOperatorLog" class="log-card">
      <template #header>
        <div class="clearfix">
          <span>操作日志</span>
          <el-button @click="showOperatorLog = false" class="hide-button" type="text">
            <svg viewBox="0 0 1024 1024" width="10" height="10">
              <path
                d="M322.9568 973.5936l-81.4592-81.4592L621.6448 512 241.4976 131.8528l81.4592-81.4592L784.5632 512 322.944 973.5936z"
                fill="#4C4C4C"
                p-id="5948"
              />
            </svg>
            收起</el-button
          >
        </div>
      </template>
      <div v-for="o in 4" :key="o" class="log-text">
        <div>{{ '张三 上传数据到' }}</div>
        <div>2024-02-{{ o }} 18:21</div>
      </div>
    </el-card>
  </div>
</template>

<script setup lang="ts">
const router = useRouter() // 路由
const showOperatorLog = ref(false)
const goTarget = (href) => {
  window.open(href, '_blank')
}
const handleClick = (routerName) => {
  router.push({ name: routerName })
}
</script>

<style scoped lang="scss">
.home {
  background-color: #f2f2f2;
  height: 100%;
  display: flex;
}

.container {
  margin: auto auto;
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  justify-content: space-between;
  width: 1000px;
}

.card {
  padding: 10px;
}

.card img {
  width: 100%;
  user-select: none;
  cursor: pointer;
  pointer-events: visible;
}

.card img:hover {
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
}

.right-button {
  display: flex;
  align-items: center;
  position: absolute;
  font-size: 14px;
  top: 116px;
  right: 0px;
  width: 30px;
  height: 96px;
  border-radius: 10px 0px 0px 10px;
  background: #ffffff;
  color: #165dff;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
  text-align: center;
  padding: 6px;
  line-height: 14px;
  user-select: none;
  cursor: pointer;
}

.log-card {
  width: 400px;
  transition: box-shadow 0.3s ease;
  /* 为阴影添加过渡效果 */
}

.hide-button {
  float: right;
  padding: 3px 0;
  color: #999;
  font-size: 12px;
}

.log-text {
  font-size: 14px;
  line-height: 30px;
  display: flex;
  justify-content: space-between;
  user-select: none;
}

.log-text:hover {
  background-color: #f2f2f2;
}

/* 定义动画关键帧 */
@keyframes log-card-animation {
  0% {
    transform: translateX(100%);
    opacity: 0;
  }

  100% {
    transform: translateX(0);
    opacity: 1;
  }
}

.image-container {
  position: relative;
  display: inline-block; /* 或者根据需求设置其他display值 */
}

.image-text {
  position: absolute;
  top: 40px; /* 距离底部距离 */
  left: 30px; /* 距离左侧距离 */
  color: #02184d; /* 文字颜色 */
  font-size: 32px; /* 文字大小 */
  font-weight: 600; /* 文字粗细 */
}
.image-text-english {
  position: absolute;
  top: 82px; /* 距离底部距离 */
  left: 30px; /* 距离左侧距离 */
  color: #425d9b; /* 文字颜色 */
  font-size: 15px; /* 文字大小 */
  font-weight: 600; /* 文字粗细 */
}

.image-text2 {
  position: absolute;
  top: 35px; /* 距离底部距离 */
  left: 30px; /* 距离左侧距离 */
  color: #165dff; /* 文字颜色 */
  font-size: 22px; /* 文字大小 */
  font-weight: 600; /* 文字粗细 */
}

.image-button {
  position: absolute;
  top: 120px; /* 距离底部距离 */
  left: 30px; /* 距离左侧距离 */
  color: #7683ac; /* 文字颜色 */
  font-size: 12px; /* 文字大小 */
  font-weight: 500; /* 文字粗细 */
  padding-left: 15px; /* 留出空间给箭头 */
}

.image-button::before {
  content: '';
  position: absolute;
  left: 0;
  top: 50%;
  transform: translateY(-50%);
  width: 0;
  height: 0;
  border-top: 5px solid transparent;
  border-bottom: 5px solid transparent;
  border-left: 8px solid #7683ac; /* 向右的实心三角形 */
}

.image-button2 {
  position: absolute;
  top: 60px; /* 距离底部距离 */
  right: 60px; /* 距离左侧距离 */
  color: #165dff; /* 文字颜色 */
  font-size: 12px; /* 文字大小 */
  font-weight: 500; /* 文字粗细 */
  padding-left: 15px; /* 留出空间给箭头 */
}

.image-button2::before {
  content: '';
  position: absolute;
  left: 0;
  top: 50%;
  transform: translateY(-50%);
  width: 0;
  height: 0;
  border-top: 5px solid transparent;
  border-bottom: 5px solid transparent;
  border-left: 8px solid #165dff; /* 向右的实心三角形 */
}

.corner-image {
  position: absolute;
  bottom: 70px;
  right: 40px;
  width: 60px; /* 缩小宽度 */
  height: auto; /* 高度自动，保持比例 */
  max-width: 100px; /* 最大宽度限制 */
  max-height: 100px; /* 最大高度限制 */
  z-index: 2;
  pointer-events: none; /* 防止图片干扰点击事件 */
  object-fit: contain; /* 保持图片比例 */
}
</style>
