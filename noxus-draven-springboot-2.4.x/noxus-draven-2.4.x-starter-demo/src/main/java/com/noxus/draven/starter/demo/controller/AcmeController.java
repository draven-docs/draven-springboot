package com.noxus.draven.starter.demo.controller;

import com.noxus.draven.starters.service.Formatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 〈功能概述〉<br>
 *
 * @className: AcmeController
 * @package: com.noxus.draven.starter.demo.controller
 * @author: draven
 * @date: 2020/12/20 03:46
 */

@RestController
@RequestMapping
public class AcmeController {

    @Value("${acme.checkLocation}")
    private String checkLocation;

    @Autowired
    private Formatter formatter;

    @RequestMapping("test")
    public String test() throws Exception {
        Date date = new Date();
        long time = date.getTime();
        Map<Object, Object> data = new HashMap<>();
        data.put("name", "demo");

        String format = formatter.format(data);
        String demo = "demo";
        demo = demo + ":" + checkLocation + ":" + format;
        return demo;
    }
}

