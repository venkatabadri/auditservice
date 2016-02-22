package com.trinet.audit.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trinet.audit.entity.Audit;
import com.trinet.audit.repository.AuditRepository;
import com.trinet.audit.response.AuditReport;
import com.trinet.audit.response.AuditResponse;
import com.trinet.audit.util.ServiceConstants;

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
        auditResponse.setStatusMessage(ServiceConstants.MESSAGE_RESPONSE_SUCCESS);
        return auditResponse;
    }

    /**
     * get the audit logs from the specified query parameters
     */
    @Override
    public AuditReport queryAuditDocument(Map<String, String> auditQueryInputMap) {

        List<Audit> events = null;
        AuditReport auditReport = new AuditReport();
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {

            if (auditQueryInputMap == null) {
                events = auditRepository.findAll();
                auditReport.setMessage(ServiceConstants.MESSAGE_RESPONSE_SUCCESS);
                auditReport.setStatusCode("200");
                jsonStr = mapperObj.writeValueAsString(events);
                LOGGER.info("Response from Audit service ::" + jsonStr);
                auditReport.setResult(jsonStr);

            }
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return auditReport;
    }

    /**
     * get the audit details by specified id  in the query map
     */
    @Override
    public AuditReport findById(Map<String, String> auditQueryInputMap) {
       Audit audit = null;
        AuditReport auditReport = new AuditReport();
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {

            if (auditQueryInputMap != null) {
                audit = auditRepository.findOne(auditQueryInputMap.get("auditId"));
                auditReport.setMessage(ServiceConstants.MESSAGE_RESPONSE_SUCCESS);
                auditReport.setStatusCode("200");
                jsonStr = mapperObj.writeValueAsString(audit);
                LOGGER.info("Audit details retrieved  ::" + jsonStr);
                auditReport.setResult(jsonStr);

            }
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return auditReport;
    }

    
    
}
