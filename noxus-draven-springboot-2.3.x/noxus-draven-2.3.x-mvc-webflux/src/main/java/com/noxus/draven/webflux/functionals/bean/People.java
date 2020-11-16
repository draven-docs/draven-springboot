package com.noxus.draven.webflux.functionals.bean;

/**
 * 〈功能概述〉<br>
 *
 * @className: People
 * @package: com.noxus.draven.webflux.functionals.bean
 * @author: draven
 * @date: 2020/11/13 11:05
 */
public class People {

    public People() {

    }

    public People(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    private String name;
    private String mail;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
