package com.noxus.draven.hibernate.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * 名称
     */
    String username;

    /**
     * 性别
     */
    int age;

    /**
     * 性别
     */
    int sex;

    /**
     * 性别
     */
    String password;
}


