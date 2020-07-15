package com.noxus.draven.activity;

import org.activiti.app.conf.ApplicationConfiguration;
import org.activiti.app.servlet.ApiDispatcherServletConfiguration;
import org.activiti.app.servlet.AppDispatcherServletConfiguration;
import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication(exclude = {
        SecurityAutoConfiguration.class,
        org.activiti.spring.boot.SecurityAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@Import({ApplicationConfiguration.class})
public class ActivityApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ActivityApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ActivityApplication.class);
    }

    @Bean
    public ServletRegistrationBean apiDispatcher() {
        DispatcherServlet api = new DispatcherServlet();
        api.setContextClass(AnnotationConfigWebApplicationContext.class);
        api.setContextConfigLocation(ApiDispatcherServletConfiguration.class.getName());
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(api);
        registrationBean.addUrlMappings("/api/*");
        registrationBean.setLoadOnStartup(1);
        registrationBean.setAsyncSupported(true);
        registrationBean.setName("api");
        return registrationBean;
    }

    // app登录、访问需要
    @Bean
    public ServletRegistrationBean appDispatcher() {
        DispatcherServlet app = new DispatcherServlet();
        app.setContextClass(AnnotationConfigWebApplicationContext.class);
        app.setContextConfigLocation(AppDispatcherServletConfiguration.class.getName());
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setServlet(app);
        registrationBean.addUrlMappings("/app/*");
        registrationBean.setLoadOnStartup(1);
        registrationBean.setAsyncSupported(true);
        registrationBean.setName("app");
        return registrationBean;
    }
//    @Bean
//    public CommandLineRunner init(final RepositoryService repositoryService,
//                                  final RuntimeService runtimeService,
//                                  final TaskService taskService) {
//
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... strings) throws Exception {
//                System.out.println("Number of process definitions : "
//                        + repositoryService.createProcessDefinitionQuery().count());
//                System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
//                runtimeService.startProcessInstanceByKey("oneTaskProcess");
//                System.out.println("Number of tasks after process start: " + taskService.createTaskQuery().count());
//            }
//        };
//    }


//    @Bean
//    public DataSource database() {
//        return DataSourceBuilder.create()
//                .url("jdbc:mysql://116.196.77.250:303206/activiti?characterEncoding=UTF-8")
//                .username("root")
//                .password("root")
//                .driverClassName("com.mysql.jdbc.Driver")
//                .build();
//    }
}