//package com.noxus.draven.activity.config;
//
//import org.activiti.engine.*;
//import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
//import org.activiti.engine.repository.DeploymentBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.support.ResourcePatternResolver;
//
//import javax.annotation.PostConstruct;
//import java.io.IOException;
//
///**
// * 使用Java类完成配置文件
// *
// * @author answerChang 2019-04-08
// */
//@Configuration
//public class ActivitiConfigs {
//
//    @Value("${spring.datasource.url}")
//    private String url;
//
//    @Value("${spring.datasource.username}")
//    private String userName;
//
//    @Value("${spring.datasource.password}")
//    private String password;
//
//    @Value("${spring.datasource.driver-class-name}")
//    private String driver;
//
////    @Autowired
////    private DataSource dataSource;
//
//    @Autowired
//    private ResourcePatternResolver resourceLoader;
//
//    /**
//     * 初始化配置，将创建28张表
//     *
//     * @return
//     */
////    @Bean
////    public StandaloneProcessEngineConfiguration processEngineConfiguration() {
////        StandaloneProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration();
////        configuration.setDataSource(dataSource);
////        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
////        configuration.setAsyncExecutorActivate(false);
////        return configuration;
////    }
//
//    // activiti core
//    // ProcessEngine 和服务类都是线程安全的。
//    @Bean
//    public ProcessEngineConfiguration processEngineConfiguration() {
//        ProcessEngineConfiguration processEngineConfiguration = new StandaloneProcessEngineConfiguration();
//        // 连接数据库的配置
//        processEngineConfiguration.setJdbcDriver(driver);
//        processEngineConfiguration.setJdbcUrl(url);
//        processEngineConfiguration.setJdbcUsername(userName);
//        processEngineConfiguration.setJdbcPassword(password);
//        processEngineConfiguration.setAsyncExecutorActivate(true);
//        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
//        return processEngineConfiguration;
//    }
//
//    @Bean
//    public ProcessEngine processEngine() {
//        return processEngineConfiguration().buildProcessEngine();
//    }
//
//    @Bean
//    public RepositoryService repositoryService() {
//        return processEngine().getRepositoryService();
//    }
//
//    @Bean
//    public RuntimeService runtimeService() {
//        return processEngine().getRuntimeService();
//    }
//
//    @Bean
//    public TaskService taskService() {
//        return processEngine().getTaskService();
//    }
//
//    @Bean
//    public HistoryService historyService() {
//        return processEngine().getHistoryService();
//    }
//
//    /**
//     * 部署流程
//     *
//     * @throws IOException
//     */
//    @PostConstruct
//    public void initProcess() throws IOException {
//        DeploymentBuilder deploymentBuilder = repositoryService().createDeployment();
//        deploymentBuilder.enableDuplicateFiltering().addClasspathResource("projectDeclareProcess.bpmn").name("projectDeclareProcess").deploy();
//        Resource resource1 = resourceLoader.getResource("classpath:/processes/*"); //加载流程图资源文件
//        deploymentBuilder.enableDuplicateFiltering().addInputStream(resource1.getFilename(), resource1.getInputStream()).name("myProcess_1").deploy(); //按流程id部署
//    }
//}