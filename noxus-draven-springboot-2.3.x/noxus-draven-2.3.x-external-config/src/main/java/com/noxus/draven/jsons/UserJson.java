package com.noxus.draven.jsons;

import java.io.Serializable;

/**
 * 〈功能概述〉<br>
 *
 * @className: UserJson
 * @package: com.noxus.draven.jsons
 * @author: draven
 * @date: 2020/11/11 16:47
 */
public class UserJson implements Serializable {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
