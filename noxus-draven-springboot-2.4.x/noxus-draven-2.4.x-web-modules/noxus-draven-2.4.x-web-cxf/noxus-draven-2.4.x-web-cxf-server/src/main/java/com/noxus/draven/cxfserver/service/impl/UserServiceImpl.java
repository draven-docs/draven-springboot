package com.noxus.draven.cxfserver.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.noxus.draven.cxfserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author draven
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public String getHello(String paramss) throws JsonProcessingException {
        Map map = objectMapper.readValue(paramss, Map.class);
        String param = objectMapper.writeValueAsString(map);
        return param;
    }
}
