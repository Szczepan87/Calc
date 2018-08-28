package com.szczepanski.calc.UnitsOfMeasurement;

import com.szczepanski.calc.App;
import com.szczepanski.calc.R;

import java.math.BigDecimal;

public class PressureMeasurementUnit extends UnitDatabaseTemplate {

    public PressureMeasurementUnit() {
        fillUnitDatabase();
    }

    private UnitOfMeasurement pascal = new UnitOfMeasurement(BigDecimal.valueOf(1), App.getContext().getString(R.string.Pascal), "Pa");

    @Override
    public void fillUnitDatabase() {
        getListOfMeasurementUnits().add(pascal);
        getListOfMeasurementUnits().add(new UnitOfMeasurement(pascal.getUnitValue().multiply(BigDecimal.valueOf(101325)),App.getContext().getString(R.string.Atmospheres),"atm"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(pascal.getUnitValue().multiply(BigDecimal.valueOf(100000)),App.getContext().getString(R.string.Bars),"b"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(pascal.getUnitValue().multiply(BigDecimal.valueOf(100)),App.getContext().getString(R.string.Hectopascals),"hPa"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(pascal.getUnitValue().multiply(BigDecimal.valueOf(9.80665)),App.getContext().getString(R.string.Kilograms_per_sq_meter),"kg/m2"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(pascal.getUnitValue().multiply(BigDecimal.valueOf(1000)),App.getContext().getString(R.string.Kilopascals),"kPa"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(pascal.getUnitValue().multiply(BigDecimal.valueOf(100)),App.getContext().getString(R.string.Millibars),"mb"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(pascal.getUnitValue().multiply(BigDecimal.valueOf(133.322)),App.getContext().getString(R.string.Millimeters_of_mercury),"mmRg"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(pascal.getUnitValue().multiply(BigDecimal.valueOf(6894.757)),App.getContext().getString(R.string.PSI),"psi"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(pascal.getUnitValue().multiply(BigDecimal.valueOf(98066500)), App.getContext().getString(R.string.Tonnes_per_sq_centimeter),"t/cm2"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(pascal.getUnitValue().multiply(BigDecimal.valueOf(9806.65)), App.getContext().getString(R.string.Tonnes_per_sq_meter),"t/m2"));
    }
}
