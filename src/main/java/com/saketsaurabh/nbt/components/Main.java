package com.saketsaurabh.nbt.components;

import com.saketsaurabh.nbt.measurement.Master;
import com.saketsaurabh.nbt.measurement.MeasurementStats;
import com.saketsaurabh.nbt.measurement.Worker;
import com.saketsaurabh.nbt.reporting.Reporting;
import org.apache.commons.cli.*;

import java.io.IOException;

/**
 * Main initializer class for the application.
 */
public class Main {
    public static void main(String args[]) throws IOException {
        // Create the options object.
        Options options = new Options();
        options.addOption("m", false, "start as master");
        options.addOption("w", false, "start as worker");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
             cmd = parser.parse(options, args);
        } catch (ParseException e) {
            e.printStackTrace();
            System.err.println("Failed to parse command line arguments.");
            System.exit(1);
        }

        if(cmd.hasOption("m") && cmd.hasOption("w")) {
            System.err.println("Cannot specify as both master and worker.");
            System.exit(1);
        } else if (cmd.hasOption("m")) {
            System.out.println("Started as a master...");
            MeasurementStats stats = new MeasurementStats();
            Reporting reporting = new Reporting(stats);
            reporting.start();
            Master master = new Master(stats);
            master.start();
        } else if (cmd.hasOption("w")) {
            System.out.println("Started as a worker...");
            Worker worker = new Worker();
            worker.start();
        } else {
            System.err.println("Please specify either as master or as a worker.");
            System.exit(1);
        }
    }
}
