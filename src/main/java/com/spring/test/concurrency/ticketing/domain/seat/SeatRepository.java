package com.spring.test.concurrency.ticketing.domain.seat;

import com.spring.test.concurrency.ticketing.domain.seat.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
