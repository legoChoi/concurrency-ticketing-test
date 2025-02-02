package com.spring.test.concurrency.ticketing.domain.reservation;

import com.spring.test.concurrency.ticketing.domain.reservation.entity.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ReservationServiceTest {

    @Autowired ReservationService reservationService;

    @Test
    @Transactional
    @Rollback
    void test() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1000);
        CountDownLatch latch = new CountDownLatch(1000);

        AtomicInteger successCnt = new AtomicInteger();
        AtomicInteger failCnt = new AtomicInteger();

        for (int i = 0; i < 1000; i++) {
            executor.submit(() -> {
                try {
                    reservationService.createReservation(1L, 1L);
                    successCnt.incrementAndGet();
                } catch (Exception e) {
                    failCnt.incrementAndGet();
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
        executor.shutdown();


        assertAll(
                () -> assertEquals(1, successCnt.get(), "예약 성공은 1건만 허용되어야 함"),
                () -> assertEquals(999, failCnt.get(), "예약 실패는 999건이어야 함")
        );
    }
}