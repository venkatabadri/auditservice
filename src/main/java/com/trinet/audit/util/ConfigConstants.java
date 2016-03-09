package com.trinet.audit.util;

/**
 * <p>
 * Constants used for Audit Service.
 * </p>
 * 
 * @author laxmi_pabbaraju
 *
 */
public class ConfigConstants {
    /** Audit file location key. */
    public static final String AUDIT_CONFIG_FILE_LOC = "audit.configLocation";
    /** Audit appender key. */
    public static final String AUDIT_APPENDER = "audit.appender";
    /** Audit appender file location key. */
    public static final String AUDIT_APPENDER_FILE_LOC = "audit.appender.file.location";
    /** Audit Mongo DB host key. */
    public static final String AUDIT_MONGO_HOST = "spring.data.mongodb.host";
    /** Audit properties file name. */
    public static final String CONFIG_AUDIT_PROERTY_FILE = "application-audit.properties";
    
    /**
     * Private constructor
     */
    private ConfigConstants() {
        // No implementation
    }
}
