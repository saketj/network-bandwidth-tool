// Configure a client instance
var Keen = require('keen-js');
var rp = require('request-promise');

// Configure a client instance
var client = new Keen({
  projectId: '5906ce0cbe8c3e260bcadb9b',
  writeKey: 'D5634011ECF8EF1E8CC13A5B3A701A0360E60C6DB52E39671DA17D4A7AA333AA411D0E34BE25574F49217664912D0947CEFA2C8E79D698538652D4AD6AE0E30A44EDAA16D74D4FA0B429D9CA0692045320F02D35270D75AE540BD13EBE6CB398'
});

var options = {
  method: 'GET',
  uri: 'http://184.72.0.96:3000/summary',
  json: true
};

// Make a request to fetch the stats
rp(options)
  .then(function(stats) {
    var events = {
      measurements: stats
    };
    client.addEvents(events, function(err, res) {
      if (err) {
        console.log("Failed to push data to keen.io");
      } else {
        // Data successfully pushed to keen.io.
        process.exit();
      }
    })
  })
  .catch(function(err) {
    // GET Request failed.
    console.log("GET API call failed ", err);
  });
