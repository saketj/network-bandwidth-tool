package com.saketsaurabh.nbt.measurement;


import org.json.simple.JSONObject;

import java.io.IOException;

public class IperfServer {

    private JSONObject config;

    public IperfServer(JSONObject config) {
        this.config = config;
    }

    public void start() {
        Runnable worker = new Runnable() {
            @Override
            public void run() {
                process();
            }
        };
        Thread workerThread = new Thread(worker);
        workerThread.start();
    }

    public void process() {
        String iperfCmd = (String)((JSONObject) config.get("iperf")).get("command");
        String iperfServerPort = (String)((JSONObject) config.get("iperf")).get("iperf_port");
        ProcessBuilder pb = new ProcessBuilder(iperfCmd, "-s", "-p", iperfServerPort);
        Process process = null;
        try {
            process = pb.start();
            System.out.println("iPerf server now started in background.");
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
