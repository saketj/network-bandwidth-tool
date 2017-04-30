package com.saketsaurabh.nbt.measurement;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MeasurementRepository {
    Map<String, MeasurementRecord> measurementRecords;

    public MeasurementRepository() {
        measurementRecords = new HashMap<>();
    }

    public Collection<MeasurementRecord> getMeasurementRecords() {
        return measurementRecords.values();
    }
}
