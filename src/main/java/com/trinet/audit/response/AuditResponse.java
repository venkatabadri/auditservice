package com.trinet.audit.response;

/**
 * @author laxmi_pabbaraju This class is used to set audit response with status
 *         code and message description
 */
public class AuditResponse {

    /* The status code of response data */
    private String statusCode;

    /* The status message of response data */
    private String statusMessage;

    /* Get the status code of response */
    public String getStatusCode() {
        return statusCode;
    }

    /* Set the status code of response */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /* Get the status message of response */
    public String getStatusMessage() {
        return statusMessage;
    }

    /* Set the status message of response */
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    /* String representation of object */
    @Override
    public String toString() {
        return "AuditResponse [statusCode=" + statusCode + ", statusMessage=" + statusMessage + "]";
    }

}
