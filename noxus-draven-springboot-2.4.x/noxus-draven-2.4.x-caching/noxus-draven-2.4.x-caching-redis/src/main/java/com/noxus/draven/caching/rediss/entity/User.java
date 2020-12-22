package com.noxus.draven.caching.rediss.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 〈功能概述〉<br>
 *
 * @className: User
 * @package: com.noxus.draven.caching.rediss.entity
 * @author: draven
 * @date: 2020/12/22 14:31
 */
@Data
//lombok依赖，可省略get set方法
public class User implements Serializable {

    private int userId;

    private String userName;

    private String userPassword;

    public User(int userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }
}


