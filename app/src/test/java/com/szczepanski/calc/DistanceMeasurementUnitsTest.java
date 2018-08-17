package com.szczepanski.calc;

import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;

public class DistanceMeasurementUnitsTest {

    private UnitDatabaseTemplate unit = new DistanceMeasurementUnit();

    @Test
    public void compareMetricToMetricUnitTest() {
        assertEquals(BigDecimal.valueOf(0.001),unit.getUnit("m")
                .getUnitValue().divide(unit.getUnit("km").getUnitValue()));
    }

    @Test
    public void compareMetricToImperialUnitTest() {
        assertEquals(BigDecimal.valueOf(0.0000254),unit.getUnit("in")
                .getUnitValue().divide(unit.getUnit("km").getUnitValue()));
    }

    @Test
    public void compareImperialToImperialUnitTest() {
        assertEquals(BigDecimal.valueOf(3),unit.getUnit("yd")
                .getUnitValue().divide(unit.getUnit("ft").getUnitValue()));
    }

    @Test
    public void compareImperialToMetricUnitTest() {
        assertEquals(BigDecimal.valueOf(91.44),unit.getUnit("yd")
                .getUnitValue().divide(unit.getUnit("cm").getUnitValue()));
    }
}