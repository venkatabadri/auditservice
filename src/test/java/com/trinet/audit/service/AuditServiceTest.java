package com.trinet.audit.service;

import static org.junit.Assert.assertTrue;

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
        assertTrue("200".equals(auditResponse.get_statusCode()));
        assertTrue(auditResponse.get_statusMessage().equals(ServiceConstants.MESSAGE_RESPONSE_SUCCESS));

    }

    @Test
    public void verifyAuditDocumentTest() throws AuditException {
        Audit audit = createAuditObject();
        audit.setCompanyId("");
        AuditResponse auditResponse = auditService.insertAuditDocument(audit);
        assertTrue("422".equals(auditResponse.get_statusCode()));
        assertTrue(auditResponse.get_statusMessage().equals(ServiceConstants.AUDIT_FIELDVALIDATION_MSG));

    }

    private Audit createAuditObject() {

        Audit audit = new Audit();

        audit.setAuditTrailId("AT456");
        audit.setEmployeeId("123456");
        audit.setCompanyId("PSl1");
        audit.setProxyEmployeeId("1234");
        audit.setProxyCompanyId("PSLHYD");
        audit.setTimeStamp(System.currentTimeMillis());
        audit.setUserIP("127.0.0.1");
        audit.setBrowserInfo("ChromBrowser");
        audit.setOsInfo("Windows7");
        audit.setDeviceInfo("Samsung");
        audit.setEnvironment("Dev Environment");
        audit.setServerIP("127.0.0.1");
        audit.setApplication("Employee");
        audit.setFeature("Feature 1");
        audit.setResource("Resource Object");
        audit.setBizEvent("CREATE");
        audit.setMethod("PUT");
        audit.setStatusCode("200");
        audit.setErrorCode("0");
        audit.setRequest(
                "{ empId: 'PSL007',empName: 'Nagu',age: '30',salary: '12000',designation: 'Engineer',manager: 'Jhon',location: 'Hyderabad'}");
        audit.setResponse("{statuscode: '0',statusdescription: ' Record Inserted Successfully ',data: []}");

        return audit;
    }

}
