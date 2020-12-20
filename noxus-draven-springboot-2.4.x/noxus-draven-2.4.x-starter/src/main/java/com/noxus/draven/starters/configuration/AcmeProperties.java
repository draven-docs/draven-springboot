package com.noxus.draven.starters.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;

@ConfigurationProperties("acme")
public class AcmeProperties {

    private boolean checkLocation = false;

    private Date date = new Date();


    private String MyDemo = "demo";

    public boolean isCheckLocation() {
        return checkLocation;
    }

    public void setCheckLocation(boolean checkLocation) {
        this.checkLocation = checkLocation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMyDemo() {
        return MyDemo;
    }

    public void setMyDemo(String myDemo) {
        MyDemo = myDemo;
    }
}
