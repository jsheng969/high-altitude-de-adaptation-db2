package cn.iocoder.yudao.module.queueDB.service.external;

import cn.iocoder.yudao.module.queueDB.controller.admin.external.config.AppProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

@Service
public class RReportServiceImpl implements RReportService {

    @Autowired
    private AppProperties appProperties;

    private final RestTemplate restTemplate = new RestTemplate();

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map run(String type, MultipartFile trainFile, MultipartFile validFile) throws Exception {
        String reportType = normalizeType(type);

        String taskId = reportType + "_task_" + UUID.randomUUID().toString().replace("-", "");

        boolean useDefaultTrain = true;
        boolean useDefaultValid = true;

        String trainPath = "";
        String validPath = "";

        File inputDir = new File(appProperties.getInputDir());
        if (!inputDir.exists()) {
            inputDir.mkdirs();
        }

        if (trainFile != null && !trainFile.isEmpty()) {
            File file = new File(appProperties.getInputDir() + "/" + taskId + "_train.sav");
            trainFile.transferTo(file);
            trainPath = file.getAbsolutePath();
            useDefaultTrain = false;
        }

        if (validFile != null && !validFile.isEmpty()) {
            File file = new File(appProperties.getInputDir() + "/" + taskId + "_valid.sav");
            validFile.transferTo(file);
            validPath = file.getAbsolutePath();
            useDefaultValid = false;
        }

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("task_id", taskId);
        body.put("use_default_train", useDefaultTrain);
        body.put("use_default_valid", useDefaultValid);

        if (!useDefaultTrain) {
            body.put("train_file", trainPath);
        }

        if (!useDefaultValid) {
            body.put("valid_file", validPath);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<Map<String, Object>>(body, headers);

        String rUrl = appProperties.getrServiceUrl() +"/run/" + reportType;

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(
                    rUrl,
                    request,
                    Map.class
            );
            Map result = response.getBody();
            if (result == null) {
                return new HashMap();
            }
            result.put("report_type", reportType);
            return result;
        } catch (HttpStatusCodeException e) {
            try {
                Map result = objectMapper.readValue(e.getResponseBodyAsString(), Map.class);
                result.put("report_type", reportType);
                return result;
            } catch (Exception ex) {
                Map<String, Object> result = new HashMap<>();
                result.put("success", false);
                result.put("report_type", reportType);
                result.put("message", e.getResponseBodyAsString());
                return result;
            }
        }
    }

    @Override
    public Map getResult(String type, String taskId) {
        String reportType = normalizeType(type);

        String url = appProperties.getrServiceUrl() +"/result?task_id=" + taskId + "&type=" + reportType;
        Map raw = restTemplate.getForObject(url, Map.class);

        if (raw == null) {
            return new HashMap();
        }

        raw.put("report_type", firstString(raw.get("report_type"), reportType));
        raw.put("generated_at", firstString(raw.get("generated_at")));
        raw.put("task_id", firstString(raw.get("task_id")));
        raw.put("model_formula", firstString(raw.get("model_formula")));

        Object successObj = raw.get("success");
        if (successObj instanceof List && !((List) successObj).isEmpty()) {
            raw.put("success", ((List) successObj).get(0));
        }

        String pdfPath = firstString(raw.get("pdf"));
        if (pdfPath != null && !"".equals(pdfPath)) {
            raw.put("pdf", buildPreviewUrl(reportType, taskId, new File(pdfPath).getName()));
        } else {
            raw.put("pdf", "");
        }

        Object chartsObj = raw.get("charts");
        List<Map<String, Object>> newCharts = new ArrayList<Map<String, Object>>();

        if (chartsObj instanceof List) {
            List charts = (List) chartsObj;
            for (Object item : charts) {
                if (!(item instanceof Map)) {
                    continue;
                }

                Map chart = (Map) item;

                String key = firstString(chart.get("key"));
                String name = firstString(chart.get("name"));
                String path = firstString(chart.get("path"));

                Map<String, Object> newChart = new HashMap<String, Object>();
                newChart.put("key", key);
                newChart.put("name", name);
                newChart.put("path", path);

                if (path != null && !"".equals(path)) {
                    String fileName = new File(path).getName();
                    newChart.put("url", buildPreviewUrl(reportType, taskId, fileName));
                } else {
                    newChart.put("url", "");
                }

                newCharts.add(newChart);
            }
        }

        raw.put("charts", newCharts);
        return raw;
    }

    @Override
    public Map getTasks(String type) {
        String reportType = normalizeType(type);
        String url = appProperties.getrServiceUrl() +"/tasks?type=" + reportType;
        Map raw = restTemplate.getForObject(url, Map.class);

        if (raw == null) {
            return new HashMap();
        }

        Object tasksObj = raw.get("tasks");
        if (tasksObj instanceof List) {
            List tasks = (List) tasksObj;
            List<Map<String, Object>> newTasks = new ArrayList<Map<String, Object>>();

            for (Object item : tasks) {
                if (!(item instanceof Map)) {
                    continue;
                }

                Map task = (Map) item;
                Map<String, Object> newTask = new HashMap<String, Object>();

                String taskId = firstString(task.get("task_id"));
                String pdfPath = firstString(task.get("pdf"));

                newTask.put("task_id", taskId);
                newTask.put("report_type", reportType);
                newTask.put("generated_at", firstString(task.get("generated_at")));

                Object successObj = task.get("success");
                if (successObj instanceof List && !((List) successObj).isEmpty()) {
                    newTask.put("success", ((List) successObj).get(0));
                } else {
                    newTask.put("success", successObj);
                }

                if (pdfPath != null && !"".equals(pdfPath)) {
                    newTask.put("pdf", buildPreviewUrl(reportType, taskId, new File(pdfPath).getName()));
                } else {
                    newTask.put("pdf", "");
                }

                newTasks.add(newTask);
            }

            raw.put("tasks", newTasks);
        }

        raw.put("report_type", reportType);
        return raw;
    }

    private String buildPreviewUrl(String type, String taskId, String fileName) {
        return "/external/report/file/" + type + "/" + taskId + "/" + fileName;
    }

    private String normalizeType(String type) {
        if ("chronic".equalsIgnoreCase(type)) {
            return "chronic";
        }
        return "acute";
    }

    private String firstString(Object obj) {
        return firstString(obj, "");
    }

    private String firstString(Object obj, String defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.isEmpty() || list.get(0) == null) {
                return defaultValue;
            }
            return String.valueOf(list.get(0));
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            Object path = map.get("path");
            if (path != null) {
                return firstString(path, defaultValue);
            }
            Object url = map.get("url");
            if (url != null) {
                return firstString(url, defaultValue);
            }
        }
        return String.valueOf(obj);
    }
}