const si = require('systeminformation');
si.currentLoad(function(data) {
  var cpuUsage = data.currentload.toFixed(2);
  si.mem(function(data) {
      var memUsage = (data.available * 100 / data.total).toFixed(2);
      var output = { "cpu": cpuUsage, "memory": memUsage };
      console.log(JSON.stringify(output));
      process.exit();
  });
});
