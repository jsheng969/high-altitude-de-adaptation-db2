package cn.iocoder.yudao.module.review.dal.dataobject.experimentexamabdominalultrasound;

import lombok.*;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 实验组体检-腹部超声 DO
 *
 * @author 芋道源码
 */
@TableName("review_experiment_exam_abdominal_ultrasound")
@KeySequence("review_experiment_exam_abdominal_ultrasound_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperimentExamAbdominalUltrasoundDO extends BaseDO {

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
     * 腹部超声-描述
     */
    private String ultrasoundDescription;
    /**
     * 腹部超声-小结
     */
    private String ultrasoundSummary;

}