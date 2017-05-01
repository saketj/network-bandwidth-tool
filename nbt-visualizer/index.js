var thrift = require('thrift');
var express = require('express');
var cors = require('cors');

var app = express();
app.use(cors());

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

// Create a NBTReportingService client with the connection
var client = thrift.createClient(NBTReportingService, connection);


app.get('/summary', function(req, res){
    client.getSummary(function(err, response) {
        res.send(response);
    });
});


app.listen(3000, function () {
    console.log('Reporting also available via http at http://localhost:3000/summary.')
})

