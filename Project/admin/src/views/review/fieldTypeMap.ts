interface TableField {
  label: string
  prop: string
}

// 基础信息
export const basicInfoFields: TableField[] = [
  { label: '性别', prop: 'gender' },
  { label: '年龄', prop: 'basicOtherInfoRespVO.age' },
  { label: '入伍年份', prop: 'experimentSurveyServiceInfoRespVO.enlistmentYear' },
  { label: '进入高原年份', prop: 'experimentSurveyServiceInfoRespVO.highlandEntryYear' },
  { label: '退役年份', prop: 'experimentSurveyServiceInfoRespVO.dischargeYear' },
  { label: '服役时间', prop: 'serviceDuration' },
  { label: '服役期间职务', prop: 'experimentSurveyServiceInfoRespVO.servicePosition' },
  { label: '学历', prop: 'highestEducation' },
  { label: '生育情况', prop: 'basicOtherInfoRespVO.fertilityStatus' },
  { label: '民族', prop: 'ethnicity' },
  { label: '身高（cm）', prop: 'height' },
  { label: '体重（公斤）', prop: 'weight' },
  { label: '退役体重（公斤）', prop: 'basicOtherInfoRespVO.retiredWeight' }
  // { label: '婚姻状况', prop: 'maritalStatus' },
]

