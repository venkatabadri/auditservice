package com.trinet.audit.core;

import java.util.Map;

public class AuditResponse {
    
    private String statusCode;
    private Map<String, AuditExcerption> auditException;
    
    public String getStatusCode() {
        return statusCode;
    }
    
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
    
    public Map<String, AuditExcerption> getAuditException() {
        return auditException;
    }
    
    public void setAuditException(Map<String, AuditExcerption> auditException) {
        this.auditException = auditException;
    }
    
}
