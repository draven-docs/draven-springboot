package noxus.com.draven.http2;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;


/**
 * 〈功能概述〉<br>
 *
 * @className: prefixApplication
 * @package: noxus.com.draven.prefix
 * @author: draven
 * @date: 2021/4/17 22:28
 */
@SpringBootApplication
public class Http2Application {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Http2Application.class);
        application.setEnvironmentPrefix("myapp");
        application.run(args);
    }

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
        return tomcat;
    }

    //org.apache.coyote.http11.Http11Nio2Protocol
    // org.apache.coyote.http11.Http11NioProtocol
    private Connector createStandardConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11Nio2Protocol");
        connector.setPort(9000);
        return connector;
    }

}
