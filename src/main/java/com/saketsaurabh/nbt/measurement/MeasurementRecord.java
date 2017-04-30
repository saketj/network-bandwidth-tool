package com.saketsaurabh.nbt.measurement;

public class MeasurementRecord {
    String sourceIP;
    String destinationIP;
    double bandwidth;

    public MeasurementRecord(String sourceIP, String destinationIP, double bandwidth) {
        this.sourceIP = sourceIP;
        this.destinationIP = destinationIP;
        this.bandwidth = bandwidth;
    }

    public String getSourceIP() {
        return sourceIP;
    }

    public String getDestinationIP() {
        return destinationIP;
    }

    public double getBandwidth() {
        return bandwidth;
    }
}
