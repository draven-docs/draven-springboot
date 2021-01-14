package com.noxus.draven.cxfclient;

import com.noxus.draven.cxfclient.interceptors.LoginInterceptor;
import com.noxus.draven.cxfclient.service.UserService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class CXFClient {

    /*public static void main(String[] args) {

    }*/

    public static void main(String[] args) {
        printInformation();
        client();
    }

    //JaxWsDynamicClientFactory dcf
    private static void printInformation() {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();

        Client client = dcf.createClient("http://127.0.0.1:10090/soap/user?wsdl");
        client.getOutInterceptors().add(new LoginInterceptor());
        Object[] object = new Object[0];
        try {
            object = client.invoke("getHello", "zhangsan");
            System.out.println(object[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void client() {
        try {
            // 接口地址
            String address = "http://127.0.0.1:10090/soap/user?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            jaxWsProxyFactoryBean.getOutInterceptors().add(new LoginInterceptor());
            // 设置代理地址
            jaxWsProxyFactoryBean.setAddress(address);
            // 设置接口类型
            jaxWsProxyFactoryBean.setServiceClass(UserService.class);
            // 创建一个代理接口实现
            UserService us = (UserService) jaxWsProxyFactoryBean.create();
            // 数据准备
            String name = "zhang";
            // 调用代理接口的方法调用并返回结果
            String result = us.getHello(name);
            System.out.println("返回结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
