package com.noxus.draven.cxfclient.controller;

import com.noxus.draven.cxfclient.config.ClientConfig;
import com.noxus.draven.cxfclient.service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈功能概述〉<br>
 *
 * @className: CxfClientController
 * @package: com.noxus.draven.cxfclient.controller
 * @author: draven
 * @date: 2021/1/13 16:22
 */

@RestController
@RequestMapping
public class CxfClientController {

    @Autowired
    private ClientConfig clientConfig;

    @Autowired
    private Impl impl;


    @RequestMapping("client")
    public List<Object> client() throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name","names");
        List<Object> ob = impl.parase("",map);
        return ob;
    }

    @RequestMapping("clients")
    public Object clients() throws Exception {
        Map<Object, Object> map = new HashMap<>();
        map.put("name","names");
        Object ob = impl.parases("getHello",map);
        return ob;
    }

}
