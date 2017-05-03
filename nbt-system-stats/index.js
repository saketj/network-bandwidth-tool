const si = require('systeminformation');
var express = require('express');
var cors = require('cors');
var exec = require('child_process').exec;

var app = express();
app.use(cors());


app.get('/systemstats', function(req, res){
    exec('./stats.sh', function(error, stdout, stderr) {
      res.json(JSON.parse(stdout));
    });
});


app.listen(3001, function () {
    console.log('Cluster stats available via http at http://localhost:3001/systemstats.')
})
