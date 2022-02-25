package com.landlordassistant.application.repositories;

import com.landlordassistant.application.entities.Renter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RenterRepository extends JpaRepository<Renter, Long> {

}
