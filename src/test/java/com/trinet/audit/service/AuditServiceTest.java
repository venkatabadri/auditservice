package com.trinet.audit.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.trinet.audit.TrinetAuditApplication;
import com.trinet.audit.dao.AuditDao;
import com.trinet.audit.entity.Audit;
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

    @Mock
    private AuditDao auditDaoMock;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void insertAuditDocumentTest() {

        AuditResponse auditResponse = auditService.insertAuditDocument(createAuditObject());
        assertTrue("200".equals(auditResponse.get_statusCode()));
        assertTrue(auditResponse.get_statusMessage().equals(ServiceConstants.MESSAGE_RESPONSE_SUCCESS));
    }

    @Test
    public void verifyAuditDocumentTest() {
        Audit audit = createAuditObject();
        audit.setCompanyId("");
        audit.setAuditId("987654321");
        AuditResponse auditResponse = auditService.insertAuditDocument(audit);
        assertTrue("400".equals(auditResponse.get_statusCode()));
        assertTrue(auditResponse.get_statusMessage().equals(ServiceConstants.AUDIT_FIELDVALIDATION_MSG));

    }

    @Test
    public void insertAuditToMongoDBFailTest() {
        Audit audit = createAuditObject();
        Mockito.when(auditDaoMock.insertAuditDocument(audit)).thenReturn(null);
        assertEquals(null, auditDaoMock.insertAuditDocument(audit));
    }

    private Audit createAuditObject() {

        Audit audit = new Audit();
        audit.setAuditId("");
        audit.setAuditTrailId("AT456");
        audit.setEmployeeId("123456");
        audit.setCompanyId("PSl1");
        audit.setProxyEmployeeId("1234");
        audit.setProxyCompanyId("PSLHYD");
        audit.setUserIP("localhost");
        audit.setBrowserInfo("ChromBrowser");
        audit.setOsInfo("Windows7");
        audit.setDeviceInfo("Samsung");
        audit.setEnvironment("Dev Environment");
        audit.setServerIP("localhost");
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
