package com.landlordassistant.application.api;

import com.landlordassistant.application.entities.Period;
import com.landlordassistant.application.entities.Renter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PeriodInfo {

    private long id;

    private LocalDate startDate;
    private BigDecimal startColdWater;
    private BigDecimal startHotWater;
    private BigDecimal startElectricity;

    private LocalDate endDate;
    private BigDecimal endColdWater;
    private BigDecimal endHotWater;
    private BigDecimal endElectricity;

    private BigDecimal resultColdWater;
    private BigDecimal resultHotWater;
    private BigDecimal resultElectricity;
    private BigDecimal resultCanalization;

    private List<Long> renters;

    public PeriodInfo(long id, LocalDate startDate,
                      BigDecimal startColdWater, BigDecimal startHotWater,
                      BigDecimal startElectricity, LocalDate endDate,
                      BigDecimal endColdWater, BigDecimal endHotWater,
                      BigDecimal endElectricity, BigDecimal resultColdWater,
                      BigDecimal resultHotWater, BigDecimal resultElectricity,
                      BigDecimal resultCanalization, List<Long> renters) {
        this.id = id;
        this.startDate = startDate;
        this.startColdWater = startColdWater;
        this.startHotWater = startHotWater;
        this.startElectricity = startElectricity;
        this.endDate = endDate;
        this.endColdWater = endColdWater;
        this.endHotWater = endHotWater;
        this.endElectricity = endElectricity;
        this.resultColdWater = resultColdWater;
        this.resultHotWater = resultHotWater;
        this.resultElectricity = resultElectricity;
        this.resultCanalization = resultCanalization;
        this.renters = renters;
    }

    public PeriodInfo(Period period) {
        this.id = period.getId();
        this.startDate = period.getStartDate();
        this.startColdWater = period.getStartColdWater();
        this.startHotWater = period.getStartHotWater();
        this.startElectricity = period.getStartElectricity();
        this.endDate = period.getEndDate();
        this.endColdWater = period.getEndColdWater();
        this.endHotWater = period.getEndHotWater();
        this.endElectricity = period.getEndElectricity();
        this.resultColdWater = period.getResultColdWater();
        this.resultHotWater = period.getResultHotWater();
        this.resultElectricity = period.getResultElectricity();
        this.resultCanalization = period.getResultCanalization();
        this.renters = period.getRenters().stream()
                .map(Renter::getId)
                .toList();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public BigDecimal getStartColdWater() {
        return startColdWater;
    }

    public void setStartColdWater(BigDecimal startColdWater) {
        this.startColdWater = startColdWater;
    }

    public BigDecimal getStartHotWater() {
        return startHotWater;
    }

    public void setStartHotWater(BigDecimal startHotWater) {
        this.startHotWater = startHotWater;
    }

    public BigDecimal getStartElectricity() {
        return startElectricity;
    }

    public void setStartElectricity(BigDecimal startElectricity) {
        this.startElectricity = startElectricity;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getEndColdWater() {
        return endColdWater;
    }

    public void setEndColdWater(BigDecimal endColdWater) {
        this.endColdWater = endColdWater;
    }

    public BigDecimal getEndHotWater() {
        return endHotWater;
    }

    public void setEndHotWater(BigDecimal endHotWater) {
        this.endHotWater = endHotWater;
    }

    public BigDecimal getEndElectricity() {
        return endElectricity;
    }

    public void setEndElectricity(BigDecimal endElectricity) {
        this.endElectricity = endElectricity;
    }

    public BigDecimal getResultColdWater() {
        return resultColdWater;
    }

    public void setResultColdWater(BigDecimal resultColdWater) {
        this.resultColdWater = resultColdWater;
    }

    public BigDecimal getResultHotWater() {
        return resultHotWater;
    }

    public void setResultHotWater(BigDecimal resultHotWater) {
        this.resultHotWater = resultHotWater;
    }

    public BigDecimal getResultElectricity() {
        return resultElectricity;
    }

    public void setResultElectricity(BigDecimal resultElectricity) {
        this.resultElectricity = resultElectricity;
    }

    public BigDecimal getResultCanalization() {
        return resultCanalization;
    }

    public void setResultCanalization(BigDecimal resultCanalization) {
        this.resultCanalization = resultCanalization;
    }

    public List<Long> getRenters() {
        return renters;
    }

    public void setRenters(List<Long> renters) {
        this.renters = renters;
    }
}
