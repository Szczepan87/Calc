package com.szczepanski.calc.UnitsOfMeasurement;

import com.szczepanski.calc.App;
import com.szczepanski.calc.R;

import java.math.BigDecimal;

public class VolumeMeasurementUnit extends UnitDatabaseTemplate{

    public VolumeMeasurementUnit() {
        fillUnitDatabase();
    }

    private final UnitOfMeasurement liter = new UnitOfMeasurement(BigDecimal.valueOf(1), App.getContext().getString(R.string.Liters),"l");

    @Override
    public void fillUnitDatabase() {
        getListOfMeasurementUnits().add(liter);
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(36.36872)),App.getContext().getString(R.string.Bushels_UK), "bu(UK)"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(35.23907)),App.getContext().getString(R.string.Bushels_US), "bu(US)"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.001)),App.getContext().getString(R.string.Cubic_centimeters), "cm3"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(1)),App.getContext().getString(R.string.Cubic_decimeters), "dm3"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(28.316847)),App.getContext().getString(R.string.Cubic_feet), "ft3"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(1233481.837548)),App.getContext().getString(R.string.Acre_foot), "arcft"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.016387)),App.getContext().getString(R.string.Cubic_inch), "in3"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(1000)),App.getContext().getString(R.string.Cubic_meter), "m3"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.000001)),App.getContext().getString(R.string.Cubic_millimeter), "mm3"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(764.554858)),App.getContext().getString(R.string.Cubic_yard), "yd3"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.014787)),App.getContext().getString(R.string.Table_spoon), "tbs"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.004929)),App.getContext().getString(R.string.Tea_spoon), "tas"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.028413)),App.getContext().getString(R.string.Fluid_ounces_imperial), "fl oz"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.029574)),App.getContext().getString(R.string.Fluid_ounces_US), "fl oz (US)"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(4.54609)),App.getContext().getString(R.string.Gallons_imperial), "gal"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(3.785412)),App.getContext().getString(R.string.Gallons_US), "gal (US)"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.001)),App.getContext().getString(R.string.Milliliters), "ml"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.568261)),App.getContext().getString(R.string.Pint), "pt"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(0.473176)),App.getContext().getString(R.string.Pint_US), "pt(US)"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(liter.getUnitValue().multiply(BigDecimal.valueOf(158.987295)),App.getContext().getString(R.string.Barrel_oil), "bbl"));
    }
}
