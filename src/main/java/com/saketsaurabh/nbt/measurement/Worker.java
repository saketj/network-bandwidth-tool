package com.saketsaurabh.nbt.measurement;

import org.apache.thrift.TException;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * NBT Worker receives a bandwidth work request from the master
 * and produces a work response and sends it back.
 */
public class Worker {

    private JSONObject config;
    private WorkHandler handler;
    private NBTMeasurementService.Processor processor;
    private int nbtWorkerPort;

    public Worker(JSONObject config) {
        this.config = config;
        this.nbtWorkerPort = Integer.parseInt((String)config.get("worker_port"));
    }

    public void start() {
        handler = new WorkHandler(config);
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

    public void process(NBTMeasurementService.Processor processor) {
        try {
            TServerTransport serverTransport = new TServerSocket(nbtWorkerPort);
            // TServer server = new TSimpleServer(new TServer.Args(serverTransport).processor(processor));

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

    private JSONObject config;

    public WorkHandler(JSONObject config) {
        this.config = config;
    }

    @Override
    public BandwidthWorkResponse performMeasurement(BandwidthWorkRequest workRequest) throws MeasurementFailedException, TException {
        BandwidthWorkResponse workResponse = new BandwidthWorkResponse();
        workResponse.setDestination_ip(workRequest.getDestination_ip());
        workResponse.setBandwidth(1.0);
        // Run the iperf command to find the bandwidth to the destination.
        String iperfCmd = (String)((JSONObject) config.get("iperf")).get("command");
        String iperfServerPort = (String)((JSONObject) config.get("iperf")).get("iperf_port");
        String iperfPayloadSize = (String)((JSONObject) config.get("iperf")).get("payload_size");
        ProcessBuilder pb = new ProcessBuilder(iperfCmd,
                "-c", workRequest.getDestination_ip(),
                "-p", iperfServerPort,
                "-n", iperfPayloadSize,
                "-J");
        Process process;
        String output = null;
        try {
            process = pb.start();
            process.waitFor();
            output = getCommandOutput(process.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double senderBandwidth = parseSenderBandwidth(output);
        workResponse.setBandwidth(senderBandwidth);
        return workResponse;
    }

    public String getCommandOutput(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + System.getProperty("line.separator"));
            }
        } finally {
            br.close();
        }
        return sb.toString();
    }

    public double parseSenderBandwidth(String jsonOutput) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(jsonOutput);
            double bitsPerSecond = (double)((JSONObject)((JSONObject) json.get("end"))
                    .get("sum_sent")).get("bits_per_second");
            double mbitsPerSecond = bitsPerSecond / 1e+6F;
            return mbitsPerSecond;
        } catch (ParseException e) {
            System.err.println("Cannot parse iperf output.");
            e.printStackTrace();
            return 0.0;
        }
    }
}


