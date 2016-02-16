package com.trinet.audit.dao;

import java.util.List;

import com.trinet.audit.entity.AuditEvent;
import com.trinet.audit.response.AuditReport;
import com.trinet.audit.response.AuditResponse;

/**
 * @author laxmi_pabbaraju
 *
 */
public interface AuditDAO {

    public AuditResponse insertAuditDocument(List<AuditEvent> auditEvents);

    public AuditReport queryAuditDocument(List<AuditEvent> auditEvents);

}
