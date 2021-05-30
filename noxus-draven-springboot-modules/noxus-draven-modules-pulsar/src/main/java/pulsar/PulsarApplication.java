package pulsar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 〈功能概述〉<br>
 *
 * @className: Application
 * @package: PACKAGE_NAME
 * @author: draven
 * @date: 2021/5/16 20:04
 */

@SpringBootApplication
@MapperScan("pulsar.plus.mapper")
public class PulsarApplication {
    public static void main(String[] args) {
        SpringApplication.run(PulsarApplication.class);
    }
}
