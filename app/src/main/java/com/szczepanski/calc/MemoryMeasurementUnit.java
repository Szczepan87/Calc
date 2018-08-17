package com.szczepanski.calc;

import java.math.BigDecimal;

public class MemoryMeasurementUnit extends UnitDatabaseTemplate {

    MemoryMeasurementUnit() {
        fillUnitDatabase();
    }

    private final UnitOfMeasurement bit = new UnitOfMeasurement(BigDecimal.valueOf(1),"Bit","b");

    @Override
    public void fillUnitDatabase() {
        getListOfMeasurementUnits().add(bit);
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(8)),"Byte", "B"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(1024)),"Kilobits", "Kb"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(8192)),"Kilobyte", "KB"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(1048576)),"Megabits", "Mb"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(8388608)),"Megabyte", "MB"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(1073741824)),"Gigabits", "Gb"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(Long.valueOf("8589934592"))),"Gigabytes", "GB"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(Long.valueOf("1125899906842620"))),"Petabits", "Pb"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(Long.valueOf("9007199254740990"))),"Petabytes", "PB"));
        getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(Long.valueOf("1152921504606847000"))),"Exabits", "Eb"));
        //kolejna linijka przekręca Long
        //getListOfMeasurementUnits().add(new UnitOfMeasurement(bit.getUnitValue().multiply(BigDecimal.valueOf(Long.valueOf("9223372036854776000"))),"Exabytes", "EB"));
    }
}
