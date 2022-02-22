package com.landlordassistant.application.services;

import com.landlordassistant.application.entities.Renter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface RenterService {
    public List<Renter> getAllRenters();
    public void saveRenter(Renter renter);
    public Renter getRenter(long renterID);
    public void deleteRenter(long renterID);
}
