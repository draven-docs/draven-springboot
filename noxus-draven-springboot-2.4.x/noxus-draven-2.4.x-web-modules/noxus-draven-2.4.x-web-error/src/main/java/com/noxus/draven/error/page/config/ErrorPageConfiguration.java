package com.noxus.draven.error.page.config;

/**
 * 〈功能概述〉<br>
 * 此配置可用 可读取图片
 *
 * @className: ErrorConfiguration
 * @package: com.noxus.draven.config
 * @author: draven
 * @date: 2020/12/24 14:30
 */

/*
@Configuration
public class ErrorPageConfiguration {
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }
}*/

/*
@Configuration
public class ErrorPageConfiguration {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                ErrorPage errorPage1 = new ErrorPage(HttpStatus.NOT_FOUND, "/page/error/4xx.html");
                ErrorPage errorPage2 = new ErrorPage(HttpStatus.NOT_FOUND, "/page/error/5xx.html");
                factory.addErrorPages(errorPage1, errorPage2);
            }
        };
    }
}*/
