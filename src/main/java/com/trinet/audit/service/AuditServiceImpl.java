package com.trinet.audit.service;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.trinet.audit.dao.AuditDao;
import com.trinet.audit.entity.Audit;
import com.trinet.audit.response.AuditResponse;
import com.trinet.audit.util.AuditUtils;
import com.trinet.audit.util.ConfigConstants;
import com.trinet.audit.util.ServiceConstants;

/**
 * Audit service Implementation
 * @author laxmi_pabbaraju
 *
 */
@Service
public class AuditServiceImpl implements AuditService {

    /* Instance of Logger Factory */
    private static final Logger LOGGER = LoggerFactory.getLogger(AuditServiceImpl.class);

    /* The audit dao */
    private AuditDao auditDao;

    //@Value("${audit.appender}")
    private String storageType;

    //@Value("${audit.appender.file.location}")
    private String location;

    //@Value("${spring.data.mongodb.host}")
    private String mongodetails;

    @Autowired
    public void setAuditDao(AuditDao auditDao) {
        this.auditDao = auditDao;
    }

   /**
    * Setting Storage type
    * @param storageType
    */
    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    /**
     * set Location Type
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
        Properties properties;
        try {
            properties = AuditUtils.loadPropertiesFileFromEnv();
            storageType = properties.getProperty(ConfigConstants.AUDIT_APPENDER);
            location = properties.getProperty(ConfigConstants.AUDIT_APPENDER_FILE_LOC);
            mongodetails = properties.getProperty(ConfigConstants.AUDIT_MONGO_HOSt);
            LOGGER.info("storageType :  " + storageType + "Location ::" + location);

        } catch (FileNotFoundException ex) {
            LOGGER.info(ex.toString(), ex);
        }

        if (AuditUtils.isStringEmpty(audit.getAuditId())) {
            audit.setAuditId(java.util.UUID.randomUUID().toString());
        }
        audit.setTimeStamp(AuditUtils.getISO8601StringForDate());
        try {
            if (storageType != null && storageType.equalsIgnoreCase(ServiceConstants.STORAGE_TYPE_FLATFILE)) {
                if (location == null || location.isEmpty()) {
                    return setResopnseObject(audit, "File location is required", ServiceConstants.MESSAGE_RESPONSE_FAIL_CODE);
                }
                AuditUtils.writeToFile(location, audit);
                auditResponse = setResopnseObject(audit, ServiceConstants.MESSAGE_RESPONSE_SUCCESS, ServiceConstants.MESSAGE_RESPONSE_OK_CODE);
                LOGGER.info("Audit data stored in a file");

            } else if (storageType != null && storageType.equalsIgnoreCase(ServiceConstants.STORAGE_TYPE_MONGO)) {
                if (mongodetails.isEmpty()) {
                    return setResopnseObject(audit, "Mongodb details are required.", ServiceConstants.MESSAGE_RESPONSE_FAIL_CODE);
                }
                auditResponse = auditDao.insertAuditDocument(audit);
                LOGGER.info("Audit data stored in a Mongo DB");
            }

            if (AuditUtils.verifyAudit(audit)) {
                auditResponse = setResopnseObject(audit, ServiceConstants.AUDIT_FIELDVALIDATION_MSG,ServiceConstants.MESSAGE_RESPONSE_FORBIDDEN_CODE);
                LOGGER.info("Insufficient input data for auditing. ...");
            }
        } catch (Exception e) {
            auditResponse = setResopnseObject(audit, e.getMessage(), ServiceConstants.MESSAGE_RESPONSE_FAIL_CODE);
            LOGGER.info(e.toString(), e);
        }

        return auditResponse;
    }

    /**
     * creating Audit response using code,and error message
     * @param audit
     * @param message
     * @param code
     * @return
     */
    private AuditResponse setResopnseObject(Audit audit, String message, String code) {
        AuditResponse auditResponse = new AuditResponse();
        if(audit.getAuditId()!=null){
            auditResponse.set_auditid(audit.getAuditId());
        }
        auditResponse.set_statusCode(code);
        auditResponse.set_statusMessage(message);
        return auditResponse;
    }

}
