package com.trinet.audit.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trinet.audit.dao.AuditDAO;
import com.trinet.audit.entity.Audit;
import com.trinet.audit.response.AuditReport;
import com.trinet.audit.response.AuditResponse;

@Service
public class GenericAuditService implements AuditService {

    private static Logger LOGGER = LoggerFactory.getLogger(GenericAuditService.class);
    /**
     * the dao object
     */
    private AuditDAO auditDAO;

    @Autowired
    public void setAuditDao(AuditDAO auditDAO) {
        this.auditDAO = auditDAO;
    }

    @Override
    public AuditResponse insertAuditDocument(Audit audit) {
        LOGGER.info("Inside insertAuditDocument ...");
        AuditResponse auditResponse = auditDAO.insertAuditDocument(audit);
        LOGGER.info("AuditService Response .. " + auditResponse);
        return auditResponse;
    }

    @Override
    public AuditReport queryAuditDocument(Map<String, String> auditQueryInputMap) {
        LOGGER.info("Inside queryAuditDocument ...");
        AuditReport auditReport = auditDAO.queryAuditDocument(null);
        return auditReport;
    }

}
