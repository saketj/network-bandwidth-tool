package com.saketsaurabh.nbt.measurement;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * The NBT master sends periodic requests to workers
 * to send bandwidth measurements.
 */
public class Master {

    private MeasurementStats stats;

    public Master(MeasurementStats stats) {
        this.stats = stats;
    }

    public void start() {
        TTransport[] transport = new TTransport[20];
        NBTMeasurementService.Client[] client = new NBTMeasurementService.Client[20];

        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            transport[i] = new TSocket("localhost", 9090);
            try {
                transport[i].open();
            } catch (TTransportException e) {
                System.err.println("Failed to open transport to the worker.");
                e.printStackTrace();
                System.exit(1);
            }

            TProtocol protocol = new TBinaryProtocol(transport[i]);
            client[i] =  new NBTMeasurementService.Client(protocol);
            BandwidthWorkRequest workRequest = new BandwidthWorkRequest();
            workRequest.setDestination_ip("X.X.X.X");
            workRequest.setDestination_port("5379");
            try {
                BandwidthWorkResponse workResponse = client[i].performMeasurement(workRequest);
                stats.aggregateBandwidth += workResponse.getBandwidth();
            } catch (TException e) {
                System.err.println("Master request to worker failed.");
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

}
