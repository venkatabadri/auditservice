package com.trinet.audit.service;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.trinet.audit.TrinetAuditApplication;
import com.trinet.audit.entity.Audit;
import com.trinet.audit.exceptions.AuditException;
import com.trinet.audit.response.AuditReport;
import com.trinet.audit.response.AuditResponse;
import com.trinet.audit.util.ServiceConstants;

/**
 * Test case to test the audit service api
 * 
 * @author laxmi_pabbaraju
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TrinetAuditApplication.class)
public class AuditServiceTest {

    @Autowired
    AuditService auditService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void insertAuditDocumentTest() throws AuditException {

        AuditResponse auditResponse = auditService.insertAuditDocument(createAuditObject());
        assertTrue(auditResponse.getStatusCode().equals("200"));
        assertTrue(auditResponse.getStatusMessage().equals(ServiceConstants.MESSAGE_RESPONSE_SUCCESS));

    }

    @Test
    public void getAuditsTest() throws AuditException {

        AuditReport auditReport = auditService.queryAuditDocument(null);
        assertTrue(auditReport != null);
        assertTrue(auditReport.getMessage().equals(ServiceConstants.MESSAGE_RESPONSE_SUCCESS));
    }

    @Test
    public void getAuditByIdTest() throws AuditException {

        HashMap<String, String> queryMap = new HashMap<String, String>();
        queryMap.put("auditId", "56c6dafd2a872ff061ffc022");
        AuditReport auditReport = auditService.findById(queryMap);
        assertTrue(auditReport != null);
        assertTrue(auditReport.getMessage().equals(ServiceConstants.MESSAGE_RESPONSE_SUCCESS));

    }

    private Audit createAuditObject() {

        Audit audit = new Audit();
        audit.setEmployeeId("10713");
        audit.setCompanyId("PSl1");
        audit.setProxyEmployeeId("1234");
        audit.setProxyCompanyId("PSLHYD");
        audit.setTimeStamp(System.currentTimeMillis());
        audit.setUserIP("127.0.0.1");
        audit.setBrowserInfo("ChromBrowser");
        audit.setOsInfo("Windows7");
        audit.setMobileInfo("Samsung");
        audit.setEnvironment("Dev Environment");
        audit.setServerIP("127.0.0.1");
        audit.setApplication("Employee");
        audit.setFeature("Feature 1");
        audit.setBusinessObject("BusinessObject");
        audit.setEventType("CREATE");
        audit.setComment("Testing Audit");

        JSONObject jsonRequest = new JSONObject();
        jsonRequest.put("empId", "7970");
        jsonRequest.put("empName", "Nagu");
        jsonRequest.put("age", "30");
        jsonRequest.put("salary", "12000");
        jsonRequest.put("designation", "Engineer");
        jsonRequest.put("manager", "Jhon");
        jsonRequest.put("location", "Pune");

        audit.setRequest(jsonRequest);

        JSONObject jsonResponse = new JSONObject();
        jsonRequest.put("statuscode", "200");
        jsonRequest.put("status", "success");

        audit.setResponse(jsonRequest);
        return audit;
    }

}
