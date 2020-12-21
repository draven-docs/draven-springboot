package com.noxus.draven.caching.jsr.service;

import com.noxus.draven.caching.jsr.entity.Jsr107Person;

public interface Jsr107PersonService {

    public Jsr107Person save(Jsr107Person person);

    public void remove(Long id);

    public Jsr107Person findOne(Jsr107Person person);
}
