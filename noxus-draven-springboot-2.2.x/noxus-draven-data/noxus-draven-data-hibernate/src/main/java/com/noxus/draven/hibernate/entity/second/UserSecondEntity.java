package com.noxus.draven.hibernate.entity.second;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserSecondEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * 名称
     */
    String name;

    /**
     * 性别
     */
    int age;

    /**
     * 性别
     */
    String email;
}
