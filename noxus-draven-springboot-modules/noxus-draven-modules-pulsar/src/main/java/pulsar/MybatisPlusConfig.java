package pulsar;

/*@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

    *//**
     * 分页插件
     *//*
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    *//**
     * 使用乐观锁
     *
     * @return
     *//*
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    *//**
     * 逻辑删除功能
     *
     * @return
     *//*
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    *//**
     * SQL执行效率插件,性能测试
     *//*
    @Bean
    @Profile({"dev", "test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }


    @Bean
    public GlobalConfig globalConfig() {
        GlobalConfig conf = new GlobalConfig();
        conf.setDbConfig(new GlobalConfig.DbConfig().setKeyGenerator(new H2KeyGenerator()));
        return conf;
    }

}*/
