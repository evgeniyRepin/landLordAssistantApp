package com.landlordassistant.application.services;

import com.landlordassistant.application.api.RenterInfo;
import com.landlordassistant.application.entities.Renter;

import java.util.List;

public interface RenterService {
    public RenterInfo getRenterInfo(long renterID);
    public List<RenterInfo> getAllRentersInfo();
    public void saveRenterInfo(RenterInfo renterInfo);
    public void deleteRenterInfo(long renterID);
}
