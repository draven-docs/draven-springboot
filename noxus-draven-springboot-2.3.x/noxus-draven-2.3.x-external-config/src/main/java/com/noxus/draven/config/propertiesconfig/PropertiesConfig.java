package com.noxus.draven.config.propertiesconfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 〈功能概述〉<br>
 *
 * @className: RandomValue
 * @package: com.noxus.draven.config.valuse.random
 * @author: draven
 * @date: 2020/11/11 11:04
 */
@RequestMapping
@RestController
@Slf4j
public class PropertiesConfig {

    //@Autowired
    private final AcmeProperties acmeProperties;

    //@Autowired
    private final EnabledProperties enabledProperties;

    //@Autowired
    private final PropertySourceConfig propertySourceConfig;

    public PropertiesConfig(AcmeProperties acmeProperties, EnabledProperties enabledProperties, PropertySourceConfig propertySourceConfig) {
        this.acmeProperties = acmeProperties;
        this.enabledProperties = enabledProperties;
        this.propertySourceConfig = propertySourceConfig;
    }


    @GetMapping("PropertiesMono")
    public Mono PropertiesMono() {
        //redisName
        log.info("{}", acmeProperties.isEnabled());
        return Mono.just(acmeProperties.isEnabled() + "" + acmeProperties.getRemoteAddress());
    }


    @GetMapping("EnabledMono")
    public Mono EnabledMono() {

        //redisName
        log.info("{}", enabledProperties.getUsername());
        return Mono.just(enabledProperties.getUsername() + "" + enabledProperties.getPassword());
    }


    @GetMapping("PropertySourceMono")
    public Mono PropertySourceMono() {

        //redisName
        log.info("{}", propertySourceConfig.getHost());
        return Mono.just(propertySourceConfig);
    }


}
