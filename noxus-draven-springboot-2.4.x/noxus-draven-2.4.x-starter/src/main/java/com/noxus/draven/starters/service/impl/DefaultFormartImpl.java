package com.noxus.draven.starters.service.impl;

import com.noxus.draven.starters.configuration.AcmeProperties;
import com.noxus.draven.starters.service.Formatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 〈功能概述〉<br>
 *
 * @className: DefaultFormartImpl
 * @package: com.noxus.draven.starters.service.impl
 * @author: draven
 * @date: 2020/12/20 01:56
 */
@Service
@Slf4j
public class DefaultFormartImpl implements Formatter {

    @Autowired
    private AcmeProperties acmeProperties;

    public DefaultFormartImpl() {

    }


    @Override
    public String format(Object object) {
        Date date = acmeProperties.getDate();
        boolean checkLocation = acmeProperties.isCheckLocation();
        String myDemo = acmeProperties.getMyDemo();
        log.info("{} {} {} ", checkLocation, date, myDemo);
        return String.valueOf(object);
    }
}
