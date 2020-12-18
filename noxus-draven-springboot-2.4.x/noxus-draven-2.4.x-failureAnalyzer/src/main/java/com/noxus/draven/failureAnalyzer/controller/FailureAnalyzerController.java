package com.noxus.draven.failureAnalyzer.controller;

import com.noxus.draven.failureAnalyzer.exception.CheckException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @className: FailureAnalyzerController
 * @package: com.noxus.draven.failureAnalyzer.controller
 * @author: draven
 * @date: 2020/12/18 14:46
 */
@RestController
@RequestMapping
public class FailureAnalyzerController {


    @RequestMapping("/hello")
    public String test() {
        String hello = "hello";
        try {
            int i = 1;
            i = i / 0;
        } catch (Exception e) {
            throw new CheckException("失败分析案例");
        }
        return hello;
    }
}
