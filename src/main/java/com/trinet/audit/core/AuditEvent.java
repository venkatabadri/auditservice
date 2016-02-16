package com.trinet.audit.core;

import java.util.List;

public class AuditEvent {
    private String userId;
    private String companyId;
    private String remoteClientIp;
    private String enttryName;
    private String recordIdentfierName;
    private String recordIdentfierValue;
    private String criticalFieldName;
    private String criticalFieldValue;
    private long timeStamp;
    private String serverId;
    private String action;
    private boolean isBlob;
    private String applicationName;
    private String methodName;
    private String uiPage;
    private String browserInfo;
    private String osInfo;
    private String mobileInfo;
    
    private List<AuditData> auditData;
    
    public String getUserId() {
        return userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    public String getCompanyId() {
        return companyId;
    }
    
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    
    public String getRemoteClientIp() {
        return remoteClientIp;
    }
    
    public void setRemoteClientIp(String remoteClientIp) {
        this.remoteClientIp = remoteClientIp;
    }
    
    public String getEnttryName() {
        return enttryName;
    }
    
    public void setEnttryName(String enttryName) {
        this.enttryName = enttryName;
    }
    
    public String getRecordIdentfierName() {
        return recordIdentfierName;
    }
    
    public void setRecordIdentfierName(String recordIdentfierName) {
        this.recordIdentfierName = recordIdentfierName;
    }
    
    public String getRecordIdentfierValue() {
        return recordIdentfierValue;
    }
    
    public void setRecordIdentfierValue(String recordIdentfierValue) {
        this.recordIdentfierValue = recordIdentfierValue;
    }
    
    public String getCriticalFieldName() {
        return criticalFieldName;
    }
    
    public void setCriticalFieldName(String criticalFieldName) {
        this.criticalFieldName = criticalFieldName;
    }
    
    public String getCriticalFieldValue() {
        return criticalFieldValue;
    }
    
    public void setCriticalFieldValue(String criticalFieldValue) {
        this.criticalFieldValue = criticalFieldValue;
    }
    
    public long getTimeStamp() {
        return timeStamp;
    }
    
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    public String getServerId() {
        return serverId;
    }
    
    public void setServerId(String serverId) {
        this.serverId = serverId;
    }
    
    public String getAction() {
        return action;
    }
    
    public void setAction(String action) {
        this.action = action;
    }
    
    public boolean isBlob() {
        return isBlob;
    }
    
    public void setBlob(boolean isBlob) {
        this.isBlob = isBlob;
    }
    
    public String getApplicationName() {
        return applicationName;
    }
    
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
    
    public String getMethodName() {
        return methodName;
    }
    
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    
    public String getUiPage() {
        return uiPage;
    }
    
    public void setUiPage(String uiPage) {
        this.uiPage = uiPage;
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
    
    public List<AuditData> getAuditData() {
        return auditData;
    }
    
    public void setAuditData(List<AuditData> auditData) {
        this.auditData = auditData;
    }
    
}
