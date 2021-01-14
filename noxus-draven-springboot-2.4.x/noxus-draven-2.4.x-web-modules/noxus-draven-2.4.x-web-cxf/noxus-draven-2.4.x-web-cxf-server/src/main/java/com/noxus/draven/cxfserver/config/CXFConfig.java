package com.noxus.draven.cxfserver.config;

import com.noxus.draven.cxfserver.interceptors.CxfAuthInterceptor;
import com.noxus.draven.cxfserver.service.UserService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @author draven
 */
@Configuration
public class CXFConfig {

    @Autowired
    private Bus bus;


    @Autowired
    private UserService userService;

    /**
     * 此方法被注释后:wsdl访问地址为http://127.0.0.1:8080/services/user?wsdl
     * 去掉注释后：wsdl访问地址为：http://127.0.0.1:8080/soap/user?wsdl
     * dispatcherServlet
     */
    @Bean
    public ServletRegistrationBean createServletRegistrationBean() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
    }


  /*  @Bean(name = Bus.DEFAULT_BUS_ID)
    public isd springBus() {
        String id = new SpringBus().getId();
        return null;
    }*/

    /**
     * 发布服务
     * 指定访问url
     *
     * @return
     */
    @Bean
    public Endpoint userEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, userService);
        endpoint.getInInterceptors().add(new CxfAuthInterceptor());//添加校验拦截器
        endpoint.publish("/user");
        return endpoint;
    }
}