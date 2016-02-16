package com.trinet.audit.response;

import java.util.List;
import java.util.Map;

/*
 * This class  is used for reporting audit data .
 */
public class AuditReport {

	private List<Map<String,String>> data;

	public List<Map<String, String>> getData() {
		return data;
	}

	public void setData(List<Map<String, String>> data) {
		this.data = data;
	}
	
}
