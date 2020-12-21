package com.noxus.draven.caching.ehcache.based.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 〈功能概述〉<br>
 *
 * @className: User
 * @package: com.noxus.draven.caching.ehcache.based.entity
 * @author: draven
 * @date: 2020/12/21 16:23
 */
@Data
@AllArgsConstructor
@Setter
@Getter
public class User implements Serializable {

    private String code;

    private String name;

}
