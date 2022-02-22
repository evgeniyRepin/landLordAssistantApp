package com.landlordassistant.application.dto;

import com.landlordassistant.application.entities.Period;
import com.landlordassistant.application.entities.Renter;
import com.landlordassistant.application.entities.Tariff;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeveralPeriodsCalculationResult {
    private BigDecimal coldWaterAmount;
    private BigDecimal hotWaterAmount;
    private BigDecimal electricityAmount;
    private BigDecimal canalizationAmount;

    private BigDecimal coldWaterBill;
    private BigDecimal hotWaterBill;
    private BigDecimal electricityBill;
    private BigDecimal canalizationBill;

    private BigDecimal totalBill;

    private Map<Renter, BigDecimal> rentersBill;

    {
        coldWaterAmount = new BigDecimal(0);
        hotWaterAmount = new BigDecimal(0);
        electricityAmount = new BigDecimal(0);
        canalizationAmount = new BigDecimal(0);

        coldWaterBill = new BigDecimal(0);
        hotWaterBill = new BigDecimal(0);
        electricityBill = new BigDecimal(0);
        canalizationBill = new BigDecimal(0);

        totalBill = new BigDecimal(0);

        rentersBill = new HashMap<>();
    }


    public void calculatePeriods(Period[] periods, Tariff tariff) {

        List<OnePeriodCalculationResult> OnePeriodResultList = new ArrayList<>();

        for (Period period : periods) {
            coldWaterAmount = coldWaterAmount.add(period.getResultColdWater());
            hotWaterAmount = hotWaterAmount.add(period.getResultHotWater());
            electricityAmount = electricityAmount.add(period.getResultElectricity());
            canalizationAmount = canalizationAmount.add(period.getResultCanalization());
            addOnePeriodBills(new OnePeriodCalculationResult(period, tariff));
        }
    }

    private void addOnePeriodBills(OnePeriodCalculationResult period) {
        this.coldWaterBill = this.coldWaterBill.add(period.getColdWaterBill());
        this.hotWaterBill = this.hotWaterBill.add(period.getHotWaterBill());
        this.electricityBill = this.electricityBill.add(period.getElectricityBill());
        this.canalizationBill = this.canalizationBill.add(period.getCanalizationBill());
        this.totalBill = this.totalBill.add(period.getTotalBill());

//        TODO rewrite more elegantly
        for (Map.Entry<Renter, BigDecimal> pair : period.getBillsPerRenterMap().entrySet()) {
            if (rentersBill.containsKey(pair.getKey())) {
                BigDecimal oldValue = rentersBill.get(pair.getKey());
                BigDecimal newValue = oldValue.add(pair.getValue());
                rentersBill.put(pair.getKey(), newValue);
            } else {
                rentersBill.put(pair.getKey(), pair.getValue());
            }
        }
    }

    public BigDecimal getColdWaterAmount() {
        return coldWaterAmount;
    }

    public void setColdWaterAmount(BigDecimal coldWaterAmount) {
        this.coldWaterAmount = coldWaterAmount;
    }

    public BigDecimal getHotWaterAmount() {
        return hotWaterAmount;
    }

    public void setHotWaterAmount(BigDecimal hotWaterAmount) {
        this.hotWaterAmount = hotWaterAmount;
    }

    public BigDecimal getElectricityAmount() {
        return electricityAmount;
    }

    public void setElectricityAmount(BigDecimal electricityAmount) {
        this.electricityAmount = electricityAmount;
    }

    public BigDecimal getCanalizationAmount() {
        return canalizationAmount;
    }

    public void setCanalizationAmount(BigDecimal canalizationAmount) {
        this.canalizationAmount = canalizationAmount;
    }

    public BigDecimal getColdWaterBill() {
        return coldWaterBill;
    }

    public void setColdWaterBill(BigDecimal coldWaterBill) {
        this.coldWaterBill = coldWaterBill;
    }

    public BigDecimal getHotWaterBill() {
        return hotWaterBill;
    }

    public void setHotWaterBill(BigDecimal hotWaterBill) {
        this.hotWaterBill = hotWaterBill;
    }

    public BigDecimal getElectricityBill() {
        return electricityBill;
    }

    public void setElectricityBill(BigDecimal electricityBill) {
        this.electricityBill = electricityBill;
    }

    public BigDecimal getCanalizationBill() {
        return canalizationBill;
    }

    public void setCanalizationBill(BigDecimal canalizationBill) {
        this.canalizationBill = canalizationBill;
    }

    public BigDecimal getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(BigDecimal totalBill) {
        this.totalBill = totalBill;
    }

    public Map<Renter, BigDecimal> getRentersBill() {
        return rentersBill;
    }

    public void setRentersBill(Map<Renter, BigDecimal> rentersBill) {
        this.rentersBill = rentersBill;
    }
}
