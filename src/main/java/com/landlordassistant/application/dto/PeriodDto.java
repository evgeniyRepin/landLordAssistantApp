package com.landlordassistant.application.dto;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PeriodDto {

    long id;

    LocalDate startDate;
    BigDecimal startColdWater;
    BigDecimal startHotWater;
    BigDecimal startElectricity;

    LocalDate endDate;
    BigDecimal endColdWater;
    BigDecimal endHotWater;
    BigDecimal endElectricity;

    private List<Long> renters;

    public PeriodDto(long id, LocalDate startDate, BigDecimal startColdWater, BigDecimal startHotWater, BigDecimal startElectricity, LocalDate endDate, BigDecimal endColdWater, BigDecimal endHotWater, BigDecimal endElectricity, List<Long> renters) {
        this.id = id;
        this.startDate = startDate;
        this.startColdWater = startColdWater;
        this.startHotWater = startHotWater;
        this.startElectricity = startElectricity;
        this.endDate = endDate;
        this.endColdWater = endColdWater;
        this.endHotWater = endHotWater;
        this.endElectricity = endElectricity;
        this.renters = renters;
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

    public List<Long> getRenters() {
        return renters;
    }

    public void setRenters(List<Long> renters) {
        this.renters = renters;
    }
}
