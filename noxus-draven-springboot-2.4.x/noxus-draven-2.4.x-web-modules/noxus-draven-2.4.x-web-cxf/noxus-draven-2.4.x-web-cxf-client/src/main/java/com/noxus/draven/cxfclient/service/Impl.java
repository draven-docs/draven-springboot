package com.noxus.draven.cxfclient.service;

import com.noxus.draven.cxfclient.annotations.AspectAnnot;
import com.noxus.draven.cxfclient.config.ParaseCxf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈功能概述〉<br>
 *
 * @className: impl
 * @package: com.noxus.draven.cxfclient.service
 * @author: draven
 * @date: 2021/1/13 17:37
 */
@Service
public class Impl {

    @Autowired
    private ParaseCxf paraseCxf;


    @AspectAnnot(method = "getHello")
    public List<Object> parase(String method,HashMap<Object, Object> map) throws Exception {
        List<Object> parase = paraseCxf.parase(method, map);
        return parase;
    }

    @AspectAnnot(method = "getHello",args = UserService.class)
    public Object parases(String method, Map<Object, Object> map) throws Exception {
        Object parases = paraseCxf.parases(method, map);
        return parases;
    }



}
