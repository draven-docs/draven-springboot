package com.noxus.draven.starters.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noxus.draven.starters.service.Formatter;

/**
 * 〈功能概述〉<br>
 *
 * @className: JackonImpl
 * @package: com.noxus.draven.starters.service.impl
 * @author: draven
 * @date: 2020/12/20 02:43
 */
public class JackonFormatImpl implements Formatter {

    private final ObjectMapper objectMapper;

    public JackonFormatImpl() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public String format(Object object) throws Exception {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new Exception(e);
        }
    }
}
