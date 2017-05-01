namespace java com.saketsaurabh.nbt.reporting


struct BandwidthMeasurement {
    1: string source_ip,
    2: string destination_ip,
    3: double bandwidth          /*  measured in Mbits/sec   */
    4: i32 timestamp
}

service NBTReportingService {
    list<BandwidthMeasurement> getSummary()
}