package cn.iocoder.yudao.module.queueDB.service.external;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ROmicsReportService {

    void writeFileToResponse(String fileName, HttpServletResponse response) throws IOException;
}
