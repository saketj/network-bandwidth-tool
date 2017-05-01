package com.saketsaurabh.nbt.measurement;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Map;

/**
 * The NBT master sends periodic requests to workers
 * to send bandwidth measurements.
 */
public class Master {

    private JSONObject config;
    private MeasurementRepository repository;
    private int nbtWorkerPort;


    public Master(JSONObject config, MeasurementRepository repository) {
        this.config = config;
        this.repository = repository;
        nbtWorkerPort = Integer.parseInt((String)config.get("worker_port"));
        initializeRepositoryRecords(repository, config);
    }

    private void initializeRepositoryRecords(MeasurementRepository repository, JSONObject config) {
        JSONArray jsonList = (JSONArray) config.get("instances");
        for (int i = 0; i < jsonList.size(); ++i) {
            String sourceIP = (String) jsonList.get(i);
            for (int j = i + 1; j < jsonList.size(); ++j) {
                String destinationIP = (String) jsonList.get(j);
                MeasurementRecord record = new MeasurementRecord(sourceIP, destinationIP, 0.0);
                String key = sourceIP + "=" + destinationIP;
                repository.measurementRecords.put(key, record);
            }
        }
    }

    public void start() {
        while (true) {
            for (Map.Entry<String, MeasurementRecord> entry : repository.measurementRecords.entrySet()) {
                String sourceIP = entry.getValue().sourceIP;
                String destinationIP = entry.getValue().destinationIP;

                TTransport transport = new TSocket(sourceIP, nbtWorkerPort);
                try {
                    transport.open();
                } catch (TTransportException e) {
                    System.err.println("Failed to open transport to the worker.");
                    e.printStackTrace();
                    System.exit(1);
                }

                TProtocol protocol = new TBinaryProtocol(transport);
                NBTMeasurementService.Client client = new NBTMeasurementService.Client(protocol);
                BandwidthWorkRequest workRequest = new BandwidthWorkRequest();
                workRequest.setDestination_ip(destinationIP);
                try {
                    BandwidthWorkResponse workResponse = client.performMeasurement(workRequest);
                    entry.getValue().bandwidth = workResponse.getBandwidth();
                } catch (TException e) {
                    System.err.println("Master request to worker failed.");
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }

}
