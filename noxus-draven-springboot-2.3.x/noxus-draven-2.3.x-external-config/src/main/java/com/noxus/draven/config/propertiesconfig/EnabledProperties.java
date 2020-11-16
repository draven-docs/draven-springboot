package com.noxus.draven.config.propertiesconfig;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author draven
 */
//@Component
@ConfigurationProperties("enabled")
public class EnabledProperties {

    private String username;
    private String password;

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
