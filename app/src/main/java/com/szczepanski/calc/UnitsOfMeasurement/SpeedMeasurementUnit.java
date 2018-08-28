package com.szczepanski.calc.UnitsOfMeasurement;

import com.szczepanski.calc.App;
import com.szczepanski.calc.R;

import java.math.BigDecimal;

public class SpeedMeasurementUnit extends UnitDatabaseTemplate {

    public SpeedMeasurementUnit() {
        fillUnitDatabase();
    }

    private UnitOfMeasurement meterPerSecond = new UnitOfMeasurement(BigDecimal.valueOf(1), App.getContext().getString(R.string.Meters_per_second),"m/s");

    @Override
    public void fillUnitDatabase() {
        getListOfMeasurementUnits().add(meterPerSecond);
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meterPerSecond.getUnitValue().multiply(BigDecimal.valueOf(1000)),App.getContext().getString(R.string.Kilometers_per_second),"km/s"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meterPerSecond.getUnitValue().multiply(BigDecimal.valueOf(0.2777777778)),App.getContext().getString(R.string.Kilometers_per_hour),"km/h"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meterPerSecond.getUnitValue().multiply(BigDecimal.valueOf(0.44704)),App.getContext().getString(R.string.Miles_per_hour),"mph"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meterPerSecond.getUnitValue().multiply(BigDecimal.valueOf(340.2933)),App.getContext().getString(R.string.Mach),"Ma"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meterPerSecond.getUnitValue().multiply(BigDecimal.valueOf(343)),App.getContext().getString(R.string.Speed_of_sound),"sound"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(meterPerSecond.getUnitValue().multiply(BigDecimal.valueOf(299790000)),App.getContext().getString(R.string.Speed_of_light),"c"));
    }
}
