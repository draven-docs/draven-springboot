package com.noxus.draven.plus;


import com.github.pagehelper.PageInfo;
import com.noxus.draven.plus.PlusApplication;
import com.noxus.draven.plus.entity.User;
import com.noxus.draven.plus.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/*
 * <p>
 * 前端控制器
 * </p>
 *
 * @author draven
 * @since 2020-01-11
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PlusApplication.class)
public class UserControllerTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);

    }

    @Test
    public void test() {
        int id = 1;
        User user = userMapper.selectById(id);
        System.out.println(user);
    }

    @Test
    public void testList() {
        List<User> users = userMapper.selectList(null);
        PageInfo<User> page = new PageInfo<User>(users);
        System.out.println(page);
    }


}

