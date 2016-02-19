package com.trinet.audit.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trinet.audit.entity.Audit;
import com.trinet.audit.repository.AuditRepository;
import com.trinet.audit.response.AuditReport;
import com.trinet.audit.response.AuditResponse;

/*
 * DAO Implementer class for auditDao.
 */
@Repository
public class AuditDAOImpl implements AuditDAO {

    private static Logger LOGGER = LoggerFactory.getLogger(AuditDAOImpl.class);

    private AuditRepository auditRepository;

    public AuditRepository getAuditRepository() {
        return auditRepository;
    }

    @Autowired
    public void setAuditRepository(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    /**
     * this method is used to retrieve the audit details for the report.
     * 
     */
    @Override
    public AuditResponse insertAuditDocument(Audit audit) {
        LOGGER.info("Inserting audit document.....");
        auditRepository.save(audit);
        AuditResponse auditResponse = new AuditResponse();
        auditResponse.setStatusCode("200");
        auditResponse.setAuditException(null);
        return auditResponse;
    }

    /**
     * get the audit logs from the specified query parameters
     */
    @Override
    public AuditReport queryAuditDocument(Map<String, String> auditQueryInputMap) {

        List<Audit> events = auditRepository.findAll();
        AuditReport auditReport = new AuditReport();
        auditReport.setMessage("SUCCESS");
        auditReport.setStatusCode("200");
        
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
            jsonStr = mapperObj.writeValueAsString(events);
            LOGGER.info("Response from Audit service ::" + jsonStr);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
        }
        auditReport.setResult(jsonStr);
        return auditReport;
    }

}
