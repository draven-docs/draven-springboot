package com.noxus.draven.cxfserver.client;

import com.noxus.draven.cxfserver.interceptors.LoginInterceptor;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import javax.xml.namespace.QName;

/**
 * 〈功能概述〉<br>
 *
 * @className: CXFClient
 * @package: com.noxus.draven.cxfserver.client
 * @author: draven demo
 * @date: 2021/1/14 14:02
 */
public class CXFClient {

    /*public static void main(String[] args) {
        try {
            // 接口地址
            String address = "http://127.0.0.1:10090/soap/user?wsdl";
            // 代理工厂
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            jaxWsProxyFactoryBean.getOutInterceptors().add(new LoginInterceptor("root","admin"));;
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
    }*/

    public static void main(String[] args) {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        printInformation(dcf);
    }

    private static void printInformation(JaxWsDynamicClientFactory dcf) {
        Client client = dcf.createClient("http://127.0.0.1:10090/soap/user?wsdl");
        client.getOutInterceptors().add(new LoginInterceptor("root", "admin"));
        QName qName = new QName("");
        //Client client = dcf.createClient("http://127.0.0.1:10090/soap/user?wsdl",qName);
        Object[] object = new Object[0];
        try {
            object = client.invoke("getHello", "zhangsan");
            System.out.println(object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

}
