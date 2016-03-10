package com.trinet.audit.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trinet.audit.dao.AuditDao;
import com.trinet.audit.entity.Audit;
import com.trinet.audit.response.AuditResponse;
import com.trinet.audit.util.AuditUtils;
import com.trinet.audit.util.ConfigConstants;
import com.trinet.audit.util.ServiceConstants;

/**
 * Audit service Implementation
 * 
 * @author laxmi_pabbaraju
 *
 */
@Service
public class AuditServiceImpl implements AuditService {

    /* Instance of Logger Factory */
    private static final Logger LOGGER = LoggerFactory.getLogger(AuditServiceImpl.class);

    /* The audit dao */
    private AuditDao auditDao;

    // @Value("${audit.appender}")
    private String storageType;

    // @Value("${audit.appender.file.location}")
    private String location;

    // @Value("${spring.data.mongodb.host}")
    private String mongodetails;

    @Autowired
    public void setAuditDao(AuditDao auditDao) {
        this.auditDao = auditDao;
    }

    /**
     * Setting Storage type
     * 
     * @param storageType
     */
    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    /**
     * set Location Type
     * 
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Inserting audit data based on the storage type either file or mongodb
     **/
    @Override
    public AuditResponse insertAuditDocument(Audit audit) {
        AuditResponse auditResponse = null;
        setAuditData(audit);
        try {
            if (storageType != null && storageType.equalsIgnoreCase(ServiceConstants.STORAGE_TYPE_FLATFILE)) {
                auditResponse = insertAuditLogs(audit);
            } else if (storageType != null && storageType.equalsIgnoreCase(ServiceConstants.STORAGE_TYPE_MONGO)) {
                auditResponse = insertAuditLogToMongoDB(audit);
            }
            auditResponse = verifyAudit(audit,auditResponse);
        } catch (Exception e) {
            audit.setAuditId(null);
            auditResponse = setResponseObject(audit, e.getMessage(), ServiceConstants.MESSAGE_RESPONSE_FAIL_CODE);
            LOGGER.info(e.toString(), e);
        }
        return auditResponse;
    }

    /**
     * Sets the {@link Audit} properties.
     * 
     * @param audit
     *            The {@link Audit} object.
     */
    private void setAuditData(Audit audit) {
        setAuditProperties();
        setAuditId(audit);
        audit.setTimeStamp(AuditUtils.getISO8601StringForDate());
    }

    /**
     * Verifies the {@link Audit} data.
     * 
     * @param audit
     *            The {@link Audit} object
     * @param auditResponse
     *            The {@link AuditResponse} object
     * @return The {@link AuditResponse} object
     */
    private AuditResponse verifyAudit(Audit audit, AuditResponse auditResponse) {
        if (AuditUtils.verifyAudit(audit)) {
            auditResponse = setResponseObject(audit, ServiceConstants.AUDIT_FIELDVALIDATION_MSG,
                    ServiceConstants.MESSAGE_RESPONSE_FORBIDDEN_CODE);
            LOGGER.info("Insufficient input data for auditing....");
        }
        return auditResponse;
    }

    /**
     * Sets the {@link Audit} Id.
     * 
     * @param audit
     *            The {@link Audit} object
     */
    private void setAuditId(Audit audit) {
        if (AuditUtils.isStringEmpty(audit.getAuditId())) {
            audit.setAuditId(java.util.UUID.randomUUID().toString());
        }
    }

    /**
     * Inserts the {@link Audit} document.
     * 
     * @param audit
     *            The {@link Audit} object
     * @return The {@link AuditResponse} object
     */
    private AuditResponse insertAuditLogToMongoDB(Audit audit) {
        AuditResponse auditResponse;
        if (mongodetails.isEmpty()) {
            return setResponseObject(audit, "Mongodb details are required.",
                    ServiceConstants.MESSAGE_RESPONSE_FAIL_CODE);
        }
        auditResponse = auditDao.insertAuditDocument(audit);
        LOGGER.info("Audit data stored in a Mongo DB");
        return auditResponse;
    }

    /**
     * Write {@link Audit} logs to file.
     * 
     * @param audit
     *            The {@link Audit} object
     * @return The {@link AuditResponse} object
     * @throws IOException
     *             The {@link IOException} object
     */
    private AuditResponse insertAuditLogs(Audit audit) throws IOException {
        AuditResponse auditResponse;
        if (location == null || location.isEmpty()) {
            return setResponseObject(audit, "File location is required",
                    ServiceConstants.MESSAGE_RESPONSE_FAIL_CODE);
        }
        AuditUtils.writeToFile(location, audit);
        auditResponse = setResponseObject(audit, ServiceConstants.MESSAGE_RESPONSE_SUCCESS,
                ServiceConstants.MESSAGE_RESPONSE_OK_CODE);
        LOGGER.info("Audit data stored in a file");
        return auditResponse;
    }

    /**
     * Sets the {@link Audit} properties.
     */
    private void setAuditProperties() {
        Properties properties;
        try {
            properties = AuditUtils.loadPropertiesFileFromEnv();
            storageType = properties.getProperty(ConfigConstants.AUDIT_APPENDER);
            location = properties.getProperty(ConfigConstants.AUDIT_APPENDER_FILE_LOC);
            mongodetails = properties.getProperty(ConfigConstants.AUDIT_MONGO_HOST);
            LOGGER.info("storageType :  " + storageType + "Location ::" + location);

        } catch (Exception e) {
            LOGGER.info(e.toString(), e);
        }
    }

    /**
     * Creating Audit response using code,and error message
     * 
     * @param audit
     *            The {@link Audit} object
     * @param message
     *            The audit message
     * @param code
     *            The code
     * @return The {@link AuditResponse} object
     */
    private AuditResponse setResponseObject(Audit audit, String message, String code) {
        AuditResponse auditResponse = new AuditResponse();
        auditResponse.set_auditid(audit.getAuditId());
        auditResponse.set_statusCode(code);
        auditResponse.set_statusMessage(message);
        return auditResponse;
    }

}
