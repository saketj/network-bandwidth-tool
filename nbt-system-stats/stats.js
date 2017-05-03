const si = require('systeminformation');
const os = require('os-utils');

os.cpuUsage(function(data) {
  var cpuUsage = (data * 100).toFixed(2);
  si.mem(function(data) {
      var memUsage = (data.available * 100 / data.total).toFixed(2);
      var output = { "cpu": cpuUsage, "memory": memUsage };
      console.log(JSON.stringify(output));
      process.exit();
  });
});
