package com.noxus.draven.caching.caffeine.controller;

import com.noxus.draven.caching.caffeine.entity.Person;
import com.noxus.draven.caching.caffeine.service.PersonService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    private final PersonService personService;

    public CacheController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/put")
    public long put(@RequestBody Person person) {
        Person p = personService.save(person);
        return p.getId();
    }

    @RequestMapping("/able")
    public Person cacheable(@RequestBody Person person) {

        return personService.findOne(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id) {

        personService.remove(id);
        return "ok";
    }


}
