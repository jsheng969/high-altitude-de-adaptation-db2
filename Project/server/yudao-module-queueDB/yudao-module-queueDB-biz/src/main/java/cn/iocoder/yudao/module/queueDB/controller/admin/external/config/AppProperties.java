package cn.iocoder.yudao.module.queueDB.controller.admin.external.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "base")
public class AppProperties {

    private String rServiceUrl;
    private String sharedRoot;
    private String inputDir;

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

    public void setInputDir(String inputDir) {
        this.inputDir = inputDir;
    }
}
