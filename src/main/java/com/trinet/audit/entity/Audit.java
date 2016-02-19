package com.trinet.audit.entity;

import java.io.Serializable;

import org.json.simple.JSONObject;
import org.springframework.data.annotation.Id;

/**
 * 
 * @author laxmi_pabbaraju
 * Audit object which represents Who,When and Where part
 *         of the audit.
 */
public class Audit implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String auditId;
    private String employeeId;
    private String companyId;
    private String proxyEmployeeId;
    private String proxyCompanyId;
    private long timeStamp;
    private String userIP;
    private String browserInfo;
    private String osInfo;
    private String mobileInfo;
    private String environment;
    private String serverIP;
    private String application;
    private String feature;
    private String businessObject;
    private String eventType;
    private String comment;
    private JSONObject request;
    private JSONObject response;

   

    public String getAuditId() {
        return auditId;
    }

    public void setAuditId(String auditId) {
        this.auditId = auditId;
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

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
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

    public String getMobileInfo() {
        return mobileInfo;
    }

    public void setMobileInfo(String mobileInfo) {
        this.mobileInfo = mobileInfo;
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

    public String getBusinessObject() {
        return businessObject;
    }

    public void setBusinessObject(String businessObject) {
        this.businessObject = businessObject;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public JSONObject getRequest() {
        return request;
    }

    public void setRequest(JSONObject request) {
        this.request = request;
    }

    public JSONObject getResponse() {
        return response;
    }

    public void setResponse(JSONObject response) {
        this.response = response;
    }

}
