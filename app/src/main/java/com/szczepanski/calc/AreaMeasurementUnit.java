package com.szczepanski.calc;

import java.math.BigDecimal;

public class AreaMeasurementUnit extends UnitDatabaseTemplate{

    AreaMeasurementUnit() {
        fillUnitDatabase();
    }

    private final UnitOfMeasurement squareMeter = new UnitOfMeasurement(BigDecimal.valueOf(1),"Square meter", "m2");

    @Override
    public void fillUnitDatabase() {
        getListOfMeasurementUnits().add(squareMeter);
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(4046.856422)), "Acre","Acr"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(100)), "Are","a"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(10000)), "Hectares","ha"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(0.0001)), "Square centimeter","cm2"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(0.092903)), "Square feet","ft2"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(0.000645)), "Square inch","in2"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(1000000)), "Square kilometer","km2"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(2589988.110336)), "Square mile","mi2"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(0.000001)), "Square millimeter","mm2"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(0.83612736)), "Square yard","yd2"));
    }
}
