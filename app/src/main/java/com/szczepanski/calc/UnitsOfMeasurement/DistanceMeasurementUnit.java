package com.szczepanski.calc.UnitsOfMeasurement;

import com.szczepanski.calc.App;
import com.szczepanski.calc.R;

import java.math.BigDecimal;

public class DistanceMeasurementUnit extends UnitDatabaseTemplate{

    public DistanceMeasurementUnit() {
        fillUnitDatabase();
    }

    private final UnitOfMeasurement meter = new UnitOfMeasurement(BigDecimal.valueOf(1), App.getContext().getString(R.string.Meter), "m");

    @Override
    public void fillUnitDatabase() {
        getListOfMeasurementUnits().add(meter);
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.001)),App.getContext().getString(R.string.Millimeter), "mm"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.01)),App.getContext().getString(R.string.Centimeter), "cm"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.1)),App.getContext().getString(R.string.Decimeter), "dm"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.0254)),App.getContext().getString(R.string.Inch), "in"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.3048)),App.getContext().getString(R.string.Foot), "ft"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.9144)),App.getContext().getString(R.string.Yard), "yd"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(1000)),App.getContext().getString(R.string.Kilometer), "km"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(1609.4)),App.getContext().getString(R.string.Mile), "mi"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(1852)),App.getContext().getString(R.string.Nautical_mile), "Nmi"));
    }
}
