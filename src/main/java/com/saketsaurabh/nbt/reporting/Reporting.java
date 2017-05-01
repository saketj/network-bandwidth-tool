package com.saketsaurabh.nbt.reporting;

import com.saketsaurabh.nbt.measurement.MeasurementRecord;
import com.saketsaurabh.nbt.measurement.MeasurementRepository;
import org.apache.thrift.TException;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Reporting {
    private static final int REPORTING_PORT = 9091;

    private JSONObject config;
    private ReportingHandler handler;
    private NBTReportingService.Processor processor;

    public Reporting(JSONObject config, MeasurementRepository repository) {
        this.config = config;
        handler = new ReportingHandler(repository);
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

    public void process(NBTReportingService.Processor processor) {
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

    private MeasurementRepository repository;

    public ReportingHandler(MeasurementRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BandwidthMeasurement> getSummary() throws TException {
        List<BandwidthMeasurement> outputList = new ArrayList<>();

        Collection<MeasurementRecord> records = repository.getMeasurementRecords();
        for (MeasurementRecord record : records) {
            BandwidthMeasurement measurement = new BandwidthMeasurement();
            measurement.setSource_ip(record.getSourceIP());
            measurement.setDestination_ip(record.getDestinationIP());
            measurement.setBandwidth(record.getBandwidth());
            measurement.setTimestamp((int) (System.currentTimeMillis() / 1000L));
            outputList.add(measurement);
        }
        return outputList;
    }
}