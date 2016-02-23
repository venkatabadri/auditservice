package com.trinet.audit.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.trinet.audit.util.ServiceConstants;
/**
 * 
 * @author venkata_badri
 *
 */
public class AuditDAOFactory {
   /**
    * 
    */
    @Autowired
    private AuditMongoDAO mongoAuditDAO; 
  
    
    //@Autowired
   // private AuditCassandaraDAO auditCassandaraDAO; 
  
    /**
     * 
     * @param daoType
     * @return
     */
    public AuditDAO  getDAO(String daoType ){
        
        if(daoType.equals(ServiceConstants.MONGO_DB)){
            return mongoAuditDAO;
        } else {
            return null;
        }
    }

}
