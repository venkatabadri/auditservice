package com.trinet.audit.exceptions;

/**
 * User defined exception for Audit actions
 * 
 * @author laxmi_pabbaraju
 *
 */
public class AuditException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 967033981824886178L;

    public AuditException() {
        super();

    }

    public AuditException(String message) {
        super(message);

    }
}
