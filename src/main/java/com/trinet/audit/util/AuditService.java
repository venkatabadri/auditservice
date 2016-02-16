package com.trinet.audit.util;

import java.util.List;

import com.trinet.audit.core.AuditEvent;
import com.trinet.audit.core.AuditResponse;
import com.trinet.audit.dao.AuditDAO;

public class AuditService {
    private static AuditDAO auditDAO;
    
    public static AuditResponse audit(List<AuditEvent> auditTrail) {
        
        return (auditDAO).save(auditTrail);
    }
    
}