// 实验组流调
export const experimentSurveyGroupFields: Record<string, any> = {
  吸烟情况: {
    吸烟: [
      { label: '每天吸烟数（根）', prop: 'experimentSurveySmokingRespVO.dailySmoking' },
      { label: '开始吸烟年龄', prop: 'experimentSurveySmokingRespVO.smokingStartAge' },
      { label: '烟龄', prop: 'experimentSurveySmokingRespVO.smokingYears' },
      { label: '尝试戒烟', prop: 'experimentSurveySmokingRespVO.triedQuit' },
      {
        label: '高原/平原吸烟情况',
        prop: 'experimentSurveySmokingRespVO.highlandPlainSmokingStatus'
      }
    ],
    已戒烟: [
      { label: '烟龄', prop: 'experimentSurveySmokingRespVO.smokingYears2' },
      { label: '戒烟时长', prop: 'experimentSurveySmokingRespVO.quitTime' },
      {
        label: '高原/平原吸烟情况',
        prop: 'experimentSurveySmokingRespVO.highlandPlainSmokingStatus2'
      }
    ],
    吸烟状态: [{ label: '吸烟状态', prop: 'experimentSurveySmokingRespVO.smokingStatus' }]
  },
  饮酒情况: [
    { label: '是否有饮酒经历', prop: 'experimentSurveyDrinkingRespVO.drinkingExperience' },
    { label: '是否仍在饮酒', prop: 'experimentSurveyDrinkingRespVO.stillDrinking' },
    { label: '饮酒频率', prop: 'experimentSurveyDrinkingRespVO.drinkingFrequency' },
    { label: '饮酒类型', prop: 'drinkingType' },
    { label: '是否过量饮酒', prop: 'experimentSurveyDrinkingRespVO.overDrinking' }
  ],
  自我评价: [
    {
      label: '与同龄人相比，您认为目前自己的身体健康状况如何',
      prop: 'experimentSurveySelfAssessmentRespVO.healthComparisonWithPeers'
    },
    {
      label: '您认为自己身体健康状况能得的分数',
      prop: 'experimentSurveySelfAssessmentRespVO.healthScore'
    }
  ],
  亲属既往疾病: [
    { label: '心血管循环系统', prop: 'cardiovascularCirculatorySystem' },
    { label: '呼吸系统', prop: 'respiratorySystem' },
    { label: '代谢系统', prop: 'MetabolicSystem' },
    { label: '消化系统', prop: 'digestiveSystem' },
    { label: '神经系统', prop: 'nervousSystem' },
    { label: '癌症', prop: 'cancer' }
  ],
  服役信息: {
    应用信息: [
      { label: '应用地点', prop: 'experimentSurveyServiceInfoRespVO.highlandServiceLocation' },
      { label: '应用海拔', prop: 'experimentSurveyServiceInfoRespVO.altitude' },
      { label: '应用服役时长', prop: 'serviceTime' }
    ],
    地点1: [
      {
        label: '服役地点',
        prop: 'experimentSurveyServiceInfoRespVO.highlandServiceLocation1'
      },
      { label: '海拔高度', prop: 'experimentSurveyServiceInfoRespVO.altitude1' },
      { label: '服役时长', prop: 'serviceTime1' }
    ],
    地点2: [
      {
        label: '服役地点',
        prop: 'experimentSurveyServiceInfoRespVO.highlandServiceLocation2'
      },
      { label: '海拔高度', prop: 'experimentSurveyServiceInfoRespVO.altitude2' },
      { label: '服役时长', prop: 'serviceTime2' }
    ],
    地点3: [
      {
        label: '服役地点',
        prop: 'experimentSurveyServiceInfoRespVO.highlandServiceLocation3'
      },
      { label: '海拔高度', prop: 'experimentSurveyServiceInfoRespVO.altitude3' },
      { label: '服役时长', prop: 'serviceTime3' }
    ],
    地点4: [
      {
        label: '服役地点',
        prop: 'experimentSurveyServiceInfoRespVO.highlandServiceLocation4'
      },
      { label: '海拔高度', prop: 'experimentSurveyServiceInfoRespVO.altitude4' },
      { label: '服役时长', prop: 'serviceTime4' }
    ],
    地点5: [
      {
        label: '服役地点',
        prop: 'experimentSurveyServiceInfoRespVO.highlandServiceLocation5'
      },
      { label: '海拔高度', prop: 'experimentSurveyServiceInfoRespVO.altitude5' },
      { label: '服役时长', prop: 'serviceTime5' }
    ],
    地点6: [
      {
        label: '服役地点',
        prop: 'experimentSurveyServiceInfoRespVO.highlandServiceLocation6'
      },
      { label: '海拔高度', prop: 'experimentSurveyServiceInfoRespVO.altitude6' },
      { label: '服役时长', prop: 'serviceTime6' }
    ]
  },
  高原服役期间高原反应信息: [
    { label: '从事高原任务类型', prop: 'experimentSurveyServiceInfoRespVO.highlandTaskType' },
    { label: '诊断过高原性疾病', prop: 'highlandDiseases' },
    {
      label: '是否发生过高原反应',
      prop: 'experimentSurveyHighlandReactionRespVO.reactionOccurred'
    },
    { label: '高原反应次数', prop: 'reactionCount' },
    { label: '高原反应症状', prop: 'highlandReactionSymptoms' },
    {
      label: '高原反应变化情况',
      prop: 'experimentSurveyHighlandReactionRespVO.multipleReactionsChanges'
    }
  ],
  退役后返回平原1月内症状: {
    精神及全身症状: [
      { label: '疲倦', prop: 'experimentSurveyPostReturnSymptomsRespVO.fatigue' },
      { label: '嗜睡', prop: 'experimentSurveyPostReturnSymptomsRespVO.drowsiness' },
      { label: '头昏', prop: 'experimentSurveyPostReturnSymptomsRespVO.dizziness' },
      { label: '眩晕', prop: 'experimentSurveyPostReturnSymptomsRespVO.vertigo' },
      { label: '精力不集中', prop: 'experimentSurveyPostReturnSymptomsRespVO.poorConcentration' },
      { label: '反应迟钝', prop: 'experimentSurveyPostReturnSymptomsRespVO.slowReaction' },
      { label: '记忆减退', prop: 'experimentSurveyPostReturnSymptomsRespVO.memoryLoss' },
      { label: '失眠', prop: 'experimentSurveyPostReturnSymptomsRespVO.insomnia' },
      { label: '多梦', prop: 'experimentSurveyPostReturnSymptomsRespVO.nightmares' }
    ],
    循环症状: [
      { label: '心前区痛', prop: 'experimentSurveyPostReturnSymptomsRespVO.chestPain' },
      { label: '心慌', prop: 'experimentSurveyPostReturnSymptomsRespVO.palpitations' },
      { label: '脉率减慢', prop: 'experimentSurveyPostReturnSymptomsRespVO.bradycardia' },
      { label: '紫绀', prop: 'experimentSurveyPostReturnSymptomsRespVO.cyanosis' },
      {
        label: '血压波动',
        prop: 'experimentSurveyPostReturnSymptomsRespVO.bloodPressureFluctuation'
      },
      { label: '皮肤出血', prop: 'experimentSurveyPostReturnSymptomsRespVO.skinBleeding' },
      { label: '皮肤瘀斑', prop: 'experimentSurveyPostReturnSymptomsRespVO.skinBruising' },
      { label: '贫血', prop: 'experimentSurveyPostReturnSymptomsRespVO.anemia' }
    ],
    呼吸症状: [
      { label: '咽喉痛', prop: 'experimentSurveyPostReturnSymptomsRespVO.soreThroat' },
      { label: '咳嗽', prop: 'experimentSurveyPostReturnSymptomsRespVO.cough' },
      { label: '多痰', prop: 'experimentSurveyPostReturnSymptomsRespVO.phlegm' },
      { label: '气喘', prop: 'experimentSurveyPostReturnSymptomsRespVO.wheezing' },
      { label: '胸闷', prop: 'experimentSurveyPostReturnSymptomsRespVO.chestTightness' }
    ],
    消化症状: [
      { label: '体重减轻', prop: 'experimentSurveyPostReturnSymptomsRespVO.weightLoss' },
      { label: '食欲增加', prop: 'experimentSurveyPostReturnSymptomsRespVO.increasedAppetite' },
      { label: '厌食', prop: 'experimentSurveyPostReturnSymptomsRespVO.anorexia' },
      { label: '便秘', prop: 'experimentSurveyPostReturnSymptomsRespVO.constipation' },
      { label: '腹泻', prop: 'experimentSurveyPostReturnSymptomsRespVO.diarrhea' },
      { label: '腹痛', prop: 'experimentSurveyPostReturnSymptomsRespVO.abdominalPain' },
      { label: '黄疸', prop: 'experimentSurveyPostReturnSymptomsRespVO.jaundice' }
    ],
    其他症状: [
      { label: '手足麻木', prop: 'experimentSurveyPostReturnSymptomsRespVO.numbness' },
      { label: '肢体水肿', prop: 'experimentSurveyPostReturnSymptomsRespVO.limbEdema' },
      { label: '面部水肿', prop: 'experimentSurveyPostReturnSymptomsRespVO.facialEdema' },
      { label: '脱发', prop: 'experimentSurveyPostReturnSymptomsRespVO.hairLoss' },
      { label: '夜尿增多', prop: 'experimentSurveyPostReturnSymptomsRespVO.increasedUrination' }
    ]
  },
  高原返回平原后基本信息: [
    { label: '常住地区', prop: 'residenceArea' },
    { label: '每年居住时间', prop: 'residenceTime' },
    { label: '工作情况', prop: 'experimentSurveyPostReturnInfoRespVO.postReturnWorkStatus' },
    { label: '体检或就诊次数', prop: 'experimentSurveyPostReturnInfoRespVO.annualCheckups' }
  ],
  新发疾病诊断情况: {
    高原期间出现疾病: [
      {
        label: '高原期间出现疾病',
        prop: 'highlandDiseasesDuringService'
      }
    ],
    返回平原后新发疾病: [
      {
        label: '返回平原后新发疾病',
        prop: 'newDiseasesPostReturn'
      }
    ],
    新发疾病诊断1: [
      { label: '疾病名称', prop: 'experimentSurveyNewDiseasesRespVO.newDisease1Name' },
      {
        label: '是否在二级或二级以上医院被诊断',
        prop: 'experimentSurveyNewDiseasesRespVO.diagnosed'
      },
      { label: '诊断时间', prop: 'experimentSurveyNewDiseasesRespVO.diagnosisDate' },
      { label: '是否住院', prop: 'experimentSurveyNewDiseasesRespVO.hospitalized' },
      { label: '是否药物治疗', prop: 'experimentSurveyNewDiseasesRespVO.medication' },
      { label: '药物治疗效果', prop: 'experimentSurveyNewDiseasesRespVO.medicationEffect' }
    ],
    新发疾病诊断2: [
      { label: '疾病名称', prop: 'experimentSurveyNewDiseasesRespVO.newDisease2Name' },
      {
        label: '是否在二级或二级以上医院被诊断',
        prop: 'experimentSurveyNewDiseasesRespVO.diagnosed2'
      },
      { label: '诊断时间', prop: 'experimentSurveyNewDiseasesRespVO.diagnosisDate2' },
      { label: '是否住院', prop: 'experimentSurveyNewDiseasesRespVO.hospitalized2' },
      { label: '是否药物治疗', prop: 'experimentSurveyNewDiseasesRespVO.medication2' },
      { label: '药物治疗效果', prop: 'experimentSurveyNewDiseasesRespVO.medicationEffect2' }
    ],
    新发疾病诊断3: [
      { label: '疾病名称', prop: 'experimentSurveyNewDiseasesRespVO.newDisease3Name' },
      {
        label: '是否在二级或二级以上医院被诊断',
        prop: 'experimentSurveyNewDiseasesRespVO.diagnosed3'
      },
      { label: '诊断时间', prop: 'experimentSurveyNewDiseasesRespVO.diagnosisDate3' },
      { label: '是否住院', prop: 'experimentSurveyNewDiseasesRespVO.hospitalized3' },
      { label: '是否药物治疗', prop: 'experimentSurveyNewDiseasesRespVO.medication3' },
      { label: '药物治疗效果', prop: 'experimentSurveyNewDiseasesRespVO.medicationEffect3' }
    ],
    新发疾病诊断4: [
      { label: '疾病名称', prop: 'experimentSurveyNewDiseasesRespVO.newDisease4Name' },
      {
        label: '是否在二级或二级以上医院被诊断',
        prop: 'experimentSurveyNewDiseasesRespVO.diagnosed4'
      },
      { label: '诊断时间', prop: 'experimentSurveyNewDiseasesRespVO.diagnosisDate4' },
      { label: '是否住院', prop: 'experimentSurveyNewDiseasesRespVO.hospitalized4' },
      { label: '是否药物治疗', prop: 'experimentSurveyNewDiseasesRespVO.medication4' },
      { label: '药物治疗效果', prop: 'experimentSurveyNewDiseasesRespVO.medicationEffect4' }
    ]
  },
  返回平原后体育锻炼情况: [
    { label: '是否有规律锻炼', prop: 'experimentSurveyExerciseRespVO.regularExercise' },
    { label: '锻炼频率', prop: 'experimentSurveyExerciseRespVO.exerciseFrequency' },
    { label: '每次锻炼时长', prop: 'experimentSurveyExerciseRespVO.exerciseDuration' },
    { label: '体育锻炼形式', prop: 'exerciseType' },
    { label: '胸闷、气促', prop: 'experimentSurveyExerciseRespVO.chestPainOrShortness' },
    {
      label: '医生指导下体育锻炼',
      prop: 'experimentSurveyExerciseRespVO.doctorGuidedExercise'
    }
  ],
  返回平原后饮食习惯: [
    { label: '饮食情况', prop: 'experimentSurveyDietRespVO.eatingHabits' },
    { label: '平时饮用饮料', prop: 'dietType' }
  ],
  近一周睡眠情况: [
    { label: '晚上睡觉时间(点)', prop: 'experimentSurveySleepRespVO.sleepTimeStart' },
    { label: '入睡需要时间（分钟）', prop: 'experimentSurveySleepRespVO.sleepOnsetTime' },
    { label: '起床时间(点)', prop: 'experimentSurveySleepRespVO.wakeTime' },
    { label: '实际睡眠时间（小时）', prop: 'experimentSurveySleepRespVO.actualSleepDuration' },
    { label: '影响睡眠烦恼原因', prop: 'reasonsAffectingSleep' },
    { label: '催眠药使用情况', prop: 'experimentSurveySleepRespVO.sleepAids' },
    { label: '感到困倦', prop: 'experimentSurveySleepRespVO.fatigue' },
    { label: '精力不足', prop: 'experimentSurveySleepRespVO.lackOfEnergy' },
    { label: '自评睡眠情况', prop: 'experimentSurveySleepRespVO.selfAssessmentSleep' }
  ],
  疾病谱: [
    { label: '消化系统', prop: 'diseaseSpectrumDigestiveSystem' },
    { label: '心血管系统', prop: 'diseaseSpectrumCardiovascularSystem' },
    { label: '内分泌系统', prop: 'diseaseSpectrumEndocrineSystem' },
    { label: '呼吸系统', prop: 'diseaseSpectrumRespiratorySystem' },
    { label: '泌尿系统', prop: 'diseaseSpectrumUrinarySystem' },
    { label: '骨骼系统', prop: 'diseaseSpectrumSkeletalSystem' },
    { label: '神经系统', prop: 'diseaseSpectrumNervousSystem' }
  ],
  framingham评分: [
    { label: 'Framingham评分（分）', prop: 'experimentFraminghamRespVO.framinghamScore' },
    { label: 'Framingham概率', prop: 'experimentFraminghamRespVO.framinghamRisk' },
    { label: 'Framingham分类', prop: 'experimentFraminghamRespVO.framinghamRiskType' }
  ]
}

