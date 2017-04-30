package com.saketsaurabh.nbt.reporting;

import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;

public class ReportingWebServer {

    private JSONObject config;

    public ReportingWebServer(JSONObject config) {
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
        JSONObject reportingConfig = (JSONObject) config.get("reporting");
        String webCmd = (String)((JSONObject)reportingConfig.get("web")).get("cmd");
        String webArgs = (String)((JSONObject)reportingConfig.get("web")).get("args");
        String webDirectory = (String)((JSONObject)reportingConfig.get("web")).get("dir");
        ProcessBuilder pb = new ProcessBuilder(webCmd, webArgs);
        pb.directory(new File(System.getProperty("user.dir") + File.separator + webDirectory));
        Process process;
        try {
            process = pb.start();
            System.out.println("Reporting also available via http at http://localhost:3000/summary.");
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
