package com.saketsaurabh.nbt.components;

import com.saketsaurabh.nbt.measurement.Master;
import com.saketsaurabh.nbt.measurement.MeasurementRepository;
import com.saketsaurabh.nbt.measurement.Worker;
import com.saketsaurabh.nbt.reporting.Reporting;
import org.apache.commons.cli.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;

/**
 * Main initializer class for the application.
 */
public class Main {

    public static JSONObject config = null;

    public static void main(String args[]) throws IOException {
        // Create the options object.
        Options options = new Options();
        options.addOption("m", false, "start as master");
        options.addOption("w", false, "start as worker");
        options.addOption("c", true, "config file specifying the topology");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
             cmd = parser.parse(options, args);
        } catch (ParseException e) {
            e.printStackTrace();
            System.err.println("Failed to parse command line arguments.");
            System.exit(1);
        }

        if (!cmd.hasOption("c")) {
            System.err.println("Need to specify config file as input.");
            System.exit(1);
        }
        JSONParser configParser = new JSONParser();
        try {
            Object obj = configParser.parse(new FileReader(cmd.getOptionValue("c")));
            config = (JSONObject) obj;
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
            System.err.println("Failed to read the config file.");
            System.exit(1);
        }


        if(cmd.hasOption("m") && cmd.hasOption("w")) {
            System.err.println("Cannot specify as both master and worker.");
            System.exit(1);
        } else if (cmd.hasOption("m")) {
            System.out.println("Started as a master...");
            MeasurementRepository repository = new MeasurementRepository();
            Reporting reporting = new Reporting(config, repository);
            reporting.start();
            Master master = new Master(config, repository);
            master.start();
        } else if (cmd.hasOption("w")) {
            System.out.println("Started as a worker...");
            // IperfServer iperfServer = new IperfServer(config);
            // iperfServer.start();
            Worker worker = new Worker(config);
            worker.start();
        } else {
            System.err.println("Please specify either as master or as a worker.");
            System.exit(1);
        }
    }
}
