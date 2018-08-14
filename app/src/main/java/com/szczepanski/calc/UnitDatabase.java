package com.szczepanski.calc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UnitDatabase {

    private final UnitOfMeasurement meter = new UnitOfMeasurement(BigDecimal.valueOf(1),"Meter","m");

    private List<UnitOfMeasurement> distanceUnits = new ArrayList<>();
    private List<UnitOfMeasurement> weightUnits = new ArrayList<>();
    private List<UnitOfMeasurement> massUnits = new ArrayList<>();
    private List<UnitOfMeasurement> volumeUnits = new ArrayList<>();

    private void fillDistanceUnits(){
        distanceUnits.add(0, meter);
        distanceUnits.add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.001)),"Millimeter", "mm"));
        distanceUnits.add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.01)),"Centimeter", "cm"));
        distanceUnits.add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.1)),"Decimeter", "dm"));
        distanceUnits.add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(39.37)),"Inch", "in"));
        distanceUnits.add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.3048)),"Foot", "ft"));
        distanceUnits.add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.9144)),"Yard", "yrd"));
        distanceUnits.add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(0.9144)),"Yard", "yrd"));
        distanceUnits.add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(1000)),"Kilometer", "km"));
        distanceUnits.add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(1609.4)),"Mile", "mi"));
        distanceUnits.add(new UnitOfMeasurement(meter.getUnitValue().multiply(BigDecimal.valueOf(1852)),"Nautical mile", "Nmi"));
    }

    public UnitOfMeasurement getDistanceUnit(String name) {
        for (int i = 0; i < distanceUnits.size(); i++) {
            if (distanceUnits.get(i).getFullName().toLowerCase().equals(name))
                return distanceUnits.get(i);
        }
        return null;
    }
}
