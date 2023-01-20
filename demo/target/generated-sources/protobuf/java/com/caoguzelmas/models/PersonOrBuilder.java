// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: person.proto

package com.caoguzelmas.models;

public interface PersonOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Person)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * =&gt; tags
   * </pre>
   *
   * <code>string name = 1;</code>
   */
  java.lang.String getName();
  /**
   * <pre>
   * =&gt; tags
   * </pre>
   *
   * <code>string name = 1;</code>
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>int32 age = 2;</code>
   */
  int getAge();

  /**
   * <code>.common.Address address = 3;</code>
   */
  boolean hasAddress();
  /**
   * <code>.common.Address address = 3;</code>
   */
  com.caoguzelmas.models.Address getAddress();
  /**
   * <code>.common.Address address = 3;</code>
   */
  com.caoguzelmas.models.AddressOrBuilder getAddressOrBuilder();

  /**
   * <code>repeated .common.Car car = 4;</code>
   */
  java.util.List<com.caoguzelmas.models.Car> 
      getCarList();
  /**
   * <code>repeated .common.Car car = 4;</code>
   */
  com.caoguzelmas.models.Car getCar(int index);
  /**
   * <code>repeated .common.Car car = 4;</code>
   */
  int getCarCount();
  /**
   * <code>repeated .common.Car car = 4;</code>
   */
  java.util.List<? extends com.caoguzelmas.models.CarOrBuilder> 
      getCarOrBuilderList();
  /**
   * <code>repeated .common.Car car = 4;</code>
   */
  com.caoguzelmas.models.CarOrBuilder getCarOrBuilder(
      int index);
}