// 实验组体检
export const experimentExamGroupFields: Record<string, TableField[]> = {
  腹部超声: [
    {
      label: '腹部超声-描述',
      prop: 'experimentExamAbdominalUltrasoundRespVO.ultrasoundDescription'
    },
    { label: '腹部超声-小结', prop: 'experimentExamAbdominalUltrasoundRespVO.ultrasoundSummary' }
  ],
  基本检测信息: [
    { label: '收缩压(mmHg)', prop: 'experimentExamBasicTestsRespVO.systolicPressure' },
    { label: '舒张压(mmHg)', prop: 'experimentExamBasicTestsRespVO.diastolicPressure' },
    { label: '脉搏(次/分)', prop: 'experimentExamBasicTestsRespVO.pulse' },
    { label: '身高(CM)', prop: 'experimentExamBasicTestsRespVO.height' },
    { label: '体重(KG)', prop: 'experimentExamBasicTestsRespVO.weight' },
    { label: '体重指数(kg/m^2)', prop: 'experimentExamBasicTestsRespVO.bmi' }
  ],
  生化: [
    { label: '尿素', prop: 'experimentExamBiochemicalTestsRespVO.urea' },
    { label: '肌酐', prop: 'experimentExamBiochemicalTestsRespVO.creatinine' },
    { label: '谷丙转氨酶', prop: 'experimentExamBiochemicalTestsRespVO.alt' },
    { label: '谷草转氨酶', prop: 'experimentExamBiochemicalTestsRespVO.ast' },
    { label: '总胆固醇', prop: 'experimentExamBiochemicalTestsRespVO.totalCholesterol' },
    { label: '甘油三酯', prop: 'experimentExamBiochemicalTestsRespVO.triglycerides' },
    { label: '高密度脂蛋白胆固醇', prop: 'experimentExamBiochemicalTestsRespVO.hdlC' },
    { label: '低密度脂蛋白胆固醇', prop: 'experimentExamBiochemicalTestsRespVO.ldlC' },
    { label: '尿酸', prop: 'experimentExamBiochemicalTestsRespVO.uricAcid' },
    { label: '总蛋白', prop: 'experimentExamBiochemicalTestsRespVO.totalProtein' },
    { label: '白蛋白', prop: 'experimentExamBiochemicalTestsRespVO.albumin' },
    { label: '球蛋白', prop: 'experimentExamBiochemicalTestsRespVO.globulin' },
    { label: '白球比例', prop: 'experimentExamBiochemicalTestsRespVO.albGlobRatio' },
    { label: '总胆红素', prop: 'experimentExamBiochemicalTestsRespVO.totalBilirubin' },
    { label: '直接胆红素', prop: 'experimentExamBiochemicalTestsRespVO.directBilirubin' },
    { label: '间接胆红素', prop: 'experimentExamBiochemicalTestsRespVO.indirectBilirubin' },
    { label: '糖化血红蛋白', prop: 'experimentExamBiochemicalTestsRespVO.glycatedHemoglobin' },
    { label: '钾', prop: 'experimentExamBiochemicalTestsRespVO.potassium' },
    { label: '钠', prop: 'experimentExamBiochemicalTestsRespVO.sodium' },
    { label: '氯', prop: 'experimentExamBiochemicalTestsRespVO.chloride' },
    { label: '钙', prop: 'experimentExamBiochemicalTestsRespVO.calcium' },
    { label: '磷', prop: 'experimentExamBiochemicalTestsRespVO.phosphorus' },
    { label: '镁', prop: 'experimentExamBiochemicalTestsRespVO.magnesium' },
    { label: '葡萄糖空腹', prop: 'experimentExamBiochemicalTestsRespVO.fastingGlucose' },
    { label: '凝血酶原时间', prop: 'experimentExamBiochemicalTestsRespVO.prothrombinTime' },
    { label: '凝血酶原活动度', prop: 'experimentExamBiochemicalTestsRespVO.prothrombinActivity' },
    { label: '国际标准化比率', prop: 'experimentExamBiochemicalTestsRespVO.inr' },
    { label: '纤维蛋白原', prop: 'experimentExamBiochemicalTestsRespVO.fibrinogen' },
    { label: '活化部分凝血活酶时间', prop: 'experimentExamBiochemicalTestsRespVO.aptt' },
    { label: '凝血酶时间', prop: 'experimentExamBiochemicalTestsRespVO.thrombinTime' }
  ],
  血常规: [
    { label: '白细胞计数', prop: 'experimentExamBloodRoutineRespVO.wbc' },
    { label: '红细胞计数', prop: 'experimentExamBloodRoutineRespVO.rbc' },
    { label: '血红蛋白浓度', prop: 'experimentExamBloodRoutineRespVO.hemoglobin' },
    { label: '红细胞比容', prop: 'experimentExamBloodRoutineRespVO.hematocrit' },
    { label: '平均红细胞容积', prop: 'experimentExamBloodRoutineRespVO.mcv' },
    { label: '平均红细胞血红蛋白含量', prop: 'experimentExamBloodRoutineRespVO.mch' },
    { label: '平均红细胞血红蛋白浓度', prop: 'experimentExamBloodRoutineRespVO.mchc' },
    { label: 'RBC分布宽度CV值', prop: 'experimentExamBloodRoutineRespVO.rdwCv' },
    { label: 'RBC分布宽度SD值', prop: 'experimentExamBloodRoutineRespVO.rdwSd' },
    { label: '血小板计数', prop: 'experimentExamBloodRoutineRespVO.plateletCount' },
    { label: '血小板比容', prop: 'experimentExamBloodRoutineRespVO.plateletCrit' },
    { label: '平均血小板体积', prop: 'experimentExamBloodRoutineRespVO.mpv' },
    { label: '血小板分布宽度', prop: 'experimentExamBloodRoutineRespVO.pdw' },
    { label: '中性粒细胞计数', prop: 'experimentExamBloodRoutineRespVO.neutrophils' },
    { label: '淋巴细胞计数', prop: 'experimentExamBloodRoutineRespVO.lymphocytes' },
    { label: '单核细胞计数', prop: 'experimentExamBloodRoutineRespVO.monocytes' },
    { label: '嗜酸性粒细胞计数', prop: 'experimentExamBloodRoutineRespVO.eosinophils' },
    { label: '嗜碱性粒细胞计数', prop: 'experimentExamBloodRoutineRespVO.basophils' },
    { label: '中性粒细胞百分率', prop: 'experimentExamBloodRoutineRespVO.neutrophilsPercentage' },
    { label: '淋巴细胞百分率', prop: 'experimentExamBloodRoutineRespVO.lymphocytesPercentage' },
    { label: '单核细胞百分率', prop: 'experimentExamBloodRoutineRespVO.monocytesPercentage' },
    { label: '嗜酸性粒细胞百分率', prop: 'experimentExamBloodRoutineRespVO.eosinophilsPercentage' },
    { label: '嗜碱性粒细胞百分率', prop: 'experimentExamBloodRoutineRespVO.basophilsPercentage' }
  ],
  心电图: [{ label: '心电图描述', prop: 'experimentExamEcgRespVO.ecgDescription' }],
  既往病史: [
    {
      label: '内科既往病史',
      prop: 'experimentExamPastMedicalHistoryRespVO.internalDiseaseHistory'
    },
    { label: '外科既往病史', prop: 'experimentExamPastMedicalHistoryRespVO.externalDiseaseHistory' }
  ]
}

