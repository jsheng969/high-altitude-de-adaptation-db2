package cn.iocoder.yudao.module.review.dal.dataobject.controldiseasespectrum;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组-疾病谱 DO
 *
 * @author 管理员
 */
@TableName("review_control_disease_spectrum")
@KeySequence("review_control_disease_spectrum_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ControlDiseaseSpectrumDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Long id;
    /**
     * 基础信息id
     */
    private Long personId;
    /**
     * 脂肪肝
     */
    private Boolean fattyLiver;
    /**
     * 肝囊肿
     */
    private Boolean hepaticCyst;
    /**
     * 胆囊息肉
     */
    private Boolean gallbladderPolyp;
    /**
     * 胆囊结石
     */
    private Boolean gallbladderStone;
    /**
     * 肝血管瘤
     */
    private Boolean hepaticHemangioma;
    /**
     * 脾大
     */
    private Boolean splenomegaly;
    /**
     * 慢性胃炎
     */
    private Boolean chronicGastritis;
    /**
     * 肠息肉
     */
    private Boolean intestinalPolyp;
    /**
     * 阑尾炎
     */
    private Boolean appendicitis;
    /**
     * 急性胰腺炎
     */
    private Boolean acutePancreatitis;
    /**
     * 消化道溃疡
     */
    private Boolean digestiveUlcer;
    /**
     * 消化道出血
     */
    private Boolean digestiveBleeding;
    /**
     * 高血压
     */
    private Boolean hypertension;
    /**
     * 窦性心动过缓
     */
    private Boolean bradycardia;
    /**
     * 短暂性脑缺血
     */
    private Boolean transientIschemicAttack;
    /**
     * 窦性心动过速
     */
    private Boolean tachycardia;
    /**
     * 脑梗死/脑血栓
     */
    private Boolean cerebralInfarction;
    /**
     * 频发房性早搏
     */
    private Boolean frequentPrematureAtrialContractions;
    /**
     * 频发室性早搏
     */
    private Boolean frequentPrematureVentricularContractions;
    /**
     * 冠心病
     */
    private Boolean coronaryHeartDisease;
    /**
     * 房颤
     */
    private Boolean atrialFibrillation;
    /**
     * 心肌梗死
     */
    private Boolean myocardialInfarction;
    /**
     * 高甘油三酯血症
     */
    private Boolean hypertriglyceridemia;
    /**
     * 低密度脂蛋白胆固醇增多症
     */
    private Boolean highLdl;
    /**
     * 高密度脂蛋白胆固醇增多症
     */
    private Boolean highHdl;
    /**
     * 高尿酸血症
     */
    private Boolean hyperuricemia;
    /**
     * 高胆固醇血症
     */
    private Boolean hypercholesterolemia;
    /**
     * 糖尿病
     */
    private Boolean diabetes;
    /**
     * 甲状腺疾病
     */
    private Boolean thyroidDisease;
    /**
     * 肺结节
     */
    private Boolean lungNodule;
    /**
     * 肺气肿
     */
    private Boolean pulmonaryEmphysema;
    /**
     * 慢阻肺
     */
    private Boolean copd;
    /**
     * 哮喘
     */
    private Boolean asthma;
    /**
     * 肾结石
     */
    private Boolean kidneyStone;
    /**
     * 肾囊肿
     */
    private Boolean renalCyst;
    /**
     * 前列腺炎
     */
    private Boolean prostatitis;
    /**
     * 腰椎病
     */
    private Boolean lumbarSpondylosis;
    /**
     * 颈椎病
     */
    private Boolean cervicalSpondylosis;
    /**
     * 失眠
     */
    private Boolean insomnia;

}