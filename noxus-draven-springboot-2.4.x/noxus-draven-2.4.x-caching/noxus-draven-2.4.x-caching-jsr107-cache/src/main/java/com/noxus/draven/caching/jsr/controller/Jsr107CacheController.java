package com.noxus.draven.caching.jsr.controller;

import com.noxus.draven.caching.jsr.entity.Jsr107Person;
import com.noxus.draven.caching.jsr.service.Jsr107PersonService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Jsr107CacheController {

    private final Jsr107PersonService jsr107personService;

    public Jsr107CacheController(Jsr107PersonService jsr107personService) {
        this.jsr107personService = jsr107personService;
    }

    @RequestMapping("/put")
    public long put(@RequestBody Jsr107Person person) {
        Jsr107Person p = jsr107personService.save(person);
        return p.getId();
    }

    @RequestMapping("/able")
    public Jsr107Person cacheable(@RequestBody Jsr107Person person) {

        return jsr107personService.findOne(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id) {

        jsr107personService.remove(id);
        return "ok";
    }


}
