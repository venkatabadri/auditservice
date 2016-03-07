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
import com.trinet.audit.exceptions.AuditException;
import com.trinet.audit.response.AuditResponse;
import com.trinet.audit.util.AuditUtils;
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

    @Value("${audit.appender}")
    private String storageType;

    @Value("${audit.appender.file.location}")
    private String location;

    @Value("${spring.data.mongodb.host}")
    private String mongodetails;

    @Autowired
    public void setAuditDao(AuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Inserting audit data based on the storage type either file or mongodb
     * 
     * @throws AuditException
     */
    @Override
    public AuditResponse insertAuditDocument(Audit audit) {

        AuditResponse auditResponse = null;
        Properties properties;
        try {
            properties = AuditUtils.loadPropertiesFileFromEnv();
            storageType = (String) properties.getProperty("audit.appender");
            location = (String) properties.getProperty("audit.appender.file.location");
            mongodetails = (String) properties.getProperty("spring.data.mongodb.host");
            LOGGER.info("storageType :  " + storageType + "Location ::" + location);

        } catch (FileNotFoundException e) {
            LOGGER.info(e.getMessage());
        }
        LOGGER.info("Storage Type ::" + storageType);
        if (AuditUtils.isStringEmpty(audit.getAuditId())) {
            audit.setAuditId(java.util.UUID.randomUUID().toString());
        }
        audit.setTimeStamp(AuditUtils.getISO8601StringForDate());
        try {
            if (storageType != null && storageType.equals(ServiceConstants.STORAGE_TYPE_FLATFILE)) {
                AuditUtils.writeToFile(location, audit);
                auditResponse = new AuditResponse();
                auditResponse.set_auditid(audit.getAuditId());
                auditResponse.set_statusCode("200");
                auditResponse.set_statusMessage(ServiceConstants.MESSAGE_RESPONSE_SUCCESS);
                LOGGER.info("Audit data stored in a file");

            } else if (storageType != null && storageType.equals(ServiceConstants.STORAGE_TYPE_MONGO)) {
                LOGGER.info("insideaudit mongodetails" + mongodetails);
                auditResponse = auditDao.insertAuditDocument(audit);
                LOGGER.info("Audit data stored in a Mongo DB");
            }

            if (AuditUtils.verifyAudit(audit)) {
                auditResponse = new AuditResponse();
                auditResponse.set_auditid(audit.getAuditId());
                auditResponse.set_statusCode("400");
                auditResponse.set_statusMessage(ServiceConstants.AUDIT_FIELDVALIDATION_MSG);

                LOGGER.info("Insufficient input data for auditing. ...");
            }
        } catch (Exception e) {
            auditResponse = new AuditResponse();
            auditResponse.set_auditid(audit.getAuditId());
            auditResponse.set_statusCode("500");
            auditResponse.set_statusMessage(e.getMessage());
            LOGGER.info(e.toString(), e);
        }

        return auditResponse;
    }

}
