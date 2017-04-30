var thrift = require('thrift');
var NBTReportingService = require('./NBTReportingService');
console.log('', NBTReportingService);
var ttypes = require('./nbt-reporting-service_types');

var transport = thrift.TBufferedTransport;
var protocol = thrift.TBinaryProtocol;

var connection = thrift.createConnection("localhost", 9091, {
  transport : transport,
  protocol : protocol
});

connection.on('error', function(err) {
  if (err) {
    console.log("Error connecting to reporting server.", err);
  }
});

// Create a Calculator client with the connection
var client = thrift.createClient(NBTReportingService, connection);

client.getSummary(function(err, response) {
  console.log(" ", response);
  connection.end();
});
