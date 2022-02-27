package com.landlordassistant.application.controllers.rest;

import com.landlordassistant.application.dto.PeriodInfo;
import com.landlordassistant.application.dto.ResponseDto;
import com.landlordassistant.application.dto.SeveralPeriodsCalculationResult;
import com.landlordassistant.application.entities.Period;
import com.landlordassistant.application.services.PeriodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/periods")
public class RestPeriodController {

    private final PeriodService periodService;

    public RestPeriodController(PeriodService periodService) {
        this.periodService = periodService;
    }

    @GetMapping
    public ResponseDto<List<Period>> getAllPeriods() {
        List<Period> periods = periodService.getAllPeriods();
        return ResponseDto.success(periods);
    }

    @GetMapping("/{id}")
    public ResponseDto<Period> getPeriod(@PathVariable long id) {
        Period period = periodService.getPeriod(id);
        return ResponseDto.success(period);
    }

    @PostMapping
    @ResponseBody
//    Стоит ли принимать новый период с коллекцией id рентеров или лучше принимать коллекцию самих рентеров?
    public ResponseDto<Void> addNewPeriod(@RequestBody PeriodInfo periodInfo) {
        Period period = new Period(periodInfo);
        periodService.savePeriod(period, periodInfo.getRenters());
        return ResponseDto.success();
    }

    @PutMapping
    public ResponseDto<Void> updatePeriod(@RequestBody PeriodInfo periodInfo) {
        Period period = new Period(periodInfo);
        periodService.savePeriod(period, periodInfo.getRenters());
        return ResponseDto.success();
    }

    @DeleteMapping("/{id}")
    public ResponseDto<Void> deletePeriod(@PathVariable long id) {
        Period period = periodService.getPeriod(id);
        periodService.deletePeriod(id);
        return ResponseDto.success();
    }

    @GetMapping("/calculate")
    @ResponseBody
    public ResponseDto<SeveralPeriodsCalculationResult> calculatePeriods(@RequestParam("id") long[] periodsIds) {
        SeveralPeriodsCalculationResult result =
                periodService.calculatePeriods(periodsIds);
        return ResponseDto.success(result);
    }
}
