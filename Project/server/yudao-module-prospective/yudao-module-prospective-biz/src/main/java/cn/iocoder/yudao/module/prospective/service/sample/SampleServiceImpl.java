package cn.iocoder.yudao.module.prospective.service.sample;

import cn.iocoder.yudao.framework.datasource.core.inter.EncryptField;
import cn.iocoder.yudao.framework.datasource.core.inter.Encryptor;
import cn.iocoder.yudao.framework.security.core.LoginUser;
import cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils;
import cn.iocoder.yudao.framework.web.core.util.WebFrameworkUtils;
import cn.iocoder.yudao.module.prospective.controller.admin.samplehistory.vo.SampleHistorySaveReqVO;
import cn.iocoder.yudao.module.prospective.service.samplehistory.SampleHistoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.*;
import cn.iocoder.yudao.module.prospective.controller.admin.sample.vo.*;
import cn.iocoder.yudao.module.prospective.dal.dataobject.sample.SampleDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.prospective.dal.mysql.sample.SampleMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.prospective.enums.ErrorCodeConstants.*;

/**
 * 生物样本 Service 实现类
 *
 * @author 管理员
 */
@Service
@Validated
public class SampleServiceImpl implements SampleService {

    @Resource
    private SampleMapper sampleMapper;

    @Resource
    private SampleHistoryService sampleHistoryService;

    @Autowired
    private Encryptor encryptor;

    @Override
    public Long createSample(SampleSaveReqVO createReqVO) {
        // 插入
        SampleDO sample = BeanUtils.toBean(createReqVO, SampleDO.class);
        sampleMapper.insert(sample);
        // 返回
        return sample.getId();
    }

    @Override
    public void updateSample(SampleSaveReqVO updateReqVO) {
        // 校验存在
        validateSampleExists(updateReqVO.getId());
        // 更新
        SampleDO updateObj = BeanUtils.toBean(updateReqVO, SampleDO.class);
        sampleMapper.updateById(updateObj);
    }

    @Override
    public void deleteSample(Long id) {
        // 校验存在
        validateSampleExists(id);
        // 删除
        sampleMapper.deleteById(id);
    }

    private void validateSampleExists(Long id) {
        if (sampleMapper.selectById(id) == null) {
            throw exception(SAMPLE_NOT_EXISTS);
        }
    }

    @Override
    public SampleDO getSample(Long id) {
        return sampleMapper.selectById(id);
    }

    @Override
    public PageResult<SampleDO> getSamplePage(SamplePageReqVO pageReqVO) {
        return sampleMapper.selectPage(pageReqVO);
    }

    @Override
    public void batchInsert(List<SamplePageReqVO> dataList) {
        sampleMapper.batchInsert(dataList);
    }

    @Override
    public List<BoxDisplayVO> getBoxesWithSampleTypes(SampleRespVO sampleRespVO) {
        return sampleMapper.selectBoxesWithGroupedSampleTypes(sampleRespVO);
    }

    @Override
    public List<SampleRespVO> getDataByBoxNo(SampleRespVO sampleRespVO) {
        return sampleMapper.selectDataByBoxNo(sampleRespVO);
    }

    @Override
    public List<SampleTypeCountVO> getSampleTypeCount() {
        return sampleMapper.selectSampleTypeCount();
    }

    @Override
    public void takeOut(Long id) {
        SampleDO sampleDO = sampleMapper.selectById(id);
        if (null != sampleDO) {
            sampleDO.setStatus(0); // 0=取出
            if (null != sampleDO.getRemainCount()){
                if (sampleDO.getRemainCount() >0){
                    sampleDO.setRemainCount(sampleDO.getRemainCount() - 1);
                }
            } else {
                if (null != sampleDO.getTotalCount()){
                    sampleDO.setRemainCount(sampleDO.getTotalCount() - 1);
                }else {
                    //默认总可以次数为10次
                    sampleDO.setRemainCount(9);
                }
            }
            sampleMapper.updateById(sampleDO);

            // 记录取样记录
            SampleHistorySaveReqVO sampleHistorySaveReqVO = new SampleHistorySaveReqVO();
            sampleHistorySaveReqVO.setBioSampleId(sampleDO.getId());
            String nickname = SecurityFrameworkUtils.getLoginUserNickname();
            if (nickname == null) {
                sampleHistorySaveReqVO.setCreateBy(nickname);
            }
            sampleHistorySaveReqVO.setCreateTime(LocalDateTime.now());
            sampleHistorySaveReqVO.setAction("取出");
            sampleHistoryService.createSampleHistory(sampleHistorySaveReqVO);
        }

    }