// 对照组流调
export const controlSurveyGroupFields: Record<string, TableField[]> = {
  饮酒情况: [
    { label: '饮酒经历', prop: 'controlSurveyDrinkingInfoRespVO.drinkingExperience' },
    { label: '饮酒频率', prop: 'controlSurveyDrinkingInfoRespVO.drinkingFrequency' }
  ],
  既往疾病: [
    // 疾病1
    { label: '疾病1名称', prop: 'controlSurveyPastDiseasesRespVO.disease1Name' },
    { label: '疾病1是否确诊', prop: 'controlSurveyPastDiseasesRespVO.disease1Diagnosed' },
    { label: '疾病1确诊时间', prop: 'controlSurveyPastDiseasesRespVO.disease1DiagnosisDate' },
    { label: '疾病1是否住院', prop: 'controlSurveyPastDiseasesRespVO.disease1Hospitalized' },
    { label: '疾病1是否治疗', prop: 'controlSurveyPastDiseasesRespVO.disease1Treated' },
    { label: '疾病1治疗效果', prop: 'controlSurveyPastDiseasesRespVO.disease1TreatmentEffect' },

    // 疾病2
    { label: '疾病2名称', prop: 'controlSurveyPastDiseasesRespVO.disease2Name' },
    { label: '疾病2是否确诊', prop: 'controlSurveyPastDiseasesRespVO.disease2Diagnosed' },
    { label: '疾病2确诊时间', prop: 'controlSurveyPastDiseasesRespVO.disease2DiagnosisDate' },
    { label: '疾病2是否住院', prop: 'controlSurveyPastDiseasesRespVO.disease2Hospitalized' },
    { label: '疾病2是否治疗', prop: 'controlSurveyPastDiseasesRespVO.disease2Treated' },
    { label: '疾病2治疗效果', prop: 'controlSurveyPastDiseasesRespVO.disease2TreatmentEffect' },

    // 疾病3
    { label: '疾病3名称', prop: 'controlSurveyPastDiseasesRespVO.disease3Name' },
    { label: '疾病3是否确诊', prop: 'controlSurveyPastDiseasesRespVO.disease3Diagnosed' },
    { label: '疾病3确诊时间', prop: 'controlSurveyPastDiseasesRespVO.disease3DiagnosisDate' },
    { label: '疾病3是否住院', prop: 'controlSurveyPastDiseasesRespVO.disease3Hospitalized' },
    { label: '疾病3是否治疗', prop: 'controlSurveyPastDiseasesRespVO.disease3Treated' },
    { label: '疾病3治疗效果', prop: 'controlSurveyPastDiseasesRespVO.disease3TreatmentEffect' },

    // 疾病4
    { label: '疾病4名称', prop: 'controlSurveyPastDiseasesRespVO.disease4Name' },
    { label: '疾病4是否确诊', prop: 'controlSurveyPastDiseasesRespVO.disease4Diagnosed' },
    { label: '疾病4确诊时间', prop: 'controlSurveyPastDiseasesRespVO.disease4DiagnosisDate' },
    { label: '疾病4是否住院', prop: 'controlSurveyPastDiseasesRespVO.disease4Hospitalized' },
    { label: '疾病4是否治疗', prop: 'controlSurveyPastDiseasesRespVO.disease4Treated' },
    { label: '疾病4治疗效果', prop: 'controlSurveyPastDiseasesRespVO.disease4TreatmentEffect' },

    // 疾病5
    { label: '疾病5名称', prop: 'controlSurveyPastDiseasesRespVO.disease5Name' },
    { label: '疾病5是否确诊', prop: 'controlSurveyPastDiseasesRespVO.disease5Diagnosed' },
    { label: '疾病5确诊时间', prop: 'controlSurveyPastDiseasesRespVO.disease5DiagnosisDate' },
    { label: '疾病5是否住院', prop: 'controlSurveyPastDiseasesRespVO.disease5Hospitalized' },
    { label: '疾病5是否治疗', prop: 'controlSurveyPastDiseasesRespVO.disease5Treated' },
    { label: '疾病5治疗效果', prop: 'controlSurveyPastDiseasesRespVO.disease5TreatmentEffect' },

    // 疾病6
    { label: '疾病6名称', prop: 'controlSurveyPastDiseasesRespVO.disease6Name' },
    { label: '疾病6是否确诊', prop: 'controlSurveyPastDiseasesRespVO.disease6Diagnosed' },
    { label: '疾病6确诊时间', prop: 'controlSurveyPastDiseasesRespVO.disease6DiagnosisDate' },
    { label: '疾病6是否住院', prop: 'controlSurveyPastDiseasesRespVO.disease6Hospitalized' },
    { label: '疾病6是否治疗', prop: 'controlSurveyPastDiseasesRespVO.disease6Treated' },
    { label: '疾病6治疗效果', prop: 'controlSurveyPastDiseasesRespVO.disease6TreatmentEffect' }
  ],
  旅居信息: [
    { label: '高原经历', prop: 'controlSurveyResidenceInfoRespVO.highlandExperience' },
    { label: '长期平原经历', prop: 'controlSurveyResidenceInfoRespVO.longTermPlainExperience' },
    { label: '常住地1', prop: 'controlSurveyResidenceInfoRespVO.residence1' },
    { label: '常住地2', prop: 'controlSurveyResidenceInfoRespVO.residence2' },
    { label: '常住地3', prop: 'controlSurveyResidenceInfoRespVO.residence3' }
  ],
  自我评价: [
    { label: '每年体检/就诊次数', prop: 'controlSurveySelfAssessmentRespVO.annualCheckups' },
    {
      label: '与同龄人相比，您认为目前自己的身体健康状况如何',
      prop: 'controlSurveySelfAssessmentRespVO.healthComparison'
    },
    {
      label: '您认为自己身体健康状况能得________分',
      prop: 'controlSurveySelfAssessmentRespVO.healthScore'
    }
  ],
  吸烟情况: [
    { label: '是否吸烟', prop: 'controlSurveySmokingInfoRespVO.smokingStatus' },
    { label: '烟龄', prop: 'controlSurveySmokingInfoRespVO.smokingYears' },
    { label: '是否尝试戒烟', prop: 'controlSurveySmokingInfoRespVO.triedQuit' },
    { label: '戒烟时间', prop: 'controlSurveySmokingInfoRespVO.quitTime' }
  ],
  疾病谱: [
    { label: '消化系统', prop: 'diseaseSpectrumDigestiveSystemControl' },
    { label: '心血管系统', prop: 'diseaseSpectrumCardiovascularSystemControl' },
    { label: '内分泌系统', prop: 'diseaseSpectrumEndocrineSystemControl' },
    { label: '呼吸系统', prop: 'diseaseSpectrumRespiratorySystemControl' },
    { label: '泌尿系统', prop: 'diseaseSpectrumUrinarySystemControl' },
    { label: '骨骼系统', prop: 'diseaseSpectrumSkeletalSystemControl' },
    { label: '神经系统', prop: 'diseaseSpectrumNervousSystemControl' }
  ],
  framingham评分: [
    { label: 'Framingham评分（分）', prop: 'controlFraminghamRespVO.framinghamScore' },
    { label: 'Framingham概率', prop: 'controlFraminghamRespVO.framinghamRisk' },
    { label: 'Framingham分类', prop: 'controlFraminghamRespVO.framinghamRiskType' }
  ]
}

