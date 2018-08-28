package com.szczepanski.calc.UnitsOfMeasurement;

import java.math.BigDecimal;

public class UnitOfMeasurement{

    private BigDecimal value;
    private String fullName;
    private String shortName;

    public UnitOfMeasurement(BigDecimal value, String fullName, String shortName) {
        this.value = value;
        this.fullName = fullName;
        this.shortName = shortName;
    }

    public BigDecimal getUnitValue() {
        return this.value;
    }

    public String getShortName() {
        return this.shortName;
    }

    public String getFullName() {
        return this.fullName;
    }
}
