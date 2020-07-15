package com.noxus.draven.tk.controller;

import com.noxus.draven.tk.entity.User;
import com.noxus.draven.tk.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("test")
    public List<User> test() {
        return userMapper.selectAll();
    }
}
