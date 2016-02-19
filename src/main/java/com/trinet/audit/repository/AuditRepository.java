/**
 * 
 */
package com.trinet.audit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.trinet.audit.entity.Audit;



/**
 * @author laxmi_pabbaraju
 * 
 */
public interface AuditRepository extends MongoRepository<Audit, String> {

}
