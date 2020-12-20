package com.noxus.draven.starter.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 〈功能概述〉<br>
 *
 * @className: DemoApplication
 * @package: com.noxus.draven.starter.demo
 * @author: draven
 * @date: 2020/12/20 02:23
 */
@SpringBootApplication
public class DemoApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
        /*ConfigurableApplicationContext run = new SpringApplicationBuilder(DemoApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        HashMap<Object, Object> data = new HashMap<>();

        data.put("name", "demo");
        Formatter bean = run.getBean(Formatter.class);
        System.out.println(bean.format(data));
        run.close();
*/
    }
}
