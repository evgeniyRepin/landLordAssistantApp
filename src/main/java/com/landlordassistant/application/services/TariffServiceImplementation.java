package com.landlordassistant.application.services;

import com.landlordassistant.application.entities.Tariff;
import com.landlordassistant.application.exceptionHandling.NoSuchEntityException;
import com.landlordassistant.application.repositories.TariffRepository;
import org.springframework.stereotype.Service;

@Service
public class TariffServiceImplementation implements TariffService {

    TariffRepository tariffRepository;

    public TariffServiceImplementation(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public Tariff getTariff(long id) {
        Tariff tariff = tariffRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchEntityException("There is no tariff with id=" + id));

        return tariff;
    }
}
