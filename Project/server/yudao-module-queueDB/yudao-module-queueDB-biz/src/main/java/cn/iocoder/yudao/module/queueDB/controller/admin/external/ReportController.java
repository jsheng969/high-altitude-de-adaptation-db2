package cn.iocoder.yudao.module.queueDB.controller.admin.external;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.module.queueDB.service.external.RReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;

import java.util.Map;

import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@RestController
@RequestMapping("/external/report")
@CrossOrigin
public class ReportController {

    @Autowired
    private RReportService reportService;

    @PostMapping("/run")
    public CommonResult<Map> run(
            @RequestParam(value = "type", defaultValue = "acute") String type,
            @RequestParam(value = "trainFile", required = false) MultipartFile trainFile,
            @RequestParam(value = "validFile", required = false) MultipartFile validFile
    ) throws Exception {
        return success(reportService.run(type, trainFile, validFile));
    }

    @GetMapping("/result/{taskId}")
    public CommonResult<Map> result(@PathVariable String taskId,
                                    @RequestParam(value = "type", defaultValue = "acute") String type) {
        return success(reportService.getResult(type, taskId));
    }

    @GetMapping("/tasks")
    public CommonResult<Map> tasks(@RequestParam(value = "type", defaultValue = "acute") String type) {
        return success(reportService.getTasks(type));
    }

    @PermitAll
    @GetMapping("/file/{type}/{taskId}/{fileName:.+}")
    public void getFile(@PathVariable String type,
                        @PathVariable String taskId,
                        @PathVariable String fileName,
                        HttpServletResponse response) throws IOException {

        String safeType = normalizeType(type);

        File file = new File(
                "/Users/jsheng/Downloads/Tools/Tools/数据和代码-给邓工20260211/shared/output/"
                        + safeType + "/" + taskId + "/" + fileName
        );

        if (!file.exists() || !file.isFile()) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String contentType = Files.probeContentType(file.toPath());
        if (contentType == null) {
            String lower = fileName.toLowerCase();
            if (lower.endsWith(".png")) {
                contentType = "image/png";
            } else if (lower.endsWith(".jpg") || lower.endsWith(".jpeg")) {
                contentType = "image/jpeg";
            } else if (lower.endsWith(".pdf")) {
                contentType = "application/pdf";
            } else {
                contentType = "application/octet-stream";
            }
        }

        response.setContentType(contentType);
        response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");

        try (InputStream in = new FileInputStream(file);
             OutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[8192];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            out.flush();
        }
    }

    private String normalizeType(String type) {
        if ("chronic".equalsIgnoreCase(type)) {
            return "chronic";
        }
        return "acute";
    }
}