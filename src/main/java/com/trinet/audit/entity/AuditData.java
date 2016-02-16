/**
 * 
 */
package com.trinet.audit.entity;

import java.io.Serializable;

/**
 * @author laxmi_pabbaraju It represents the data item in the entity
 * WHAT” part of the audit service
 */
public class AuditData implements Serializable {

   
    private static final long serialVersionUID = -8994694496176954129L;
    private String columnName;
    private String oldValue;
    private String newValue;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

}
