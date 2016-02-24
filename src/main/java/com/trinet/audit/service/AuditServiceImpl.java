package com.trinet.audit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trinet.audit.dao.AuditDAO;
import com.trinet.audit.entity.Audit;
import com.trinet.audit.exceptions.AuditException;
import com.trinet.audit.response.AuditResponse;

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

    @Autowired
    public void setAuditDao(AuditDAO auditDAO) {
        this.auditDAO = auditDAO;
    }

    /**
     * Inserting audit data to nosql
     * 
     * @throws AuditException
     */
    @Override
    public AuditResponse insertAuditDocument(Audit audit) throws AuditException {
        LOGGER.info("Inside insertAuditDocument ...");
        AuditResponse auditResponse = auditDAO.insertAuditDocument(audit);
        LOGGER.info("AuditService Response .. " + auditResponse);
        return auditResponse;
    }
}
