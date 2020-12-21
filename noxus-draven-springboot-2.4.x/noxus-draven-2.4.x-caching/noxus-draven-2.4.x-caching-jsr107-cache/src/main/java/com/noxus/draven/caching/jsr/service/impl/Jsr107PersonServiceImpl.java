package com.noxus.draven.caching.jsr.service.impl;

import com.noxus.draven.caching.jsr.entity.Jsr107Person;
import com.noxus.draven.caching.jsr.service.Jsr107PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class Jsr107PersonServiceImpl implements Jsr107PersonService {


    private static final Map maps = new HashMap<String, Object>();

    static {
        maps.put("1", new Jsr107Person());
    }

    //@Autowired PersonRepository personRepository;

    @Override
    @CachePut(value = "people", key = "#person.id")
    public Jsr107Person save(Jsr107Person person) {
        //Person p = personRepository.save(person);
        maps.put(person.getId() + "", person);
        log.info("为id、key为:" + person.getId() + "数据做了缓存");
        return person;
    }

    @Override
    @CacheEvict(value = "people")
    public void remove(Long id) {
        log.info("删除了id、key为" + id + "的数据缓存");
        //这里不做实际删除操作
    }

    @Override
    @Cacheable(value = "people", key = "#person.id")
    public Jsr107Person findOne(Jsr107Person person) {
        //Person p = personRepository.findOne(person.getId());
        Jsr107Person persons = (Jsr107Person) maps.get(person.getId() + "");
        log.info("为id、key为:" + persons.getId() + "数据做了缓存");
        return persons;
    }
}



