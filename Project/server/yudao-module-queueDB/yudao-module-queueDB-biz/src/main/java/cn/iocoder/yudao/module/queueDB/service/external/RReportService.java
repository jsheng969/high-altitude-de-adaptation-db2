package cn.iocoder.yudao.module.queueDB.service.external;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface RReportService {

    Map run(String type, MultipartFile trainFile, MultipartFile validFile) throws Exception;

    Map getResult(String type, String taskId);

    Map getTasks(String type);
}
