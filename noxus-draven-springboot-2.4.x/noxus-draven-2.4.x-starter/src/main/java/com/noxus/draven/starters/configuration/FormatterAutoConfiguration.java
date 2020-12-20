package com.noxus.draven.starters.configuration;

import com.noxus.draven.starters.service.Formatter;
import com.noxus.draven.starters.service.impl.DefaultFormartImpl;
import com.noxus.draven.starters.service.impl.JackonFormatImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * 〈功能概述〉<br>
 *
 * @className: FormatterAutoConfiguration
 * @package: com.noxus.draven.starters.configuration
 * @author: draven
 * @date: 2020/12/20 01:57
 */
@Configuration
@EnableConfigurationProperties(AcmeProperties.class)
@ConditionalOnClass(Formatter.class)
@Slf4j
public class FormatterAutoConfiguration {

    private final AcmeProperties acmeProperties;

    public FormatterAutoConfiguration(AcmeProperties acmeProperties) {
        this.acmeProperties = acmeProperties;
    }

    @Bean
    @ConditionalOnMissingBean(DefaultFormartImpl.class)
    @ConditionalOnMissingClass(value = {"com.fasterxml.jackson.databind.ObjectMapper"})
    @ConditionalOnProperty(prefix = "acme", value = "checkLocation", havingValue = "true")
    public Formatter defaulttFormatter() {
        Date date = acmeProperties.getDate();
        boolean checkLocation = acmeProperties.isCheckLocation();
        String myDemo = acmeProperties.getMyDemo();
        return new DefaultFormartImpl();
    }

    @Bean
    @ConditionalOnMissingBean(JackonFormatImpl.class)
    @ConditionalOnClass(name = "com.fasterxml.jackson.databind.ObjectMapper")
    @ConditionalOnProperty(prefix = "acme", value = "checkLocation", havingValue = "false")
    public Formatter jackonFormatter() {
        Date date = acmeProperties.getDate();
        boolean checkLocation = acmeProperties.isCheckLocation();
        String myDemo = acmeProperties.getMyDemo();
        log.info("{}","{}","{}",checkLocation,date,myDemo);
        JackonFormatImpl jackonFormat = new JackonFormatImpl(acmeProperties);
        return new JackonFormatImpl();
    }
}
