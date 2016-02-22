package com.trinet.audit.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trinet.audit.dao.AuditDAO;
import com.trinet.audit.entity.Audit;
import com.trinet.audit.exceptions.AuditException;
import com.trinet.audit.response.AuditReport;
import com.trinet.audit.response.AuditResponse;

/**
 * Audit service Implementation
 * @author laxmi_pabbaraju
 *
 */
@Service
public class AuditServiceImpl implements AuditService {

    private static Logger LOGGER = LoggerFactory.getLogger(AuditServiceImpl.class);
    /**
     * the dao object
     */
    private AuditDAO auditDAO;

    @Autowired
    public void setAuditDao(AuditDAO auditDAO) {
        this.auditDAO = auditDAO;
    }

    /**
     * Inserting audit data to nosql
     * @throws AuditException 
     */
    @Override
    public AuditResponse insertAuditDocument(Audit audit) throws AuditException  {
        LOGGER.info("Inside insertAuditDocument ...");
        AuditResponse auditResponse = auditDAO.insertAuditDocument(audit);
        LOGGER.info("AuditService Response .. " + auditResponse);
        return auditResponse;
    }

    /**
     * Retrieving  all audit data using query parameter
     * @throws AuditException 
     */
    @Override
    public AuditReport queryAuditDocument(Map<String, String> auditQueryInputMap) throws AuditException {
        LOGGER.info("Inside queryAuditDocument ...");
        AuditReport auditReport = auditDAO.queryAuditDocument(null);
        return auditReport;
    }

    /**
     * Retrieving audit data using query parameter or by id
     */
    @Override
    public AuditReport findById(Map<String, String> auditQueryInputMap) {
        LOGGER.info("Inside findById ...");
        AuditReport auditReport = auditDAO.findById(auditQueryInputMap);
        return auditReport;
    }

}
