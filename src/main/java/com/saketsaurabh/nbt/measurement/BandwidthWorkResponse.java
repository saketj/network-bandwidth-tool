/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.saketsaurabh.nbt.measurement;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-04-30")
public class BandwidthWorkResponse implements org.apache.thrift.TBase<BandwidthWorkResponse, BandwidthWorkResponse._Fields>, java.io.Serializable, Cloneable, Comparable<BandwidthWorkResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BandwidthWorkResponse");

  private static final org.apache.thrift.protocol.TField DESTINATION_IP_FIELD_DESC = new org.apache.thrift.protocol.TField("destination_ip", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField DESTINATION_PORT_FIELD_DESC = new org.apache.thrift.protocol.TField("destination_port", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField BANDWIDTH_FIELD_DESC = new org.apache.thrift.protocol.TField("bandwidth", org.apache.thrift.protocol.TType.DOUBLE, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new BandwidthWorkResponseStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new BandwidthWorkResponseTupleSchemeFactory();

  public java.lang.String destination_ip; // required
  public java.lang.String destination_port; // required
  public double bandwidth; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    DESTINATION_IP((short)1, "destination_ip"),
    DESTINATION_PORT((short)2, "destination_port"),
    BANDWIDTH((short)3, "bandwidth");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // DESTINATION_IP
          return DESTINATION_IP;
        case 2: // DESTINATION_PORT
          return DESTINATION_PORT;
        case 3: // BANDWIDTH
          return BANDWIDTH;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __BANDWIDTH_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.DESTINATION_IP, new org.apache.thrift.meta_data.FieldMetaData("destination_ip", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DESTINATION_PORT, new org.apache.thrift.meta_data.FieldMetaData("destination_port", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BANDWIDTH, new org.apache.thrift.meta_data.FieldMetaData("bandwidth", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.DOUBLE)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BandwidthWorkResponse.class, metaDataMap);
  }

  public BandwidthWorkResponse() {
  }

  public BandwidthWorkResponse(
    java.lang.String destination_ip,
    java.lang.String destination_port,
    double bandwidth)
  {
    this();
    this.destination_ip = destination_ip;
    this.destination_port = destination_port;
    this.bandwidth = bandwidth;
    setBandwidthIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BandwidthWorkResponse(BandwidthWorkResponse other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetDestination_ip()) {
      this.destination_ip = other.destination_ip;
    }
    if (other.isSetDestination_port()) {
      this.destination_port = other.destination_port;
    }
    this.bandwidth = other.bandwidth;
  }

  public BandwidthWorkResponse deepCopy() {
    return new BandwidthWorkResponse(this);
  }

  @Override
  public void clear() {
    this.destination_ip = null;
    this.destination_port = null;
    setBandwidthIsSet(false);
    this.bandwidth = 0.0;
  }

  public java.lang.String getDestination_ip() {
    return this.destination_ip;
  }

  public BandwidthWorkResponse setDestination_ip(java.lang.String destination_ip) {
    this.destination_ip = destination_ip;
    return this;
  }

  public void unsetDestination_ip() {
    this.destination_ip = null;
  }

  /** Returns true if field destination_ip is set (has been assigned a value) and false otherwise */
  public boolean isSetDestination_ip() {
    return this.destination_ip != null;
  }

  public void setDestination_ipIsSet(boolean value) {
    if (!value) {
      this.destination_ip = null;
    }
  }

  public java.lang.String getDestination_port() {
    return this.destination_port;
  }

  public BandwidthWorkResponse setDestination_port(java.lang.String destination_port) {
    this.destination_port = destination_port;
    return this;
  }

  public void unsetDestination_port() {
    this.destination_port = null;
  }

  /** Returns true if field destination_port is set (has been assigned a value) and false otherwise */
  public boolean isSetDestination_port() {
    return this.destination_port != null;
  }

  public void setDestination_portIsSet(boolean value) {
    if (!value) {
      this.destination_port = null;
    }
  }

  public double getBandwidth() {
    return this.bandwidth;
  }

  public BandwidthWorkResponse setBandwidth(double bandwidth) {
    this.bandwidth = bandwidth;
    setBandwidthIsSet(true);
    return this;
  }

  public void unsetBandwidth() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __BANDWIDTH_ISSET_ID);
  }

  /** Returns true if field bandwidth is set (has been assigned a value) and false otherwise */
  public boolean isSetBandwidth() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __BANDWIDTH_ISSET_ID);
  }

  public void setBandwidthIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __BANDWIDTH_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case DESTINATION_IP:
      if (value == null) {
        unsetDestination_ip();
      } else {
        setDestination_ip((java.lang.String)value);
      }
      break;

    case DESTINATION_PORT:
      if (value == null) {
        unsetDestination_port();
      } else {
        setDestination_port((java.lang.String)value);
      }
      break;

    case BANDWIDTH:
      if (value == null) {
        unsetBandwidth();
      } else {
        setBandwidth((java.lang.Double)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case DESTINATION_IP:
      return getDestination_ip();

    case DESTINATION_PORT:
      return getDestination_port();

    case BANDWIDTH:
      return getBandwidth();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case DESTINATION_IP:
      return isSetDestination_ip();
    case DESTINATION_PORT:
      return isSetDestination_port();
    case BANDWIDTH:
      return isSetBandwidth();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof BandwidthWorkResponse)
      return this.equals((BandwidthWorkResponse)that);
    return false;
  }

  public boolean equals(BandwidthWorkResponse that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_destination_ip = true && this.isSetDestination_ip();
    boolean that_present_destination_ip = true && that.isSetDestination_ip();
    if (this_present_destination_ip || that_present_destination_ip) {
      if (!(this_present_destination_ip && that_present_destination_ip))
        return false;
      if (!this.destination_ip.equals(that.destination_ip))
        return false;
    }

    boolean this_present_destination_port = true && this.isSetDestination_port();
    boolean that_present_destination_port = true && that.isSetDestination_port();
    if (this_present_destination_port || that_present_destination_port) {
      if (!(this_present_destination_port && that_present_destination_port))
        return false;
      if (!this.destination_port.equals(that.destination_port))
        return false;
    }

    boolean this_present_bandwidth = true;
    boolean that_present_bandwidth = true;
    if (this_present_bandwidth || that_present_bandwidth) {
      if (!(this_present_bandwidth && that_present_bandwidth))
        return false;
      if (this.bandwidth != that.bandwidth)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetDestination_ip()) ? 131071 : 524287);
    if (isSetDestination_ip())
      hashCode = hashCode * 8191 + destination_ip.hashCode();

    hashCode = hashCode * 8191 + ((isSetDestination_port()) ? 131071 : 524287);
    if (isSetDestination_port())
      hashCode = hashCode * 8191 + destination_port.hashCode();

    hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(bandwidth);

    return hashCode;
  }

  @Override
  public int compareTo(BandwidthWorkResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetDestination_ip()).compareTo(other.isSetDestination_ip());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDestination_ip()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.destination_ip, other.destination_ip);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetDestination_port()).compareTo(other.isSetDestination_port());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDestination_port()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.destination_port, other.destination_port);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetBandwidth()).compareTo(other.isSetBandwidth());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBandwidth()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bandwidth, other.bandwidth);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("BandwidthWorkResponse(");
    boolean first = true;

    sb.append("destination_ip:");
    if (this.destination_ip == null) {
      sb.append("null");
    } else {
      sb.append(this.destination_ip);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("destination_port:");
    if (this.destination_port == null) {
      sb.append("null");
    } else {
      sb.append(this.destination_port);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("bandwidth:");
    sb.append(this.bandwidth);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BandwidthWorkResponseStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public BandwidthWorkResponseStandardScheme getScheme() {
      return new BandwidthWorkResponseStandardScheme();
    }
  }

  private static class BandwidthWorkResponseStandardScheme extends org.apache.thrift.scheme.StandardScheme<BandwidthWorkResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BandwidthWorkResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // DESTINATION_IP
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.destination_ip = iprot.readString();
              struct.setDestination_ipIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // DESTINATION_PORT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.destination_port = iprot.readString();
              struct.setDestination_portIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // BANDWIDTH
            if (schemeField.type == org.apache.thrift.protocol.TType.DOUBLE) {
              struct.bandwidth = iprot.readDouble();
              struct.setBandwidthIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, BandwidthWorkResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.destination_ip != null) {
        oprot.writeFieldBegin(DESTINATION_IP_FIELD_DESC);
        oprot.writeString(struct.destination_ip);
        oprot.writeFieldEnd();
      }
      if (struct.destination_port != null) {
        oprot.writeFieldBegin(DESTINATION_PORT_FIELD_DESC);
        oprot.writeString(struct.destination_port);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(BANDWIDTH_FIELD_DESC);
      oprot.writeDouble(struct.bandwidth);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BandwidthWorkResponseTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public BandwidthWorkResponseTupleScheme getScheme() {
      return new BandwidthWorkResponseTupleScheme();
    }
  }

  private static class BandwidthWorkResponseTupleScheme extends org.apache.thrift.scheme.TupleScheme<BandwidthWorkResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BandwidthWorkResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetDestination_ip()) {
        optionals.set(0);
      }
      if (struct.isSetDestination_port()) {
        optionals.set(1);
      }
      if (struct.isSetBandwidth()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetDestination_ip()) {
        oprot.writeString(struct.destination_ip);
      }
      if (struct.isSetDestination_port()) {
        oprot.writeString(struct.destination_port);
      }
      if (struct.isSetBandwidth()) {
        oprot.writeDouble(struct.bandwidth);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BandwidthWorkResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.destination_ip = iprot.readString();
        struct.setDestination_ipIsSet(true);
      }
      if (incoming.get(1)) {
        struct.destination_port = iprot.readString();
        struct.setDestination_portIsSet(true);
      }
      if (incoming.get(2)) {
        struct.bandwidth = iprot.readDouble();
        struct.setBandwidthIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

