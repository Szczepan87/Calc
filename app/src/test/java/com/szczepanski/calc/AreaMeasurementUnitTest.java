package com.szczepanski.calc;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static junit.framework.Assert.assertEquals;

public class AreaMeasurementUnitTest {

    private UnitDatabaseTemplate unit = new AreaMeasurementUnit();

    @Test
    public void compareMetricToMetricUnitTest() {
        assertEquals(BigDecimal.valueOf(0.0000010000).setScale(10),unit.getUnit("m2")
                .getUnitValue().divide(unit.getUnit("km2").getUnitValue(),10, RoundingMode.HALF_UP));
    }

    @Test
    public void compareMetricToImperialUnitTest() {
        assertEquals(BigDecimal.valueOf(2.5899881103),unit.getUnit("mi2")
                .getUnitValue().divide(unit.getUnit("km2").getUnitValue(),10,RoundingMode.HALF_UP));
    }


    @Test
    public void compareImperialToImperialUnitTest() {
        assertEquals(BigDecimal.valueOf(3097600.000000000).setScale(10),unit.getUnit("mi2")
                .getUnitValue().divide(unit.getUnit("yd2").getUnitValue(),10,RoundingMode.HALF_UP));
    }

    @Test
    public void compareImperialToMetricUnitTest() {
        assertEquals(BigDecimal.valueOf(8361.2736000000).setScale(10),unit.getUnit("yd2")
                .getUnitValue().divide(unit.getUnit("cm2").getUnitValue(),10,RoundingMode.HALF_UP));
    }

}