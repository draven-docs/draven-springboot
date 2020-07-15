package com.noxus.draven.pay.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by hai.dong on 2018/11/21.
 */
@Component
@ConfigurationProperties(prefix = "alipay")
public class AliPayConfig {
    private String appId;
    private String url;
    private String appPrivateKey;
    private String alipayPublicKey;
    private String charSet;
    private String format;
    private String notifyUrl;
    private String returnUrl;
    private String signType;
    private String paymentSuccessUrl;
    private String paymentFailUrl;

    public String getPaymentSuccessUrl() {
        return paymentSuccessUrl;
    }

    public void setPaymentSuccessUrl(String paymentSuccessUrl) {
        this.paymentSuccessUrl = paymentSuccessUrl;
    }

    public String getPaymentFailUrl() {
        return paymentFailUrl;
    }

    public void setPaymentFailUrl(String paymentFailUrl) {
        this.paymentFailUrl = paymentFailUrl;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppPrivateKey() {
        return appPrivateKey;
    }

    public void setAppPrivateKey(String appPrivateKey) {
        this.appPrivateKey = appPrivateKey;
    }

    public String getAlipayPublicKey() {
        return alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getCharSet() {
        return charSet;
    }

    public void setCharSet(String charSet) {
        this.charSet = charSet;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }
}
