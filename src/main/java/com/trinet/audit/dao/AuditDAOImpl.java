package com.trinet.audit.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.trinet.audit.entity.AuditEvent;
import com.trinet.audit.response.AuditReport;
import com.trinet.audit.response.AuditResponse;

/*
 * DAO Implementer class for auditDao.
 */
@Repository
public class AuditDAOImpl implements AuditDAO {

    private static Logger LOGGER = Logger.getLogger(AuditDAOImpl.class);

     /**
     * this method is used to retrieve the audit details for the report.
     * 
     */
    @Override
    public AuditResponse insertAuditDocument(List<AuditEvent> auditEvents) {
        LOGGER.info("Inside AuditDAO save......");
        if (auditEvents != null && !auditEvents.isEmpty())
            System.out.println(auditEvents.get(0));

        AuditResponse auditResponse = new AuditResponse();
        auditResponse.setStatusCode("200");
        auditResponse.setAuditException(null);

        return auditResponse;
    }

    @Override
    public AuditReport queryAuditDocument(List<AuditEvent> auditEvents) {
        // TODO Auto-generated method stub
        return null;
    }

}
