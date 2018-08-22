package com.szczepanski.calc.UnitsOfMeasurement;

import com.szczepanski.calc.App;
import com.szczepanski.calc.R;

import java.math.BigDecimal;

public class MemoryMeasurementUnit extends UnitDatabaseTemplate {

    public MemoryMeasurementUnit() {
        fillUnitDatabase();
    }

    private final UnitOfMeasurement bit = new UnitOfMeasurement(BigDecimal.valueOf(1), App.getContext().getString(R.string.Bit),"b");

    @Override
    public void fillUnitDatabase() {
        getListOfMeasurementUnits().add(bit);
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(8)),App.getContext().getString(R.string.Byte), "B"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(1024)),App.getContext().getString(R.string.Kilobits), "Kb"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(8192)),App.getContext().getString(R.string.Kilobyte), "KB"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(1048576)),App.getContext().getString(R.string.Megabits), "Mb"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(8388608)),App.getContext().getString(R.string.Megabyte), "MB"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(1073741824)),App.getContext().getString(R.string.Gigabits), "Gb"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(Long.valueOf("8589934592"))),App.getContext().getString(R.string.Gigabytes), "GB"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(Long.valueOf("1125899906842620"))),App.getContext().getString(R.string.Petabits), "Pb"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(Long.valueOf("9007199254740990"))),App.getContext().getString(R.string.Petabytes), "PB"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(Long.valueOf("1152921504606847000"))),App.getContext().getString(R.string.Exabits), "Eb"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(getListOfMeasurementUnits().get(getListOfMeasurementUnits().indexOf(getUnit(App.getContext().getString(R.string.Exabits))))
                .getUnitValue().multiply(BigDecimal.valueOf(8)),App.getContext().getString(R.string.Exabytes), "EB"));
    }
}
