package com.noxus.draven.rocketmq.entity;

import lombok.*;
import lombok.experimental.Accessors;

@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Accessors(chain = true)
@Getter
@Setter
@Data
public class UserContent {
    private String username;
    private String pwd;

}
