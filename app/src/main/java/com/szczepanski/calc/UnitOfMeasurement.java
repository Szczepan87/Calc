package com.szczepanski.calc;

import java.math.BigDecimal;

public class UnitOfMeasurement {

    private int resId;
    private BigDecimal value;
    private String fullName;
    private String shortName;

    UnitOfMeasurement(final BigDecimal value, final String fullName, final String shortName) {
        this.value = value;
        this.fullName = fullName;
        this.shortName = shortName;
    }

    public UnitOfMeasurement(BigDecimal value, int resourceId, String shortName) {
        this.value = value;
        this.resId = resourceId;
        this.shortName = shortName;
    }


    public int getResId() {
        return resId;
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
