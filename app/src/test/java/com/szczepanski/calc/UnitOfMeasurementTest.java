package com.szczepanski.calc;


import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class UnitOfMeasurementTest {

    @Test
    public void createTest() {
        UnitOfMeasurement unitOfMeasurement = new UnitOfMeasurement(BigDecimal.valueOf(1),"Test", "T");
        assertEquals("Test",unitOfMeasurement.getFullName());
        assertEquals("T",unitOfMeasurement.getShortName());
        assertEquals(BigDecimal.valueOf(1),unitOfMeasurement.getUnitValue());
    }
}