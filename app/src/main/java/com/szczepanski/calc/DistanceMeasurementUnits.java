package com.szczepanski.calc;

import java.math.BigDecimal;

public class DistanceMeasurementUnits extends UnitDatabaseTemplate{
    
    private final UnitOfMeasurement meter = new UnitOfMeasurement(BigDecimal.valueOf(1),"Meter", "m");
    
    @Override
    public void fillListOfMeasurementUnits() {
        getListOfMeasurementUnits().add(meter);
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.001)),"Millimeter", "mm"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.01)),"Centimeter", "cm"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.1)),"Decimeter", "dm"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(39.37)),"Inch", "in"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.3048)),"Foot", "ft"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.9144)),"Yard", "yrd"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.9144)),"Yard", "yrd"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(1000)),"Kilometer", "km"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(1609.4)),"Mile", "mi"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(1852)),"Nautical mile", "Nmi"));
    }
}
