package com.noxus.draven.mybatis.controller;

import com.noxus.draven.mybatis.entity.User;
import com.noxus.draven.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/test")
    public List<User> test() {

        return userMapper.selectfromUser();
    }
}