// 对照组体检
export const controlExamGroupFields: Record<string, TableField[]> = {
  腹部超声: [
    { label: '腹部超声-描述', prop: 'controlExamAbdominalUltrasoundRespVO.ultrasoundDescription' },
    { label: '腹部超声-小结', prop: 'controlExamAbdominalUltrasoundRespVO.ultrasoundSummary' }
  ],
  基本检测信息: [
    { label: '收缩压(mmHg)', prop: 'controlExamBasicTestsRespVO.systolicPressure' },
    { label: '舒张压(mmHg)', prop: 'controlExamBasicTestsRespVO.diastolicPressure' },
    { label: '脉搏(次/分)', prop: 'controlExamBasicTestsRespVO.pulse' },
    { label: '身高(CM)', prop: 'controlExamBasicTestsRespVO.height' },
    { label: '体重(KG)', prop: 'controlExamBasicTestsRespVO.weight' },
    { label: '体重指数(kg/m^2)', prop: 'controlExamBasicTestsRespVO.bmi' }
  ],
  生化: [
    { label: '尿素', prop: 'controlExamBiochemicalTestsRespVO.urea' },
    { label: '肌酐', prop: 'controlExamBiochemicalTestsRespVO.creatinine' },
    { label: '谷丙转氨酶', prop: 'controlExamBiochemicalTestsRespVO.alt' },
    { label: '谷草转氨酶', prop: 'controlExamBiochemicalTestsRespVO.ast' },
    { label: '总胆固醇', prop: 'controlExamBiochemicalTestsRespVO.totalCholesterol' },
    { label: '甘油三酯', prop: 'controlExamBiochemicalTestsRespVO.triglycerides' },
    { label: '高密度脂蛋白胆固醇', prop: 'controlExamBiochemicalTestsRespVO.hdlC' },
    { label: '低密度脂蛋白胆固醇', prop: 'controlExamBiochemicalTestsRespVO.ldlC' },
    { label: '尿酸', prop: 'controlExamBiochemicalTestsRespVO.uricAcid' },
    { label: '总蛋白', prop: 'controlExamBiochemicalTestsRespVO.totalProtein' },
    { label: '白蛋白', prop: 'controlExamBiochemicalTestsRespVO.albumin' },
    { label: '球蛋白', prop: 'controlExamBiochemicalTestsRespVO.globulin' },
    { label: '白球比例', prop: 'controlExamBiochemicalTestsRespVO.albGlobRatio' },
    { label: '总胆红素', prop: 'controlExamBiochemicalTestsRespVO.totalBilirubin' },
    { label: '直接胆红素', prop: 'controlExamBiochemicalTestsRespVO.directBilirubin' },
    { label: '间接胆红素', prop: 'controlExamBiochemicalTestsRespVO.indirectBilirubin' },
    { label: '糖化血红蛋白', prop: 'controlExamBiochemicalTestsRespVO.glycatedHemoglobin' },
    { label: '钾', prop: 'controlExamBiochemicalTestsRespVO.potassium' },
    { label: '钠', prop: 'controlExamBiochemicalTestsRespVO.sodium' },
    { label: '氯', prop: 'controlExamBiochemicalTestsRespVO.chloride' },
    { label: '钙', prop: 'controlExamBiochemicalTestsRespVO.calcium' },
    { label: '磷', prop: 'controlExamBiochemicalTestsRespVO.phosphorus' },
    { label: '镁', prop: 'controlExamBiochemicalTestsRespVO.magnesium' },
    { label: '葡萄糖空腹', prop: 'controlExamBiochemicalTestsRespVO.fastingGlucose' },
    { label: '凝血酶原时间', prop: 'controlExamBiochemicalTestsRespVO.prothrombinTime' },
    { label: '凝血酶原活动度', prop: 'controlExamBiochemicalTestsRespVO.prothrombinActivity' },
    { label: '国际标准化比率', prop: 'controlExamBiochemicalTestsRespVO.inr' },
    { label: '纤维蛋白原', prop: 'controlExamBiochemicalTestsRespVO.fibrinogen' },
    { label: '活化部分凝血活酶时间', prop: 'controlExamBiochemicalTestsRespVO.aptt' },
    { label: '凝血酶时间', prop: 'controlExamBiochemicalTestsRespVO.thrombinTime' }
  ],
  血常规: [
    { label: '白细胞计数', prop: 'controlExamBloodRoutineRespVO.wbc' },
    { label: '红细胞计数', prop: 'controlExamBloodRoutineRespVO.rbc' },
    { label: '血红蛋白浓度', prop: 'controlExamBloodRoutineRespVO.hemoglobin' },
    { label: '红细胞比容', prop: 'controlExamBloodRoutineRespVO.hematocrit' },
    { label: '平均红细胞容积', prop: 'controlExamBloodRoutineRespVO.mcv' },
    { label: '平均红细胞血红蛋白含量', prop: 'controlExamBloodRoutineRespVO.mch' },
    { label: '平均红细胞血红蛋白浓度', prop: 'controlExamBloodRoutineRespVO.mchc' },
    { label: 'RBC分布宽度CV值', prop: 'controlExamBloodRoutineRespVO.rdwCv' },
    { label: 'RBC分布宽度SD值', prop: 'controlExamBloodRoutineRespVO.rdwSd' },
    { label: '血小板计数', prop: 'controlExamBloodRoutineRespVO.plateletCount' },
    { label: '血小板比容', prop: 'controlExamBloodRoutineRespVO.plateletCrit' },
    { label: '平均血小板体积', prop: 'controlExamBloodRoutineRespVO.mpv' },
    { label: '血小板分布宽度', prop: 'controlExamBloodRoutineRespVO.pdw' },
    { label: '中性粒细胞计数', prop: 'controlExamBloodRoutineRespVO.neutrophils' },
    { label: '淋巴细胞计数', prop: 'controlExamBloodRoutineRespVO.lymphocytes' },
    { label: '单核细胞计数', prop: 'controlExamBloodRoutineRespVO.monocytes' },
    { label: '嗜酸性粒细胞计数', prop: 'controlExamBloodRoutineRespVO.eosinophils' },
    { label: '嗜碱性粒细胞计数', prop: 'controlExamBloodRoutineRespVO.basophils' },
    { label: '中性粒细胞百分率', prop: 'controlExamBloodRoutineRespVO.neutrophilsPercentage' },
    { label: '淋巴细胞百分率', prop: 'controlExamBloodRoutineRespVO.lymphocytesPercentage' },
    { label: '单核细胞百分率', prop: 'controlExamBloodRoutineRespVO.monocytesPercentage' },
    { label: '嗜酸性粒细胞百分率', prop: 'controlExamBloodRoutineRespVO.eosinophilsPercentage' },
    { label: '嗜碱性粒细胞百分率', prop: 'controlExamBloodRoutineRespVO.basophilsPercentage' }
  ],
  心电图: [{ label: '心电图描述', prop: 'controlExamEcgRespVO.ecgDescription' }],
  既往病史: [
    { label: '内科既往病史', prop: 'controlExamPastMedicalHistoryRespVO.internalDiseaseHistory' },
    { label: '外科既往病史', prop: 'controlExamPastMedicalHistoryRespVO.externalDiseaseHistory' }
  ]
}

