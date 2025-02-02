package com.spring.test.concurrency.ticketing;

import com.spring.test.concurrency.ticketing.domain.concert.ConcertRepository;
import com.spring.test.concurrency.ticketing.domain.concert.entity.Concert;
import com.spring.test.concurrency.ticketing.domain.seat.SeatRepository;
import com.spring.test.concurrency.ticketing.domain.seat.entity.Seat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CreateForTest {

    @Autowired ConcertRepository concertRepository;
    @Autowired SeatRepository seatRepository;

    @Test
    void createConcert() {
        concertRepository.save(new Concert());
    }

    @Test
    void createSeats() {
        for (int i = 0; i < 10; i++) {
            seatRepository.save(new Seat());
        }
    }
}
