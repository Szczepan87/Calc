package com.szczepanski.calc.UnitsOfMeasurement;

import com.szczepanski.calc.App;
import com.szczepanski.calc.R;

import java.math.BigDecimal;

public class PowerMeasurementUnit extends UnitDatabaseTemplate {

    public PowerMeasurementUnit() {
        fillUnitDatabase();
    }

    private UnitOfMeasurement watt = new UnitOfMeasurement(BigDecimal.valueOf(1), App.getContext().getString(R.string.Watt),"W");
    @Override
    public void fillUnitDatabase() {
        getListOfMeasurementUnits().add(watt);
        getListOfMeasurementUnits().add(new UnitOfMeasurement(watt.getUnitValue().multiply(BigDecimal.valueOf(746)),App.getContext().getString(R.string.Horse_power), "HP"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(watt.getUnitValue().multiply(BigDecimal.valueOf(1000)),App.getContext().getString(R.string.Kilowatts), "kW"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(watt.getUnitValue().multiply(BigDecimal.valueOf(1000000)),App.getContext().getString(R.string.Megawatts), "MW"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(watt.getUnitValue().multiply(BigDecimal.valueOf(1000000000)),App.getContext().getString(R.string.Gigawatts), "GW"));
    }
}
