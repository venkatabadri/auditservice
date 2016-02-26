package com.trinet.audit.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trinet.audit.entity.Audit;
import com.trinet.audit.repository.AuditMongoRepository;
import com.trinet.audit.response.AuditResponse;
import com.trinet.audit.util.ServiceConstants;

/*
 * DAO Implementer class for auditDao.
 */
@Repository
public class AuditMongoDao implements AuditDao {

    /* LoggerFactory instance */
    private static final Logger LOGGER = LoggerFactory.getLogger(AuditMongoDao.class);

    /* Repository for audit */
    @Autowired
    private AuditMongoRepository audiMomgotRepository;

    public void setAuditRepository(AuditMongoRepository auditRepository) {
        this.audiMomgotRepository = auditRepository;
    }

    /**
     * this method is used to retrieve the audit details for the report.
     * 
     */
    @Override
    public AuditResponse insertAuditDocument(Audit audit) {
        LOGGER.info("Inserting audit document.....");
        audiMomgotRepository.save(audit);
        AuditResponse auditResponse = new AuditResponse();
        auditResponse.setStatusCode("200");
        auditResponse.setStatusMessage(ServiceConstants.MESSAGE_RESPONSE_SUCCESS);
        return auditResponse;
    }
}
