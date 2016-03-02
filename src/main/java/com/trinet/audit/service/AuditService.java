package com.trinet.audit.service;

import com.trinet.audit.entity.Audit;
import com.trinet.audit.response.AuditResponse;

/**
 * An interface to access audit service api
 * 
 * @author laxmi_pabbaraju
 *
 */
public interface AuditService {

     AuditResponse insertAuditDocument(Audit audit);

}
