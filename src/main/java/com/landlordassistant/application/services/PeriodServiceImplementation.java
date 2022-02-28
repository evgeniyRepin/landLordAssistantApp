package com.landlordassistant.application.services;

import com.landlordassistant.application.entities.Tariff;
import com.landlordassistant.application.exceptionHandling.NoSuchPeriodException;
import com.landlordassistant.application.entities.Period;
import com.landlordassistant.application.entities.Renter;
import com.landlordassistant.application.repositories.PeriodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodServiceImplementation implements PeriodService {

    private final PeriodRepository periodRepository;
    private final RenterService renterService;
    private final TariffService tariffService;

    public PeriodServiceImplementation(PeriodRepository periodRepository,
                                       RenterService renterService,
                                       TariffService tariffService) {
        this.periodRepository = periodRepository;
        this.renterService = renterService;
        this.tariffService = tariffService;
    }

    @Override
    public Period getPeriod(long id) {
        Period period = periodRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchPeriodException("There is no period with id = " + id));
        return period;
    }

    @Override
    public void savePeriod(Period period) {
        periodRepository.save(period);
    }

    @Override
    public void savePeriod(Period period, List<Long> renters) {
        for (Long id : renters) {
            Renter renter = renterService.getRenter(id);
            period.getRenters().add(renter);
        }
        periodRepository.save(period);
    }

    @Override
    public List<Period> getAllPeriods() {
        return periodRepository.findAll();
    }

    @Override
    public void deletePeriod(long id) {
        periodRepository.deleteById(id);
    }

    @Override
    public SeveralPeriodsCalculationResult calculatePeriods(long[] periodIds) {
        Tariff tariff = tariffService.getTariff(1);
        Period[] periods = new Period[periodIds.length];

        for (int i = 0; i < periodIds.length; i++) {
            Period period = getPeriod(periodIds[i]);
            periods[i] = period;
        }

        SeveralPeriodsCalculationResult severalPeriodsCalculationResult = new SeveralPeriodsCalculationResult();
        severalPeriodsCalculationResult.calculatePeriods(periods, tariff);

        return severalPeriodsCalculationResult;
    }
}
