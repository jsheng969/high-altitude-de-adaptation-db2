package cn.iocoder.yudao.module.prospective.service.basicinfo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import cn.iocoder.yudao.module.prospective.controller.admin.basicinfo.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.basicinfo.ProspectiveBasicInfoDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.basicinfo.ProspectiveBasicInfoMapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.TIME_POINT1_SURVEY_BASIC_INFO_NOT_EXISTS;

/**
 * 基础信息 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class ProspectiveBasicInfoServiceImpl implements ProspectiveBasicInfoService {

    @Resource
    private ProspectiveBasicInfoMapper prospectiveBasicInfoMapper;

    @Override
    public Long createBasicInfo(BasicInfoSaveReqVO createReqVO) {
        // 插入
        ProspectiveBasicInfoDO basicInfo = BeanUtils.toBean(createReqVO, ProspectiveBasicInfoDO.class);
        prospectiveBasicInfoMapper.insert(basicInfo);
        // 返回
        return basicInfo.getId();
    }

    @Override
    public void updateBasicInfo(BasicInfoSaveReqVO updateReqVO) {
        // 校验存在
        validateBasicInfoExists(updateReqVO.getId());
        // 更新
        ProspectiveBasicInfoDO updateObj = BeanUtils.toBean(updateReqVO, ProspectiveBasicInfoDO.class);
        prospectiveBasicInfoMapper.updateById(updateObj);
    }

    @Override
    public void deleteBasicInfo(Long id) {
        // 校验存在
        validateBasicInfoExists(id);
        // 删除
        prospectiveBasicInfoMapper.deleteById(id);
    }

    private void validateBasicInfoExists(Long id) {
        if (prospectiveBasicInfoMapper.selectById(id) == null) {
            throw exception(TIME_POINT1_SURVEY_BASIC_INFO_NOT_EXISTS);
        }
    }

    @Override
    public ProspectiveBasicInfoDO getBasicInfo(Long id) {
        return prospectiveBasicInfoMapper.selectById(id);
    }

    @Override
    public PageResult<ProspectiveBasicInfoDO> getBasicInfoPage(BasicInfoPageReqVO pageReqVO) {
        return prospectiveBasicInfoMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ProspectiveBasicInfoDO> selectBasicInfoList(BasicInfoPageReqVO reqVO){
        return prospectiveBasicInfoMapper.selectBasicInfoList(reqVO);
    }

    @Override
    public PageResult<ProspectiveBasicInfoDO> getDataByParamPage(BasicInfoPageReqVO pageReqVO) {
//        // 第一步：只分页查主表 ID（性能好）
//        Page<ProspectiveBasicInfoDO> page = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());
//        Page<ProspectiveBasicInfoDO> basicInfoPage = prospectiveBasicInfoMapper.selectBasicInfoPage(page, pageReqVO);
//
//        List<Long> personIds = basicInfoPage.getRecords().stream()
//                .map(ProspectiveBasicInfoDO::getId)
//                .collect(Collectors.toList());
//
//        if (CollectionUtils.isEmpty(personIds)) {
//            return new PageResult<>(Collections.emptyList(), 0L);
//        }
//
//        // 第二步：通过 ID 批量查询完整详情（含子表联查）
//        List<BasicInfoRespVO> voList = prospectiveBasicInfoMapper.selectBasicInfoDetailsByIds(personIds, pageReqVO.getTimePoint());
//
//        // 第三步：position 字段脱敏处理
//        voList.forEach(vo -> {
//            String pos = vo.getPosition();
//            if (StringUtils.isBlank(pos)) {
//                vo.setPosition("*");
//            } else if (pos.length() == 1) {
//                vo.setPosition("*");
//            } else if (pos.length() == 2) {
//                vo.setPosition(pos.charAt(0) + "*");
//            } else {
//                vo.setPosition(pos.charAt(0) + "**" + pos.charAt(pos.length() - 1));
//            }
//        });
//
//        // 返回分页数据
//        return new PageResult<>(voList, basicInfoPage.getTotal());



        Page<ProspectiveBasicInfoDO> page = new Page<>(pageReqVO.getPageNo(), pageReqVO.getPageSize());
        Page<BasicInfoRespVO> basicInfoRespVOList = prospectiveBasicInfoMapper.selectDataByParamPage(page,pageReqVO);
        String ecgKeyword = null;
        if (pageReqVO.getAdvancedConditions() != null) {
            // 找到前端传的 ecg_analysis_result 条件值
            ecgKeyword = pageReqVO.getAdvancedConditions().stream()
                    .filter(c -> "peeod.ecg_analysis_result".equals(c.getField()))
                    .map(BasicInfoPageReqVO.AdvancedCondition::getValue)
                    .findFirst()
                    .orElse(null);
        }

        String finalEcgKeyword = ecgKeyword;
        basicInfoRespVOList.setRecords(
                basicInfoRespVOList.getRecords().stream()
                        .map(item -> {
                            // ========= 对 position 字段做脱敏处理 =========
                            String pos = item.getPosition();
                            if (pos == null || pos.length() == 0) {
                                // null 或空字符串，显示 "*"
                                item.setPosition("*");
                            } else if (pos.length() == 1) {
                                // 只有一个字，显示 "*"
                                item.setPosition("*");
                            } else if (pos.length() == 2) {
                                // 两个字，显示第一个字 + "*"
                                item.setPosition(pos.charAt(0) + "*");
                            } else {
                                // 超过两个字，显示第一个字 + "**" + 最后一个字
                                String result = pos.charAt(0) + "**" + pos.charAt(pos.length() - 1);
                                item.setPosition(result);
                            }
                            // ========= 对 ecg_analysis_result 的处理 =========
                            if (finalEcgKeyword != null
                                    && item.getExperimentExamOtherDataRespVO() != null
                                    && item.getExperimentExamOtherDataRespVO().getEcgAnalysisResult() != null) {

                                String[] results = item.getExperimentExamOtherDataRespVO().getEcgAnalysisResult().split("，");
                                String matched = Arrays.stream(results)
                                        .map(String::trim)
                                        .filter(r -> r.contains(finalEcgKeyword))
                                        .collect(Collectors.joining("，")); // 理论上只有一个

                                // ✅ set 回去
                                item.getExperimentExamOtherDataRespVO().setEcgAnalysisResult(matched);
                            }
                            return item;
                        })
                        .collect(Collectors.toList())
        );

        return new PageResult(basicInfoRespVOList.getRecords(),basicInfoRespVOList.getTotal());
    }

    @Override
    public BasicInfoAverageVO getAverageByParam(BasicInfoPageReqVO pageReqVO) {
        BasicInfoAverageVO basicInfoRespVOList = prospectiveBasicInfoMapper.getAverageByParam(pageReqVO);
        return basicInfoRespVOList;
    }

    @Override
    public Integer getVipNumber1() {
        return prospectiveBasicInfoMapper.getVipNumber1();
    }

    @Override
    public Integer getVipNumber2() {
        return prospectiveBasicInfoMapper.getVipNumber2();
    }

    @Override
    public Integer getVipNumber3() {
        return prospectiveBasicInfoMapper.getVipNumber3();
    }

    @Override
    public BasicInfoAverageVO getQueue1() {
        return prospectiveBasicInfoMapper.getQueue1();
    }

    @Override
    public BasicInfoAverageVO getQueue2() {
        return prospectiveBasicInfoMapper.getQueue2();
    }

    @Override
    public BasicInfoAverageVO getQueue3() {
        return prospectiveBasicInfoMapper.getQueue3();
    }

    @Override
    public BasicInfoAverageVO getTimePoint(BasicInfoPageReqVO basicInfoReqVO) {
        return prospectiveBasicInfoMapper.getTimePoint(basicInfoReqVO);
    }

    @Override
    public List<Map<String, Object>> getQueue1EthnicityCount() {
        return prospectiveBasicInfoMapper.getQueue1EthnicityCount();
    }

    @Override
    public List<Map<String, Object>> getQueue2EthnicityCount() {
        return prospectiveBasicInfoMapper.getQueue2EthnicityCount();
    }

    @Override
    public BasicInfoAverageVO getMissionPointAltitudeCount() {
        return prospectiveBasicInfoMapper.getMissionPointAltitudeCount();
    }

    @Override
    public BasicInfoAverageVO getClinicalSymptomsData(BasicInfoPageReqVO basicInfoReqVO) {
        return prospectiveBasicInfoMapper.getClinicalSymptomsData(basicInfoReqVO);
    }

    @Override
    public BasicInfoAverageVO getExamData(BasicInfoPageReqVO basicInfoReqVO) {
        return prospectiveBasicInfoMapper.getExamData(basicInfoReqVO);
    }



}