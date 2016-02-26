package com.trinet.audit.service;

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

    @Autowired
    public void setAuditDao(AuditDao auditDao) {
        this.auditDao = auditDao;
    }

    /**
     * Inserting audit data based on the storage type either file or mongodb
     * 
     * @throws AuditException
     */
    @Override
    public AuditResponse insertAuditDocument(Audit audit) throws AuditException {

        AuditResponse auditResponse = null;
        if (!AuditUtils.verifyAudit(audit)) {

            LOGGER.info("Executing  insertAuditDocument method ...");
            LOGGER.info("The specified Storage Type  is .. " + storageType);
            
            try {
                if (storageType.equals(ServiceConstants.STORAGE_TYPE_FLATFILE)) {
                    AuditUtils.writeToFile(location, audit.toString());
                    auditResponse = new AuditResponse();
                    auditResponse.setStatusCode("200");
                    auditResponse.setStatusMessage(ServiceConstants.MESSAGE_RESPONSE_SUCCESS);
                    LOGGER.info("Audit data stored in a file");

                } else if (storageType.equals(ServiceConstants.STORAGE_TYPE_MONGO)) {
                    auditResponse = auditDao.insertAuditDocument(audit);
                    LOGGER.info("Audit data stored in a Mongo DB");

                }

            } catch (Exception e) {
                LOGGER.info(e.getMessage(), e);
            }
        } else {
            auditResponse = new AuditResponse();
            auditResponse.setStatusCode("500");
            auditResponse.setStatusMessage(ServiceConstants.AUDIT_FIELDVALIDATION_MSG);
            LOGGER.info("Insufficient input data for auditing. ...");
            LOGGER.info(auditResponse.toString());
        }

        return auditResponse;
    }

}
