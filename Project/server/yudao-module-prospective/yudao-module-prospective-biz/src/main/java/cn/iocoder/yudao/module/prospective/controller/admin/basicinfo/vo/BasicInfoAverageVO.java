package cn.iocoder.yudao.module.prospective.controller.admin.basicinfo.vo;

import lombok.Data;

@Data
public class BasicInfoAverageVO {

    private Double dataRatio;
    private Integer maleCount;
    private Integer femaleCount;
    private Double averageAge;
    private Double minAge;
    private Double maxAge;

    private Double averagePlateauMissionDuration;
    private Double maxPlateauMissionDuration;
    private Double minPlateauMissionDuration;

    private Integer scoreLt6;
    private Integer score6To15;
    private Integer score16To25;
    private Integer scoreGt25;
    private Integer scoreGte6;

    private Integer scoreLt6Tp3;
    private Integer score6To15Tp3;
    private Integer score16To25Tp3;
    private Integer scoreGt25Tp3;
    private Integer scoreGte6Tp3;

    private Integer scoreDowngradeCount1;
    private Integer scoreDowngradeCount2;
    private Integer scoreDowngradeCount3;
    private Integer scoreDowngradeCount4;
    private Integer scoreDowngradeCount5;
    private Integer scoreDowngradeCount6;

    private Integer fatigueSum;
    private Integer weaknessSum;
    private Integer drowsinessSum;
    private Integer dizzinessSum;
    private Integer vertigoSum;
    private Integer poorConcentrationSum;
    private Integer slowReactionSum;
    private Integer memoryLossSum;
    private Integer insomniaSum;
    private Integer nightmaresSum;
    private Integer soreThroatSum;
    private Integer coughSum;
    private Integer phlegmSum;
    private Integer wheezingSum;
    private Integer chestTightnessSum;
    private Integer chestPainSum;
    private Integer palpitationsSum;
    private Integer bradycardiaSum;
    private Integer cyanosisSum;
    private Integer bloodPressureFluctuationSum;
    private Integer skinBleedingSum;
    private Integer skinBruisingSum;
    private Integer anemiaSum;
    private Integer weightLossSum;
    private Integer increasedAppetiteSum;
    private Integer anorexiaSum;
    private Integer constipationSum;
    private Integer diarrheaSum;
    private Integer abdominalPainSum;
    private Integer abdominalDistensionSum;
    private Integer jaundiceSum;
    private Integer numbnessSum;
    private Integer limbEdemaSum;
    private Integer facialEdemaSum;
    private Integer hairLossSum;
    private Integer increasedUrinationSum;

    private Double averageMissionPointAltitude;
    private Double minMissionPointAltitude;
    private Double maxMissionPointAltitude;

    private Integer dur12A3000To4000;
    private Integer dur12A4000To5000;
    private Integer dur12A5000;
    private Integer durlt12A3000To4000;
    private Integer durlt12A4000To5000;
    private Integer durlt12A5000;
    private Integer allA3000To4000;
    private Integer allA4000To5000;
    private Integer allA5000;

    private Integer totalScoreQ1;
    private Integer totalScoreQ2;

    private Double examCountQ1;
    private String meanStddevQ1;

    private Double examCountQ2;
    private String meanStddevQ2;
}
