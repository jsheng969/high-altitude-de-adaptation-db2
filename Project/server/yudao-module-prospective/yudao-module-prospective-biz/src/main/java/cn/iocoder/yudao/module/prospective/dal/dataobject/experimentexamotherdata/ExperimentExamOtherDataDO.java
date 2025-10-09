package cn.iocoder.yudao.module.prospective.dal.dataobject.experimentexamotherdata;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组体检-其他数据 DO
 *
 * @author 管理员
 */
@TableName("prospective_experiment_exam_other_data")
@KeySequence("prospective_experiment_exam_other_data_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentExamOtherDataDO extends BaseDO {

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
     * 心肌肌钙蛋白I
     */
    private String cardiacTroponinI;
    /**
     * 血管超声结果
     */
    private String vascularUltrasoundResult;
    /**
     * 心电图分析结果
     */
    private String ecgAnalysisResult;
    /**
     * 时相
     */
    private Integer timePoint;

}