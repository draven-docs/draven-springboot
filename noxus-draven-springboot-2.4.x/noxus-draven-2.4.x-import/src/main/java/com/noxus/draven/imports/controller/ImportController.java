package com.noxus.draven.imports.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @className: ImportController
 * @package: com.noxus.draven.two.four.x.imports.controller.config
 * @author: draven
 * @date: 2020/11/13 13:10
 */
@RestController
@RequestMapping
public class ImportController {

    @Value("${default.demo}")
    String defaultDemo;

//    @Value("${test.demo}")
//    String testDemo;

    @Value("${demo}")
    String demo;

    @GetMapping("imports")
    public String imports() {
        String testDemo = "testDemo";
        return defaultDemo + "：" + demo + ": " + testDemo;
    }
}
