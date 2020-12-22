package com.noxus.draven.deploy.jndi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jndi.JndiLocatorSupport;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 〈功能概述〉<br>
 *
 * @className: DataSourceConfig
 * @package: com.noxus.draven.deploy.jndi.config
 * @author: draven
 * @date: 2020/12/22 22:52
 */
@Configuration
@EnableConfigurationProperties
@Slf4j
public class DataSourceConfig {

    private static final String ENVVARLINUX = "linuxdeploy";
    private static final String ENVVARLOCAL = "localdeploy";
    @Value("${spring.datasource.jndi-name}")
    private String jndiName;

    @Value("${envs}")
    private String envs;


    @Bean("dataSource")
    @Primary
    public DataSource primaryDataSource() throws NamingException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        if (ENVVARLINUX.equals(envs)) {
            log.info("环境linux：{}", envs);
            bean.setJndiName(jndiName);
        } else if (ENVVARLOCAL.equals(envs)) {
            log.info("环境local：{}", envs);
            bean.setJndiName(JndiLocatorSupport.CONTAINER_PREFIX + jndiName);
        }
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
        return (DataSource) bean.getObject();
    }
}
