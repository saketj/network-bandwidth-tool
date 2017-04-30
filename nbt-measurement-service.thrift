namespace java com.saketsaurabh.nbt.measurement


exception MeasurementFailedException {
    1: i32 code,
    2: string description
}

struct BandwidthWorkRequest {
    1: string destination_ip
}

struct BandwidthWorkResponse {
    1: string destination_ip,
    2: double bandwidth          /*  measured in Mbits/sec   */
}


service NBTMeasurementService {
    BandwidthWorkResponse performMeasurement(BandwidthWorkRequest workRequest) throws (1: MeasurementFailedException e)
}