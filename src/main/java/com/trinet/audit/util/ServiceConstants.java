package com.trinet.audit.util;

/**
 * @author laxmi_pabbaraju
 *
 */
public final class ServiceConstants {

    /**
     * response Success
     */
    public static final String MESSAGE_RESPONSE_SUCCESS = "Success";

    /**
     * response Fail
     */
    public static final String MESSAGE_RESPONSE_FAIL = "Fail";

    /**
     * File appender type is mongodb
     */
    public static final String STORAGE_TYPE_MONGO = "mongodb";

    /**
     * File appender type is file
     */
    public static final String STORAGE_TYPE_FLATFILE = "file";

    /**
     * Audit filename
     */
    public static final String AUDIT_FILENAME = "auditlog.txt";
    
    /**
     * 
     */
    public static final String AUDIT_FIELDVALIDATION_MSG = "Insufficient input data for auditing.";
    
    /**
     * Response code for success
     */
    public static final String MESSAGE_RESPONSE_OK_CODE = "200";

    /**
     *  Response code for forbidden
     */
    public static final String MESSAGE_RESPONSE_FORBIDDEN_CODE = "400";
    
    /**
     *  Response code for failure
     */
    public static final String MESSAGE_RESPONSE_FAIL_CODE = "500";


    private ServiceConstants() {
        super();
    }
}