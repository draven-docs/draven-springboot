package com.noxus.draven.starters.configuration;

import com.noxus.draven.starters.service.Formatter;
import com.noxus.draven.starters.service.impl.DefaultFormartImpl;
import com.noxus.draven.starters.service.impl.JackonFormatImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈功能概述〉<br>
 *
 * @className: FormatterAutoConfiguration
 * @package: com.noxus.draven.starters.configuration
 * @author: draven
 * @date: 2020/12/20 01:57
 */
@Configuration
public class FormatterAutoConfiguration {


    @Bean
    @ConditionalOnMissingClass(value = {"com.fasterxml.jackson.databind.ObjectMapper"})
    public Formatter defaulttFormatter() {
        return new DefaultFormartImpl();
    }

    @Bean
    @ConditionalOnClass(name = "com.fasterxml.jackson.databind.ObjectMapper")
    public Formatter jackonFormatter() {
        return new JackonFormatImpl();
    }


}
