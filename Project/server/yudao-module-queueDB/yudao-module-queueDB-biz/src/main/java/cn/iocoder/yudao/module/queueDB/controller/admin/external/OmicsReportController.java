package cn.iocoder.yudao.module.queueDB.controller.admin.external;

import cn.iocoder.yudao.module.queueDB.service.external.ROmicsReportService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/external/omics-report")
@CrossOrigin
public class OmicsReportController {

    private final ROmicsReportService omicsReportService;

    public OmicsReportController(ROmicsReportService omicsReportService) {
        this.omicsReportService = omicsReportService;
    }

    @PermitAll
    @GetMapping("/file/{fileName:.+}")
    public void getFile(
                        @PathVariable String fileName,
                        HttpServletResponse response) throws IOException {
        omicsReportService.writeFileToResponse(fileName, response);
    }
}
