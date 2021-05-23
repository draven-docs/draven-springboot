package noxus.com.draven.metrics;

import org.springframework.boot.SpringApplication;

/**
 * 〈功能概述〉<br>
 *
 * @className: MetricsApplication
 * @package: noxus.com.draven.metrics
 * @author: draven
 * @date: 2021/5/23 14:26
 */
public class MetricsApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MetricsApplication.class);
        application.setEnvironmentPrefix("myapp");
        application.run(args);
    }
}
