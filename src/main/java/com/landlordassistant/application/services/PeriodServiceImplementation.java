package com.landlordassistant.application.services;

import com.landlordassistant.application.api.CreatePeriodInfo;
import com.landlordassistant.application.api.PeriodInfo;
import com.landlordassistant.application.api.SeveralPeriodsCalculationResultInfo;
import com.landlordassistant.application.entities.Tariff;
import com.landlordassistant.application.exceptionHandling.NoSuchPeriodException;
import com.landlordassistant.application.entities.Period;
import com.landlordassistant.application.entities.Renter;
import com.landlordassistant.application.repositories.PeriodRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
    public PeriodInfo getPeriodInfo(long id) {
        Period period = getPeriod(id);
        return new PeriodInfo(period);
    }

    private Period getPeriod(long id) {
        Period period = periodRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchPeriodException("There is no period with id=" + id));
        return period;
    }

    @Override
    public List<PeriodInfo> getAllPeriodsInfo() {
        List<PeriodInfo> periodInfoList = periodRepository.findAll().stream()
                .map(PeriodInfo::new)
                .toList();
        return periodInfoList;
    }

    @Override
    public void savePeriodInfo(CreatePeriodInfo createPeriodInfo) {
        Period period = new Period(createPeriodInfo);
        for (Long id : createPeriodInfo.getRenters()) {
            Renter renter = new Renter(renterService.getRenterInfo(id));
            period.getRenters().add(renter);
        }
        periodRepository.save(period);
    }

    @Override
    public void deletePeriodInfo(long id) {
        getPeriodInfo(id);
        periodRepository.deleteById(id);
    }

    @Override
    public SeveralPeriodsCalculationResultInfo calculatePeriodsInfo(long[] periodIds) {
        Tariff tariff = tariffService.getTariff(1);
        List<Period> periods = Arrays.stream(periodIds)
                .mapToObj(this::getPeriod)
                .toList();

        SeveralPeriodsCalculationResult severalPeriodsCalculationResult = new SeveralPeriodsCalculationResult();
        severalPeriodsCalculationResult.calculatePeriods(periods, tariff);

        return new SeveralPeriodsCalculationResultInfo(severalPeriodsCalculationResult);
    }
}
