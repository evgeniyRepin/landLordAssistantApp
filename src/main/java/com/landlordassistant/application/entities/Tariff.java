package com.landlordassistant.application.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "tariffs")
public class Tariff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "cold_water_per_unit")
    private BigDecimal coldWaterPerUnit;
    @NotNull
    @Column(name = "hot_water_per_unit")
    private BigDecimal hotWaterPerUnit;
    @NotNull
    @Column(name = "electricity")
    private BigDecimal electricityPerUnit;
    @NotNull
    @Column(name = "canalization")
    private BigDecimal canalizationPerUnit;

    public Tariff() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getColdWaterPerUnit() {
        return coldWaterPerUnit;
    }

    public void setColdWaterPerUnit(BigDecimal coldWaterPerUnit) {
        this.coldWaterPerUnit = coldWaterPerUnit;
    }

    public BigDecimal getHotWaterPerUnit() {
        return hotWaterPerUnit;
    }

    public void setHotWaterPerUnit(BigDecimal hotWaterPerUnit) {
        this.hotWaterPerUnit = hotWaterPerUnit;
    }

    public BigDecimal getElectricityPerUnit() {
        return electricityPerUnit;
    }

    public void setElectricityPerUnit(BigDecimal electricityPerUnit) {
        this.electricityPerUnit = electricityPerUnit;
    }

    public BigDecimal getCanalizationPerUnit() {
        return canalizationPerUnit;
    }

    public void setCanalizationPerUnit(BigDecimal canalizationPerUnit) {
        this.canalizationPerUnit = canalizationPerUnit;
    }
}
