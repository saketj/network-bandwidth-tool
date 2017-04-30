package com.saketsaurabh.nbt.measurement;

import org.apache.thrift.TException;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

/**
 * NBT Worker receives a bandwidth work request from the master
 * and produces a work response and sends it back.
 */
public class Worker {

    private static WorkHandler handler;
    private static NBTMeasurementService.Processor processor;

    public void start() {
        handler = new WorkHandler();
        processor = new NBTMeasurementService.Processor<>(handler);
        Runnable worker = new Runnable() {
            @Override
            public void run() {
                process(processor);
            }
        };
        Thread workerThread = new Thread(worker);
        workerThread.start();
    }

    public static void process(NBTMeasurementService.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(9090);
            //TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            // Use this for a multithreaded server
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            System.out.println("Worker is ready to take requests.");
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class WorkHandler implements NBTMeasurementService.Iface {

    @Override
    public BandwidthWorkResponse performMeasurement(BandwidthWorkRequest workRequest) throws MeasurementFailedException, TException {
        BandwidthWorkResponse workResponse = new BandwidthWorkResponse();
        workResponse.setDestination_ip(workRequest.getDestination_ip());
        workResponse.setDestination_port(workRequest.getDestination_port());
        workResponse.setBandwidth(53.21);
        return workResponse;
    }
}
