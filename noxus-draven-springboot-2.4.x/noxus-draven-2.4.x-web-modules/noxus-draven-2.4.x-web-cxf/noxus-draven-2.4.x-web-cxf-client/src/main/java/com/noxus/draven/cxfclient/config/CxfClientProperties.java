package com.noxus.draven.cxfclient.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 〈功能概述〉<br>
 *
 * @className: CxfClientProperties
 * @package: com.noxus.draven.cxfclient.config
 * @author: draven
 * @date: 2021/1/13 16:39
 */
@Component
@ConfigurationProperties(prefix = "cxfclient")
@PropertySource(value = "classpath:cxfClient.properties")
@Order(-1)
public class CxfClientProperties {

    private String targetNamespace;

    private String address;

    private String username;

    private String password;


    public String getTargetNamespace() {
        return targetNamespace;
    }

    public void setTargetNamespace(String targetNamespace) {
        this.targetNamespace = targetNamespace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
