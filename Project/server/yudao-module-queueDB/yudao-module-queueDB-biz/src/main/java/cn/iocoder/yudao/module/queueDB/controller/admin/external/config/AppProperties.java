package cn.iocoder.yudao.module.queueDB.controller.admin.external.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "base")
public class AppProperties {

    private String rServiceUrl;
    private String sharedRoot;
    private String rSharedRoot;
    private String inputDir;

    private String outputDir;

    private String pluginsDir;

    private String abilityModelServiceUrl;

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

    public String getrSharedRoot() {
        return rSharedRoot;
    }

    public void setrSharedRoot(String rSharedRoot) {
        this.rSharedRoot = rSharedRoot;
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

    public String getPluginsDir() {
        return pluginsDir;
    }

    public void setPluginsDir(String pluginsDir) {
        this.pluginsDir = pluginsDir;
    }

    public String getAbilityModelServiceUrl() {
        return abilityModelServiceUrl;
    }

    public void setAbilityModelServiceUrl(String abilityModelServiceUrl) {
        this.abilityModelServiceUrl = abilityModelServiceUrl;
    }
}
