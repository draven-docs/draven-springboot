package com.noxus.draven.starters.service.impl;

import com.noxus.draven.starters.service.Formatter;
import org.springframework.stereotype.Service;

/**
 * 〈功能概述〉<br>
 *
 * @className: DefaultFormartImpl
 * @package: com.noxus.draven.starters.service.impl
 * @author: draven
 * @date: 2020/12/20 01:56
 */
@Service
public class DefaultFormartImpl implements Formatter {
    @Override
    public String format(Object object) {
        return String.valueOf(object);
    }
}
