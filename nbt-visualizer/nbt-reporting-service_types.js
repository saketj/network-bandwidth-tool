//
// Autogenerated by Thrift Compiler (0.10.0)
//
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
//
"use strict";

var thrift = require('thrift');
var Thrift = thrift.Thrift;
var Q = thrift.Q;


var ttypes = module.exports = {};
var BandwidthMeasurement = module.exports.BandwidthMeasurement = function(args) {
  this.source_ip = null;
  this.destination_ip = null;
  this.bandwidth = null;
  this.timestamp = null;
  if (args) {
    if (args.source_ip !== undefined && args.source_ip !== null) {
      this.source_ip = args.source_ip;
    }
    if (args.destination_ip !== undefined && args.destination_ip !== null) {
      this.destination_ip = args.destination_ip;
    }
    if (args.bandwidth !== undefined && args.bandwidth !== null) {
      this.bandwidth = args.bandwidth;
    }
    if (args.timestamp !== undefined && args.timestamp !== null) {
      this.timestamp = args.timestamp;
    }
  }
};
BandwidthMeasurement.prototype = {};
BandwidthMeasurement.prototype.read = function(input) {
  input.readStructBegin();
  while (true)
  {
    var ret = input.readFieldBegin();
    var fname = ret.fname;
    var ftype = ret.ftype;
    var fid = ret.fid;
    if (ftype == Thrift.Type.STOP) {
      break;
    }
    switch (fid)
    {
      case 1:
      if (ftype == Thrift.Type.STRING) {
        this.source_ip = input.readString();
      } else {
        input.skip(ftype);
      }
      break;
      case 2:
      if (ftype == Thrift.Type.STRING) {
        this.destination_ip = input.readString();
      } else {
        input.skip(ftype);
      }
      break;
      case 3:
      if (ftype == Thrift.Type.DOUBLE) {
        this.bandwidth = input.readDouble();
      } else {
        input.skip(ftype);
      }
      break;
      case 4:
      if (ftype == Thrift.Type.I32) {
        this.timestamp = input.readI32();
      } else {
        input.skip(ftype);
      }
      break;
      default:
        input.skip(ftype);
    }
    input.readFieldEnd();
  }
  input.readStructEnd();
  return;
};

BandwidthMeasurement.prototype.write = function(output) {
  output.writeStructBegin('BandwidthMeasurement');
  if (this.source_ip !== null && this.source_ip !== undefined) {
    output.writeFieldBegin('source_ip', Thrift.Type.STRING, 1);
    output.writeString(this.source_ip);
    output.writeFieldEnd();
  }
  if (this.destination_ip !== null && this.destination_ip !== undefined) {
    output.writeFieldBegin('destination_ip', Thrift.Type.STRING, 2);
    output.writeString(this.destination_ip);
    output.writeFieldEnd();
  }
  if (this.bandwidth !== null && this.bandwidth !== undefined) {
    output.writeFieldBegin('bandwidth', Thrift.Type.DOUBLE, 3);
    output.writeDouble(this.bandwidth);
    output.writeFieldEnd();
  }
  if (this.timestamp !== null && this.timestamp !== undefined) {
    output.writeFieldBegin('timestamp', Thrift.Type.I32, 4);
    output.writeI32(this.timestamp);
    output.writeFieldEnd();
  }
  output.writeFieldStop();
  output.writeStructEnd();
  return;
};

