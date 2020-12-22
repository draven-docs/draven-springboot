package com.noxus.draven.deploy.jndi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 〈功能概述〉<br>
 *
 * @className: JndiController
 * @package: com.noxus.draven.deploy.jndi.controller
 * @author: draven
 * @date: 2020/12/22 22:55
 */
@RestController
@RequestMapping
@Slf4j
public class JndiController {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/jndi")
    public Object jndi() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * FROM nacos14.config_info");
        log.info("获取值：{}", null == maps ? "0" : maps.size());
        return maps;
    }
}
