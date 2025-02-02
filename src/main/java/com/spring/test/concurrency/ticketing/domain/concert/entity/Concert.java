package com.spring.test.concurrency.ticketing.domain.concert.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "concerts")
@NoArgsConstructor
@AllArgsConstructor
public class Concert {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
