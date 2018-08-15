package com.szczepanski.calc;

import java.util.ArrayList;
import java.util.List;

public abstract class UnitDatabaseTemplate {


    private List<UnitOfMeasurement> listOfMeasurementUnits = new ArrayList<>();

    List<UnitOfMeasurement> getListOfMeasurementUnits() {
        return listOfMeasurementUnits;
    }

    public UnitOfMeasurement getDistanceUnit(String fullNameOrShortName) {
        for (int i = 0; i < listOfMeasurementUnits.size(); i++) {
            if (listOfMeasurementUnits.get(i).getFullName().toLowerCase().equals(fullNameOrShortName))
                return listOfMeasurementUnits.get(i);
            else if (listOfMeasurementUnits.get(i).getShortName().toLowerCase().equals(fullNameOrShortName))
                return listOfMeasurementUnits.get(i);
        }
        return null;
    }

    public List<String> getAvailableUnitNames(){
        List<String> list = new ArrayList<>();

        for (int i = 0; i < listOfMeasurementUnits.size(); i++) {
            list.add(listOfMeasurementUnits.get(i).getFullName());
        }
        return list;
    }
}
