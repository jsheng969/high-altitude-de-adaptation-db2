package cn.iocoder.yudao.module.queueDB.controller.admin.external.dto;

import java.util.List;
import java.util.Map;

public class RunReportResponse {
    private boolean success;
    private String taskId;
    private String generatedAt;
    private Map<String, String> inputs;
    private String pdf;
    private List<Map<String, String>> charts;
    private Map<String, Object> metrics;
    private String modelFormula;
    private Map<String, Object> vif;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(String generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Map<String, String> getInputs() {
        return inputs;
    }

    public void setInputs(Map<String, String> inputs) {
        this.inputs = inputs;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public List<Map<String, String>> getCharts() {
        return charts;
    }

    public void setCharts(List<Map<String, String>> charts) {
        this.charts = charts;
    }

    public Map<String, Object> getMetrics() {
        return metrics;
    }

    public void setMetrics(Map<String, Object> metrics) {
        this.metrics = metrics;
    }

    public String getModelFormula() {
        return modelFormula;
    }

    public void setModelFormula(String modelFormula) {
        this.modelFormula = modelFormula;
    }

    public Map<String, Object> getVif() {
        return vif;
    }

    public void setVif(Map<String, Object> vif) {
        this.vif = vif;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}