package cn.iocoder.yudao.module.queueDB.service.external;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface AbilityModelService {

    Map<String, Object> uploadTrainFile(MultipartFile file, String datatype) throws IOException;

    Map<String, Object> uploadPredictionFile(MultipartFile file, String datatype) throws IOException;

    Map<String, Object> getTrainRecordsPage(Integer page, Integer pageSize, String altitudeGroup);

    Map<String, Object> getPredictionRecordsPage(Integer page, Integer pageSize, String altitudeGroup);

    Map<String, Object> getTrainRecordDetail(String recordId);

    Map<String, Object> getPredictionRecordDetail(String recordId);

    void writeFileToResponse(String encodedSource, boolean preview, HttpServletResponse response) throws IOException;
}
