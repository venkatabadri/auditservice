package com.trinet.audit.dao;

import com.trinet.audit.entity.Audit;
import com.trinet.audit.response.AuditResponse;

/**
 * @author laxmi_pabbaraju An interface used by AuditService
 */
public interface AuditDao {

    /**
     * saving audit details
     * 
     * @param audit
     * @return
     */
     AuditResponse insertAuditDocument(Audit audit);
}
