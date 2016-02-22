package com.trinet.audit.response;

/*
 * This class is used for reporting audit data .
 */
public class AuditReport {

    /* The status code */
    private String statusCode;

    /* The status message */
    private String message;

    /* the result of response data */
    private String result;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
