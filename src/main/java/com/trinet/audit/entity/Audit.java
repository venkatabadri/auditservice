package com.trinet.audit.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

/**
 * 
 * @author laxmi_pabbaraju Audit object which represents Who,When and Where part
 *         of the audit.
 */
public class Audit implements Serializable {

    private static final long serialVersionUID = 1L;

    /** the unique id */
    @Id
    private String id;
    private String auditId;
    private String auditTrailId;
    private String employeeId;
    private String companyId;
    private String proxyEmployeeId;
    private String proxyCompanyId;
    private String timeStamp;
    private String userIP;
    private String browserInfo;
    private String osInfo;
    private String deviceInfo;
    private String environment;
    private String serverIP;
    private String application;
    private String feature;
    private String resource;
    private String bizEvent;
    private String method;
    private String statusCode;
    private String errorCode;
    private String request;
    private String response;

    public String getAuditId() {
        return auditId;
    }

    public void setAuditId(String auditId) {
        this.auditId = auditId;
    }

    public String getAuditTrailId() {
        return auditTrailId;
    }

    public void setAuditTrailId(String auditTrailId) {
        this.auditTrailId = auditTrailId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getProxyEmployeeId() {
        return proxyEmployeeId;
    }

    public void setProxyEmployeeId(String proxyEmployeeId) {
        this.proxyEmployeeId = proxyEmployeeId;
    }

    public String getProxyCompanyId() {
        return proxyCompanyId;
    }

    public void setProxyCompanyId(String proxyCompanyId) {
        this.proxyCompanyId = proxyCompanyId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    public String getBrowserInfo() {
        return browserInfo;
    }

    public void setBrowserInfo(String browserInfo) {
        this.browserInfo = browserInfo;
    }

    public String getOsInfo() {
        return osInfo;
    }

    public void setOsInfo(String osInfo) {
        this.osInfo = osInfo;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getBizEvent() {
        return bizEvent;
    }

    public void setBizEvent(String bizEvent) {
        this.bizEvent = bizEvent;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
