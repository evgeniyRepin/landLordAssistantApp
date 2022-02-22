package com.landlordassistant.application.services;

import com.landlordassistant.application.exceptionHandling.NoSuchRenterException;
import com.landlordassistant.application.entities.Renter;
import com.landlordassistant.application.repositories.RenterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RenterServiceImplementation implements RenterService{

    private final RenterRepository renterRepository;

    public RenterServiceImplementation(RenterRepository renterRepository) {
        this.renterRepository = renterRepository;
    }

    @Override
    public List<Renter> getAllRenters() {
        return renterRepository.findAll();
    }

    @Override
    public void saveRenter(Renter renter) {
        renterRepository.save(renter);
    }

    @Override
    public Renter getRenter(long renterID) {
        Renter renter = renterRepository
                .findById(renterID)
                .orElseThrow(() -> new NoSuchRenterException("There is no such renter with id= " + renterID));

            return renter;
    }

    @Override
    public void deleteRenter(long renterID) {
            renterRepository.deleteById(renterID);
    }
}
