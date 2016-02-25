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

    private ServiceConstants() {
        super();
    }
}