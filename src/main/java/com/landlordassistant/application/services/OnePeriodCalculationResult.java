package com.landlordassistant.application.services;

import com.landlordassistant.application.entities.Period;
import com.landlordassistant.application.entities.Renter;
import com.landlordassistant.application.entities.Tariff;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class OnePeriodCalculationResult {
    private BigDecimal coldWaterBill;
    private BigDecimal hotWaterBill;
    private BigDecimal electricityBill;
    private BigDecimal canalizationBill;
    private BigDecimal totalBill;
    private BigDecimal billPerRenter;

    Map<Renter, BigDecimal> billsPerRenterMap;

    public OnePeriodCalculationResult(Period period, Tariff tariff) {
        coldWaterBill = period.getResultColdWater()
                .multiply(tariff.getColdWaterPerUnit())
                .setScale(2, RoundingMode.DOWN);
        hotWaterBill = period.getResultHotWater()
                .multiply(tariff.getHotWaterPerUnit())
                .setScale(2, RoundingMode.DOWN);
        electricityBill = period.getResultElectricity()
                .multiply(tariff.getElectricityPerUnit())
                .setScale(2, RoundingMode.DOWN);
        canalizationBill = period.getResultCanalization()
                .multiply(tariff.getCanalizationPerUnit())
                .setScale(2, RoundingMode.DOWN);
        totalBill = coldWaterBill.add(hotWaterBill).add(electricityBill).add(canalizationBill)
                .setScale(2, RoundingMode.DOWN);

        billPerRenter = totalBill
                .divide(new BigDecimal(period.getRenters().size()), 2, RoundingMode.DOWN)
                .setScale(2, RoundingMode.DOWN);

        billsPerRenterMap = new HashMap<>();
        for (Renter renter : period.getRenters()) {
            billsPerRenterMap.put(renter, billPerRenter);
        }
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

    public BigDecimal getBillPerRenter() {
        return billPerRenter;
    }

    public void setBillPerRenter(BigDecimal billPerRenter) {
        this.billPerRenter = billPerRenter;
    }

    public Map<Renter, BigDecimal> getBillsPerRenterMap() {
        return billsPerRenterMap;
    }

    public void setBillsPerRenterMap(Map<Renter, BigDecimal> billsPerRenterMap) {
        this.billsPerRenterMap = billsPerRenterMap;
    }
}
