package com.saketsaurabh.nbt.reporting;

import com.saketsaurabh.nbt.measurement.*;
import org.apache.thrift.TException;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import java.util.ArrayList;
import java.util.List;

public class Reporting {
    private static final int REPORTING_PORT = 9091;
    private static ReportingHandler handler;
    private static NBTReportingService.Processor processor;
    
    public Reporting(MeasurementStats stats) {
        handler = new ReportingHandler(stats);
        processor = new NBTReportingService.Processor<>(handler);
    }

    

    public void start() {
        Runnable worker = new Runnable() {
            @Override
            public void run() {
                process(processor);
            }
        };
        Thread workerThread = new Thread(worker);
        workerThread.start();
    }

    public static void process(NBTReportingService.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(REPORTING_PORT);
            //TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

            // Use this for a multithreaded server
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            System.out.println("Reporting can obtained at the port " + REPORTING_PORT);
            server.serve();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



class ReportingHandler implements NBTReportingService.Iface {

    private MeasurementStats stats;

    public ReportingHandler(MeasurementStats stats) {
        this.stats = stats;
    }

    @Override
    public List<BandwidthMeasurement> getSummary() throws TException {
        BandwidthMeasurement measurement = new BandwidthMeasurement();
        measurement.setSource_ip("A.A.A.A");
        measurement.setSource_port("1234");
        measurement.setDestination_ip("Z.Z.Z.Z");
        measurement.setDestination_port("4321");
        measurement.setBandwidth(stats.getAggregateBandwidth());
        List<BandwidthMeasurement> list = new ArrayList<>();
        list.add(measurement);
        return list;
    }
}