package com.trinet.audit.service;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.trinet.audit.TrinetAuditApplication;
import com.trinet.audit.entity.Audit;
import com.trinet.audit.response.AuditReport;
import com.trinet.audit.response.AuditResponse;

/**
 * Test case to test the audit service
 * 
 * @author laxmi_pabbaraju
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TrinetAuditApplication.class)
@WebAppConfiguration
public class AuditServiceTest {

    @Autowired
    private AuditService auditService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void insertAuditDocumentTest() {

        AuditResponse auditResponse = auditService.insertAuditDocument(getAuditObject());
        assertTrue(auditResponse.getStatusCode().equals("200"));
        assertNull(auditResponse.getAuditException());

    }
    
    @Test
    public void getAuditsTest() {

        AuditReport auditReport = auditService.queryAuditDocument(null);
        assertTrue(auditReport!=null);
       

    }

    private Audit getAuditObject() {

        Audit audit = new Audit();
       /* audit.setAuditId(1001L);*/
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

        JSONObject jsonObjectReq = new JSONObject();
        jsonObjectReq.put("empId", "7970");
        jsonObjectReq.put("empName", "Nagu");
        jsonObjectReq.put("age", 30);
        jsonObjectReq.put("salary", "12000");
        jsonObjectReq.put("designation", "Engineer");
        jsonObjectReq.put("manager", "Jhon");
        jsonObjectReq.put("location", "Pune");
        
        audit.setRequest(jsonObjectReq);
        
        JSONObject jsonObjectRsp = new JSONObject();
        jsonObjectRsp.put("statuscode","200");
        jsonObjectRsp.put("status","success");

        audit.setResponse(jsonObjectRsp);
        return audit;
    }

}
