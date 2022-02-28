package com.landlordassistant.application.api;

import com.landlordassistant.application.entities.Renter;
import com.landlordassistant.application.services.SeveralPeriodsCalculationResult;

import java.math.BigDecimal;
import java.util.Map;

public class SeveralPeriodsCalculationResultInfo {
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

    public SeveralPeriodsCalculationResultInfo(SeveralPeriodsCalculationResult result) {
        coldWaterAmount = result.getColdWaterAmount();
        hotWaterAmount = result.getHotWaterAmount();
        electricityAmount = result.getElectricityAmount();
        canalizationAmount = result.getCanalizationAmount();

        coldWaterBill = result.getColdWaterBill();
        hotWaterBill = result.getHotWaterBill();
        electricityBill = result.getElectricityBill();
        canalizationBill = result.getCanalizationBill();
        rentersBill = result.getRentersBill();
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
