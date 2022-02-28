package com.landlordassistant.application.controllers.rest;

import com.landlordassistant.application.api.CreatePeriodInfo;
import com.landlordassistant.application.api.PeriodInfo;
import com.landlordassistant.application.api.SeveralPeriodsCalculationResultInfo;
import com.landlordassistant.application.dto.ResponseDto;
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

    @GetMapping("/{id}")
    public ResponseDto<PeriodInfo> getPeriod(@PathVariable long id) {
        PeriodInfo periodInfo = periodService.getPeriodInfo(id);
        return ResponseDto.success(periodInfo);
    }

    @GetMapping
    public ResponseDto<List<PeriodInfo>> getAllPeriods() {
        List<PeriodInfo> periods = periodService.getAllPeriodsInfo();
        return ResponseDto.success(periods);
    }

    @PostMapping
    public ResponseDto<Void> addNewPeriodInfo(@RequestBody CreatePeriodInfo createPeriodInfo) {
        periodService.savePeriodInfo(createPeriodInfo);
        return ResponseDto.success();
    }

    @PutMapping
    public ResponseDto<Void> updatePeriodInfo(@RequestBody CreatePeriodInfo createPeriodInfo) {
        periodService.savePeriodInfo(createPeriodInfo);
        return ResponseDto.success();
    }

    @DeleteMapping("/{id}")
    public ResponseDto<Void> deletePeriod(@PathVariable long id) {
        periodService.deletePeriodInfo(id);
        return ResponseDto.success();
    }

    @GetMapping("/calculate")
    @ResponseBody
    public ResponseDto<SeveralPeriodsCalculationResultInfo> calculatePeriods(@RequestParam("id") long[] periodsIds) {
        SeveralPeriodsCalculationResultInfo result =
                periodService.calculatePeriodsInfo(periodsIds);
        return ResponseDto.success(result);
    }
}
