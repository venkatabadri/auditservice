/**
 * 
 */
package com.trinet.audit.response;

import java.util.Map;

import com.trinet.audit.exceptions.AuditException;

/**
 * @author laxmi_pabbaraju This class is used to set audit response with status
 *         code and exception
 */
public class AuditResponse {

    /**
     * the status code of response data
     */
    private String statusCode;
    private Map<String, AuditException> auditException;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, AuditException> getAuditException() {
        return auditException;
    }

    public void setAuditException(Map<String, AuditException> auditException) {
        this.auditException = auditException;
    }

    @Override
    public String toString() {
        return "AuditResponse [statusCode=" + statusCode + ", auditException=" + auditException + "]";
    }

}
