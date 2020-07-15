package com.noxus.draven.activity.config;

//@Configuration//声名为配置类，继承Activiti抽象配置类
//public class ActivitiConfig2 extends AbstractProcessEngineAutoConfiguration {
//
//    @Bean
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource activitiDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    public SpringProcessEngineConfiguration springProcessEngineConfiguration(
//            PlatformTransactionManager transactionManager,
//            SpringAsyncExecutor springAsyncExecutor) throws IOException {
//
//        return baseSpringProcessEngineConfiguration(
//                activitiDataSource(),
//                transactionManager,
//                springAsyncExecutor);
//    }
//}