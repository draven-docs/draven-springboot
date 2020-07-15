package com.noxus.draven.hibernate;


import com.noxus.draven.hibernate.entity.User;
import com.noxus.draven.hibernate.repository.primary.UserPrimaryRepository;
import com.noxus.draven.hibernate.repository.second.UserSecondRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibernateApplication.class)
public class SpringbootJapDatasourceApplicationTests {
    @Autowired
    private UserPrimaryRepository userPrimaryRepository;
    @Autowired
    private UserSecondRepository userSecondRepository;

    @Test
    public void contextLoads() {
        System.out.println(userPrimaryRepository.findAll());
        System.out.println(userSecondRepository.findAll());
    }

}
