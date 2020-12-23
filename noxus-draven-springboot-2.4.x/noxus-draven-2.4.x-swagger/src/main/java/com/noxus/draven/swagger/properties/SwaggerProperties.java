package com.noxus.draven.swagger.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 〈功能概述〉<br>
 *
 * @className: SwaggerProperties
 * @package: com.noxus.draven.swagger.properties
 * @author: draven
 * @date: 2020/12/23 09:11
 */
//@EnableConfigurationProperties
@Component
@ConfigurationProperties("swagger")
public class SwaggerProperties {


    private static final String SWAGGER_AUTHOR = "draven";

    private static final String SWAGGER_EMAIL = "123456@123.com";

    /**
     * 是否开启swagger，生产环境一般关闭，所以这里定义一个变量
     */
    private Boolean enable;

    /**
     * 项目应用名
     */
    private String applicationName;

    /**
     * 项目版本信息
     */
    private String applicationVersion;

    /**
     * 项目描述信息
     */
    private String applicationDescription;

    /**
     * 扫描包路径
     */
    private String scans;

    /**
     * 接口调试地址
     */
    private String tryHost;

    /**
     * 作者信息
     */
    private String author = SWAGGER_AUTHOR;

    /**
     * email
     */
    private String email = SWAGGER_EMAIL;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getApplicationDescription() {
        return applicationDescription;
    }

    public void setApplicationDescription(String applicationDescription) {
        this.applicationDescription = applicationDescription;
    }

    public String getTryHost() {
        return tryHost;
    }

    public void setTryHost(String tryHost) {
        this.tryHost = tryHost;
    }

    public String getScans() {
        return scans;
    }

    public void setScans(String scans) {
        this.scans = scans;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

