package com.landlordassistant.application.entities;

import com.landlordassistant.application.dto.PeriodInfo;

import javax.validation.constraints.NotNull;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "periods")
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "start_date")
    private LocalDate startDate;
    @NotNull
    @Column(name = "start_cold_water")
    private BigDecimal startColdWater;
    @NotNull
    @Column(name = "start_hot_water")
    private BigDecimal startHotWater;
    @NotNull
    @Column(name = "start_electricity")
    private BigDecimal startElectricity;

    @NotNull
    @Column(name = "end_date")
    private LocalDate endDate;
    @NotNull
    @Column(name = "end_cold_water")
    private BigDecimal endColdWater;
    @NotNull
    @Column(name = "end_hot_water")
    private BigDecimal endHotWater;
    @NotNull
    @Column(name = "end_electricity")
    private BigDecimal endElectricity;

    @NotNull
    @Column(name = "result_cold_water")
    private BigDecimal resultColdWater;
    @NotNull
    @Column(name = "result_hot_water")
    private BigDecimal resultHotWater;
    @NotNull
    @Column(name = "result_electricity")
    private BigDecimal resultElectricity;
    @NotNull
    @Column(name = "result_canalization")
    private BigDecimal resultCanalization;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "periods_renters",
            joinColumns = @JoinColumn(name = "period_id"),
            inverseJoinColumns = @JoinColumn(name = "renter_id"))
    private List<Renter> renters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Period period = (Period) o;

        if (id != period.id) return false;
        if (!startDate.equals(period.startDate)) return false;
        if (!startColdWater.equals(period.startColdWater)) return false;
        if (!startHotWater.equals(period.startHotWater)) return false;
        if (!startElectricity.equals(period.startElectricity)) return false;
        if (!endDate.equals(period.endDate)) return false;
        if (!endColdWater.equals(period.endColdWater)) return false;
        if (!endHotWater.equals(period.endHotWater)) return false;
        if (!endElectricity.equals(period.endElectricity)) return false;
        if (!resultColdWater.equals(period.resultColdWater)) return false;
        if (!resultHotWater.equals(period.resultHotWater)) return false;
        if (!resultElectricity.equals(period.resultElectricity)) return false;
        return resultCanalization.equals(period.resultCanalization);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + startDate.hashCode();
        result = 31 * result + startColdWater.hashCode();
        result = 31 * result + startHotWater.hashCode();
        result = 31 * result + startElectricity.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + endColdWater.hashCode();
        result = 31 * result + endHotWater.hashCode();
        result = 31 * result + endElectricity.hashCode();
        result = 31 * result + resultColdWater.hashCode();
        result = 31 * result + resultHotWater.hashCode();
        result = 31 * result + resultElectricity.hashCode();
        result = 31 * result + resultCanalization.hashCode();
        return result;
    }

    public Period() {
    }

    public Period(PeriodInfo periodInfo) {

        this.id = periodInfo.getId();

        this.startDate = periodInfo.getStartDate();
        this.startColdWater = periodInfo.getStartColdWater();
        this.startHotWater = periodInfo.getStartHotWater();
        this.startElectricity = periodInfo.getStartElectricity();

        this.endDate = periodInfo.getEndDate();
        this.endColdWater = periodInfo.getEndColdWater();
        this.endHotWater = periodInfo.getEndHotWater();
        this.endElectricity = periodInfo.getEndElectricity();

        resultColdWater = endColdWater.subtract(startColdWater);
        resultHotWater = endHotWater.subtract(startHotWater);
        resultElectricity = endElectricity.subtract(startElectricity);
        resultCanalization = resultColdWater.add(resultHotWater);

        renters = new ArrayList<>();
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

    public List<Renter> getRenters() {
        return renters;
    }

    public void setRenters(List<Renter> renters) {
        this.renters = renters;
    }
}
