package com.noxus.draven.hibernate.repository;

import com.noxus.draven.hibernate.config.dynamic.DataSource;
import com.noxus.draven.hibernate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    //默认数据源
    @DataSource
    int updates(User user);


    @DataSource("slave2")
    List<User> selectAlls();

    @DataSource
    int saves(User user);

    @DataSource
    int deleteByIds(long l);

    //slave1
    @DataSource("slave1")
    User selectByIds(long l);
}
