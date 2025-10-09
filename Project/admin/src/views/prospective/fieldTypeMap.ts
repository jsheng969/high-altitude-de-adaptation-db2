interface TableField {
  label: string
  prop: string
}

// 基础信息
export const basicInfoFields: TableField[] = [
  { label: '超声', prop: 'code' },
  { label: '肺功能', prop: 'name' },
  { label: '人体成分', prop: 'actualAge' },
  { label: '认知', prop: 'gender' },
  { label: '神经外科', prop: 'birthDate' },
  { label: '心电', prop: 'position' },
  { label: '血液', prop: 'idNumber' },
  { label: '眼科', prop: 'basicOtherInfoRespVO.maritalStatus' },
  { label: '血栓弹力图', prop: 'basicOtherInfoRespVO.height' },
  { label: '体重', prop: 'basicOtherInfoRespVO.weight' },
  { label: '民族', prop: 'basicOtherInfoRespVO.ethnicity' },
  { label: '最高学历', prop: 'basicOtherInfoRespVO.educationLevel' },
  { label: '生育情况', prop: 'basicOtherInfoRespVO.fertilityStatus' }
]

// 实验组流调
export const experimentSurveyGroupFields: Record<string, TableField[]> = {
  驻训信息: [
    {
      label: '任务点海拔(m)',
      prop: 'experimentSurveyStationTrainingInfoRespVO.missionPointAltitude'
    },
    { label: '驻训地点', prop: 'experimentSurveyStationTrainingInfoRespVO.location' },
    {
      label: '高原驻训次数',
      prop: 'experimentSurveyStationTrainingInfoRespVO.plateauTrainingCount'
    },
    {
      label: '驻训总时长(月)',
      prop: 'experimentSurveyStationTrainingInfoRespVO.plateauTrainingDuration'
    },
    { label: '任务类型', prop: 'experimentSurveyStationTrainingInfoRespVO.missionType' },
    { label: '每日工作时长(h)', prop: 'experimentSurveyStationTrainingInfoRespVO.dailyWorkHours' },
    { label: '服役期间职务', prop: 'experimentSurveyStationTrainingInfoRespVO.servicePosition' }
  ],
  吸烟信息: [
    { label: '吸烟情况', prop: 'experimentSurveySmokingInfoRespVO.smokingStatus' },
    { label: '每日吸烟量', prop: 'experimentSurveySmokingInfoRespVO.dailyCigarettes' },
    { label: '开始吸烟年龄', prop: 'experimentSurveySmokingInfoRespVO.smokingStartAge' },
    { label: '烟龄', prop: 'experimentSurveySmokingInfoRespVO.smokingYears' },
    { label: '是否尝试过戒烟', prop: 'experimentSurveySmokingInfoRespVO.quitAttempted' },
    { label: '吸烟地区', prop: 'experimentSurveySmokingInfoRespVO.smokingRegion' },
    { label: '戒烟前烟龄', prop: 'experimentSurveySmokingInfoRespVO.quitSmokingYears' },
    { label: '已戒烟时长', prop: 'experimentSurveySmokingInfoRespVO.quitSmokingDuration' },
    { label: '戒烟前吸烟地区', prop: 'experimentSurveySmokingInfoRespVO.quitSmokingRegion' }
  ],
  自我评价: [
    {
      label: '健康状况对比评价',
      prop: 'experimentSurveySelfAssessmentRespVO.healthComparisonWithPeers'
    },
    { label: '健康自评分数', prop: 'experimentSurveySelfAssessmentRespVO.healthScore' }
  ],
  评分总数统计: [
    { label: '评分类型', prop: 'totalScoreType' },
    { label: '评分总数', prop: 'experimentSurveyScoreSummaryRespVO.totalScore' },
    { label: '转归类型', prop: 'conversionType' },
    { label: '第二时相点评分', prop: 'experimentSurveyScoreSummaryRespVO.totalScore2' }
  ],
  退役后返回平原症状: [
    { label: '疲倦', prop: 'experimentSurveyPostReturnSymptomsRespVO.fatigue' },
    { label: '疲倦持续时间', prop: 'experimentSurveyPostReturnSymptomsRespVO.fatigueDuration' },
    { label: '乏力', prop: 'experimentSurveyPostReturnSymptomsRespVO.weakness' },
    { label: '乏力持续时间', prop: 'experimentSurveyPostReturnSymptomsRespVO.weaknessDuration' },
    { label: '嗜睡', prop: 'experimentSurveyPostReturnSymptomsRespVO.drowsiness' },
    { label: '嗜睡持续时间', prop: 'experimentSurveyPostReturnSymptomsRespVO.drowsinessDuration' },
    { label: '头昏', prop: 'experimentSurveyPostReturnSymptomsRespVO.dizziness' },
    { label: '头昏持续时间', prop: 'experimentSurveyPostReturnSymptomsRespVO.dizzinessDuration' },
    { label: '眩晕', prop: 'experimentSurveyPostReturnSymptomsRespVO.vertigo' },
    { label: '眩晕持续时间', prop: 'experimentSurveyPostReturnSymptomsRespVO.vertigoDuration' },
    { label: '精力不集中', prop: 'experimentSurveyPostReturnSymptomsRespVO.poorConcentration' },
    {
      label: '精力不集中持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.poorConcentrationDuration'
    },
    { label: '反应迟钝', prop: 'experimentSurveyPostReturnSymptomsRespVO.slowReaction' },
    {
      label: '反应迟钝持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.slowReactionDuration'
    },
    { label: '记忆减退', prop: 'experimentSurveyPostReturnSymptomsRespVO.memoryLoss' },
    {
      label: '记忆减退持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.memoryLossDuration'
    },
    { label: '失眠', prop: 'experimentSurveyPostReturnSymptomsRespVO.insomnia' },
    { label: '失眠持续时间', prop: 'experimentSurveyPostReturnSymptomsRespVO.insomniaDuration' },
    { label: '多梦', prop: 'experimentSurveyPostReturnSymptomsRespVO.nightmares' },
    { label: '多梦持续时间', prop: 'experimentSurveyPostReturnSymptomsRespVO.nightmaresDuration' },
    { label: '咽喉痛', prop: 'experimentSurveyPostReturnSymptomsRespVO.soreThroat' },
    {
      label: '咽喉痛持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.soreThroatDuration'
    },
    { label: '咳嗽', prop: 'experimentSurveyPostReturnSymptomsRespVO.cough' },
    { label: '咳嗽持续时间', prop: 'experimentSurveyPostReturnSymptomsRespVO.coughDuration' },
    { label: '多痰', prop: 'experimentSurveyPostReturnSymptomsRespVO.phlegm' },
    { label: '多痰持续时间', prop: 'experimentSurveyPostReturnSymptomsRespVO.phlegmDuration' },
    { label: '气喘', prop: 'experimentSurveyPostReturnSymptomsRespVO.wheezing' },
    { label: '气喘持续时间', prop: 'experimentSurveyPostReturnSymptomsRespVO.wheezingDuration' },
    { label: '胸闷', prop: 'experimentSurveyPostReturnSymptomsRespVO.chestTightness' },
    {
      label: '胸闷持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.chestTightnessDuration'
    },
    { label: '心前区痛', prop: 'experimentSurveyPostReturnSymptomsRespVO.chestPain' },
    {
      label: '心前区痛持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.chestPainDuration'
    },
    { label: '心慌', prop: 'experimentSurveyPostReturnSymptomsRespVO.palpitations' },
    {
      label: '心慌持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.palpitationsDuration'
    },
    { label: '脉率减慢', prop: 'experimentSurveyPostReturnSymptomsRespVO.bradycardia' },
    {
      label: '脉率减慢持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.bradycardiaDuration'
    },
    { label: '紫绀', prop: 'experimentSurveyPostReturnSymptomsRespVO.cyanosis' },
    { label: '紫绀持续时间', prop: 'experimentSurveyPostReturnSymptomsRespVO.cyanosisDuration' },
    {
      label: '血压波动',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.bloodPressureFluctuation'
    },
    {
      label: '血压波动持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.bloodPressureFluctuationDuration'
    },
    { label: '皮肤出血', prop: 'experimentSurveyPostReturnSymptomsRespVO.skinBleeding' },
    {
      label: '皮肤出血持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.skinBleedingDuration'
    },
    { label: '皮肤瘀斑', prop: 'experimentSurveyPostReturnSymptomsRespVO.skinBruising' },
    {
      label: '皮肤瘀斑持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.skinBruisingDuration'
    },
    { label: '贫血', prop: 'experimentSurveyPostReturnSymptomsRespVO.anemia' },
    { label: '贫血持续时间', prop: 'experimentSurveyPostReturnSymptomsRespVO.anemiaDuration' },
    { label: '体重减轻', prop: 'experimentSurveyPostReturnSymptomsRespVO.weightLoss' },
    {
      label: '体重减轻持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.weightLossDuration'
    },
    { label: '食欲增加', prop: 'experimentSurveyPostReturnSymptomsRespVO.increasedAppetite' },
    {
      label: '食欲增加持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.increasedAppetiteDuration'
    },
    { label: '厌食', prop: 'experimentSurveyPostReturnSymptomsRespVO.anorexia' },
    { label: '厌食持续时间', prop: 'experimentSurveyPostReturnSymptomsRespVO.anorexiaDuration' },
    { label: '便秘', prop: 'experimentSurveyPostReturnSymptomsRespVO.constipation' },
    {
      label: '便秘持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.constipationDuration'
    },
    { label: '腹泻', prop: 'experimentSurveyPostReturnSymptomsRespVO.diarrhea' },
    { label: '腹泻持续时间', prop: 'experimentSurveyPostReturnSymptomsRespVO.diarrheaDuration' },
    { label: '腹痛', prop: 'experimentSurveyPostReturnSymptomsRespVO.abdominalPain' },
    {
      label: '腹痛持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.abdominalPainDuration'
    },
    { label: '腹胀', prop: 'experimentSurveyPostReturnSymptomsRespVO.abdominalDistension' },
    {
      label: '腹胀持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.abdominalDistensionDuration'
    },
    { label: '黄疸', prop: 'experimentSurveyPostReturnSymptomsRespVO.jaundice' },
    { label: '黄疸持续时间', prop: 'experimentSurveyPostReturnSymptomsRespVO.jaundiceDuration' },
    { label: '手足麻木', prop: 'experimentSurveyPostReturnSymptomsRespVO.numbness' },
    {
      label: '手足麻木持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.numbnessDuration'
    },
    { label: '肢体水肿', prop: 'experimentSurveyPostReturnSymptomsRespVO.limbEdema' },
    {
      label: '肢体水肿持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.limbEdemaDuration'
    },
    { label: '面部水肿', prop: 'experimentSurveyPostReturnSymptomsRespVO.facialEdema' },
    {
      label: '面部水肿持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.facialEdemaDuration'
    },
    { label: '脱发', prop: 'experimentSurveyPostReturnSymptomsRespVO.hairLoss' },
    { label: '脱发持续时间', prop: 'experimentSurveyPostReturnSymptomsRespVO.hairLossDuration' },
    { label: '夜尿增多', prop: 'experimentSurveyPostReturnSymptomsRespVO.increasedUrination' },
    {
      label: '夜尿增多持续时间',
      prop: 'experimentSurveyPostReturnSymptomsRespVO.increasedUrinationDuration'
    },
    { label: '返回后有无其他症状', prop: 'experimentSurveyPostReturnSymptomsRespVO.otherSymptoms' }
  ],
  高原体能信息: [
    {
      label: '是否有规律的体能训练',
      prop: 'experimentSurveyPlateauFitnessInfoRespVO.hasRegularTraining'
    },
    { label: '体能训练频率', prop: 'experimentSurveyPlateauFitnessInfoRespVO.trainingFrequency' },
    { label: '每次锻炼时长', prop: 'experimentSurveyPlateauFitnessInfoRespVO.trainingDuration' },
    { label: '体能训练类型', prop: 'experimentSurveyPlateauFitnessInfoRespVO.trainingType' },
    {
      label: '训练时是否胸闷气促',
      prop: 'experimentSurveyPlateauFitnessInfoRespVO.hasChestDiscomfort'
    },
    {
      label: '适应后症状是否缓解',
      prop: 'experimentSurveyPlateauFitnessInfoRespVO.symptomReliefAfterAdaptation'
    },
    { label: '是否存在失眠', prop: 'experimentSurveyPlateauFitnessInfoRespVO.hasInsomnia' },
    { label: '日均睡眠小时数', prop: 'experimentSurveyPlateauFitnessInfoRespVO.dailySleepHours' },
    { label: '失眠是否改善', prop: 'experimentSurveyPlateauFitnessInfoRespVO.insomniaImprovement' },
    { label: '饮食情况及习惯', prop: 'experimentSurveyPlateauFitnessInfoRespVO.dietHabits' }
  ],
  抵达高原后症状记录: [
    { label: '头痛', prop: 'experimentSurveyPlateauArrivalSymptomsRespVO.headache' },
    {
      label: '头痛持续时间',
      prop: 'experimentSurveyPlateauArrivalSymptomsRespVO.headacheDuration'
    },
    { label: '消化道症状', prop: 'experimentSurveyPlateauArrivalSymptomsRespVO.digestiveSymptoms' },
    {
      label: '消化道症状持续时间',
      prop: 'experimentSurveyPlateauArrivalSymptomsRespVO.digestiveSymptomsDuration'
    },
    { label: '疲惫和/或乏力', prop: 'experimentSurveyPlateauArrivalSymptomsRespVO.fatigue' },
    {
      label: '疲惫乏力持续时间',
      prop: 'experimentSurveyPlateauArrivalSymptomsRespVO.fatigueDuration'
    },
    { label: '头晕', prop: 'experimentSurveyPlateauArrivalSymptomsRespVO.dizziness' },
    {
      label: '头晕持续时间',
      prop: 'experimentSurveyPlateauArrivalSymptomsRespVO.dizzinessDuration'
    },
    {
      label: '相关症状如何影响您的日常工作及生活',
      prop: 'experimentSurveyPlateauArrivalSymptomsRespVO.impactOnDailyLife'
    }
  ],
  推进情况调查: [
    { label: '交通方式', prop: 'experimentSurveyMissionProgressSurveyRespVO.transportationMode' },
    {
      label: '任务点海拔',
      prop: 'experimentSurveyMissionProgressSurveyRespVO.missionPointAltitude'
    },
    { label: '地点', prop: 'experimentSurveyMissionProgressSurveyRespVO.location' },
    { label: '抵达任务地点日期', prop: 'experimentSurveyMissionProgressSurveyRespVO.arrivalDate' },
    {
      label: '高原任务持续时间',
      prop: 'experimentSurveyMissionProgressSurveyRespVO.plateauMissionDuration'
    },
    {
      label: '推进途中耗费时间',
      prop: 'experimentSurveyMissionProgressSurveyRespVO.travelDuration'
    },
    { label: '途中经停', prop: 'experimentSurveyMissionProgressSurveyRespVO.hasStopover' },
    { label: '经停地点', prop: 'experimentSurveyMissionProgressSurveyRespVO.stopoverLocation' },
    { label: '经停时间', prop: 'experimentSurveyMissionProgressSurveyRespVO.stopoverDuration' },
    {
      label: '抵达任务地后有无不适',
      prop: 'experimentSurveyMissionProgressSurveyRespVO.hasDiscomfortAfterArrival'
    },
    {
      label: '不适发生时间（抵达后）',
      prop: 'experimentSurveyMissionProgressSurveyRespVO.discomfortOccurrenceTime'
    },
    { label: '返回目的', prop: 'experimentSurveyMissionProgressSurveyRespVO.returnPurpose' }
  ],
  既往疾病史: [
    { label: '既往是否患有下列疾病', prop: 'experimentSurveyMedicalHistoryRespVO.description' }
  ],
  抵达高原后有无新下疾病: [
    { label: '疾病名称', prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.diseases' },
    { label: '高血压', prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.hypertension' },
    {
      label: '心肌梗死',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.myocardialInfarction'
    },
    {
      label: '冠心病',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.coronaryHeartDisease'
    },
    {
      label: '肺心病',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.pulmonaryHeartDisease'
    },
    {
      label: '四肢静脉血栓',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.lowerExtremityVenousThrombosis'
    },
    {
      label: '窦性心动过缓',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.bradycardia'
    },
    {
      label: '窦性心动过速',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.tachycardia'
    },
    {
      label: '窦性心律不齐',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.arrhythmia'
    },
    {
      label: '房颤',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.atrialFibrillation'
    },
    {
      label: '阵发性室上速',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.paroxysmalAuricularTachycardia'
    },
    {
      label: '频发房性早搏',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.frequentPrematureAtrialContractions'
    },
    {
      label: '频发室性早搏',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.frequentPrematureVentricularContractions'
    },
    { label: '房室传导阻滞', prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.avBlock' },
    {
      label: '室性心动过速',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.ventricularTachycardia'
    },
    {
      label: '其他(心血管疾病)',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.otherDiseases11'
    },
    { label: '眩晕', prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.dizziness' },
    {
      label: '短暂性脑缺血',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.transientIschemicAttack'
    },
    {
      label: '脑梗死/脑血栓',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.cerebralInfarction'
    },
    {
      label: '脑出血',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.cerebralHemorrhage'
    },
    {
      label: '其他(脑血管疾病)',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.otherDiseases12'
    },
    { label: '高血脂', prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.hyperlipidemia' },
    { label: '糖尿病', prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.diabetes' },
    { label: '高尿酸血症(痛风)', prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.gout' },
    {
      label: '甲状腺疾病',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.thyroidDisease'
    },
    {
      label: '其他(代谢内分泌疾病)',
      prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.otherDiseases13'
    },
    { label: '失眠', prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.insomnia' },
    { label: '肿瘤', prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.tumor' },
    { label: '其他', prop: 'experimentSurveyHighlandDiseasesDuringServiceRespVO.otherDiseases14' }
  ],
  基本检测信息: [
    { label: '收缩压', prop: 'experimentSurveyBasicCheckInfoRespVO.systolicBloodPressure' },
    { label: '舒张压', prop: 'experimentSurveyBasicCheckInfoRespVO.diastolicBloodPressure' },
    { label: '氧饱和度', prop: 'experimentSurveyBasicCheckInfoRespVO.oxygenSaturation' },
    { label: '心率', prop: 'experimentSurveyBasicCheckInfoRespVO.heartRate' },
    { label: '基本身高', prop: 'experimentSurveyBasicCheckInfoRespVO.basicHeight' },
    { label: '基本体重', prop: 'experimentSurveyBasicCheckInfoRespVO.basicWeight' },
    { label: '调查身高', prop: 'experimentSurveyBasicCheckInfoRespVO.surveyHeight' },
    { label: '调查体重', prop: 'experimentSurveyBasicCheckInfoRespVO.surveyWeight' }
  ],
  高原急性高山病记录: [
    {
      label: '急性高原反应',
      prop: 'experimentSurveyAcuteMountainSicknessRecordsRespVO.acuteMountainReaction'
    },
    { label: '肺水肿', prop: 'experimentSurveyAcuteMountainSicknessRecordsRespVO.pulmonaryEdema' },
    { label: '脑水肿', prop: 'experimentSurveyAcuteMountainSicknessRecordsRespVO.cerebralEdema' },
    {
      label: '高原心脏病',
      prop: 'experimentSurveyAcuteMountainSicknessRecordsRespVO.highAltitudeHeartDisease'
    },
    {
      label: '高原红细胞增多症',
      prop: 'experimentSurveyAcuteMountainSicknessRecordsRespVO.polycythemia'
    },
    {
      label: '高原期间有无发生以下疾病',
      prop: 'experimentSurveyAcuteMountainSicknessRecordsRespVO.otherDiseases'
    },
    {
      label: '其他疾病描述',
      prop: 'experimentSurveyAcuteMountainSicknessRecordsRespVO.otherDiseasesDesc'
    }
  ]
}

// 实验组体检
export const experimentExamGroupFields: Record<string, TableField[]> = {
  生化: [
    { label: '谷丙转氨酶', prop: 'experimentExamBiochemicalTestsV2RespVO.alt' },
    { label: '谷草转氨酶', prop: 'experimentExamBiochemicalTestsV2RespVO.ast' },
    {
      label: '谷草转氨酶与谷丙转氨酶比值',
      prop: 'experimentExamBiochemicalTestsV2RespVO.astAltRatio'
    },
    { label: '总蛋白', prop: 'experimentExamBiochemicalTestsV2RespVO.totalProtein' },
    { label: '白蛋白', prop: 'experimentExamBiochemicalTestsV2RespVO.albumin' },
    { label: '球蛋白', prop: 'experimentExamBiochemicalTestsV2RespVO.globulin' },
    { label: '白球比', prop: 'experimentExamBiochemicalTestsV2RespVO.albGlobRatio' },
    { label: '总胆红素', prop: 'experimentExamBiochemicalTestsV2RespVO.totalBilirubin' },
    { label: '直接胆红素', prop: 'experimentExamBiochemicalTestsV2RespVO.directBilirubin' },
    { label: '间接胆红素', prop: 'experimentExamBiochemicalTestsV2RespVO.indirectBilirubin' },
    { label: '碱性磷酸酶', prop: 'experimentExamBiochemicalTestsV2RespVO.alkalinePhosphatase' },
    { label: '谷氨酰转肽酶', prop: 'experimentExamBiochemicalTestsV2RespVO.ggt' },
    { label: '总胆汁酸', prop: 'experimentExamBiochemicalTestsV2RespVO.totalBileAcid' },
    { label: '胆碱酯酶', prop: 'experimentExamBiochemicalTestsV2RespVO.cholinesterase' },
    { label: '前白蛋白', prop: 'experimentExamBiochemicalTestsV2RespVO.prealbumin' },
    { label: '尿素', prop: 'experimentExamBiochemicalTestsV2RespVO.urea' },
    { label: '肌酐', prop: 'experimentExamBiochemicalTestsV2RespVO.creatinine' },
    { label: '尿酸', prop: 'experimentExamBiochemicalTestsV2RespVO.uricAcid' },
    { label: '甘油三酯', prop: 'experimentExamBiochemicalTestsV2RespVO.triglycerides' },
    { label: '胆固醇', prop: 'experimentExamBiochemicalTestsV2RespVO.cholesterol' },
    { label: '高密度脂蛋白', prop: 'experimentExamBiochemicalTestsV2RespVO.hdlC' },
    { label: '低密度脂蛋白', prop: 'experimentExamBiochemicalTestsV2RespVO.ldlC' },
    { label: '载脂蛋白A', prop: 'experimentExamBiochemicalTestsV2RespVO.apoa' },
    { label: '载脂蛋白B', prop: 'experimentExamBiochemicalTestsV2RespVO.apob' },
    { label: '脂蛋白a', prop: 'experimentExamBiochemicalTestsV2RespVO.lpa' },
    { label: '葡萄糖', prop: 'experimentExamBiochemicalTestsV2RespVO.glucose' },
    { label: '肌酸激酶', prop: 'experimentExamBiochemicalTestsV2RespVO.ck' },
    { label: '肌酸激酶同工酶MB', prop: 'experimentExamBiochemicalTestsV2RespVO.ckMb' },
    { label: 'α-羟丁酸脱氢酶', prop: 'experimentExamBiochemicalTestsV2RespVO.alphaHbdh' },
    { label: '乳酸脱氢酶', prop: 'experimentExamBiochemicalTestsV2RespVO.ldh' },
    { label: 'C-反应蛋白', prop: 'experimentExamBiochemicalTestsV2RespVO.crp' },
    { label: '免疫球蛋白G', prop: 'experimentExamBiochemicalTestsV2RespVO.igg' },
    { label: '免疫球蛋白A', prop: 'experimentExamBiochemicalTestsV2RespVO.iga' },
    { label: '免疫球蛋白M', prop: 'experimentExamBiochemicalTestsV2RespVO.igm' },
    { label: '补体3', prop: 'experimentExamBiochemicalTestsV2RespVO.complement3' },
    { label: '补体4', prop: 'experimentExamBiochemicalTestsV2RespVO.complement4' },
    { label: '肌红蛋白', prop: 'experimentExamBiochemicalTestsV2RespVO.myoglobin' },
    { label: '小而密低密度脂蛋白', prop: 'experimentExamBiochemicalTestsV2RespVO.smallDenseLdl' },
    { label: '同型半胱氨酸', prop: 'experimentExamBiochemicalTestsV2RespVO.homocysteine' },
    { label: '5-核苷酸酶', prop: 'experimentExamBiochemicalTestsV2RespVO.nucleotidase' },
    { label: '腺苷脱氨酶', prop: 'experimentExamBiochemicalTestsV2RespVO.ada' },
    { label: '淀粉酶', prop: 'experimentExamBiochemicalTestsV2RespVO.amylase' },
    { label: '阴离子间隙', prop: 'experimentExamBiochemicalTestsV2RespVO.anionGap' },
    { label: '缓冲碱', prop: 'experimentExamBiochemicalTestsV2RespVO.bufferBase' },
    { label: '碳酸氢盐', prop: 'experimentExamBiochemicalTestsV2RespVO.bicarbonate' },
    { label: '碱剩余', prop: 'experimentExamBiochemicalTestsV2RespVO.baseExcess' },
    { label: '细胞外液碱剩余', prop: 'experimentExamBiochemicalTestsV2RespVO.extracellularBe' },
    { label: '血尿素', prop: 'experimentExamBiochemicalTestsV2RespVO.bloodUrea' },
    { label: '血尿素氮', prop: 'experimentExamBiochemicalTestsV2RespVO.bun' },
    { label: '钙', prop: 'experimentExamBiochemicalTestsV2RespVO.calcium' },
    { label: '氯', prop: 'experimentExamBiochemicalTestsV2RespVO.chloride' },
    { label: '胱抑素C', prop: 'experimentExamBiochemicalTestsV2RespVO.cystatinC' },
    { label: '铁', prop: 'experimentExamBiochemicalTestsV2RespVO.iron' },
    { label: '实际碳酸氢盐', prop: 'experimentExamBiochemicalTestsV2RespVO.actualBicarbonate' },
    { label: '标准碳酸氢盐', prop: 'experimentExamBiochemicalTestsV2RespVO.standardBicarbonate' },
    { label: '钾', prop: 'experimentExamBiochemicalTestsV2RespVO.potassium' },
    { label: '镁', prop: 'experimentExamBiochemicalTestsV2RespVO.magnesium' },
    { label: '钠', prop: 'experimentExamBiochemicalTestsV2RespVO.sodium' },
    { label: '磷', prop: 'experimentExamBiochemicalTestsV2RespVO.phosphorus' },
    { label: '二氧化碳分压', prop: 'experimentExamBiochemicalTestsV2RespVO.pco2' },
    { label: '酸碱度', prop: 'experimentExamBiochemicalTestsV2RespVO.ph' },
    { label: '氧分压', prop: 'experimentExamBiochemicalTestsV2RespVO.po2' },
    { label: '视黄醇结合蛋白', prop: 'experimentExamBiochemicalTestsV2RespVO.rbp' },
    { label: '肾素活性', prop: 'experimentExamBiochemicalTestsV2RespVO.reninActivity' },
    {
      label: '氢离子浓度',
      prop: 'experimentExamBiochemicalTestsV2RespVO.hydrogenIonConcentration'
    },
    { label: '二氧化碳总量', prop: 'experimentExamBiochemicalTestsV2RespVO.tco2' },
    { label: '乳酸', prop: 'experimentExamBiochemicalTestsV2RespVO.lacticAcid' },
    { label: '微量白蛋白', prop: 'experimentExamBiochemicalTestsV2RespVO.microalbumin' },
    { label: '血浆渗透压', prop: 'experimentExamBiochemicalTestsV2RespVO.plasmaOsmoticPressure' },
    { label: '肺泡-动脉血氧分压差', prop: 'experimentExamBiochemicalTestsV2RespVO.aAGradient' },
    { label: '动脉-肺泡氧分压比值', prop: 'experimentExamBiochemicalTestsV2RespVO.aARatio' },
    { label: '氧合指数', prop: 'experimentExamBiochemicalTestsV2RespVO.oxygenationIndex' },
    { label: '估计血氧饱和度', prop: 'experimentExamBiochemicalTestsV2RespVO.estimatedSpo2' },
    { label: '估计总血红蛋白', prop: 'experimentExamBiochemicalTestsV2RespVO.estimatedHb' },
    { label: 'β2-微球蛋白', prop: 'experimentExamBiochemicalTestsV2RespVO.beta2Microglobulin' },
    { label: '超敏C反应蛋白', prop: 'experimentExamBiochemicalTestsV2RespVO.hsCrp' },
    { label: '乙肝表面抗原', prop: 'experimentExamBiochemicalTestsV2RespVO.hbsag' },
    { label: '乙肝表面抗体', prop: 'experimentExamBiochemicalTestsV2RespVO.antiHbs' },
    { label: '乙肝e抗原', prop: 'experimentExamBiochemicalTestsV2RespVO.hbeag' },
    { label: '乙肝e抗体', prop: 'experimentExamBiochemicalTestsV2RespVO.antiHbe' },
    { label: '乙肝核心抗体', prop: 'experimentExamBiochemicalTestsV2RespVO.antiHbc' },
    { label: '总胆固醇', prop: 'experimentExamBiochemicalTestsV2RespVO.totalCholesterol' },
    { label: '缺血修饰白蛋白', prop: 'experimentExamBiochemicalTestsV2RespVO.ima' },
    { label: 'α-L-岩藻糖苷酶', prop: 'experimentExamBiochemicalTestsV2RespVO.afucosidase' }
  ],
  血常规: [
    { label: '白细胞计数', prop: 'experimentExamBloodRoutineRespVO.wbcCount' },
    { label: '淋巴细胞百分比', prop: 'experimentExamBloodRoutineRespVO.lymphocytePercent' },
    { label: '中间细胞百分比', prop: 'experimentExamBloodRoutineRespVO.midCellPercent' },
    { label: '粒细胞百分比', prop: 'experimentExamBloodRoutineRespVO.granulocytePercent' },
    { label: '淋巴细胞计数', prop: 'experimentExamBloodRoutineRespVO.lymphocyteCount' },
    { label: '中间细胞计数', prop: 'experimentExamBloodRoutineRespVO.midCellCount' },
    { label: '粒细胞计数', prop: 'experimentExamBloodRoutineRespVO.granulocyteCount' },
    { label: '红细胞计数', prop: 'experimentExamBloodRoutineRespVO.rbcCount' },
    { label: '血红蛋白', prop: 'experimentExamBloodRoutineRespVO.hemoglobin' },
    { label: '血细胞比容', prop: 'experimentExamBloodRoutineRespVO.hematocrit' },
    { label: '平均红细胞体积', prop: 'experimentExamBloodRoutineRespVO.mcv' },
    { label: '平均红细胞血红蛋白含量', prop: 'experimentExamBloodRoutineRespVO.mch' },
    { label: '平均红细胞血红蛋白浓度', prop: 'experimentExamBloodRoutineRespVO.mchc' },
    { label: '红细胞分布宽度变异系数', prop: 'experimentExamBloodRoutineRespVO.rdwCv' },
    { label: '红细胞分布宽度标准差', prop: 'experimentExamBloodRoutineRespVO.rdwSd' },
    { label: '血小板计数', prop: 'experimentExamBloodRoutineRespVO.plateletCount' },
    { label: '平均血小板体积', prop: 'experimentExamBloodRoutineRespVO.mpv' },
    { label: '血小板分布宽度', prop: 'experimentExamBloodRoutineRespVO.pdw' },
    { label: '血小板压积', prop: 'experimentExamBloodRoutineRespVO.pct' },
    { label: '大血小板比率', prop: 'experimentExamBloodRoutineRespVO.largePlateletRatio' },
    { label: '大血小板计数', prop: 'experimentExamBloodRoutineRespVO.largePlateletCount' },
    { label: '嗜碱性粒细胞计数', prop: 'experimentExamBloodRoutineRespVO.basophilCount' },
    { label: '嗜碱性粒细胞百分比', prop: 'experimentExamBloodRoutineRespVO.basophilPercent' },
    { label: '嗜酸性粒细胞计数', prop: 'experimentExamBloodRoutineRespVO.eosinophilCount' },
    { label: '嗜酸性粒细胞百分比', prop: 'experimentExamBloodRoutineRespVO.eosinophilPercent' },
    { label: '幼稚粒细胞计数', prop: 'experimentExamBloodRoutineRespVO.immatureGranulocyteCount' },
    {
      label: '幼稚粒细胞百分比',
      prop: 'experimentExamBloodRoutineRespVO.immatureGranulocytePercent'
    },
    { label: '单核细胞计数', prop: 'experimentExamBloodRoutineRespVO.monocyteCount' },
    { label: '单核细胞百分比', prop: 'experimentExamBloodRoutineRespVO.monocytePercent' },
    { label: '有核红细胞计数', prop: 'experimentExamBloodRoutineRespVO.nucleatedRbcCount' },
    { label: '有核红细胞百分比', prop: 'experimentExamBloodRoutineRespVO.nucleatedRbcPercent' },
    { label: '中性粒细胞计数', prop: 'experimentExamBloodRoutineRespVO.neutrophilCount' },
    { label: '中性粒细胞百分比', prop: 'experimentExamBloodRoutineRespVO.neutrophilPercent' }
  ],
  凝血功能: [
    { label: '活化部分凝血活酶时间', prop: 'experimentExamCoagulationTestsRespVO.aptt' },
    {
      label: '抗凝血酶Ⅲ活性百分比',
      prop: 'experimentExamCoagulationTestsRespVO.antithrombinIiiActivityPercent'
    },
    {
      label: '抗凝血酶Ⅲ活性（吸光度变化速率检测）',
      prop: 'experimentExamCoagulationTestsRespVO.antithrombinIiiActivityRate'
    },
    {
      label: 'D-二聚体（光密度差值检测）',
      prop: 'experimentExamCoagulationTestsRespVO.dDimerOptDensity'
    },
    { label: 'D-二聚体浓度', prop: 'experimentExamCoagulationTestsRespVO.dDimerConcentration' },
    {
      label: '纤维蛋白降解产物（光密度差值检测）',
      prop: 'experimentExamCoagulationTestsRespVO.fibrinDegradationProductsDensity'
    },
    {
      label: '纤维蛋白降解产物浓度',
      prop: 'experimentExamCoagulationTestsRespVO.fibrinDegradationProductsConcentration'
    },
    {
      label: '纤维蛋白原浓度',
      prop: 'experimentExamCoagulationTestsRespVO.fibrinogenConcentration'
    },
    {
      label: '纤维蛋白原凝固时间',
      prop: 'experimentExamCoagulationTestsRespVO.fibrinogenClottingTime'
    },
    {
      label: '凝血酶原时间(百分比活动度)',
      prop: 'experimentExamCoagulationTestsRespVO.prothrombinTimePercent'
    },
    { label: '凝血酶原时间-国际标准化比值', prop: 'experimentExamCoagulationTestsRespVO.ptInr' },
    {
      label: '凝血酶原时间比值',
      prop: 'experimentExamCoagulationTestsRespVO.prothrombinTimeRatio'
    },
    { label: '凝血酶原时间', prop: 'experimentExamCoagulationTestsRespVO.prothrombinTime' },
    { label: '凝血酶时间', prop: 'experimentExamCoagulationTestsRespVO.thrombinTime' },
    { label: '凝血酶时间(1)', prop: 'experimentExamCoagulationTestsRespVO.thrombinTime1' },
    { label: '活化部分凝血活酶时间(1)', prop: 'experimentExamCoagulationTestsRespVO.aptt1' },
    { label: '活化部分凝血活酶时间(2)', prop: 'experimentExamCoagulationTestsRespVO.aptt2' },
    { label: '凝血酶原活动度', prop: 'experimentExamCoagulationTestsRespVO.prothrombinActivity' },
    { label: '国际标准化比值', prop: 'experimentExamCoagulationTestsRespVO.inr' }
  ],
  心肌肌钙蛋白I: [{ label: '心肌肌钙蛋白I', prop: 'experimentExamOtherDataRespVO.cardiacTroponinI' }],
  血管超声结果: [{ label: '血管超声结果', prop: 'experimentExamOtherDataRespVO.vascularUltrasoundResult' }],
  心电图分析结果: [{ label: '心电图分析结果', prop: 'experimentExamOtherDataRespVO.ecgAnalysisResult' }],
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
    eatingHabits: '饮食习惯',
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
    otherSleepIssues: '其他影响睡眠的事情'
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
