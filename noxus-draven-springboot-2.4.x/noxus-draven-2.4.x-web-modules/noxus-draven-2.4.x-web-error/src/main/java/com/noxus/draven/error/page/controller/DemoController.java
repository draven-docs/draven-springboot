package com.noxus.draven.error.page.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈功能概述〉<br>
 *
 * @className: DemoController
 * @package: com.noxus.draven.controller
 * @author: draven
 * @date: 2020/12/24 14:34
 */

@RestController
@RequestMapping
public class DemoController {

    @RequestMapping("/demo")
    public String demo() {
        return "12345";
    }
}
