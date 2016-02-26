package com.trinet.audit.response;

/**
 * @author laxmi_pabbaraju This class is used to set audit response with status
 *         code and message description
 */
public class AuditResponse {

    /* The status code of response data */
    private String _statusCode;

    /* The status message of response data */
    private String _statusMessage;

    /* Get the status code of response */
    public String get_statusCode() {
        return _statusCode;
    }

    /* Set the status code of response */
    public void set_statusCode(String _statusCode) {
        this._statusCode = _statusCode;
    }

    /* Get the status message of response */
    public String get_statusMessage() {
        return _statusMessage;
    }

    /* Set the status message of response */
    public void set_statusMessage(String _statusMessage) {
        this._statusMessage = _statusMessage;
    }

    @Override
    public String toString() {
        return "AuditResponse [_statusCode=" + _statusCode + ", _statusMessage=" + _statusMessage + "]";
    }
}
