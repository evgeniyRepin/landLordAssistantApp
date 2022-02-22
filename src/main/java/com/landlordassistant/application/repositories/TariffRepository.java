package com.landlordassistant.application.repositories;

import com.landlordassistant.application.entities.Renter;
import com.landlordassistant.application.entities.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffRepository extends JpaRepository<Tariff, Long> {
}