export const fieldTypeMaps = {
  drinkingTypeMap: {
    beer: '啤酒',
    liquor: '白酒',
    redWine: '红酒',
    cocktails: '鸡尾酒',
    spirits: '烈酒',
    otherAlcohol: '其他'
  },
  cardiovascularCirculatorySystemMap: {
    hypertension: '高血压',
    hyperlipidemia: '高血脂',
    congenitalHeartDisease: '先天性心脏病',
    pulmonaryHeartDisease: '肺心病',
    stroke: '中风/脑溢血',
    coronaryHeartDisease: '冠心病/心绞痛',
    myocardialInfarction: '心肌梗塞',
    bradycardia: '窦性心动过缓',
    tachycardia: '窦性心动过速',
    arrhythmia: '窦性心律不齐',
    atrialFibrillation: '房颤',
    paroxysmalAuricularTachycardia: '阵发性室上速',
    frequentPrematureAtrialContractions: '频发房性早搏',
    frequentPrematureVentricularContractions: '频发室性早搏',
    avBlock: '房室传导阻滞',
    ventricularTachycardia: '室性心动过速',
    otherDiseases1: '其他'
  },
  respiratorySystemMap: {
    chronicBronchitis: '慢性支气管炎',
    asthma: '哮喘',
    tuberculosis: '肺结核',
    emphysema: '肺气肿',
    pneumonia: '肺炎',
    copd: '慢性阻塞性肺疾病',
    otherDiseases2: '其他'
  },
  metabolicSystemMap: {
    thyroidDisease: '甲状腺疾病',
    diabetes: '糖尿病',
    gout: '高尿酸血症（痛风）'
  },
  digestiveSystemMap: {
    chronicGastroenteritis: '慢性肠胃炎',
    duodenalUlcer: '十二指肠溃疡',
    gastricUlcer: '胃溃疡',
    gallstones: '胆结石',
    colonPolyps: '结肠息肉',
    hepatitisB: '乙型肝炎',
    cholecystitis: '胆囊炎',
    otherDiseases3: '其他'
  },
  nervousSystemMap: {
    dementia: '老年痴呆',
    parkinsonsDisease: '帕金森综合征',
    multipleSclerosis: '多发性硬化病',
    epilepsy: '癫痫'
  },
  cancerMap: {
    lungCancer: '肺癌',
    liverCancer: '肝癌',
    gastricCancer: '胃癌',
    colonCancer: '直/结肠癌',
    pancreaticCancer: '胰腺癌',
    esophagealCancer: '食管癌',
    prostateCancer: '前列腺癌',
    breastCancer: '乳腺癌',
    cervicalCancer: '宫颈癌',
    otherDiseases4: '其他'
  },
  highlandDiseasesMap: {
    acuteHighlandReaction: '急性高原反应',
    highlandPulmonaryEdema: '高原肺水肿',
    highlandCerebralEdema: '高原脑水肿',
    highlandHeartDisease: '高原心脏病',
    highlandPolycythemia: '高原红细胞增多症',
    otherDiseases: '其他'
  },
  highlandReactionSymptomsMap: {
    headache: '头痛',
    vomiting: '呕吐',
    dizziness: '头昏',
    nausea: '恶心',
    palpitations: '心慌',
    poorAppetite: '食欲不振',
    chestTightness: '胸闷',
    blurredVision: '眼花',
    shortnessOfBreath: '气短',
    abdominalBloating: '腹胀',
    diarrhea: '腹泻'
  },
  residenceAreaMap: {
    chengdu: '成都',
    kunming: '昆明',
    xining: '西宁',
    otherArea: '其他'
  },
  highlandDiseasesDuringServiceMap: {
    hypertension: '高血压',
    myocardialInfarction: '心肌梗死',
    coronaryHeartDisease: '冠心病',
    pulmonaryHeartDisease: '肺心病',
    lowerExtremityVenousThrombosis: '四肢静脉血栓',
    bradycardia: '窦性心动过缓',
    tachycardia: '窦性心动过速',
    arrhythmia: '窦性心律不齐',
    atrialFibrillation: '房颤',
    paroxysmalAuricularTachycardia: '阵发性室上速',
    frequentPrematureAtrialContractions: '频发房性早搏',
    frequentPrematureVentricularContractions: '频发室性早搏',
    avBlock: '房室传导阻滞',
    ventricularTachycardia: '室性心动过速',
    otherDiseases1: '其他',
    dizziness: '眩晕',
    transientIschemicAttack: '短暂性脑缺血',
    cerebralInfarction: '脑梗死/脑血栓',
    cerebralHemorrhage: '脑出血',
    otherDiseases2: '其他',
    hyperlipidemia: '高血脂',
    diabetes: '糖尿病',
    gout: '高尿酸血症（痛风）',
    thyroidDisease: '甲状腺疾病',
    otherDiseases3: '其他',
    insomnia: '失眠',
    tumor: '肿瘤',
    otherDiseases4: '其他'
  },
  newDiseasesPostReturnMap: {
    hypertension: '高血压',
    myocardialInfarction: '心肌梗死',
    coronaryHeartDisease: '冠心病',
    pulmonaryHeartDisease: '肺心病',
    lowerExtremityVenousThrombosis: '四肢静脉血栓',
    bradycardia: '窦性心动过缓',
    tachycardia: '窦性心动过速',
    arrhythmia: '窦性心律不齐',
    atrialFibrillation: '房颤',
    paroxysmalAuricularTachycardia: '阵发性室上速',
    frequentPrematureAtrialContractions: '频发房性早搏',
    frequentPrematureVentricularContractions: '频发室性早搏',
    avBlock: '房室传导阻滞',
    ventricularTachycardia: '室性心动过速',
    otherDiseases1: '其他',
    dizziness: '眩晕',
    transientIschemicAttack: '短暂性脑缺血',
    cerebralInfarction: '脑梗死/脑血栓',
    cerebralHemorrhage: '脑出血',
    otherDiseases2: '其他',
    hyperlipidemia: '高血脂',
    diabetes: '糖尿病',
    gout: '高尿酸血症（痛风）',
    thyroidDisease: '甲状腺疾病',
    otherDiseases3: '其他',
    insomnia: '失眠',
    tumor: '肿瘤',
    otherDiseases4: '其他'
  },
  dietTypeMap: {
    // eatingHabits: '饮食习惯',
    drinkingWater: '饮用水',
    tea: '茶水',
    fruitJuice: '果汁',
    carbonatedDrinks: '碳酸饮料',
    coffee: '咖啡',
    milk: '牛奶'
  },
  reasonsAffectingSleepMap: {
    sleepDifficulties: '入睡困难',
    nightAwakening: '夜间易醒或早醒',
    nightUrination: '夜间去厕所',
    breathingDifficulties: '呼吸不畅',
    coughOrSnore: '咳嗽或鼾声高',
    feelingCold: '感觉冷',
    feelingHot: '感觉热',
    nightmares: '做恶梦',
    painOrDiscomfort: '疼痛不适',
    otherSleepIssues: '其他影响睡眠的事情',
    sleepAids: '催眠药'
  },
  diseaseSpectrumDigestiveSystemMap: {
    fattyLiver: '脂肪肝',
    hepaticCyst: '肝囊肿',
    gallbladderPolyp: '胆囊息肉',
    gallbladderStone: '胆囊结石',
    hepaticHemangioma: '肝血管瘤',
    splenomegaly: '脾大',
    chronicGastritis: '慢性胃炎',
    intestinalPolyp: '肠息肉',
    appendicitis: '阑尾炎',
    acutePancreatitis: '急性胰腺炎',
    digestiveUlcer: '消化道溃疡',
    digestiveBleeding: '消化道出血'
  },
  diseaseSpectrumCardiovascularSystemMap: {
    hypertension: '高血压',
    bradycardia: '窦性心动过缓',
    transientIschemicAttack: '短暂性脑缺血',
    tachycardia: '窦性心动过速',
    cerebralInfarction: '脑梗死/脑血栓',
    frequentPrematureAtrialContractions: '频发房性早搏',
    frequentPrematureVentricularContractions: '频发室性早搏',
    coronaryHeartDisease: '冠心病',
    atrialFibrillation: '房颤',
    myocardialInfarction: '心肌梗死'
  },
  diseaseSpectrumEndocrineSystemMap: {
    hypertriglyceridemia: '高甘油三酯血症',
    highLdl: '低密度脂蛋白胆固醇增多症',
    highHdl: '高密度脂蛋白胆固醇增多症',
    hyperuricemia: '高尿酸血症',
    hypercholesterolemia: '高胆固醇血症',
    diabetes: '糖尿病',
    thyroidDisease: '甲状腺疾病'
  },
  diseaseSpectrumRespiratorySystemMap: {
    lungNodule: '肺结节',
    pulmonaryEmphysema: '肺气肿',
    copd: '慢阻肺',
    asthma: '哮喘'
  },
  diseaseSpectrumUrinarySystemMap: {
    kidneyStone: '肾结石',
    renalCyst: '肾囊肿',
    prostatitis: '前列腺炎'
  },
  diseaseSpectrumSkeletalSystemMap: {
    lumbarSpondylosis: '腰椎病',
    cervicalSpondylosis: '颈椎病'
  },
  diseaseSpectrumNervousSystemMap: {
    insomnia: '失眠'
  }
}
