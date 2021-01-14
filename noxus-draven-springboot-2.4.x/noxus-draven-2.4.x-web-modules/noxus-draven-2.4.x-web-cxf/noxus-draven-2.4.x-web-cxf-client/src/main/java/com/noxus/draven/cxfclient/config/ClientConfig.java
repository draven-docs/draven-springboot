package com.noxus.draven.cxfclient.config;

import com.noxus.draven.cxfclient.interceptors.LoginInterceptor;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 〈功能概述〉<br>
 *
 * @className: ClientConfig
 * @package: com.noxus.draven.cxfclient.config
 * @author: draven
 * @date: 2021/1/13 16:24
 */
@Configuration
@Import(CxfClientProperties.class)
public class ClientConfig {


    @Autowired
    CxfClientProperties cxfClientProperties;

   /* @Bean
    public JaxWsDynamicClientFactory getDcf() {
        return JaxWsDynamicClientFactory.newInstance();
    }*/

    @Bean
    public Client getDynamicClient() {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(cxfClientProperties.getAddress());
        client.getOutInterceptors().add(this.getLoginInterceptor());
        return client;
    }

    @Bean
    public JaxWsProxyFactoryBean getClient() {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = this.jaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.getOutInterceptors().add(this.getLoginInterceptor());
        jaxWsProxyFactoryBean.setAddress(cxfClientProperties.getAddress());
        return jaxWsProxyFactoryBean;
    }


    @Bean
    public LoginInterceptor getLoginInterceptor() {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        loginInterceptor.setPassword(cxfClientProperties.getPassword());
        loginInterceptor.setUsername(cxfClientProperties.getUsername());
        return loginInterceptor;
    }

    @Bean
    protected JaxWsProxyFactoryBean jaxWsProxyFactoryBean() {
        return new JaxWsProxyFactoryBean();
    }

}



