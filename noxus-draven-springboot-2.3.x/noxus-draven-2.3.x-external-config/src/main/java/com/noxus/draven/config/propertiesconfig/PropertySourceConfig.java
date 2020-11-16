package com.noxus.draven.config.propertiesconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * 〈功能概述〉<br>
 *
 * @className: PropertySourceConfig
 * @package: com.noxus.draven.config.propertiesconfig
 * @author: draven
 * @date: 2020/11/11 16:04
 */
@Component
@ConfigurationProperties(prefix = "redis")
@PropertySource(value = "classpath:/config/redis.properties")
@Validated
public class PropertySourceConfig {


    @NotNull
    private String host;

    private String node;

    private Integer port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
