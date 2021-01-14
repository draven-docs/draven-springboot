package com.noxus.draven.cxfclient.annotations;

import com.noxus.draven.cxfclient.service.UserService;

import java.lang.annotation.*;

/**
 * 〈功能概述〉<br>
 *
 * @className: AspectCxf
 * @package: com.noxus.draven.cxfclient.config
 * @author: draven
 * @date: 2021/1/13 17:04
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AspectAnnot {

    public String method() default "getHello";

    //public Class args() default UserService.Type;
    Class<?>[] args() default {UserService.class};

}
