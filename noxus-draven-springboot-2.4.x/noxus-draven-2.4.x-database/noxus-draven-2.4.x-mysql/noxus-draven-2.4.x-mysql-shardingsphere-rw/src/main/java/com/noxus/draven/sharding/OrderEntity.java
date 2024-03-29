package com.noxus.draven.sharding;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "t_order_0")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Integer userId;
}
