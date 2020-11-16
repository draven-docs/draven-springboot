package com.noxus.draven.names.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.stereotype.Component;

//@Configuration
@Component
@ConfigurationProperties(prefix = "sample")
public class SampleConfigurationProperties {

    //@Value("${import}")

    private final String importValue;

    public SampleConfigurationProperties(@Name("import") String importValue) {
        this.importValue = importValue;
    }

    public String getImportValue() {
        return importValue;
    }

    /*public void setImportValue(String importValue) {
        this.importValue = importValue;
    }*/

//    public SampleConfigurationProperties(@Name("import") String importValue) {
//
//        this.importValue = importValue;
//    }

}
