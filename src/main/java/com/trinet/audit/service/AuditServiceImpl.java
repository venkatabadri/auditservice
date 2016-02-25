package com.trinet.audit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.trinet.audit.dao.AuditDAO;
import com.trinet.audit.entity.Audit;
import com.trinet.audit.exceptions.AuditException;
import com.trinet.audit.response.AuditResponse;
import com.trinet.audit.util.FileUtils;
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
    private AuditDAO auditDAO;

    @Value("${audit.appender}")
    private String storageType;

    @Value("${audit.appender.file.location}")
    private String location;

    @Autowired
    public void setAuditDao(AuditDAO auditDAO) {
        this.auditDAO = auditDAO;
    }

    /**
     * Inserting audit data based on the storage type either file or mongodb
     * 
     * @throws AuditException
     */
    @Override
    public AuditResponse insertAuditDocument(Audit audit) throws AuditException {
        LOGGER.info("Executing  insertAuditDocument method ...");
        LOGGER.info("The specified Storage Type  is .. " + storageType);
        AuditResponse auditResponse = null;
        try {
            if (storageType.equals(ServiceConstants.STORAGE_TYPE_FLATFILE)) {
                FileUtils.writeToFile(location, audit.toString());
                auditResponse = new AuditResponse();
                auditResponse.setStatusCode("200");
                auditResponse.setStatusMessage(ServiceConstants.MESSAGE_RESPONSE_SUCCESS);
                LOGGER.info("Audit data stored in a file");

            } else if (storageType.equals(ServiceConstants.STORAGE_TYPE_MONGO)) {
                auditResponse = auditDAO.insertAuditDocument(audit);
                LOGGER.info("Audit data stored in a Mongo DB");

            }

        } catch (Exception e)
        {
            LOGGER.info(e.getMessage(), e);
        }

        return auditResponse;
    }

}
