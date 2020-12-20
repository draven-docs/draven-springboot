package com.noxus.draven.starters.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noxus.draven.starters.configuration.AcmeProperties;
import com.noxus.draven.starters.service.Formatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 〈功能概述〉<br>
 *
 * @className: JackonImpl
 * @package: com.noxus.draven.starters.service.impl
 * @author: draven
 * @date: 2020/12/20 02:43
 */
@Service
@EnableConfigurationProperties(AcmeProperties.class)
@Slf4j
public class JackonFormatImpl implements Formatter {

    @Autowired
    private AcmeProperties acmeProperties;

    @Autowired
    private ObjectMapper objectMapper;

    public JackonFormatImpl() {

    }

    public JackonFormatImpl(AcmeProperties acmeProperties) {
        this.acmeProperties = acmeProperties;
    }

    @Override
    public String format(Object object) throws Exception {
        try {
            Date date = acmeProperties.getDate();
            boolean checkLocation = acmeProperties.isCheckLocation();
            String myDemo = acmeProperties.getMyDemo();
            log.info("{} {} {} ",checkLocation,date,myDemo);
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }

}
