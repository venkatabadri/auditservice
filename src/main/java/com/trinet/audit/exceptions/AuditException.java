package com.trinet.audit.exceptions;

/**
 *  User defined exception for Audit actions
 * @author laxmi_pabbaraju
 *
 */
public class AuditException extends Exception {
    
    
     public AuditException(){
         super ();
        
    }
    public AuditException( String message){
         super (message);
        
    }
}
