package cn.iocoder.yudao.module.queueDB.controller.admin.external.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "base")
public class AppProperties {

    private String rServiceUrl;
    private String sharedRoot;
    private String inputDir;

    private String outputDir;

    public String getrServiceUrl() {
        return rServiceUrl;
    }

    public void setrServiceUrl(String rServiceUrl) {
        this.rServiceUrl = rServiceUrl;
    }

    public String getSharedRoot() {
        return sharedRoot;
    }

    public void setSharedRoot(String sharedRoot) {
        this.sharedRoot = sharedRoot;
    }

    public String getInputDir() {
        return inputDir;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setInputDir(String inputDir) {
        this.inputDir = inputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }
}
