package com.noxus.draven.caching.ehcache.based.controller;

/**
 * 〈功能概述〉<br>
 *
 * @className: CacheApi
 * @package: com.noxus.draven.caching.ehcache.based.controller
 * @author: draven
 * @date: 2020/12/21 16:21
 */

import com.noxus.draven.caching.ehcache.based.entity.User;
import com.noxus.draven.caching.ehcache.based.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cache")
public class CacheApi {

    @Autowired
    private CacheService cacheService;

    @GetMapping("get")
    public User get(@RequestParam int id) {
        return cacheService.get(id);
    }

    @PostMapping("set")
    public User set(@RequestParam int id, @RequestParam String code, @RequestParam String name) {
        User u = new User(code, name);
        return cacheService.set(id, u);
    }

    @DeleteMapping("del")
    public void del(@RequestParam int id) {
        cacheService.del(id);
    }

}
