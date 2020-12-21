package com.noxus.draven.caching.jsr.service;

import com.noxus.draven.caching.jsr.entity.Person;

public interface PersonService {

    public Person save(Person person);

    public void remove(Long id);

    public Person findOne(Person person);
}
