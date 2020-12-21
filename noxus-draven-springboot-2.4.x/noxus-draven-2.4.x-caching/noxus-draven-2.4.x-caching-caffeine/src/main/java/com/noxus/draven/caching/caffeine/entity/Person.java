package com.noxus.draven.caching.caffeine.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 〈功能概述〉<br>
 *
 * @className: Persion
 * @package: com.noxus.draven.caching.jdk.based.entity
 * @author: draven
 * @date: 2020/12/21 15:36
 */
@Slf4j
@Getter
@Setter
public class Person {
    /**
     * 唯一
     */
    private Long id;

    /**
     * 年龄
     */
    private Integer age;
}