    @Override
    public void putBack(SamplePageReqVO pageReqVO) {
        SampleDO sampleDO = sampleMapper.selectById(pageReqVO.getId());
        if (null != sampleDO) {
            sampleDO.setStatus(1); // 1=放回
            sampleDO.setTubeNo(pageReqVO.getTubeNo());
            sampleMapper.updateById(sampleDO);

            // 记录取样记录
            SampleHistorySaveReqVO sampleHistorySaveReqVO = new SampleHistorySaveReqVO();
            sampleHistorySaveReqVO.setBioSampleId(sampleDO.getId());
            String nickname = SecurityFrameworkUtils.getLoginUserNickname();
            if (nickname == null) {
                sampleHistorySaveReqVO.setCreateBy(nickname);
            }
            sampleHistorySaveReqVO.setCreateTime(LocalDateTime.now());
            sampleHistorySaveReqVO.setAction("放回");
            sampleHistoryService.createSampleHistory(sampleHistorySaveReqVO);
        }
    }

    @Override
    public void takeOutByTubeNo(String tubeNo) {
        QueryWrapper<SampleDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tube_no", tubeNo);
        List<SampleDO> sampleDOList = sampleMapper.selectList(queryWrapper);
        if (sampleDOList.size() > 0) {
            SampleDO sampleDO = sampleDOList.get(0);
            sampleDO.setStatus(0); // 0=取出
            if (null != sampleDO.getRemainCount()){
                if (sampleDO.getRemainCount() >0){
                    sampleDO.setRemainCount(sampleDO.getRemainCount() - 1);
                }
            } else {
                if (null != sampleDO.getTotalCount()){
                    sampleDO.setRemainCount(sampleDO.getTotalCount() - 1);
                }else {
                    //默认总可以次数为10次
                    sampleDO.setRemainCount(9);
                }
            }
            sampleMapper.updateById(sampleDO);

            // 记录取样记录
            SampleHistorySaveReqVO sampleHistorySaveReqVO = new SampleHistorySaveReqVO();
            sampleHistorySaveReqVO.setBioSampleId(sampleDO.getId());
            String nickname = SecurityFrameworkUtils.getLoginUserNickname();
            if (nickname == null) {
                sampleHistorySaveReqVO.setCreateBy(nickname);
            }
            sampleHistorySaveReqVO.setCreateTime(LocalDateTime.now());
            sampleHistorySaveReqVO.setAction("取出");
            sampleHistoryService.createSampleHistory(sampleHistorySaveReqVO);
        }

    }

    /**
     * 批量加密所有带 @EncryptField 注解的字段
     */
    public void encryptAllAnnotatedFields() throws IllegalAccessException {
        // 查询所有数据
        List<SampleDO> list = sampleMapper.selectList(null);

        for (SampleDO sample : list) {
            boolean updated = false;
            // 获取对象所有字段，包括父类字段
            for (Field field : getAllFields(sample.getClass())) {
                if (field.isAnnotationPresent(EncryptField.class)) {
                    field.setAccessible(true);
                    Object val = field.get(sample);
                    if (val instanceof String && val != null && !val.toString().isEmpty()) {
                        // 避免重复加密
                        if (!isEncrypted(val.toString())) {
                            field.set(sample, encryptor.encrypt(val.toString()));
                            updated = true;
                        }
                    }
                }
            }
            // 如果有字段被加密，更新到数据库
            if (updated) {
                sampleMapper.updateById(sample);
            }
        }
    }

    /**
     * 递归获取类及父类所有字段
     */
    private List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        while (clazz != null && clazz != Object.class) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }

    /**
     * 判断字段是否已经加密
     */
    private boolean isEncrypted(String val) {
        try {
            String decrypt = encryptor.decrypt(val);
            return !Objects.equals(val, decrypt); // 解密后和原文不一致 → 已加密
        } catch (Exception e) {
            return false; // 解密失败 → 明文
        }
    }

}