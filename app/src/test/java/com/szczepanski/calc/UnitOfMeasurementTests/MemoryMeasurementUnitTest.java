package com.szczepanski.calc.UnitOfMeasurementTests;

import com.szczepanski.calc.UnitsOfMeasurement.MemoryMeasurementUnit;
import com.szczepanski.calc.UnitsOfMeasurement.UnitDatabaseTemplate;

import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static junit.framework.Assert.assertEquals;
@Ignore
public class MemoryMeasurementUnitTest {

    private UnitDatabaseTemplate unit = new MemoryMeasurementUnit();

    @Test
    public void compareBitToBitTest() {
        assertEquals(BigDecimal.valueOf(0.0009765625),unit.getUnit("b")
                .getUnitValue().divide(unit.getUnit("Kb").getUnitValue(), 10, RoundingMode.HALF_UP));
    }

    @Test
    public void compareByteToByteTest() {
        assertEquals(BigDecimal.valueOf(0.0009765625),unit.getUnit("B")
                .getUnitValue().divide(unit.getUnit("KB").getUnitValue(),10,RoundingMode.HALF_UP));
    }

    @Test
    public void compareImperialToImperialUnitTest() {
        assertEquals(BigDecimal.valueOf(0.0001220703),unit.getUnit("b")
                .getUnitValue().divide(unit.getUnit("KB").getUnitValue(),10,RoundingMode.HALF_UP));
    }

    @Test
    public void compareImperialToMetricUnitTest() {
        assertEquals(BigDecimal.valueOf(8192),unit.getUnit("KB")
                .getUnitValue().divide(unit.getUnit("b").getUnitValue(),RoundingMode.HALF_UP));
    }

}