package com.trinet.audit.entity;

import java.io.Serializable;
import java.util.List;

/**
 *  
 * @author laxmi_pabbaraju
 * AuditEvent object also contains a list of AuditData which represents WHAT part of the audit data.
 */
public class AuditEvent implements Serializable {

    private static final long serialVersionUID = 1L;
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

    @Override
    public String toString() {
        return "AuditEvent [userId=" + userId + ", companyId=" + companyId + ", remoteClientIp=" + remoteClientIp
                + ", enttryName=" + enttryName + ", recordIdentfierName=" + recordIdentfierName
                + ", recordIdentfierValue=" + recordIdentfierValue + ", criticalFieldName=" + criticalFieldName
                + ", criticalFieldValue=" + criticalFieldValue + ", timeStamp=" + timeStamp + ", serverId=" + serverId
                + ", action=" + action + ", isBlob=" + isBlob + ", applicationName=" + applicationName + ", methodName="
                + methodName + ", uiPage=" + uiPage + ", browserInfo=" + browserInfo + ", osInfo=" + osInfo
                + ", mobileInfo=" + mobileInfo + ", auditData=" + auditData + "]";
    }

}
