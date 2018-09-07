package com.szczepanski.calc.UnitOfMeasurementTests;

import com.szczepanski.calc.UnitsOfMeasurement.UnitDatabaseTemplate;
import com.szczepanski.calc.UnitsOfMeasurement.VolumeMeasurementUnit;

import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static junit.framework.Assert.assertEquals;
@Ignore
public class VolumeMeasurementUnitTest {

    private UnitDatabaseTemplate unit = new VolumeMeasurementUnit();

    @Test
    public void compareMetricToMetricUnitTest() {
        assertEquals(BigDecimal.valueOf(0.001),unit.getUnit("ml")
                .getUnitValue().divide(unit.getUnit("l").getUnitValue(), RoundingMode.HALF_DOWN));
    }

    @Test
    public void compareMetricToImperialUnitTest() {
        assertEquals(BigDecimal.valueOf(158.987295),unit.getUnit("bbl")
                .getUnitValue().divide(unit.getUnit("l").getUnitValue(),RoundingMode.HALF_UP));
    }

    @Test
    public void compareImperialToImperialUnitTest() {
        assertEquals(BigDecimal.valueOf(9702.037896),unit.getUnit("bbl")
                .getUnitValue().divide(unit.getUnit("in3").getUnitValue(),RoundingMode.HALF_UP));
    }

    @Test
    public void compareImperialToMetricUnitTest() {
        assertEquals(BigDecimal.valueOf(0.035315),unit.getUnit("l")
                .getUnitValue().divide(unit.getUnit("ft3").getUnitValue(),6,RoundingMode.HALF_UP));
    }
}