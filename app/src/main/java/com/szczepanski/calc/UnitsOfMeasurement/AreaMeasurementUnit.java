package com.szczepanski.calc.UnitsOfMeasurement;

import com.szczepanski.calc.App;
import com.szczepanski.calc.R;

import java.math.BigDecimal;


public class AreaMeasurementUnit extends UnitDatabaseTemplate{

    public AreaMeasurementUnit() {

        fillUnitDatabase();
    }

    private final UnitOfMeasurement squareMeter = new UnitOfMeasurement(BigDecimal.valueOf(1),App.getContext().getString(R.string.Square_meter), "m2");

    @Override
    public void fillUnitDatabase() {
        getListOfMeasurementUnits().add(squareMeter);
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(4046.856422)), App.getContext().getString(R.string.Acre),"Acr"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(100)), App.getContext().getString(R.string.Are),"a"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(10000)), App.getContext().getString(R.string.Hectares),"ha"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(0.0001)), App.getContext().getString(R.string.Square_centimeter),"cm2"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(0.092903)), App.getContext().getString(R.string.Square_feet),"ft2"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(0.000645)), App.getContext().getString(R.string.Square_inch),"in2"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(1000000)), App.getContext().getString(R.string.Square_kilometer),"km2"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(2589988.110336)), App.getContext().getString(R.string.Square_mile),"mi2"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(0.000001)), App.getContext().getString(R.string.Square_millimeter),"mm2"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(squareMeter.getUnitValue().multiply(BigDecimal.valueOf(0.83612736)), App.getContext().getString(R.string.Square_yard),"yd2"));
    }
}
