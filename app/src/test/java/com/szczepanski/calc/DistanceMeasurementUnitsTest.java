package com.szczepanski.calc;

import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;

public class DistanceMeasurementUnitsTest {

    UnitDatabaseTemplate unit = new DistanceMeasurementUnits();

    @Test
    public void compareMetricToMetricUnitTest() {
        assertEquals(BigDecimal.valueOf(0.001),unit.getDistanceUnit("m")
                .getUnitValue().divide(unit.getDistanceUnit("km").getUnitValue()));
    }

    @Test
    public void compareMetricToImperialUnitTest() {
        assertEquals(BigDecimal.valueOf(0.0000254),unit.getDistanceUnit("inch")
                .getUnitValue().divide(unit.getDistanceUnit("km").getUnitValue()));
    }

    @Test
    public void compareImperialToImperialUnitTest() {
        assertEquals(BigDecimal.valueOf(3),unit.getDistanceUnit("yard")
                .getUnitValue().divide(unit.getDistanceUnit("ft").getUnitValue()));
    }

    @Test
    public void compareImperialToMetricUnitTest() {
        assertEquals(BigDecimal.valueOf(91.44),unit.getDistanceUnit("yard")
                .getUnitValue().divide(unit.getDistanceUnit("cm").getUnitValue()));
    }
}