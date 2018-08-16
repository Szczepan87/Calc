package com.szczepanski.calc;

import java.math.BigDecimal;

public class VolumeMeasurementUnit extends UnitDatabaseTemplate{

    VolumeMeasurementUnit() {
        fillUnitDatabase();
    }

    private final UnitOfMeasurement liter = new UnitOfMeasurement(BigDecimal.valueOf(1),"Liter","l");

    @Override
    public void fillUnitDatabase() {
        getListOfMeasurementUnits().add(liter);
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(36.36872)),"Bushels (UK)", "bu(UK)"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(35.23907)),"Bushels (US)", "bu(US)"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(35.23907)),"Bushels (US)", "bu(US)"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.001)),"Cubic centimeters", "cm3"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(1)),"Cubic decimeters", "dm3"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(28.316847)),"Cubic feet", "ft3"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(1233481.837548)),"Acre foot", "arcft"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.016387)),"Cubic inch", "in3"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(1000)),"Cubic meter", "m3"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.000001)),"Cubic millimeter", "mm3"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(764.554858)),"Cubic yard", "yd3"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.014787)),"Table spoon", "tbs"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.004929)),"Tea spoon", "tas"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.028413)),"Fluid ounces(imperial)", "fl oz"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.029574)),"Fluid ounces(US)", "fl oz (US)"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(4.54609)),"Gallons (imperial)", "gal"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(3.785412)),"gallons (US)", "gal (US)"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.001)),"Milliliters", "ml"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.568261)),"Pint", "pt"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.473176)),"Pint (US)", "pt(US)"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(158.987295)),"Barrel (oil)", "bbl"));
    }
}
