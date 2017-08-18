/**
 * TemperatureService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.webServices;

public interface TemperatureService extends javax.xml.rpc.Service {
    public java.lang.String getTemperatureAddress();

    public com.webServices.Temperature getTemperature() throws javax.xml.rpc.ServiceException;

    public com.webServices.Temperature getTemperature(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
