<template>
  <div class="home">
    <el-card>
      <template #header>
        <div class="card-title">
          <span>筛选条件</span>
        </div>
      </template>

      <el-form
        v-model="queryParams"
        ref="queryForm"
        size="small"
        class="query-form"
        label-width="100px"
      >
        <el-form-item label="数据节点：">
          <div class="select-bar">
            <el-select
              class="select-width"
              size="small"
              clearable
              v-model="queryParams.group"
              placeholder="请选择组"
            >
              <el-option label="实验组" :value="1">实验组</el-option>
              <el-option label="对照组" :value="2">对照组</el-option>
              <!-- <el-option label="全部" :value="0">全部</el-option> -->
            </el-select>
            <el-select
              class="select-width"
              size="small"
              clearable
              v-model="queryParams.type"
              placeholder="请选择类"
            >
              <el-option label="流调" :value="1">流调</el-option>
              <el-option label="体检" :value="2">体检</el-option>
              <el-option label="全部" :value="0">全部</el-option>
            </el-select>
            <!-- <el-select class="select-width" size="mini" clearable v-model="queryParams.altitude" placeholder="请选择海拔高度" multiple>
                            <el-option v-for="item in 24" :key="item" :value="item - 1">{{ item - 1 }}</el-option>
                        </el-select>
                        <el-select class="select-width" size="mini" clearable v-model="queryParams.duration" placeholder="请选择高原时长" multiple>
                            <el-option v-for="item in 24" :key="item" :value="item - 1">{{ item - 1 }}</el-option>
                        </el-select>
                        <el-select class="select-width" size="mini" clearable v-model="queryParams.person" placeholder="筛选人员" multiple>
                            <el-option v-for="item in 24" :key="item" :value="item - 1">{{ item - 1 }}</el-option>
                        </el-select>
                        <el-select class="select-width" size="mini" clearable v-model="queryParams.time" placeholder="请选择时相点" multiple>
                            <el-option v-for="item in 24" :key="item" :value="item - 1">{{ item - 1 }}</el-option>
                        </el-select>
                        <el-select
