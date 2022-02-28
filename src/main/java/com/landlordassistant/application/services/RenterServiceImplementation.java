package com.landlordassistant.application.services;

import com.landlordassistant.application.api.RenterInfo;
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
    public RenterInfo getRenterInfo(long renterID) {
        Renter renter = renterRepository
                .findById(renterID)
                .orElseThrow(() -> new NoSuchRenterException("There is no such renter with id=" + renterID));

        return new RenterInfo(renter);
    }

    @Override
    public List<RenterInfo> getAllRentersInfo() {
        List<RenterInfo> renterInfoList =
                renterRepository.findAll().stream()
                        .map(renter -> new RenterInfo(renter))
                        .toList();
        return renterInfoList;
    }

    @Override
    public void saveRenterInfo(RenterInfo renterInfo) {
        renterRepository.save(new Renter(renterInfo));
    }

    @Override
    public void deleteRenterInfo(long renterID) {
        getRenterInfo(renterID);
        renterRepository.deleteById(renterID);
    }
}
