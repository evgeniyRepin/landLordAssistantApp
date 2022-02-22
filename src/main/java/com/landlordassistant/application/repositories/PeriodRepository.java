package com.landlordassistant.application.repositories;

import com.landlordassistant.application.entities.Period;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodRepository extends JpaRepository<Period, Long> {
}
