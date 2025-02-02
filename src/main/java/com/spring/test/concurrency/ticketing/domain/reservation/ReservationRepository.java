package com.spring.test.concurrency.ticketing.domain.reservation;

import com.spring.test.concurrency.ticketing.domain.reservation.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
