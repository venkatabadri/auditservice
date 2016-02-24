package com.trinet.audit.dao;

import com.trinet.audit.entity.Audit;
import com.trinet.audit.exceptions.AuditException;
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
}
