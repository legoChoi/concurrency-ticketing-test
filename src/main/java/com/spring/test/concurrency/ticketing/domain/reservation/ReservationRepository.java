package com.spring.test.concurrency.ticketing.domain.reservation;

import com.spring.test.concurrency.ticketing.domain.concert.entity.Concert;
import com.spring.test.concurrency.ticketing.domain.reservation.entity.Reservation;
import com.spring.test.concurrency.ticketing.domain.seat.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    boolean existsByConcertAndSeat(Concert concert, Seat seat);
}
