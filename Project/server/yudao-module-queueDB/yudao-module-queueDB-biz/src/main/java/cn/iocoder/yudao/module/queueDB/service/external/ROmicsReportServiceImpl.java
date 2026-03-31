package cn.iocoder.yudao.module.queueDB.service.external;

import cn.iocoder.yudao.module.queueDB.controller.admin.external.config.AppProperties;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

@Service
public class ROmicsReportServiceImpl implements ROmicsReportService {

    private final AppProperties appProperties;

    public ROmicsReportServiceImpl(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    @Override
    public void writeFileToResponse(String fileName, HttpServletResponse response) throws IOException {
        File file = resolveFile(fileName);
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
        response.setHeader("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");

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

    private File resolveFile(String fileName) throws IOException {
        String safeFileName = sanitizeFileName(fileName);

        File omicsBaseDir = new File(appProperties.getPluginsDir());
        File resolved = new File(omicsBaseDir, safeFileName);

        String basePath = omicsBaseDir.getCanonicalPath() + File.separator;
        String resolvedPath = resolved.getCanonicalPath();
        if (!resolvedPath.startsWith(basePath)) {
            throw new IOException("Illegal file path");
        }
        return resolved;
    }

    private String sanitizeSegment(String value) {
        if (value == null) {
            return "";
        }
        return value.replace("\\", "").replace("/", "").trim();
    }

    private String sanitizeFileName(String value) {
        String sanitized = sanitizeSegment(value);
        return sanitized.replace("..", "");
    }
}
