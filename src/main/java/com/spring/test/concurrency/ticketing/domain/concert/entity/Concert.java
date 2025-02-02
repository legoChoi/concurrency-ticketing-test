package com.spring.test.concurrency.ticketing.domain.concert.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "concerts")
public class Concert {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
