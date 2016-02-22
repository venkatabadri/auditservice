package com.trinet.audit.dao;

import java.util.Map;

import com.trinet.audit.entity.Audit;
import com.trinet.audit.exceptions.AuditException;
import com.trinet.audit.response.AuditReport;
import com.trinet.audit.response.AuditResponse;

/**
 * @author laxmi_pabbaraju An interface used by AuditService
 */
public interface AuditDAO {

    /**
     * saving audit details
     * 
     * @param audit
     * @return
     */
    public AuditResponse insertAuditDocument(Audit audit) throws AuditException;

    /**
     * Retrieving audit details based on the query parameters
     * 
     * @param auditQueryInputMap
     * @return
     */
    public AuditReport queryAuditDocument(Map<String, String> auditQueryInputMap)  throws AuditException;

    /**
     * find audit data by id
     * @param auditQueryInputMap
     * @return
     */
    public AuditReport findById(Map<String, String> auditQueryInputMap);

}
