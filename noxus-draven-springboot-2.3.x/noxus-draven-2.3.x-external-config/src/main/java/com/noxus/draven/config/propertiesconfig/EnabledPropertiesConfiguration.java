package com.noxus.draven.config.propertiesconfig;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈功能概述〉<br>
 *
 * @className: EnabledProperties
 * @package: com.noxus.draven.config.propertiesconfig
 * @author: draven
 * @date: 2020/11/11 15:23
 */
@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(EnabledProperties.class)
public class EnabledPropertiesConfiguration {


    private final EnabledProperties enabledProperties;

    public EnabledPropertiesConfiguration(EnabledProperties enabledProperties) {
        this.enabledProperties = enabledProperties;
    }

    @Bean
    public EnabledUser getUser() {
        EnabledUser enabledUser = new EnabledUser();
        enabledUser.setPassword(enabledProperties.getPassword());
        enabledUser.setUsername(enabledProperties.getUsername());
        return enabledUser;
    }

}
