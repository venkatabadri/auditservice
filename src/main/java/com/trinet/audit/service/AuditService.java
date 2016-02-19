package com.trinet.audit.service;

import java.util.Map;

import com.trinet.audit.entity.Audit;
import com.trinet.audit.response.AuditReport;
import com.trinet.audit.response.AuditResponse;

/**
 * An interface to access audit service api
 * 
 * @author laxmi_pabbaraju
 *
 */
public interface AuditService {

    public AuditResponse insertAuditDocument(Audit audit);

    public AuditReport queryAuditDocument(Map<String, String> auditQueryInputMap);

}
