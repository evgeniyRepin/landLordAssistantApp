package com.landlordassistant.application.controllers.rest;

import com.landlordassistant.application.dto.PeriodDto;
import com.landlordassistant.application.dto.SeveralPeriodsCalculationResult;
import com.landlordassistant.application.entities.Period;
import com.landlordassistant.application.services.PeriodService;
import com.landlordassistant.application.services.RenterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/periods")
public class RestPeriodController {

    private final PeriodService periodService;

    public RestPeriodController(PeriodService periodService) {
        this.periodService = periodService;
    }

    @GetMapping
    public List<Period> getAllPeriods() {
        List<Period> periods = periodService.getAllPeriods();

        return periods;
    }

    @GetMapping("/{id}")
    public Period getPeriod(@PathVariable long id) {
        Period period = periodService.getPeriod(id);
        return period;
    }

    @PostMapping
    @ResponseBody
//    Стоит ли принимать новый период с коллекцией id рентеров или лучше принимать коллекцию самих рентеров?
    public Period addNewPeriod(@RequestBody PeriodDto periodDto) {
        Period period = new Period(periodDto);
        periodService.savePeriod(period, periodDto.getRenters());
        return period;
    }

    @PutMapping
    public Period updatePeriod(@RequestBody PeriodDto periodDto) {
        Period period = new Period(periodDto);
        periodService.savePeriod(period, periodDto.getRenters());
        return period;
    }

    @DeleteMapping("/{id}")
    public Period deletePeriod(@PathVariable long id) {
        Period period = periodService.getPeriod(id);
        periodService.deletePeriod(id);
        return period;
    }

    @GetMapping("/calculate")
    @ResponseBody
    public SeveralPeriodsCalculationResult calculatePeriods(@RequestParam("id") long[] periodsIds) {
        SeveralPeriodsCalculationResult result =
                periodService.calculatePeriods(periodsIds);
        return result;
    }
}
