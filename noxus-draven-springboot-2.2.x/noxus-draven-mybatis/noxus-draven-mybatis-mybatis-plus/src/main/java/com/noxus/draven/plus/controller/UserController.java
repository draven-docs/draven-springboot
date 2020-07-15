package com.noxus.draven.plus.controller;


import com.noxus.draven.plus.entity.User;
import com.noxus.draven.plus.mapper.UserMapper;
import com.noxus.draven.plus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author draven
 * @since 2020-01-11
 */
@RestController
@RequestMapping("/plus/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public User test() {
        User user = userMapper.selectOnes();
        return user;
    }

}

