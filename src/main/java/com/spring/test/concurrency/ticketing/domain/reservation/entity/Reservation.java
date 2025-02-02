package com.spring.test.concurrency.ticketing.domain.reservation.entity;

import com.spring.test.concurrency.ticketing.domain.concert.entity.Concert;
import com.spring.test.concurrency.ticketing.domain.reservation.enums.ReservationStatus;
import com.spring.test.concurrency.ticketing.domain.seat.entity.Seat;
import jakarta.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private ReservationStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concert_id")
    private Concert concert;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private Seat seat;
}
