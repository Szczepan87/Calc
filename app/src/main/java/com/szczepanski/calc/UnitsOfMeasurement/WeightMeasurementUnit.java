package com.szczepanski.calc.UnitsOfMeasurement;

import com.szczepanski.calc.App;
import com.szczepanski.calc.R;

import java.math.BigDecimal;

public class WeightMeasurementUnit extends UnitDatabaseTemplate {

    public WeightMeasurementUnit() {
        fillUnitDatabase();
    }

    private final UnitOfMeasurement gram = new UnitOfMeasurement(BigDecimal.valueOf(1), App.getContext().getString(R.string.Gram), "g");

    @Override
    public void fillUnitDatabase() {
        getListOfMeasurementUnits().add(gram);
        getListOfMeasurementUnits().add(new UnitOfMeasurement(gram.getUnitValue().multiply(BigDecimal.valueOf(5)),App.getContext().getString(R.string.Carat_metric),"CD"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(gram.getUnitValue().multiply(BigDecimal.valueOf(10)),App.getContext().getString(R.string.Decagram),"dag"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(gram.getUnitValue().multiply(BigDecimal.valueOf(28.349523)),App.getContext().getString(R.string.Ounce),"oz"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(gram.getUnitValue().multiply(BigDecimal.valueOf(31.103477)),App.getContext().getString(R.string.Ounce_precious_metals),"ozt"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(gram.getUnitValue().multiply(BigDecimal.valueOf(453.59237)),App.getContext().getString(R.string.Pounds),"lbs"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(gram.getUnitValue().multiply(BigDecimal.valueOf(1000)),App.getContext().getString(R.string.Kilograms),"kg"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(gram.getUnitValue().multiply(BigDecimal.valueOf(1000000)),App.getContext().getString(R.string.Tonne_metric),"t"));
    }
}
