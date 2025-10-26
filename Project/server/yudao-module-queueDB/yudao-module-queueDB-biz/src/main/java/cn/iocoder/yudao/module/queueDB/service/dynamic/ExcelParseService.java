package cn.iocoder.yudao.module.queueDB.service.dynamic;

import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.dto.ExcelImportReqDTO;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo.ExcelBasicInfo;
import cn.iocoder.yudao.module.queueDB.controller.admin.dynamictable.vo.ExcelParseResult;
import org.springframework.web.multipart.MultipartFile;

public interface ExcelParseService {
    /**
     * 解析Excel文件
     * @param file Excel文件
     * @param importReq 导入请求
     * @return 解析结果
     */
    ExcelParseResult parseExcel(MultipartFile file, ExcelImportReqDTO importReq);

    /**
     * 生成字段编码（中文转英文）
     * @param chineseName 中文字段名
     * @param parentGroup 父分组
     * @return 字段编码
     */
    String generateFieldCode(String chineseName, String parentGroup);

    /**
     * 检测Excel配置模式
     * @param file Excel文件
     * @return 配置模式：simple/full
     */
    String detectConfigMode(MultipartFile file);

    /**
     * 验证Excel文件格式
     * @param file Excel文件
     * @return 验证结果
     */
    boolean validateExcelFormat(MultipartFile file);

    /**
     * 获取Excel基本信息
     * @param file Excel文件
     * @return 基本信息
     */
    ExcelBasicInfo getExcelBasicInfo(MultipartFile file);
}
