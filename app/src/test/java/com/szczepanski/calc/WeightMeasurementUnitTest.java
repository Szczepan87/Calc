package com.szczepanski.calc;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static junit.framework.Assert.assertEquals;

public class WeightMeasurementUnitTest {

    private UnitDatabaseTemplate unit = new WeightMeasurementUnit();

    @Test
    public void compareMetricToMetricUnitTest() {
        assertEquals(BigDecimal.valueOf(0.001),unit.getUnit("g")
                .getUnitValue().divide(unit.getUnit("kg").getUnitValue()));
    }

    @Test
    public void compareMetricToImperialUnitTest() {
        assertEquals(BigDecimal.valueOf(31.103477),unit.getUnit("ozt")
                .getUnitValue().divide(unit.getUnit("g").getUnitValue(),RoundingMode.HALF_UP));
    }

    @Test
    public void compareImperialToImperialUnitTest() {
        assertEquals(BigDecimal.valueOf(0.068571),unit.getUnit("ozt")
                .getUnitValue().divide(unit.getUnit("lbs").getUnitValue(),RoundingMode.HALF_UP));
    }
}