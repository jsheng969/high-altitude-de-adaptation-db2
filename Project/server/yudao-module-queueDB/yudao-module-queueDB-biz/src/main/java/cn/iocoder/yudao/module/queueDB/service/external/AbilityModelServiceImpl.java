package cn.iocoder.yudao.module.queueDB.service.external;

import cn.hutool.core.util.StrUtil;
import cn.iocoder.yudao.module.queueDB.controller.admin.external.config.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AbilityModelServiceImpl implements AbilityModelService {

    private static final String DEFAULT_ABILITY_MODEL_SERVICE_URL = "http://127.0.0.1:5001";

    private final AppProperties appProperties;
    private final RestTemplate restTemplate;

    @Override
    public Map<String, Object> uploadTrainFile(MultipartFile file, String datatype) throws IOException {
        return postMultipart("/api/upload/brainexcel", file, datatype);
    }

    @Override
    public Map<String, Object> uploadPredictionFile(MultipartFile file, String datatype) throws IOException {
        return postMultipart("/api/upload/brainmodel", file, datatype);
    }

    @Override
    public Map<String, Object> getTrainRecordsPage(Integer page, Integer pageSize, String altitudeGroup) {
        return getForMap("/api/analysis/records/page", page, pageSize, altitudeGroup);
    }

    @Override
    public Map<String, Object> getPredictionRecordsPage(Integer page, Integer pageSize, String altitudeGroup) {
        return getForMap("/api/prediction/records/page", page, pageSize, altitudeGroup);
    }

    @Override
    public Map<String, Object> getTrainRecordDetail(String recordId) {
        return rewriteResponseMap(restTemplate.getForObject(buildAbilityModelUrl("/api/train/record/" + recordId), Map.class));
    }

    @Override
    public Map<String, Object> getPredictionRecordDetail(String recordId) {
        return rewriteResponseMap(restTemplate.getForObject(buildAbilityModelUrl("/api/prediction/record/" + recordId), Map.class));
    }

    @Override
    public void writeFileToResponse(String encodedSource, boolean preview, HttpServletResponse response) throws IOException {
        String sourceUrl = decodeSource(encodedSource);
        String targetUrl = preview ? buildPreviewTargetUrl(sourceUrl) : normalizeSourceUrl(sourceUrl);

        try {
            ResponseEntity<byte[]> remoteResponse = restTemplate.exchange(targetUrl, HttpMethod.GET, HttpEntity.EMPTY, byte[].class);
            writeRemoteResponse(remoteResponse, response, preview);
        } catch (HttpStatusCodeException ex) {
            response.setStatus(ex.getRawStatusCode());
            if (StrUtil.isNotBlank(ex.getResponseBodyAsString())) {
                response.setCharacterEncoding(StandardCharsets.UTF_8.name());
                response.getWriter().write(ex.getResponseBodyAsString());
            }
        }
    }

    private Map<String, Object> postMultipart(String path, MultipartFile file, String datatype) throws IOException {
        LinkedMultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file", buildFilePart(file));
        body.add("datatype", datatype);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        ResponseEntity<Map> response = restTemplate.exchange(
                buildAbilityModelUrl(path),
                HttpMethod.POST,
                new HttpEntity<>(body, headers),
                Map.class
        );
        return rewriteResponseMap(response.getBody());
    }

    private HttpEntity<ByteArrayResource> buildFilePart(MultipartFile file) throws IOException {
        HttpHeaders fileHeaders = new HttpHeaders();
        String fileName = StrUtil.blankToDefault(file.getOriginalFilename(), "upload.xlsx");
        fileHeaders.setContentDispositionFormData("file", fileName);
        fileHeaders.setContentType(parseContentType(file.getContentType()));

        ByteArrayResource resource = new ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return fileName;
            }
        };
        return new HttpEntity<>(resource, fileHeaders);
    }

    private MediaType parseContentType(String contentType) {
        if (StrUtil.isBlank(contentType)) {
            return MediaType.APPLICATION_OCTET_STREAM;
        }
        try {
            return MediaType.parseMediaType(contentType);
        } catch (InvalidMediaTypeException ignored) {
            return MediaType.APPLICATION_OCTET_STREAM;
        }
    }

    private Map<String, Object> getForMap(String path, Integer page, Integer pageSize, String altitudeGroup) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(buildAbilityModelUrl(path))
                .queryParam("page", page)
                .queryParam("page_size", pageSize)
                .queryParam("altitude_group", altitudeGroup)
                .encode(StandardCharsets.UTF_8)
                .build()
                .toUri();
        return rewriteResponseMap(restTemplate.getForObject(uri, Map.class));
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> rewriteResponseMap(Map raw) {
        if (raw == null) {
            return new LinkedHashMap<>();
        }
        return (Map<String, Object>) rewriteValue(raw);
    }

    @SuppressWarnings("unchecked")
    private Object rewriteValue(Object value) {
        if (value instanceof Map) {
            Map<String, Object> rewritten = new LinkedHashMap<>();
            ((Map<?, ?>) value).forEach((key, nestedValue) -> {
                String keyText = String.valueOf(key);
                if (nestedValue instanceof String && isAbilityModelFileUrlKey(keyText)) {
                    rewritten.put(keyText, buildFileProxyUrl((String) nestedValue, keyText.endsWith("_preview_url")));
                    return;
                }
                rewritten.put(keyText, rewriteValue(nestedValue));
            });
            return rewritten;
        }
        if (value instanceof List) {
            List<Object> rewritten = new ArrayList<>();
            for (Object item : (List<?>) value) {
                rewritten.add(rewriteValue(item));
            }
            return rewritten;
        }
        return value;
    }

    private boolean isAbilityModelFileUrlKey(String key) {
        return key.endsWith("_download_url") || key.endsWith("_preview_url");
    }

    private String buildFileProxyUrl(String sourceUrl, boolean preview) {
        if (StrUtil.isBlank(sourceUrl)) {
            return sourceUrl;
        }
        String normalizedSource = normalizeSourceUrl(sourceUrl);
        String encodedSource = Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(normalizedSource.getBytes(StandardCharsets.UTF_8));
        return (preview ? "/api/file/preview/" : "/api/file/download/") + encodedSource;
    }

    private String decodeSource(String encodedSource) {
        byte[] decoded = Base64.getUrlDecoder().decode(encodedSource);
        return new String(decoded, StandardCharsets.UTF_8);
    }

    private String buildPreviewTargetUrl(String sourceUrl) {
        String normalizedSource = normalizeSourceUrl(sourceUrl);
        URI uri = URI.create(normalizedSource);
        String rawPath = StrUtil.replace(uri.getRawPath(), "/api/file/download/", "/api/file/preview/");
        String rawQuery = removeActionQuery(uri.getRawQuery());

        UriComponentsBuilder builder = UriComponentsBuilder.fromUri(uri)
                .replacePath(rawPath)
                .replaceQuery(rawQuery);
        return builder.build(true).toUriString();
    }

    private String removeActionQuery(String rawQuery) {
        if (StrUtil.isBlank(rawQuery)) {
            return null;
        }
        List<String> preservedParams = new ArrayList<>();
        for (String queryPart : rawQuery.split("&")) {
            if (StrUtil.isBlank(queryPart)) {
                continue;
            }
            int separatorIndex = queryPart.indexOf('=');
            String key = separatorIndex >= 0 ? queryPart.substring(0, separatorIndex) : queryPart;
            if ("action".equalsIgnoreCase(key)) {
                continue;
            }
            preservedParams.add(queryPart);
        }
        return preservedParams.isEmpty() ? null : String.join("&", preservedParams);
    }

    private String normalizeSourceUrl(String sourceUrl) {
        if (StrUtil.isBlank(sourceUrl)) {
            return sourceUrl;
        }
        if (StrUtil.startWithAnyIgnoreCase(sourceUrl, "http://", "https://")) {
            return sourceUrl;
        }
        String relativePath = sourceUrl.startsWith("/") ? sourceUrl : "/" + sourceUrl;
        return buildAbilityModelUrl(relativePath);
    }

    private String buildAbilityModelUrl(String path) {
        String baseUrl = StrUtil.blankToDefault(appProperties.getAbilityModelServiceUrl(), DEFAULT_ABILITY_MODEL_SERVICE_URL);
        String normalizedBase = StrUtil.removeSuffix(baseUrl, "/");
        String normalizedPath = path.startsWith("/") ? path : "/" + path;
        return normalizedBase + normalizedPath;
    }

    private void writeRemoteResponse(ResponseEntity<byte[]> remoteResponse, HttpServletResponse response, boolean preview) throws IOException {
        response.setStatus(remoteResponse.getStatusCodeValue());

        HttpHeaders remoteHeaders = remoteResponse.getHeaders();
        MediaType contentType = remoteHeaders.getContentType();
        if (contentType != null) {
            response.setContentType(contentType.toString());
        }
        if (remoteHeaders.getContentLength() >= 0) {
            response.setContentLengthLong(remoteHeaders.getContentLength());
        }

        String disposition = remoteHeaders.getFirst(HttpHeaders.CONTENT_DISPOSITION);
        if (StrUtil.isBlank(disposition)) {
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, preview ? "inline" : "attachment");
        } else {
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, disposition);
        }

        byte[] body = remoteResponse.getBody();
        if (body == null || body.length == 0) {
            return;
        }

        try (OutputStream outputStream = response.getOutputStream()) {
            outputStream.write(body);
            outputStream.flush();
        }
    }
}
