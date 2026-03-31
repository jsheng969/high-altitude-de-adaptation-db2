package cn.iocoder.yudao.module.queueDB.controller.admin.external;

import cn.iocoder.yudao.module.queueDB.service.external.AbilityModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api")
public class AbilityModelController {

    private final AbilityModelService abilityModelService;

    @PostMapping("/upload/brainexcel")
    public Map<String, Object> uploadTrainFile(@RequestParam("file") MultipartFile file,
                                               @RequestParam("datatype") String datatype) throws IOException {
        return abilityModelService.uploadTrainFile(file, datatype);
    }

    @PostMapping("/upload/brainmodel")
    public Map<String, Object> uploadPredictionFile(@RequestParam("file") MultipartFile file,
                                                    @RequestParam("datatype") String datatype) throws IOException {
        return abilityModelService.uploadPredictionFile(file, datatype);
    }

    @GetMapping("/analysis/records/page")
    public Map<String, Object> getTrainRecordsPage(@RequestParam("page") Integer page,
                                                   @RequestParam("page_size") Integer pageSize,
                                                   @RequestParam("altitude_group") String altitudeGroup) {
        Map<String, Object> trainRecordsPage = abilityModelService.getTrainRecordsPage(page, pageSize, altitudeGroup);
        return trainRecordsPage;
    }

    @GetMapping("/prediction/records/page")
    public Map<String, Object> getPredictionRecordsPage(@RequestParam("page") Integer page,
                                                        @RequestParam("page_size") Integer pageSize,
                                                        @RequestParam("altitude_group") String altitudeGroup) {
        return abilityModelService.getPredictionRecordsPage(page, pageSize, altitudeGroup);
    }

    @GetMapping("/train/record/{recordId}")
    public Map<String, Object> getTrainRecordDetail(@PathVariable String recordId) {
        return abilityModelService.getTrainRecordDetail(recordId);
    }

    @GetMapping("/prediction/record/{recordId}")
    public Map<String, Object> getPredictionRecordDetail(@PathVariable String recordId) {
        return abilityModelService.getPredictionRecordDetail(recordId);
    }

    @PermitAll
    @GetMapping("/file/download/{encodedSource:.+}")
    public void downloadFile(@PathVariable String encodedSource,
                             HttpServletResponse response) throws IOException {
        abilityModelService.writeFileToResponse(encodedSource, false, response);
    }

    @PermitAll
    @GetMapping("/file/preview/{encodedSource:.+}")
    public void previewFile(@PathVariable String encodedSource,
                            HttpServletResponse response) throws IOException {
        abilityModelService.writeFileToResponse(encodedSource, true, response);
    }
}