class="select-width"
size="mini" clearable v-model="queryParams.backTime" placeholder="请选择回到平原时间"
                            multiple>
                            <el-option v-for="item in 24" :key="item" :value="item - 1">{{ item - 1 }}</el-option>
                        </el-select>
                        <el-select class="select-width" size="mini" clearable v-model="queryParams.other" placeholder="其他" multiple>
                            <el-option v-for="item in 24" :key="item" :value="item - 1">{{ item - 1 }}</el-option>
                        </el-select> -->
          </div>
        </el-form-item>

        <el-form-item label="基础信息：">
          <select-all-checkbox
            v-model="queryParams.baseInfo"
            :items="[
              '性别',
              '年龄',
              '入伍年份',
              '进入高原年份',
              '退役年份',
              '服役时间',
              '服役期间职务',
              '学历',
              '生育情况',
              '民族',
              '身高（cm）',
              '体重（公斤）',
              '退役体重（公斤）'
            ]"
          />
        </el-form-item>
        <el-form-item
          label="实验组："
          v-if="
            (queryParams.group == 1 || queryParams.group == 0) &&
            (queryParams.type == 1 || queryParams.type == 0)
          "
        >
          <select-all-checkbox
            v-model="queryParams.experimentGroupSurvey"
            :items="[
              '吸烟情况',
              '饮酒情况',
              '自我评价',
              '亲属既往疾病',
              '服役信息',
              '高原服役期间高原反应信息',
              '退役后返回平原1月内症状',
              '高原返回平原后基本信息',
              '新发疾病诊断情况',
              '返回平原后体育锻炼情况',
              '返回平原后饮食习惯',
              '近一周睡眠情况',
              '疾病谱',
              'framingham评分'
            ]"
          />
        </el-form-item>
        <el-form-item
          label="实验组："
          v-if="
            (queryParams.group == 1 || queryParams.group == 0) &&
            (queryParams.type == 2 || queryParams.type == 0)
          "
        >
          <select-all-checkbox
            v-model="queryParams.experimentGroupExam"
            :items="[
              // '基本信息',
              '基本检测信息',
              '既往病史',
              '血常规',
              '生化',
              '心电图',
              '腹部超声'
            ]"
          />
        </el-form-item>

        <!-- <el-form-item
          label="流调："
          v-if="
            (queryParams.group == 1 || queryParams.group == 0) &&
            (queryParams.type == 1 || queryParams.type == 0)
          "
        >
          <select-all-checkbox
            v-model="queryParams.experimentGroupSurvey"
            :items="['基本检测信息', '既往病史', '血常规', '生化', '心电图', '腹部超声']"
          />
        </el-form-item>
        <el-form-item
          label="体检："
          v-if="
            (queryParams.group == 1 || queryParams.group == 0) &&
            (queryParams.type == 2 || queryParams.type == 0)
          "
        >
          <select-all-checkbox
            v-model="queryParams.experimentGroupExam"
            :items="['基本检测信息', '既往病史', '血常规', '生化', '心电图', '腹部超声']"
          />
        </el-form-item> -->

        <el-form-item
          label="对照组："
          v-if="
            (queryParams.group == 2 || queryParams.group == 0) &&
            (queryParams.type == 1 || queryParams.type == 0)
          "
        >
          <select-all-checkbox
            v-model="queryParams.compareGroupSurvey"
            :items="[
              '既往疾病',
              '吸烟情况',
              '饮酒情况',
              '旅居信息',
              '自我评价',
              '疾病谱',
              'framingham评分'
            ]"
          />
        </el-form-item>
        <el-form-item
          label="对照组："
          v-if="
            (queryParams.group == 2 || queryParams.group == 0) &&
            (queryParams.type == 2 || queryParams.type == 0)
          "
        >
          <select-all-checkbox
            v-model="queryParams.compareGroupExam"
            :items="[
              // '基本信息',
              '基本检测信息',
              '既往病史',
              '血常规',
              '生化',
              '心电图',
              '腹部超声'
            ]"
          />
        </el-form-item>

        <!-- <el-form-item
          label="流调："
          v-if="
            (queryParams.group == 2 || queryParams.group == 0) &&
            (queryParams.type == 1 || queryParams.type == 0)
          "
        >
          <select-all-checkbox
            v-model="queryParams.compareGroupSurvey"
            :items="['基本检测信息', '既往病史', '血常规', '生化', '心电图', '腹部超声']"
          />
        </el-form-item>
        <el-form-item
          label="体检："
          v-if="
            (queryParams.group == 2 || queryParams.group == 0) &&
            (queryParams.type == 2 || queryParams.type == 0)
          "
        >
          <select-all-checkbox
            v-model="queryParams.compareGroupExam"
            :items="['基本检测信息', '既往病史', '血常规', '生化', '心电图', '腹部超声']"
          />
        </el-form-item> -->
        <!-- <div class="form-tip">
                    *说明：第一时相点为上高原前，第二时相点为正处于高原，第三时相点为回到平原后。
                </div> -->
      </el-form>
    </el-card>

    <el-card class="result-card">
      <template #header>
        <span>筛选结果</span>
        <div class="card-title">
          <!-- <div style="margin-top: 20px">
            <el-form :inline="true" :model="queryParams" class="demo-form-inline">
              <el-form-item label="姓名" prop="username">
                <el-input
                  v-model="queryParams.name"
                  placeholder="请输入姓名"
                  clearable
                  @keyup.enter="handleQuery"
                  class="!w-240px"
                  @submit.prevent
                />
              </el-form-item>
              <el-form-item label="服役年限">
                <el-select
                  v-model="queryParams.serviceDurationRange"
                  placeholder="请选择服役年限"
                  clearable
                  class="!w-240px"
                >
                  <el-option label="小于10年" value="1" />
                  <el-option label="10-15年" value="2" />
                  <el-option label="大于15年" value="3" />
                </el-select>
              </el-form-item>
              <el-form-item label="海拔高度">
                <el-input
                  v-model="queryParams.altitudeMin"
                  placeholder="大于"
                  type="number"
                  clearable
                  class="!w-120px"
                />
                <span style="margin: 0 4px">~</span>
                <el-input
                  v-model="queryParams.altitudeMax"
                  placeholder="小于"
                  type="number"
                  clearable
                  class="!w-120px"
                />
              </el-form-item>
              <el-form-item>
                <el-button @click="handleQuery"> <Icon icon="ep:search" />搜索 </el-button>
                <el-button @click="resetQuery"><Icon icon="ep:refresh" />重置</el-button>
              </el-form-item>
            </el-form>
          </div> -->
          <!-- <div>
            
            <el-button icon="el-icon-refresh" size="small" @click="resetQuery">重置条件</el-button>
          </div> -->
          <!-- 高级筛选字段弹窗 -->
          <div style="margin-top: 20px; text-align: right; margin-right: 20px">
            <el-button @click="fieldSelectorVisible = true">高级筛选字段</el-button>
            <el-button type="success" plain @click="handleExport" :loading="exportLoading">
          <Icon icon="ep:download" class="mr-5px" /> 导出</el-button>
          </div>
          <!-- <div v-if="conditions.length > 0">
            筛选条件：
            <span v-for="(condition, index) in conditions" :key="index">
              {{ condition.label }} {{ condition.operator }} {{ condition.displayText }}
              <span v-if="index < conditions.length - 1">，</span>
            </span>
          </div> -->
          <div>
            <span style="margin-left: 15px">共{{ total }}人</span>
            ，占比 {{ (average.dataRatio * 100).toFixed(2) }}%
            <span v-if="hasGenderCondition">
              ，男性有{{ average.maleCount }}人，女性有{{ average.femaleCount }}人
            </span>
            <span v-if="hasAgeCondition">
              ，平均年龄为{{ average.averageAge.toFixed(2) }}岁（最小{{
                average.minAge.toFixed(2)
              }}岁，最大{{ average.maxAge.toFixed(2) }}岁）
            </span>
            <span v-if="hasAltitudeCondition">
              ，高原服役平均海拔{{ average.averageHighlandAltitude.toFixed(2) }}米（最高{{
                average.maxHighlandAltitude.toFixed(2)
              }}米，最矮{{ average.minHighlandAltitude.toFixed(2) }}米)
            </span>
            <span v-if="hasServiceTimeCondition">
              ，高原服役平均时长{{
                formatToYearMonth(average.averageHighlandServiceDuration)
              }}（最长{{ formatToYearMonth(average.maxHighlandServiceDuration) }}，最短{{
                formatToYearMonth(average.minHighlandServiceDuration)
              }})
            </span>
            <span v-if="hasResidenceTimeCondition">
              ，退役在成都生活平均时长{{
                formatToYearMonth(average.averageChengduLivingDuration)
              }}（最长{{ formatToYearMonth(average.maxChengduLivingDuration) }}，最短{{
                formatToYearMonth(average.minChengduLivingDuration)
              }})
            </span>
            <span v-if="hasDischargeYearCondition">
              <template v-if="hasResidenceAreaCondition">
                ，退役在{{ residenceAreaOperatorText }}的平均时长
              </template>
              <template v-else> ，退役平均时长 </template>
              {{ average.averageYearsSinceDischarge.toFixed(2) }}年（最长{{
                average.maxYearsSinceDischarge.toFixed(2)
              }}年，最短{{ average.minYearsSinceDischarge.toFixed(2) }}年)
            </span>
            <span v-if="hasReeAverageTotalCholesterol">
              ，总胆固醇平均值为{{ average.reeAverageTotalCholesterol.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageTriglycerides">
              ，甘油三酯平均值为{{ average.reeAverageTriglycerides.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageHdlC">
              ，高密度脂蛋白胆固醇平均值为{{ average.reeAverageHdlC.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageLdlC">
              ，低密度脂蛋白胆固醇平均值为{{ average.reeAverageLdlC.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageTotalCholesterol">
              ，总胆固醇平均值为{{ average.rceAverageTotalCholesterol.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageTriglycerides">
              ，甘油三酯平均值为{{ average.rceAverageTriglycerides.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageHdlC">
              ，高密度脂蛋白胆固醇平均值为{{ average.rceAverageHdlC.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageLdlC">
              ，低密度脂蛋白胆固醇平均值为{{ average.rceAverageLdlC.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageWbc">
              ，白细胞计数平均值为{{ average.reeAverageWbc.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageRbc">
              ，红细胞计数平均值为{{ average.reeAverageRbc.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageNeutrophils">
              ，血红蛋白浓度平均值为{{ average.reeAverageNeutrophils.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageLymphocytes">
              ，红细胞比容平均值为{{ average.reeAverageLymphocytes.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageMonocytes">
              ，平均红细胞容积平均值为{{ average.reeAverageMonocytes.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageEosinophils">
              ，平均红细胞血红蛋白含量平均值为{{ average.reeAverageEosinophils.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageBasophils">
              ，平均红细胞血红蛋白浓度平均值为{{ average.reeAverageBasophils.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageMcv">
              ，RBC分布宽度CV值平均值为{{ average.reeAverageMcv.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageMch">
              ，RBC分布宽度SD值平均值为{{ average.reeAverageMch.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageMchc">
              ，血小板计数平均值为{{ average.reeAverageMchc.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageRdwCv">
              ，血小板比容平均值为{{ average.reeAverageRdwCv.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageRdwSd">
              ，平均血小板体积平均值为{{ average.reeAverageRdwSd.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageHemoglobin">
              ，血小板分布宽度平均值为{{ average.reeAverageHemoglobin.toFixed(2) }}
            </span>
            <span v-if="hasReeAveragePlateletCrit">
              ，中性粒细胞计数平均值为{{ average.reeAveragePlateletCrit.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageMpv">
              ，淋巴细胞计数平均值为{{ average.reeAverageMpv.toFixed(2) }}
            </span>
            <span v-if="hasReeAveragePdw">
              ，单核细胞计数平均值为{{ average.reeAveragePdw.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageHematocrit">
              ，嗜酸性粒细胞计数平均值为{{ average.reeAverageHematocrit.toFixed(2) }}
            </span>
            <span v-if="hasReeAveragePlateletCount">
              ，嗜碱性粒细胞计数平均值为{{ average.reeAveragePlateletCount.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageNeutrophilsPercentage">
              ，中性粒细胞百分率平均值为{{ average.reeAverageNeutrophilsPercentage.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageLymphocytesPercentage">
              ，淋巴细胞百分率平均值为{{ average.reeAverageLymphocytesPercentage.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageMonocytesPercentage">
              ，单核细胞百分率平均值为{{ average.reeAverageMonocytesPercentage.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageEosinophilsPercentage">
              ，嗜酸性粒细胞百分率平均值为{{ average.reeAverageEosinophilsPercentage.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageBasophilsPercentage">
              ，嗜碱性粒细胞百分率平均值为{{ average.reeAverageBasophilsPercentage.toFixed(2) }}
            </span>

            <span v-if="hasRceAverageWbc">
              ，白细胞计数平均值为{{ average.rceAverageWbc.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageRbc">
              ，红细胞计数平均值为{{ average.rceAverageRbc.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageNeutrophils">
              ，血红蛋白浓度平均值为{{ average.rceAverageNeutrophils.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageLymphocytes">
              ，红细胞比容平均值为{{ average.rceAverageLymphocytes.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageMonocytes">
              ，平均红细胞容积平均值为{{ average.rceAverageMonocytes.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageEosinophils">
              ，平均红细胞血红蛋白含量平均值为{{ average.rceAverageEosinophils.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageBasophils">
              ，平均红细胞血红蛋白浓度平均值为{{ average.rceAverageBasophils.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageMcv">
              ，RBC分布宽度CV值平均值为{{ average.rceAverageMcv.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageMch">
              ，RBC分布宽度SD值平均值为{{ average.rceAverageMch.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageMchc">
              ，血小板计数平均值为{{ average.rceAverageMchc.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageRdwCv">
              ，血小板比容平均值为{{ average.rceAverageRdwCv.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageRdwSd">
              ，平均血小板体积平均值为{{ average.rceAverageRdwSd.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageHemoglobin">
              ，血小板分布宽度平均值为{{ average.rceAverageHemoglobin.toFixed(2) }}
            </span>
            <span v-if="hasRceAveragePlateletCrit">
              ，中性粒细胞计数平均值为{{ average.rceAveragePlateletCrit.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageMpv">
              ，淋巴细胞计数平均值为{{ average.rceAverageMpv.toFixed(2) }}
            </span>
            <span v-if="hasRceAveragePdw">
              ，单核细胞计数平均值为{{ average.rceAveragePdw.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageHematocrit">
              ，嗜酸性粒细胞计数平均值为{{ average.rceAverageHematocrit.toFixed(2) }}
            </span>
            <span v-if="hasRceAveragePlateletCount">
              ，嗜碱性粒细胞计数平均值为{{ average.rceAveragePlateletCount.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageNeutrophilsPercentage">
              ，中性粒细胞百分率平均值为{{ average.rceAverageNeutrophilsPercentage.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageLymphocytesPercentage">
              ，淋巴细胞百分率平均值为{{ average.rceAverageLymphocytesPercentage.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageMonocytesPercentage">
              ，单核细胞百分率平均值为{{ average.rceAverageMonocytesPercentage.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageEosinophilsPercentage">
              ，嗜酸性粒细胞百分率平均值为{{ average.rceAverageEosinophilsPercentage.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageBasophilsPercentage">
              ，嗜碱性粒细胞百分率平均值为{{ average.rceAverageBasophilsPercentage.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageTotalProtein">
              ，总蛋白平均值为{{ average.reeAverageTotalProtein.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageAlbumin">
              ，白蛋白平均值为{{ average.reeAverageAlbumin.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageGlobulin">
              ，球蛋白平均值为{{ average.reeAverageGlobulin.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageAlbGlobRatio">
              ，白球比例平均值为{{ average.reeAverageAlbGlobRatio.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageTotalBilirubin">
              ，总胆红素平均值为{{ average.reeAverageTotalBilirubin.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageDirectBilirubin">
              ，直接胆红素平均值为{{ average.reeAverageDirectBilirubin.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageIndirectBilirubin">
              ，间接胆红素平均值为{{ average.reeAverageIndirectBilirubin.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageAlt">
              ，谷丙转氨酶平均值为{{ average.reeAverageAlt.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageAst">
              ，谷草转氨酶平均值为{{ average.reeAverageAst.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageUricAcid">
              ，尿酸平均值为{{ average.reeAverageUricAcid.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageUrea">
              ，尿素平均值为{{ average.reeAverageUrea.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageCreatinine">
              ，肌酐平均值为{{ average.reeAverageCreatinine.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageProthrombinTime">
              ，凝血酶原时间平均值为{{ average.reeAverageProthrombinTime.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageProthrombinActivity">
              ，凝血酶原活动度平均值为{{ average.reeAverageProthrombinActivity.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageInr">
              ，国际标准化比率平均值为{{ average.reeAverageInr.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageFibrinogen">
              ，纤维蛋白原平均值为{{ average.reeAverageFibrinogen.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageAptt">
              ，活化部分凝血活酶时间平均值为{{ average.reeAverageAptt.toFixed(2) }}
            </span>
            <span v-if="hasReeAverageThrombinTime">
              ，凝血酶时间平均值为{{ average.reeAverageThrombinTime.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageTotalProtein">
              ，总蛋白平均值为{{ average.rceAverageTotalProtein.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageAlbumin">
              ，白蛋白平均值为{{ average.rceAverageAlbumin.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageGlobulin">
              ，球蛋白平均值为{{ average.rceAverageGlobulin.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageAlbGlobRatio">
              ，白球比例平均值为{{ average.rceAverageAlbGlobRatio.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageTotalBilirubin">
              ，总胆红素平均值为{{ average.rceAverageTotalBilirubin.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageDirectBilirubin">
              ，直接胆红素平均值为{{ average.rceAverageDirectBilirubin.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageIndirectBilirubin">
              ，间接胆红素平均值为{{ average.rceAverageIndirectBilirubin.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageAlt">
              ，谷丙转氨酶平均值为{{ average.rceAverageAlt.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageAst">
              ，谷草转氨酶平均值为{{ average.rceAverageAst.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageUricAcid">
              ，尿酸平均值为{{ average.rceAverageUricAcid.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageUrea">
              ，尿素平均值为{{ average.rceAverageUrea.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageCreatinine">
              ，肌酐平均值为{{ average.rceAverageCreatinine.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageProthrombinTime">
              ，凝血酶原时间平均值为{{ average.rceAverageProthrombinTime.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageProthrombinActivity">
              ，凝血酶原活动度平均值为{{ average.rceAverageProthrombinActivity.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageInr">
              ，国际标准化比率平均值为{{ average.rceAverageInr.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageFibrinogen">
              ，纤维蛋白原平均值为{{ average.rceAverageFibrinogen.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageAptt">
              ，活化部分凝血活酶时间平均值为{{ average.rceAverageAptt.toFixed(2) }}
            </span>
            <span v-if="hasRceAverageThrombinTime">
              ，凝血酶时间平均值为{{ average.rceAverageThrombinTime.toFixed(2) }}
            </span>
          </div>
          <AdvancedSearch
            v-model="fieldSelectorVisible"
            :groupedFields="fieldGroups"
            @confirm="handleFieldSelect"
          />
          <!-- <chart-table-switch v-model="pageType" /> -->
        </div>
      </template>

      <div v-if="false" class="result-empty">
        <svg
          xmlns="http://www.w3.org/2000/svg"
          xmlns:xlink="http://www.w3.org/1999/xlink"
          fill="none"
          version="1.1"
          width="48"
          height="48"
          viewBox="0 0 48 48"
        >
          <defs>
            <clipPath id="master_svg0_0_581">
              <rect x="0" y="0" width="48" height="48" rx="0" />
            </clipPath>
          </defs>
          <g clip-path="url(#master_svg0_0_581)">
            <g>
              <path
                d="M24.0,43.0C24.0,43.0,24.0,44.5,24.0,44.5C24.8,44.5,25.5,43.8,25.5,43.0C25.5,43.0,24.0,43.0,24.0,43.0C24.0,43.0,24.0,43.0,24.0,43.0ZM43.0,24.0C43.0,24.0,43.0,25.5,43.0,25.5C43.8,25.5,44.5,24.8,44.5,24.0C44.5,24.0,43.0,24.0,43.0,24.0C43.0,24.0,43.0,24.0,43.0,24.0ZM3.5,24.0C3.5,35.3,12.7,44.5,24.0,44.5C24.0,44.5,24.0,41.5,24.0,41.5C14.3,41.5,6.5,33.7,6.5,24.0C6.5,24.0,3.5,24.0,3.5,24.0C3.5,24.0,3.5,24.0,3.5,24.0ZM25.5,43.0C25.5,43.0,25.5,26.0,25.5,26.0C25.5,26.0,22.5,26.0,22.5,26.0C22.5,26.0,22.5,43.0,22.5,43.0C22.5,43.0,25.5,43.0,25.5,43.0C25.5,43.0,25.5,43.0,25.5,43.0ZM25.5,26.0C25.5,25.7,25.7,25.5,26.0,25.5C26.0,25.5,26.0,22.5,26.0,22.5C24.1,22.5,22.5,24.1,22.5,26.0C22.5,26.0,25.5,26.0,25.5,26.0C25.5,26.0,25.5,26.0,25.5,26.0ZM25.5,26.0C25.5,26.0,43.0,26.0,43.0,26.0C43.0,26.0,43.0,22.5,43.0,22.5C43.0,22.5,25.5,22.5,25.5,22.5C25.5,22.5,25.5,26.0,25.5,26.0C25.5,26.0,25.5,26.0,25.5,26.0ZM44.5,24.0C44.5,12.7,35.3,3.5,24.0,3.5C24.0,3.5,24.0,6.5,24.0,6.5C33.7,6.5,41.5,14.3,41.5,24.0C41.5,24.0,44.5,24.0,44.5,24.0C44.5,24.0,44.5,24.0,44.5,24.0ZM24.0,3.5C12.7,3.5,3.5,12.7,3.5,24.0C3.5,24.0,6.5,24.0,6.5,24.0C6.5,14.3,14.3,6.5,24.0,6.5C24.0,6.5,24.0,3.5,24.0,3.5C24.0,3.5,24.0,3.5,24.0,3.5Z"
                fill="#000000"
                fill-opacity="0.3"
              />
            </g>
            <g>
              <path
                d="M30.0,30.0C30.0,30.0,30.0,28.5,30.0,28.5C29.2,28.5,28.5,29.2,28.5,30.0C28.5,30.0,30.0,30.0,30.0,30.0C30.0,30.0,30.0,30.0,30.0,30.0ZM42.0,30.0C42.0,30.0,43.5,30.0,43.5,30.0C43.5,29.2,42.8,28.5,42.0,28.5C42.0,28.5,42.0,30.0,42.0,30.0C42.0,30.0,42.0,30.0,42.0,30.0ZM42.0,42.0C42.0,42.0,42.0,43.5,42.0,43.5C42.8,43.5,43.5,42.8,43.5,42.0C43.5,42.0,42.0,42.0,42.0,42.0C42.0,42.0,42.0,42.0,42.0,42.0ZM30.0,42.0C30.0,42.0,28.5,42.0,28.5,42.0C28.5,42.8,29.2,43.5,30.0,43.5C30.0,43.5,30.0,42.0,30.0,42.0C30.0,42.0,30.0,42.0,30.0,42.0ZM30.0,31.5C30.0,31.5,42.0,31.5,42.0,31.5C42.0,31.5,42.0,28.5,42.0,28.5C42.0,28.5,30.0,28.5,30.0,28.5C30.0,28.5,30.0,31.5,30.0,31.5C30.0,31.5,30.0,31.5,30.0,31.5ZM40.5,30.0C40.5,30.0,40.5,42.0,40.5,42.0C40.5,42.0,43.5,42.0,43.5,42.0C43.5,42.0,43.5,30.0,43.5,30.0C43.5,30.0,40.5,30.0,40.5,30.0C40.5,30.0,40.5,30.0,40.5,30.0ZM42.0,40.5C42.0,40.5,30.0,40.5,30.0,40.5C30.0,40.5,30.0,43.5,30.0,43.5C30.0,43.5,42.0,43.5,42.0,43.5C42.0,43.5,42.0,40.5,42.0,40.5C42.0,40.5,42.0,40.5,42.0,40.5ZM31.5,42.0C31.5,42.0,31.5,30.0,31.5,30.0C31.5,30.0,28.5,30.0,28.5,30.0C28.5,30.0,28.5,42.0,28.5,42.0C28.5,42.0,31.5,42.0,31.5,42.0C31.5,42.0,31.5,42.0,31.5,42.0Z"
                fill="#000000"
                fill-opacity="0.3"
              />
            </g>
          </g>
        </svg>
        <div>请选择筛选条件</div>.
      </div>
      <el-table
        :data="list"
        style="width: 100%"
        @header-click="handleHeaderClick"
        :header-cell-class-name="getHeaderCellClass"
      >
        <el-table-column type="index" label="序号" width="60" class-name="level-1-header" />
        <el-table-column
          label="姓名"
          :align="'center'"
          key="name"
          prop="name"
          class-name="level-1-header"
        />

        <!-- 多级表头 -->
        <template v-for="(fields, groupName) in displayedFields" :key="groupName">
          <template v-if="Array.isArray(fields)">
            <el-table-column :label="groupName" :align="'center'" class-name="level-1-header">
              <el-table-column
                v-for="field in fields"
                :key="field.prop"
                :label="field.label"
                :prop="field.prop"
                :formatter="formatField"
                :min-width="getAutoMinWidth(field.label, field.prop, list)"
                :align="'center'"
                class-name="level-2-header"
              />
            </el-table-column>
          </template>

          <template v-else>
            <template
              v-if="Object.keys(fields).length === 1 && Object.keys(fields)[0] === groupName"
            >
              <el-table-column :label="groupName" :align="'center'" class-name="level-1-header">
                <el-table-column
                  v-for="field in fields[groupName]"
                  :key="field.prop"
                  :label="field.label"
                  :prop="field.prop"
                  :formatter="formatField"
                  :min-width="getAutoMinWidth(field.label, field.prop, list)"
                  :align="'center'"
                  class-name="level-2-header"
                />
              </el-table-column>
            </template>

            <template v-else>
              <el-table-column :label="groupName" :align="'center'" class-name="level-1-header">
                <template v-for="(subFields, subGroupName) in fields" :key="subGroupName">
                  <!-- ⚠️ 二级组名 和 第一个字段的 label 相同，可跳过二级表头 -->
                  <template
                    v-if="
                      subGroupName === groupName ||
                      (subFields.length === 1 && subGroupName === subFields[0].label)
                    "
                  >
                    <el-table-column
                      v-for="field in subFields"
                      :key="field.prop"
                      :label="field.label"
                      :prop="field.prop"
                      :formatter="formatField"
                      :min-width="getAutoMinWidth(field.label, field.prop, list)"
                      :align="'center'"
                      class-name="level-2-header"
                    />
                  </template>

                  <!-- 正常二级表头 -->
                  <template v-else>
                    <el-table-column
                      :label="subGroupName"
                      :align="'center'"
                      class-name="level-2-header"
                    >
                      <el-table-column
                        v-for="field in subFields"
                        :key="field.prop"
                        :label="field.label"
                        :prop="field.prop"
                        :formatter="formatField"
                        :min-width="getAutoMinWidth(field.label, field.prop, list)"
                        :align="'center'"
                        class-name="level-3-header"
                      />
                    </el-table-column>
                  </template>
                </template>
              </el-table-column>
            </template>
          </template>
        </template>
      </el-table>

      <Pagination
        :total="total"
        v-model:page="queryParams.pageNo"
        v-model:limit="queryParams.pageSize"
        :page-sizes="[10, 20, 30, 50, 100, 600]"
        @pagination="getList"
      />
    </el-card>
  </div>
</template>

<script lang="ts" setup>
import './styles.css'
import selectAllCheckbox from '../components/selectAllCheckbox/index.vue'
// import { BasicInfoApi } from '@/api/review/basicinfo'
import AdvancedSearch from './AdvancedSearch.vue'
import {
  basicInfoFields,
  experimentSurveyGroupFields,
  experimentExamGroupFields,
  controlSurveyGroupFields,
  controlExamGroupFields
} from './fieldTypeMap'

import {
  mapFieldConfigs,
  formatSelectedTypes,
  formatServiceTime,
  formatTotalServiceTime,
  formatReactionCount,
  formatResidenceTime,
  formatExerciseType,
  formatKeyAndValue
} from './formatUtils'

import { ref, reactive, watch } from 'vue'

import request from '@/config/axios'
import download from '@/utils/download'
// import { group } from 'console'

interface TableField {
  label: string
  prop: string
}

const loading = ref(true) // 列表的加载中
const total = ref(0) // 列表的总页数
const list = ref([]) // 列表的数
const fieldSelectorVisible = ref(false)

type DisplayedFields = Record<string, TableField[] | Record<string, TableField[]>>

// 动态显示的字段
const displayedFields = ref<DisplayedFields>({})

const queryParams = reactive({
  pageNo: 1,
  pageSize: 10,
  group: 1,
  type: 1,
  name: undefined,
  mobile: undefined,
  status: undefined,
  deptId: undefined,
  createTime: [],
  baseInfo: [
    '性别',
    '年龄',
    '入伍年份',
    '进入高原年份',
    '退役年份',
    '服役时间',
    '服役期间职务',
    '学历',
    '生育情况',
    '民族',
    '身高（cm）',
    '体重（公斤）',
    '退役体重（公斤）'
  ] as string[],
  experimentGroupSurvey: [] as string[],
  experimentGroupExam: [] as string[],
  compareGroupSurvey: [] as string[],
  compareGroupExam: [] as string[],
  reviewBasicInfoFields: [] as string[],
  advancedConditions: []
})

//-----------------------------------------------------------------表字段处理start----------------------------------------------------
// 更新动态字段
const updateDisplayedFields = () => {
  const groupedFields: Record<string, TableField[]> = {}

  displayedFields.value = {}

  if (queryParams.baseInfo.length > 0) {
    groupedFields['基础信息'] = basicInfoFields.filter((field) =>
      queryParams.baseInfo.includes(field.label)
    )
  }
  if (
    (queryParams.group == 1 || queryParams.group == 0) &&
    (queryParams.type == 1 || queryParams.type == 0)
  ) {
    // 添加实验组字段
    queryParams.experimentGroupSurvey.forEach((group) => {
      if (experimentSurveyGroupFields[group]) {
        groupedFields[group] = experimentSurveyGroupFields[group]
      }
    })
  }
  if (
    (queryParams.group == 1 || queryParams.group == 0) &&
    (queryParams.type == 2 || queryParams.type == 0)
  ) {
    // 添加对照组字段
    queryParams.experimentGroupExam.forEach((group) => {
      if (experimentExamGroupFields[group]) {
        groupedFields[group] = experimentExamGroupFields[group]
      }
    })
  }
  if (
    (queryParams.group == 2 || queryParams.group == 0) &&
    (queryParams.type == 1 || queryParams.type == 0)
  ) {
    // 添加对照组字段
    queryParams.compareGroupSurvey.forEach((group) => {
      if (controlSurveyGroupFields[group]) {
        groupedFields[group] = controlSurveyGroupFields[group]
      }
    })
  }
  if (
    (queryParams.group == 2 || queryParams.group == 0) &&
    (queryParams.type == 2 || queryParams.type == 0)
  ) {
    // 添加对照组字段
    queryParams.compareGroupExam.forEach((group) => {
      if (controlExamGroupFields[group]) {
        groupedFields[group] = controlExamGroupFields[group]
      }
    })
  }
  displayedFields.value = groupedFields
}

// function resetQuery() {
//   // queryParams = {}
//   // queryParams.baseInfo.splice(0)
//   // queryParams.experimentGroupSurvey.splice(0)
//   // queryParams.experimentGroupExam.splice(0)
//   // queryParams.compareGroupSurvey.splice(0)
//   // queryParams.compareGroupExam.splice(0)
//   handleQuery()
// }

// function handleQuery() {
//   getList()
// }

function formatField(row, column, cellValue) {
  const prop = column.property

  if (
    prop == 'experimentFraminghamRespVO.framinghamRiskType' ||
    prop == 'controlFraminghamRespVO.framinghamRiskType'
  ) {
    if (cellValue === 'low') {
      return '低风险'
    } else if (cellValue === 'medium') {
      return '中风险'
    } else if (cellValue === 'high') {
      return '高风险'
    }
  }

  if (typeof cellValue === 'boolean') {
    return cellValue ? '是' : '否'
  }

  if (typeof cellValue === 'string') {
    return cellValue === '0' ? '-' : cellValue
  }

  // 处理服役时间差：退役年份 - 进入高原年份
  if (prop === 'serviceDuration') {
    const start = parseInt(row.experimentSurveyServiceInfoRespVO?.highlandEntryYear)
    const end = parseInt(row.experimentSurveyServiceInfoRespVO?.dischargeYear)
    return !isNaN(start) && !isNaN(end) ? `${end - start} 年` : '-'
  }

  // 处理 serviceTime1 ~ serviceTime6
  if (prop.startsWith('serviceTime')) {
    const match = prop.match(/serviceTime(\d)/)
    return match
      ? formatServiceTime(row.experimentSurveyServiceInfoRespVO, match[1])
      : formatTotalServiceTime(row.experimentSurveyServiceInfoRespVO)
  }

  // 单独处理饮酒类型（与通用逻辑重复，保留用于兼容性）
  if (prop === 'drinkingType') {
    return formatSelectedTypes(row.experimentSurveyDrinkingRespVO || {}, mapFieldConfigs[prop].map)
  }

  // 通用 map 字段处理
  if (mapFieldConfigs[prop]) {
    const { map, source, separator = '，' } = mapFieldConfigs[prop]
    const data = row[source] || {}
    return formatSelectedTypes(data, map, separator)
  }

  // 特殊字段处理：高原反应次数
  if (prop === 'reactionCount') {
    const info = row.experimentSurveyHighlandReactionRespVO || {}
    return formatReactionCount(info)
  }

  // 特殊字段处理：每年居住时间
  if (prop === 'residenceTime') {
    const info = row.experimentSurveyPostReturnInfoRespVO || {}
    return formatResidenceTime(info)
  }

  // 特殊字段处理：体育锻炼形式
  if (prop === 'exerciseType') {
    const info = row.experimentSurveyExerciseRespVO || {}
    return formatExerciseType(info)
  }

  // 特殊字段处理：实验组流调-影响睡眠烦恼原因
  if (prop === 'reasonsAffectingSleep') {
    const info = row.experimentSurveySleepRespVO || {}
    return formatKeyAndValue(info)
  }

  // 默认回退值
  return cellValue ?? '-'
}
//-----------------------------------------------------------------表字段处理end----------------------------------------------------

//表格宽度自适应
function getAutoMinWidth(label: string, prop: any, list: any[]): string {
  const maxDataLen = list.reduce((max, row) => {
    const cellValue = prop?.split('.').reduce((obj, key) => obj?.[key], row)
    const formatted = formatField(row, { property: prop }, cellValue)
    return Math.max(max, formatted?.length || 0)
  }, 0)

  const labelLen = label.length
  const maxLen = Math.max(labelLen, maxDataLen)
  return `${maxLen * 14 + 40}px`
}

const average = ref({
  dataRatio: 0,
  maleCount: 0,
  femaleCount: 0,
  averageAge: 0,
  minAge: 0,
  maxAge: 0,
  averageHighlandAltitude: 0,
  maxHighlandAltitude: 0,
  minHighlandAltitude: 0,
  averageHighlandServiceDuration: 0,
  maxHighlandServiceDuration: 0,
  minHighlandServiceDuration: 0,
  averageChengduLivingDuration: 0,
  maxChengduLivingDuration: 0,
  minChengduLivingDuration: 0,
  averageYearsSinceDischarge: 0,
  maxYearsSinceDischarge: 0,
  minYearsSinceDischarge: 0,
  reeAverageTotalCholesterol: 0,
  reeAverageTriglycerides: 0,
  reeAverageHdlC: 0,
  reeAverageLdlC: 0,
  rceAverageTotalCholesterol: 0,
  rceAverageTriglycerides: 0,
  rceAverageHdlC: 0,
  rceAverageLdlC: 0,
  reeAverageWbc: 0,
  reeAverageRbc: 0,
  reeAverageNeutrophils: 0,
  reeAverageLymphocytes: 0,
  reeAverageMonocytes: 0,
  reeAverageEosinophils: 0,
  reeAverageBasophils: 0,
  reeAverageMcv: 0,
  reeAverageMch: 0,
  reeAverageMchc: 0,
  reeAverageRdwCv: 0,
  reeAverageRdwSd: 0,
  reeAverageHemoglobin: 0,
  reeAveragePlateletCrit: 0,
  reeAverageMpv: 0,
  reeAveragePdw: 0,
  reeAverageHematocrit: 0,
  reeAveragePlateletCount: 0,
  reeAverageNeutrophilsPercentage: 0,
  reeAverageLymphocytesPercentage: 0,
  reeAverageMonocytesPercentage: 0,
  reeAverageEosinophilsPercentage: 0,
  reeAverageBasophilsPercentage: 0,
  rceAverageWbc: 0,
  rceAverageRbc: 0,
  rceAverageNeutrophils: 0,
  rceAverageLymphocytes: 0,
  rceAverageMonocytes: 0,
  rceAverageEosinophils: 0,
  rceAverageBasophils: 0,
  rceAverageMcv: 0,
  rceAverageMch: 0,
  rceAverageMchc: 0,
  rceAverageRdwCv: 0,
  rceAverageRdwSd: 0,
  rceAverageHemoglobin: 0,
  rceAveragePlateletCrit: 0,
  rceAverageMpv: 0,
  rceAveragePdw: 0,
  rceAverageHematocrit: 0,
  rceAveragePlateletCount: 0,
  rceAverageNeutrophilsPercentage: 0,
  rceAverageLymphocytesPercentage: 0,
  rceAverageMonocytesPercentage: 0,
  rceAverageEosinophilsPercentage: 0,
  rceAverageBasophilsPercentage: 0,
  reeAverageTotalProtein: 0,
  reeAverageAlbumin: 0,
  reeAverageGlobulin: 0,
  reeAverageAlbGlobRatio: 0,
  reeAverageTotalBilirubin: 0,
  reeAverageDirectBilirubin: 0,
  reeAverageIndirectBilirubin: 0,
  reeAverageAlt: 0,
  reeAverageAst: 0,
  reeAverageUricAcid: 0,
  reeAverageUrea: 0,
  reeAverageCreatinine: 0,
  reeAverageProthrombinTime: 0,
  reeAverageProthrombinActivity: 0,
  reeAverageInr: 0,
  reeAverageFibrinogen: 0,
  reeAverageAptt: 0,
  reeAverageThrombinTime: 0,
  rceAverageTotalProtein: 0,
  rceAverageAlbumin: 0,
  rceAverageGlobulin: 0,
  rceAverageAlbGlobRatio: 0,
  rceAverageTotalBilirubin: 0,
  rceAverageDirectBilirubin: 0,
  rceAverageIndirectBilirubin: 0,
  rceAverageAlt: 0,
  rceAverageAst: 0,
  rceAverageUricAcid: 0,
  rceAverageUrea: 0,
  rceAverageCreatinine: 0,
  rceAverageProthrombinTime: 0,
  rceAverageProthrombinActivity: 0,
  rceAverageInr: 0,
  rceAverageFibrinogen: 0,
  rceAverageAptt: 0,
  rceAverageThrombinTime: 0
}) // 平均值

/** 查询列表 */
const getList = async () => {
  loading.value = true
  try {
    queryParams.reviewBasicInfoFields = basicInfoFields
      .filter((field) => queryParams.baseInfo.includes(field.label))
      .map((field) => field.prop)
    //获取平均值
    average.value = await BasicInfoApi.getAverageByParam(queryParams)

    //获取分页数据
    const data = await BasicInfoApi.getDataByParamPage(queryParams)
    list.value = data.list
    total.value = data.total
  } finally {
    loading.value = false
  }
}

//-------------------------------------------------------------高级查询条件处理start--------------------------------------------------
const conditions = ref([])
const hasResidenceAreaCondition = ref(false)
const residenceAreaOperatorText = ref('')

const handleFieldSelect = (newConditions) => {
  conditions.value = newConditions
  const residenceAreaCondition = newConditions.find((c) => c.field === 'residenceArea')
  if (residenceAreaCondition) {
    hasResidenceAreaCondition.value = true
    residenceAreaOperatorText.value = residenceAreaCondition.displayText || ''
  } else {
    hasResidenceAreaCondition.value = false
    residenceAreaOperatorText.value = ''
  }
  const sqlConditions = normalizeConditions(newConditions)
  queryParams.advancedConditions = sqlConditions as never[]
  getList()
}

// 字段别名映射
const fieldAliasMap = {
  basicInfoRespVO: 'rbi',
  basicOtherInfoRespVO: 'rboi',
  experimentSurveyDietRespVO: 'diet',
  experimentSurveyDrinkingRespVO: 'drinking',
  experimentSurveyExerciseRespVO: 'exercise',
  experimentSurveyFamilyDiseasesRespVO: 'family_diseases',
  experimentSurveyHighlandDiseasesRespVO: 'highland_diseases',
  experimentSurveyHighlandDiseasesDuringServiceRespVO: 'highland_diseases_during_service',
  experimentSurveyHighlandReactionRespVO: 'highland_reaction',
  experimentSurveyHighlandReactionSymptomsRespVO: 'highland_reaction_symptoms',
  experimentSurveyNewDiseasesRespVO: 'new_diseases',
  experimentSurveyNewDiseasesPostReturnRespVO: 'new_diseases_post_return',
  experimentSurveyPostReturnInfoRespVO: 'post_return_info',
  experimentSurveyPostReturnSymptomsRespVO: 'post_return_symptoms',
  experimentSurveySelfAssessmentRespVO: 'self_assessment',
  experimentSurveyServiceInfoRespVO: 'service_info',
  experimentSurveySleepRespVO: 'sleep',
  experimentSurveySmokingRespVO: 'smoking',
  experimentExamAbdominalUltrasoundRespVO: 'ree_abdominal_ultrasound',
  experimentExamBasicTestsRespVO: 'ree_basic_tests',
  experimentExamBiochemicalTestsRespVO: 'ree_biochemical_tests',
  experimentExamBloodRoutineRespVO: 'ree_blood_routine',
  experimentExamEcgRespVO: 'ree_ecg',
  experimentExamPastMedicalHistoryRespVO: 'ree_past_medical_history',
  controlExamAbdominalUltrasoundRespVO: 'rce_abdominal_ultrasound',
  controlExamBasicTestsRespVO: 'rce_basic_tests',
  controlExamBiochemicalTestsRespVO: 'rce_biochemical_tests',
  controlExamBloodRoutineRespVO: 'rce_blood_routine',
  controlExamEcgRespVO: 'rce_ecg',
  controlExamPastMedicalHistoryRespVO: 'rce_past_medical_history',
  controlSurveyDrinkingInfoRespVO: 'rcs_drinking_info',
  controlSurveyPastDiseasesRespVO: 'rcs_past_diseases',
  controlSurveyResidenceInfoRespVO: 'rcs_residence_info',
  controlSurveySelfAssessmentRespVO: 'rcs_self_assessment',
  controlSurveySmokingInfoRespVO: 'rcs_smoking_info',
  experimentDiseaseSpectrumRespVO: 'experiment_disease_spectrum',
  experimentFraminghamRespVO: 'experiment_framingham',
  controlDiseaseSpectrumRespVO: 'control_disease_spectrum',
  controlFraminghamRespVO: 'control_framingham'
}

// 驼峰转下划线
function camelToSnake(str) {
  return str.replace(/[A-Z]/g, (letter) => `_${letter.toLowerCase()}`)
}

interface Condition {
  logic: string
  field: string
  operator: string
  value: string | number
}

/**
 * 解析条件数组，将高级查询条件转换成可用于SQL的条件数组
 * @param {Array} conditions - 形如 [{field, value, logic, operator}, ...] 的查询条件
 * @returns {Array} - 解析后的SQL条件数组，每条形如 {logic, field, operator, value}
 */
function normalizeConditions(conditions) {
  const normalized: Condition[] = []

  conditions.forEach((item, index) => {
    const logic = index === 0 ? '' : item.logic || 'AND'
    // 其他字段，直接转换
    let fieldFull = item.field
    // 处理带别名情况，例如 basicOtherInfoRespVO.age -> rboi.age
    const parts = item.field.split('.')
    if (parts.length == 1 && (parts[0] == 'height' || parts[0] == 'weight')) {
      fieldFull = `rbi.${camelToSnake(parts[0])}`
    }
    if (parts.length == 1 && parts[0] == 'residenceTime') {
      fieldFull = `post_return_info.chengdu_residence_time`
    }
    if (parts.length > 1) {
      fieldFull = `${parts[0]}.${camelToSnake(parts[1])}`
    }
    if (parts.length > 1 && fieldAliasMap[parts[0]]) {
      fieldFull = `${fieldAliasMap[parts[0]]}.${camelToSnake(parts[1])}`
    }
    if (item.field.startsWith('experimentSurveyServiceInfoRespVO.altitude')) {
      const logic = index === 0 ? '' : item.logic || 'AND'

      // 提取字段编号，例如 altitude1、altitude2 => 1、2
      const match = item.field.match(/altitude(\d+)/)
      const numSuffix = match ? match[1] : '' // 没有后缀就用空串，对应 altitude

      const between = item.value.split(',')
      const min = between[0]?.trim()
      const max = between[1]?.trim()

      if (min != 'undefined' && max != 'undefined') {
        console.log(normalized, 'normalized1')
        normalized.push({
          logic,
          field: `service_info.altitude${numSuffix}`,
          operator: '>=',
          value: min
        })
        normalized.push({
          logic: 'AND',
          field: `service_info.altitude${numSuffix}`,
          operator: '<=',
          value: max
        })
      } else if (min == 'undefined') {
        console.log(normalized, 'normalized2')
        normalized.push({
          logic,
          field: `service_info.altitude${numSuffix}`,
          operator: '<=',
          value: max
        })
      } else if (max == 'undefined') {
        console.log(normalized, 'normalized3')
        normalized.push({
          logic,
          field: `service_info.altitude${numSuffix}`,
          operator: '>=',
          value: min
        })
      }
    } else if (item.field.startsWith('serviceTime')) {
      const logic = index === 0 ? '' : 'AND'
      const match = item.field.match(/serviceTime(\d+)/)
      let field = ''

      if (!match) {
        // 无数字，构造 year1*12+month1+year2*12+month2+...+year6*12+month6
        const parts: string[] = []
        for (let i = 1; i <= 6; i++) {
          parts.push(`service_info.year${i}*12`)
          parts.push(`service_info.month${i}`)
        }
        field = parts.join('+')
      } else {
        // 有数字，比如 serviceTime3 -> year3*12+month3
        const num = match[1]
        field = `service_info.year${num}*12+service_info.month${num}`
      }

      if (item.value === '1') {
        // 小于10年
        normalized.push({
          logic,
          field,
          operator: '<',
          value: 120
        })
      } else if (item.value === '2') {
        // 10-15年区间
        normalized.push({
          logic,
          field,
          operator: '>=',
          value: 120
        })
        normalized.push({
          logic: 'AND',
          field,
          operator: '<=',
          value: 180
        })
      } else if (item.value === '3') {
        // 大于15年
        normalized.push({
          logic,
          field,
          operator: '>',
          value: 180
        })
      }
    } else if (item.field === 'serviceDuration') {
      // 处理服役时间差：退役年份 - 进入高原年份
      const logic = index === 0 ? '' : 'AND'
      let operator = item.operator
      let value = item.value
      normalized.push({
        logic,
        field: `(service_info.discharge_year - service_info.highland_entry_year)`,
        operator,
        value
      })
    } else if (item.field === 'residenceArea') {
      // 针对常住地区多选处理，value 可能是 "成都，昆明"
      const diseases = Array.isArray(item.value) ? item.value.map((v) => v.trim()) : []

      diseases.forEach((diseaseChoose, idx) => {
        const subField = camelToSnake(diseaseChoose)

        if (subField && subField !== 'other_area') {
          normalized.push({
            logic: idx === 0 && index === 0 ? '' : 'AND', // 第一个条件不带logic，后面都带AND
            field: `post_return_info.${subField}`,
            operator: '=',
            value: 1
          })
        } else if (subField === 'other_area') {
          // 处理其他地区的特殊情况
          normalized.push({
            logic: idx === 0 && index === 0 ? '' : 'AND',
            field: `post_return_info.${subField}`,
            operator: '!=',
            value: '0' // 其他地区不等于1
          })
        }
      })
    } else if (item.field === 'highlandDiseasesDuringService') {
      // 针对高原病多选处理，value 可能是 "高血压，肺心病"
      const diseases = Array.isArray(item.value) ? item.value.map((v) => v.trim()) : []

      diseases.forEach((diseaseChoose, idx) => {
        const subField = camelToSnake(diseaseChoose)
        if (subField) {
          normalized.push({
            logic: idx === 0 && index === 0 ? '' : 'AND', // 第一个条件不带logic，后面都带AND
            field: `highland_diseases_during_service.${subField}`,
            operator: '=',
            value: 1
          })
        }
      })
    } else if (item.field === 'newDiseasesPostReturn') {
      // 针对高原病多选处理，value 可能是 "高血压，肺心病"
      const diseases = Array.isArray(item.value) ? item.value.map((v) => v.trim()) : []

      diseases.forEach((diseaseChoose, idx) => {
        const subField = camelToSnake(diseaseChoose)
        if (subField) {
          normalized.push({
            logic: idx === 0 && index === 0 ? '' : 'AND', // 第一个条件不带logic，后面都带AND
            field: `new_diseases_post_return.${subField}`,
            operator: '=',
            value: 1
          })
        }
      })
    } else if (
      item.field === 'diseaseSpectrumDigestiveSystem' ||
      item.field === 'diseaseSpectrumCardiovascularSystem' ||
      item.field === 'diseaseSpectrumEndocrineSystem' ||
      item.field === 'diseaseSpectrumRespiratorySystem' ||
      item.field === 'diseaseSpectrumUrinarySystem' ||
      item.field === 'diseaseSpectrumSkeletalSystem' ||
      item.field === 'diseaseSpectrumNervousSystem'
    ) {
      // 针对高原病多选处理，value 可能是 "高血压，肺心病"
      const diseases = Array.isArray(item.value) ? item.value.map((v) => v.trim()) : []

      diseases.forEach((diseaseChoose, idx) => {
        const subField = camelToSnake(diseaseChoose)
        if (subField) {
          normalized.push({
            logic: idx === 0 && index === 0 ? '' : 'AND', // 第一个条件不带logic，后面都带AND
            field: `experiment_disease_spectrum.${subField}`,
            operator: '=',
            value: 1
          })
        }
      })
    } else if (
      item.field === 'diseaseSpectrumDigestiveSystemControl' ||
      item.field === 'diseaseSpectrumCardiovascularSystemControl' ||
      item.field === 'diseaseSpectrumEndocrineSystemControl' ||
      item.field === 'diseaseSpectrumRespiratorySystemControl' ||
      item.field === 'diseaseSpectrumUrinarySystemControl' ||
      item.field === 'diseaseSpectrumSkeletalSystemControl' ||
      item.field === 'diseaseSpectrumNervousSystemControl'
    ) {
      // 针对高原病多选处理，value 可能是 "高血压，肺心病"
      const diseases = Array.isArray(item.value) ? item.value.map((v) => v.trim()) : []

      diseases.forEach((diseaseChoose, idx) => {
        const subField = camelToSnake(diseaseChoose)
        if (subField) {
          normalized.push({
            logic: idx === 0 && index === 0 ? '' : 'AND', // 第一个条件不带logic，后面都带AND
            field: `control_disease_spectrum.${subField}`,
            operator: '=',
            value: 1
          })
        }
      })
    } else if (item.field === 'experimentExamEcgRespVO.ecgDescription') {
      const values = Array.isArray(item.value) ? item.value : []

      values.forEach((val, idx) => {
        const parts = val
          .split('/')
          .map((v) => v.trim())
          .filter(Boolean)

        parts.forEach((part, subIdx) => {
          normalized.push({
            logic: idx === 0 && subIdx === 0 ? '' : 'AND',
            field: 'ree_ecg.ecg_description',
            operator: 'like',
            value: `%${part}%`
          })
        })
      })
    } else {
      // 处理姓名模糊查询的operator转换
      let operator = item.operator
      let value = item.value
      if (fieldFull.toLowerCase().includes('name') && operator === '=') {
        operator = 'LIKE'
        value = `%${value}%`
      }

      normalized.push({
        logic,
        field: fieldFull,
        operator,
        value
      })
    }
  })

  return normalized
}
//-------------------------------------------------------------高级查询条件处理end----------------------------------------------------

//---------------------------------------------------------------高级查询左侧树start---------------------------------------------------
const fieldGroups = ref<Record<string, Record<string, TableField[]>>>({})

const convertToGroupedTree = (
  flatGroups: Record<string, TableField[]>
): Record<string, Record<string, TableField[]>> => {
  const tree: Record<string, Record<string, TableField[]>> = {}

  for (const [groupName, fields] of Object.entries(flatGroups)) {
    // 判断当前 groupName 是否属于某个大类
    if (groupName === '基础信息') {
      tree['基础信息'] = {
        基础信息字段: fields
      }
    } else if (experimentSurveyGroupFields[groupName]) {
      if (!tree['实验组流调']) tree['实验组流调'] = {}
      tree['实验组流调'][groupName] = fields
    } else if (experimentExamGroupFields[groupName]) {
      if (!tree['实验组体检']) tree['实验组体检'] = {}
      tree['实验组体检'][groupName] = fields
    } else if (controlSurveyGroupFields[groupName]) {
      if (!tree['对照组流调']) tree['对照组流调'] = {}
      tree['对照组流调'][groupName] = fields
    } else if (controlExamGroupFields[groupName]) {
      if (!tree['对照组体检']) tree['对照组体检'] = {}
      tree['对照组体检'][groupName] = fields
    } else {
      // 兜底：归为“其他”组
      if (!tree['其他']) tree['其他'] = {}
      tree['其他'][groupName] = fields
    }
  }

  return tree
}

// 封装更新逻辑
const updateFieldsAndGroups = () => {
  updateDisplayedFields() // 更新 displayedFields.value
  fieldGroups.value = convertToGroupedTree(displayedFields.value as Record<string, TableField[]>)
  getList()
}
//---------------------------------------------------------------高级查询左侧树end---------------------------------------------------

//---------------------------------------------------------点击表头，上方显示平均值逻辑start--------------------------------------------
// 检查是否存在 field 为 "basicOtherInfoRespVO.age" 的条件
// const hasAgeCondition = computed(() =>
//   conditions.value.some(
//     (condition: { field: string }) => condition.field === 'basicOtherInfoRespVO.age'
//   )
// )
// const hasAltitudeCondition = computed(() =>
//   conditions.value.some(
//     (condition: { field: string }) =>
//       condition.field === 'experimentSurveyServiceInfoRespVO.altitude' ||
//       condition.field === 'experimentSurveyServiceInfoRespVO.altitude1' ||
//       condition.field === 'experimentSurveyServiceInfoRespVO.altitude2' ||
//       condition.field === 'experimentSurveyServiceInfoRespVO.altitude3' ||
//       condition.field === 'experimentSurveyServiceInfoRespVO.altitude4' ||
//       condition.field === 'experimentSurveyServiceInfoRespVO.altitude5' ||
//       condition.field === 'experimentSurveyServiceInfoRespVO.altitude6'
//   )
// )
// const hasServiceTimeCondition = computed(() =>
//   conditions.value.some(
//     (condition: { field: string }) =>
//       condition.field === 'serviceTime'
//   )
// )
// const hasResidenceTimeCondition = computed(() =>
//   conditions.value.some(
//     (condition: { field: string }) =>
//       condition.field === 'residenceArea' || condition.field === 'residenceTime'
//   )
// )
const hasGenderCondition = ref(false)
const hasAgeCondition = ref(false)
const hasAltitudeCondition = ref(false)
const hasServiceTimeCondition = ref(false)
const hasDischargeYearCondition = ref(false)
const hasResidenceTimeCondition = ref(false)
const hasReeAverageTotalCholesterol = ref(false)
const hasReeAverageTriglycerides = ref(false)
const hasReeAverageHdlC = ref(false)
const hasReeAverageLdlC = ref(false)
const hasRceAverageTotalCholesterol = ref(false)
const hasRceAverageTriglycerides = ref(false)
const hasRceAverageHdlC = ref(false)
const hasRceAverageLdlC = ref(false)

const hasReeAverageWbc = ref(false)
const hasReeAverageRbc = ref(false)
const hasReeAverageNeutrophils = ref(false)
const hasReeAverageLymphocytes = ref(false)
const hasReeAverageMonocytes = ref(false)
const hasReeAverageEosinophils = ref(false)
const hasReeAverageBasophils = ref(false)
const hasReeAverageMcv = ref(false)
const hasReeAverageMch = ref(false)
const hasReeAverageMchc = ref(false)
const hasReeAverageRdwCv = ref(false)
const hasReeAverageRdwSd = ref(false)
const hasReeAverageHemoglobin = ref(false)
const hasReeAveragePlateletCrit = ref(false)
const hasReeAverageMpv = ref(false)
const hasReeAveragePdw = ref(false)
const hasReeAverageHematocrit = ref(false)
const hasReeAveragePlateletCount = ref(false)
const hasReeAverageNeutrophilsPercentage = ref(false)
const hasReeAverageLymphocytesPercentage = ref(false)
const hasReeAverageMonocytesPercentage = ref(false)
const hasReeAverageEosinophilsPercentage = ref(false)
const hasReeAverageBasophilsPercentage = ref(false)

const hasRceAverageWbc = ref(false)
const hasRceAverageRbc = ref(false)
const hasRceAverageNeutrophils = ref(false)
const hasRceAverageLymphocytes = ref(false)
const hasRceAverageMonocytes = ref(false)
const hasRceAverageEosinophils = ref(false)
const hasRceAverageBasophils = ref(false)
const hasRceAverageMcv = ref(false)
const hasRceAverageMch = ref(false)
const hasRceAverageMchc = ref(false)
const hasRceAverageRdwCv = ref(false)
const hasRceAverageRdwSd = ref(false)
const hasRceAverageHemoglobin = ref(false)
const hasRceAveragePlateletCrit = ref(false)
const hasRceAverageMpv = ref(false)
const hasRceAveragePdw = ref(false)
const hasRceAverageHematocrit = ref(false)
const hasRceAveragePlateletCount = ref(false)
const hasRceAverageNeutrophilsPercentage = ref(false)
const hasRceAverageLymphocytesPercentage = ref(false)
const hasRceAverageMonocytesPercentage = ref(false)
const hasRceAverageEosinophilsPercentage = ref(false)
const hasRceAverageBasophilsPercentage = ref(false)

const hasReeAverageTotalProtein = ref(false)
const hasReeAverageAlbumin = ref(false)
const hasReeAverageGlobulin = ref(false)
const hasReeAverageAlbGlobRatio = ref(false)
const hasReeAverageTotalBilirubin = ref(false)
const hasReeAverageDirectBilirubin = ref(false)
const hasReeAverageIndirectBilirubin = ref(false)
const hasReeAverageAlt = ref(false)
const hasReeAverageAst = ref(false)
const hasReeAverageUricAcid = ref(false)
const hasReeAverageUrea = ref(false)
const hasReeAverageCreatinine = ref(false)
const hasReeAverageProthrombinTime = ref(false)
const hasReeAverageProthrombinActivity = ref(false)
const hasReeAverageInr = ref(false)
const hasReeAverageFibrinogen = ref(false)
const hasReeAverageAptt = ref(false)
const hasReeAverageThrombinTime = ref(false)

const hasRceAverageTotalProtein = ref(false)
const hasRceAverageAlbumin = ref(false)
const hasRceAverageGlobulin = ref(false)
const hasRceAverageAlbGlobRatio = ref(false)
const hasRceAverageTotalBilirubin = ref(false)
const hasRceAverageDirectBilirubin = ref(false)
const hasRceAverageIndirectBilirubin = ref(false)
const hasRceAverageAlt = ref(false)
const hasRceAverageAst = ref(false)
const hasRceAverageUricAcid = ref(false)
const hasRceAverageUrea = ref(false)
const hasRceAverageCreatinine = ref(false)
const hasRceAverageProthrombinTime = ref(false)
const hasRceAverageProthrombinActivity = ref(false)
const hasRceAverageInr = ref(false)
const hasRceAverageFibrinogen = ref(false)
const hasRceAverageAptt = ref(false)
const hasRceAverageThrombinTime = ref(false)

function handleHeaderClick(column: any) {
  const label = column.label

  // 所有条件先重置
  hasGenderCondition.value = false
  hasAgeCondition.value = false
  hasAltitudeCondition.value = false
  hasServiceTimeCondition.value = false
  hasDischargeYearCondition.value = false
  hasResidenceTimeCondition.value = false
  hasReeAverageTotalCholesterol.value = false
  hasReeAverageTriglycerides.value = false
  hasReeAverageHdlC.value = false
  hasReeAverageLdlC.value = false
  hasRceAverageTotalCholesterol.value = false
  hasRceAverageTriglycerides.value = false
  hasRceAverageHdlC.value = false
  hasRceAverageLdlC.value = false

  hasReeAverageWbc.value = false
  hasReeAverageRbc.value = false
  hasReeAverageNeutrophils.value = false
  hasReeAverageLymphocytes.value = false
  hasReeAverageMonocytes.value = false
  hasReeAverageEosinophils.value = false
  hasReeAverageBasophils.value = false
  hasReeAverageMcv.value = false
  hasReeAverageMch.value = false
  hasReeAverageMchc.value = false
  hasReeAverageRdwCv.value = false
  hasReeAverageRdwSd.value = false
  hasReeAverageHemoglobin.value = false
  hasReeAveragePlateletCrit.value = false
  hasReeAverageMpv.value = false
  hasReeAveragePdw.value = false
  hasReeAverageHematocrit.value = false
  hasReeAveragePlateletCount.value = false
  hasReeAverageNeutrophilsPercentage.value = false
  hasReeAverageLymphocytesPercentage.value = false
  hasReeAverageMonocytesPercentage.value = false
  hasReeAverageEosinophilsPercentage.value = false
  hasReeAverageBasophilsPercentage.value = false

  hasRceAverageWbc.value = false
  hasRceAverageRbc.value = false
  hasRceAverageNeutrophils.value = false
  hasRceAverageLymphocytes.value = false
  hasRceAverageMonocytes.value = false
  hasRceAverageEosinophils.value = false
  hasRceAverageBasophils.value = false
  hasRceAverageMcv.value = false
  hasRceAverageMch.value = false
  hasRceAverageMchc.value = false
  hasRceAverageRdwCv.value = false
  hasRceAverageRdwSd.value = false
  hasRceAverageHemoglobin.value = false
  hasRceAveragePlateletCrit.value = false
  hasRceAverageMpv.value = false
  hasRceAveragePdw.value = false
  hasRceAverageHematocrit.value = false
  hasRceAveragePlateletCount.value = false
  hasRceAverageNeutrophilsPercentage.value = false
  hasRceAverageLymphocytesPercentage.value = false
  hasRceAverageMonocytesPercentage.value = false
  hasRceAverageEosinophilsPercentage.value = false
  hasRceAverageBasophilsPercentage.value = false

  hasReeAverageTotalProtein.value = false
  hasReeAverageAlbumin.value = false
  hasReeAverageGlobulin.value = false
  hasReeAverageAlbGlobRatio.value = false
  hasReeAverageTotalBilirubin.value = false
  hasReeAverageDirectBilirubin.value = false
  hasReeAverageIndirectBilirubin.value = false
  hasReeAverageAlt.value = false
  hasReeAverageAst.value = false
  hasReeAverageUricAcid.value = false
  hasReeAverageUrea.value = false
  hasReeAverageCreatinine.value = false
  hasReeAverageProthrombinTime.value = false
  hasReeAverageProthrombinActivity.value = false
  hasReeAverageInr.value = false
  hasReeAverageFibrinogen.value = false
  hasReeAverageAptt.value = false
  hasReeAverageThrombinTime.value = false

  hasRceAverageTotalProtein.value = false
  hasRceAverageAlbumin.value = false
  hasRceAverageGlobulin.value = false
  hasRceAverageAlbGlobRatio.value = false
  hasRceAverageTotalBilirubin.value = false
  hasRceAverageDirectBilirubin.value = false
  hasRceAverageIndirectBilirubin.value = false
  hasRceAverageAlt.value = false
  hasRceAverageAst.value = false
  hasRceAverageUricAcid.value = false
  hasRceAverageUrea.value = false
  hasRceAverageCreatinine.value = false
  hasRceAverageProthrombinTime.value = false
  hasRceAverageProthrombinActivity.value = false
  hasRceAverageInr.value = false
  hasRceAverageFibrinogen.value = false
  hasRceAverageAptt.value = false
  hasRceAverageThrombinTime.value = false

  // 根据表头名开启对应条件
  switch (label) {
    case '性别':
      hasGenderCondition.value = true
      break
    case '年龄':
      hasAgeCondition.value = true
      break
    case '应用海拔':
      hasAltitudeCondition.value = true
      break
    case '退役年份':
      hasDischargeYearCondition.value = true
      break
    // case '常住地区':
    //   hasResidenceTimeCondition.value = true
    //   break
  }
  const property = column.property
  switch (property) {
    case 'serviceTime':
      hasServiceTimeCondition.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.totalCholesterol':
      hasReeAverageTotalCholesterol.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.triglycerides':
      hasReeAverageTriglycerides.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.hdlC':
      hasReeAverageHdlC.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.ldlC':
      hasReeAverageLdlC.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.totalProtein':
      hasReeAverageTotalProtein.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.albumin':
      hasReeAverageAlbumin.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.globulin':
      hasReeAverageGlobulin.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.albGlobRatio':
      hasReeAverageAlbGlobRatio.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.totalBilirubin':
      hasReeAverageTotalBilirubin.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.directBilirubin':
      hasReeAverageDirectBilirubin.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.indirectBilirubin':
      hasReeAverageIndirectBilirubin.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.alt':
      hasReeAverageAlt.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.ast':
      hasReeAverageAst.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.uricAcid':
      hasReeAverageUricAcid.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.urea':
      hasReeAverageUrea.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.creatinine':
      hasReeAverageCreatinine.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.prothrombinTime':
      hasReeAverageProthrombinTime.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.prothrombinActivity':
      hasReeAverageProthrombinActivity.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.inr':
      hasReeAverageInr.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.fibrinogen':
      hasReeAverageFibrinogen.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.aptt':
      hasReeAverageAptt.value = true
      break
    case 'experimentExamBiochemicalTestsRespVO.thrombinTime':
      hasReeAverageThrombinTime.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.totalCholesterol':
      hasRceAverageTotalCholesterol.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.triglycerides':
      hasRceAverageTriglycerides.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.hdlC':
      hasRceAverageHdlC.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.ldlC':
      hasRceAverageLdlC.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.totalProtein':
      hasRceAverageTotalProtein.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.albumin':
      hasRceAverageAlbumin.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.globulin':
      hasRceAverageGlobulin.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.albGlobRatio':
      hasRceAverageAlbGlobRatio.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.totalBilirubin':
      hasRceAverageTotalBilirubin.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.directBilirubin':
      hasRceAverageDirectBilirubin.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.indirectBilirubin':
      hasRceAverageIndirectBilirubin.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.alt':
      hasRceAverageAlt.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.ast':
      hasRceAverageAst.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.uricAcid':
      hasRceAverageUricAcid.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.urea':
      hasRceAverageUrea.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.creatinine':
      hasRceAverageCreatinine.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.prothrombinTime':
      hasRceAverageProthrombinTime.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.prothrombinActivity':
      hasRceAverageProthrombinActivity.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.inr':
      hasRceAverageInr.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.fibrinogen':
      hasRceAverageFibrinogen.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.aptt':
      hasRceAverageAptt.value = true
      break
    case 'controlExamBiochemicalTestsRespVO.thrombinTime':
      hasRceAverageThrombinTime.value = true
      break
    // 血常规相关字段
    case 'experimentExamBloodRoutineRespVO.wbc':
      hasReeAverageWbc.value = true
      break
    case 'experimentExamBloodRoutineRespVO.rbc':
      hasReeAverageRbc.value = true
      break
    case 'experimentExamBloodRoutineRespVO.hemoglobin':
      hasReeAverageNeutrophils.value = true
      break
    case 'experimentExamBloodRoutineRespVO.hematocrit':
      hasReeAverageLymphocytes.value = true
      break
    case 'experimentExamBloodRoutineRespVO.mcv':
      hasReeAverageMonocytes.value = true
      break
    case 'experimentExamBloodRoutineRespVO.mch':
      hasReeAverageEosinophils.value = true
      break
    case 'experimentExamBloodRoutineRespVO.mchc':
      hasReeAverageBasophils.value = true
      break
    case 'experimentExamBloodRoutineRespVO.rdwCv':
      hasReeAverageMcv.value = true
      break
    case 'experimentExamBloodRoutineRespVO.rdwSd':
      hasReeAverageMch.value = true
      break
    case 'experimentExamBloodRoutineRespVO.plateletCount':
      hasReeAverageMchc.value = true
      break
    case 'experimentExamBloodRoutineRespVO.plateletCrit':
      hasReeAverageRdwCv.value = true
      break
    case 'experimentExamBloodRoutineRespVO.mpv':
      hasReeAverageRdwSd.value = true
      break
    case 'experimentExamBloodRoutineRespVO.pdw':
      hasReeAverageHemoglobin.value = true
      break
    case 'experimentExamBloodRoutineRespVO.neutrophils':
      hasReeAveragePlateletCrit.value = true
      break
    case 'experimentExamBloodRoutineRespVO.lymphocytes':
      hasReeAverageMpv.value = true
      break
    case 'experimentExamBloodRoutineRespVO.monocytes':
      hasReeAveragePdw.value = true
      break
    case 'experimentExamBloodRoutineRespVO.eosinophils':
      hasReeAverageHematocrit.value = true
      break
    case 'experimentExamBloodRoutineRespVO.basophils':
      hasReeAveragePlateletCount.value = true
      break
    case 'experimentExamBloodRoutineRespVO.neutrophilsPercentage':
      hasReeAverageNeutrophilsPercentage.value = true
      break
    case 'experimentExamBloodRoutineRespVO.lymphocytesPercentage':
      hasReeAverageLymphocytesPercentage.value = true
      break
    case 'experimentExamBloodRoutineRespVO.monocytesPercentage':
      hasReeAverageMonocytesPercentage.value = true
      break
    case 'experimentExamBloodRoutineRespVO.eosinophilsPercentage':
      hasReeAverageEosinophilsPercentage.value = true
      break
    case 'experimentExamBloodRoutineRespVO.basophilsPercentage':
      hasReeAverageBasophilsPercentage.value = true
      break

    case 'controlExamBloodRoutineRespVO.wbc':
      hasRceAverageWbc.value = true
      break
    case 'controlExamBloodRoutineRespVO.rbc':
      hasRceAverageRbc.value = true
      break
    case 'controlExamBloodRoutineRespVO.hemoglobin':
      hasRceAverageNeutrophils.value = true
      break
    case 'controlExamBloodRoutineRespVO.hematocrit':
      hasRceAverageLymphocytes.value = true
      break
    case 'controlExamBloodRoutineRespVO.mcv':
      hasRceAverageMonocytes.value = true
      break
    case 'controlExamBloodRoutineRespVO.mch':
      hasRceAverageEosinophils.value = true
      break
    case 'controlExamBloodRoutineRespVO.mchc':
      hasRceAverageBasophils.value = true
      break
    case 'controlExamBloodRoutineRespVO.rdwCv':
      hasRceAverageMcv.value = true
      break
    case 'controlExamBloodRoutineRespVO.rdwSd':
      hasRceAverageMch.value = true
      break
    case 'controlExamBloodRoutineRespVO.plateletCount':
      hasRceAverageMchc.value = true
      break
    case 'controlExamBloodRoutineRespVO.plateletCrit':
      hasRceAverageRdwCv.value = true
      break
    case 'controlExamBloodRoutineRespVO.mpv':
      hasRceAverageRdwSd.value = true
      break
    case 'controlExamBloodRoutineRespVO.pdw':
      hasRceAverageHemoglobin.value = true
      break
    case 'controlExamBloodRoutineRespVO.neutrophils':
      hasRceAveragePlateletCrit.value = true
      break
    case 'controlExamBloodRoutineRespVO.lymphocytes':
      hasRceAverageMpv.value = true
      break
    case 'controlExamBloodRoutineRespVO.monocytes':
      hasRceAveragePdw.value = true
      break
    case 'controlExamBloodRoutineRespVO.eosinophils':
      hasRceAverageHematocrit.value = true
      break
    case 'controlExamBloodRoutineRespVO.basophils':
      hasRceAveragePlateletCount.value = true
      break
    case 'controlExamBloodRoutineRespVO.neutrophilsPercentage':
      hasRceAverageNeutrophilsPercentage.value = true
      break
    case 'controlExamBloodRoutineRespVO.lymphocytesPercentage':
      hasRceAverageLymphocytesPercentage.value = true
      break
    case 'controlExamBloodRoutineRespVO.monocytesPercentage':
      hasRceAverageMonocytesPercentage.value = true
      break
    case 'controlExamBloodRoutineRespVO.eosinophilsPercentage':
      hasRceAverageEosinophilsPercentage.value = true
      break
    case 'controlExamBloodRoutineRespVO.basophilsPercentage':
      hasRceAverageBasophilsPercentage.value = true
      break
  }
}

function getHeaderCellClass({ column }) {
  const clickableFields = [
    '性别',
    '年龄',
    '应用海拔',
    '应用服役时长',
    // '常住地区',
    '退役年份',
    '总胆固醇',
    '甘油三酯',
    '高密度脂蛋白胆固醇',
    '低密度脂蛋白胆固醇',
    '白细胞计数',
    '红细胞计数',
    '血红蛋白浓度',
    '红细胞比容',
    '平均红细胞容积',
    '平均红细胞血红蛋白含量',
    '平均红细胞血红蛋白浓度',
    'RBC分布宽度CV值',
    'RBC分布宽度SD值',
    '血小板计数',
    '血小板比容',
    '平均血小板体积',
    '血小板分布宽度',
    '中性粒细胞计数',
    '淋巴细胞计数',
    '单核细胞计数',
    '嗜酸性粒细胞计数',
    '嗜碱性粒细胞计数',
    '中性粒细胞百分率',
    '淋巴细胞百分率',
    '单核细胞百分率',
    '嗜酸性粒细胞百分率',
    '嗜碱性粒细胞百分率',
    '总蛋白',
    '白蛋白',
    '球蛋白',
    '白球比例',
    '总胆红素',
    '直接胆红素',
    '间接胆红素',
    '谷丙转氨酶',
    '谷草转氨酶',
    '尿酸',
    '尿素',
    '肌酐',
    '凝血酶原时间',
    '凝血酶原活动度',
    '国际标准化比率',
    '纤维蛋白原',
    '活化部分凝血活酶时间',
    '凝血酶时间'
  ]
  if (clickableFields.includes(column.label)) {
    return 'clickable-header'
  }
  return ''
}
//---------------------------------------------------------点击表头，上方显示平均值逻辑嗯对end--------------------------------------------

// 监听筛选条件的变化
watch(
  () => [
    queryParams.baseInfo,
    queryParams.experimentGroupSurvey,
    queryParams.experimentGroupExam,
    queryParams.compareGroupSurvey,
    queryParams.compareGroupExam,
    queryParams.group,
    queryParams.type
  ],
  updateFieldsAndGroups,
  { deep: true, immediate: true }
)

/** 初始化 */
onMounted(() => {
  getList()
})

const formatToYearMonth = (months) => {
  const years = Math.floor(months / 12) // 计算年
  const remainingMonths = Math.ceil(months % 12) // 计算剩余月并向上取整
  if (remainingMonths === 12) {
    // 如果剩余月数为 12，则进位到下一年
    return `${years + 1}年0月`
  }
  return `${years}年${remainingMonths}月`
}


const exportLoading = ref(false) // 导出的加载中
const message = useMessage() // 消息弹窗

const handleExport = async () => {
  try {
    // 导出的二次确认
    await message.exportConfirm()
    // 发起导出
    
    exportLoading.value = true
    const data = await BasicInfoApi.exportReview(queryParams)
    if(queryParams.group == 1){
      download.excel(data, '回顾性-实验组.xls')
    }else{
      download.excel(data, '回顾性-对照组.xls')
    }
    
  } catch {
  } finally {
    exportLoading.value = false
  }
}

// 示例整合数据结构
// const fieldGroups = {
//   基本信息: {
//     基础信息字段: basicInfoFields
//   },
//   实验组流调: experimentSurveyGroupFields,
//   实验组体检: experimentExamGroupFields,
//   对照组流调: controlSurveyGroupFields,
//   对照组体检: controlExamGroupFields
// }
</script>
<style>
.select-width {
  width: 200px;
}

/* 表头样式，注意作用于 <th> 元素 */
.el-table__header .level-1-header {
  background-color: #f0f9ff !important; /* 一级表头浅蓝色 */
}
.el-table__header .level-2-header {
  background-color: #e0f7fa !important; /* 二级表头青绿色 */
}
.el-table__header .level-3-header {
  background-color: #fff3e0 !important; /* 三级表头浅橙色 */
}

/* 全局样式中添加，或使用 scoped 样式 */
.clickable-header {
  cursor: pointer;
  color: #409eff; /* Element Plus 主色调 */
  font-weight: bold;
}
</style>
