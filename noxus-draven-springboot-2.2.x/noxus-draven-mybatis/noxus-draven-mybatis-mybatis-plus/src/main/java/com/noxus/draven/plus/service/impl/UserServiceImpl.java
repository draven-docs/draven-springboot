package com.noxus.draven.plus.service.impl;

import com.noxus.draven.plus.entity.User;
import com.noxus.draven.plus.mapper.UserMapper;
import com.noxus.draven.plus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author draven
 * @since 2020-01-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
