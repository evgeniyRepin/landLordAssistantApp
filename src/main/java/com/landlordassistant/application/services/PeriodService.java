package com.landlordassistant.application.services;


import com.landlordassistant.application.api.CreatePeriodInfo;
import com.landlordassistant.application.api.PeriodInfo;
import com.landlordassistant.application.api.SeveralPeriodsCalculationResultInfo;
import com.landlordassistant.application.entities.Period;

import java.util.List;

public interface PeriodService {

    PeriodInfo getPeriodInfo(long id);
    List<PeriodInfo> getAllPeriodsInfo();
    void savePeriodInfo(CreatePeriodInfo createPeriodInfo);
    void deletePeriodInfo(long id);
    SeveralPeriodsCalculationResultInfo calculatePeriodsInfo(long[] periodIds);
}
