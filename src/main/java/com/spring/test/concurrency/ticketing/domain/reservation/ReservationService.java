package com.spring.test.concurrency.ticketing.domain.reservation;

import com.spring.test.concurrency.ticketing.domain.concert.ConcertRepository;
import com.spring.test.concurrency.ticketing.domain.concert.entity.Concert;
import com.spring.test.concurrency.ticketing.domain.reservation.entity.Reservation;
import com.spring.test.concurrency.ticketing.domain.reservation.enums.ReservationStatus;
import com.spring.test.concurrency.ticketing.domain.seat.SeatRepository;
import com.spring.test.concurrency.ticketing.domain.seat.entity.Seat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ConcertRepository concertRepository;
    private final SeatRepository seatRepository;

    @Transactional
    public void createReservation(Long concertId, Long seatId) throws InterruptedException {
        // checking
        Concert concert = concertRepository.findById(concertId)
                .orElseThrow(() -> new IllegalStateException("잘못된 콘서트"));

        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new IllegalStateException("잘못된 좌석"));

        if (reservationRepository.existsByConcertAndSeat(concert, seat)) {
            throw new IllegalStateException("이미 예약된 좌석입니다.");
        }

        // 결제
        Thread thread = Thread.currentThread();
        thread.sleep(500);

        reservationRepository.save(new Reservation(ReservationStatus.REQUESTED, concert, seat));
    }
}
