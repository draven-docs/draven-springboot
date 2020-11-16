package com.noxus.draven.names;

import com.noxus.draven.names.config.SampleConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 〈功能概述〉<br>
 *
 * @className: NameApplication
 * @package: com.noxus.draven.names
 * @author: draven
 * @date: 2020/11/13 19:10
 */
@SpringBootApplication
public class NameApplication {


    public NameApplication(SampleConfigurationProperties sampleConfigurationProperties) {
        this.sampleConfigurationProperties = sampleConfigurationProperties;
    }

    public static void main(String[] args) {
        SpringApplication.run(NameApplication.class, args);
    }


    private final SampleConfigurationProperties sampleConfigurationProperties;


    public String test() {
        return sampleConfigurationProperties.toString();
    }


}
