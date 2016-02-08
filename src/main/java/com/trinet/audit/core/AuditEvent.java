package com.trinet.audit.core;

import java.util.List;

public class AuditEvent {
	 private String userId;
	    private String companyId;
	    private String remoteClientIp;
	    private String tableIdentfier;
	    private String keyIdentfier;
	    private String keyDatatypes;
	    private String keyValues;
	    private long timeStamp;
	    private String serverId;
	    private String action;
	    

		private DeviceInfo deviceInfo;
	    private Application applicatiion;
	    
	    private List<AuditData> auditData;

}
