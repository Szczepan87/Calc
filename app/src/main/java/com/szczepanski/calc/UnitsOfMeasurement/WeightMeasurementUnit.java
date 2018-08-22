package com.szczepanski.calc.UnitsOfMeasurement;

import java.math.BigDecimal;

public class WeightMeasurementUnit extends UnitDatabaseTemplate {

    public WeightMeasurementUnit() {
        fillUnitDatabase();
    }

    private final UnitOfMeasurement gram = new UnitOfMeasurement(BigDecimal.valueOf(1),"Gram", "g");

    @Override
    public void fillUnitDatabase() {
        getListOfMeasurementUnits().add(gram);
        getListOfMeasurementUnits().add(new UnitOfMeasurement(gram.getUnitValue().multiply(BigDecimal.valueOf(5)),"Carat(metric)","CD"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(gram.getUnitValue().multiply(BigDecimal.valueOf(10)),"Decagram","dag"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(gram.getUnitValue().multiply(BigDecimal.valueOf(28.349523)),"Ounce","oz"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(gram.getUnitValue().multiply(BigDecimal.valueOf(31.103477)),"Ounce(precious metals)","ozt"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(gram.getUnitValue().multiply(BigDecimal.valueOf(453.59237)),"Pounds","lbs"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(gram.getUnitValue().multiply(BigDecimal.valueOf(1000)),"Kilogram","kg"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(gram.getUnitValue().multiply(BigDecimal.valueOf(1000000)),"Tonne (metric)","t"));
    }
}
