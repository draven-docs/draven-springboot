package apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 〈功能概述〉<br>
 *
 * @className: Application
 * @package: PACKAGE_NAME
 * @author: draven
 * @date: 2021/5/25 23:25
 */
@EnableApolloConfig
@SpringBootApplication
public class ApolloApplication {
    public static void main(String[] args) {
        String apollo_meta = System.getenv("APOLLO_META");
        //System.setProperty("apollo.configService", "http://10.211.55.5:8080");
        SpringApplication.run(ApolloApplication.class);
        System.out.println(apollo_meta);
        String env = System.getenv("env");
        System.out.println(env);
    }

}
