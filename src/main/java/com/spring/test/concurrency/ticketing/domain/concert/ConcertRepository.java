package com.spring.test.concurrency.ticketing.domain.concert;

import com.spring.test.concurrency.ticketing.domain.concert.entity.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
}
