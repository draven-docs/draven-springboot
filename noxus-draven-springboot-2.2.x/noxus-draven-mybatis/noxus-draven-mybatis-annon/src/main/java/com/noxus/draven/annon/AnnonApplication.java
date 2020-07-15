package com.noxus.draven.annon;

import com.noxus.draven.annon.config.dynamic.DynamicDataSourceAnnotationAdvisor;
import com.noxus.draven.annon.config.dynamic.DynamicDataSourceAnnotationInterceptor;
import com.noxus.draven.annon.config.dynamic.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Import(DynamicDataSourceRegister.class)
@SpringBootApplication
@MapperScan("com.noxus.draven.annon.mapper")
@EnableTransactionManagement
public class AnnonApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnnonApplication.class, args);
    }

    @Bean
    public DynamicDataSourceAnnotationAdvisor dynamicDatasourceAnnotationAdvisor() {
        return new DynamicDataSourceAnnotationAdvisor(new DynamicDataSourceAnnotationInterceptor());
    }
}
