package com.noxus.draven.cxfclient.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.noxus.draven.cxfclient.service.UserService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 〈功能概述〉<br>
 *
 * @className: ParaseCxf
 * @package: com.noxus.draven.cxfclient.config
 * @author: draven
 * @date: 2021/1/13 16:56
 */
@Component
public class ParaseCxf {

    @Autowired
    private ClientConfig clientConfig;

    @Autowired
    ObjectMapper objectMapper;

    public List<Object> parase(String method, Map params) throws Exception {
        String paramss = params.toString();
        paramss = objectMapper.writeValueAsString(params);
        Client dynamicClient = clientConfig.getDynamicClient();
        Object[] invoke = dynamicClient.invoke(method, paramss);
        List<Object> objects = Arrays.asList(invoke);
        return objects;
    }


    public Object parases(String method, Map params) throws Exception {
        String paramss = params.toString();
        paramss = objectMapper.writeValueAsString(params);
        JaxWsProxyFactoryBean client = clientConfig.getClient();
        client.setServiceClass(UserService.class);
        UserService us = (UserService) client.create();
        // 调用代理接口的方法调用并返回结果
        String result = us.getHello(paramss);
        System.out.println("返回结果:" + result);
        Map map = objectMapper.readValue(result, Map.class);
        return map;
    }

}
