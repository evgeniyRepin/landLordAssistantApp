package com.landlordassistant.application.services;


import com.landlordassistant.application.entities.Period;

import java.util.List;

public interface PeriodService {

    void savePeriod(Period period);
    void savePeriod(Period period, List<Long> renters);
    List<Period> getAllPeriods();
    Period getPeriod(long id);
    void deletePeriod(long id);
    SeveralPeriodsCalculationResult calculatePeriods(long[] periodIds);
}
