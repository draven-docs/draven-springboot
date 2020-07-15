package com.noxus.draven.hibernate.controller;

import com.noxus.draven.hibernate.repository.primary.UserPrimaryRepository;
import com.noxus.draven.hibernate.repository.second.UserSecondRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserPrimaryRepository userPrimaryRepository;
    @Autowired
    private UserSecondRepository userSecondRepository;

    @RequestMapping("/hello")
    public List<Map<String, Object>> hello() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM user ", new Object[]{});
        return list;
    }

    @RequestMapping("/contextLoads")
    public void contextLoads() {
        System.out.println(userPrimaryRepository.findAll());
        System.out.println(userSecondRepository.findAll());
    }
}
