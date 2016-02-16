package com.trinet.audit.dao;

import java.util.List;

import com.trinet.audit.core.AuditEvent;
import com.trinet.audit.core.AuditReport;
import com.trinet.audit.core.AuditResponse;

public interface AuditDAO {
    public AuditResponse save(List<AuditEvent> auditTrail);
    
    public AuditReport queryAudit(List<AuditEvent> auditTrail);
    
}
