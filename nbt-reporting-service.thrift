namespace java com.saketsaurabh.nbt.reporting


struct BandwidthMeasurement {
    1: string source_ip,
    2: string source_port,
    3: string destination_ip,
    4: string destination_port,
    5: double bandwidth          /*  measured in Mbits/sec   */
}

service NBTReportingService {
    list<BandwidthMeasurement> getSummary()
}